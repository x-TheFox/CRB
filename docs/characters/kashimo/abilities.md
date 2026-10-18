# Hajime Kashimo — Abilities & Kit Specification

## 1. Electrified Cursed Energy (Innate Trait / Passive)
- **Canon ref**: Jujutsu Kaisen Chapters 184–190
- **JJA implementation**: Tag `lightningfists`, `functions/kashimo/lightning1a.mcfunction`, `lightning1b.mcfunction`, `lightning1c.mcfunction`, `damages/electric_damage.mcfunction`.
- **Trigger**: Inherent passive on all physical attacks while CE is unsealed.
- **Cost / Cooldown / Range**:
  - Cost: Passive 0 CE / 2 CE per hit.
  - Cooldown: None.
  - Range: Melee attack reach (3.5 blocks).
- **Damage / Effect**:
  - Adds +3 electric damage that bypasses conventional physical armor.
  - Applies 75 ticks of `shocked` status and 20 ticks of `Stun`.
  - Deposits **Positive Electrical Charge** on Kashimo and **Negative Electrical Charge** on the victim (stack counter: 1 to 5).
- **VFX / SFX**: Blue/teal electric sparks (`ds:lightning_shockwave1`), crackling audio (`mob.lightning.spark`).
- **Multiplayer notes**: Server-authoritative charge tracking via `PlayerChargeAttachment` data capability.

---

## 2. Sure-Hit Lightning Discharge (落雷)
- **Canon ref**: Chapters 186, 188 (Panda & Hakari fights)
- **JJA implementation**: `items/kashimo/lightning2.json`, `functions/kashimo/lightningbolt1.mcfunction`, tag `form2`.
- **Trigger**: Ability Key 2 (`X` or Radial Wheel) when target charge reaches threshold (5 stacks) or Nyoi Staff is planted.
- **Cost / Cooldown / Range**:
  - Cost: 80 CE.
  - Cooldown: 12 seconds.
  - Range: 35 blocks line-of-sight / staff vector.
- **Damage / Effect**:
  - 35 hearts true/armor-piercing damage (60 damage in Mythical Beast Amber).
  - Guarantees 100% accuracy without domain barrier by utilizing electrostatic potential difference.
  - Vaporizes target limbs / causes severe bleeding and instant 40-tick stun.
- **Windup / Active / Recovery frames**: 5 ticks windup, 2 ticks strike, 10 ticks recovery.
- **VFX**: Blinding electric arc from Kashimo's palm to target, cascading lightning bolts (`ds:lightningbolt1`, `ds:lightningbolt2`, `ds:lightningbolt3`).
- **SFX**: Sonic boom crack (`ambient.weather.thunder` at 1.75 pitch + `mob.kashimoscream`).
- **Camera direction**: Sudden 5-degree FOV punch and chromatic aberration snap on impact.

---

## 3. Lightning Cloak (雷衣)
- **Canon ref**: Chapter 185
- **JJA implementation**: `items/kashimo/lightning3.json`, `functions/kashimo/lightning_cloak.mcfunction`, `lightning2.mcfunction`, objective `ltncloak`.
- **Trigger**: Ability Key 3.
- **Cost / Cooldown / Duration**:
  - Cost: 60 CE activation + 2 CE/s upkeep.
  - Cooldown: 25 seconds.
  - Duration: 15 seconds (scaled by CE pool: `operation @s ltncloak += @s Energy`).
- **Damage / Effect**:
  - Grants Speed IV, Jump Boost III, Resistance II.
  - Contact electrification: any entity colliding with Kashimo takes 6 electric damage and 20 ticks stun.
  - Incoming metallic projectiles deflect with sparks.
- **VFX**: Continuous blue electrical aura surrounding body (`ds:lightning_cloak_charge1..5`).
- **SFX**: High-voltage hum loop and static discharge.

---

