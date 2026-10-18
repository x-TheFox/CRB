# Kinetic & Curse Absorption — Animations & VFX Specification

## 1. Animation Manifest
- **Bedrock references**:
  - `animation.absorption.ab1`
  - `animation.absorption.ab8` (Supernova float and downward palm slam)
- **Player Animation Library (Java)**:
  - `absorption_absorb_brace`: Cross-armed guarding stance with kinetic ripple rings around forearms.
  - `absorption_beam_fire`: Single-hand outstretched palm with continuous recoil tremor.
  - `absorption_nuke_levitate`: Suspended floating state with hands held high above head gathering atmospheric lightning.

## 2. VFX Particle Architecture
- **Bedrock Particle IDs**:
  - `ds:absorption_ex`
  - `ds:turbo_intensity2`, `ds:turbo_intensity3`, `ds:turbo_intensity3b`
  - `ds:large_impact1`, `ds:large_impact2`
- **Veil Post-Processing & Custom Shaders**:
  - Kinetic distortion sphere: Spherical lens refraction overlay that expands and contracts as absorption meter fills.
  - Blinding supernova flash on `absorption8` detonation.
