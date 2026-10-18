package com.crb.content.characters.mahito;

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

public class SelfEmbodimentOfPerfectionAbility extends Ability {
    public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(CursedRealityBoundless.MOD_ID, "self_embodiment_perfection");

    public SelfEmbodimentOfPerfectionAbility() {
        super(ID, "Domain Expansion: Self-Embodiment of Perfection (自閉円頓裹)", AbilityCategory.DOMAIN_EXPANSION, 320.0, 1000, 10, 66.0);
    }

    @Override
    public void execute(ServerPlayer player, AbilityContext context) {
        ServerLevel level = player.serverLevel();

        player.sendSystemMessage(Component.literal("§d§lDomain Expansion: Self-Embodiment of Perfection (自閉円頓裹)"));

        DomainInstance selfEmbodiment = new DomainInstance(
                player.getUUID(),
                ID,
                BarrierType.CLOSED_SPHERE,
                player.position(),
                66.0,
                800,
                95.0 // Advanced soul barrier refinement
        );

        DomainManager.registerDomain(selfEmbodiment);

        // Soul hands surrounding barrier
        level.sendParticles(ParticleTypes.SOUL, player.getX(), player.getY() + 1.0, player.getZ(), 200, 6.0, 3.0, 6.0, 0.1);
        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.SCULK_SHRIEKER_SHRIEK, SoundSource.PLAYERS, 3.5f, 1.2f);
    }
}
