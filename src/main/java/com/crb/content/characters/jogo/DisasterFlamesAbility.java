package com.crb.content.characters.jogo;

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

public class DisasterFlamesAbility extends Ability {
    public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(CursedRealityBoundless.MOD_ID, "disaster_flames");

    public DisasterFlamesAbility() {
        super(ID, "Disaster Flames: Volcanic Jets (災禍の炎)", AbilityCategory.OFFENSIVE, 50.0, 40, 5, 20.0);
    }

    @Override
    public void execute(ServerPlayer player, AbilityContext context) {
        ServerLevel level = player.serverLevel();
        Vec3 start = player.getEyePosition();
        Vec3 dir = player.getLookAngle().normalize();

        for (double d = 1.0; d < 20.0; d += 1.0) {
            Vec3 pos = start.add(dir.scale(d));
            AABB burnBox = new AABB(pos.subtract(1.2, 1.2, 1.2), pos.add(1.2, 1.2, 1.2));

            List<Entity> struck = level.getEntities(player, burnBox, e -> e instanceof LivingEntity && e != player);
            for (Entity e : struck) {
                if (e instanceof LivingEntity living) {
                    living.hurt(level.damageSources().inFire(), 25.0f);
                    living.setRemainingFireTicks(160);
                }
            }

            level.sendParticles(ParticleTypes.FLAME, pos.x, pos.y, pos.z, 15, 0.3, 0.3, 0.3, 0.05);
            level.sendParticles(ParticleTypes.LAVA, pos.x, pos.y, pos.z, 5, 0.2, 0.2, 0.2, 0.0);
        }

        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.FIRECHARGE_USE, SoundSource.PLAYERS, 2.0f, 0.8f);
    }
}
