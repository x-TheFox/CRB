# Hiromi Higuruma — Abilities & Kit Specification

## 1. Gavel Morphing & Dynamic Weapon Mastery
- **Canon ref**: Chapters 164–165 (vs Yuji Itadori)
- **JJA implementation**: `gavel1_m1s.mcfunction`, `gavel2_m1s.mcfunction`, `gavel3_m1s.mcfunction`, `gavel_switch.mcfunction`, `minimum.mcfunction`, `maximum.mcfunction`.
- **Trigger**: Primary Weapon / Shape Shift key (`Z`).
- **Gavel Forms**:
  1. **Standard Gavel (Form 1)**: Fast 1-handed bludgeon (5 damage, 0.4s cooldown).
  2. **Telescoping Gavel / Grapple (Form 2)**: Extended handle reach up to 12 blocks, hooks enemies and drags them into melee range.
  3. **Colossal Mallet (Form 3 - Maximum Output)**: Massive 4x size gavel dropped overhead, dealing 28 crushing damage and creating a 5-block ground fissure.
- **VFX / SFX**: Wooden crack, golden CE spark, whoosh and heavy thud on impact.

---

## 2. Domain Expansion: Deadly Sentencing (誅伏賜死, Chūbuku Shishi)
- **Canon ref**: Chapters 164, 165, 166, 244–245
- **JJA implementation**: `judgeman/deadly_sentencing.mcfunction`, `deadlysentencing_start.mcfunction`, `trial_set.mcfunction`, `tag=the_judge`.
- **Cost / Cooldown / Duration**:
  - Cost: 100 CE (Extremely cheap due to non-lethal nature and lack of built-in damage sure-hit).
  - Cooldown: 40 seconds.
  - Duration: Until verdict is delivered (max 90 seconds).
- **Core Rules (Server-Authoritative Enforcement)**:
  - **Absolute Non-Violence (暴力禁止の縛り)**: All attacks, damage events, projectile firings, and ability inputs are intercepted and canceled by the server.
  - **Trial Podiums**: Higuruma, the Defendant, and Judgeman are spawned at predetermined courtroom positions facing the center.
  - **Judgeman's Docket**: Judgeman opens an envelope containing a random verified crime committed by the defendant (e.g. killing villagers, stealing from chests, PVP murder, entering buildings without permission).
- **Defendant's Choices**:
  1. *Silence* (黙秘) — Forfeits defense; guaranteed guilty verdict.
  2. *Confession* (自白) — Admits guilt; penalty is mitigated if minor, but confiscation applies.
  3. *Denial / Defense* (否認 / 弁明) — Present counter-statement; Judgeman compares with packet evidence.

---

## 3. Sentences & Penalties
- **Confiscation (没収, Bosshū)**:
  - **Canon Rule**: If the defendant possesses a Cursed Tool, the tool is confiscated first (Sukuna Kamutoke loophole, Chapter 245). If no cursed tool, their Innate Technique is completely locked for 60 seconds (or permanent until Higuruma is defeated). If no CT and no cursed tool, their Cursed Energy manipulation is disabled entirely.
  - **JJA parity**: `confiscate` scoreboard sets target's abilities `ability1..8` to disabled cooldown lock.
- **Death Penalty (死刑, Shikei)**:
  - Awarded for high-severity crimes (murder, mass slaughter, multiple counts).
  - Judgeman summons the **Executioner's Sword** directly into Higuruma's hand.

---

## 4. Executioner's Sword (処刑人の剣)
- **Canon ref**: Chapters 166, 246–247
- **JJA implementation**: `functions/fighting/executionsword/`, `death_sentence_hit.mcfunction`, `items/executionsword.json`.
- **Cost / Duration**:
  - Cost: Granted exclusively via Death Penalty verdict.
  - Duration: Lasts until Higuruma dies or strikes the condemned target.
- **Sure-Kill Mechanics (Server-Authoritative)**:
  - Deals **absolute instant death** to the designated condemned target upon receiving any contact damage (`damage @s 999999 override`).
  - Completely bypasses armor, totem of undying, resistance potion effects, and domain barriers.
  - Harmless to non-condemned third parties (acting as an ordinary blunt prop).
  - If passed to an ally (canon Sukuna raid), retains its one-hit-kill attribute against the condemned subject as long as Higuruma lives.
