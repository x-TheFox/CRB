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
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.phys.Vec3;

public class TenShadowsSummonAbility extends Ability {
    public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(CursedRealityBoundless.MOD_ID, "ten_shadows_summon");

    public TenShadowsSummonAbility() {
        super(ID, "Ten Shadows: Divine Dog (玉犬)", AbilityCategory.UTILITY, 50.0, 100, 10, 10.0);
    }

    @Override
    public void execute(ServerPlayer player, AbilityContext context) {
        ServerLevel level = player.serverLevel();
        Vec3 spawnPos = player.position().add(player.getLookAngle().scale(2.5));

        // Materialize shadow shikigami
        Wolf divineDog = EntityType.WOLF.create(level);
        if (divineDog != null) {
            divineDog.setPos(spawnPos.x, spawnPos.y, spawnPos.z);
            divineDog.tame(player);
            divineDog.setCustomName(Component.literal("§8Divine Dog: Totality"));
            divineDog.setCustomNameVisible(true);
            level.addFreshEntity(divineDog);
        }

        level.sendParticles(ParticleTypes.SQUID_INK, spawnPos.x, spawnPos.y + 0.5, spawnPos.z, 50, 0.5, 0.5, 0.5, 0.05);
        level.playSound(null, spawnPos.x, spawnPos.y, spawnPos.z, SoundEvents.WOLF_GROWL, SoundSource.PLAYERS, 2.0f, 0.8f);
    }
}
