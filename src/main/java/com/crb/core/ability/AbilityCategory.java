package com.crb.core.ability;

public enum AbilityCategory {
    OFFENSIVE("Offensive"),
    DEFENSIVE("Defensive"),
    UTILITY("Utility"),
    DOMAIN_EXPANSION("Domain Expansion"),
    ANTI_DOMAIN_ART("Anti-Domain Art"),
    MARTIAL_ARTS("Martial Arts");

    private final String displayName;

    AbilityCategory(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
