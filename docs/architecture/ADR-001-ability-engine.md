# ADR-001: Ability Engine & Input Execution Pipeline

**Status**: **ACCEPTED**  
**Deciders**: Orchestrator (Autonomous Systems Architect)  
**Date**: 2026-10-18  

---

## 1. Context & Problem Statement
In the Jujutsu Awakening (JJA) Bedrock addon, abilities are executed via dedicated hotbar items (e.g. `limitless1` through `limitless6`) because Bedrock lacks custom keybinding APIs. Using an item fires an `item_use` hook, running an `execute as @s` mcfunction that checks scoreboard scores (`Move`, `Cooldown`, `Camera`, `infinity`). This architecture is burdened by inventory slot clutter, tick delay desynchronization, and client-server prediction latency.

For Minecraft Java Edition on NeoForge 1.21.1, we must engineer a native, server-authoritative Ability Engine that supports instant keybind activation, radial technique selection, multi-key combo strings, charging/channeling states, and predictive client animation without sacrificing server authority.

---

## 2. Decision: State-Machine Ability Framework

### 2.1 Core Components
1. **`AbilityRegistry`**:
   - `DeferredRegister<Ability>` holding all registered abilities across all characters.
   - Each `Ability` is a singleton definition defining:
     - `ResourceLocation id`
     - `int ceCost`, `int activationTicks`, `int cooldownTicks`
     - `boolean requiresTarget`, `double maxRange`
     - `AbilityCategory` (Offensive, Defensive, Utility, Domain, Anti-Domain)
     - `ServerHandler` (`execute(ServerPlayer caster, AbilityContext ctx)`)
2. **`AbilityExecutionState` (Data Attachment on Player)**:
   - Tracks current ability phase: `IDLE`, `WINDUP`, `ACTIVE_CHANNEL`, `RECOVERY`, `BURNOUT`.
   - Tracks `ticksInState`, `currentAbilityId`, `targetEntityUUID`, `aimVector`.
3. **Client Input Pipeline**:
   - Input keypress (`KeyMapping`) -> checks local client prediction -> dispatches `ServerboundAbilityCastPayload(abilityId, inputType)`.
   - Client plays immediate sound cue and starts Player Animation Library layer.
4. **Server Validation Pipeline**:
   - Server receives packet:
     1. Validates caster is alive and not stunned.
     2. Validates technique is not sealed (Confiscation check).
     3. Validates Cursed Energy pool >= `ability.ceCost`.
     4. Validates `cooldownTracker.isReady(abilityId)`.
     5. Consumes CE, applies cooldown, and invokes `ability.onActivate(serverPlayer, ctx)`.
     6. Broadcasts `ClientboundAbilityStateSyncPayload` to tracking players.

---

## 3. Handling Combos & Charging (e.g. Hollow Purple, Divergent Fist)
- **Tap vs Hold Detection**:
  - `KEY_DOWN` sends `START_CHARGE` with timestamp.
  - Server enters `ACTIVE_CHANNEL` phase, applying slowness and rendering charging particle/shader effect.
  - `KEY_UP` sends `RELEASE_CHARGE` with elapsed ticks. Server calculates output multiplier (e.g. 100% vs 200% Maximum Output).
- **Combo Chains**:
  - Consecutive M1 or ability activations within a 12-tick buffer window increment a `comboStep` counter, executing sequential animation transitions (e.g. Todo's 4-hit martial arts or Yuji's Divergent Fist).

---

## 4. Consequences & Verification
- **Multiplayer Safety**: Prevents hacked client packets from spamming abilities or spoofing zero-cost casts.
- **Verification**: Tested via `AbilityEngineGametests#testCooldownEnforcedOnServer` and `AbilityEngineGametests#testInsufficientCECancelsCast`.
