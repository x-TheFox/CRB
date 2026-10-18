# Jogo — Canon Completion & Upgrade Specification

## 1. Missing-Iconic Analysis (Canon Gap Identification)

### 1.1 Domain Amplification Combat Stance
- **Canon Ref**: Chapters 84–88 (Shibuya Incident vs. Gojo)
- **Gap in JJA**: JJA provides Domain Amplification as an independent item in `items/particles/domainamplification.json`. Jogo canonically mastered Domain Amplification alongside Hanami to neutralize Satoru Gojo's Neutral Infinity and fight in close-quarters melee combat!
- **Java Upgrade Spec**:
  - Ability: **Disaster Domain Amplification**
  - Effect: Coats Jogo in a thin fluid aura that neutralizes Gojo's Infinity on physical strike, but temporarily disables Ember Insects and Flamethrower while channeled.

### 1.2 Multi-Directional Lava Geyser Traps
- **Canon Ref**: Chapter 111 (Incinerating Nanami, Maki, and Naobito Zenin)
- **Gap in JJA**: In JJA, eruptions only manifest at a single point beneath the target. Canonically, Jogo instantly manifest twin volcanic vents on adjacent walls or pillars, cross-firing streams of superheated magma to pin and melt opponents before they can react!
- **Java Upgrade Spec**:
  - Ability: **Crossfire Caldera**
  - Trigger: Aim at two solid surface blocks within 15 blocks; erupts two converging streams of molten rock that trap targets caught between them.

---

## 2. Fidelity Corrections
1. **Meteor Impact Pacing**: In JJA, the meteor hits relatively quickly. In canon (Chapter 115), Sukuna challenged Panda and Kusakabe to stand still until 1 second before impact because the meteor's immense mass took time to descend. In CRB, provide a distinct warning shadow on the ground for 3 seconds before impact, rewarding enemies who make an immediate high-speed retreat.

---

## 3. Flagged Judgment Calls (Orchestrator Adjudication)
- **Judgment Call: Block Destruction with Meteor**:
  - In JJA, griefing is toggled via `setting_griefing`.
  - *Ruling*: **Respect Server Mob Griefing Rule**. If `mobGriefing` is false, Meteor damages entities and leaves visual scorched particle ash on blocks without permanently destroying world structures.
