# Toge Inumaki — Implementation Notes & Architecture

## 1. Technical Architecture
- **Package**: `com.crb.content.characters.inumaki`
- **Data Attachments (NeoForge 1.21.1)**:
  - `ThroatStrainAttachment`: Integer strain value (0–100), recovery rate timer, and vocal paralysis state.
  - `EarReinforcementAttachment`: Boolean tracking whether an entity is defending their hearing.
- **Networking & Payloads**:
  - `ServerboundSpeechCommandPayload`: Sends selected command ID and aim vector to server.
  - `ClientboundVoiceWavePacket`: Spawns client-side soundwave particle mesh and screen distortion.
- **Conical Raycast Intersection**:
  - Calculates entity bounding box intersection inside forward cone `dot(playerLook, (entityPos - playerPos)) > cos(FOV / 2)`.
- **Gametests**:
  - `InumakiGametests#testDontMoveParalyzesTarget`: Verifies target velocity is frozen.
  - `InumakiGametests#testConsecutiveCommandsInflictThroatDamage`: Asserts strain > 70 damages player.
  - `InumakiGametests#testSyrupRestoresThroat`: Asserts drinking syrup reduces strain by 40.
