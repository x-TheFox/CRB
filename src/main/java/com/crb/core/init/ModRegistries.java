package com.crb.core.init;

import com.crb.CursedRealityBoundless;
import com.crb.core.cursedenergy.CursedEnergyData;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class ModRegistries {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(BuiltInRegistries.ITEM, CursedRealityBoundless.MOD_ID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CursedRealityBoundless.MOD_ID);
    public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, CursedRealityBoundless.MOD_ID);

    // Data Attachments
    public static final Supplier<AttachmentType<CursedEnergyData>> CURSED_ENERGY = ATTACHMENT_TYPES.register(
            "cursed_energy",
            () -> AttachmentType.serializable(CursedEnergyData::new)
                    .copyOnDeath()
                    .build()
    );

    // Creative Tab
    public static final Supplier<CreativeModeTab> CRB_TAB = CREATIVE_MODE_TABS.register("crb_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.crb"))
            .icon(() -> new ItemStack(Items.NETHER_STAR))
            .displayItems((parameters, output) -> {
                ITEMS.getEntries().forEach(itemSupplier -> output.accept(itemSupplier.get()));
            })
            .build()
    );

    public static void register(IEventBus modBus) {
        ITEMS.register(modBus);
        CREATIVE_MODE_TABS.register(modBus);
        ATTACHMENT_TYPES.register(modBus);
    }
}
