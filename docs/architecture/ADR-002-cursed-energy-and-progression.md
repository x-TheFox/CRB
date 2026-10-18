# ADR-002: Cursed Energy & Progression Attachment System

**Status**: **ACCEPTED**  
**Deciders**: Orchestrator (Autonomous Systems Architect)  
**Date**: 2026-10-18  

---

## 1. Context & Problem Statement
In JJA Bedrock, cursed energy and progression are managed via scoreboard values:
- `Energy` (Current Cursed Energy)
- `MaxEnergy` (Maximum Cursed Energy Pool)
- `Grade` (Grade 4 to Special Grade)
- `Clan`, `Trait`, `InnateTechnique` (String tags or scoreboard identifiers)
Every tick, `_scores.mcfunction` runs hundreds of execute commands to cap values, regenerate energy, and check requirements.

In NeoForge 1.21.1, we require a high-performance, serialization-safe architecture using native **Data Attachments** that persists across player deaths where appropriate, synchronizes efficiently to client HUDs, and avoids per-tick garbage collection pressure.

---

## 2. Decision: `CursedEnergyData` Attachment

### 2.1 Attachment Structure
```java
public class CursedEnergyData implements INBTSerializable<CompoundTag> {
    private double currentCE;
    private double maxCE;
    private double regenRatePerSecond;
    private double outputEfficiency; // 1.0 base, 0.00001 for Six Eyes
    private SorcererGrade grade;
    private Clan clan;
    private Trait trait;
    private ResourceLocation innateTechnique;
    private boolean isSixEyes;
    private boolean isZeroCE; // Heavenly Restriction
    private int blackFlashStreak;
    private long lastCombatTick;

    // Fast-path methods
    public boolean consume(double amount) {
        double realCost = amount * outputEfficiency;
        if (currentCE >= realCost) {
            currentCE -= realCost;
            return true;
        }
        return false;
    }
}
```

### 2.2 Registration & Persistence
- Registered via `NeoForgeRegistries.ATTACHMENT_TYPES` with `.copyOnDeath()` so players retain their unlocked grade, clan, trait, and innate technique upon death.
- In death scenarios, `currentCE` resets to `maxCE * 0.5`.
- Heavenly Restriction sets `maxCE = 0` and locks all CE gain hooks.

### 2.3 Tick Loop Optimization
- Instead of per-tick networking packets, the server batches CE regeneration:
  - Updates internal double value every server tick.
  - Sends a sync packet to the client ONLY when:
    1. CE is consumed by an ability cast.
    2. Player takes damage.
    3. Once every second (20 ticks) for gradual passive recovery.
- Interpolated client-side bar rendering ensures butter-smooth HUD animation without network flood.

---

## 3. Progression Arc (Grade 4 to Special Grade)
- Progression points are awarded through:
  - Exorcising Cursed Spirits (scaled by curse grade).
  - Landing Black Flashes (+100 progression EXP).
  - Surviving / Winning Domain Clashes.
  - Completing Jujutsu High missions.
- Advancing grade increases `maxCE` and `outputEfficiency`, and unlocks higher-tier moves (e.g. Hollow Purple at Special Grade / Awakening).
