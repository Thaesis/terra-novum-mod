package com.thasisgaming.block;

import com.thasisgaming.TestMod;
import com.thasisgaming.block.custom.DryingRackBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TestMod.MODID);

    // Block Registry
    public static final RegistryObject<Block> TOBACCO_PLANT = BLOCKS.register("tobacco_plant",
            () -> new CropBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission()
                    .randomTicks().instabreak().sound(SoundType.CROP).pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> DRYING_RACK = BLOCKS.register("drying_rack",
            () -> new DryingRackBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).noOcclusion()));

    // Registration Method
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
