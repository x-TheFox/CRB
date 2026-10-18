package com.crb.content.characters.megumi;

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
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.phys.Vec3;

public class MahoragaRitualAbility extends Ability {
    public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(CursedRealityBoundless.MOD_ID, "mahoraga_ritual");

    public MahoragaRitualAbility() {
        super(ID, "Subjugation Ritual: Mahoraga (魔虚羅)", AbilityCategory.UTILITY, 250.0, 1200, 40, 15.0);
    }

    @Override
    public void execute(ServerPlayer player, AbilityContext context) {
        ServerLevel level = player.serverLevel();
        Vec3 spawnPos = player.position().add(player.getLookAngle().scale(4.0));

        player.sendSystemMessage(Component.literal("§6§l[Megumi] §eWith this treasure, I summon... Eight-Handled Sword Divergent Sila Divine General Mahoraga!"));

        IronGolem mahoraga = EntityType.IRON_GOLEM.create(level);
        if (mahoraga != null) {
            mahoraga.setPos(spawnPos.x, spawnPos.y, spawnPos.z);
            mahoraga.setCustomName(Component.literal("§6§lDivine General Mahoraga"));
            mahoraga.setCustomNameVisible(true);
            level.addFreshEntity(mahoraga);
        }

        level.sendParticles(ParticleTypes.ENCHANTED_HIT, spawnPos.x, spawnPos.y + 1.5, spawnPos.z, 100, 1.0, 1.0, 1.0, 0.2);
        level.playSound(null, spawnPos.x, spawnPos.y, spawnPos.z, SoundEvents.BELL_BLOCK, SoundSource.PLAYERS, 4.0f, 0.5f);
        level.playSound(null, spawnPos.x, spawnPos.y, spawnPos.z, SoundEvents.LIGHTNING_BOLT_THUNDER, SoundSource.PLAYERS, 3.0f, 0.7f);
    }
}
