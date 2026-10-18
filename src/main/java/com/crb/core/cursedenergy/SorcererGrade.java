package com.crb.core.cursedenergy;

public enum SorcererGrade {
    GRADE_4("Grade 4", 100.0, 1.0),
    GRADE_3("Grade 3", 250.0, 1.2),
    SEMI_GRADE_2("Semi-Grade 2", 450.0, 1.5),
    GRADE_2("Grade 2", 700.0, 2.0),
    SEMI_GRADE_1("Semi-Grade 1", 1100.0, 2.5),
    GRADE_1("Grade 1", 1600.0, 3.2),
    SPECIAL_GRADE_1("Special Grade 1", 2200.0, 4.0),
    SPECIAL_GRADE("Special Grade", 3500.0, 5.0);

    private final String displayName;
    private final double baseMaxCE;
    private final double baseRegenRate;

    SorcererGrade(String displayName, double baseMaxCE, double baseRegenRate) {
        this.displayName = displayName;
        this.baseMaxCE = baseMaxCE;
        this.baseRegenRate = baseRegenRate;
    }

    public String getDisplayName() {
        return displayName;
    }

    public double getBaseMaxCE() {
        return baseMaxCE;
    }

    public double getBaseRegenRate() {
        return baseRegenRate;
    }
}
