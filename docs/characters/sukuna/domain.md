# Ryomen Sukuna — Domain Expansion: Malevolent Shrine (伏魔御厨子)

## 1. Concept & Canon Reference
- **Name**: Malevolent Shrine (伏魔御厨子, Fukuma Mizushi)
- **Canon Ref**: Jujutsu Kaisen Chapters 118–119, 225–230; Anime Episode 4, Season 2 Episode 17
- **Core Concept**: An unprecedented "divine feat" of domain expansion. Unlike ordinary domains that construct an enclosed barrier to isolate space, Malevolent Shrine paints its domain canvas directly onto physical reality without a barrier. By binding itself to allow an escape route, a Binding Vow massively magnifies the sure-hit operational radius to a devastating **200 meters** (200 blocks).

---

## 2. JJA Bedrock Mechanics & Forensic Evidence
- **Trigger**: `items/sukuna/sukuna3.json`
- **Execution Pipeline**: `functions/sukuna/attacks/dismantles/malevolentshrine.mcfunction`, `functions/sukuna/shrine_tick.mcfunction`
- **Radius**: Explicitly sets `r=200` in `_scores.mcfunction` L18 and L20.
- **Continuous Sure-Hit**:
  - Targets with Cursed Energy: bombarded by Cleave (`damages/cleave_tick.mcfunction`).
  - Inanimate Objects / Terrain: relentlessly cleaved by Dismantle until leveled to dust.
- **Center Monument**: Summons `ds:malevolent_shrine` structure at the caster's coordinates.

---

## 3. Java-Native Evolution (CRB Architecture)

### 3.1 Open-Barrier Geometric Engine
- **No Outer Wall**: Players and mobs can physically walk, sprint, or fly into and out of the 200-block boundary.
- **Atmospheric Transformation**: Skybox fades into a stormy crimson red; ground is scarred with thousands of random slashing decals; air is choked with swirling dust and blood mist.
- **Center Monument**: Spawns a high-fidelity GeckoLib 3D Buddhist temple adorned with demonic horned skulls at the origin.

### 3.2 Dynamic Sure-Hit Algorithm
The server runs a spatial partition query every 2 ticks within 200 blocks of the shrine center:
1. **Living Entities with CE**: Sliced by **Cleave**, which dynamically evaluates the target's current armor and max HP, applying damage that scales with their defense.
2. **Inanimate Entities & Blocks**: Sliced by **Dismantle**, disintegrating solid blocks into falling dust particles.
3. **Anti-Domain Defense**: Entities maintaining **Simple Domain** or **Hollow Wicker Basket** are shielded, but the sheer volume of continuous slashes rapidly erodes the stability of their simple barrier, stripping it away within 4–8 seconds unless reinforced.

### 3.3 Domain Clashing vs. Closed Domains
When Malevolent Shrine clashes with a closed domain (e.g., Gojo's Unlimited Void):
- The closed domain's barrier forms its 66-block sphere inside Malevolent Shrine's 200-block open radius.
- Inside the closed domain, both sure-hits cancel each other out in a clash of refinement.
- **However, outside the 66-block barrier**, Sukuna's open domain remains fully active. Malevolent Shrine's slashes relentlessly strike the exterior shell of the closed domain from all sides!
- Unless the opponent can withstand Sukuna's attacks and damage him enough to break his concentration, the closed domain's exterior will inevitably collapse after its barrier durability is depleted.
