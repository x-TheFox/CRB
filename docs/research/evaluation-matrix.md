# Architecture & Library Evaluation Matrix

**Date**: 2026-10-18  
**Project**: Cursed Reality: Boundless (CRB) · Minecraft Java Edition 1.21.1 · NeoForge 21.1.x  

---

## 1. Evaluation Methodology
Libraries were evaluated against 5 non-negotiable criteria derived from the Constitution:
1. **NeoForge 1.21.1 Native Stability (30%)**: Proven compatibility with NeoForge 21.1.x (Data Attachments, `CustomPacketPayload`, Mojang mappings, Java 21).
2. **Server-Authoritative Safety (25%)**: Safe execution across dedicated multiplayer environments with zero client-trusted combat state.
3. **Cinematic & Visual Fidelity (20%)**: Capability to deliver anime-grade camera choreography, custom shaders, impact frames, and dynamic lighting.
4. **Offline / Hermetic Availability (15%)**: Pre-compiled jars available in `libs/` for zero-friction compilation and deterministic CI/CD builds.
5. **Community Maintenance & Documentation (10%)**: Active upstream maintenance, clear source code, and responsive issue trackers.

---

## 2. Capability Evaluation Matrix

| Capability Domain | Candidate 1 (Selected) | Candidate 2 | Candidate 3 | Rationale & Selection Outcome |
| :--- | :--- | :--- | :--- | :--- |
| **Entity & Armor Animation** | **GeckoLib 4.9.3** (`libs/geckolib-neoforge-1.21.1-4.9.3.jar`) | Blockbench Custom Java Models | KosmX Model Engine | **Selected: GeckoLib 4.9.3**. Standardized Bedrock-compatible keyframe animation schema, bone controllers, sound/particle keyframe listeners, and native NeoForge 1.21.1 support. |
| **First/Third-Person Player Animation** | **Player Animation Library 1.1.6** (`libs/PlayerAnimationLibNeoforge-1.1.6+mc.1.21.1.jar`) | Emotecraft / Custom Render Layer | Raw ModelPart Math | **Selected: Player Animation Lib 1.1.6**. Native support for playing complex layered animations on the player model without replacing the player entity or breaking armor rendering. |
| **Post-Processing & Custom Shaders** | **Veil 4.5.2** (`libs/veil-neoforge-1.21.1-4.5.2.jar`) | Post-1.21 Vanilla Core Shaders | Iris / Oculus Embedded | **Selected: Veil 4.5.2**. The premier NeoForge rendering engine for custom framebuffers, volumetric lighting, bloom, screen-distortion post-processing passes, and procedural mesh ribbons. |
| **Cinematic Camera Choreography** | **Free Camera API 2.1.1** (`libs/freecameraapi-neo-1.21.1-2.1.1.jar`) | Vanilla `/camera` Command Packets | Custom Camera Mixins | **Selected: Free Camera API 2.1.1**. Provides programmatic camera detachment, spline easing curves (`in_out_circ`, `cubic_bezier`), FOV manipulation, and lock-on tracking. |
| **AI & Entity Brain Trees** | **SmartBrainLib 1.16.11** (`libs/SmartBrainLib-neoforge-1.21.1-1.16.11.jar`) | Vanilla Goal Selectors | Custom State Machine Tasks | **Selected: SmartBrainLib 1.16.11**. Modular, composable behavior trees with priority selectors, memory modules, dynamic target filtering, and clean multiplayer synchronization. |
| **In-Game Configuration & Client UI** | **Yet Another Config Lib (YACL) 3.8.2** (`libs/yet_another_config_lib_v3-3.8.2+1.21.1-neoforge.jar`) | Cloth Config | AutoConfig / NeoForge Config Specs | **Selected: YACL 3.8.2**. Modern, accessible UI generation with category tabs, live previews, controller support, and seamless JSON serialization. |
| **Cursed Energy & Trait Persistence** | **NeoForge Data Attachments** (Native NeoForge 1.21.1) | Old Forge Capabilities (Deprecated) | Entity Persistent Data NBT | **Selected: Data Attachments**. NeoForge 1.21.1's native, type-safe replacement for Capabilities. Seamless automatic serialization to NBT and automatic death-persistence options. |
| **Multiplayer Network Synchronization** | **NeoForge Payload Networking** (`CustomPacketPayload`) | Old SimpleChannel / Forge Network | Raw Netty Channels | **Selected: CustomPacketPayload**. Modern protocol using type-safe records, `Type<T>` identifiers, and `IPayloadHandler` routing. |

---

## 3. Final Stack Approval
All 6 chosen libraries are present in `CRB/libs/` and have been integrated into the root build classpath.
