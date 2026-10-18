# Reconnaissance Report 01: Architecture of the JJA Addon

## 1. Architectural Overview & Runtime Topology
The Jujutsu Awakening (JJA) Bedrock addon operates entirely within Bedrock Edition's constrained data-driven runtime, utilizing a hybrid architecture of:
1. **Command Function Tick Engine** (`tick.json` → `functions/*.mcfunction`) executing 20 times per second.
2. **Scoreboard Virtual Memory Bus** managing player state, cursed energy, ability cooldowns, damage calculations, and combat frames.
3. **Bedrock Scripting Engine** (`scripts/index.js`, `scripts/domain_clashing.js` via `@minecraft/server`) handling projectile physics, geometric volume manipulation (circles/spheres), script events, and UI dialogs.
4. **Custom Font / Glyph Rendering Engine** repurposing Unicode Private Use Area glyphs (`\ue000`–`\uf8ff`) in the actionbar and title channels to render custom full-screen animations, HUD meters, and character portraits without Java UI access.

---

## 2. Input & Ability Trigger Pipeline

### 2.1 The Dedicated Hotbar Item Workaround
Because Minecraft Bedrock Edition offers no native keybind registry or custom input event channels for addons, JJA forces player input through dedicated items placed in hotbar slots:
- **Technique Selector Items**: e.g., `ds:limitless_technique` (`items/limitless/limitlesstech.json`)
- **Ability Slot Items**: e.g., `ds:limitless1` through `ds:limitless6` (`items/limitless/limitless1.json`...)
- **Combat Style Items**: e.g., `ds:basic_combat`, `ds:sukuna_fists`, `ds:limitless_fists`

### 2.2 Input State Combination Matrix
To squeeze maximum depth out of single item clicks, JJA monitors physical player inputs via scoreboard objectives updated every tick (`_scores.mcfunction` L202–L212, `detect_sneak2.mcfunction`):
- `detect_sneak` / `Sneaking`: Sneak state detection
- `detect_doublesneak`: Rapid sneak tapping
- `detect_jump`: Jump state detection
- `detect_sprint`: Sprinting state
- `detect_left`: Mouse turn / look direction angle shift
- `punch`: Left-click / attack detection
- `itemUse:<identifier>`: Right-click item usage via Bedrock beforeEvents

**Example from `items/limitless/limitless1.json`**:
- **Right-Click**: Neutral Infinity toggle (`ds:limitless1`)
- **Sneak + Right-Click**: Infinity Aura Burst
- **Jump + Right-Click**: Infinity Dash (`infinity_dash.mcfunction`)
- **Jump + Sneak + Right-Click**: Spatial Compression Stride

### 2.3 Script Event Bridge
When command functions require dynamic trigonometry or projectile velocity calculations beyond mcfunction capabilities, JJA fires a script event:
```mcfunction
# functions/sukuna/dismantle.mcfunction
scriptevent ds:dismantle
```
Handled in `scripts/index.js` (L60–L86):
```javascript
system.afterEvents.scriptEventReceive.subscribe((event) => {
  if (event.id === "ds:dismantle") {
    const playerView = player.getViewDirection();
    const projectile = player.dimension.spawnEntity('ds:dismantle', spawnPos);
    projectile.getComponent('minecraft:projectile').shoot({
      x: playerView.x * 4.5, y: playerView.y * 4.5, z: playerView.z * 4.5
    });
  }
});
```

---

## 3. State Management: The Scoreboard Memory Bus

The central state machine is initialized in `functions/add_scores.mcfunction` (605 lines) and updated in `functions/_scores.mcfunction` (417 lines). Every player and entity maintains scores in the following architectural groups:

### 3.1 Cursed Energy & Combat Economics
- `Energy`: Current Cursed Energy (CE). Depleted upon ability activation.
- `EnergyCap`: Maximum CE pool (starts at 100, expandable up to 1000+ via stat investment).
- `ceregen`: CE passive recovery rate (ticks per energy point).
- `rctuses`: Number of Reverse Cursed Technique heal charges remaining (default: 3).
- `rct` / `rctheal`: Active RCT regeneration state flags.

