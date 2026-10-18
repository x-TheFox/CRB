# ADR-005: Domain Expansion & Clashing Architecture

**Status**: **ACCEPTED**  
**Deciders**: Orchestrator (Autonomous Systems Architect)  
**Date**: 2026-10-18  

---

## 1. Context & Problem Statement
In JJA Bedrock, domain clashing was handled via `domain_clashing.js` which compared tick scores (`domainclash1`, `domainclash2`), summoned structure blocks, and teleported players.
In CRB Java Edition, Domain Expansions are the pinnacle of Jujutsu combat. The engine must support:
- Standard enclosed spherical barriers (66 blocks diameter).
- Open-barrier domains with an expansive physical radius (Malevolent Shrine: 200 blocks radius).
- Non-lethal courtrooms (Deadly Sentencing) and gacha domains (Idle Death Gamble).
- Mathematical 3-way and 2-way domain clashing with barrier tug-of-war.

---

## 2. Decision: `DomainManager` World Subsystem

### 2.1 Domain Instance Lifecycle
1. **Invocation**:
   - Player casts Domain Expansion.
   - Hand sign animation plays (`PlayerAnimationLib`).
   - Server registers an active `DomainInstance` anchored at `(x, y, z)`.
2. **Barrier Formation**:
   - An enclosed domain creates a physical boundary preventing unauthorized exit.
   - Zero-CE individuals (Toji/Maki) pass through freely.
   - Exterior barrier is rendered via Veil stencil shader (reflective black/slate sphere); interior generates custom skybox and terrain overlay without overwriting world blocks destructively.
3. **Sure-Hit Loop**:
   - Every tick, the domain iterates over all entities inside its volume.
   - Evaluates defense conditions:
     - Is target protected by Simple Domain? -> Sure-hit negated.
     - Is target using Domain Amplification? -> Sure-hit negated/reduced.
     - Is target using Falling Blossom Emotion? -> Counter-strikes sure-hit.
     - Is target zero-CE? -> Target ignored.
   - If undefended, applies authoritative sure-hit payload.

---

## 3. Domain Clashing Algorithm
When two or more domain expansions overlap in volume:
1. **Sure-Hit Neutralization**: Both sure-hit effects immediately cancel each other out in the overlapping volume.
2. **Clash Refinement Rating ($R$)**:
   $$R = \text{BaseRefinement} + (\text{CurrentCE} \times 0.2) + (\text{SorcererGrade} \times 10) + \text{EnvironmentalAdvantage}$$
3. **Barrier Tug-of-War**:
   - The boundary between the domains shifts dynamically toward the domain with lower refinement.
   - If $\Delta R > 50$, the weaker domain cracks, suffers barrier shatter, and immediately collapses, leaving the losing caster in CT Burnout.
4. **Open-Barrier vs Closed Barrier (Sukuna vs Gojo Rule)**:
   - An open domain has no outer shell to clash against; instead, its sure-hit strikes the **exterior** of the closed domain's barrier from the outside.
   - Because closed barriers are fragile to external impacts, the closed domain barrier shatters after 60 ticks unless reinforced via binding vows (shrinking barrier size to basketball size).
