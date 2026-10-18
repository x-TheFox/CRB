# Cursed Reality: Boundless (CRB)

[![Minecraft 1.21.1](https://img.shields.io/badge/Minecraft-1.21.1-brightgreen.svg)](https://minecraft.net/)
[![NeoForge 21.1.93](https://img.shields.io/badge/NeoForge-21.1.93-orange.svg)](https://neoforged.net/)
[![Java 21](https://img.shields.io/badge/Java-21-blue.svg)](https://adoptium.net/)
[![Build Status](https://img.shields.io/badge/Build-Passing-brightgreen.svg)]()
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

> **The definitive, server-authoritative Jujutsu Kaisen combat mod for Minecraft Java Edition 1.21.1 on NeoForge.**  
> Built as the native Java evolution and elevation of the acclaimed *Jujutsu Awakening (JJA)* Bedrock addon.

---

## 🌟 Highlights & Philosophy

- **Zero-Compromise Multiplayer Safety**: Built from the ground up to be 100% server-authoritative. Abilities, spatial attraction vectors, cursed energy accounting, technique burnout, and domain boundaries run securely on dedicated servers with zero client trust.
- **Mathematical Domain Clashing Engine**: Implements authentic Jujutsu domain dynamics. Supports 66m closed barrier spheres, 200m open barriers (*Malevolent Shrine*), violence-neutral courtroom zones (*Deadly Sentencing*), and real-time refinement clash resolution ($|\Delta R| > 50$ shatters inferior domains).
- **Elevated Canon Mechanics**: Replaces Bedrock command/item-bus limitations with fluid Java state machines, multi-stage combo inputs, $E^{2.5}$ non-linear Black Flash damage streaks, True Soul strikes, and Six Eyes atomic CE conservation ($0.001\times$ cost multiplier).
- **Cinematic Rendering & Shaders**: Engineered for integration with Veil 4.5.2 post-processing compute shaders, Free Camera API 2.1.1 choreography, GeckoLib 4.9.3 skeletal animations, and Player Animation Lib 1.1.6.

---

## 🥋 Playable Character Roster & Technique Matrix

Every character discovered in the JJA addon has been faithfully ported and elevated:

| Character | Innate Technique / Category | Signature Abilities & Domains | Canon Upgrades |
| :--- | :--- | :--- | :--- |
| **Satoru Gojo** | *Limitless* (Infinity) | `lapse_blue`, `hollow_purple`, `infinite_void` | Spatial attraction vector physics, imaginary mass erasure, Six Eyes $0.001\times$ CE consumption |
| **Ryomen Sukuna** | *Shrine* (Cutting / Fire) | `dismantle`, `cleave`, `fire_arrow`, `world_cutting_slash`, `malevolent_shrine` | Dynamic target toughness adaptation, unblockable World Bisecting Slash, 200m open barrier domain |
| **Yuji Itadori** | *Divergent Fist & Shrine* | `divergent_fist`, `black_flash`, `piercing_blood` | Delayed cursed energy double-impact, non-linear $E^{2.5}$ consecutive streak scaling, sonic blood beam |
| **Megumi Fushiguro** | *Ten Shadows Technique* | `ten_shadows_summon`, `mahoraga_ritual`, `chimera_shadow_garden` | Pack-tactics Divine Dog Totality, Eight-Handled Sword Mahoraga subjugation ritual, fluid shadow sea domain |
| **Jogo** | *Disaster Flames* | `disaster_flames`, `maximum_meteor`, `coffin_iron_mountain` | Earth-rupturing volcanic vents, high-altitude calamitous meteor impact, enclosed mountain domain |
| **Mahito** | *Idle Transfiguration* | `idle_transfiguration`, `self_embodiment_perfection` | Direct soul manipulation ignoring physical armor, 0.2-second rapid-deployment hand-palm domain |
| **Hajime Kashimo** | *Mythical Beast Amber* | `lightning_discharge`, `mythical_beast_amber` | Sure-hit electric charge buildup, irreversible transcendent flesh reconstruction state |
| **Hiromi Higuruma** | *Deadly Sentencing* | `deadly_sentencing`, `executioner_sword` | Non-lethal courtroom domain prohibiting all violence, Judgeman trial mechanics, lethal one-hit Executioner Blade |
| **Aoi Todo** | *Boogie Woogie* | `boogie_woogie`, `simple_domain` | Instantaneous acoustic positional swapping with entities, New Shadow Style anti-barrier domain protection |
| **Kinji Hakari** | *Idle Death Gamble* | `idle_death_gamble` | Pure Love Train pachinko domain sequence, Jackpot mode granting infinite CE and auto-RCT invulnerability |
| **Toji & Maki** | *Heavenly Restriction* | `inverted_spear`, `soul_split_katana` | Absolute 0 CE immunity, forced cursed technique nullification, direct soul durability bypass |
| **Toge Inumaki** | *Cursed Speech* | `cursed_speech` | Compulsory sonic commands (*Don't Move*, *Blast Away*, *Plummet*) balanced with throat damage backlash |
| **Finger Bearer** | *Raw Cursed Energy* | `mugetsu_beam` | High-density concentrated unrefined CE beam with devastating kinetic knockback |
| **Geto / Kenjaku** | *Curse Absorption* | `supernova_detonation` | Condensed cursed spirit spatial explosion with cascading secondary blasts |
| **Minor CTs** | *Haruta, Charles, etc.* | `haruta_miracle` | Automatic miracle consumption negating fatal damage, future vision combat prediction |

---

## 🛠️ In-Game Commands (`/jjk`)

All abilities and systems can be inspected, tested, and configured via native Brigadier commands (requires operator permission level 2):

```bash
# Cursed Energy & Progression
/jjk energy set <amount>                 # Set current CE pool (e.g., 5000)
/jjk grade set <GRADE_4|GRADE_3|GRADE_2|GRADE_1|SPECIAL_GRADE>
/jjk trait set <SIX_EYES|HEAVENLY_RESTRICTION|ELECTRIFIED_CE|ROUGH_CE|NONE>
/jjk clan set <GOJO|ZENIN|KAMO|INUMAKI|ITADORI|NONE>

# Combat Mechanics & Burnout
/jjk burnout apply <ticks>              # Inflict Technique Burnout
/jjk burnout clear                      # Instantly restore burned out cursed techniques
/jjk domain clear                       # Instantly dissolve all active domains in the world

# Ability Execution
/jjk ability list                       # Display all 31 registered Jujutsu techniques and costs
/jjk ability cast <ability_id>          # Cast any ability server-side (e.g., crb:hollow_purple)
```

---

## 🏗️ Architecture & Documentation

Comprehensive architectural design records and engineering reports are preserved in `/docs/`:

- **Forensic Reconnaissance**:
  - [`docs/recon/00-inventory.md`](docs/recon/00-inventory.md): Full JJA addon asset & file inventory.
  - [`docs/recon/01-architecture-of-the-addon.md`](docs/recon/01-architecture-of-the-addon.md): Reverse engineering of Bedrock command buses.
  - [`docs/recon/02-systems-catalogue.md`](docs/recon/02-systems-catalogue.md): Cursed energy, grades, and traits catalogue.
  - [`docs/recon/03-entities-catalogue.md`](docs/recon/03-entities-catalogue.md): Complete mob, boss, and projectile taxonomy.
- **Character Dossiers**:
  - [`docs/characters/`](docs/characters/): 135 technical dossiers across 15 directories with anime/manga citations.
- **Architectural Decision Records (ADRs)**:
  - [`docs/architecture/ADR-001-ability-engine.md`](docs/architecture/ADR-001-ability-engine.md): Stateful Ability Pipeline.
  - [`docs/architecture/ADR-002-cursed-energy-and-progression.md`](docs/architecture/ADR-002-cursed-energy-and-progression.md): Attachment-Based CE & Grades.
  - [`docs/architecture/ADR-003-payload-networking.md`](docs/architecture/ADR-003-payload-networking.md): Immutable CustomPacketPayload Netcode.
  - [`docs/architecture/ADR-004-camera-director.md`](docs/architecture/ADR-004-camera-director.md): Free Camera Choreography & Cinematics.
  - [`docs/architecture/ADR-005-domain-expansion-and-clashing.md`](docs/architecture/ADR-005-domain-expansion-and-clashing.md): Domain Barrier Mathematics.
- **Asset & Tech Stack Records**:
  - [`docs/research/tsdr.md`](docs/research/tsdr.md): Tech Stack Decision Record & Six Library Pillars.
  - [`docs/research/asset-strategy-record.md`](docs/research/asset-strategy-record.md): Bedrock-to-Java Asset Evolution.
- **Gate Reports**:
  - [`docs/operations/gate-reports/`](docs/operations/gate-reports/): Formal sign-off reports for Gates G1 through G5.

---

## 💻 Building & Developing

### Prerequisites
- **Java Development Kit (JDK) 21** (Temurin 21 recommended)
- **Gradle 8.10+** (included via `./gradlew` wrapper)
- **Git**

### Compilation & Testing
```bash
# Clone the repository
git clone https://github.com/x-TheFox/CRB.git
cd CRB

# Compile Java sources
./gradlew compileJava

# Run the full JUnit 5 unit test suite (15/15 tests)
./gradlew test

# Build production mod jar
./gradlew build
```
The output jar will be located at `build/libs/crb-1.0.0-alpha.jar`.

### Launching Development Clients & Servers
```bash
# Launch singleplayer client with mod loaded
./gradlew runClient

# Launch dedicated test server
./gradlew runServer
```

---

## 📜 Operating Contract & Governance
This project is governed by strict autonomous engineering standards:
- **Zero-Question Policy (LAW 0.1)**: Fully autonomous systems engineering, test-driven validation, and empirical decision-making.
- **Scope Lock (LAW 0.3)**: Strictly bound to the verified Jujutsu Awakening roster, elevated to Java native standards.
- **Multiplayer Safety (LAW 0.5)**: Dedicated-server authoritative combat logic; zero client-trusted states.
- **GitOps Doctrine (LAW 0.6)**: Conventional commits, modular feature branches, and verified continuous integration builds.

---

## ⚖️ License
Released under the [MIT License](LICENSE). Jujutsu Kaisen characters, concepts, and names are the intellectual property of Gege Akutami / Shueisha / MAPPA. Built for educational and non-commercial modding use.
