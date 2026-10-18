# Satoru Gojo — Summons & Spawned Entities

## 1. Entity Registry & Role
While Satoru Gojo does not command shikigami, his technique manifests persistent physical and metaphysical entities:

| Identifier | Name | Lifecycle | AI / Physics Behavior |
|------------|------|-----------|------------------------|
| `ds:familiar_entity` (tagged `blue_singularity`) | Blue Gravitational Orb | 3–6 seconds (`Deleter` timer) | Stationary or linear vector flight; exerts continuous gravitational pull on all non-owner entities within 15 blocks. |
| `ds:familiar_entity` (tagged `red_bead`) | Red Repulsive Projectile | 2 seconds | High-velocity raycast projectile (velocity multiplier 4.5); on impact spawns repulsive physics explosion and despawns. |
| `ds:hollow_purple_projectile` | Hollow Purple Imaginary Mass | 8 seconds | Unstoppable forward line entity; deletes blocks in collision box and applies true damage. |
| `ds:domain_barrier` | Unlimited Void Outer Barrier | 30 seconds (or 0.2s) | 66-block radius hollow spherical collision barrier; completely opaque to outside observers; impenetrable except with anti-domain barrier arts. |
| `ds:domain_barrier_inside` | Unlimited Void Inner Universe | 30 seconds | Interior sensory projector applying continuous mental overload ticks to occupants. |
| `ds:student_gojo` / `ds:student_gojo2` | Teen Gojo (Boss Encounter) | Persistent until defeated | AI boss sorcerer implementing teen Gojo moveset (pre-awakening and post-awakening). |

## 2. Server Authority & Despawn Guarantees
All spawned entities are bound to the caster's session UUID. If Gojo logs out, dies, or suffers technique burnout, all active Blue singularities, Red orbs, and domain barriers are automatically dismantled by the server tick listener.
