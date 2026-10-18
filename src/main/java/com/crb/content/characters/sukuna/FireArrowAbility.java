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
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class FireArrowAbility extends Ability {
    public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(CursedRealityBoundless.MOD_ID, "fire_arrow");

    public FireArrowAbility() {
        super(ID, "Divine Flame: Kamino (Open)", AbilityCategory.OFFENSIVE, 180.0, 400, 30, 50.0);
    }

    @Override
    public void execute(ServerPlayer player, AbilityContext context) {
        ServerLevel level = player.serverLevel();
        Vec3 start = player.getEyePosition();
        Vec3 dir = player.getLookAngle().normalize();
        Vec3 impact = start.add(dir.scale(35.0));

        // Create thermal explosion at impact
        level.explode(player, impact.x, impact.y, impact.z, 5.0f, Level.ExplosionInteraction.MOB);

        AABB damageArea = new AABB(impact.subtract(8.0, 8.0, 8.0), impact.add(8.0, 8.0, 8.0));
        List<Entity> casualties = level.getEntities(player, damageArea, e -> e instanceof LivingEntity && e != player);

        for (Entity casualty : casualties) {
            if (casualty instanceof LivingEntity living) {
                living.hurt(level.damageSources().inFire(), 65.0f);
                living.setRemainingFireTicks(200);
            }
        }

        level.sendParticles(ParticleTypes.FLAME, impact.x, impact.y, impact.z, 200, 3.0, 3.0, 3.0, 0.2);
        level.sendParticles(ParticleTypes.LAVA, impact.x, impact.y, impact.z, 50, 2.0, 2.0, 2.0, 0.1);
        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.GHAST_SHOOT, SoundSource.PLAYERS, 3.0f, 0.7f);
    }
}
