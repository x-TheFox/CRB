package com.crb.core.domain;

public enum BarrierType {
    CLOSED_SPHERE("Closed Barrier", 66.0, true),
    OPEN_BARRIER("Open Barrier", 200.0, false),
    NON_LETHAL_COURTROOM("Courtroom Non-Lethal", 50.0, true),
    POCKET_DIMENSION("Subway Pocket Dimension", 48.0, true);

    private final String displayName;
    private final double defaultRadius;
    private final boolean hasPhysicalBarrier;

    BarrierType(String displayName, double defaultRadius, boolean hasPhysicalBarrier) {
        this.displayName = displayName;
        this.defaultRadius = defaultRadius;
        this.hasPhysicalBarrier = hasPhysicalBarrier;
    }

    public String getDisplayName() {
        return displayName;
    }

    public double getDefaultRadius() {
        return defaultRadius;
    }

    public boolean hasPhysicalBarrier() {
        return hasPhysicalBarrier;
    }
}
