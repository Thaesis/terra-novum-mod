package com.thasisgaming.block.entity;

import com.thasisgaming.TestMod;
import com.thasisgaming.block.TBlocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TBlockEntites {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, TestMod.MODID);

    public static final RegistryObject<BlockEntityType<DryingRackBlockEntity>> DRYING_RACK_BE =
            BLOCK_ENTITIES.register("drying_rack_be", () ->
                    BlockEntityType.Builder.of(DryingRackBlockEntity::new, TBlocks.DRYING_RACK.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
