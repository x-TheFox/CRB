# Reconnaissance Report 00: Addon Inventory & Scope Lock

## 1. Executive Summary
This report establishes the forensic baseline for the **Jujutsu Awakening (JJA) — The Domain Update** Bedrock addon, serving as the behavioral specification, asset registry, and scope definition for **Cursed Reality: Boundless (CRB)** on Minecraft Java Edition 1.21.1 (NeoForge).

- **Addon Name**: Jujutsu Awakening | The Domain Update
- **Author**: Heroic Productions (Magroic & Heroic Maps)
- **Behaviour Pack (BP)**: Version 0.1.0 (`f8ab221b-b6db-452f-ab09-de6621f45bc8`), Min Engine 1.20.30
- **Resource Pack (RP)**: Version 1.0.4 (`ec62e8d2-e2b1-4af8-a311-6a7263c78642`), Min Engine 1.20.80
- **Script Dependencies**: `@minecraft/server` v1.7.0, `@minecraft/server-ui` v1.3.0

---

## 2. Directory Inventory

### 2.1 Behaviour Pack (`JJA RP AND BP/Behaviour/JujutsuAwa`)
| Directory / File | File Count | Purpose |
|------------------|------------|---------|
| `animation_controllers/` | 2 | Entity and player state transitions / tick event dispatchers |
| `blocks/` | 52 | Custom domain barriers, rift components, and altar blocks |
| `entities/` | 317 | Hitboxes, projectiles, summons, bosses, NPCs, visual dummies |
| `feature_rules/` | 20 | Worldgen feature placement rules for JJK structures |
| `features/` | 20 | Structure feature definitions (cursed schools, rifts, boss arenas) |
| `functions/` | 1937 | Core execution logic: character kits, combat bus, scoreboards, damage |
| `items/` | 229 | Technique selectors, ability triggers, cursed tools, consumables, relics |
| `loot_tables/` | 58 | Mob drops, boss rewards, finger drops, relic chests |
| `recipes/` | 18 | Crafting recipes for cursed tools, armor, and utility items |
| `scripts/` | 2 | `index.js` (UI forms, projectile spawns, script events) & `domain_clashing.js` |
| `spawn_rules/` | 29 | Natural entity spawning rules for curses and sorcerers |
| `structures/` | 93 | `.mcstructure` binary templates for arenas, domain barriers, and shrines |
| `worldgen/` | 59 | Biome modifiers and structure placement parameters |
| `manifest.json` | 1 | Pack header, modules, dependencies |

### 2.2 Resource Pack (`JJA RP AND BP/Resource/JujutsuAwa`)
| Directory / File | File Count | Purpose |
|------------------|------------|---------|
| `animation_controllers/` | 34 | Client-side visual state controllers for entities, player stances |
| `animations/` | 149 | Skeletal animations for abilities, stances, summons, cutscenes |
| `attachables/` | 215 | First-person and third-person held/worn models and VFX rigs |
| `blocks.json` | 1 | Block model and texture mapping |
| `entity/` | 257 | Client entity definitions linking geometry, textures, and animations |
| `font/` | 11 | Custom glyph mappings for full-screen cinematics, actionbar UI, logos |
| `materials/` | 2 | Material render definitions (translucency, glowing, shaders) |
| `models/` | 367 | Bedrock geometry models (`.geo.json`) for mobs, weapons, domains, VFX |
| `particles/` | 3475 | Molang particle emitters for aura, slashes, fire, lightning, domains |
| `render_controllers/` | 82 | Render controllers for conditional textures, geometries, and glows |
| `sounds/` | 416 | Audio files (`.ogg`, `.mp3`, `.wav`) for abilities, voice lines, domains |
| `sounds.json` | 1 | Sound event definitions and subtitle mappings |
| `textures/` | 1101 | Textures for items, mobs, armor, particle sprites, UI sheets |
| `ui/` | 8 | JSON-UI definitions and form styling |
| `manifest.json` | 1 | Pack header, resources module |

---

## 3. Namespace Conventions
- **Addon Namespace**: `ds:` (e.g., `ds:limitless1`, `ds:sukuna_technique`, `ds:dismantle`)
- **Vanilla Namespace**: `minecraft:` (e.g., `minecraft:item`, `minecraft:entity`)
- **NPC Namespace**: `npc:` (e.g., `npc:npc_custom`)

---

## 4. Scope Lock Statement (LAW 0.3 Binding Authority)

In accordance with **CONSTITUTION LAW 0.3 (SCOPE LOCK)**, the following **14 Character Kits / Techniques** and **4 Minor Techniques** discovered within the JJA addon files constitute the **exclusive and exhaustive playable roster** for *Cursed Reality: Boundless*. No character or technique outside this verified roster shall be implemented.

### 4.1 Primary Playable Character Kits
1. **Satoru Gojo** — Limitless & Six Eyes (`limitless`)
2. **Ryomen Sukuna** — Shrine / Dismantle & Cleave / Open: Divine Flame / Heian Transformation (`sukuna`)
3. **Yuji Itadori** — Soul Shrine / Divergent Fist / Black Flash (`yuji`)
4. **Megumi Fushiguro** — The Ten Shadows Technique (`10shadows` / `shikigami`)
5. **Jogo** — Disaster Flames Technique (`disaster_flames` / `flames`)
6. **Mahito** — Idle Transfiguration Technique (`c_idle_transfig` / `idle_transfig`)
7. **Hajime Kashimo** — Electrified Cursed Energy & Mythical Beast Amber (`kashimo`)
8. **Hiromi Higuruma** — Judgeman Technique (`judgeman`)
9. **Aoi Todo** — Boogie Woogie Technique & Delusional Idol Combat (`boogie_woogie`)
10. **Kinji Hakari** — Private Pure Lovetrain Technique / Idle Death Gamble (`lovetrain`)
11. **Toji Fushiguro / Maki Zenin** — Heavenly Restriction: Unmeasured Strength (`heavenly_restriction` / `hr`)
12. **Toge Inumaki** — Cursed Speech Technique (`speech`)
13. **Finger Bearer** — Explosive Cursed Energy (`explosiveenergy` / `explosive`)
14. **Absorption** — Kinetic Damage Absorption & Energy Release (`absorption`)

### 4.2 Minor / Support Cursed Techniques
1. **Haruta Shigemo** — Miracles Technique (`miracles`)
2. **Charles Bernard** — Wind-Up Technique (`windup`)
3. **Alleviation** — Pain-Killer Technique (`painkiller`)
4. **Immobilizing Sight** — Paralyzing Gaze Technique (`sight`)

### 4.3 Out of Scope / Unreleased Addon Stubs
- `ds:blood_manipulation`: Found in `yuji/blood_manipulation.json`, explicit tooltip says `[ NOT RELEASED / MADE ]`. (To be canon-completed under Yuji's kit via §5.4).
- `ds:omega_scythe`: Explicit tooltip states `Item is not yet developed...`. Excluded per LAW 0.3/§13.
- `ds:queen_of_curses`: Exotic slot 3 tooltip says `Queen of Curses + Copy (Unreleased)`. Functionality absent; excluded from roster per LAW 0.3.
