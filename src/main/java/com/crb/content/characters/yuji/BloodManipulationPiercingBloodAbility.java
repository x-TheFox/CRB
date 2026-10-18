package com.crb.content.characters.yuji;

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

public class BloodManipulationPiercingBloodAbility extends Ability {
    public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(CursedRealityBoundless.MOD_ID, "piercing_blood");

    public BloodManipulationPiercingBloodAbility() {
        super(ID, "Blood Manipulation: Piercing Blood (穿血)", AbilityCategory.OFFENSIVE, 65.0, 100, 15, 40.0);
    }

    @Override
    public void execute(ServerPlayer player, AbilityContext context) {
        ServerLevel level = player.serverLevel();
        Vec3 start = player.getEyePosition();
        Vec3 dir = player.getLookAngle().normalize();

        // Supersonic blood jet raycast
        for (double d = 1.0; d < 40.0; d += 1.0) {
            Vec3 pos = start.add(dir.scale(d));
            AABB beamBox = new AABB(pos.subtract(0.8, 0.8, 0.8), pos.add(0.8, 0.8, 0.8));

            List<Entity> pierced = level.getEntities(player, beamBox, e -> e instanceof LivingEntity && e != player);
            for (Entity e : pierced) {
                if (e instanceof LivingEntity living) {
                    living.hurt(level.damageSources().arrow(null, player), 28.0f);
                    living.hurtMarked = true;
                }
            }

            level.sendParticles(ParticleTypes.CRIMSON_SPORE, pos.x, pos.y, pos.z, 8, 0.1, 0.1, 0.1, 0.05);
        }

        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.CROSSBOW_SHOOT, SoundSource.PLAYERS, 2.5f, 1.8f);
    }
}
