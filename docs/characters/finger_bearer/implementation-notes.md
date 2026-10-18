# Finger Bearer / Explosive Energy — Implementation Notes & Architecture

## 1. Technical Architecture
- **Package**: `com.crb.content.characters.finger_bearer`
- **Boss Entity Class**: `FingerBearerBossEntity` (extends `Monster`, implements `GeoEntity`)
- **Data Attachments (NeoForge 1.21.1)**:
  - `ExplosiveEnergyAttachment`: Tracks raw energy charge, volatile critical meter, and boss phase.
- **SmartBrainLib AI Tasks**:
  - `SetPlayerLookTarget`: Tracks player combat vector.
  - `TeleportBehindTargetTask`: Executes TP punch when line of sight is obstructed.
  - `ChargeMugetsuBeamTask`: Enters charging state when HP < 50%, aiming beam at predicted player movement.
- **Loot Table Integration**:
  - `crb:entities/finger_bearer`: Always drops 1x `crb:sukuna_finger`, with rare cursed tool essence.
- **Gametests**:
  - `FingerBearerGametests#testBossSpawnsWithFinger`: Asserts boss entity carries finger drop.
  - `FingerBearerGametests#testMugetsuDamageArea`: Verifies beam deals continuous damage along raycast.
