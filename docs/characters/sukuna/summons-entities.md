# Ryomen Sukuna — Summons & Spawned Entities

## 1. Entity Registry & Role

| Identifier | Name | Lifecycle | AI / Physics Behavior |
|------------|------|-----------|------------------------|
| `ds:dismantle` / `ds:dismantle_quick` | Dismantle Slicing Projectile | 2 seconds | Linear raycast projectile; velocity 4.5–7.0 blocks/tick; breaks fragile blocks and applies sharp damage. |
| `ds:fuga_arrow` | Divine Flame Arrow | 3 seconds | Ballistic projectile with parabolic arc; creates 20-block explosive crater and incendiary zone upon collision. |
| `ds:malevolent_shrine` | Malevolent Shrine Center Monument | 40 seconds (domain duration) | Monumental center structure; non-targetable; serves as the geometric origin for the 200-block sure-hit field. |
| `ds:red_tint_shrine` | Environmental Red Skybox Marker | 40 seconds | Environmental aura entity that projects the apocalyptic crimson skybox filter to all clients within 250 blocks. |
| `ds:hiten_spear` / `ds:lost_hiten` | Legendary Trident Hiten | Persistent item entity | Sukuna's legendary cursed weapon; grants wide-radius cleave whirlwinds. |
| `ds:kamutoke` | Vajra Dagger Kamutoke | Equipment | Channeling weapon that discharges lightning bolts without cursed energy cost. |
| `ds:mahoragaboss` / `ds:mahoragatamed` | Eight-Handled Wheel Mahoraga | Active under Meguna | Summoned when Sukuna takes over Megumi's body; carries the adaptation wheel above Sukuna's head! |

## 2. Server Authority & Cleanup
The Malevolent Shrine center monument is tracked by server chunk tickets. When domain duration expires or Sukuna is incapacitated, the monument collapses with particle dust and the 200m slicing loop terminates immediately.
