# Jogo — Summons & Spawned Entities

## 1. Entity Registry & Role

| Identifier | Name | Lifecycle | AI / Physics Behavior |
|------------|------|-----------|------------------------|
| `ds:ember_insect` | Ember Insect Familiar | 5 seconds | Flying homing projectile; tracks targets and detonates on collision. |
| `ds:meteor_entity` | Maximum Meteor Entity | 4 seconds | Giant descending physics entity; destroys blocks and explodes on ground contact. |
| `ds:volcano_geyser` | Ground Volcano Spire | 6 seconds | Stationary block-pillar entity erupting continuous fire and lava particles upward. |
| `ds:domain_barrier` (tagged `IronMountain`) | Coffin of the Iron Mountain Barrier | 30 seconds | 66-block spherical barrier enclosing volcanic interior dimension. |
| `ds:jogo` | Jogo Boss Sorcerer | Persistent until defeated | Boss entity exercising complete Disaster Flames moveset and domain expansion. |
