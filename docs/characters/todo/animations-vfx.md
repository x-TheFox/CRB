# Aoi Todo — Animations & VFX Specification

## 1. Animation Manifest
- **Bedrock references**:
  - `animation.boogie_woogie.clap`
  - `animation.boogie_woogie.fake_clap`
  - `animation.plus_ultra.start`
  - `animation.plus_ultra.start1`
  - `animation.todo.taunt`
- **Player Animation Library (Java)**:
  - `todo_crisp_clap`: Snappy two-hand slap with high chest raise and shoulder snap.
  - `todo_vibraslap_strike`: Fast prosthetic tap against forearm.
  - `todo_pebble_flick`: Low-angle thumb-flick hurling cursed pebble forward.
  - `todo_plus_ultra_combo`: 6-phase teleport martial arts sequence with rotation changes.

## 2. VFX Particle Architecture
- **Bedrock Particle IDs**:
  - `ds:boogie_woogie_tp` (Spatial warping white/blue ring).
  - `ds:boogie_woogie_tp2` (Concentrated cursed spark trails).
  - `ds:leap` (Ground dust kickback).
  - `gg:impact_frame` (High-contrast monochrome inverted frame on heavy hits).
- **Veil Post-Processing & Custom Shaders**:
  - `veil:shaders/post/swap_distortion.json`: Single-frame spatial refraction lens wave across screen when swapping player camera.
  - Directional motion blur vector on successful position swap.
