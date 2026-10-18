# Jogo — Domain Expansion: Coffin of the Iron Mountain (蓋棺鉄囲山)

## 1. Concept & Canon Reference
- **Name**: Coffin of the Iron Mountain (蓋棺鉄囲山, Gaikan Tecchisen)
- **Canon Ref**: Jujutsu Kaisen Chapters 14–16; Anime Episode 7
- **Core Concept**: Traps the opponent inside the fiery molten belly of an active subterranean volcano. The intense thermal energy is lethal to average sorcerers without active CE reinforcement. The domain's sure-hit commands the volcanic stone walls to manifest molten boulder spikes directly on the enemy's body.

---

## 2. JJA Bedrock Mechanics & Forensic Evidence
- **Trigger**: `items/disaster_flames/domain.json` (`ds:flames7`)
- **Execution Pipeline**: `functions/flames/domain.mcfunction`, `functions/flames/IronMountain`
- **Terrain Alteration**: Clones volcanic obsidian and lava chamber using `tickingarea add IronMountain`.
- **Sure-Hit**: Spawns sharp magma rock spikes tracking targets every 20 ticks.

---

## 3. Java-Native Evolution (CRB Architecture)
- **Volcanic Chamber Interior**: 66-block procedural sphere lined with smoking basalt and flowing lava falls.
- **Ambient Heat Burn**: Any entity lacking Cursed Energy or Simple Domain catches fire instantly and takes 5 thermal damage per tick.
- **Sure-Hit: Magma Spear Eruption**: Molten volcanic spears thrust out from the domain walls directly into the target's coordinates with 100% accuracy.
- **Domain Clash Vulnerability**: Can be easily overwhelmed by more refined domains (e.g. Gojo's Unlimited Void or Sukuna's Malevolent Shrine).
