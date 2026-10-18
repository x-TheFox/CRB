# Minor Cursed Techniques — Implementation Notes & Architecture

## 1. Technical Architecture
- **Package**: `com.crb.content.characters.minor_techniques`
- **Data Attachments (NeoForge 1.21.1)**:
  - `MiracleDataAttachment`: Integer count (0–6) of stored miracles.
  - `MangaInkAttachment`: Stores target UUID, ink timer, and number of active future panels.
  - `PainKillerAttachment`: Stores active deferred damage pool and remaining anesthetic duration.
- **Event Listeners**:
  - `LivingDeathEvent`: Haruta miracle rescue logic intercepts fatal blow, cancels death, decrements miracle counter, and heals player.
  - `RenderLevelStageEvent`: Renders 3D billboard manga panels in world space for Charles Bernard.
- **Gametests**:
  - `MinorCTGametests#testMiracleSavesFromLethal`: Asserts player survives lethal hit when miracle counter > 0.
  - `MinorCTGametests#testPainkillerDefersDamage`: Asserts player does not take instant damage while buff is active.
