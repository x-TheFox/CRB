package com.crb.content.characters.toji_maki;

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

public class SoulSplitKatanaAbility extends Ability {
    public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(CursedRealityBoundless.MOD_ID, "soul_split_katana");

    public SoulSplitKatanaAbility() {
        super(ID, "Split Soul Katana: Soul Sever (釈魂刀)", AbilityCategory.OFFENSIVE, 0.0, 40, 2, 4.0);
    }

    @Override
    public void execute(ServerPlayer player, AbilityContext context) {
        ServerLevel level = player.serverLevel();
        Vec3 reach = player.getEyePosition().add(player.getLookAngle().scale(3.0));
        AABB hitBox = new AABB(reach.subtract(1.5, 1.5, 1.5), reach.add(1.5, 1.5, 1.5));

        List<Entity> struck = level.getEntities(player, hitBox, e -> e instanceof LivingEntity && e != player);
        for (Entity e : struck) {
            if (e instanceof LivingEntity living) {
                // Cuts soul directly: ignores armor and resistance
                living.hurt(level.damageSources().fellOutOfWorld(), 38.0f);
                living.hurtMarked = true;

                level.sendParticles(ParticleTypes.SOUL, living.getX(), living.getY() + 1.0, living.getZ(), 25, 0.4, 0.4, 0.4, 0.05);
            }
        }

        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.PLAYER_ATTACK_SWEEP, SoundSource.PLAYERS, 2.0f, 1.4f);
    }
}
