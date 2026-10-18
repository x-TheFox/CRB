# Technology Stack Decision Record (TSDR)

**Date**: 2026-10-18  
**Status**: **APPROVED & ACTIVE**  
**Context**: Replicating and elevating the Jujutsu Awakening (JJA) Bedrock addon into a definitive Minecraft Java Edition mod on NeoForge 1.21.1.  

---

## 1. Architectural Principles
1. **Zero-Deprecation Foundation**: Built exclusively on modern NeoForge 1.21.1 APIs. No legacy Forge 1.20.1 paradigms (no `CapabilityManager`, no `SimpleChannel`, no static event handlers).
2. **Server-Authoritative Core**: All combat calculations, cooldowns, cursed energy pools, hitboxes, and domain rules reside on the server. The client is strictly an input emitter and visual/audio rendering engine.
3. **Hermetic Stability**: Dependencies are vendor-cached directly in `libs/` to ensure full build reproducibility even in disconnected, restricted, or offline CI/CD pipelines.

---

## 2. Adopted Technology Stack

### 2.1 Core Runtime & Mod Loader
- **Minecraft Version**: 1.21.1
- **Mod Loader**: NeoForge 21.1.93 (or latest 21.1.x series)
- **Java Toolchain**: Java 21 (Temurin-21.0.9+10)
- **Mapping Standard**: Mojang Official Mappings with Parchment 2024.11.17 parameter names.

### 2.2 Adopted Library Portfolio (The Six Pillars)
1. **Free Camera API (v2.1.1)**:
   - *Jar*: `libs/freecameraapi-neo-1.21.1-2.1.1.jar`
   - *Purpose*: Unlocking client camera from the player entity to drive anime cutscenes (Hollow Purple charging, Malevolent Shrine domain expansion, Sukuna vs Mahoraga world clashes).
2. **GeckoLib (v4.9.3)**:
   - *Jar*: `libs/geckolib-neoforge-1.21.1-4.9.3.jar`
   - *Purpose*: Complex skeletal mesh animations for bosses (Mahoraga, Sukuna, Finger Bearer), summons (Nue, Divine Dog, Max Elephant), and animated 3D weapons (Executioner's Sword, Nyoi Staff).
3. **Player Animation Library (v1.1.6+mc.1.21.1)**:
   - *Jar*: `libs/PlayerAnimationLibNeoforge-1.1.6+mc.1.21.1.jar`
   - *Purpose*: High-fidelity first-person and third-person player combat animations (divergent fist, black flash winding, domain hand signs, martial arts combos).
4. **Veil (v4.5.2)**:
   - *Jar*: `libs/veil-neoforge-1.21.1-4.5.2.jar`
   - *Purpose*: Custom rendering pipelines, bloom post-processing, screen-space distortion passes (Infinity refraction, World Cutting Slash tear, Domain barriers), and procedural particle ribbons.
5. **Yet Another Config Lib / YACL (v3.8.2)**:
   - *Jar*: `libs/yet_another_config_lib_v3-3.8.2+1.21.1-neoforge.jar`
   - *Purpose*: In-game settings interface for keybinds, particle densities, camera shake intensity, and canon purist toggles.
6. **SmartBrainLib (v1.16.11)**:
   - *Jar*: `libs/SmartBrainLib-neoforge-1.21.1-1.16.11.jar`
   - *Purpose*: Composable behavior trees and memory-driven AI architectures for intelligent boss fights and cooperative shikigami companions.

---

## 3. NeoForge 1.21.1 Core Architecture Specifications

### 3.1 Data Attachments (State Persistence)
All persistent player and entity data (Cursed Energy, Techniques, Progression, Traits, Clan, Cooldowns) is implemented using NeoForge's `AttachmentType` registered via `NeoForgeRegistries.ATTACHMENT_TYPES`:
- Registered with custom `Codec<T>` or `INBTSerializable<CompoundTag>`.
- Configured with `.copyOnDeath()` where appropriate (e.g. innate CT, maximum CE pool, unlocked grades).

### 3.2 Payload Networking (Client-Server Protocol)
All network communication uses NeoForge's `CustomPacketPayload` and `PayloadRegistrar`:
- Registered via `RegisterPayloadHandlersEvent` on the mod event bus.
- Directional protocols:
  - `ServerboundAbilityTriggerPayload`: Client input requests ability execution.
  - `ClientboundStateSyncPayload`: Server synchronizes active CE, active domain, and animation states to client.
  - `ClientboundCameraCuePayload`: Server commands client camera director to execute cinematic sequences.
