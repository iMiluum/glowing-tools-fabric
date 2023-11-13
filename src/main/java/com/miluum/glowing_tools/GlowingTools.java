package com.miluum.glowing_tools;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GlowingTools implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("glowing-tools");
    public static final Item GLOWING_NETHERITE_PICKAXE = new GlowingPickaxeItem(
            ToolMaterials.NETHERITE,
            1,
            -2.8f,
            new Item.Settings());
    public static final Item GLOWING_DIAMOND_PICKAXE = new GlowingPickaxeItem(
            ToolMaterials.DIAMOND,
            1,
            -2.8f,
            new Item.Settings());
    public static final Item GLOWING_GOLDEN_PICKAXE = new GlowingPickaxeItem(
            ToolMaterials.GOLD,
            1,
            -2.8f,
            new Item.Settings());
    public static final Item GLOWING_IRON_PICKAXE = new GlowingPickaxeItem(
            ToolMaterials.IRON,
            1,
            -2.8f,
            new Item.Settings());
    public static final Item GLOWING_STONE_PICKAXE = new GlowingPickaxeItem(
            ToolMaterials.STONE,
            1,
            -2.8f,
            new Item.Settings());
    public static final Item GLOWING_WOODEN_PICKAXE = new GlowingPickaxeItem(
            ToolMaterials.WOOD,
            1,
            -2.8f,
            new Item.Settings());

    public static final ItemGroup TOOL_GROUP = FabricItemGroupBuilder.create(
                    new Identifier("glowing_tools", "tools"))
            .icon(() -> new ItemStack(GLOWING_DIAMOND_PICKAXE))
            .appendItems(stacks -> {
                stacks.add(new ItemStack(GLOWING_NETHERITE_PICKAXE));
                stacks.add(new ItemStack(GLOWING_DIAMOND_PICKAXE));
                stacks.add(new ItemStack(GLOWING_GOLDEN_PICKAXE));
                stacks.add(new ItemStack(GLOWING_IRON_PICKAXE));
                stacks.add(new ItemStack(GLOWING_STONE_PICKAXE));
                stacks.add(new ItemStack(GLOWING_WOODEN_PICKAXE));
            })
            .build();

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing glowing tools!");
        Registry.register(Registry.ITEM, new Identifier("glowing_tools", "glowing_netherite_pickaxe"), GLOWING_NETHERITE_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("glowing_tools", "glowing_diamond_pickaxe"), GLOWING_DIAMOND_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("glowing_tools", "glowing_golden_pickaxe"), GLOWING_GOLDEN_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("glowing_tools", "glowing_iron_pickaxe"), GLOWING_IRON_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("glowing_tools", "glowing_stone_pickaxe"), GLOWING_STONE_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("glowing_tools", "glowing_wooden_pickaxe"), GLOWING_WOODEN_PICKAXE);
    }
}