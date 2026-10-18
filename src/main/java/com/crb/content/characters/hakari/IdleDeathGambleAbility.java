package com.crb.content.characters.hakari;

import com.crb.CursedRealityBoundless;
import com.crb.core.ability.Ability;
import com.crb.core.ability.AbilityCategory;
import com.crb.core.domain.BarrierType;
import com.crb.core.domain.DomainInstance;
import com.crb.core.domain.DomainManager;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;

public class IdleDeathGambleAbility extends Ability {
    public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(CursedRealityBoundless.MOD_ID, "idle_death_gamble");

    public IdleDeathGambleAbility() {
        super(ID, "Domain Expansion: Idle Death Gamble (坐殺博徒)", AbilityCategory.DOMAIN_EXPANSION, 120.0, 600, 10, 48.0);
    }

    @Override
    public void execute(ServerPlayer player, AbilityContext context) {
        ServerLevel level = player.serverLevel();

        player.sendSystemMessage(Component.literal("§e§lDomain Expansion: Idle Death Gamble (坐殺博徒) §r§6— 7-7-7 JACKPOT HIT!"));

        DomainInstance gamble = new DomainInstance(
                player.getUUID(),
                ID,
                BarrierType.POCKET_DIMENSION,
                player.position(),
                48.0,
                5020, // Exactly 4 minutes and 11 seconds of immortality!
                110.0
        );

        DomainManager.registerDomain(gamble);

        // Bestow 4 minutes and 11 seconds of absolute immortality and regen
        player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 5020, 5));
        player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 5020, 3));
        player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 5020, 3));
        player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 5020, 2));

        level.sendParticles(ParticleTypes.NOTE, player.getX(), player.getY() + 1.0, player.getZ(), 50, 1.0, 1.0, 1.0, 0.5);
        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.UI_TOAST_CHALLENGE_COMPLETE, SoundSource.PLAYERS, 4.0f, 1.0f);
    }
}
