# Aoi Todo — Abilities & Kit Specification

## 1. Boogie Woogie: Self-Target Position Swap (不義遊戯・単体転移)
- **Canon ref**: Chapters 34, 49–53 / Episode 19–20
- **JJA implementation**: `boogie1.mcfunction`, `swap.mcfunction`, `instant_clap.mcfunction`, tag `swapper`/`swapped`.
- **Trigger**: Ability Key 1 (`Z` or Primary Ability key).
- **Cost / Cooldown / Range**:
  - Cost: 25 CE.
  - Cooldown: 1.5s (0.2s with Vibraslap).
  - Range: 32 blocks (scaled by CE output).
- **Damage / Effect**:
  - Instantly swaps exact coordinates and momentum between Todo and the crosshair-targeted entity containing Cursed Energy.
  - Disorients victim: turns victim's view pitch/yaw 180 degrees away, canceling their active melee windup.
- **Frames**: 1-tick clap action, instantaneous translation, 2-tick recovery.
- **VFX / SFX**: Hand clap animation, spatial blur particle burst (`ds:boogie_woogie_tp`, `ds:boogie_woogie_tp2`), crisp metallic hand clap audio (`crb:todo.clap`).
- **Multiplayer safety**: Server-authoritative position exchange with chunk boundary checks and anti-suffocation elevation safety.

---

## 2. Imbued Cursed Energy Pebble Swap (呪力籠めた小石転移)
- **Canon ref**: Chapter 127 (Todo vs Mahito)
- **JJA implementation**: `boogie_woogie/pebble.mcfunction`, `pebble_land.mcfunction`, entity `ds:pebble`.
- **Trigger**: Ability Key 2 (`X`).
- **Cost / Cooldown / Range**:
  - Cost: 35 CE.
  - Cooldown: 4 seconds.
  - Range: Thrown projectile range (up to 45 blocks).
- **Damage / Effect**:
  - Throws a high-velocity pebble imbued with cursed energy.
  - Todo can trigger a clap mid-flight or upon pebble landing, swapping himself or an enemy with the projectile.
  - Allows extreme vertical recovery or offensive repositioning behind flying enemies.

---

## 3. Third-Party Double Entity Swap (第三者相互転移)
- **Canon ref**: Chapter 52 (Hanami fight: swapping Yuji and Hanami, or Hanami and Playful Cloud)
- **JJA implementation**: `boogie3.mcfunction`, `swap_others.mcfunction`, `select_target.mcfunction`.
- **Trigger**: Ability Key 3 (`C`).
- **Cost / Cooldown / Range**:
  - Cost: 45 CE.
  - Cooldown: 3.5 seconds.
  - Range: 25 blocks radius around Todo.
- **Damage / Effect**:
  - Selects Target A and Target B within line of sight and swaps their positions without moving Todo.
  - Can swap an ally out of a lethal attack trajectory while swapping the attacker into their own crossfire.

---

## 4. Fake Clap Mind Games (フェイククラップ)
- **Canon ref**: Chapter 130 (vs Mahito)
- **JJA implementation**: `swap_notarget.mcfunction`.
- **Trigger**: Ability Key 4 (`V`).
- **Cost / Cooldown**:
  - Cost: 5 CE.
  - Cooldown: 0.8s.
- **Effect**:
  - Todo visibly claps hands with full audio and particle effect, but no swap occurs.
  - If target entity is currently shielding or parrying in anticipation of a swap, their guard is broken and they suffer 15 ticks of Stun.

---

## 5. "What Kind of Woman Is Your Type?!" & Brother Link (魂の親友)
- **Canon ref**: Chapter 35 (vs Megumi), Chapter 50 (vs Yuji)
- **JJA implementation**: `ask_brother.mcfunction`, `women_type1..8.mcfunction`, `brother_tag.mcfunction`, `swap_brother.mcfunction`.
- **Trigger**: Radial Interaction on another player.
- **Effect**:
  - Prompts target player with Todo's quintessential philosophical question.
  - If the player responds with a compatible answer (e.g. "A tall woman with a big ass... like Takada-chan!"), a deep memory of a nonexistent high school life awakens.
  - Target receives the `brother_tag`.
  - **Brother Synergy**:
    - Swapping with your Brother costs 50% less CE.
    - Synchronized attacks grant +25% Black Flash chance when striking within 0.5s of a swap.

---

## 6. Cinematic 530,000 IQ Black Flash Beatdown (最高峰の連撃)
- **Canon ref**: Chapters 127–132 (Shibuya vs Mahito)
- **JJA implementation**: `plus_ultra.mcfunction`, `plus_ultra_victim.mcfunction`, tag `plusultra`.
- **Cost / Cooldown**:
  - Cost: 180 CE.
  - Cooldown: 45 seconds.
- **Damage / Effect**:
  - Cinematic camera lock on victim.
  - Todo executes 6 blinding rapid swaps from different compass vectors, delivering brutal liver blows, flying knee strikes, and concluding with a guaranteed Black Flash right hook dealing 45 hearts damage.
  - Summons `gg:impact_frame`, screen shake 4.0, chromatic aberration.
