# Hajime Kashimo — JJA Parity Matrix

| Feature / Move | JJA Implementation | CRB Java Implementation | Parity / Elevation Status |
| :--- | :--- | :--- | :--- |
| **Electrified CE Melee** | `lightning1a..c.mcfunction`, tag `lightningfists`, scoreboard `Hit`/`shocked` | Server data attachment `PlayerChargeData`, custom electric damage type bypassing armor | Elevated (Server-authoritative charge physics) |
| **Sure-Hit Lightning Bolt** | `lightningbolt1.mcfunction`, dummy target entity `LightningBoltTRG` | Direct mathematical vector raycast between player and target with 0 latency | Elevated (No fake target entity latency) |
| **Lightning Cloak** | `lightning_cloak.mcfunction`, objective `ltncloak` | Dynamic CE upkeep tick loop, Veil emissive shader aura, contact stun event | Elevated (Real dynamic shader bloom) |
| **Nyoi Staff Arc** | `functions/fighting/nyoistaff/`, `water_conduct.mcfunction` | Custom thrown weapon entity with planted state, arc-tracer line-of-sight check | Elevated (Realistic physics and electrolysis simulation) |
| **Mythical Beast Amber** | `beast_awaken.mcfunction`, `amber_end.mcfunction`, tag `mythicalbeastamber` | Timed transformation state, GeckoLib body morph, high-frequency sound blast, body disintegration | Elevated (True canon bodily disintegration mechanics) |
| **Amber Blast Moves (1-6)**| `lightning_am1..6.mcfunction` | Fully rendered Veil energy rays, sound cannons, and synchrotron radiation bursts | Elevated (Distinct VFX rather than reused particle blocks) |
| **Domain Expansion** | `kashimo_domain1.mcfunction`, scoreboard `domain` | Procedural Veil dome barrier, stormy skybox shader, server sure-hit loop | Elevated (Full client-side custom skybox & barrier shader) |
