package com.miluum.glowing_tools;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class GlowingTools implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("glowing-tools");
    private static final List<ItemStack> itemList = new ArrayList<>();

    private static Item createPickaxeItem(ToolMaterial material){
        Item createdItem = new GlowingPickaxeItem(
                material,
                1,
                -2.8f,
                new Item.Settings()
        );
        ItemStack createdItemStack = new ItemStack(createdItem);
        itemList.add(createdItemStack);
        return createdItem;
    }

    public static final Item GLOWING_NETHERITE_PICKAXE = createPickaxeItem(ToolMaterials.NETHERITE);
    public static final Item GLOWING_DIAMOND_PICKAXE = createPickaxeItem(ToolMaterials.DIAMOND);
    public static final Item GLOWING_GOLDEN_PICKAXE = createPickaxeItem(ToolMaterials.GOLD);
    public static final Item GLOWING_IRON_PICKAXE = createPickaxeItem(ToolMaterials.IRON);
    public static final Item GLOWING_STONE_PICKAXE = createPickaxeItem(ToolMaterials.STONE);
    public static final Item GLOWING_WOODEN_PICKAXE = createPickaxeItem(ToolMaterials.WOOD);

    public static final ItemGroup TOOL_GROUP = FabricItemGroupBuilder.create(
                    new Identifier("glowing_tools", "tools"))
            .icon(() -> new ItemStack(GLOWING_DIAMOND_PICKAXE))
            .appendItems(stacks -> {
                stacks.addAll(itemList);
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