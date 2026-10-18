# Hiromi Higuruma — Domain Expansion: Deadly Sentencing (誅伏賜死)

## 1. Domain Structure & Architecture
- **Barrier Type**: Old-style Non-Lethal Domain Expansion with a 50-block cubical courtroom interior.
- **Visuals**:
  - Grand mahogany courtroom with high ceilings, judicial bench, witness stand, defense and prosecution tables.
  - Giant hovering Judgeman behind the judge's podium holding scales and balance weights.
- **Binding Vow: Absolute Non-Violence**:
  - The moment the barrier forms, both the user and all occupants enter an inviolable binding vow of non-violence.
  - Any attempt to swing weapons, fire arrows, cast abilities, or drink potions is canceled server-side.

## 2. Server-Authoritative Trial Protocol
1. **Accusation Phase (0s–10s)**:
   - Server reads defendant's statistic tracker (e.g. `minecraft:player_kills`, `minecraft:mob_kills`, or custom CRB crime ledger).
   - Judgeman pronounces accusation in chat and via GUI modal: *"Defendant [Name] is charged with the crime of [Charge]!"*
2. **Defense Phase (10s–30s)**:
   - Interactive UI prompt appears on defendant's screen offering three actions:
     - **[1] Silence**
     - **[2] Confession**
     - **[3] Defense / Denial**
   - Higuruma receives counter-evidence packet in his GUI.
3. **Verdict Phase (30s–45s)**:
   - Judgeman evaluates the defense.
   - Triple gavel strike echoes:
     - **Innocent**: Domain dissolves immediately; Higuruma suffers 15s CT burnout.
     - **Guilty - Confiscation**: Defendant loses Cursed Technique (or Cursed Tool) for 60 seconds.
     - **Guilty - Death Penalty**: Defendant loses CT AND Higuruma is awarded the Executioner's Sword. Domain dissolves and active combat resumes.
