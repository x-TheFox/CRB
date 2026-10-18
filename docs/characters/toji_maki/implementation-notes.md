# Toji Fushiguro & Maki Zenin — Implementation Notes & Architecture

## 1. Technical Architecture
- **Package**: `com.crb.content.characters.toji_maki`
- **Data Attachments (NeoForge 1.21.1)**:
  - `HeavenlyRestrictionAttachment`: Enforces zero CE value, grants passive attribute modifiers (speed, attack damage, armor, toughness), and flags entity as `isDomainImmune()`.
  - `SensoryVisionAttachment`: Controls custom post-processing view filter.
- **Combat & Event Hooks**:
  - `DomainExpansionEvent.TargetFilter`: When domain checks for valid targets inside barrier, entities with `HeavenlyRestrictionAttachment` returning true are skipped.
  - `LivingHurtEvent`: Handles Inverted Spear CT dispelling and Soul Split Katana pure soul damage.
- **Gametests**:
  - `HeavenlyRestrictionGametests#testZeroCEEnforced`: Verifies CE never increases above 0.
  - `HeavenlyRestrictionGametests#testDomainSureHitIgnoresHR`: Verifies standard lethal domain sure-hit does not damage player.
  - `HeavenlyRestrictionGametests#testInvertedSpearDispelsInfinity`: Verifies Inverted Spear penetrates Infinity barrier.
