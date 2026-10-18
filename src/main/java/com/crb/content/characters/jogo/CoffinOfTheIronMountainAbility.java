package com.crb.content.characters.jogo;

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

public class CoffinOfTheIronMountainAbility extends Ability {
    public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(CursedRealityBoundless.MOD_ID, "coffin_iron_mountain");

    public CoffinOfTheIronMountainAbility() {
        super(ID, "Domain Expansion: Coffin of the Iron Mountain (蓋棺鉄囲山)", AbilityCategory.DOMAIN_EXPANSION, 300.0, 1000, 20, 66.0);
    }

    @Override
    public void execute(ServerPlayer player, AbilityContext context) {
        ServerLevel level = player.serverLevel();

        player.sendSystemMessage(Component.literal("§c§lDomain Expansion: Coffin of the Iron Mountain (蓋棺鉄囲山)"));

        DomainInstance coffin = new DomainInstance(
                player.getUUID(),
                ID,
                BarrierType.CLOSED_SPHERE,
                player.position(),
                66.0,
                850,
                90.0 // Solid disaster curse refinement
        );

        DomainManager.registerDomain(coffin);

        // Volcanic magma particles
        level.sendParticles(ParticleTypes.LAVA, player.getX(), player.getY() + 1.0, player.getZ(), 200, 5.0, 2.0, 5.0, 0.2);
        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.LAVA_EXTINGUISH, SoundSource.PLAYERS, 3.0f, 0.5f);
    }
}
