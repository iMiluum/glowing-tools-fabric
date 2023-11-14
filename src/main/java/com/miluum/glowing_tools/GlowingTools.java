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

    private static Item createAxeItem(ToolMaterial material){
        return createAxeItem(material, 6, -3.2f);
    }

    private static Item createAxeItem(ToolMaterial material, int attackDamage){
        return createAxeItem(material, attackDamage, -3.2f);
    }

    private static Item createAxeItem(ToolMaterial material, float attackSpeed){
        return createAxeItem(material, 6, attackSpeed);
    }

    private static Item createAxeItem(ToolMaterial material, int attackDamage, float attackSpeed){
        Item createdItem = new GlowingAxeItem(
                material,
                attackDamage,
                attackSpeed,
                new Item.Settings()
        );
        ItemStack createdItemStack = new ItemStack(createdItem);
        itemList.add(createdItemStack);
        return createdItem;
    }

    private static Item createShovelItem(ToolMaterial material){
        Item createdItem = new GlowingShovelItem(
                material,
                1.5f,
                -3.0f,
                new Item.Settings()
        );
        ItemStack createdItemStack = new ItemStack(createdItem);
        itemList.add(createdItemStack);
        return createdItem;
    }

    private static void registerItem(String key, Item item) {
        Registry.register(Registry.ITEM, new Identifier("glowing_tools", key), item);
    }

    public static final Item GLOWING_NETHERITE_PICKAXE = createPickaxeItem(ToolMaterials.NETHERITE);
    public static final Item GLOWING_DIAMOND_PICKAXE = createPickaxeItem(ToolMaterials.DIAMOND);
    public static final Item GLOWING_GOLDEN_PICKAXE = createPickaxeItem(ToolMaterials.GOLD);
    public static final Item GLOWING_IRON_PICKAXE = createPickaxeItem(ToolMaterials.IRON);
    public static final Item GLOWING_STONE_PICKAXE = createPickaxeItem(ToolMaterials.STONE);
    public static final Item GLOWING_WOODEN_PICKAXE = createPickaxeItem(ToolMaterials.WOOD);

    public static final Item GLOWING_NETHERITE_AXE = createAxeItem(ToolMaterials.NETHERITE, 5, -3.0f);
    public static final Item GLOWING_DIAMOND_AXE = createAxeItem(ToolMaterials.DIAMOND, 5, -3.0f);
    public static final Item GLOWING_GOLDEN_AXE = createAxeItem(ToolMaterials.GOLD, -3.0f);
    public static final Item GLOWING_IRON_AXE = createAxeItem(ToolMaterials.IRON, -3.1f);
    public static final Item GLOWING_STONE_AXE = createAxeItem(ToolMaterials.STONE, 7);
    public static final Item GLOWING_WOODEN_AXE = createAxeItem(ToolMaterials.WOOD);

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
        registerItem("glowing_netherite_pickaxe", GLOWING_NETHERITE_PICKAXE);
        registerItem("glowing_diamond_pickaxe", GLOWING_DIAMOND_PICKAXE);
        registerItem("glowing_golden_pickaxe", GLOWING_GOLDEN_PICKAXE);
        registerItem("glowing_iron_pickaxe", GLOWING_IRON_PICKAXE);
        registerItem("glowing_stone_pickaxe", GLOWING_STONE_PICKAXE);
        registerItem("glowing_wooden_pickaxe", GLOWING_WOODEN_PICKAXE);

        registerItem("glowing_netherite_axe", GLOWING_NETHERITE_AXE);
        registerItem("glowing_diamond_axe", GLOWING_DIAMOND_AXE);
        registerItem("glowing_golden_axe", GLOWING_GOLDEN_AXE);
        registerItem("glowing_iron_axe", GLOWING_IRON_AXE);
        registerItem("glowing_stone_axe", GLOWING_STONE_AXE);
        registerItem("glowing_wooden_axe", GLOWING_WOODEN_AXE);

    }
}