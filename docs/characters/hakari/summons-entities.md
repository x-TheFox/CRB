# Kinji Hakari — Summons & Entities Specification

## 1. Entities & Props
- **Train Shutter Door Entity (`crb:shutter_door`)**:
  - Two opposing metallic door models that spawn 4 blocks apart, slide toward each other in 6 ticks, and despawn after 25 ticks.
  - Possesses solid collision box that blocks movement and reflects projectiles.
- **Pachinko Ball Projectile (`crb:pachinko_ball`)**:
  - Steel sphere entity with elastic bouncing physics (`restitution = 0.85`), striking enemies up to 3 times before losing kinetic energy.
- **Freight Cargo Container Entity (`crb:cargo_container`)**:
  - Falling physics block / entity that drops from 15 blocks above, crushing anything beneath it.
- **Boss Entity (`crb:hakari_boss`)**:
  - SmartBrainLib AI that immediately expands Idle Death Gamble if CE permits.
  - During Jackpot mode:
    - AI switches to hyper-aggressive, fearless melee rushdown.
    - Completely ignores player attacks, marching directly forward while dancing to the music.
