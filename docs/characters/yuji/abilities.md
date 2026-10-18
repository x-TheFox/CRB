# Yuji Itadori — Abilities & Kit Specification

## 1. Core Martial Art: Divergent Fist (逕庭拳, Keiteiken)
- **Canon ref**: Chapter 19–21, 64 / Episode 9, 13
- **JJA implementation**: `items/particles/divergentfists.json`, `functions/_scores.mcfunction` L173 (`divfist`), `functions/yuji/base_cmds.mcfunction`.
- **Trigger (Java direction)**: Toggle / Passive Modifier on Basic M1 punches.
- **Cost / Cooldown / Duration / Range / Area**:
  - Cost: 10 CE per punch.
  - Cooldown: 0s (passive modifier).
  - Range: Melee (2.5 blocks).
- **Damage / Effect**:
  - Two-phase impact: First deals initial physical blunt damage (15 HP), then 4 ticks later a secondary shockwave of cursed energy hits the exact same location, dealing secondary heavy damage (20 HP) and interrupting enemy counter-attacks.
- **Windup / Active / Recovery frames**: 3 ticks punch, 4 ticks lag, 2 ticks recovery.
- **VFX**: Blue or orange cursed energy trailing behind the punch, followed by a delayed explosive burst of cursed energy sparks at the contact point (`particles/yuji/divergent_burst.json`).
- **SFX / Voice**: Initial punch thud `mob.player.hurt`, followed 0.2s later by heavy bass detonation `random.explode` with pitch 1.8.
- **Camera direction (Java upgrade)**: Micro-double hitch on screen shake (two distinct rumble beats matching the two impacts).
- **Multiplayer notes**: Server records strike location on tick 0; schedules secondary damage event on tick 4; target cannot block secondary strike if initial strike broke posture.
- **Tests**: `YujiGametests#testDivergentFistDoubleImpact`, `YujiGametests#testDivergentFistGuardBreak`.

---

## 2. Pinnacle Phenomenon: Consecutive Black Flash (黒閃, Kokusen)
- **Canon ref**: Chapters 48–50, 120–132, 256–257 / Episode 19, Season 2 Episode 19–20
- **JJA implementation**: `functions/end_blackflash.mcfunction`, `functions/_scores.mcfunction` L68–L72 (`blackflash_amount`, `blackflashing`, `thezone`).
- **Trigger (Java direction)**: Timing-based critical hit (pressing Attack within a 3-frame window of CE impact) or guaranteed during "The Zone".
- **Cost / Cooldown / Duration / Range / Area**:
  - Cost: 40 CE.
  - Cooldown: 0s (combo-chainable up to 8 times!).
  - Range: Melee.
- **Damage / Effect**:
  - Spatial distortion when cursed energy flashes black within 0.000001 seconds of physical impact.
  - Applies damage to the power of 2.5: deals catastrophic scaling damage (80 to 180+ HP on consecutive chains).
  - Triggers **"The Zone"** (`thezone = 1`): Grants 120% potential output, increases movement speed by 30%, reduces CE costs, and makes subsequent Black Flashes substantially easier to execute.
- **Windup / Active / Recovery frames**: 4 ticks punch windup, 2 ticks impact freeze, 6 ticks recovery.
- **VFX**: Violent jagged crimson and pitch-black spatial lightning bolts tearing through the air and surrounding the target's body (`particles/yuji/black_flash_lightning.json`).
- **SFX / Voice**: Deafening acoustic silence (1 tick) followed by an apocalyptic bass crack and singing energy fracture `mob.blackflash.impact`.
- **Camera direction (Java upgrade)**: 2 ticks of pure high-contrast monochrome impact frame flash; dynamic FOV punch; violent camera shake along the vector of the punch.
- **Multiplayer notes**: Server verifies timing window; broadcasts black flash event to all players in 60 blocks; renders dramatic particle shockwave.
- **Tests**: `YujiGametests#testBlackFlashDamageExponent`, `YujiGametests#testConsecutiveBlackFlashZoneEntry`.

---

## 3. Innate Technique: Soul Dismantle (魂の解)
- **Canon ref**: Chapters 250–252, 257–266
- **JJA implementation**: `items/yuji/soul_shrine1.json`, `functions/yuji/soul_ab1.mcfunction` through `soul_ab5.mcfunction`, `dismantle_small.mcfunction`.
- **Trigger (Java direction)**: Secondary Ability Key (`R` with Soul Shrine active).
- **Cost / Cooldown / Duration / Range / Area**:
  - Cost: 60 CE.
  - Cooldown: 6s.
  - Range: Melee grab / short raycast (6 blocks).
