# Toji Fushiguro & Maki Zenin — Abilities & Kit Specification

## 1. Zero Cursed Energy & Superhuman Senses (Passive Trait)
- **Canon ref**: Chapters 73–77, 197–198
- **JJA implementation**: Tag `heavenly_restriction`, effect buffs (Speed IV, Strength IV, Resistance III, Jump Boost III).
- **Core Mechanics (Server-Authoritative)**:
  - **Zero CE Bar**: Cursed Energy pool is permanently locked at `0`.
  - **Sensory Perception**: Sees invisible cursed spirits, air friction ripples, and trajectory prediction lines without Six Eyes.
  - **Domain Immunity**: Cannot be trapped inside enclosed domain barriers against their will. Completely immune to domain sure-hit targeting (domains recognize them as inanimate structures).
  - **Regenerative Constitution**: Natural health regeneration operates at 3x standard player speed without consuming CE or using RCT.

---

## 2. Jetstream Dash & Superhuman Speed (超速移動)
- **Canon ref**: Chapters 73, 197
- **JJA implementation**: `hr/jetstream.mcfunction`, `hr_moves.mcfunction`, `hr1.mcfunction`.
- **Trigger**: Double-tap Sprint or Ability Key 1.
- **Cost / Cooldown**: 0 CE / 3s cooldown (Stamina-based).
- **Effect**:
  - Blinding instant linear dash across 16 blocks leaving behind atmospheric compression shockwaves.
  - Passes through entities, staggering them for 10 ticks.
  - Can jump off falling debris and step on atmospheric currents mid-air (Air Walk).

---

## 3. Bone Splitter & Lethal Martial Arts (骨砕き & 格闘)
- **Canon ref**: Chapter 73, Chapter 150
- **JJA implementation**: `bone_splitter.mcfunction`, `deadly_strike.mcfunction`, `deadly_clash.mcfunction`.
- **Cost / Cooldown**: 0 CE / 5s cooldown.
- **Damage / Effect**:
  - Close-quarters grappling strike dealing 24 physical damage.
  - Bypasses CE reinforcement defenses due to brute mechanical leverage.
  - Breaks opponent's guard, causing 30 ticks of disarm/stun.

---

## 4. Dive Kick (急降下キック)
- **Canon ref**: Chapter 110 (Toji vs Megumi / Dagon)
- **JJA implementation**: `dive_kick.mcfunction`, `hr4.mcfunction`.
- **Cost / Cooldown**: 0 CE / 6s cooldown.
- **Effect**:
  - Launches into air and drives downward heel at a 45-degree angle.
  - Impacts ground with power 4.0 crater shockwave, dealing 28 damage and launching enemies into the air.

---

## 5. Inverted Spear of Heaven (天逆鉾)
- **Canon ref**: Chapters 71–75 (vs Gojo's Infinity)
- **JJA implementation**: `functions/fighting/invertedspear/`.
- **Effect**:
  - Completely **nullifies and dispels any active Cursed Technique** upon contact.
  - Pierces Gojo's Infinity effortlessly as if it did not exist.
  - Cancels active Simple Domains, Falling Blossom Emotion, and breaks sustained barrier structures on strike.

---

## 6. Split Soul Katana (釈魂刀)
- **Canon ref**: Chapters 77, 198 (Maki vs Naoya)
- **JJA implementation**: `functions/fighting/soul_sword/`.
- **Effect**:
  - Completely ignores physical hardness, armor values, and cursed energy reinforcement.
  - Directly cuts the boundary of the victim's **soul**, dealing true unhealable damage unless the victim understands the outline of their soul and possesses advanced RCT.
