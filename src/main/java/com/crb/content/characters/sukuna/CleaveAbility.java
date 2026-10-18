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

public class CleaveAbility extends Ability {
    public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(CursedRealityBoundless.MOD_ID, "cleave");

    public CleaveAbility() {
        super(ID, "Shrine: Cleave", AbilityCategory.OFFENSIVE, 60.0, 50, 4, 4.5);
    }

    @Override
    public void execute(ServerPlayer player, AbilityContext context) {
        ServerLevel level = player.serverLevel();
        Vec3 reach = player.getEyePosition().add(player.getLookAngle().scale(3.5));
        AABB hitBox = new AABB(reach.subtract(1.5, 1.5, 1.5), reach.add(1.5, 1.5, 1.5));

        List<Entity> targets = level.getEntities(player, hitBox, e -> e instanceof LivingEntity && e != player);
        for (Entity target : targets) {
            if (target instanceof LivingEntity living) {
                // Cleave adjusts to target toughness: scales with max health
                float baseDamage = 30.0f;
                float scalingDamage = living.getMaxHealth() * 0.4f;
                float finalDamage = Math.min(120.0f, baseDamage + scalingDamage);

                living.hurt(level.damageSources().mobAttack(player), finalDamage);
                living.hurtMarked = true;

                level.sendParticles(ParticleTypes.DAMAGE_INDICATOR, living.getX(), living.getY() + 1.0, living.getZ(), 20, 0.5, 0.5, 0.5, 0.1);
            }
        }

        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ANVIL_LAND, SoundSource.PLAYERS, 1.5f, 1.6f);
    }
}
