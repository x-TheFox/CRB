# Finger Bearer / Explosive Energy — Summons & Entities Specification

## 1. Entities & Bosses
- **Finger Bearer Boss Entity (`crb:finger_bearer_boss`)**:
  - Implements SmartBrainLib AI with 2 variations:
    - **Detention Center Variant (Finger Bearer 1)**: More primitive, relies heavily on high-speed ambushes, ground slams, and raw palm blasts.
    - **Yasohachi Bridge Variant (Finger Bearer 2)**: Smarter, keeps distance, utilizes homing finger arrows and full Mugetsu beams.
  - Drops **Ryomen Sukuna's Finger** (`crb:sukuna_finger`) upon defeat.
- **Energy Arrow Projectile (`crb:finger_arrow`)**:
  - Supersonic piercing entity that leaves purple particle contrails and passes through shields.
- **Mugetsu Beam Entity (`crb:mugetsu_beam`)**:
  - Continuous cylinder raycast entity dealing multi-tick damage along its axis.
