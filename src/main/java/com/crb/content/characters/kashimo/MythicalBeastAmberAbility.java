package com.crb.content.characters.kashimo;

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
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;

public class MythicalBeastAmberAbility extends Ability {
    public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(CursedRealityBoundless.MOD_ID, "mythical_beast_amber");

    public MythicalBeastAmberAbility() {
        super(ID, "Mythical Beast Amber (幻獣琥珀)", AbilityCategory.UTILITY, 250.0, 99999, 30, 0.0);
    }

    @Override
    public void execute(ServerPlayer player, AbilityContext context) {
        ServerLevel level = player.serverLevel();

        player.sendSystemMessage(Component.literal("§e§l[Kashimo] §6Mythical Beast Amber Awakened! Flesh converts to electricity!"));

        // Relativistic physical buffs
        player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2400, 4));
        player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2400, 3));
        player.addEffect(new MobEffectInstance(MobEffects.JUMP, 2400, 2));
        player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2400, 2));

        level.sendParticles(ParticleTypes.ELECTRIC_SPARK, player.getX(), player.getY() + 1.0, player.getZ(), 200, 2.0, 2.0, 2.0, 0.3);
        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.LIGHTNING_BOLT_IMPACT, SoundSource.PLAYERS, 4.0f, 1.2f);
    }
}
