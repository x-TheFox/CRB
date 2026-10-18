# ADR-004: Camera Director & Cinematic Cutscene Engine

**Status**: **ACCEPTED**  
**Deciders**: Orchestrator (Autonomous Systems Architect)  
**Date**: 2026-10-18  

---

## 1. Context & Problem Statement
In JJA Bedrock, cinematics were achieved through the Bedrock `/camera` command, which suffers from jerky transitions, lack of customizable spline curves, and sudden snaps.
In CRB Java Edition, cinematics must capture anime-accurate visual intensity: dynamic perspective tracking, high-speed fly-bys during Black Flash beatdowns, wide pullback shots for Hollow Purple and Supernova, and intimate close-ups during domain hand signs.

---

## 2. Decision: Hybrid Free Camera API & Client Director

### 2.1 Core Subsystems
1. **`ClientCameraDirector`**:
   - Manages camera state transitions: `NORMAL_FIRST_PERSON`, `NORMAL_THIRD_PERSON`, `CINEMATIC_ORBIT`, `SCRIPTED_SPLINE_DETACH`.
   - Listens for server cues (`ClientboundCameraCuePayload`).
2. **Spline Easing Curves**:
   - Utilizes cubic bezier and circular easing curves (`easeInCirc`, `easeInOutQuad`, `easeOutBack`) to emulate MAPPA camera dynamics.
3. **Screen Shake System**:
   - Rotational and translational camera shake with decay formulas:
     `offset = PerlinNoise(time * frequency) * amplitude * exp(-decay * time)`
4. **Impact Frames (`ImpactFrameRenderer`)**:
   - 1 to 2 frame monochrome flash: inverts colors or renders stylized comic-book ink silhouettes on direct critical Black Flash impacts.

---

## 3. Disconnect & Safety Protocol (Law 0.5)
- If a player takes damage, disconnects, dies, or enters combat while their camera is detached in a cinematic, the camera is **immediately snapped back** to first-person view in 1 tick, preventing disorientation or exploits.
