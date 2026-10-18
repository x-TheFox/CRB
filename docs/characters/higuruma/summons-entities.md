# Hiromi Higuruma — Summons & Entities Specification

## 1. Entities & Shikigami
- **Judgeman Entity (`crb:judgeman`)**:
  - Implements custom GeckoLib model with floating cloth robes, balance scales suspended from arm, and blindfolded wooden mask.
  - Non-combatant entity: Invulnerable to damage; acts as courtroom presiding officer.
  - Manages trial state machine, reads defendant history, and executes verdict animations.
- **Judge's Gavel Entity (`crb:higuruma_gavel`)**:
  - Dynamic scale weapon entity supporting fluid transitions between 1.0x, 2.5x, and 8.0x bounding boxes.
- **Executioner's Sword Item & Entity (`crb:executioners_sword`)**:
  - Radiant sword item granted directly to mainhand upon Death Sentence.
  - Tracks specific UUID of condemned target. If swung at non-condemned entity, deals only base physical damage. If swung at condemned target, triggers instant death hook.
- **Boss Entity (`crb:higuruma_boss`)**:
  - SmartBrainLib AI that initiates combat with Gavel swings, casts Deadly Sentencing at 80% HP, and pursues defendant with Executioner's Sword if verdict is guilty.
