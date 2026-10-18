# Aoi Todo — Implementation Notes & Architecture

## 1. Technical Architecture
- **Package**: `com.crb.content.characters.todo`
- **Data Attachments (NeoForge 1.21.1)**:
  - `BrotherLinkAttachment`: Stores bonded player UUIDs and team coordination multipliers.
  - `VibraslapAttachment`: Tracks equipped prosthetic, swap frequency, and cooldown timers.
- **Networking & Payloads**:
  - `ServerboundTriggerSwapPayload`: Client requests swap with crosshair target.
  - `ClientboundPositionSwapPayload`: Server executes coordinate/momentum swap and sends visual/audio packet to both participants.
- **Safety & Anti-Cheat Protocols**:
  - Distance check: Target must be within maximum range (32 blocks base, 60 blocks Vibraslap).
  - Cursed Energy check: Target entity must possess active CE > 5.
  - Geometry validation: Prevents swapping players into solid bedrock or suffocation blocks.
- **Gametests**:
  - `TodoGametests#testSwapExchangesCoordinates`: Verifies two entities cleanly exchange `(x, y, z)`.
  - `TodoGametests#testPebbleSwapMidAir`: Asserts player swaps with airborne pebble entity.
  - `TodoGametests#testSimpleDomainNeutralizesSureHit`: Asserts Simple Domain cancels incoming domain damage.
