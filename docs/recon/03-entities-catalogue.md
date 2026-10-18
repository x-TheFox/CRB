# Reconnaissance Report 03: Entities Catalogue

## 1. Overview
This catalogue documents all 317 entities defined within `JJA RP AND BP/Behaviour/JujutsuAwa/entities/`, categorizing them into:
1. **Bosses & Encounter Entities** (multi-phase fight structures)
2. **Cursed Spirit Mobs & Rogue Sorcerers** (graded enemy threats)
3. **Character Summons & Shikigami** (playable kit-bound entities)
4. **NPCs & Quest Brokers**
5. **Utility, Projectile & Hitbox Entities**

---

## 2. Boss Encounters

| Entity Identifier | Name / Encounter | Phase Structure | Bound Kit / System |
|-------------------|------------------|-----------------|---------------------|
| `ds:toji_boss` | Toji Fushiguro (Sorcerer Killer) | Phase 1: Inverted Spear + Playful Cloud melee rush. Phase 2: Glock ranged strafe + Split-Soul Katana armor piercing. Spawns inventory curse. | Heavenly Restriction Boss Encounter (`functions/mobs/toji/*`) |
| `ds:shikigami10` | Divine General Mahoraga | Continuously adapts to damage types via overhead wheel ticks (`adapttimer`, `adaptCD`). Heals to full and gains immunity upon 4 wheel spins. | Ten Shadows Summon & Boss (`functions/shikigami/*`) |
| `ds:yuji_itadori_awakened` | Awakened Yuji Itadori | High mobility, consecutive Black Flash combos (`blackflash_amount_special`), Soul Dismantles. | Yuji Kit & Boss (`functions/mobs/yuji*`) |
| `ds:student_gojo` / `ds:student_gojo2` | Teen Gojo | Neutral Infinity shield active, Lapse Blue suction, spatial blitzing. | Hidden Inventory Mission Boss (`functions/mobs/student_gojo*`) |
| `ds:astaroth` | Astaroth (Rift Overlord) | Multi-stage void rift boss; summons void eyes, reality tears, destabilizes void reactor. | Rift Raid System (`functions/rift_astaroth.mcfunction`) |
| `ds:benedictus` | Benedictus | Rift entity; casts heavy cosmic AoE beams and gravity wells. | Rift Raid System (`functions/rift_benedictus.mcfunction`) |
| `ds:duke` | Duke of Erisia | Custom JJA crossover boss; high posture guard, counter parries, gale sweeps. | Rift Raid System (`functions/duke*`) |
| `ds:kaiguy` | Kaiguy | Crossover rift boss; lightning blade rushes and thunder claps. | Rift Raid System (`functions/kaiguy*`) |

---

## 3. Cursed Spirit Mobs & Sorcerer Enemies

| Entity Identifier | Grade | Behaviors / Mechanics | Drop / Reward |
|-------------------|-------|------------------------|---------------|
| `ds:curse_warder_v1` | Grade 4 | Basic melee shambling, low health pool | Shoddy Cursed Remnant |
| `ds:curse_warder_v2` | Grade 3 | Agile lunging strikes, minor cursed energy bursts | Strong Cursed Remnant |
| `ds:curse_warder_v3` | Grade 2 | Heavy sweeping claws, knockback slams | Deadly Cursed Remnant |
| `ds:curse_warder_v4` | Grade 1 | High health, explosive palm blasts, evasive dashes | Superior Cursed Remnant |
| `ds:flyhead_bucket` / Flyheads | Grade 4 | Swarming nuisance entities, block player view | Flyhead Bucket |
| `ds:grasshopper` | Semi-Grade 2 | Leaping stomps, four-handed rapid punch barrage | Cursed Crystal |
| `ds:centipede` | Grade 2 | Segmented burrowing attacks, constriction | Rough Crystal |
| `ds:azure_flames` | Grade 1 | Blue fire projectiles, volcanic geysers | Cursed Crystal |
| `ds:kaiju` | Special Grade | Colossal cursed entity, ground slam shockwaves, massive HP | Undying Crystal, Special Grade Seal |
| `ds:sharko` | Special Grade | High damage, diving strikes, kick stun | Blitz Crystal |
| `ds:bayer_npc` | Sorcerer | Q-combat dagger strikes | Promotion Papers |
| `ds:kokun_npc` | Sorcerer | Dual blade slashes | Promotion Papers |

