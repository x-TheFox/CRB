# Ryomen Sukuna — Canon Completion & Upgrade Specification

## 1. Missing-Iconic Analysis (Canon Gap Identification)

### 1.1 Kamutoke Lightning Storm & Hiten Wind Scythes
- **Canon Ref**: Chapter 237–238, 245
- **Gap in JJA**: In JJA, `ds:kamutoke` and `ds:hiten` exist primarily as simple stat items in `items/weps/`. Their signature canon combat moves (Kamutoke discharging wide-area high-voltage lightning storms without CE cost, and Hiten unleashing sweeping gale blades) are incomplete.
- **Java Upgrade Spec**:
  - Ability: **Kamutoke: Divine Lightning Barrage**
  - Trigger: Attack while wielding Kamutoke in off-hand or secondary weapon slot.
  - Cost: 0 CE (cursed tool self-powered). Cooldown: 6s.
  - Effect: Discharges 5 violent lightning strikes from the sky onto targeted coordinates, electrocuting and stunning targets for 20 ticks.

### 1.2 Incomplete Domain Restorations & Enchain Binding Vow
- **Canon Ref**: Chapter 11, 226, 258
- **Gap in JJA**:
  1. **Enchain Contract**: The binding vow between Sukuna and Yuji (*"When I chant 'Enchain', you yield control of your body for one minute..."*) is absent as a gameplay mechanic.
  2. **Selective Domain Target Exclusion**: In Chapter 119, Sukuna selectively restricts Malevolent Shrine's radius from 200m down to 140m to avoid harming Megumi Fushiguro. In JJA, the radius is hard-coded to 200m.
- **Java Upgrade Spec**:
  - Ability: **Domain Tuning: Radius Modulation**
  - Trigger: While casting Malevolent Shrine, scroll mouse wheel or adjust slider on HUD.
  - Effect: Allows dynamically selecting a radius between 20 and 200 blocks. Smaller radii concentrate slash frequency, increasing DPS by up to 50%!

### 1.3 Brain RCT & Output Recovery via Black Flash
- **Canon Ref**: Chapters 255–256
- **Gap in JJA**: Landing Black Flash as Sukuna in JJA simply increments `blackflash_amount`. Canonically, Sukuna landing Black Flash on Maki and Larue restores his depleted Reverse Cursed Technique output and reignites his circuit for Domain Expansion!
- **Java Upgrade Spec**:
  - Effect: When Sukuna lands a Black Flash, his RCT output recovers by 25% and his technique burnout timer is reduced by 10 seconds per hit.

---

## 2. Fidelity Corrections
1. **World Cutting Slash Spatial Mechanics**: In JJA, WCS functions partly as an extremely high-damage projectile. In canon (Chapter 236), it does NOT travel through space; it slices the target coordinate in the fabric of space instantaneously. In CRB, WCS must instantaneously bisect everything intersecting the geometric plane without travel delay.
2. **Fuga Post-Domain Dust Explosion**: JJA triggers Fuga independently. In canon (Chapter 258), Fuga's true terrifying power in Shinjuku and Shibuya was achieved by igniting the fine aerosolized dust created by Malevolent Shrine. In CRB, a dedicated synergy multiplier must double Fuga's explosion radius when fired immediately after Malevolent Shrine.

---

## 3. Flagged Judgment Calls (Orchestrator Adjudication)
- **Judgment Call: One Sukuna Vessel Per World Policy**:
  - In JJA, a toggle `setting_only_one_sukuna` exists in `scripts/index.js`.
  - *Ruling*: **Configurable Server Rule (`sukuna_vessel_limit = 1` by default)**. In multiplayer servers, having multiple players roleplaying Sukuna breaks immersion and balance. The server config allows competitive servers to enable multi-vessel if desired.
