# Aoi Todo — Summons & Entities Specification

## 1. Entities & Projectiles
- **Cursed Pebble Entity (`crb:cursed_pebble`)**:
  - Small physics projectile inheriting from `ThrowableItemProjectile`.
  - Imbued with a minimum threshold of Cursed Energy (10 CE), making it a valid target for Boogie Woogie swap while airborne or lodged in blocks.
- **Playful Cloud Cursed Tool Entity (`crb:playful_cloud`)**:
  - Special Grade cursed tool with 3 segmented red staffs connected by chains.
  - Can be thrown or dropped into combat zones to act as an anchor point for swap tactics.
- **Takada-chan Hallucination (`crb:takada_hallucination`)**:
  - Client-side visual entity appearing behind Todo during the 530,000 IQ mental sequence.
- **Boss Entity (`crb:todo_boss`)**:
  - SmartBrainLib AI with advanced behavioral tree:
    - Analyzes incoming player attack vectors and executes instantaneous counter-swaps.
    - Uses pebble tosses when player attempts to kite or keep distance.
    - If fighting alongside Yuji Itadori, coordinates alternating pincer attacks.
