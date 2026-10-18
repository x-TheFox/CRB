package com.crb.content.characters.sukuna;

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

public class DismantleAbility extends Ability {
    public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(CursedRealityBoundless.MOD_ID, "dismantle");

    public DismantleAbility() {
        super(ID, "Shrine: Dismantle", AbilityCategory.OFFENSIVE, 45.0, 30, 2, 28.0);
    }

    @Override
    public void execute(ServerPlayer player, AbilityContext context) {
        ServerLevel level = player.serverLevel();
        Vec3 start = player.getEyePosition();
        Vec3 dir = player.getLookAngle().normalize();

        for (double d = 1.0; d < 28.0; d += 1.5) {
            Vec3 pos = start.add(dir.scale(d));
            AABB slashBox = new AABB(pos.subtract(1.0, 1.0, 1.0), pos.add(1.0, 1.0, 1.0));

            List<Entity> struck = level.getEntities(player, slashBox, e -> e instanceof LivingEntity && e != player);
            for (Entity e : struck) {
                if (e instanceof LivingEntity living) {
                    living.hurt(level.damageSources().mobAttack(player), 22.0f);
                    living.hurtMarked = true;
                }
            }

            level.sendParticles(ParticleTypes.SWEEP_ATTACK, pos.x, pos.y, pos.z, 2, 0.2, 0.2, 0.2, 0.0);
        }

        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.PLAYER_ATTACK_SWEEP, SoundSource.PLAYERS, 2.0f, 1.8f);
    }
}
