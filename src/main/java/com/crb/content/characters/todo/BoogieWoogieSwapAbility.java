package com.crb.content.characters.todo;

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

public class BoogieWoogieSwapAbility extends Ability {
    public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(CursedRealityBoundless.MOD_ID, "boogie_woogie");

    public BoogieWoogieSwapAbility() {
        super(ID, "Boogie Woogie (不義遊戯)", AbilityCategory.UTILITY, 25.0, 25, 2, 32.0);
    }

    @Override
    public void execute(ServerPlayer player, AbilityContext context) {
        ServerLevel level = player.serverLevel();
        Vec3 look = player.getLookAngle();
        Vec3 targetPos = player.getEyePosition().add(look.scale(16.0));
        AABB targetBox = new AABB(targetPos.subtract(6.0, 6.0, 6.0), targetPos.add(6.0, 6.0, 6.0));

        List<Entity> candidates = level.getEntities(player, targetBox, e -> e instanceof LivingEntity && e != player);
        if (!candidates.isEmpty()) {
            Entity target = candidates.get(0);

            Vec3 playerPos = player.position();
            Vec3 targetEntityPos = target.position();

            // Server-authoritative coordinate exchange
            player.teleportTo(targetEntityPos.x, targetEntityPos.y, targetEntityPos.z);
            target.teleportTo(playerPos.x, playerPos.y, playerPos.z);

            // Particles at both locations
            level.sendParticles(ParticleTypes.PORTAL, playerPos.x, playerPos.y + 1.0, playerPos.z, 20, 0.5, 0.5, 0.5, 0.1);
            level.sendParticles(ParticleTypes.PORTAL, targetEntityPos.x, targetEntityPos.y + 1.0, targetEntityPos.z, 20, 0.5, 0.5, 0.5, 0.1);

            level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.PLAYER_ATTACK_CRIT, SoundSource.PLAYERS, 2.0f, 1.8f);
        }
    }
}
