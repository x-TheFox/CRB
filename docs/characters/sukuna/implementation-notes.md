# Ryomen Sukuna — Implementation Notes & Technical Map

## 1. Module Ownership
- **Package**: `com.crb.game.character.sukuna`
- **Class Structure**:
  - `SukunaTechniqueDefinition`: Registers Shrine, Dismantle, Cleave, Fuga, World Cutting Slash, and 3 fighting styles.
  - `DismantleProjectileEntity`: Fast raycast slicing projectile with line-of-sight penetration.
  - `FugaArrowEntity`: Parabolic explosive projectile with post-domain thermobaric synergy.
  - `WorldCuttingSlashHandler`: Instantaneous plane-intersection bisection algorithm executing server-side lethal slicing.
  - `MalevolentShrineDomain`: Implements `OpenDomainInstance` interface (200m radius, no outer wall, dynamic Cleave/Dismantle entity-filtering tick loop).
  - `HeianFormCapability`: Manages extra arm bones in player model, secondary off-hand slot, and simultaneous chanting.

## 2. Test Plan & Gametests
- `SukunaDismantleRaycastTest`: Verifies projectile flies in crosshair direction and cuts test dummy.
- `SukunaCleaveScalingTest`: Verifies contact Cleave inflicts higher damage against iron golem (high armor) than unarmored zombie.
- `SukunaFugaExplosionTest`: Verifies thermobaric blast radius scales up when preceded by Malevolent Shrine.
- `SukunaWorldCuttingSlashTest`: Verifies WCS damages entity even when protected by Satoru Gojo's Neutral Infinity.
- `SukunaOpenDomainPerimeterTest`: Verifies players can freely cross the 200m boundary and receive continuous slashes while inside.

## 3. Deviations from JJA
- Native four-armed player rendering with GeckoLib/PlayerAnimationLib instead of rigid Bedrock armor attachable models.
- Instantaneous spatial slice for World Cutting Slash rather than slow command chain projectile.
- Configurable radius modulation for Malevolent Shrine.