- **Damage / Effect**:
  - Applies Dismantle specifically to the **boundary between souls**.
  - Bypasses physical armor and standard durability.
  - Against reincarnated sorcerers (such as Sukuna): deals massive soul stability damage, lowering their synchronization rate, reducing their maximum cursed energy, and directly peeling the foreign soul away from the host body!
  - Against standard entities: deals unhealable soul damage that cannot be restored by ordinary RCT without soul awareness.
- **Windup / Active / Recovery frames**: 4 ticks lunge, 8 ticks soul carve, 8 ticks recovery.
- **VFX**: Translucent azure and crimson soul scissor silhouettes cutting across the target's torso (`particles/yuji/soul_dismantle.json`).
- **SFX / Voice**: Resonant soul-bell chime accompanied by sharp scissor shearing sound.
- **Camera direction (Java upgrade)**: Target's screen flashes translucent blue; subtle camera shake.
- **Multiplayer notes**: Deducts target's vessel synchronization capability data directly on server.
- **Tests**: `YujiGametests#testSoulDismantleReducesVesselSync`.

---

## 4. Acquired Technique: Blood Manipulation (赤血操術)
- **Canon ref**: Chapters 251, 256, 257
- **JJA implementation**: Stub present in `items/yuji/blood_manipulation.json` (`[ NOT RELEASED / MADE ]`); fully implemented in CRB per §5.4.
- **Trigger (Java direction)**: Blood Stance Key (`Z`).
- **Cost / Cooldown / Duration / Range / Area**:
  - Cost: 50–120 CE (uses Yuji's own blood; healed by CE conversion via Death Painting physiology).
  - Cooldown: 4s–14s.
  - Range: Up to 40 blocks.
- **Sub-Abilities**:
  1. **Piercing Blood (穿血, Senketsu)**: Compresses blood between palms to maximum density and fires a supersonic beam of pressurized blood like a bullet. (45 damage, 40 blocks range).
  2. **Supernova (超新星, Chōshinsei)**: Releases compressed blood orbs in all directions that detonate simultaneously like a fragmentation grenade.
  3. **Blood Reattachment**: Uses blood coagulation to instantly reattach severed limbs during combat.
- **VFX**: Dense crimson blood particles pressurized between hands, leaving high-velocity blood vapor trails (`particles/yuji/piercing_blood.json`).
- **SFX / Voice**: High-pressure hydraulic hiss followed by supersonic gunshot sonic crack.
- **Tests**: `YujiGametests#testPiercingBloodVelocity`, `YujiGametests#testSupernovaAoE`.

---

## 5. Domain Expansion: Shrine of Reverie (虎杖悠仁の領域)
- **Canon ref**: Chapters 264–268 (Climax of the Shinjuku Showdown)
- **JJA implementation**: `items/yuji/soul_shrine1 - Copy.json` (`ds:soul_shrine2`), `functions/yuji/memories_shrine.mcfunction`, `functions/yuji/domain_blackflash.mcfunction`.
- **Trigger (Java direction)**: Domain Key Combo (Hold `Sneak` + Press `G`).
- **Cost / Cooldown / Duration / Range / Area**:
  - Cost: 350 CE.
  - Cooldown: 180s.
  - Duration: 35s.
  - Range: 66-block enclosed domain barrier.
- **Damage / Effect**:
  - Manifests Yuji's innate domain: a nostalgic rural Japanese train platform and Sendai townscape enveloped in snowy twilight.
  - In this domain, Yuji establishes peaceful dialogue before battle. Once combat resumes:
  - **Sure-Hit: Boundless Soul Dismantle**: Every punch landed by Yuji inside the domain strikes the core of the soul with sure-hit accuracy, preventing any evasion.
  - Guarantees Black Flash on the 4th consecutive combo hit!
- **Windup / Active / Recovery frames**: 20 ticks clasping hands in prayer sign.
- **VFX**: Train station platform structure, gently falling snow, warm incandescent station lights, surrounded by a rustic dusk horizon.
- **SFX / Voice**: Soft train station announcement chime, distant train engine thrum, gentle wind whistling.
- **Camera direction (Java upgrade)**: Melancholic cinematic pan across the train station platform and railroad tracks before locking onto the opponent.
- **Multiplayer notes**: All occupants are teleported into the station domain; server enforces soul dismantle sure-hit on all attacks.
- **Tests**: `YujiGametests#testYujiDomainStationGeneration`, `YujiGametests#testYujiSureHitSoulStrikes`.
