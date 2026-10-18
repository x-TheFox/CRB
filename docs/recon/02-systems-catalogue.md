# Reconnaissance Report 02: Systems Catalogue

## 1. Overview
This catalogue defines all supporting systems discovered within the Jujutsu Awakening (JJA) addon, detailing their Bedrock mechanics, the underlying constraints that forced their design, and the architectural replacement direction for **Cursed Reality: Boundless (CRB)** on NeoForge 1.21.1.

---

## 2. Cursed Energy & Regeneration Economy

### 2.1 JJA Addon Behavior
- **Energy Pool**: Managed via the `Energy` scoreboard objective (starts at 100, capped by `EnergyCap`).
- **Passive Regen**: Increments `Energy` every \(N\) ticks determined by `ceregen` and player's `energystat` score.
- **Active Charging**: Sneaking while holding `ds:cursedenergy` accelerates energy regeneration (`functions/ce/charge.mcfunction`).
- **Energy Depletion**: Every ability checks `if score @s Energy >= <cost>` and removes that amount. If depleted, ability execution fails with a subtitle warning (`§cNot Enough Cursed Energy!`).
- **Zero-CE Restriction**: Players with Heavenly Restriction (`tag @s add heavenlyrestriction`) have `Energy` hard-locked to 0 and their CE bar hidden.

### 2.2 Bedrock Constraint
Bedrock has no custom entity data attachments or custom player capability channels; everything had to be routed through public scoreboard objectives visible to all players.

### 2.3 CRB Java-Native Replacement Direction
- Implemented as a NeoForge **Data Attachment** (`CursedEnergyData`) attached directly to `ServerPlayer`.
- Replaces scoreboard poll with server-authoritative tick calculation with client synchronization via custom packet payload (`SyncCursedEnergyPacket`).
- Replaces holding a dummy charging item with a dedicated configurable **Focus / Charge Keybind** (default: `C`).

---

## 3. Stat & Progression Economy

### 3.1 JJA Addon Behavior
- **Experience & Levels**:
  - `Exp` / `ExpMax`: Starting at 0/30, scaling upward with each level.
  - `level`: Grants 2 `invest` stat points per level (`The Prodigy` trait doubles this to 4).
  - `grade`: Grades 4 through 1, Semi-Grade 1, and Special Grade. Promotions managed via `ds:promotion` papers (`functions/promotion.mcfunction`).
- **Attributes**:
  - `strength`: Modifies melee strike damage (`BasicM1s`, `Flourish`).
  - `agility`: Modifies movement speed attributes, sprint velocity, and water-run duration.
  - `endurance`: Adds hearts (`health_boost` effect in Bedrock) and reduces incoming damage.
  - `energystat`: Expands `EnergyCap` and reduces cooldown recovery durations.
- **Stat Manual**: Opening `ds:stats_book` displays an interactive scoreboard chat menu where players click tellraw links to allocate `invest` points (`functions/stat_give.mcfunction`).

### 3.2 Bedrock Constraint
Bedrock cannot render interactive attribute distribution GUI screens without complex JSON-UI hacks or ActionFormData dialogs that lock user input.

### 3.3 CRB Java-Native Replacement Direction
- Dedicated **Sorcerer Status Screen** (keybind `K` or radial submenu) featuring an anime-styled character silhouette, radar attribute chart, current Grade badge, and responsive point allocation buttons.
- Grade ranking unlocks access to higher-tier mission contracts, special-grade cursed tool attunement, and Domain Expansion viability.

---

## 4. Character Acquisition & Gacha Loop

### 4.1 JJA Addon Behavior
- **Initial Roll**: New players receive 3 Clan rolls, 3 Trait rolls, and 3 Technique rolls.
- **Clans**:
  - Clanless (73%), Inumaki (11%), Kamo (7%), Zenin (6%), Gojo (3%).
  - Clans provide innate trait roll boosts (e.g., Gojo clan unlocks `The Six Eyes` trait).
- **Traits**:
  - Common: Enhanced Strength (+5), Quick Feet (+5), Faster Energy Charge, Alley Cat.
  - Uncommon: 530,000 IQ, Tactical Intellect, Exoskeleton, Satiated by Cursed Energy, Lone Wolf.
  - Rare: Rough Cursed Energy, Blessed Strength (+12 STR/AGI), RCT Master, The Prodigy (2x invest points), Restless Gambler, Boundless Cursed Energy, Undying Will, Insanity.
  - Exotic: Heavenly Restriction: Unmeasured Strength (Toji/Maki physical body), 120% of Potential (+20% stat caps), Delusional Idol Fan, Prince of Black Sparks.
  - Honored: The Six Eyes (massively reduced CE costs, infinite sensory range).
- **Techniques**:
  - Common: Immobilizing Sight, Miracles, Pain-Killer.
  - Uncommon: Explosive Cursed Energy, Wind-Up.
  - Rare: Cursed Speech, Absorption, Boogie-Woogie.
  - Exotic: Judgeman, Private Pure Lovetrain.
  - Honored: Limitless, 10 Shadows, Mythical Beast Amber.
  - Dishonored (Curses): Disaster Flames, Idle Transfiguration.
