package com.crb.content.characters.inumaki;

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
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class CursedSpeechCommandAbility extends Ability {
    public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(CursedRealityBoundless.MOD_ID, "cursed_speech");

    public CursedSpeechCommandAbility() {
        super(ID, "Cursed Speech: Don't Move! (動くな)", AbilityCategory.OFFENSIVE, 40.0, 80, 2, 20.0);
    }

    @Override
    public void execute(ServerPlayer player, AbilityContext context) {
        ServerLevel level = player.serverLevel();
        Vec3 reach = player.getEyePosition().add(player.getLookAngle().scale(10.0));
        AABB cone = new AABB(reach.subtract(8.0, 8.0, 8.0), reach.add(8.0, 8.0, 8.0));

        player.sendSystemMessage(Component.literal("§3§l[Inumaki] §bDon't Move! (動くな!)"));

        List<Entity> heard = level.getEntities(player, cone, e -> e instanceof LivingEntity && e != player);
        for (Entity e : heard) {
            if (e instanceof LivingEntity living) {
                // Paralyze entity completely
                living.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 10));
                living.setDeltaMovement(0, 0, 0);
                living.hurtMarked = true;

                level.sendParticles(ParticleTypes.SONIC_BOOM, living.getX(), living.getY() + 1.0, living.getZ(), 1, 0, 0, 0, 0);
            }
        }

        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.WARDEN_SONIC_BOOM, SoundSource.PLAYERS, 2.5f, 1.4f);
    }
}
