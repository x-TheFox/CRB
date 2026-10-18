# Yuji Itadori — Implementation Notes & Technical Map

## 1. Module Ownership
- **Package**: `com.crb.game.character.yuji`
- **Class Structure**:
  - `YujiTechniqueDefinition`: Registers Soul Shrine, Blood Manipulation, Divergent Fist, and Black Flash handlers.
  - `DivergentFistHandler`: Subscribes to melee attack events, registers initial damage and schedules secondary lagged damage task.
  - `BlackFlashDirector`: Precision frame-timing evaluator for Black Flash execution and "The Zone" state updates.
  - `SoulDismantleEffect`: Damage source targeting soul integrity data attachments.
  - `BloodManipulationHandler`: Implements Piercing Blood raycast and Supernova particle cluster.
  - `ShrineOfReverieDomain`: Implements `DomainExpansionInstance` for train station arena generation, nostalgic lighting, and sure-hit soul strikes.

## 2. Test Plan & Gametests
- `YujiDivergentFistLagTest`: Verifies 4-tick delay between primary and secondary damage events.
- `YujiBlackFlashComboTest`: Verifies consecutive Black Flash increases damage scaling up to 8 hits.
- `YujiSoulDismantleTest`: Verifies soul damage cannot be healed by standard regeneration potions.
- `YujiBloodManipulationTest`: Verifies Piercing Blood projectile velocity and armor penetration.
- `YujiDomainGenerationTest`: Verifies train station platform arena spawns reliably without clipping terrain.

## 3. Deviations from JJA
- Complete implementation of unreleased Blood Manipulation (`blood_manipulation.json`).
- Active frame-timing skill window for Black Flash rather than pure random roll.
- Dedicated train station arena dimension instance.
