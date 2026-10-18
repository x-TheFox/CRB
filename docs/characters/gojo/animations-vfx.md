# Satoru Gojo — Animations, VFX & Presentation Specification

## 1. Skeletal Animations (`animations/`)
From `JJA RP AND BP/Resource/JujutsuAwa/animations/`:
- `animation.gojo.infinity_stance`: Idle floating stance with hands in pockets or coat billowing.
- `animation.gojo.blue_point`: Single index finger forward point with spatial tension.
- `animation.gojo.red_charge`: Index and middle finger held upward, flame-like recoil on release.
- `animation.gojo.purple_fusion`: Two-handed gesture bringing blue orb (right hand) and red orb (left hand) to chest level, snapping forward with open palms.
- `animation.gojo.handsign_unlimited_void`: Crossing middle finger over index finger of right hand close to face.
- `animation.gojo.blindfold_pull`: Hand reaching up to adjust or lower blindfold, exposing the glowing Six Eyes.

## 2. Particle Pipeline & VFX Assets (`particles/`)
- `particles/limitless/blue_orb.json`: Concentric blue swirling accretion disc with inward gravitational particle suction.
- `particles/limitless/red_beam.json`: Scarlet laser core with radiating repulsive sonic shockwave rings.
- `particles/limitless/purple_singularity.json`: Core violet sphere surrounded by lightning discharge arcs, micro black holes, and space distortion ribbons.
- `particles/limitless/infinity_distort.json`: Refractive heat-haze bubble around the player's collision volume.
- `particles/limitless/unlimited_void_sky.json`: Dome skybox particle emitter projecting cosmic galaxies and neural eye structures.

## 3. Attachables & Render Controllers
- `attachables/gojo_blindfold.json`: Detachable black cloth blindfold covering eyes.
- `attachables/gojo_cloak.json`: High-collar Jujutsu High dark blue tunic with dynamic cloth physics.
- `render_controllers/gojo_eyes.json`: Dynamic emissive texture overlay for bright cyan glowing iris pupils when blindfold is removed.

## 4. Impact Frames & Screen Space Effects
- During Hollow Purple release: 2 frames of inverted monochrome flash (Black background with white line silhouette) followed by 1 frame of saturated purple burn.
- Unlimited Void entrance: Full-screen post-processing desaturation, followed by chromatic aberration pulsing to heartbeat rhythm (80 BPM).
