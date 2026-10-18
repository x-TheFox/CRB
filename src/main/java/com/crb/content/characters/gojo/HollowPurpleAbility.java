package com.crb.content.characters.gojo;

import com.crb.CursedRealityBoundless;
import com.crb.core.ability.Ability;
import com.crb.core.ability.AbilityCategory;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class HollowPurpleAbility extends Ability {
    public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(CursedRealityBoundless.MOD_ID, "hollow_purple");

    public HollowPurpleAbility() {
        super(ID, "Secret Art: Hollow Purple", AbilityCategory.OFFENSIVE, 220.0, 500, 40, 60.0);
    }

    @Override
    public void execute(ServerPlayer player, AbilityContext context) {
        ServerLevel level = player.serverLevel();
        Vec3 start = player.getEyePosition();
        Vec3 direction = player.getLookAngle().normalize();

        double stepSize = 1.0;
        double maxDist = 45.0;
        double erasureRadius = 3.5;

        // March the imaginary mass forward along raycast
        for (double d = 2.0; d < maxDist; d += stepSize) {
            Vec3 sphereCenter = start.add(direction.scale(d));

            // Obliterate entities along the path
            AABB hitBox = new AABB(sphereCenter.subtract(erasureRadius, erasureRadius, erasureRadius),
                    sphereCenter.add(erasureRadius, erasureRadius, erasureRadius));

            List<Entity> struckEntities = level.getEntities(player, hitBox, e -> e instanceof LivingEntity && e != player);
            for (Entity struck : struckEntities) {
                if (struck instanceof LivingEntity living) {
                    living.hurt(level.damageSources().fellOutOfWorld(), 90.0f); // Spatial erasure bypasses conventional armor
                    living.setDeltaMovement(direction.scale(3.0));
                }
            }

            // Pulverize blocks in path
            BlockPos centerPos = BlockPos.containing(sphereCenter);
            int r = (int) Math.ceil(erasureRadius);
            for (int dx = -r; dx <= r; dx++) {
                for (int dy = -r; dy <= r; dy++) {
                    for (int dz = -r; dz <= r; dz++) {
                        if (dx * dx + dy * dy + dz * dz <= erasureRadius * erasureRadius) {
                            BlockPos targetPos = centerPos.offset(dx, dy, dz);
                            BlockState state = level.getBlockState(targetPos);
                            if (!state.isAir() && state.getBlock() != Blocks.BEDROCK) {
                                level.setBlock(targetPos, Blocks.AIR.defaultBlockState(), 3);
                            }
                        }
                    }
                }
            }

            // Purple imaginary mass VFX
            level.sendParticles(ParticleTypes.DRAGON_BREATH, sphereCenter.x, sphereCenter.y, sphereCenter.z, 20, 0.5, 0.5, 0.5, 0.05);
            level.sendParticles(ParticleTypes.ELECTRIC_SPARK, sphereCenter.x, sphereCenter.y, sphereCenter.z, 15, 0.4, 0.4, 0.4, 0.1);
        }

        // Grand spatial sonic boom
        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.GENERIC_EXPLODE.value(), SoundSource.PLAYERS, 4.0f, 0.5f);
        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.END_PORTAL_SPAWN, SoundSource.PLAYERS, 3.0f, 1.8f);
    }
}
