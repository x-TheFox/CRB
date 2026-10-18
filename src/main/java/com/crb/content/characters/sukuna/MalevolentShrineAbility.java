package com.crb.content.characters.sukuna;

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

public class MalevolentShrineAbility extends Ability {
    public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(CursedRealityBoundless.MOD_ID, "malevolent_shrine");

    public MalevolentShrineAbility() {
        super(ID, "Domain Expansion: Malevolent Shrine (伏魔御廚子)", AbilityCategory.DOMAIN_EXPANSION, 400.0, 1200, 20, 200.0);
    }

    @Override
    public void execute(ServerPlayer player, AbilityContext context) {
        ServerLevel level = player.serverLevel();

        player.sendSystemMessage(Component.literal("§4§lDomain Expansion: Malevolent Shrine (伏魔御廚子)"));

        DomainInstance shrine = new DomainInstance(
                player.getUUID(),
                ID,
                BarrierType.OPEN_BARRIER,
                player.position(),
                200.0,
                1000,
                120.0 // Superb refinement rating
        );

        DomainManager.registerDomain(shrine);

        // Visual manifestation: blood particles and thunder
        level.sendParticles(ParticleTypes.CRIMSON_SPORE, player.getX(), player.getY() + 2.0, player.getZ(), 300, 10.0, 5.0, 10.0, 0.1);
        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.WITHER_SPAWN, SoundSource.PLAYERS, 5.0f, 0.5f);
        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.BELL_BLOCK, SoundSource.PLAYERS, 4.0f, 0.6f);
    }
}
