# Megumi Fushiguro — Implementation Notes & Technical Map

## 1. Module Ownership
- **Package**: `com.crb.game.character.megumi`
- **Class Structure**:
  - `TenShadowsTechnique`: Core registry for all 10 shikigami, shadow storage data attachment, and taming state machine.
  - `ShikigamiEntityBase`: Custom base mob entity utilizing **SmartBrainLib** for coordinated group pathfinding and target prioritization.
  - `MahoragaEntity`: Adaptive boss entity implementing `IDamageAdaptationListener`, tracking incoming damage types and managing the Dharmachakra wheel model rotation.
  - `ChimeraShadowGardenDomain`: Implements `IncompleteDomainInstance` modifying chunk floor blocks and managing shadow clone mirroring.

## 2. Test Plan & Gametests
- `MegumiTamingRitualTest`: Verifies untamed shikigami spawns hostile and grants taming achievement upon defeat.
- `MegumiMahoragaAdaptationTest`: Verifies 4 hits of fire damage grants Mahoraga complete immunity to fire.
- `MegumiPiercingOxChargeTest`: Verifies damage increases proportionally with charge distance.
- `MegumiIncompleteDomainTest`: Verifies domain stability checks for enclosed walls vs open air.

## 3. Deviations from JJA
- Utilizes SmartBrainLib AI instead of Bedrock's erratic entity goal components.
- Integrated partial shadow manifestation mechanics for traversal and tactical utility.
