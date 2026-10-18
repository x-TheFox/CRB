# Yuji Itadori — Canon Completion & Upgrade Specification

## 1. Missing-Iconic Analysis (Canon Gap Identification)

### 1.1 Complete Blood Manipulation Arsenal
- **Canon Ref**: Chapters 251, 256, 257 (Shinjuku Showdown)
- **Gap in JJA**: JJA shipped `items/yuji/blood_manipulation.json` with the explicit tooltip `[ NOT RELEASED / MADE ]`. The entire Blood Manipulation technique was unfinished in the Bedrock pack!
- **Java Upgrade Spec**:
  - Implement full Blood Manipulation for Yuji:
    1. **Piercing Blood (穿血)**: Supersonic focused blood laser beam with high armor-piercing damage.
    2. **Supernova (超新星)**: 360-degree blood bullet explosion.
    3. **Blood Edge (血刃)**: Coats fists or weapons in razor-sharp coagulated blood blades.
    4. **Convergence (収束)**: Compresses blood to its absolute limit to prep Piercing Blood or Supernova.
    5. **Death Painting Healing**: Because Yuji consumed Death Painting Wombs 4–9, he can convert Cursed Energy directly into blood, preventing blood-loss exhaustion!

### 1.2 Simple Domain & New Shadow Style
- **Canon Ref**: Chapter 258 (Surviving Malevolent Shrine)
- **Gap in JJA**: In JJA, Simple Domain is a generic shared technique from Kusakabe. Yuji canonically mastered New Shadow Style: Simple Domain through soul-swap training with Atsuya Kusakabe, using it to survive Sukuna's 99-second full-output Malevolent Shrine!
- **Java Upgrade Spec**:
  - Yuji gains an innate +50% Simple Domain durability bonus when facing slicing damage.

### 1.3 Soul Perception & Soul Repair
- **Canon Ref**: Chapter 252 (Healing soul wounds from Split-Soul Katana)
- **Gap in JJA**: JJA lacks soul healing mechanics. Canonically, because Yuji shared a body with Sukuna, he can perceive the outline of the soul and use RCT to heal damage inflicted directly to the soul!
- **Java Upgrade Spec**:
  - Yuji can heal true soul damage using RCT, unlike ordinary sorcerers who cannot heal soul cuts.

---

## 2. Fidelity Corrections
1. **Black Flash Trigger Window**: In JJA, Black Flash is largely randomized (`blackflashchance`). In canon, Black Flash occurs when cursed energy is applied within 0.000001 seconds of physical impact. In CRB, introduce an active skill-based timing mechanic (hitting attack during the flash window) alongside an innate critical chance.

---

## 3. Flagged Judgment Calls (Orchestrator Adjudication)
- **Judgment Call: Blood Manipulation Acquisition Method**:
  - In JJA, blood manipulation was unreleased. In canon, Yuji ate the Death Paintings.
  - *Ruling*: **Unlocked upon reaching Grade 1 or consuming Death Painting Relics in the game**. Seamlessly blends with JJA's progression arc.
