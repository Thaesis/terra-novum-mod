package com.thasisgaming.items;

import com.thasisgaming.TestMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class TCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TestMod.MODID);

    public static final RegistryObject<CreativeModeTab> TEST_TAB = CREATIVE_MODE_TABS.register("test_tab", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> TItems.TOBACCO_LEAVES.get().getDefaultInstance())
            .displayItems((parameters, output) -> {

                // Blocks
                //output.accept(TOBACCO_PLANT.get());

                // Items
                output.accept(TItems.TOBACCO_SEEDS.get());
                output.accept(TItems.TOBACCO_LEAVES.get());

            }).build());

    // Registration Method
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
