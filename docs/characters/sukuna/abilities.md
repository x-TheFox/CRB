# Ryomen Sukuna — Abilities & Kit Specification

## 1. Slashing Technique: Dismantle (解, Kai)
- **Canon ref**: Chapter 118, 246 / Episode 4, Season 2 Episode 17
- **JJA implementation**: `items/sukuna/sukuna1.json`, `functions/sukuna/attacks/dismantles/ab1.mcfunction` through `ab2e.mcfunction`. Spawns projectile `ds:dismantle` / `ds:dismantle_quick`.
- **Trigger (Java direction)**: Primary Slash Key (`L-Click` with CT active) / Modifier combos for Quick and Barrage variants.
- **Cost / Cooldown / Duration / Range / Area**:
  - Cost: 20 CE (Single) / 60 CE (Barrage).
  - Cooldown: 1.5s (Single) / 6s (Barrage).
  - Range: 35 blocks projectile travel.
- **Damage / Effect**:
  - Fires an invisible slicing wave that travels through air at 4.5 blocks/tick.
  - Deals 25 sharp slashing damage; cuts through organic material and cleaves solid stone.
  - Barrage variant fires a rapid fan of 5 slicing blades, shredding incoming projectiles and enemies.
- **Windup / Active / Recovery frames**: 3 ticks flick of wrist windup, 12 ticks flight, 4 ticks recovery.
- **VFX**: Barely visible translucent air-refraction crescent blade with blood-red and pitch-black trailing vapor lines (`particles/sukuna/dismantle_slash.json`).
- **SFX / Voice**: Sharp blade slice sound `mob.slash` followed by whipping air shock `mob.witch.throw`.
- **Camera direction (Java upgrade)**: Subtle forward directional camera lurch (0.1 blocks) in slash direction.
- **Multiplayer notes**: Fast server-side projectile raycast; clients render predicted trajectory; hit registers on server.
- **Tests**: `SukunaGametests#testDismantleProjectileHit`, `SukunaGametests#testDismantleBlockDamage`.

---

## 2. Slashing Technique: Cleave (捌, Hachi)
- **Canon ref**: Chapter 118, 214, 246 / Episode 12, Season 2 Episode 17
- **JJA implementation**: `items/sukuna/sukuna2.json`, `functions/sukuna/attacks/cleaves/cleave.mcfunction`, `spiderweb.mcfunction`, `layered_cleave.mcfunction`, `max_cleave_shockwave.mcfunction`.
- **Trigger (Java direction)**: Secondary Ability Key (`R`) / Hold `Sneak` for Spiderweb.
- **Cost / Cooldown / Duration / Range / Area**:
  - Cost: 50 CE (Contact) / 120 CE (Spiderweb).
  - Cooldown: 5s (Contact) / 14s (Spiderweb).
  - Range: Melee grab / contact (3 blocks); Spiderweb covers 12-block radius along ground.
