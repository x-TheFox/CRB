# Ryomen Sukuna — Animations, VFX & Presentation Specification

## 1. Skeletal Animations (`animations/`)
From `JJA RP AND BP/Resource/JujutsuAwa/animations/`:
- `animation.sukuna.flick_dismantle`: Casual wrist and finger flick launching invisible slash waves.
- `animation.sukuna.grab_cleave`: Forward burst grab with right hand sinking into target's shoulder/torso.
- `animation.sukuna.spiderweb`: Slamming palm onto the floor with fingers splayed out.
- `animation.sukuna.fuga_draw`: Right arm pulled back drawing an invisible colossal bow string, left arm extended straight with flaming arrowhead.
- `animation.sukuna.handsign_enma`: Enma-ten hand sign (palms pressed together with middle/ring fingers interwoven).
- `animation.sukuna.four_armed_stance`: Four-armed idle combat stance with upper arms guarding face and lower arms prepared for grapple.
- `animation.sukuna.world_slash_chant`: Pointing forward with upper right hand while lower mouth and upper left hand form chants and signs.

## 2. Particle Pipeline & VFX Assets (`particles/`)
- `particles/sukuna/dismantle_slash.json`: Sharp thin slicing crescent with crimson trail and distorted air edge.
- `particles/sukuna/cleave_grid.json`: Dense red-and-black lattice network of intersecting slashes adhering to entity hitboxes.
- `particles/sukuna/fuga_arrow.json`: Superheated white-and-orange flame core swirling with thermochemical plasma tendrils.
- `particles/sukuna/fuga_explosion.json`: Multi-phase expanding thermal shockwave and volcanic mushroom cloud.
- `particles/sukuna/world_slash_rift.json`: Jet-black spatial seam tearing across the screen with reality-shattering glass sparks.
- `particles/sukuna/malevolent_shrine_dust.json`: Continuous cloud of pulverized stone and airborne blood mist filling the 200m perimeter.

## 3. Attachables & Models
- `models/entity/heian_sukuna.geo.json`: Custom four-armed model with abdominal mouth and facial cursed markings.
- `attachables/sukuna_robes.json`: Flowing white kimono with black sash and torn sleeves.
- `models/entity/malevolent_shrine.geo.json`: Monumental wooden Buddhist shrine adorned with horned demon skulls and bull horns.

## 4. Impact Frames & Visual Cinematics
- World Cutting Slash: 3 ticks of pure inverted monochrome impact frame; viewport cuts along a diagonal split line, displacing the top-right and bottom-left halves of the screen by 10 pixels before snapping back.
- Contact Cleave: High-contrast red flash with radial blood decals on the player's screen.