### 3.2 Combat & Animation State Tracking
- `Stun`: Ticks remaining where the entity cannot move, attack, or activate abilities (`functions/_scores.mcfunction` L13: `scoreboard players remove @e[scores={Stun=1..}] Stun 1`).
- `Hit`: Hit reaction animation phase.
- `Blocking` / `Posture`: Guard meter; filling posture breaks player guard into Stun.
- `Flourish`: Combo finisher counter.
- `Dash` / `DashCD`: Dash activation and recovery cooldown.
- `Evade` / `Evasive`: Invulnerability dodge frames.
- `thezone` / `blackflash_amount`: Flow state ("The Zone") entered upon successful Black Flash.

### 3.3 Ability Routing State
- `ability1` through `ability12`: Cooldown timers for individual technique skills.
- `wep1` through `wep6v2`: Cursed tool skill cooldowns.
- `Mode`: Stance or transformation stage (e.g., Sukuna 4-arms, Mahito Instant Spirit Body, Kashimo Amber Beast).
- `Deleter`: Lifetime countdown in ticks for temporary VFX entities, barriers, and hitboxes.

---

## 4. Ability Execution Pattern

Every JJA ability follows an identical 6-phase pipeline:
```
[Player Input (Item / Combo)]
             ↓
[1. Tag Routing]: _scores.mcfunction routes tag=itemUse:<id> to ability mcfunction
             ↓
[2. State Verification]: Check Stun == 0, Disabled == 0, Cooldown == 0, Energy >= Cost
             ↓
[3. Resource Deduction & Cooldown Set]: Deduct Energy, set abilityCD = duration, add combat tag
             ↓
[4. Animation & Stance Dispatch]: Set Frames score, trigger animation controller on player
             ↓
[5. Hitbox / Area Spawn & Damage]: Summon invisible area marker (e.g., ds:massive_knockback),
                                   execute damage calculation, apply Stun / knockback
             ↓
[6. VFX / SFX Dispatch & Cleanup]: Particle emitter summoned at ~ ~ ~, playsound fired,
                                   Deleter timer set to clean up temporary entities
```

**Evidence citation (`functions/limitless/blue.mcfunction`)**:
1. Verifies: `execute if score @s Energy >= fifty endurance if score @s ability2 = zero endurance`
2. Sets cooldown: `scoreboard players set @s ability2 140`
3. Deducts CE: `scoreboard players remove @s Energy 50`
4. Plays sound: `playsound limitless.blue_charge @s ~~~ 1 1`
5. Spawns entity: `summon ds:familiar_entity ~ ~1.5 ~` with tag `blue_vacuum`
6. Applies suction: `teleport @e[r=15,type=!player] ^ ^ ^0.8`

---

## 5. Domain Expansion Engine & Clash Dynamics

### 5.1 Barrier Construction & Geometry
Domains are spawned via dedicated functions (e.g., `functions/domain_barrier.mcfunction`, `structures/structures/malevolentshrine.mcstructure`):
- **Closed Domains**: Summon a 66-block radius hollow spherical barrier (`ds:domain_barrier`, `ds:domain_barrier_inside`, `blocks/blocks/domain_barrier.json`).
- **Open Domains (Malevolent Shrine)**: No physical barrier. Operates over an unprecedented 200-block radius (`_scores.mcfunction` L18, L20: `r=200`).
- **Ticking Areas**: Domain areas are protected from engine despawning via `tickingarea add` (`deadlysentencing`, `malevolentshrine`, `IronMountain`, `shadowgarden`).

### 5.2 Sure-Hit Implementation
Sure-hit in JJA is implemented by continuous tick loops selecting all entities inside the domain radius that lack the `domain_immune` or `simpledomain_protecting` tag:
```mcfunction
# functions/sukuna/malevolent_shrine_tick.mcfunction
execute as @e[r=200,tag=!domain_owner,tag=!simpledomain_protecting] at @s run function functions/damages/cleave_tick
```

### 5.3 Domain Clash Resolution System (`scripts/domain_clashing.js`)
When two or more players expand domains in overlapping areas:
1. Both receive the `tag domainclashing` and objective `domain_clasher`.
2. `domain_clashing.js` detects nearby clashers within a 50-block radius (`hasNearbyClasher`, L36–L54).
3. Clashing players engage in combat; damage dealt to a clasher deducts their `domain_clasher` score.
4. If a player's clash score drops to 0 or their health falls below threshold:
   - Loser's barrier shatters via `domainloser.mcfunction` (`playsound domain.break`, particle `ds:domain_shatter`).
   - Loser suffers Cursed Technique Burnout (`tag @s add cantdomain`, `scoreboard players set @s Disabled 600`).
   - Winner's domain expands to full dominance with sure-hit activated.

