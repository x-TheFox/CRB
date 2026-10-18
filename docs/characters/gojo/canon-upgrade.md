# Satoru Gojo — Canon Completion & Upgrade Specification

## 1. Missing-Iconic Analysis (Canon Gap Identification)

### 1.1 Long-Distance Teleportation via Spatial Compression
- **Canon Ref**: Chapter 69, 71; Episode 20
- **Gap in JJA**: JJA only offers short combat dashes (`infinity_dash.mcfunction` up to 10 blocks). Gojo's signature long-range teleportation (compressing space between himself and distant coordinates or moving allies instantly) is absent.
- **Java Upgrade Spec**:
  - Ability: **Spatial Compression: Long-Range Teleport**
  - Trigger: Sneak + Aim at target location / waypoint up to 100 blocks away (unrestricted line of sight).
  - Cost: 50 CE (reduced to 2 CE with Six Eyes).
  - Cooldown: 15s.
  - Visual: Instant spatial distortion fold at origin, sudden reappearance at destination with air displacement pop.

### 1.2 Inverted & Variable Domain Barrier Conditions (Basketball Domain)
- **Canon Ref**: Chapters 227–228 (Shinjuku Showdown vs. Sukuna)
- **Gap in JJA**: JJA only implements a static 66-block spherical barrier. It lacks Gojo's tactical barrier refinements used against Malevolent Shrine:
  1. **Inverted Conditions**: Swapping the durability of the inner and outer barrier faces (outer face becomes nearly indestructible against Sukuna's slashes).
  2. **Compressed "Basketball" Domain**: Shrinking the domain down to the size of a small basketball, concentrating barrier density and holding out against Sukuna's open domain for 3 full minutes.
- **Java Upgrade Spec**:
  - Ability: **Domain Refinement: Compressed Barrier (Basketball Domain)**
  - Trigger: While casting Unlimited Void, hold `Shift` + `Ctrl`.
  - Effect: Generates a tight 3-block radius barrier. Players inside are teleported to an isolated metaphysical sub-dimension for 3 minutes, rendering the exterior barrier virtually immune to external domain sure-hits.

### 1.3 Brain RCT Technique Reset
- **Canon Ref**: Chapter 226, 230
- **Gap in JJA**: In JJA, suffering Cursed Technique Burnout locks the player out with `tag @s add cantdomain` for a fixed timer. Gojo canonically destroys the part of his brain responsible for CT with cursed energy and immediately heals it with Reverse Cursed Technique to bypass technique burnout instantly!
- **Java Upgrade Spec**:
  - Ability: **Risky RCT: Brain Reset**
  - Trigger: Attempting to cast Limitless while on CT Burnout.
  - Cost: 100 CE + 20% max HP self-inflicted damage.
  - Effect: Instantly resets technique burnout, but increases a hidden cumulative brain strain counter. Casting this 5 times in a single combat session inflicts severe internal brain hemorrhage, disabling Domain Expansion for 1 hour.

---

## 2. Fidelity Corrections (Where JJA Contradicts Canon)
1. **Red Repulsion Mechanics**: In JJA, Red is often a simple fire explosion (`damages/fire_damage`). In canon (Chapter 71), Red is pure kinetic divergence and repulsion, NOT fire. It should deal kinetic force and blunt trauma rather than igniting targets.
2. **Infinite Information Rate**: In JJA, Unlimited Void deals flat physical damage ticks. In canon (Chapter 15), the damage is purely neurological overload. In CRB, trapped entities should take 0 physical damage initially, but suffer escalating paralysis and neural fatigue that permanently slows their reaction times until healed by advanced RCT.

---

## 3. Flagged Judgment Calls (Orchestrator Adjudication)
- **Judgment Call 1: Unrestricted 200% Hollow Purple Range**:
  - Option A: Allow 200% Purple to travel infinite chunks, chunkloading as it moves.
  - Option B: Cap at 160 blocks (render distance ceiling).
  - *Ruling*: **Option B (160 blocks max)**. Uncapped cross-chunk mass deletion presents severe server lag and memory leak risks. 160 blocks fully covers any visible battlefield while remaining multiplayer-safe.
