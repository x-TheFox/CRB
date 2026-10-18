# Finger Bearer / Explosive Energy — Animations & VFX Specification

## 1. Animation Manifest
- **GeckoLib Entity Models**:
  - `animation.finger_bearer.idle`: Grotesque twitching, asymmetrical gait, disjointed neck tremors.
  - `animation.finger_bearer.taunt`: Infant-like giggling while pointing at injured victim.
  - `animation.finger_bearer.palm_blast`: Open double palms surging with energy recoil.
  - `animation.finger_bearer.mugetsu_charge`: Arching spine backward, jaw dislocating wide open.

## 2. VFX Particle Architecture
- **Bedrock Particle IDs**:
  - `ds:energy_explosion` (Violent magenta/purple sphere detonation).
  - `ds:bolt_explode` (Purple electrical discharge sparks).
  - `ds:massive_bomb` (Large cloud of dust, smoke, and shattered ground blocks).
- **Veil Post-Processing & Custom Shaders**:
  - `veil:shaders/post/raw_cursed_bloom.json`: Unstable flickering purple luminescence around raw CE projectiles.
