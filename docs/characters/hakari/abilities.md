# Kinji Hakari — Abilities & Kit Specification

## 1. Rough Cursed Energy (Innate Trait / Passive)
- **Canon ref**: Chapter 155 (vs Yuji Itadori)
- **JJA implementation**: Tag `fistenergy`, `functions/fighting/lovetrain_m1s.mcfunction`.
- **Effect**:
  - All melee strikes inflict +2 abrasive chip damage through shields.
  - Applies micro-stagger and reduces target's natural healing rate by 30% for 4 seconds.

---

## 2. Train Shutter Doors (電車のドア)
- **Canon ref**: Chapters 155, 183
- **JJA implementation**: `shutterdoors.mcfunction`, `items/lovetrain/lovetrain1.json`.
- **Cost / Cooldown / Range**:
  - Cost: 40 CE.
  - Cooldown: 6 seconds.
  - Range: 12 blocks.
- **Damage / Effect**:
  - Materializes two heavy subway carriage shutter doors on opposite sides of the target that slam shut with violent hydraulic force.
  - Traps target in place for 25 ticks, cancels active windup, and inflicts 16 crushing damage.
  - Can be spawned in front of Hakari to block incoming projectiles.

---

## 3. Pachinko Rush & Train Cargo (パチンコ玉 & コンテナ投擲)
- **Canon ref**: Chapter 183
- **JJA implementation**: `cargo.mcfunction`, `pachinko_rush.mcfunction`, `pachinko_cannon.mcfunction`.
- **Cost / Cooldown / Range**:
  - Cost: 60 CE.
  - Cooldown: 10 seconds.
  - Range: 20 blocks.
- **Damage / Effect**:
  - Launches giant silver pachinko spheres that richochet off surfaces, dealing 8 bludgeoning damage per bounce.
  - Alternately summons a full steel train freight container dropping from the sky, dealing 26 crushing damage in a 4-block radius.

---

## 4. Domain Expansion: Idle Death Gamble (坐殺博徒)
- **Canon ref**: Chapters 182–190
- **JJA implementation**: `idledeathgamble.mcfunction`, `idledeathgamble2.mcfunction`, objective `domainstart`.
- **Cost / Cooldown / Duration**:
  - Cost: 120 CE (Innate Domain structure with non-damaging sure-hit).
  - Cooldown: Resets to 0 immediately upon Jackpot conclusion!
  - Duration: Until Jackpot is hit or 3 riichi rounds fail.
- **Sure-Hit Effect (Rules Infusion)**:
  - Hakari transmits the entire overwhelmingly complex ruleset of *Private Pure Love Train* into the minds of everyone inside the domain in an instant.
  - Harmless to the opponent physically, fulfilling the sure-hit condition to bypass domain defenses.
- **Visuals & Gacha Phases**:
  - Color visual indicators: Green (Low chance), Red (Medium chance), Gold (High chance).
  - Riichi cutscenes: Romance drama scenarios play out inside the domain (e.g. Transit Inspection, Last Train Chase).

---

## 5. Jackpot Mode: Boundless Immortality (大当たり・4分11秒の無敵)
- **Canon ref**: Chapters 186–189 (vs Kashimo)
- **JJA implementation**: `hakarimode.mcfunction`, `hakari_dance.mcfunction`, `music.tukadonka`, `ds:hakarimode`.
- **Duration**: Exactly **4 minutes and 11 seconds (251 seconds / 5,020 ticks)**.
- **Effects (Multiplayer Server-Authoritative)**:
  - **Infinite Cursed Energy**: CE pool locks at `MAX_INT`; all abilities consume 0 CE.
  - **Reflex Automatic RCT**:
    - Automatic instantaneous healing: heals 4 hearts per tick.
    - Decapitation or fatal damage is regenerated in the same tick (`EntityDeathEvent` cancellation if damage occurs while Jackpot is active).
    - Cleanses all poison, withering, and elemental shock debuffs instantly through rapid expulsion.
  - **Audio & Cinematics**:
    - The uplifting theme music *Admiring You* (*Tuka Donka*) blasts in full stereo, audible to all players within 48 blocks.
    - Hakari gains celebratory dance emotes and massive golden aura plumes.
  - **Post-Jackpot Reset**: Once the music concludes, Hakari's domain cooldown is completely refreshed, allowing him to immediately cast Idle Death Gamble again!
