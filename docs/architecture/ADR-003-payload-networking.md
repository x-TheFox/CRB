# ADR-003: Payload Networking Protocol & Network Architecture

**Status**: **ACCEPTED**  
**Deciders**: Orchestrator (Autonomous Systems Architect)  
**Date**: 2026-10-18  

---

## 1. Context & Problem Statement
Multiplayer safety (Law 0.5) is paramount. In a combat mod featuring teleportation (Boogie Woogie), continuous laser beams (Hollow Purple, Mugetsu), instant-death swords (Executioner's Sword), and world-altering barriers (Domain Expansions), netcode must be completely impervious to client packet forging, desync, and ghost hits.

---

## 2. Decision: Immutable Record Payloads with `PayloadRegistrar`

### 2.1 Packet Catalog

#### A. Client -> Server (Upstream Invocations)
1. `ServerboundAbilityCastPayload`:
   - `ResourceLocation abilityId`
   - `CastType type` (TAP, CHARGE_START, CHARGE_RELEASE, CANCEL)
   - `int targetEntityId` (-1 if none)
   - `Vec3 aimVector`
2. `ServerboundRadialSelectPayload`:
   - `int selectedSlotIndex`
3. `ServerboundCourtroomPleaPayload`:
   - `PleaType plea` (SILENCE, CONFESSION, DEFENSE)

#### B. Server -> Client (Downstream Authoritative State)
1. `ClientboundCursedEnergySyncPayload`:
   - `double currentCE`, `double maxCE`, `double regenRate`
2. `ClientboundCooldownSyncPayload`:
   - `ResourceLocation abilityId`, `int remainingTicks`, `int totalTicks`
3. `ClientboundCameraCuePayload`:
   - `CameraCueType cue` (SHAKE, IMPACT_FRAME, FOV_PULSE, DETACH_CINEMATIC)
   - `float intensity`, `int durationTicks`, `Vec3 targetCoords`
4. `ClientboundDomainManifestPayload`:
   - `UUID domainUUID`, `Vec3 center`, `double radius`, `DomainType type`, `UUID casterUUID`
5. `ClientboundDomainDissolvePayload`:
   - `UUID domainUUID`, `DissolveReason reason`

---

## 3. Security & Validation Rules
- **Anti-Cheat Validation**:
  - All coordinates sent from client are verified against server-side player bounding box (`player.position().distanceTo(aimPos) < MAX_RAYCAST_REACH`).
  - Cooldowns are tracked on the server: if an ability is requested while cooldown is active, the packet is silently dropped and logged.
  - Caster must possess active CE >= cost.
- **Thread Safety**:
  - Payload handlers immediately schedule execution on the main server thread via `context.enqueueWork(...)`. No off-thread world modifications.
