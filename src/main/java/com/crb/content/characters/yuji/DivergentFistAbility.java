package com.crb.content.characters.yuji;

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

public class DivergentFistAbility extends Ability {
    public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(CursedRealityBoundless.MOD_ID, "divergent_fist");

    public DivergentFistAbility() {
        super(ID, "Divergent Fist (逕庭拳)", AbilityCategory.OFFENSIVE, 25.0, 30, 2, 4.0);
    }

    @Override
    public void execute(ServerPlayer player, AbilityContext context) {
        ServerLevel level = player.serverLevel();
        Vec3 reach = player.getEyePosition().add(player.getLookAngle().scale(3.0));
        AABB hitBox = new AABB(reach.subtract(1.5, 1.5, 1.5), reach.add(1.5, 1.5, 1.5));

        List<Entity> targets = level.getEntities(player, hitBox, e -> e instanceof LivingEntity && e != player);
        for (Entity target : targets) {
            if (target instanceof LivingEntity living) {
                // Initial blunt physical hit
                living.hurt(level.damageSources().playerAttack(player), 12.0f);

                // Delayed secondary cursed energy burst
                level.getServer().tell(new net.minecraft.server.TickTask(level.getServer().getTickCount() + 4, () -> {
                    if (living.isAlive()) {
                        living.hurt(level.damageSources().magic(), 18.0f);
                        level.sendParticles(ParticleTypes.CRIT, living.getX(), living.getY() + 1.0, living.getZ(), 30, 0.5, 0.5, 0.5, 0.1);
                        level.playSound(null, living.getX(), living.getY(), living.getZ(), SoundEvents.GENERIC_EXPLODE.value(), SoundSource.PLAYERS, 1.5f, 1.4f);
                    }
                }));
            }
        }

        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.PLAYER_ATTACK_STRONG, SoundSource.PLAYERS, 1.5f, 1.0f);
    }
}