## 4. Nyoi Staff Discharge & Return Arc (如意棒・避雷針)
- **Canon ref**: Chapter 188
- **JJA implementation**: `functions/fighting/nyoistaff/`, `functions/kashimo/water_conduct.mcfunction`.
- **Trigger**: Throw / plant Nyoi Staff, then trigger Discharge.
- **Cost / Cooldown / Range**:
  - Cost: 40 CE.
  - Cooldown: 15 seconds.
  - Range: 50 blocks between Kashimo and staff.
- **Damage / Effect**:
  - Plants staff in ground. When discharge is triggered, a violent lightning bolt arcs directly from Kashimo to the staff, bisecting any entity caught between them for 45 true damage.
  - Water Conductivity: If staff or victim is submerged in water, radius expands to 18 blocks causing electrolysis (producing explosive chlorine/hydrogen gas and boiling water).
- **VFX**: Ground-to-staff blue beam with ground scorch particles.

---

## 5. Mythical Beast Amber (幻獣琥珀, Genjū Kohaku)
- **Canon ref**: Chapters 237–238 (vs Sukuna)
- **JJA implementation**: `items/kashimo/lightning4.json`, `functions/kashimo/beast_awaken.mcfunction`, `amberbeast.mcfunction`, `amber_end.mcfunction`, tag `mythicalbeastamber`.
- **Trigger**: Ultimate Key (`G`) with confirmation.
- **Cost / Cooldown / Duration**:
  - Cost: All remaining CE (minimum 250 CE).
  - Cooldown: Single-use per life (Canon irreversible technique).
  - Duration: 120 seconds or until cancelled.
- **Damage / Effect**:
  - Flesh converts into pure electrical phenomenon.
  - Speed VII, Strength VI, Haste V, Levitation/Flight, Agility dashes.
  - Unlocks Amber Moves:
    - `lightning_am1`: Electromagnetic Beam (Vaporization ray, 50 damage).
    - `lightning_am2`: High-Frequency Sound Wave Cannon (Shreds internal organs, bypasses Infinity).
    - `lightning_am3`: Cyclone Blitz (Relativistic dash through enemies).
    - `lightning_am4`: Synchrotron Radiation Burst (Wide AoE thermal blast).
    - `lightning_am5`: Thunderclap Bombardment.
    - `lightning_am6`: Lightning God Obliteration.
  - **Fatal Consequence**: Upon timer expiration or deactivation (`amber_end`), the user's body disintegrates into ash (permadeath or severe necrotic stat loss in survival).
- **VFX**: Glowing cyan eyes, horns made of electrical lightning, golden-amber aura ribbons, global thunder weather.
- **SFX**: Overwhelming atmospheric thunder rumble, electrical hum, distorted demonic voice filters.

---

## 6. Energy Wave & Energy Orb
- **Canon ref**: Chapter 237
- **JJA implementation**: `functions/kashimo/energy_wave.mcfunction`, `energy_orb.mcfunction`, `energy_orb_explode.mcfunction`.
- **Trigger**: Ability slot while transformed in Amber form.
- **Damage / Effect**:
  - Concentrated electromagnetic plasma orb fired at high velocity.
  - Deals 25 explosive damage, destroys fragile blocks, applies heavy knockback and shock status.

---

## 7. Domain Expansion: Unforgiving Tempest (嵐の領域)
- **Canon ref**: JJA Original Domain Adaptation (Canonically Kashimo used Hollow Wicker Basket).
- **JJA implementation**: `functions/kashimo/kashimo_domain1.mcfunction`, `lightning6.mcfunction`, `storm_domain.mcfunction`.
- **Trigger**: Domain Key (`M`).
- **Cost / Duration / Radius**:
  - Cost: 300 CE.
  - Duration: 50 seconds.
  - Radius: 66-block spherical storm barrier.
- **Sure-Hit Effect**: Continuous lightning strikes every 5 ticks targeting all hostile entities inside the barrier without requiring prior physical contact.
