# Hajime Kashimo — Summons & Entities Specification

## 1. Projectiles & Attached Entities
- **Nyoi Staff Entity (`crb:nyoi_staff`)**:
  - Entity type extending `AbstractArrow` or custom `Projectile`.
  - Properties: Can be thrown or driven into the earth; acts as a static lightning rod with position vector `(x, y, z)`.
  - Can store electrical charges transferred from Kashimo's strikes.
- **Lightning Arc Entity / Beam (`crb:lightning_discharge_beam`)**:
  - Multi-segment procedural entity rendering lightning arcs connecting Kashimo to target or staff.
  - Server-authoritative Raycast hitbox detecting intersection with any entities along the arc path.
- **Energy Orb Entity (`crb:kashimo_energy_orb`)**:
  - Fast-moving plasma ball with gravity decay and proximity detonation.
  - Explodes on collision with block or entity, triggering `ds:energy_orb_explode`.
- **Boss Entity (`crb:kashimo_boss`)**:
  - Implements SmartBrainLib AI with multi-phase transition:
    - Phase 1: Melee martial artist with Nyoi Staff and electrical charge buildup.
    - Phase 2: Lightning Cloak surge when HP drops below 60%.
    - Phase 3: Mythical Beast Amber transformation when HP reaches 20% or against Sukuna.
