# Yuji Itadori — Domain Expansion: Shrine of Reverie (虎杖悠仁の領域)

## 1. Concept & Canon Reference
- **Name**: Shrine of Reverie / Yuji's Domain (虎杖悠仁の領域展開)
- **Canon Ref**: Jujutsu Kaisen Chapters 264–268 (Shinjuku Showdown Climax)
- **Core Concept**: Yuji's domain takes the appearance of his hometown in Sendai and a nostalgic, snow-swept rural train station platform. Rather than opening with immediate violence, the domain creates a metaphysical space where Yuji attempts to guide Sukuna toward peace. When combat begins, the domain's sure-hit inflicts Soul Dismantles directly onto the enemy's soul boundary with every physical strike.

---

## 2. JJA Bedrock Mechanics & Forensic Evidence
- **Trigger**: `items/yuji/soul_shrine1 - Copy.json` (`ds:soul_shrine2`)
- **Execution Pipeline**: `functions/yuji/memories_shrine.mcfunction`, `functions/yuji/domain_blackflash.mcfunction`
- **Structure**: Clones an instanced train platform arena with snowy floor blocks and lampposts.
- **Sure-Hit**: Applies continuous soul damage ticks and guarantees Black Flash on combo completion (`domain_blackflash.mcfunction`).

---

## 3. Java-Native Evolution (CRB Architecture)

### 3.1 Domain Geometry & Arena Engine
- **Enclosed Barrier**: 66-block spherical barrier generated with a rusted iron railway bridge texture on the outside.
- **Interior Environment**: Completely transforms the interior into a quiet snowy train station at dusk. Includes station platform tiles, waiting benches, incandescent yellow lights, and a railway track stretching into foggy oblivion.
- **Ambient Effects**: Light snowflakes falling, gentle winter breeze audio, ambient train bells.

### 3.2 Sure-Hit Formula: Boundless Soul Dismantle
- Every strike landed by Yuji inside the domain strikes the core of the soul with sure-hit accuracy (cannot be dodged by normal movement or agility).
- **Vessel Severing Effect**: Against possessed or reincarnated sorcerers (such as Sukuna inside Megumi), each punch reduces soul synchronization by 5%. When synchronization reaches 0%, the foreign soul is forcefully expelled from the host body!
- **Black Flash Resonance**: Every 4th consecutive hit inside the domain automatically triggers a Black Flash with full visual impact frames.