### 5.4 Anti-Domain Counters
- **Simple Domain**: `functions/simple_domain.mcfunction` spawns `ds:simple_domain` entity at feet, granting `tag @s add simpledomain_protecting` for 10–20 seconds.
- **Domain Amplification**: `functions/particles/domainamplification.mcfunction` nullifies enemy sure-hit and bypasses Infinity at the cost of being unable to use one's own CT.
- **Falling Blossom Emotion** & **Hollow Wicker Basket**: Implemented as damage-reduction and sure-hit deflection tags (`fallingblossomown`, `hollowbasketown`).

---

## 6. Cinematics & Camera Techniques

Bedrock addons lack camera entity attachments, so JJA uses a combination of `/camera` commands and title fonts:
1. **Camera Transitions**:
   - `/camera @s fade time 0.1 0.3 0.2 color 0 0 0`: Impact frame blackout.
   - `/camera @s set minecraft:free pos ~ ~3 ~-4 facing ~ ~1 ~`: Third-person cinematic cutscene angles during Domain Expansion startup.
2. **Impact Frames**:
   - Rapid sequential title commands (`title @s title `, ``, ``) displaying high-contrast inverted black/white character silhouettes on screen for 1–2 ticks during Black Flash or lethal strikes.
3. **Screen Shake**:
   - Implemented by teleporting the player micro-fractions of a block back and forth (`tp @s ~0.05 ~-0.05 ~0.02`) on consecutive frames.

---

## 7. Progression, Stat Economy & Gacha Loop

### 7.1 Character Creation & Gacha Roll Architecture
On initial join (`joined.mcfunction`, `functions/_menu.mcfunction`):
- Player is immobilized via `inputpermission set @s movement disabled` and camera locked facing down.
- **Step 1: Race Selection**: Human / Sorcerer (`tag human`) vs Cursed Spirit (`tag curse`).
- **Step 2: Clan Rolling**: `menuclans` randomly rolls from Gojo (3%), Zenin (6%), Kamo (7%), Inumaki (11%), or Clanless (73%).
- **Step 3: Trait Rolling**: Rolls 1–2 traits (e.g., Six Eyes, Boundless Energy, Heavenly Restriction, 120% Potential).
- **Step 4: Technique Rolling**: Rolls Cursed Technique categorized by rarity tiers (Common, Uncommon, Rare, Exotic, Honored/Dishonored).

### 7.2 Stat Economy
Every level up grants `invest` points:
- `strength`: Increases melee punch damage.
- `agility`: Increases movement speed, dash distance, water-run duration.
- `endurance`: Increases maximum health pool and damage reduction.
- `energystat`: Increases maximum Cursed Energy cap and regen rate.

---

## 8. Summary of Bedrock Workarounds vs. Java-Native Evolution
| Subsystem | JJA Bedrock Workaround | CRB Java-Native Evolution (NeoForge 1.21.1) |
|-----------|------------------------|---------------------------------------------|
| **Input** | Dedicated hotbar items + click/sneak/jump detection | Radial ability wheel (GUI) + customizable direct keybind combos |
| **HUD** | Actionbar text spam + custom unicode font glyphs | Native HUD overlay (Veil / custom OpenGL render layer) with animated CE bar |
| **Cinematics** | `/camera fade` + micro-teleport shake | Dedicated Camera Director timeline (Free Camera API / ViewportEvent) with smooth interpolation, FOV ramps, screen shake |
| **Impact Frames** | Unicode glyphs in `title` command | Custom post-processing shader pipeline (Veil / PostChain) |
| **Domains** | Scoreboard distance checks + static `.mcstructure` clones | Dynamic geometric barrier generator, procedural interior dimension / arena instance, server-authoritative sure-hit event bus |
| **Netcode** | Client-trusted Bedrock command evaluation | Server-authoritative `CustomPacketPayload` validation; zero client-trusted damage |
