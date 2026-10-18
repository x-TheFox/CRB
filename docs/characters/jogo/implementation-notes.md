# Jogo — Implementation Notes & Technical Map

## 1. Module Ownership
- **Package**: `com.crb.game.character.jogo`
- **Class Structure**:
  - `JogoTechniqueDefinition`: Registers Disaster Flames, Ember Insects, Maximum Meteor, and Coffin of Iron Mountain.
  - `EmberInsectEntity`: Homing projectile entity with audio screech and dual concussive/fire explosion on impact.
  - `MaximumMeteorEntity`: Large falling celestial entity with custom GeckoLib model and crater generation algorithm.
  - `CoffinOfIronMountainDomain`: Implements `DomainExpansionInstance` with volcanic rock barrier and ambient thermal heat loop.

## 2. Test Plan & Gametests
- `JogoEmberInsectsHomingTest`: Verifies insects acquire nearby targets and navigate around obstacles.
- `JogoMeteorImpactDamageTest`: Verifies meteor deals massive damage at epicenter and scales down with distance.
- `JogoIronMountainHeatAuraTest`: Verifies entities lacking CE reinforcement suffer continuous fire damage.
