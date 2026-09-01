package com.hahamera;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class HahameraMod implements ModInitializer {
    public static final String MOD_ID = "hahamera";

    public static final Block TOMATO = Registry.register(
            Registries.BLOCK,
            id("tomato"),
            new Block(AbstractBlock.Settings.copy(Blocks.DIRT))
    );

    public static final Item TOMATO_ITEM = Registry.register(
            Registries.ITEM,
            id("tomato"),
            new BlockItem(TOMATO, new Item.Settings().registryKey(
                    RegistryKey.of(RegistryKeys.ITEM, id("tomato"))
            ))
    );

    @Override
    public void onInitialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(TOMATO_ITEM);
        });
    }

    private static Identifier id(String path) {
        return Identifier.of(MOD_ID, path);
    }
}
