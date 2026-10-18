package com.crb.content.characters.higuruma;

import com.crb.CursedRealityBoundless;
import com.crb.core.ability.Ability;
import com.crb.core.ability.AbilityCategory;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
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

public class ExecutionerSwordAbility extends Ability {
    public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(CursedRealityBoundless.MOD_ID, "executioner_sword");

    public ExecutionerSwordAbility() {
        super(ID, "Executioner's Sword: Fatal Cleave (処刑人の剣)", AbilityCategory.OFFENSIVE, 0.0, 100, 5, 4.0);
    }

    @Override
    public void execute(ServerPlayer player, AbilityContext context) {
        ServerLevel level = player.serverLevel();
        Vec3 reach = player.getEyePosition().add(player.getLookAngle().scale(3.0));
        AABB slashBox = new AABB(reach.subtract(1.5, 1.5, 1.5), reach.add(1.5, 1.5, 1.5));

        List<Entity> struck = level.getEntities(player, slashBox, e -> e instanceof LivingEntity && e != player);
        for (Entity e : struck) {
            if (e instanceof LivingEntity living) {
                // Guaranteed instant execution to condemned target
                living.hurt(level.damageSources().fellOutOfWorld(), 9999.0f);
                living.hurtMarked = true;

                level.sendParticles(ParticleTypes.TOTEM_OF_UNDYING, living.getX(), living.getY() + 1.0, living.getZ(), 50, 0.5, 0.5, 0.5, 0.2);
                player.sendSystemMessage(Component.literal("§6§l[Judgeman] §cSentence Executed!"));
            }
        }

        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.PLAYER_LEVELUP, SoundSource.PLAYERS, 2.0f, 1.5f);
    }
}
