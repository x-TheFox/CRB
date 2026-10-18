# Hiromi Higuruma — JJA Parity Matrix

| Feature / Move | JJA Implementation | CRB Java Implementation | Parity / Elevation Status |
| :--- | :--- | :--- | :--- |
| **Gavel Sizes** | `gavel1..3_m1s.mcfunction`, `gavel_switch.mcfunction` | Seamless dynamic item model transform via GeckoLib & custom reach attribute modifiers | Elevated (Dynamic scaling rather than 3 separate inventory items) |
| **Deadly Sentencing Domain** | `deadly_sentencing.mcfunction`, ticking area ~33, scoreboard resets | Custom pocket dimension courtroom structure with strict server non-violence event canceler | Elevated (Real courtroom worldgen structure, true non-violence event bus) |
| **Trial System** | Text chat broadcast + scoreboard randomized checks | Rich interactive GUI modal with crime logs, evidence cards, and defense statements | Elevated (Complete interactive courtroom trial gameplay) |
| **Confiscation** | Sets `ability1..8` to 50 cooldown on target | Nullifies target's Cursed Technique capability; correctly prioritizes equipped Cursed Tools per canon | Elevated (Prioritizes cursed tool confiscation before technique) |
| **Executioner's Sword** | `death_sentence_hit.mcfunction` commands `damage 999999` | Server-authoritative instant kill hook targeting solely the designated convict UUID | Elevated (Multiplayer-safe UUID target validation, allies can wield it) |
