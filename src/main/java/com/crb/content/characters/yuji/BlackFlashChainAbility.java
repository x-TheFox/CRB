package com.crb.content.characters.yuji;

import com.crb.CursedRealityBoundless;
import com.crb.core.ability.Ability;
import com.crb.core.ability.AbilityCategory;
import com.crb.core.cursedenergy.CursedEnergyData;
import com.crb.core.init.ModRegistries;
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

public class BlackFlashChainAbility extends Ability {
    public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(CursedRealityBoundless.MOD_ID, "black_flash");

    public BlackFlashChainAbility() {
        super(ID, "Black Flash (黒閃, Kokusen)", AbilityCategory.OFFENSIVE, 40.0, 40, 5, 4.0);
    }

    @Override
    public void execute(ServerPlayer player, AbilityContext context) {
        ServerLevel level = player.serverLevel();
        Vec3 reach = player.getEyePosition().add(player.getLookAngle().scale(3.0));
        AABB hitBox = new AABB(reach.subtract(1.5, 1.5, 1.5), reach.add(1.5, 1.5, 1.5));

        CursedEnergyData ceData = player.getData(ModRegistries.CURSED_ENERGY);

        List<Entity> targets = level.getEntities(player, hitBox, e -> e instanceof LivingEntity && e != player);
        for (Entity target : targets) {
            if (target instanceof LivingEntity living) {
                int streak = ceData.getBlackFlashStreak() + 1;
                ceData.setBlackFlashStreak(streak);
                player.setData(ModRegistries.CURSED_ENERGY, ceData);

                // Exponential damage scaling (Damage ^ 2.5 represented by base * streak)
                float baseDamage = 35.0f;
                float finalDamage = baseDamage + (streak * 15.0f);

                living.hurt(level.damageSources().playerAttack(player), finalDamage);
                living.hurtMarked = true;

                // Visual impact: black and red sparks, spatial shock
                level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, living.getX(), living.getY() + 1.0, living.getZ(), 40, 0.4, 0.4, 0.4, 0.15);
                level.sendParticles(ParticleTypes.SMOKE, living.getX(), living.getY() + 1.0, living.getZ(), 30, 0.3, 0.3, 0.3, 0.1);

                player.sendSystemMessage(Component.literal("§0§l[BLACK FLASH] §cStreak: " + streak + " §r§7(Zone Entered!)"));
            }
        }

        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.LIGHTNING_BOLT_IMPACT, SoundSource.PLAYERS, 2.5f, 0.6f);
        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.GENERIC_EXPLODE.value(), SoundSource.PLAYERS, 2.0f, 0.5f);
    }
}
