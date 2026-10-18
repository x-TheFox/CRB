# Asset Strategy Record (ASR) — Jujutsu Awakening to Java Native Evolution

**Status**: **ACCEPTED & LOCKED**  
**Governing Law**: LAW 0.4 (The Addon is a Specification, Not Runtime Content)  
**Date**: 2026-10-18  
**Author**: Principal Systems Architect / Orchestrator  

---

## 1. Context & Architectural Mandate
In Bedrock Edition addons like Jujutsu Awakening (JJA), assets serve a dual role:
1. Pure sensory media (textures, sound events, models).
2. Runtime logic conduits (JSON-UI dummy bindings, particle emission timing hacks, dummy item identifiers for hotbar-based input triggers).

Under **LAW 0.4**, Bedrock logic is never ported literally. In Java Edition on NeoForge 1.21.1, input handling, particle emission, spatial sound propagation, and entity animations are handled natively via server-authoritative packets and client-side rendering engines (GeckoLib, Player Animation Lib, Veil). This record formalizes the lifecycle and migration strategy for every class of asset.

---

## 2. Asset Classification & Processing Strategy

| Asset Class | Bedrock Source | Java Mod Destination | Strategy | Rationale & Pipeline |
| :--- | :--- | :--- | :--- | :--- |
| **Sound Effects (SFX)** | `.fsb` / `.ogg` in Resource Pack (`sounds/`) | `assets/crb/sounds/` & `sounds.json` | **Transcode & Curate** | Convert Bedrock `.fsb` / raw audio to high-fidelity stereo 44.1kHz `.ogg`. Hook into `SoundEvent` registry with distance-attenuated 3D positioning. |
| **Entity Models & Geometries** | `geometry.json` (Bedrock format 1.12.0) | GeckoLib `geo/*.geo.json` | **Automated Transcoding** | Bedrock bone hierarchies are largely compatible with GeckoLib 4.9.3 format. Transcode bone pivots and cubes via automated script; adjust root bones for Java Player model attachment. |
| **Skeletal Animations** | `animation.*.json` | GeckoLib `animations/*.animation.json` & Player Animation Lib | **Transcode & Elevate** | Bedrock keyframe timelines are migrated to GeckoLib format for mobs/bosses, while player casting animations utilize Player Animation Lib (1.1.6+mc.1.21.1) for smooth client-side interpolation and posture blending. |
| **Particles & VFX** | Bedrock particle JSON (`particles/`) | Veil Shader Pipelines + Minecraft Native Particles | **Re-express Natively** | Bedrock particle emitters rely on fixed billboarding and CPU-heavy tick commands. High-impact Jujutsu VFX (Hollow Purple distortion, Malevolent Shrine slashes, Infinite Void horizon) are elevated to Veil 4.5.2 GLSL post-processing and compute shaders. |
| **Textures & Textures UVs** | `textures/` (`.png`) | `assets/crb/textures/` | **Retain & Upscale** | High-resolution entity skin textures (Sukuna markings, Gojo blindfold, Mahoraga wheel) are imported directly, ensuring strict visual fidelity to the anime/manga source. |
| **UI & HUD** | Bedrock JSON-UI (`ui/`) | YACL 3.8.2 + Custom GuiGraphics Overlay | **Architectural Re-write** | Bedrock font-based scoreboard UI hacks are purged. Replaced with native NeoForge `RenderGuiLayerEvent` rendering vector CE gauges, cooldown wheels, and Grade icons. |

---

## 3. Copyright, Licensing & Redistribution Principles
1. **Source Addon Attribution**: All creative inspirations, character geometries, and sound design derived from Jujutsu Awakening (JJA) are credited to their original creators under non-commercial modding fair-use principles.
2. **Clean-Room Logic**: 100% of the Java code, ability state machines, networking protocols, and domain mathematics are authored clean-room without copying proprietary Bedrock scripts.
3. **Distribution Packaging**:
   - The compiled release jar (`crb-1.0.0-alpha.jar`) contains native Java code, standard lang files, and core shader assets.
   - Heavy binary audio packs are modularized to ensure lightweight core downloads and rapid continuous integration builds.

---

## 4. Architectural Verification Gate
- All asset paths strictly conform to Minecraft resource conventions (`assets/<mod_id>/...`).
- Audio files use normalized peak amplitudes (-1.0 dBFS) to prevent audio clipping during multi-ability domain clashes.
- Model bones adhere to GeckoLib 4 naming conventions (`head`, `body`, `right_arm`, `left_arm`, `right_leg`, `left_leg`).
