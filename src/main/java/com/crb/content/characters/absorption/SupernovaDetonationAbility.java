package com.crb.content.characters.absorption;

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
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class SupernovaDetonationAbility extends Ability {
    public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(CursedRealityBoundless.MOD_ID, "supernova_detonation");

    public SupernovaDetonationAbility() {
        super(ID, "Cataclysmic Supernova Detonation (核融合崩壊)", AbilityCategory.OFFENSIVE, 150.0, 800, 40, 25.0);
    }

    @Override
    public void execute(ServerPlayer player, AbilityContext context) {
        ServerLevel level = player.serverLevel();
        Vec3 epicenter = player.position();

        player.sendSystemMessage(Component.literal("§4§l[ABSORPTION] §cAll stored cursed energy detonated!"));

        AABB blastArea = new AABB(epicenter.subtract(16.0, 16.0, 16.0), epicenter.add(16.0, 16.0, 16.0));
        List<Entity> casualties = level.getEntities(player, blastArea, e -> e instanceof LivingEntity && e != player);

        for (Entity e : casualties) {
            if (e instanceof LivingEntity living) {
                double dist = living.position().distanceTo(epicenter);
                float damage = (float) Math.max(20.0, (1.0 - (dist / 16.0)) * 90.0);
                living.hurt(level.damageSources().explosion(null, player), damage);
                living.hurtMarked = true;
            }
        }

        level.sendParticles(ParticleTypes.EXPLOSION_EMITTER, epicenter.x, epicenter.y + 1.0, epicenter.z, 50, 4.0, 4.0, 4.0, 0.2);
        level.playSound(null, epicenter.x, epicenter.y, epicenter.z, SoundEvents.GENERIC_EXPLODE.value(), SoundSource.PLAYERS, 5.0f, 0.4f);
    }
}
