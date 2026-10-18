# Toge Inumaki — Summons & Entities Specification

## 1. Entities & Items
- **Cursed Megaphone Entity & Item (`crb:cursed_megaphone`)**:
  - Imbued tool marked with the Snake and Fangs seal.
  - Expands command range; breaks into shattered pieces if excessive cursed energy is forced through it.
- **Acoustic Shockwave Projectile (`crb:speech_wave`)**:
  - Broad conical wave projectile traveling at 40 blocks/sec.
  - Applies command payload to all entities whose hitboxes intersect the wave volume.
- **Throat Medicine Consumable (`crb:throat_syrup`)**:
  - Fast-acting medicinal syrup (drinking time: 0.8s), restoring vocal integrity.
- **Boss Entity (`crb:inumaki_boss`)**:
  - SmartBrainLib AI that maintains distance, issuing control commands to freeze the player before casting "Plummet" or "Blast Away", and utilizing medicine when injured.
