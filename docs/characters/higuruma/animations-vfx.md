# Hiromi Higuruma — Animations & VFX Specification

## 1. Animation Manifest
- **Bedrock references**:
  - `animation.gavel.swing`
  - `animation.gavel.slam`
  - `animation.gavel.grow`
  - `animation.judgeman.idle`
  - `animation.judgeman.gavel_strike`
- **Player Animation Library (Java)**:
  - `higuruma_gavel_combo`: 3-hit swing, lateral uppercut, downward hammer strike.
  - `higuruma_gavel_extend`: Thrust forward with arm locked, gavel head shooting out 12 blocks.
  - `higuruma_colossal_overhead`: Two-handed jump with colossal gavel, landing with ground shockwave.
  - `higuruma_courtroom_opening`: Solemn suit adjustment, holding small gavel upright as courtroom geometry erects.
  - `higuruma_executionsword_draw`: Blade ignited with pure radiant amber-gold light.

## 2. VFX Particle Architecture
- **Courtroom & Trial Particles**:
  - `ds:gavel_impact_shockwave`: Circular dust ring and ground crack decals on heavy slam.
  - `ds:judgeman_scales`: Floating balanced scales of justice above defendant's head.
  - `ds:executionsword_glow`: Shimmering radiant golden blade trail with particle sparks.
  - Courtroom lighting: Warm ambient incandescent chandelier glow within domain barrier.
