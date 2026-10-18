# Satoru Gojo — Implementation Notes & Technical Map

## 1. Module Ownership
- **Package**: `com.crb.game.character.gojo`
- **Class Structure**:
  - `GojoTechniqueDefinition`: Registers Limitless, its abilities, cooldowns, and Six Eyes data attachment modifiers.
  - `InfinityShieldHandler`: Server event subscriber listening to `LivingHurtEvent`, intercepting projectile and melee damage against players with active Infinity.
  - `LapseBlueEntity`: Custom entity handling physics tick, attraction vectors, and block displacement.
  - `ReversalRedEntity`: Fast raycast entity with repulsive impulse explosion on collision.
  - `HollowPurpleEntity`: Heavy linear projectile with voxel block-carving and true erasure damage calculations.
  - `UnlimitedVoidDomain`: Implements `DomainExpansionInstance` interface for barrier geometry, cosmic skybox rendering, and sure-hit cognitive overload ticks.

## 2. Test Plan & Gametests
- `GojoInfinityTest`: Verifies incoming skeleton arrows and blaze fireballs are deflected without player damage.
- `GojoBlueSuctionTest`: Verifies surrounding zombies within 12 blocks are pulled toward the singularity.
- `GojoRedKnockbackTest`: Verifies repulsive impulse deals heavy knockback and destroys fragile blocks (glass, wood).
- `GojoHollowPurpleErasureTest`: Verifies projectile cleanly carves a cylindrical tunnel through stone without leaving item drops.
- `GojoUnlimitedVoidStunTest`: Verifies all non-allied entities inside the 66-block barrier receive Stun and cannot attack or move.

## 3. Deviations from JJA
- Replaced Bedrock hotbar items (`ds:limitless1`–`6`) with native radial wheel and keybind combos.
- Replaced title glyph font impact frames with custom GLSL post-processing shaders via Veil.
- Replaced command-block barrier cloning with procedural geometric barrier construction.
