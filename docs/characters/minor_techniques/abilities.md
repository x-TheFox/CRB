# Minor Cursed Techniques — Abilities & Kit Specification

## 1. Haruta Shigemo: Miracles (奇跡, Kiseki)
- **Canon ref**: Chapters 100, 117–118 (vs Nanami & Sukuna)
- **JJA implementation**: `miracles_ct.mcfunction`, `miracle_add.mcfunction`, `miracle_save.mcfunction`.
- **Mechanics**:
  - Passive Miracle Storage: Passive accumulation up to 6 marks beneath the eyes.
  - Automatic Death Prevention: When receiving lethal damage (`health <= 0`), cancels death event, consumes 1 miracle mark, restores player to 50% health, and triggers a lucky dodge displacement.
  - Once all 6 marks are spent, the user becomes extremely vulnerable.

---

## 2. Charles Bernard: G Warstaff & Manga Future Sight (G戦杖)
- **Canon ref**: Chapters 181–183 (vs Hakari)
- **JJA implementation**: `windup_technique.mcfunction`, `windup_hit.mcfunction`, `windup_technique2.mcfunction`.
- **Mechanics**:
  - G-Pen Nib Strike: Physical reach attack with the G-pen staff.
  - Ink Deposit: Hitting an enemy paints an ink panel on their body.
  - Future Panel Projection: For 8 seconds after an ink strike, a floating 2D manga frame appears next to the opponent displaying their next movement 1.5 seconds in advance.
  - Auto-Parry / Evasion: While future panel is visible, pressing sprint or jump guarantees 100% dodge against the opponent's incoming attack.

---

## 3. Pain-Killer: Anesthetic Cursed Field (痛覚遮断)
- **JJA implementation**: `painkiller_technique.mcfunction`, `painkiller_use.mcfunction`, `painkiller_self.mcfunction`, `painkiller_other.mcfunction`.
- **Mechanics**:
  - Self / Ally Target Cast: Channels anesthetic CE into target's circulatory system.
  - Grants Resistance IV, Knockback Resistance 1.0, and 10 Absorption Hearts for 12 seconds.
  - Deferred Damage: 40% of the damage received during the anesthetic window is converted into a slow bleed debuff that ticks over 10 seconds after the buff ends.

---

## 4. Immobilizing Sight: Ocular Paralysis (呪視)
- **JJA implementation**: `sight_technique.mcfunction`, `sight.mcfunction`.
- **Mechanics**:
  - Requires maintaining direct crosshair line-of-sight on an enemy within 15 blocks.
  - Channels 5 CE per tick to paralyze target's motor functions (Slowness VI and attack disable) as long as eye contact is maintained.
  - Breaks if either player blinks, takes damage, or looks away.
