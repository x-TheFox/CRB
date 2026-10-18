# Jogo — Abilities & Kit Specification

## 1. Primary Pyrokinesis: Flamethrower & Fire Palm (噴火)
- **Canon ref**: Chapters 12–13, 111 / Episode 7, Season 2 Episode 14
- **JJA implementation**: `items/disaster_flames/flames.json` (`ds:flames1`), `functions/flames/flames1.mcfunction`, `firepalm.mcfunction`.
- **Cost / Cooldown / Duration / Range**: 30 CE / 3s / 40 ticks / 15 blocks forward cone.
- **Damage / Effect**: Emits a sustained stream of superheated magma fire from palms; inflicts 20 fire damage per second and sets targets on fire for 80 ticks.

## 2. Volcanic Familiars: Ember Insects (火礫蟲, Karekichū)
- **Canon ref**: Chapter 13, 115 / Episode 7, Season 2 Episode 15
- **JJA implementation**: `items/disaster_flames/flames (1) - Copy.json` (`ds:flames2`), `functions/flames/ember_insects.mcfunction`, `ember_insect_explode.mcfunction`.
- **Cost / Cooldown / Range / Area**: 60 CE / 8s / 25 blocks homing flight.
- **Damage / Effect**: Spawns 4 flying winged volcanic insects with barbed stingers. Insects home in on nearby enemies, emitting a high-pitched buzzing shriek before detonating in concussive sound and flame explosions dealing 35 damage each.

## 3. Disaster Fireball & Ash Slam
- **Canon ref**: Chapter 115 / Season 2 Episode 15
- **JJA implementation**: `items/disaster_flames/flames (2) - Copy.json` (`ds:flames3`), `functions/flames/fireball.mcfunction`, `functions/flames/flamechoke.mcfunction`.
- **Cost / Cooldown**: 45 CE / 6s.
- **Damage / Effect**: Launches a dense sphere of molten rock and fire dealing 40 impact damage. Sneak variant executes **Flame Choke**: grabs opponent by the neck and channels internal volcanic fire into their lungs.

## 4. Volcanic Launch & Eruption Geysers
- **Canon ref**: Chapter 13, 115 / Episode 7
- **JJA implementation**: `items/disaster_flames/flames (4) - Copy.json` (`ds:flames5`), `functions/flames/firewall.mcfunction`, `firewall2.mcfunction`.
- **Cost / Cooldown**: 70 CE / 10s.
- **Damage / Effect**: Stomp on the ground erupts a mini-volcanic crater beneath the target's feet, blasting molten rock skyward and launching them 15 blocks into the air.

## 5. Maximum Technique: Meteor (極ノ番「隕石」, Gokunoban: Inseki)
- **Canon ref**: Chapter 115 / Season 2 Episode 15
- **JJA implementation**: `items/disaster_flames/flames (5) - Copy.json` (`ds:flames6`), `functions/flames/meteor.mcfunction`, `functions/flames/meteorland.mcfunction`.
- **Cost / Cooldown / Duration / Range / Area**:
  - Cost: 300 CE.
  - Cooldown: 60s.
  - Duration: 80 ticks descent time.
  - Range: 60 blocks target radius; 35 block catastrophic explosion crater.
- **Damage / Effect**:
  - Summons a colossal burning celestial asteroid from the upper stratosphere.
  - The meteor casts a massive shadow over the battlefield before smashing into the earth.
  - Deals 200 explosive and fire damage to all entities within 35 blocks; completely levels buildings and transforms terrain into molten obsidian and lava.
- **Windup / Active / Recovery frames**: 50 ticks continuous channeling with arms raised high.
- **VFX**: Sky turns fiery orange; massive glowing volcanic boulder with smoke plume descends; cataclysmic screen-filling shockwave on impact (`particles/flames/meteor_crater.json`).
- **SFX / Voice**: Voice chant: *"Gokunoban... Inseki!"* Deep rumbling roar shaking the sub-woofers, followed by an earth-shattering impact detonation.

## 6. Domain Expansion: Coffin of the Iron Mountain (蓋棺鉄囲山)
- **Canon ref**: Chapters 14–16 / Episode 7
- **JJA implementation**: `items/disaster_flames/domain.json` (`ds:flames7`), `functions/flames/domain.mcfunction`, `functions/flames/IronMountain`.
- **Cost / Cooldown / Duration / Range**: 350 CE / 180s / 30s / 66 block spherical domain.
- **Damage / Effect**:
  - Transports targets inside the volcanic chamber of an active volcano.
  - **Thermal Aura**: The ambient temperature is so intense that standard non-sorcerer entities combust immediately upon entry.
  - **Sure-Hit: Magma Rock Spikes**: Sharp volcanic boulder spears manifest directly on the surface of the target's body with guaranteed tracking.
