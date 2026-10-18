# Mahito — Abilities & Kit Specification

## 1. Core Innate Technique: Idle Transfiguration (無為転変, Mui Tenpen)
- **Canon ref**: Chapters 20–22, 29–31, 120–130 / Episodes 10–13, Season 2 Episodes 18–21
- **JJA implementation**: `items/c_idle_transfig/c_idle_transfig1.json` (`ds:idle_transfig1`), `functions/idle_transfig/base_ab1.mcfunction` through `base_ab4.mcfunction`.
- **Trigger (Java direction)**: Primary Ability Key (`R` with Soul CT active) / Contact palm touch.
- **Cost / Cooldown / Range**: 50 CE / 4s / Melee touch (2.5 blocks).
- **Damage / Effect**:
  - Reaches out and grips the opponent's soul, violently mutating their physical anatomy (`functions/damages/soul_damage.mcfunction`).
  - Against non-sorcerers / weak mobs: Instant lethal transfiguration into a disfigured mutant.
  - Against sorcerers with CE reinforcement: Deals 45 true soul damage and inflicts irreversible max health reduction.
  - **Passive Soul Invulnerability**: Standard physical strikes and environmental damage do 0 HP damage to Mahito; only attacks with soul awareness (Yuji Itadori) or soul-piercing weapons deal real damage!

## 2. Self-Body Morphing: Blades, Heavy & Flight Styles
- **Blade Style (`ds:idle_transfig_combat2`)**: Morphs arms into scythe blades, drills, and whip tentacles (`blade_ab1.mcfunction`–`blade_ab4.mcfunction`). Deals slashing and armor-piercing damage.
- **Heavy Style (`ds:idle_transfig_combat3`)**: Expands upper torso and arm mass into giant muscular clubs; delivers ground slams and body repels.
- **Body Transfiguration (`ds:idle_transfig2`)**: Sprouts bird wings for mid-air flight, elongated legs for 10-block leaps, or blade fins for high-speed swimming.

## 3. Soul Multiplicity & Transfigured Human Summons
- **Stable Transfigured Soul (`ds:stable_transfigured_human`)**: Summons small agile distorted minions that sprint at enemies and bite their limbs.
- **Unstable Transfigured Soul (`ds:unstable_transfigured_human`)**: Volatile mutated soul bombs that rush targets and detonate in a cloud of acidic cursed bile.
- **Body Repel (幾魂異性体, Polymorphic Soul Isomer)**: Fuses rejected souls with weak cursed energy into an unstable, colossal giant with overwhelming physical punching power.

## 4. Ultimate Evolution: Instant Spirit Body of Distorted Killing (遍殺即霊体)
- **Canon ref**: Chapters 128–130 / Season 2 Episode 21
- **JJA implementation**: `items/c_idle_transfig/g_idle_transfig5 .json` (`ds:idle_transfig5`), `items/c_idle_transfig/instant_body_combat.json`, `functions/idle_transfig/instant_body.mcfunction`.
- **Cost / Cooldown / Duration**: 200 CE / 120s / 60s transformation.
- **Damage / Effect**:
  - Unlocked upon awakening the true essence of his soul after landing Black Flash.
  - Transfigures his entire body into a pitch-black armored chrysalis with an elongated whip-tail, blade blades on elbows, and an impenetrable carapace.
  - **Durability Multiplier**: +200% natural defense (physical damage reduced by 75%).
  - **Combat Style**: Unlocks `ds:instant_body_combat`, delivering lethal drill thrusts and tail sweeps.

## 5. Domain Expansion: Self-Embodiment of Perfection (自閉円頓裹)
- **Canon ref**: Chapters 29–31, 82, 129–130 / Episodes 12–13, Season 2 Episode 20
- **JJA implementation**: `items/c_idle_transfig/f_idle_transfig4.json` (`ds:idle_transfig4`), `functions/idle_transfig/domain.mcfunction`.
- **Cost / Cooldown / Duration / Range**: 350 CE / 180s / 30s / 66 block spherical domain.
- **Damage / Effect**:
  - Encloses victims inside an intricate web of colossal intertwined hands emerging from the darkness.
  - **Sure-Hit: Direct Soul Grasp**: In this domain, Mahito is literally inside the palms of his hands. Every entity inside is considered already in physical contact with Mahito's palm at all times!
  - Idle Transfiguration acts continuously on all trapped enemies with 100% sure-hit accuracy, causing rapid grotesque mutation and death.
  - **0.2 Second Domain**: Mahito can cast a 0.2-second domain to transfigure opponents before Sukuna can retaliate!
