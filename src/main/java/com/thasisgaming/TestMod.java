package com.thasisgaming;

import com.mojang.logging.LogUtils;
import com.thasisgaming.block.TBlocks;
import com.thasisgaming.block.custom.DryingRackBlock;
import com.thasisgaming.block.entity.TBlockEntites;
import com.thasisgaming.items.TCreativeModeTabs;
import com.thasisgaming.items.TItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

@Mod(TestMod.MODID)
public class TestMod {
    public static final String MODID = "thasisgamingmod";
    public static final Logger LOGGER = LogUtils.getLogger();

    public TestMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        //commonSetup method for mod loading
        modEventBus.addListener(this::commonSetup);

        //Register the Deferred Registries
        TBlocks.register(modEventBus);
        TItems.register(modEventBus);
        TCreativeModeTabs.register(modEventBus);
        TBlockEntites.register(modEventBus);

        //Register with the server and game events
        MinecraftForge.EVENT_BUS.register(this);

        //Register the config
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

        LOGGER.info("Hello from common setup");

        //Config.items.forEach((item) -> LOGGER.info("ITEM >> {}", item.toString()));
    }

    @SubscribeEvent
    public void onServerStarting(FMLCommonSetupEvent event) {
        //Do something upon server start.
        LOGGER.info("[placeholder] is initialized");
    }

    //EventBusSubscriber to register static methods
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            LOGGER.info("[placeholder] is initialized");
        }
    }
}
