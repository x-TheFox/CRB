# Toji Fushiguro & Maki Zenin — Animations & VFX Specification

## 1. Animation Manifest
- **Bedrock references**:
  - `animation.toji.stance`
  - `animation.toji.dive_kick`
  - `animation.toji.dash`
  - `animation.toji.slash_rapid`
- **Player Animation Library (Java)**:
  - `toji_feral_sprint`: Low-profile crouched sprint leaning forward at 30 degrees, arms trailing back.
  - `toji_spear_stab`: Brutal two-handed downward thrust with Inverted Spear.
  - `toji_air_jump`: Atmospheric rebound kick stepping off mid-air invisible platforms.
  - `toji_playful_cloud_spin`: High-speed three-section staff windmill rotation with motion blur.

## 2. VFX Particle Architecture
- **Bedrock Particle IDs**:
  - `ds:flashstrikeparticles`
  - `ds:ground_slam1..3`
  - `ds:rubble3`
  - Atmospheric vapor cones (`ds:sonic_boom_cone`) on high-speed sprint bursts.
- **Veil Post-Processing & Custom Shaders**:
  - `veil:shaders/post/sensory_vision.json`: High-contrast grayscale shader highlighting enemy heat signatures, soul outlines, and air temperature currents.
  - Zero-Cursed Energy Void: Completely invisible to sorcerer cursed-energy detection auras.
