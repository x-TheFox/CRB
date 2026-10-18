# Mahito — Implementation Notes & Technical Map

## 1. Module Ownership
- **Package**: `com.crb.game.character.mahito`
- **Class Structure**:
  - `MahitoTechniqueDefinition`: Registers Idle Transfiguration, all 3 fighting styles, Instant Spirit Body, and Self-Embodiment of Perfection.
  - `SoulDamageSource`: Custom damage source targeting soul integrity data attachments, bypassing armor and conventional healing.
  - `SoulInvulnerabilityHandler`: Subscribes to `LivingHurtEvent`, canceling physical damage if the attacker lacks soul awareness capability.
  - `TransfiguredHumanEntity`: Fast swarm mob utilizing SmartBrainLib.
  - `InstantSpiritBodyCapability`: Manages armored model replacement, +200% defense modifier, and tail attack hitboxes.
  - `SelfEmbodimentOfPerfectionDomain`: Implements `DomainExpansionInstance` with living hand barrier and continuous sure-hit soul transfiguration.

## 2. Test Plan & Gametests
- `MahitoPhysicalImmunityTest`: Verifies diamond sword strikes deal 0 damage unless wielder has soul awareness.
- `MahitoSoulTouchTest`: Verifies palm touch reduces target's max health.
- `MahitoInstantBodyDefenseTest`: Verifies incoming damage is reduced by 75% in Instant Spirit Body.
- `MahitoSukunaDomainCounterTest`: Verifies expanding domain on Sukuna triggers immediate Cleave counter-shatter.
