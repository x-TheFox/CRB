# Satoru Gojo — Domain Expansion: Unlimited Void (無量空処)

## 1. Concept & Canon Reference
- **Name**: Unlimited Void (無量空処, Muryōkūsho)
- **Canon Ref**: Jujutsu Kaisen Chapters 15, 224–230; Anime Episode 7, Season 2 Episode 9
- **Core Concept**: Manifests the metaphysical interior of the Limitless. Rather than physically striking enemies, it forces endless streams of raw information directly into the brain of every living being trapped inside, rendering them completely incapable of thought, perception, or physical movement.

---

## 2. JJA Bedrock Mechanics & Forensic Evidence
- **Trigger**: `items/limitless/limitless6.json`
- **Execution Pipeline**: `functions/limitless/gojo_domain.mcfunction`, `gojo_domain_quick.mcfunction`, `unlimited_void.mcfunction`
- **Barrier Construction**: Spawns a 66-block spherical shell using `ds:domain_barrier` and sets `tag @a[r=66] add domainactive`.
- **Sure-Hit Application**: Executes `functions/damages/unlimitedvoid` every tick against all trapped entities lacking `simpledomain_protecting` or `domainimmune`.
- **Mahoraga Adaptation**: Special logic in `unlimited_void.mcfunction` checks `if entity @e[family=mahoraga]` or entities with `wheelactive=1..` to begin Mahoraga's wheel adaptation countdown.
- **0.2 Second Domain**: `gojo_domain_quick.mcfunction` triggers a 4-tick domain that leaves all non-sorcerer and enemy entities stunned for 600 ticks (30 seconds) while collapsing the barrier immediately.

---

## 3. Java-Native Evolution (CRB Architecture)

### 3.1 Domain Geometry & Arena Engine
- **Closed Spherical Domain**: 66-block radius geometric sphere generated procedurally with black cosmic barrier blocks.
- **Interior Environment**: Completely isolates occupants from the overworld; skybox replaced with an abyss of swirling stellar nebulae, cosmic dust, and radiating neural light paths.
- **Barrier Attributes**: High physical blast resistance; exterior can be broken from the outside with heavy kinetic attacks.

### 3.2 Sure-Hit Formula & Mental Overload
- **Target Selection**: All entities inside the 66-block volume, excluding Gojo and explicitly designated allies touched by Gojo (canon: anyone in physical contact with Gojo is immune to Unlimited Void's sure-hit).
- **Effect**:
  - Trapped targets suffer **Complete Cognitive Paralysis** (`Stun` status effect, packet suppresses mouse look and keyboard inputs).
  - Screen Treatment: Client view fades into radiant white light with swirling translucent kanji overlays; audio cuts out into deep muffled oceanic bass.
  - Cumulative Brain Damage: Prolonged exposure (over 5 seconds) inflicts non-lethal brain damage that temporarily disables the target's ability to cast Domain Expansion for 10 minutes following release.

### 3.3 Domain Clashing Dynamics
- If Sukuna casts Malevolent Shrine simultaneously:
  - Sukuna's open barrier has no outer shell to attack, but its 200-block radius surrounds Unlimited Void's 66-block closed barrier.
  - Sukuna's sure-hit slashes continuously bombard the exterior of Gojo's barrier from outside.
  - Gojo's barrier holds for 3 minutes (or until Gojo inflicts enough damage to collapse Malevolent Shrine).
  - Gojo can invert barrier conditions (making the outside shell impenetrable while softening the inside) via ADR-006 domain refinement options!
