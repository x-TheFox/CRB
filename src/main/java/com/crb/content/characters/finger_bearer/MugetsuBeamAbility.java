package com.crb.content.characters.finger_bearer;

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

public class MugetsuBeamAbility extends Ability {
    public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(CursedRealityBoundless.MOD_ID, "mugetsu_beam");

    public MugetsuBeamAbility() {
        super(ID, "Mugetsu: Raw Energy Beam (無月)", AbilityCategory.OFFENSIVE, 140.0, 300, 25, 35.0);
    }

    @Override
    public void execute(ServerPlayer player, AbilityContext context) {
        ServerLevel level = player.serverLevel();
        Vec3 start = player.getEyePosition();
        Vec3 dir = player.getLookAngle().normalize();

        for (double d = 1.0; d < 35.0; d += 1.5) {
            Vec3 pos = start.add(dir.scale(d));
            AABB beamBox = new AABB(pos.subtract(1.5, 1.5, 1.5), pos.add(1.5, 1.5, 1.5));

            List<Entity> struck = level.getEntities(player, beamBox, e -> e instanceof LivingEntity && e != player);
            for (Entity e : struck) {
                if (e instanceof LivingEntity living) {
                    living.hurt(level.damageSources().dragonBreath(), 50.0f);
                    living.hurtMarked = true;
                }
            }

            level.sendParticles(ParticleTypes.DRAGON_BREATH, pos.x, pos.y, pos.z, 20, 0.4, 0.4, 0.4, 0.1);
        }

        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENDER_DRAGON_GROWL, SoundSource.PLAYERS, 3.0f, 0.6f);
    }
}