- **Damage / Effect**:
  - Contact Cleave: Grabs target and analyzes their cursed energy / toughness, automatically adjusting slash potency to deal lethal scaling damage (50 base damage + 30% target's maximum HP).
  - Cleave: Spiderweb: Smashes hand into the earth, tracing a spiderweb lattice of cleaves across the ground, collapsing structures and severing the limbs of all grounded enemies (`damages/spiderweb_damage.mcfunction`).
  - Cleave Counter: Triggers Camera 4 cinematic when attacked, catching the opponent's strike and cleaving their torso point-blank.
- **Windup / Active / Recovery frames**: 5 ticks lunge windup, 4 ticks grab/contact, 12 ticks recovery.
- **VFX**: Violent criss-crossing dark red geometric slash grids appearing directly on the target's body or ground surface (`particles/sukuna/cleave_grid.json`).
- **SFX / Voice**: Deep metallic shearing noise `mob.slice`, flesh separation squelch, heavy impact bass drop.
- **Camera direction (Java upgrade)**: Point-blank impact zoom (15% FOV decrease for 6 ticks) on grab, radial blood splatter screen overlay.
- **Multiplayer notes**: Server validates player-target distance <= 3.5 blocks before executing contact Cleave; prevents desync grabs.
- **Tests**: `SukunaGametests#testCleaveToughnessScaling`, `SukunaGametests#testSpiderwebAreaCoverage`.

---

## 3. Thermochemical Manifestation: Open — Divine Flame / Fuga (「開」火坩)
- **Canon ref**: Chapter 119, 258 / Season 2 Episode 17
- **JJA implementation**: `items/sukuna/sukuna4.json`, `functions/sukuna/attacks/fuga/fuga_mugetsu.mcfunction`, `fuga_spear.mcfunction`, `scythe.mcfunction`. Scoreboard objective `fuga`.
- **Trigger (Java direction)**: Stance Activation Key (`X` while CT active) -> Tap Attack to Fire Flame Arrow.
- **Cost / Cooldown / Duration / Range / Area**:
  - Cost: 200 CE (Standard) / 350 CE (Post-Domain Thermobaric Blast).
  - Cooldown: 30s.
  - Duration: 60 ticks charge and draw.
  - Range: 80 blocks flight path; 20 block radius apocalyptic firestorm explosion.
- **Damage / Effect**:
  - Chants *"Fuga"* (Open), manifesting a colossal bow and arrow composed of hyper-compressed liquid flame.
  - Deals 150 direct fire damage, ignites targets for 100 ticks (`onfire 100`), inflicts 50 ticks of `Stun`, and incinerates all flammable blocks in 20 blocks.
  - When used immediately following Malevolent Shrine, the arrow ignites the airborne cursed dust particles created by millions of slashes, creating a catastrophic thermobaric explosion that vaporizes the entire domain radius!
- **Windup / Active / Recovery frames**: 40 ticks draw/charge, 2 ticks release, 20 ticks recovery.
- **VFX**: Blinding white-hot and deep orange flame corona swirling into an arrowhead, shockwave distortion cone, blinding mushroom explosion (`particles/sukuna/fuga_arrow.json`).
- **SFX / Voice**: Iconic Japanese voice line: *"■... 'Fuga'."* Deep fire whoosh `mob.blaze.shoot` followed by thunderous nuclear blast `random.explode`.
- **Camera direction (Java upgrade)**: Camera locks to high-angle side view during bow draw; upon release, a sustained 1.5s heavy camera rumble with white thermal flash.
- **Multiplayer notes**: Explosion radius damage and block burning managed on server thread; chunk lighting synchronized.
- **Tests**: `SukunaGametests#testFugaArrowExplosion`, `SukunaGametests#testFugaThermobaricSynergy`.

---

## 4. The Slash That Bisects the World: World Cutting Slash (世界を断つ斬撃)
- **Canon ref**: Chapter 236, 238, 251
- **JJA implementation**: `functions/sukuna/attacks/worldslash/chant.mcfunction`, `wcs1.mcfunction`, `world_slash1.mcfunction`, `world_slash2.mcfunction`, `wcs_damage.mcfunction`.
- **Trigger (Java direction)**: Complete 3-phase Chant Sequence while in Heian Form or aiming hand sign.
- **Cost / Cooldown / Duration / Range / Area**:
  - Cost: 300 CE.
  - Cooldown: 60s.
  - Range: Extends to the edge of the world / 150 blocks along direct vector.
- **Damage / Effect**:
  - Expands the target of the technique from living entities to **space, existence, and the world itself**.
  - Bypasses ALL defensive barriers unconditionally, including Satoru Gojo's Neutral Infinity!
  - Deals 999 true bisection damage (instant lethal bisection to any entity in the plane of the slash).
  - Cuts a clean physical line through all blocks in its geometric plane.
- **Windup / Active / Recovery frames**: Requires 3 specific vocal chants ("Scale of the Dragon", "Recoil", "Twin Meteors") + directional hand sign (60 ticks total windup).
- **VFX**: Space itself visibly shatters along a paper-thin pitch-black geometric rift line (`particles/sukuna/world_slash_rift.json`) followed by negative-color shockwave bloom.
- **SFX / Voice**: Voice line: *"Ryūrin, Hanpatsu, Tsugai no Suisei."* Reality-shattering glass fracture audio crack.
- **Camera direction (Java upgrade)**: World-freeze beat (all movement pauses for 3 ticks), extreme monochrome impact frame, diagonal screen split effect across user's viewport.
- **Multiplayer notes**: Server validates chant completion and hand-sign alignment before executing spatial cut; instant server kill event.
- **Tests**: `SukunaGametests#testWorldCuttingSlashBypassesInfinity`, `SukunaGametests#testWorldSlashLethalDamage`.

---

## 5. Domain Expansion: Malevolent Shrine (伏魔御厨子)
- **Canon ref**: Chapter 118–119, 225–230 / Episode 4, Season 2 Episode 17
- **JJA implementation**: `items/sukuna/sukuna3.json`, `functions/sukuna/attacks/dismantles/malevolentshrine.mcfunction`, `functions/sukuna/shrine_tick.mcfunction`. Radius: `r=200` blocks!
- **Trigger (Java direction)**: Domain Key Combo (Hold `Sneak` + Press `G`).
- **Cost / Cooldown / Duration / Range / Area**:
  - Cost: 400 CE.
  - Cooldown: 180s.
  - Duration: 40s.
  - Range: **200 blocks radius** (Open-Barrier Domain!).
- **Damage / Effect**:
  - Does NOT construct an enclosed barrier. Manifests a Buddhist shrine adorned with horned skulls in the center of the battlefield.
  - By entering a binding vow to leave an escape route open, the sure-hit area expands to a staggering 200 blocks in radius.
  - Continuous Sure-Hit: Cleave mercilessly strikes all entities with cursed energy, while Dismantle shreds all inanimate objects and buildings continuously until the entire 200-block zone is reduced to fine dust.
- **Windup / Active / Recovery frames**: 25 ticks Enma hand-sign formation (palms touching with ring fingers hooked).
- **VFX**: Colossal decaying demonic shrine structure spawns in center; millions of criss-crossing red/black slashes fill the air; blood-red skybox tint (`particles/sukuna/shrine_slashes.json`).
- **SFX / Voice**: Voice line: *"Ryōiki Tenkai: Fukuma Mizushi."* Ominous shrine bells, continuous buzzing drone of thousands of slicing blades.
- **Camera direction (Java upgrade)**: Ground trembles violently; camera pulls back to a breathtaking wide shot revealing the looming shrine and the apocalyptic sphere of destruction.
- **Multiplayer notes**: Open barrier allows other players to physically enter and exit; players crossing the 200m boundary immediately enter the relentless slicing field.
- **Tests**: `SukunaGametests#testMalevolentShrineOpenBarrierRadius`, `SukunaGametests#testShrineContinuousSlicing`.

---

## 6. Transformations: True Heian Form & Meguna Takeover
- **Heian Transformation** (`ds:heian_transformation`): Reincarnates into Sukuna's four-armed, two-mouthed true body. Unlocks `ds:four_fists` (Double Impact, Demonic Leap, Obliterate, Overwhelming Power) and permits uninterrupted chanting while sprinting and fighting.
- **Meguna Takeover** (`functions/sukuna/meguna_cutscene.mcfunction`): Subjugates Megumi Fushiguro's soul, enabling simultaneous access to Ten Shadows shikigami (including Mahoraga) alongside Shrine.
