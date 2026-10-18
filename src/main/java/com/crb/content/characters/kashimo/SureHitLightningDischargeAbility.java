package com.crb.content.characters.kashimo;

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

public class SureHitLightningDischargeAbility extends Ability {
    public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(CursedRealityBoundless.MOD_ID, "lightning_discharge");

    public SureHitLightningDischargeAbility() {
        super(ID, "Sure-Hit Lightning Discharge (落雷)", AbilityCategory.OFFENSIVE, 80.0, 240, 5, 35.0);
    }

    @Override
    public void execute(ServerPlayer player, AbilityContext context) {
        ServerLevel level = player.serverLevel();
        Vec3 start = player.getEyePosition();
        Vec3 dir = player.getLookAngle().normalize();

        // 35-block electrostatic discharge arc
        for (double d = 1.0; d < 35.0; d += 1.5) {
            Vec3 pos = start.add(dir.scale(d));
            AABB arcBox = new AABB(pos.subtract(1.5, 1.5, 1.5), pos.add(1.5, 1.5, 1.5));

            List<Entity> struck = level.getEntities(player, arcBox, e -> e instanceof LivingEntity && e != player);
            for (Entity e : struck) {
                if (e instanceof LivingEntity living) {
                    living.hurt(level.damageSources().lightningBolt(), 55.0f);
                    living.hurtMarked = true;
                }
            }

            level.sendParticles(ParticleTypes.ELECTRIC_SPARK, pos.x, pos.y, pos.z, 20, 0.4, 0.4, 0.4, 0.2);
        }

        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.LIGHTNING_BOLT_THUNDER, SoundSource.PLAYERS, 4.0f, 1.6f);
    }
}
