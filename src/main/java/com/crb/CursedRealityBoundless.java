package com.crb;

import com.crb.core.ability.AbilityRegistry;
import com.crb.core.commands.JJKCommands;
import com.crb.core.cursedenergy.CursedEnergyData;
import com.crb.core.domain.DomainManager;
import com.crb.core.init.ModRegistries;
import com.mojang.logging.LogUtils;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.event.tick.LevelTickEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import org.slf4j.Logger;

@Mod(CursedRealityBoundless.MOD_ID)
public class CursedRealityBoundless {
    public static final String MOD_ID = "crb";
    public static final Logger LOGGER = LogUtils.getLogger();

    public CursedRealityBoundless(IEventBus modEventBus) {
        LOGGER.info("Initializing Cursed Reality: Boundless (CRB) — NeoForge 1.21.1");
        
        // Register core registries
        ModRegistries.register(modEventBus);
        
        modEventBus.addListener(this::commonSetup);

        // Register game events on NeoForge Event Bus
        NeoForge.EVENT_BUS.addListener(this::onRegisterCommands);
        NeoForge.EVENT_BUS.addListener(this::onLevelTick);
        NeoForge.EVENT_BUS.addListener(this::onPlayerTick);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("CRB Common Setup Initialized — Server-Authoritative Combat Engine Active");
        event.enqueueWork(() -> {
            AbilityRegistry.init();
            LOGGER.info("Registered {} Jujutsu Abilities into AbilityRegistry", AbilityRegistry.getAll().size());
        });
    }

    private void onRegisterCommands(RegisterCommandsEvent event) {
        JJKCommands.register(event.getDispatcher());
        LOGGER.info("Registered CRB Brigadier commands (/jjk)");
    }

    private void onLevelTick(LevelTickEvent.Post event) {
        if (event.getLevel() instanceof ServerLevel serverLevel) {
            DomainManager.tick(serverLevel);
        }
    }

    private void onPlayerTick(PlayerTickEvent.Post event) {
        if (!event.getEntity().level().isClientSide() && event.getEntity() instanceof ServerPlayer serverPlayer) {
            CursedEnergyData ceData = serverPlayer.getData(ModRegistries.CURSED_ENERGY);
            ceData.tickRegen(1);
            serverPlayer.setData(ModRegistries.CURSED_ENERGY, ceData);
        }
    }
}
