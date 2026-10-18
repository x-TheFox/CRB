# Mahito — Domain Expansion: Self-Embodiment of Perfection (自閉円頓裹)

## 1. Concept & Canon Reference
- **Name**: Self-Embodiment of Perfection (自閉円頓裹, Jihei Endonka)
- **Canon Ref**: Jujutsu Kaisen Chapters 29–31, 82, 129–130; Anime Episodes 12–13, Season 2 Episode 20
- **Core Concept**: The ultimate artistic expression of Idle Transfiguration. Inside this domain, Mahito connects the space directly to his soul. The barrier walls are formed by countless intertwined hands woven into an unbroken spherical cocoon. Inside the domain, Mahito is already in physical palm contact with every living entity at all times, making his touch of transfiguration completely unavoidable.

---

## 2. JJA Bedrock Mechanics & Forensic Evidence
- **Trigger**: `items/c_idle_transfig/f_idle_transfig4.json` (`ds:idle_transfig4`)
- **Execution Pipeline**: `functions/idle_transfig/domain.mcfunction`
- **Sure-Hit Application**: Applies continuous soul transfiguration damage ticks (`functions/damages/soul_damage.mcfunction`).
- **Insta-Kill Toggle**: Respects `setting_mahito_insta_kill` in `scripts/index.js` (L18). If enabled, non-sorcerer entities and low-grade enemies are instantly transformed into transfigured humans upon domain formation.

---

## 3. Java-Native Evolution (CRB Architecture)
- **Living Hand Barrier**: Procedural barrier generated with animated grey hand textures and ambient reaching claws.
- **Immediate Sure-Hit**: All entities without Simple Domain immediately begin mutating; maximum HP drops by 10% per second until dead or transfigured.
- **Sukuna Counter-Slash (Canon Retaliation)**: If Mahito expands this domain while Sukuna (or a player hosting Sukuna's soul) is inside without consent, touching Sukuna's soul triggers an automatic lethal Cleave counter-strike that shatters Mahito's domain barrier instantly (Chapter 30)!
- **0.2 Second Domain Mode**: Allows 0.2s deployment to strike targets without giving Sukuna or domain clashers time to retaliate.
