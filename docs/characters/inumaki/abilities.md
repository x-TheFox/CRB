# Toge Inumaki — Abilities & Kit Specification

## 1. Verbal Command Arsenal
Commands are issued along a forward directional cone (45-degree angle, 20 blocks base range, 40 blocks with Megaphone).

### A. Non-Lethal / Control Commands
1. **"Don't Move!" (動くな, Ugokuna)**:
   - *Cost / CD*: 30 CE / 4s cooldown.
   - *Effect*: Target is completely paralyzed (velocity set to 0, stun 40 ticks, camera lock).
   - *Throat Strain*: Minor (5% throat meter).
2. **"Sleep!" (眠れ, Nemure)**:
   - *Cost / CD*: 45 CE / 8s cooldown.
   - *Effect*: Target collapses to ground with Blindness and Slowness X for 70 ticks. Any damage taken wakes the target immediately.
   - *Throat Strain*: Low (10% throat meter).
3. **"Run Away!" (逃げろ, Nigero)**:
   - *Cost / CD*: 35 CE / 6s cooldown.
   - *Effect*: Forces target to run directly away from Inumaki at Speed III for 50 ticks, disabling attack inputs.

### B. Kinetic & Crushing Commands
4. **"Blast Away!" (ぶっとべ, Buttobe)**:
   - *Cost / CD*: 60 CE / 8s cooldown.
   - *Effect*: Violent shockwave launches target 20 blocks backward, dealing 18 kinetic impact damage when striking walls.
   - *Throat Strain*: Moderate (20% throat meter).
5. **"Plummet!" (堕ちろ, Ochiro)**:
   - *Cost / CD*: 75 CE / 10s cooldown.
   - *Effect*: Gravitational crush drives airborne or standing targets into the earth, creating a 3-block crater and dealing 24 damage.
   - *Throat Strain*: High (30% throat meter).
6. **"Get Crushed!" (潰れろ, Tsuburero)**:
   - *Cost / CD*: 85 CE / 12s cooldown.
   - *Effect*: Implosive pressure twists and flattens target's limbs, dealing 28 internal damage and crippling movement.
   - *Throat Strain*: High (35% throat meter).

### C. Supreme Lethal Commands
7. **"Die!" (死ね, Shine)**:
   - *Cost / CD*: 150 CE / 30s cooldown.
   - *Effect*: Attempts to extinguish target's life force. Deals 50 true damage (or instant death to low-tier curses/mobs).
   - *Throat Strain*: Extreme (80% throat meter; inflicts severe coughing and bleeding if target's grade is equal to or higher than Inumaki's).

---

## 2. Megaphone Amplification (拡声器)
- **Canon ref**: JJK 0 (vs Geto's curses)
- **JJA implementation**: `_mg` functions.
- **Effect**: Holding the Megaphone in off-hand or main-hand increases command area of effect to a 120-degree cone and 45-block reach, reducing throat strain by 25% at the risk of shattering the megaphone after 5 uses.

---

## 3. Throat Strain & Medicine Management (喉の反動とシロップ)
- **Canon ref**: Chapter 18, Chapter 100
- **Mechanics (Server-Authoritative)**:
  - Each command adds to Inumaki's `ThroatStrain` data capability (0 to 100).
  - When strain exceeds 70%, commands inflict self-damage and coughing animation locks.
  - When strain reaches 100%, Inumaki vomits blood, taking 15 hearts damage and losing voice abilities for 20 seconds.
  - Consuming **Throat Medicine (のどシロップ)** instantly restores 40% throat capacity.
