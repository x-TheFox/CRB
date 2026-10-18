# Toge Inumaki — Animations & VFX Specification

## 1. Animation Manifest
- **Bedrock references**:
  - `animation.speech.unzip` (Pulling down collar zipper)
  - `animation.speech.shout`
  - `animation.speech.cough`
  - `animation.speech.spray` (Applying throat spray)
- **Player Animation Library (Java)**:
  - `inumaki_collar_open`: Quick left hand gesture unzipping high collar to expose mouth seal.
  - `inumaki_command_shout`: Forceful forward lean, mouth open, neck veins straining with cursed aura.
  - `inumaki_throat_recoil`: Dropping to one knee, coughing violently with hand over mouth.
  - `inumaki_spray_sip`: Quick one-handed gulp from throat syrup bottle.

## 2. VFX Particle Architecture
- **Bedrock Particle IDs**:
  - `ds:speech_soundwave`: Expanding circular ripple rings representing acoustic cursed energy waves.
  - `ds:speech_crush`: Ground collapse and radial compression decals.
  - `ds:speech_blood_cough`: Crimson blood splatter particles upon throat recoil.
- **Veil Post-Processing & Custom Shaders**:
  - Acoustic Shockwave Distortion: Radial chromatic lens ripple propagating across the screen from Inumaki's mouth forward.