- **Special Vessel Acquisition**: Sukuna is acquired by finding and consuming `ds:sukuna_finger` (`functions/relics/sukuna_finger.mcfunction`). Each finger rolls a survival check based on endurance; surviving grants Sukuna Vessel status and progressively unlocks Sukuna's kit.

### 4.2 Bedrock Constraint
Relied on blind-folding title camera hacks (`camera @s fade`, font sprites in actionbar) and chat-command buttons to simulate slot machines.

### 4.3 CRB Java-Native Replacement Direction
- First-time character setup GUI with polished Jujutsu High enrollment theme.
- Configurable server option (`strict_canon_mode` vs `gacha_mode`): allows servers to assign specific canon kits directly via commands (`/jjk kit give <player> <technique>`) or maintain the survival roll experience.

---

## 5. Anti-Domain Arts

### 5.1 JJA Addon Behavior
- **Simple Domain**: `functions/simple_domain.mcfunction` spawns a stationary circle marker entity at the player's feet, granting `tag @s add simpledomain_protecting` for 10–20 seconds. It neutralizes sure-hit attacks inside hostile domain barriers. Moving outside the circle immediately cancels the protection.
- **Domain Amplification**: `functions/particles/domainamplification.mcfunction` wraps the player's body in a dense aura. It nullifies Gojo's neutral Infinity and halves incoming technique damage, but forcibly disables the user's own Cursed Technique for its duration.
- **Falling Blossom Emotion**: `fallingblossomown` intercepts incoming sure-hit strikes by coating the user in reactive cursed energy, counter-slashing incoming attacks.
- **Hollow Wicker Basket**: `hollowbasketown` creates a woven wire-like barrier around the caster, neutralizing the domain barrier's sure-hit formula while leaving hands occupied.

### 5.2 CRB Java-Native Replacement Direction
- Integrated directly into the **Domain Engine**:
  - Simple Domain creates a server-authoritative 3D protective volume around the player.
  - If the player runs or attacks aggressively, Simple Domain stability decays.
  - Domain Amplification renders as a chromatic-aberration body cloak (Veil shader) and applies an entity capability modifier that pierces defensive passive barriers (such as Gojo's Infinity).

---

## 6. Missions & World Encounters

### 6.1 JJA Addon Behavior
- **Mission Phone**: `items/phone.json` (`ds:phone`) initiates an incoming phone call (`functions/missions/phone_call.mcfunction`) with ringtone SFX.
- **Mission Grades**: Grade 4 up to Special Grade missions.
- **Mission Types**:
  - Cursed Spirit Extermination (spawn wave of curses in target radius).
  - Star Plasma Vessel Escort (escort Riko Amanai from assassins, `functions/missions/vessel_mission/*`).
  - Boss Hunts (Toji Fushiguro, Special Grade Finger Bearer).
- **Mission Cooldown**: Tracked by `missionsCD` objective.
- **Ambient Mob Events**: Every 20 minutes (`mobeventmax = 7200` ticks), an ambient cursed spirit outbreak triggers across the world (`functions/mobevents/_mobevent_random.mcfunction`).

### 6.2 CRB Java-Native Replacement Direction
- Server-authoritative **Mission Director**:
  - Spawns instanced or localized objective areas with objective trackers in the HUD.
  - Incorporates SmartBrainLib for tactical cursed spirit mob AI (flanking, swarming, retreating when outmatched).
  - Rewards players with Jujutsu Society currency, promotion credits, and cursed tool materials.

---

## 7. Cursed Tools & Special Grade Relics

### 7.1 JJA Addon Behavior
The addon implements 20+ specialized weapons and relics in `items/weps/` and `items/relics/`:
- **Inverted Spear of Heaven** (`ds:inverted_spear`): Bypasses all defensive cursed techniques (nullifies Infinity, dispels barriers).
- **Split-Soul Katana** (`ds:soul_sword`): Ignores physical armor and strikes the soul directly, dealing true damage that cannot be healed by normal RCT.
- **Playful Cloud** (`ds:playful_cloud` & `ds:playful_cloud_sharpened`): Special Grade tool with no innate technique; scales purely with the user's physical strength stat.
- **Slaughter Demon** (`ds:slaughter_demon`): Early-game cursed dagger with two small serrated blades.
- **Hiten & Kamutoke**: Sukuna's legendary Heian tools (Kamutoke emits lightning bolts, Hiten delivers wide cleaving storms).
- **Sukuna's Fingers** (`ds:sukuna_finger`): 20 collectible fingers. Consuming unlocks Sukuna progression.

### 7.2 CRB Java-Native Replacement Direction
- Custom Java weapon items with unique attack attributes, attack ranges, custom GeckoLib 3D models and animations, and capability integration (e.g., Inverted Spear of Heaven applies `NullifyCursedTechnique` event on hit).
