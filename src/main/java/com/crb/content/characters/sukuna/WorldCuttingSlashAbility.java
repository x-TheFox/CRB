package com.crb.content.characters.sukuna;

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

public class WorldCuttingSlashAbility extends Ability {
    public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(CursedRealityBoundless.MOD_ID, "world_cutting_slash");

    public WorldCuttingSlashAbility() {
        super(ID, "World Cutting Slash (世界を断つ斬撃)", AbilityCategory.OFFENSIVE, 350.0, 600, 60, 65.0);
    }

    @Override
    public void execute(ServerPlayer player, AbilityContext context) {
        ServerLevel level = player.serverLevel();

        // Broadcast chants in chat
        player.sendSystemMessage(Component.literal("§4§l[Sukuna] §r§cRyūrin. Hanpatsu. Tsugai no Suisei."));

        Vec3 start = player.getEyePosition();
        Vec3 dir = player.getLookAngle().normalize();

        // Expansive spatial bisecting plane (cutting the world itself)
        for (double d = 2.0; d < 65.0; d += 2.0) {
            Vec3 center = start.add(dir.scale(d));
            AABB plane = new AABB(center.subtract(6.0, 3.0, 6.0), center.add(6.0, 3.0, 6.0));

            List<Entity> bisected = level.getEntities(player, plane, e -> e instanceof LivingEntity && e != player);
            for (Entity entity : bisected) {
                if (entity instanceof LivingEntity living) {
                    // Absolute world bisecting cut: ignores infinity and all defenses
                    living.hurt(level.damageSources().fellOutOfWorld(), 150.0f);
                    living.hurtMarked = true;
                }
            }

            level.sendParticles(ParticleTypes.CRIT, center.x, center.y, center.z, 25, 3.0, 1.0, 3.0, 0.0);
            level.sendParticles(ParticleTypes.SWEEP_ATTACK, center.x, center.y, center.z, 5, 2.0, 0.5, 2.0, 0.0);
        }

        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.WITHER_DEATH, SoundSource.PLAYERS, 4.0f, 1.9f);
        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.LIGHTNING_BOLT_THUNDER, SoundSource.PLAYERS, 3.0f, 0.5f);
    }
}
