# Hajime Kashimo — Implementation Notes & Architecture

## 1. Technical Architecture
- **Package**: `com.crb.content.characters.kashimo`
- **Data Attachments (NeoForge 1.21.1)**:
  - `ElectricChargeAttachment`: Tracks `Map<UUID, Integer> targetCharges` for positive/negative electrostatic polarity.
  - `AmberTransformationAttachment`: Tracks active state, duration timer, and organ deterioration metrics.
- **Networking**:
  - `ClientboundLightningDischargePayload`: Sends start/end raycast vectors for client-side procedural lightning ribbon rendering.
  - `ServerboundNyoiStaffRecallPayload`: Triggers return-arc discharge between Kashimo and planted staff entity.
- **Rendering**:
  - `VeilPostProcessing`: Electrical distortion shader applied during lightning discharge.
  - `GeckoLib`: Custom animated player layer for amber horns and eyes.
- **Gametests**:
  - `KashimoGametests#testMeleeAppliesCharge`: Verifies M1 punch adds charge stack to target.
  - `KashimoGametests#testSureHitDischargeAtMaxStacks`: Verifies discharge can only fire at max stacks.
  - `KashimoGametests#testWaterElectrolysisExplosion`: Verifies underwater discharge spawns explosion after 60 ticks.
