package com.crb.content.characters.higuruma;

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

public class DeadlySentencingAbility extends Ability {
    public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(CursedRealityBoundless.MOD_ID, "deadly_sentencing");

    public DeadlySentencingAbility() {
        super(ID, "Domain Expansion: Deadly Sentencing (誅伏賜死)", AbilityCategory.DOMAIN_EXPANSION, 100.0, 800, 10, 50.0);
    }

    @Override
    public void execute(ServerPlayer player, AbilityContext context) {
        ServerLevel level = player.serverLevel();

        player.sendSystemMessage(Component.literal("§6§lDomain Expansion: Deadly Sentencing (誅伏賜死) §r§7— Court is now in session!"));

        DomainInstance courtroom = new DomainInstance(
                player.getUUID(),
                ID,
                BarrierType.NON_LETHAL_COURTROOM,
                player.position(),
                50.0,
                1200,
                80.0
        );

        DomainManager.registerDomain(courtroom);

        level.sendParticles(ParticleTypes.ENCHANT, player.getX(), player.getY() + 1.0, player.getZ(), 100, 2.0, 1.0, 2.0, 0.1);
        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ANVIL_USE, SoundSource.PLAYERS, 3.0f, 0.8f);
    }
}
