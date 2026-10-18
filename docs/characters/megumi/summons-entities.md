# Megumi Fushiguro — Summons & Spawned Entities

## 1. Complete Shikigami Entity Catalogue

| Identifier | Name | HP / Armor | AI Archetype (SmartBrainLib) | Lifecycle & Despawn |
|------------|------|------------|------------------------------|----------------------|
| `ds:shikigami1` | Rabbit Escape | 1 HP each (50 entities) | Swarm dispersion AI; circles enemies to obstruct crosshair | 10 seconds or until cleared |
| `ds:shikigami2` | Toad (Gama) | 40 HP | Stationary turret / grapple AI; reels targets in | Dismissed on command or death |
| `ds:shikigami3` | Divine Dog: Totality | 75 HP, 10 Armor | Pounce hunter; tracks wounded targets, shreds guard | Permanent until defeated |
| `ds:shikigami4` | Nue | 60 HP | Aerial strafing flyer; dives and shocks | Despawns if wings damaged |
| `ds:shikigami5` | Great Serpent | 80 HP | Subterranean bursting snake; coils target | Burst attack (5s duration) |
| `ds:shikigami6` | Piercing Ox | 100 HP, 15 Armor | Unstoppable linear charge; cannot turn | Dismissed upon wall impact |
| `ds:shikigami7` | Max Elephant | 120 HP | Heavy stomper; water pressure artillery | Despawns if CE pool depleted |
| `ds:shikigami8` | Round Deer | 90 HP | Passive support; emits healing RCT aura | Stays close to Megumi |
| `ds:shikigami11` | Merged Beast: Agito | 200 HP, 12 Armor | Elite boss AI; agile leaps, tail whips, regeneration | Summoned only with high CE |
| `ds:shikigami10` | Divine General Mahoraga | 350 HP, 20 Armor | Ultimate juggernaut; adapts to damage types | Untamed: attacks all. Tamed: obeys Megumi |

## 2. Death & Inheritance Rules (Totality Mechanics)
When a basic shikigami dies in combat (e.g. Divine Dog White), it enters an inherited state. Its essence is permanently merged into its counterpart (Divine Dog Black becomes Totality), altering its model, stats, and attack patterns permanently.
