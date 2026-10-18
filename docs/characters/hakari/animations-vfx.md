# Kinji Hakari — Animations & VFX Specification

## 1. Animation Manifest
- **Bedrock references**:
  - `animation.hakari_domain`
  - `animation.shutter_doors.close`
  - `animation.hakari.dance` (Iconic phonk/disco arm-swing dance)
  - `animation.pachinko.shoot`
- **Player Animation Library (Java)**:
  - `hakari_abrasive_m1`: Rough boxing stance with elbows, hooks, and headbutts.
  - `hakari_domain_activation`: Raising arms outward with hands cupped like slot handles.
  - `hakari_jackpot_dance`: Seamless looping celebratory dance that plays while sprinting or idle during Jackpot.
  - `hakari_door_slam`: Sudden clap summoning double shutter barriers.

## 2. VFX Particle Architecture
- **Bedrock Particle IDs**:
  - `ds:domain_area0`, `ds:domainarea0`, `ds:domainarea1`
  - `ds:pachinko_impact1`
  - `ds:spark_abrasive`
- **Veil Post-Processing & Custom Shaders**:
  - Jackpot Golden Shimmer: Blinding golden aura ribbons erupting from Hakari's body during the 4m11s song.
  - Domain Riichi Overlays: Cinematic 2D romance manga panels projected onto the interior skybox of the domain during slot evaluations.
