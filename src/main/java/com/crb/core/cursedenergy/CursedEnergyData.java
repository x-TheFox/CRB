package com.crb.core.cursedenergy;

import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.util.INBTSerializable;

public class CursedEnergyData implements INBTSerializable<CompoundTag> {
    private double currentCE = 100.0;
    private double maxCE = 100.0;
    private double regenRate = 1.0;
    private SorcererGrade grade = SorcererGrade.GRADE_4;
    private Clan clan = Clan.NONE;
    private Trait trait = Trait.NONE;
    private String innateTechnique = "crb:none";
    private int blackFlashStreak = 0;
    private boolean domainBurnout = false;
    private int burnoutTicksRemaining = 0;

    public CursedEnergyData() {}

    public boolean consume(double rawCost) {
        if (trait == Trait.HEAVENLY_RESTRICTION) {
            return false;
        }
        double effectiveCost = rawCost * trait.getCostMultiplier();
        if (currentCE >= effectiveCost) {
            currentCE -= effectiveCost;
            return true;
        }
        return false;
    }

    public void tickRegen(int elapsedTicks) {
        if (trait == Trait.HEAVENLY_RESTRICTION) {
            currentCE = 0.0;
            maxCE = 0.0;
            return;
        }
        if (burnoutTicksRemaining > 0) {
            burnoutTicksRemaining = Math.max(0, burnoutTicksRemaining - elapsedTicks);
            if (burnoutTicksRemaining == 0) {
                domainBurnout = false;
            }
        }
        if (currentCE < maxCE) {
            double effectiveRegen = (regenRate * trait.getRegenMultiplier()) * (elapsedTicks / 20.0);
            currentCE = Math.min(maxCE, currentCE + effectiveRegen);
        }
    }

    public void setGrade(SorcererGrade newGrade) {
        this.grade = newGrade;
        this.maxCE = newGrade.getBaseMaxCE();
        this.regenRate = newGrade.getBaseRegenRate();
        this.currentCE = Math.min(currentCE, maxCE);
    }

    public void applyBurnout(int ticks) {
        this.domainBurnout = true;
        this.burnoutTicksRemaining = ticks;
    }

    public void clearBurnout() {
        this.domainBurnout = false;
        this.burnoutTicksRemaining = 0;
    }

    // Getters and Setters
    public double getCurrentCE() { return currentCE; }
    public void setCurrentCE(double currentCE) { this.currentCE = Math.max(0.0, Math.min(maxCE, currentCE)); }
    public double getMaxCE() { return maxCE; }
    public void setMaxCE(double maxCE) { this.maxCE = maxCE; }
    public double getRegenRate() { return regenRate; }
    public void setRegenRate(double regenRate) { this.regenRate = regenRate; }
    public SorcererGrade getGrade() { return grade; }
    public Clan getClan() { return clan; }
    public void setClan(Clan clan) { this.clan = clan; }
    public Trait getTrait() { return trait; }
    public void setTrait(Trait trait) { this.trait = trait; }
    public String getInnateTechnique() { return innateTechnique; }
    public void setInnateTechnique(String innateTechnique) { this.innateTechnique = innateTechnique; }
    public int getBlackFlashStreak() { return blackFlashStreak; }
    public void setBlackFlashStreak(int blackFlashStreak) { this.blackFlashStreak = blackFlashStreak; }
    public boolean isDomainBurnout() { return domainBurnout; }
    public int getBurnoutTicksRemaining() { return burnoutTicksRemaining; }
    public boolean isZeroCE() { return trait == Trait.HEAVENLY_RESTRICTION; }
    public boolean hasSixEyes() { return trait == Trait.SIX_EYES; }

    public void copyFrom(CursedEnergyData other) {
        this.currentCE = other.currentCE;
        this.maxCE = other.maxCE;
        this.regenRate = other.regenRate;
        this.grade = other.grade;
        this.clan = other.clan;
        this.trait = other.trait;
        this.innateTechnique = other.innateTechnique;
        this.blackFlashStreak = other.blackFlashStreak;
        this.domainBurnout = other.domainBurnout;
        this.burnoutTicksRemaining = other.burnoutTicksRemaining;
    }

    @Override
    public CompoundTag serializeNBT(HolderLookup.Provider provider) {
        CompoundTag tag = new CompoundTag();
        tag.putDouble("currentCE", currentCE);
        tag.putDouble("maxCE", maxCE);
        tag.putDouble("regenRate", regenRate);
        tag.putString("grade", grade.name());
        tag.putString("clan", clan.name());
        tag.putString("trait", trait.name());
        tag.putString("innateTechnique", innateTechnique);
        tag.putInt("blackFlashStreak", blackFlashStreak);
        tag.putBoolean("domainBurnout", domainBurnout);
        tag.putInt("burnoutTicksRemaining", burnoutTicksRemaining);
        return tag;
    }

    @Override
    public void deserializeNBT(HolderLookup.Provider provider, CompoundTag tag) {
        this.currentCE = tag.getDouble("currentCE");
        this.maxCE = tag.getDouble("maxCE");
        this.regenRate = tag.getDouble("regenRate");
        if (tag.contains("grade")) this.grade = SorcererGrade.valueOf(tag.getString("grade"));
        if (tag.contains("clan")) this.clan = Clan.valueOf(tag.getString("clan"));
        if (tag.contains("trait")) this.trait = Trait.valueOf(tag.getString("trait"));
        if (tag.contains("innateTechnique")) this.innateTechnique = tag.getString("innateTechnique");
        this.blackFlashStreak = tag.getInt("blackFlashStreak");
        this.domainBurnout = tag.getBoolean("domainBurnout");
        this.burnoutTicksRemaining = tag.getInt("burnoutTicksRemaining");
    }
}
