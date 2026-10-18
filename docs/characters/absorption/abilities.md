# Kinetic & Curse Absorption — Abilities & Kit Specification

## 1. Innate Passive: Damage Storage Meter (蓄積メーター)
- **JJA implementation**: Scoreboard objective `absorption`.
- **Mechanics (Server-Authoritative)**:
  - Whenever the user receives damage from an entity or projectile while guarding or unsealed, 50% of the raw damage is absorbed into the `AbsorptionChargeAttachment` (Max cap: 100 points).
  - Absorbed damage reduces physical health loss by 30%.
  - Stored energy decays slowly at 1 point per 4 seconds outside combat.

---

## 2. Electric Counter-Punch (放電撃)
- **JJA implementation**: `absorption1.mcfunction`, `animation.absorption.ab1`.
- **Cost / CD**: 20 CE + 10 Stored Charge / 3s cooldown.
- **Effect**: Fast straight punch that discharges stored energy in a blinding spark, dealing 12 damage + 50% of consumed charge.

---

## 3. Kinetic Ward & Repulsion Shockwave (衝撃波放出)
- **JJA implementation**: `absorption2.mcfunction`, `absorption3.mcfunction`.
- **Cost / CD**: 40 CE + 20 Stored Charge / 6s cooldown.
- **Effect**: Forms a spherical purple energy shield for 20 ticks. If struck, immediately triggers a 360-degree shockwave repelling all surrounding enemies 10 blocks away with 18 damage.

---

## 4. Sustained Plasma Beam (収束光線砲)
- **JJA implementation**: `absorption6.mcfunction`, `beam.mcfunction`.
- **Cost / CD**: 75 CE + 40 Stored Charge / 12s cooldown.
- **Effect**: Fires a continuous high-density plasma beam forward across 30 blocks. Deals scaling damage proportional to stored charge (`damage += absorption / 10`), piercing through groups of enemies.

---

## 5. Ultimate: Cataclysmic Supernova Detonation (核融合崩壊)
- **JJA implementation**: `absorption8.mcfunction`, `music.nuke`, `ds:turbo_intensity2..3b`.
- **Cost / CD**: 150 CE + 80 Minimum Stored Charge (Consumes 100% of stored charge) / 60s cooldown.
- **Cinematic Protocol**:
  - Free camera pulls back 40 blocks above and 40 blocks backward.
  - The user floats into the air, charging an incandescent golden/crimson sphere.
  - Sub-bass rumble accompanied by the ominous `music.nuke` soundtrack.
  - Detonation: 25-block catastrophic radius explosion dealing 70 true damage, obliterating terrain (if block griefing is enabled in config), and knocking all entities to the horizon.
