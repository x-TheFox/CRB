package com.crb.content.characters.toji_maki;

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

public class InvertedSpearNullifyAbility extends Ability {
    public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(CursedRealityBoundless.MOD_ID, "inverted_spear");

    public InvertedSpearNullifyAbility() {
        super(ID, "Inverted Spear of Heaven (天逆鉾)", AbilityCategory.OFFENSIVE, 0.0, 60, 2, 4.0);
    }

    @Override
    public void execute(ServerPlayer player, AbilityContext context) {
        ServerLevel level = player.serverLevel();
        Vec3 reach = player.getEyePosition().add(player.getLookAngle().scale(3.0));
        AABB hitBox = new AABB(reach.subtract(1.5, 1.5, 1.5), reach.add(1.5, 1.5, 1.5));

        List<Entity> struck = level.getEntities(player, hitBox, e -> e instanceof LivingEntity && e != player);
        for (Entity e : struck) {
            if (e instanceof LivingEntity living) {
                living.hurt(level.damageSources().playerAttack(player), 28.0f);

                // If target is a player, nullify their technique into burnout!
                if (living instanceof ServerPlayer targetPlayer) {
                    CursedEnergyData targetData = targetPlayer.getData(ModRegistries.CURSED_ENERGY);
                    targetData.applyBurnout(200); // 10s forced technique cancellation
                    targetPlayer.setData(ModRegistries.CURSED_ENERGY, targetData);
                    targetPlayer.sendSystemMessage(Component.literal("§cYour cursed technique was forced into burnout by the Inverted Spear!"));
                }

                level.sendParticles(ParticleTypes.CRIT, living.getX(), living.getY() + 1.0, living.getZ(), 30, 0.5, 0.5, 0.5, 0.1);
            }
        }

        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.SHIELD_BREAK, SoundSource.PLAYERS, 2.0f, 1.6f);
    }
}
