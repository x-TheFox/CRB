# Satoru Gojo — Abilities & Kit Specification

## 1. Neutral Limitless: Infinity (無下限)
- **Canon ref**: Chapter 14, 75–76 / Episode 7, 27
- **JJA implementation**: `items/limitless/limitless1.json`, `functions/limitless/infinity.mcfunction`, `infinity_dash.mcfunction`. Scoreboard objective `infinity`.
- **Trigger (Java direction)**: Toggle Key (`V`) or Radial Wheel slot 1.
- **Cost / Cooldown / Duration / Range**:
  - Cost: 50 Cursed Energy activation, 1 CE per tick upkeep (reduced to 0 with Six Eyes).
  - Cooldown: 0s (toggle); 6s if broken by Domain Amplification / Inverted Spear.
  - Duration: Persistent until deactivated or broken.
  - Range: 1.5 block spherical aura around player.
- **Damage / Effect**:
  - 100% projectile deflection: all incoming projectiles (arrows, tridents, fireballs, dismantles) decelerate asymptotically and stop 0.5 blocks away.
  - Melee defense: incoming melee attacks without Domain Amplification or cursed tool bypass fail to inflict damage and cause attacker recoil.
- **Windup / Active / Recovery frames**: Instant activation (1 tick).
- **VFX**: Faint refractive spatial distortion sphere around Gojo (`particles/gojo/infinity_shield.json`), subtle blue hex-shimmer on impact.
- **SFX / Voice**: `mob.infinity.activate` on start, `beacon.ambient` hum during active state, `mob.infinity.deflect` on hit.
- **Camera direction (Java upgrade)**: Micro FOV push (2 degrees) on activation; shockwave distortion pulse on heavy deflected impacts.
- **Multiplayer notes**: Server-authoritative hit check: if attacker lacks `DomainAmplification` or `NullifyCT` tag, damage event is canceled on server.
- **Tests**: `GojoGametests#testInfinityBlocksArrow`, `GojoGametests#testInfinityBrokenByDomainAmplification`.

---

## 2. Cursed Technique Lapse: Blue (術式順転「蒼」)
- **Canon ref**: Chapter 69, 71 / Episode 27
- **JJA implementation**: `items/limitless/limitless2.json`, `functions/limitless/bluecore.mcfunction`, `maxblue.mcfunction`, `phaseblue.mcfunction`.
- **Trigger (Java direction)**: Primary Ability Key (`R`) / Hold for Maximum Output.
- **Cost / Cooldown / Duration / Range / Area**:
  - Cost: 75 CE (Tap) / 180 CE (Maximum Output).
  - Cooldown: 8s (Tap) / 16s (Max).
  - Duration: 3s singularity duration.
  - Range: 30 blocks cast range; 12 block suction vortex radius.
- **Damage / Effect**:
  - Creates a negative space singularity that pulls all surrounding entities and blocks toward its center (`functions/damages/pull_damage.mcfunction`).
  - Deals continuous crushing damage (12 HP/sec) to trapped entities; collapses in a high-density implosion dealing 35 burst damage.
- **Windup / Active / Recovery frames**: 8 ticks windup (orb manifests at fingertip), 60 ticks active vortex, 10 ticks recovery.
- **VFX**: Vibrant cobalt blue gravitational orb surrounded by clockwise spinning atmospheric distortions and suction lines (`particles/limitless/blue_orb.json`).
- **SFX / Voice**: Voice line: *"Jutsushiki Junten: Ao."* Audio cue: `mob.blue.charge` followed by low-frequency gravity thrum `mob.blue.vortex`.
- **Camera direction (Java upgrade)**: Radial blur toward the Blue orb epicenter; subtle screen pull toward the vortex.
- **Multiplayer notes**: Physics pull calculated server-side; coordinates synced via payload so clients render smooth trajectory interpolation.
- **Tests**: `GojoGametests#testBlueSuctionRange`, `GojoGametests#testBlueDamageTick`.

---

## 3. Cursed Technique Reversal: Red (術式反転「赫」)
- **Canon ref**: Chapter 71, 75 / Episode 27
- **JJA implementation**: `items/limitless/limitless3.json`, `functions/limitless/reversal.mcfunction`, `pointblank.mcfunction`, `red_beam.mcfunction`.
- **Trigger (Java direction)**: Secondary Ability Key (`F`) / Sneak modifier for Point-Blank variant.
- **Cost / Cooldown / Duration / Range / Area**:
  - Cost: 120 CE (requires positive energy conversion).
  - Cooldown: 12s.
  - Duration: Instantaneous projectile strike.
  - Range: 45 blocks raycast / projectile path; 6 block explosion radius.
- **Damage / Effect**:
  - Manifests repulsive divergence: fires a concentrated crimson bead that explodes on contact with violent repulsive force (`damages/explosion_damage.mcfunction`).
  - Deals 60 explosive damage; knocks targets back 20+ blocks; destroys non-reinforced blocks in trajectory.
