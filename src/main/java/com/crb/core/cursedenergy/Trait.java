package com.crb.core.cursedenergy;

public enum Trait {
    NONE("None", 1.0, 1.0),
    SIX_EYES("Six Eyes", 0.001, 2.0), // Extreme efficiency reducing CE costs to near-zero
    HEAVENLY_RESTRICTION("Heavenly Restriction", 0.0, 0.0), // Zero CE, immense physical stats
    ELECTRIFIED_CE("Electrified Cursed Energy", 1.0, 1.0), // Kashimo shock properties
    ROUGH_CE("Rough Cursed Energy", 1.0, 1.0), // Hakari abrasive chip damage
    OVERFLOWING_VESSEL("Overflowing Vessel", 1.2, 1.5), // Rapid CE replenishment
    COLOSSAL_RESERVES("Colossal Reserves", 1.0, 1.0), // Sukuna/Yuta vast pool
    SOUL_PERCEPTION("Soul Perception", 1.0, 1.0); // Direct soul outline awareness

    private final String displayName;
    private final double costMultiplier;
    private final double regenMultiplier;

    Trait(String displayName, double costMultiplier, double regenMultiplier) {
        this.displayName = displayName;
        this.costMultiplier = costMultiplier;
        this.regenMultiplier = regenMultiplier;
    }

    public String getDisplayName() {
        return displayName;
    }

    public double getCostMultiplier() {
        return costMultiplier;
    }

    public double getRegenMultiplier() {
        return regenMultiplier;
    }
}
