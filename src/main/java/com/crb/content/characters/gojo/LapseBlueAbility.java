package com.crb.content.characters.gojo;

import com.crb.CursedRealityBoundless;
import com.crb.core.ability.Ability;
import com.crb.core.ability.AbilityCategory;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class LapseBlueAbility extends Ability {
    public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(CursedRealityBoundless.MOD_ID, "lapse_blue");

    public LapseBlueAbility() {
        super(ID, "Cursed Technique Lapse: Blue", AbilityCategory.OFFENSIVE, 75.0, 160, 10, 25.0);
    }

    @Override
    public void execute(ServerPlayer player, AbilityContext context) {
        ServerLevel level = player.serverLevel();
        Vec3 look = player.getLookAngle();
        Vec3 focalPoint = player.getEyePosition().add(look.scale(12.0));

        // Spatial attraction physics
        double suctionRadius = 12.0;
        AABB suctionBox = new AABB(focalPoint.subtract(suctionRadius, suctionRadius, suctionRadius),
                focalPoint.add(suctionRadius, suctionRadius, suctionRadius));

        List<Entity> entities = level.getEntities(player, suctionBox, e -> e instanceof LivingEntity && e != player);

        for (Entity entity : entities) {
            Vec3 pullDir = focalPoint.subtract(entity.position()).normalize();
            double distance = entity.position().distanceTo(focalPoint);
            double strength = Math.max(0.5, (1.0 - (distance / suctionRadius)) * 1.8);

            // Set authoritative motion on server
            entity.setDeltaMovement(entity.getDeltaMovement().add(pullDir.scale(strength)));
            entity.hurtMarked = true;

            // Spatial crush damage when drawn within 2 blocks
            if (distance < 3.0 && entity instanceof LivingEntity living) {
                living.hurt(level.damageSources().magic(), 18.0f);
            }
        }

        // Particle VFX & SFX
        level.sendParticles(ParticleTypes.PORTAL, focalPoint.x, focalPoint.y, focalPoint.z, 80, 1.5, 1.5, 1.5, 0.2);
        level.sendParticles(ParticleTypes.REVERSE_PORTAL, focalPoint.x, focalPoint.y, focalPoint.z, 50, 0.8, 0.8, 0.8, 0.1);
        level.playSound(null, focalPoint.x, focalPoint.y, focalPoint.z, SoundEvents.BEACON_ACTIVATE, SoundSource.PLAYERS, 2.5f, 1.4f);
    }
}
