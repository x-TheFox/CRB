package com.crb.content.characters.megumi;

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

public class ChimeraShadowGardenAbility extends Ability {
    public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(CursedRealityBoundless.MOD_ID, "chimera_shadow_garden");

    public ChimeraShadowGardenAbility() {
        super(ID, "Domain Expansion: Chimera Shadow Garden (嵌合暗翳庭)", AbilityCategory.DOMAIN_EXPANSION, 280.0, 900, 15, 50.0);
    }

    @Override
    public void execute(ServerPlayer player, AbilityContext context) {
        ServerLevel level = player.serverLevel();

        player.sendSystemMessage(Component.literal("§8§lDomain Expansion: Chimera Shadow Garden (嵌合暗翳庭)"));

        DomainInstance garden = new DomainInstance(
                player.getUUID(),
                ID,
                BarrierType.CLOSED_SPHERE,
                player.position(),
                50.0,
                800,
                75.0 // Developing domain refinement
        );

        DomainManager.registerDomain(garden);

        // Fluid shadow floor particles
        level.sendParticles(ParticleTypes.SQUID_INK, player.getX(), player.getY() + 0.2, player.getZ(), 200, 8.0, 0.5, 8.0, 0.05);
        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.CONDUIT_ACTIVATE, SoundSource.PLAYERS, 3.0f, 0.6f);
    }
}
