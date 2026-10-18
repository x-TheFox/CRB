# Hajime Kashimo — Animations & VFX Specification

## 1. Animation Manifest
- **Bedrock source references**:
  - `animation.kashimo.fighting_stance`
  - `animation.thunder_cloak.activate`
  - `animation.amber_beast`
  - `animation.nyoi_staff.swing`
  - `animation.lightning.discharge`
- **Player Animation Library (Java)**:
  - `kashimo_electrified_m1_combo`: 3-hit aggressive kick-and-palm strike with leaning center-of-gravity.
  - `kashimo_cloak_surge`: Two-arm downward flex followed by full-body tension tremor.
  - `kashimo_surehit_discharge`: Right palm forward thrust, head tilt, left arm anchored.
  - `kashimo_amber_transformation`: Dramatic suspended float, spine arched back, lightning crackling from eye sockets and horns sprouting.

## 2. VFX Particle Architecture
- **Bedrock Particle IDs**:
  - `ds:lightning_shockwave1`
  - `ds:lightning_cloak_charge1` through `ds:lightning_cloak_charge5`
  - `ds:lightningbolt1`, `ds:lightningbolt2`, `ds:lightningbolt3`
  - `ds:lightningbolt1a`, `ds:lightningbolt2a`, `ds:lightningbolt3a` (Amber variants)
  - `ds:beast_storm1`
  - `ds:energy_wave1`, `ds:energy_wave2`, `ds:energy_wave3`
  - `ds:ground_slam1..3`, `ds:rubble3`, `ds:impact1`
- **Veil Post-Processing & Custom Shaders**:
  - `veil:shaders/post/electrical_bloom.json`: High-intensity emissive teal glow on lightning arcs.
  - `veil:shaders/post/amber_chromatic.json`: Amber transformation screen flare with rainbow chromatic aberration.
  - Custom ribbon renderer for procedural lightning branch generation instead of static 2D billboard sprites.