- **Windup / Active / Recovery frames**: 12 ticks charge at fingertip, 1 tick beam release, 14 ticks recoil recovery.
- **VFX**: Intense scarlet red energy bead emitting repulsive shockwave rings, leaving a blazing crimson trail beam (`particles/limitless/red_beam.json`).
- **SFX / Voice**: Voice line: *"Jutsushiki Hanten: Aka."* Audio cue: `mob.red.charge` high-pitch whine, followed by violent sonic detonation `random.explode`.
- **Camera direction (Java upgrade)**: Rapid camera punch-in on release with directional recoil kickback (pitch up 3 degrees).
- **Multiplayer notes**: Server-authoritative raycast calculation; verifies obstacle collision before triggering explosive blast.
- **Tests**: `GojoGametests#testRedKnockbackMagnitude`, `GojoGametests#testRedExplosionDamage`.

---

## 4. Secret Art: Hollow Purple (虚式「茈」)
- **Canon ref**: Chapter 75, 223 / Episode 20, Season 2 Episode 20
- **JJA implementation**: `items/limitless/limitless5.json`, `functions/limitless/hollow_purple.mcfunction`, `200hollow_purple.mcfunction`, `hollow_nuked.mcfunction`.
- **Trigger (Java direction)**: Ultimate Ability Key (`G`) / Hold with Chants for 200% Output.
- **Cost / Cooldown / Duration / Range / Area**:
  - Cost: 250 CE (Standard) / 450 CE (200% Output).
  - Cooldown: 45s (Standard) / 90s (200%).
  - Duration: 5s projectile travel time.
  - Range: 120 blocks forward trajectory; 8 block cylindrical erasure radius (16 blocks for 200%).
- **Damage / Effect**:
  - Combines Blue (convergence) and Red (divergence) into an imaginary mass that pushes itself forward, erasing matter in its path (`damages/deletion_damage.mcfunction`).
  - Deals 250 true erasure damage (bypasses standard armor and resistances); disintegrates all blocks in its tunnel.
- **Windup / Active / Recovery frames**:
  - Standard: 30 ticks charge (Blue and Red orbs fuse in front of chest).
  - 200%: 90 ticks complete chant sequence ("Nine Ropes, Polarized Light, Crow and Shomyo, The Gap Between Within and Without").
- **VFX**: Blue and Red orbs intertwine and collapse into an ominous deep violet sphere encircled by singing gravitational arcs and matter-disintegration sparks (`particles/limitless/purple_singularity.json`).
- **SFX / Voice**: Voice chant audio: *"Kyoshiki: Murasaki."* Full chant audio cue for 200%. Seismic bass drop `mob.purple.release` shaking the environment.
- **Camera direction (Java upgrade)**: Dramatic camera pivot to 45-degree over-shoulder shot during fusion, high-contrast monochrome impact frame flash at the instant of release, heavy sustained screen rumble along beam flight path.
- **Multiplayer notes**: Mass erasure path calculated block-by-block on server; destruction synchronized to client chunk renderers.
- **Tests**: `GojoGametests#testHollowPurpleErasure`, `GojoGametests#test200PercentPurpleChantBoost`.

---

## 5. Domain Expansion: Unlimited Void (無量空処)
- **Canon ref**: Chapter 15, 224–230 / Episode 7, Season 2 Episode 9
- **JJA implementation**: `items/limitless/limitless6.json`, `functions/limitless/gojo_domain.mcfunction`, `gojo_domain_quick.mcfunction`, `unlimited_void.mcfunction`.
- **Trigger (Java direction)**: Domain Key Combo (Hold `Sneak` + Press `G`).
- **Cost / Cooldown / Duration / Range / Area**:
  - Cost: 400 CE.
  - Cooldown: 180s.
  - Duration: 30s standard; 0.2s quick domain mode available.
  - Range: 66 block radius spherical domain barrier.
- **Damage / Effect**:
  - Manifests the inner universe of the Limitless: inundates targets with infinite information per second.
  - Sure-hit: All non-allied entities inside the barrier suffer absolute sensory and cognitive overload (`Stun` 600 ticks, cannot act, move, or perceive; continuous mental erosion damage).
- **Windup / Active / Recovery frames**: 20 ticks hand-sign startup (clasping right hand with middle finger over index), 15 ticks barrier expansion bloom.
- **VFX**: Inky black void interior surrounded by an iris of infinite cosmic light, planetary nebulae, and neural network filament threads (`particles/limitless/unlimited_void_sky.json`).
- **SFX / Voice**: Hand sign voice line: *"Ryōiki Tenkai: Muryōkūsho."* Sub-bass void drone `mob.infinitevoid1`, glass-crystallization ping on barrier seal.
- **Camera direction (Java upgrade)**: Full director cutscene: camera zooms tight on Gojo's crossed-finger hand sign, pulls rapidly out as the black barrier blooms around the environment, cutting to a held surreal wide shot of the cosmic interior.
- **Multiplayer notes**: Trapped players have UI completely grayed out with streaming Japanese kanji glyphs; packet disables client input processing while stunned.
- **Tests**: `GojoGametests#testUnlimitedVoidStunApplication`, `GojoGametests#test0Point2SecondDomainDuration`.
