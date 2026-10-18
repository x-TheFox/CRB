# Kinetic & Curse Absorption — JJA Parity Matrix

| Feature / Move | JJA Implementation | CRB Java Implementation | Parity / Elevation Status |
| :--- | :--- | :--- | :--- |
| **Damage Storage** | Scoreboard `absorption` incremented on hit | Server data capability `AbsorptionChargeAttachment` with active damage absorption mitigation | Elevated (True damage reduction rather than raw counter) |
| **Escalating Discharges** | `absorption1..7.mcfunction` | Scaled damage formulas directly reading current stored charge | Elevated (Seamless resource scaling) |
| **Plasma Beam** | `beam.mcfunction` using recursive positioning | Continuous Veil beam with raycast collision and screen shake | Elevated (Zero recursive function overhead) |
| **Supernova Nuke** | `absorption8.mcfunction`, `music.nuke`, `ds:turbo_intensity` | Free Camera cinematic director, camera ease, stereo audio sync, volumetric explosion | Elevated (State-of-the-art cinematic execution) |
| **Anti-Domain Art** | Basic status effects | Dedicated Falling Blossom Emotion responsive counter-trigger | Elevated (Strategic domain counter-play) |
