package com.crb.content.characters.todo;

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

public class SimpleDomainAbility extends Ability {
    public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(CursedRealityBoundless.MOD_ID, "simple_domain");

    public SimpleDomainAbility() {
        super(ID, "New Shadow Style: Simple Domain (簡易領域)", AbilityCategory.ANTI_DOMAIN_ART, 50.0, 200, 5, 0.0);
    }

    @Override
    public void execute(ServerPlayer player, AbilityContext context) {
        ServerLevel level = player.serverLevel();

        player.sendSystemMessage(Component.literal("§b§lNew Shadow Style: Simple Domain Deployed!"));

        // Grants defensive posture and resistance
        player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 200, 2));

        level.sendParticles(ParticleTypes.END_ROD, player.getX(), player.getY() + 0.1, player.getZ(), 80, 2.0, 0.1, 2.0, 0.05);
        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.BEACON_DEACTIVATE, SoundSource.PLAYERS, 2.0f, 1.5f);
    }
}
