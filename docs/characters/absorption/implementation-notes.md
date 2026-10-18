# Kinetic & Curse Absorption — Implementation Notes & Architecture

## 1. Technical Architecture
- **Package**: `com.crb.content.characters.absorption`
- **Data Attachments (NeoForge 1.21.1)**:
  - `AbsorptionChargeAttachment`: Stores `currentStoredCharge` (0–100), `elementalInfusionType`, and `overloadTimer`.
- **Event Listeners**:
  - `LivingHurtEvent`: Intercepts damage when player is blocking, transferring damage amount into `AbsorptionChargeAttachment` and mitigating received damage.
- **Networking & Payloads**:
  - `ClientboundAbsorptionSyncPayload`: Updates GUI charge meter on client HUD.
  - `ClientboundSupernovaCinematicPayload`: Commands Free Camera API to move camera 40 blocks up during ultimate charge.
- **Gametests**:
  - `AbsorptionGametests#testDamageConvertsToCharge`: Asserts incoming attack increments charge meter.
  - `AbsorptionGametests#testSupernovaConsumesAllCharge`: Asserts ultimate resets charge to 0.
