# Megumi Fushiguro — Abilities & Kit Specification

## 1. Shikigami Arsenal (十種影法術)

### 1.1 Divine Dogs: Shiro, Kuro & Totality (玉犬)
- **Canon ref**: Chapters 1, 47 / Episodes 1, 19
- **JJA implementation**: `items/10shadows/shikigami1 - Copy - Copy.json` (`ds:shikigami3`), `functions/shikigami/shikigami3.mcfunction`.
- **Cost / Cooldown**: 30 CE / 4s cooldown.
- **Behavior**: Summons two agile canines with scent tracking; when Shiro dies, Kuro transforms into **Divine Dog: Totality (玉犬「渾」)**, gaining colossal claws that can slice special-grade curses.

### 1.2 Toad / Gama (蝦蟇)
- **Canon ref**: Chapter 5, 44 / Episodes 4, 17
- **JJA implementation**: `items/10shadows/shikigami1 - Copy.json` (`ds:shikigami2`).
- **Cost / Cooldown**: 25 CE / 3s.
- **Behavior**: Fires an elastic tongue up to 20 blocks away to latch onto enemies or pull Megumi to safety.

### 1.3 Nue (鵺)
- **Canon ref**: Chapter 5, 214 / Episodes 4, 24
- **JJA implementation**: `items/10shadows/shikigami1 - Copy - Copy - Copy.json` (`ds:shikigami4`), `functions/shikigami/nue_bolt.mcfunction`, `nue_flap.mcfunction`.
- **Cost / Cooldown**: 50 CE / 6s.
- **Behavior**: Flying owl-winged chimera; discharges electric lightning from its wings and dives onto enemies.

### 1.4 Great Serpent / Orochi (大蛇)
- **Canon ref**: Chapter 9 / Episode 4
- **JJA implementation**: `items/10shadows/shikigami1 - Copy - Copy - Copy - Copy.json` (`ds:shikigami5`).
- **Cost / Cooldown**: 40 CE / 8s.
- **Behavior**: Bursts from the shadows beneath target's feet, coiling and launching them into the air.

### 1.5 Max Elephant (満象)
- **Canon ref**: Chapter 44, 215 / Episode 17
- **JJA implementation**: `items/10shadows/shikigami1 - Copy - Copy - Copy - Copy - Copy - Copy.json` (`ds:shikigami7`).
- **Cost / Cooldown**: 80 CE / 12s.
- **Behavior**: Summons massive weight from above; expels high-pressure torrents of water washing enemies away.

### 1.6 Rabbit Escape (脱兎)
- **Canon ref**: Chapter 110, 215 / Season 2 Episode 14
- **JJA implementation**: `items/10shadows/shikigami1.json` (`ds:shikigami1`).
- **Cost / Cooldown**: 20 CE / 5s.
- **Behavior**: Summons an immense swarm of hundreds of white rabbits, blinding the enemy's screen and providing cover for escape.

### 1.7 Piercing Ox (貫牛)
- **Canon ref**: Chapter 218
- **JJA implementation**: `items/10shadows/shikigami1 - Copy - Copy - Copy - Copy - Copy.json` (`ds:shikigami6`).
- **Cost / Cooldown**: 60 CE / 10s.
- **Behavior**: Charges in a rigid straight line; damage scales exponentially with distance traveled.

### 1.8 Round Deer / Madoka Deer (円鹿)
- **Canon ref**: Chapter 218
- **JJA implementation**: `items/10shadows/shikigami1 - Copy - Copy - Copy - Copy - Copy - Co - Copy.json` (`ds:shikigami8`).
- **Cost / Cooldown**: 100 CE / 15s.
- **Behavior**: Emits continuous positive cursed energy (RCT), healing Megumi and allies while neutralizing enemy cursed energy constructs.

### 1.9 Merged Beast: Agito (嵌合獣「 agitation 」)
- **Canon ref**: Chapters 230–235
- **JJA implementation**: `items/10shadows/shikigami11.json` (`ds:shikigami11`).
- **Cost / Cooldown**: 250 CE / 30s.
- **Behavior**: Chimera fusion of Nue, Great Serpent, Tiger Funeral, and Round Deer. Boasts extreme agility, lightning tail attacks, and continuous self-healing.

### 1.10 Divine General Mahoraga (八握剣異戒神将魔虚羅)
- **Canon ref**: Chapters 117–119, 230–236 / Season 2 Episode 17
- **JJA implementation**: `items/10shadows/shikigami10.json` (`ds:shikigami10`), `mahoraga_wheel.json` (`ds:mahoragawheel`), `shadow_wheel.json`.
- **Cost / Cooldown**: 400 CE / Ritual Untamed or 180s Cooldown when Tamed.
- **Behavior**:
  - The ultimate shikigami. Wields the Sword of Extermination.
  - **Adaptation (適応)**: The eight-handled wheel floats above Mahoraga's (or Megumi's) head.
  - Every time Mahoraga receives damage, the wheel clicks (`adapttimer`).
  - Upon 4 wheel clicks: gains 100% complete immunity to that damage type and counter-adapts its attacks to slice through the opponent's defenses!

---

## 2. Shadow Arts: Storage & Submersion
- **Shadow Inventory**: Store items and weapons inside one's own shadow (`functions/shikigami/shadow_storage.mcfunction`).
- **Shadow Submersion**: Sink into the shadow floor, becoming invulnerable and moving undetected beneath the surface.

---

## 3. Domain Expansion: Chimera Shadow Garden (嵌合暗翳庭)
- **Canon ref**: Chapter 58, 170–172 / Episode 23
- **JJA implementation**: `items/10shadows/shikigami12.json`, `functions/shikigami/chimera_garden1.mcfunction`, `shadow_garden.mcfunction`.
- **Cost / Cooldown / Duration**: 350 CE / 180s / 30s.
- **Behavior**:
  - Covers the entire arena floor in a deep, fluid shadow ocean.
  - Enemies sink into the shadows; their weight drag increases by 300%.
  - Megumi can manifest endless clone illusions of himself and his shikigami from any point on the shadow floor simultaneously.
