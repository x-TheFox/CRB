package com.crb;

import com.crb.core.init.ModRegistries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import org.slf4j.Logger;
import com.mojang.logging.LogUtils;

@Mod(CursedRealityBoundless.MOD_ID)
public class CursedRealityBoundless {
    public static final String MOD_ID = "crb";
    public static final Logger LOGGER = LogUtils.getLogger();

    public CursedRealityBoundless(IEventBus modEventBus) {
        LOGGER.info("Initializing Cursed Reality: Boundless (CRB) — NeoForge 1.21.1");
        
        // Register core registries
        ModRegistries.register(modEventBus);
        
        modEventBus.addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("CRB Common Setup Initialized — Server-Authoritative Combat Engine Active");
    }
}
