# Megumi Fushiguro — Domain Expansion: Chimera Shadow Garden (嵌合暗翳庭)

## 1. Concept & Canon Reference
- **Name**: Chimera Shadow Garden (嵌合暗翳庭, Kangō An'eitei)
- **Canon Ref**: Jujutsu Kaisen Chapter 58 (vs. Finger Bearer), Chapters 170–172 (vs. Reggie Star)
- **Core Concept**: An "incomplete" domain. Because Megumi lacks the barrier refinement to close off an artificial outer shell in empty space, he uses enclosed existing physical architecture (caves, gymnasiums, buildings) as the outer boundary. The floor becomes an infinite liquid sea of shadows, granting 120% potential to all Ten Shadows techniques.

---

## 2. JJA Bedrock Mechanics & Forensic Evidence
- **Trigger**: `items/10shadows/shikigami12.json`
- **Execution Pipeline**: `functions/shikigami/chimera_garden1.mcfunction`, `functions/shikigami/shadow_garden.mcfunction`
- **Terrain Alteration**: Replaces ground blocks within 40 blocks with shadow fluid tiles.
- **Multiple Summons**: Bypasses the active shikigami count limit, allowing simultaneous deployment of Max Elephant, Nue, Toad, and Divine Dogs.

---

## 3. Java-Native Evolution (CRB Architecture)

### 3.1 Incomplete Domain Architecture
- **Structure Dependency**: If cast inside an enclosed building or underground, Chimera Shadow Garden attains 100% stability. If cast in open air, it functions as a localized 40-block shadow swamp without an outer barrier, allowing enemies to leap out unless held down.
- **Liquid Shadow Physics**:
  - Non-allied entities standing on the shadow floor sink up to their knees.
  - Movement speed reduced by 60%; jump height reduced by 80%.
  - Falling objects and dropped items are swallowed into Megumi's shadow inventory!

### 3.2 Shadow Clones & Emergence
- Megumi can press Attack to instantly submerge into the floor and emerge behind any enemy.
- Spawns up to 3 shadow doubles of Megumi that mirror his weapon strikes and absorb incoming hits before dissolving into black liquid.
- Allows summoning duplicate shikigami (e.g. 2 Nues, 3 Toads) without additional CE cost!
