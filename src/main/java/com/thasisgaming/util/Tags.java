package com.thasisgaming.util;

import com.thasisgaming.TestMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class Tags {
    public static class Blocks {
        // Block Tags


        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(TestMod.MODID, name));
        }
    }

    public static class Items {
        // Item Tags


        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(TestMod.MODID, name));
        }
    }
}