---

## 4. Character Summons & Shikigami (Kit-Bound)

### 4.1 Ten Shadows Technique (Megumi Fushiguro)
- `ds:shikigami1`: **Rabbit Escape** — Summons dozens of illusionary rabbits that overwhelm enemy line of sight and distract hitboxes.
- `ds:shikigami2`: **Toad (Gama)** — Stationary sentry entity; fires tongue grapple up to 20 blocks to reel enemies in and pin them.
- `ds:shikigami3`: **Divine Dogs (Shiro, Kuro & Totality)** — Pack hunters with aggressive tracking AI, pouncing on targets and executing bite combos.
- `ds:shikigami4`: **Nue** — Flying electric shikigami; swoops from above with electrified wings, shocking targets in place.
- `ds:shikigami5`: **Great Serpent (Orochi)** — Burrows beneath the target's feet, bursting upward to bite and launch them into the air.
- `ds:shikigami6`: **Ox Rush (Piercing Ox)** — Charges forward in an unbreakable straight line; damage scales quadratically with distance traveled.
- `ds:shikigami7`: **Max Elephant** — Summons massive weight from above; releases high-pressure torrents of water that wash enemies away.
- `ds:shikigami8`: **Round Deer (Madoka Deer)** — Emits positive cursed energy (RCT) in an aura around Megumi, healing wounds and disrupting curse constructs.
- `ds:shikigami11`: **Merged Beast: Agito** — Chimera fusion of Nue, Great Serpent, Tiger Funeral, and Round Deer. Electric tail strikes + self-regeneration.
- `ds:shikigami10`: **Eight-Handled Sword Divergent Sila Divine General Mahoraga** — The pinnacle of Ten Shadows. Wields the Sword of Extermination; adapts to any offensive phenomenon.

### 4.2 Idle Transfiguration (Mahito)
- `ds:stable_transfigured_human`: Distorted melee minions spawned from mutated souls; swarms enemies.
- `ds:unstable_transfigured_human`: Volatile human bombs; explodes upon contact or on death dealing soul damage.
- `ds:idle_transfig5`: Instant Spirit Body of Distorted Killing form overlay entity; grants 200% defense and blade appendages.

### 4.3 Judgeman (Hiromi Higuruma)
- `ds:judgeman`: Towering shikigami with scale eyes; hovers over the courtroom during Deadly Sentencing, reading evidence and determining the verdict (Guilty: Confiscation or Death Penalty).

### 4.4 Boogie Woogie (Aoi Todo)
- `ds:takada_chan_visible`: Visual delusion shikigami of idol Nobuko Takada; appears during Delusional Idol Fan mode to assist in combo strikes!

---

## 5. NPCs & Quest Brokers
- `ds:kusakabe`: Atsuya Kusakabe — Teaches New Shadow Style Simple Domain (`functions/kusakabe_teach.mcfunction`).
- `ds:watcher`: The Rift Watcher — Offers inter-dimensional bounties and rift access keys (`functions/watcher.mcfunction`).
- `ds:attractor`: Dimensional rift beacon and mission drop-off point.
- `ds:bayer_npc` & `ds:kokun_npc`: Cursed users stationed around worldgen structures.

---

## 6. Utility, Projectile & Hitbox Entities
- `ds:dismantle` / `ds:dismantle_quick`: Sukuna's invisible slashing projectile with forward raycast velocity.
- `ds:domain_barrier` / `ds:domain_barrier_inside` / `ds:domain_barrier_white`: Spherical shell barriers that isolate the domain interior.
- `ds:simple_domain`: Cylindrical barrier marker that grants anti-domain immunity.
- `ds:massive_knockback` / `ds:boss_knockback1`: Invisible impulse entities that exert physics force onto nearby entities.
- `ds:rock_wall` / `ds:rock_throw`: Earth manipulation collision blocks and thrown projectiles.
- `ds:pebble` / `ds:pebble_cutscene`: Cursed-energy infused stones thrown by Todo for Boogie Woogie coordinate swaps.
