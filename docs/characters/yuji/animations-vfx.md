# Yuji Itadori — Animations, VFX & Presentation Specification

## 1. Skeletal Animations (`animations/`)
From `JJA RP AND BP/Resource/JujutsuAwa/animations/`:
- `animation.yuji.divergent_fist`: Heavy forward lunging cross with trailing cursed energy lag.
- `animation.yuji.black_flash`: Brutal windup hook with twisting hip rotation and sudden frozen impact frame.
- `animation.yuji.consecutive_black_flash`: Rapid 4-hit alternating left/right Black Flash combo sequence.
- `animation.yuji.soul_dismantle_cross`: Two hands held outward with scissor-cutting index and middle fingers.
- `animation.yuji.piercing_blood_compress`: Palms clasped together with thumbs locked, pointing at target.
- `animation.yuji.domain_prayer`: Hands brought together in serene, humble Buddhist prayer gesture (`functions/yuji/memories_shrine.mcfunction`).

## 2. Particle Pipeline & VFX Assets (`particles/`)
- `particles/yuji/divergent_burst.json`: Secondary blue/orange cursed energy delayed detonation.
- `particles/yuji/black_flash_lightning.json`: Thick crimson and pitch-black geometric arcs of spatial lightning bursting 8 blocks radially.
- `particles/yuji/soul_seam.json`: Cyan ethereal soul threads snapping along target's seams.
- `particles/yuji/piercing_blood.json`: High-density crimson blood projectile with supersonic shock cones.
- `particles/yuji/snow_station.json`: Atmospheric falling snow particles within the train station domain.

## 3. Impact Frames & Visual Cinematics
- Consecutive Black Flash: Every Black Flash hit triggers a 2-frame negative monochrome freeze with red lightning glow.
- The 8th Black Flash: Full-screen monochrome inversion, slow-motion beat (game ticks dilated to 0.5x speed for 10 ticks), followed by a violent shockwave punch.
