package com.crb.core.cursedenergy;

public enum Clan {
    NONE("None", "Independent Sorcerer"),
    GOJO("Gojo Clan", "Heirs of Limitless and the Six Eyes"),
    ZENIN("Zenin Clan", "Ten Shadows and Shadow Style Prowess"),
    KAMO("Kamo Clan", "Masters of Blood Manipulation"),
    INUMAKI("Inumaki Clan", "Bearers of the Snake & Fangs Cursed Speech"),
    ITADORI("Itadori Lineage", "Immense Physical Vessel & Soul Resilience"),
    FUJIWARA("Fujiwara Lineage", "Ancient Heian Aristocratic Sorcery"),
    SUGIMOTO("Sugimoto Lineage", "Vengeful Cursed Energy Lineage");

    private final String displayName;
    private final String description;

    Clan(String displayName, String description) {
        this.displayName = displayName;
        this.description = description;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getDescription() {
        return description;
    }
}
