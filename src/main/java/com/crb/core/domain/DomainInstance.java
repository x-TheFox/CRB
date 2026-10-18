package com.crb.core.domain;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.UUID;

public class DomainInstance {
    private final UUID domainId;
    private final UUID casterId;
    private final ResourceLocation domainName;
    private final BarrierType barrierType;
    private final Vec3 center;
    private final double radius;
    private final int totalDurationTicks;
    private int elapsedTicks = 0;
    private double refinementRating;
    private boolean isDissolved = false;
    private UUID clashingTargetId = null;

    public DomainInstance(UUID casterId, ResourceLocation domainName, BarrierType barrierType, Vec3 center, double radius, int durationTicks, double refinement) {
        this.domainId = UUID.randomUUID();
        this.casterId = casterId;
        this.domainName = domainName;
        this.barrierType = barrierType;
        this.center = center;
        this.radius = radius;
        this.totalDurationTicks = durationTicks;
        this.refinementRating = refinement;
    }

    public boolean isInside(Vec3 pos) {
        return center.distanceTo(pos) <= radius;
    }

    public AABB getBoundingBox() {
        return new AABB(
                center.x - radius, center.y - radius, center.z - radius,
                center.x + radius, center.y + radius, center.z + radius
        );
    }

    public void tick(ServerLevel level) {
        elapsedTicks++;
        if (elapsedTicks >= totalDurationTicks) {
            isDissolved = true;
        }
    }

    public UUID getDomainId() { return domainId; }
    public UUID getCasterId() { return casterId; }
    public ResourceLocation getDomainName() { return domainName; }
    public BarrierType getBarrierType() { return barrierType; }
    public Vec3 getCenter() { return center; }
    public double getRadius() { return radius; }
    public int getElapsedTicks() { return elapsedTicks; }
    public int getTotalDurationTicks() { return totalDurationTicks; }
    public double getRefinementRating() { return refinementRating; }
    public void setRefinementRating(double refinementRating) { this.refinementRating = refinementRating; }
    public boolean isDissolved() { return isDissolved; }
    public void setDissolved(boolean dissolved) { isDissolved = dissolved; }
    public UUID getClashingTargetId() { return clashingTargetId; }
    public void setClashingTargetId(UUID clashingTargetId) { this.clashingTargetId = clashingTargetId; }
}
