package com.crb.core.ability;

import com.crb.core.cursedenergy.CursedEnergyData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.phys.Vec3;

public abstract class Ability {
    private final ResourceLocation id;
    private final String name;
    private final AbilityCategory category;
    private final double ceCost;
    private final int cooldownTicks;
    private final int windupTicks;
    private final double maxRange;

    public Ability(ResourceLocation id, String name, AbilityCategory category, double ceCost, int cooldownTicks, int windupTicks, double maxRange) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.ceCost = ceCost;
        this.cooldownTicks = cooldownTicks;
        this.windupTicks = windupTicks;
        this.maxRange = maxRange;
    }

    public ResourceLocation getId() { return id; }
    public String getName() { return name; }
    public AbilityCategory getCategory() { return category; }
    public double getCeCost() { return ceCost; }
    public int getCooldownTicks() { return cooldownTicks; }
    public int getWindupTicks() { return windupTicks; }
    public double getMaxRange() { return maxRange; }

    public boolean canCast(ServerPlayer player, CursedEnergyData ceData) {
        if (ceData.isDomainBurnout() && category != AbilityCategory.ANTI_DOMAIN_ART) {
            return false;
        }
        return ceData.getCurrentCE() >= (ceCost * ceData.getTrait().getCostMultiplier());
    }

    public abstract void execute(ServerPlayer player, AbilityContext context);

    public void tickActive(ServerPlayer player, int activeTicks) {}

    public void onEnd(ServerPlayer player) {}

    public record AbilityContext(Vec3 targetPos, int targetEntityId, int chargeTicks, boolean isSneaking) {}
}
