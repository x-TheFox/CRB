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
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class MaximumMeteorAbility extends Ability {
    public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(CursedRealityBoundless.MOD_ID, "maximum_meteor");

    public MaximumMeteorAbility() {
        super(ID, "Maximum: Meteor (極ノ番「隕」)", AbilityCategory.OFFENSIVE, 220.0, 500, 50, 45.0);
    }

    @Override
    public void execute(ServerPlayer player, AbilityContext context) {
        ServerLevel level = player.serverLevel();
        Vec3 target = player.position().add(player.getLookAngle().scale(25.0));

        level.explode(player, target.x, target.y, target.z, 7.0f, Level.ExplosionInteraction.MOB);

        AABB meteorImpact = new AABB(target.subtract(10.0, 10.0, 10.0), target.add(10.0, 10.0, 10.0));
        List<Entity> crushed = level.getEntities(player, meteorImpact, e -> e instanceof LivingEntity && e != player);

        for (Entity e : crushed) {
            if (e instanceof LivingEntity living) {
                living.hurt(level.damageSources().fellOutOfWorld(), 95.0f);
                living.setRemainingFireTicks(300);
            }
        }

        level.sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, target.x, target.y, target.z, 150, 4.0, 4.0, 4.0, 0.1);
        level.sendParticles(ParticleTypes.LAVA, target.x, target.y, target.z, 100, 3.0, 3.0, 3.0, 0.2);
        level.playSound(null, target.x, target.y, target.z, SoundEvents.GENERIC_EXPLODE.value(), SoundSource.PLAYERS, 4.0f, 0.4f);
    }
}
