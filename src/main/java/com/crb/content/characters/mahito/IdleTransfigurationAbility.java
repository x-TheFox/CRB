package com.crb.content.characters.mahito;

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

public class IdleTransfigurationAbility extends Ability {
    public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(CursedRealityBoundless.MOD_ID, "idle_transfiguration");

    public IdleTransfigurationAbility() {
        super(ID, "Idle Transfiguration (無為転変)", AbilityCategory.OFFENSIVE, 70.0, 60, 5, 3.5);
    }

    @Override
    public void execute(ServerPlayer player, AbilityContext context) {
        ServerLevel level = player.serverLevel();
        Vec3 reach = player.getEyePosition().add(player.getLookAngle().scale(3.0));
        AABB touchBox = new AABB(reach.subtract(1.5, 1.5, 1.5), reach.add(1.5, 1.5, 1.5));

        List<Entity> touched = level.getEntities(player, touchBox, e -> e instanceof LivingEntity && e != player);
        for (Entity e : touched) {
            if (e instanceof LivingEntity living) {
                // Transfigures soul outline: true unblockable damage
                living.hurt(level.damageSources().fellOutOfWorld(), 45.0f);
                living.hurtMarked = true;

                level.sendParticles(ParticleTypes.SOUL, living.getX(), living.getY() + 1.0, living.getZ(), 40, 0.4, 0.4, 0.4, 0.1);
            }
        }

        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ZOMBIE_VILLAGER_CONVERTED, SoundSource.PLAYERS, 2.0f, 1.6f);
    }
}
