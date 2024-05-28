package com.thasisgaming.items;

import com.thasisgaming.TestMod;
import com.thasisgaming.block.TBlocks;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TestMod.MODID);

    // Item Registry
    public static final RegistryObject<Item> TOBACCO_SEEDS = ITEMS.register("tobacco_seeds",
            () -> new ItemNameBlockItem(TBlocks.TOBACCO_PLANT.get(), new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> TOBACCO_LEAVES = ITEMS.register("tobacco_leaves",
            () -> new Item(new Item.Properties().stacksTo(64)));

    // Registration Method
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
