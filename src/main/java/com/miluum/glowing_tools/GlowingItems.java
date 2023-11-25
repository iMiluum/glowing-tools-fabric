package com.miluum.glowing_tools;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.List;

public class GlowingItems {
    public static final List<ItemStack> itemList = new ArrayList<>();

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

    private static Item createSwordItem(ToolMaterial material){
        Item createdItem = new GlowingSwordItem(
                material,
                3,
                -2.4f,
                new Item.Settings()
        );
        ItemStack createdItemStack = new ItemStack(createdItem);
        itemList.add(createdItemStack);
        return createdItem;
    }

    private static Item createHoeItem(ToolMaterial material, int attackDamage, float attackSpeed){
        Item createdItem = new GlowingHoeItem(
                material,
                attackDamage,
                attackSpeed,
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

    public static final Item GLOWING_NETHERITE_AXE = createAxeItem(ToolMaterials.NETHERITE, 5, -3.0f);
    public static final Item GLOWING_DIAMOND_AXE = createAxeItem(ToolMaterials.DIAMOND, 5, -3.0f);
    public static final Item GLOWING_GOLDEN_AXE = createAxeItem(ToolMaterials.GOLD, -3.0f);
    public static final Item GLOWING_IRON_AXE = createAxeItem(ToolMaterials.IRON, -3.1f);
    public static final Item GLOWING_STONE_AXE = createAxeItem(ToolMaterials.STONE, 7);
    public static final Item GLOWING_WOODEN_AXE = createAxeItem(ToolMaterials.WOOD);

    public static final Item GLOWING_NETHERITE_SHOVEL = createShovelItem(ToolMaterials.NETHERITE);
    public static final Item GLOWING_DIAMOND_SHOVEL = createShovelItem(ToolMaterials.DIAMOND);
    public static final Item GLOWING_GOLDEN_SHOVEL = createShovelItem(ToolMaterials.GOLD);
    public static final Item GLOWING_IRON_SHOVEL = createShovelItem(ToolMaterials.IRON);
    public static final Item GLOWING_STONE_SHOVEL = createShovelItem(ToolMaterials.STONE);
    public static final Item GLOWING_WOODEN_SHOVEL = createShovelItem(ToolMaterials.WOOD);

    public static final Item GLOWING_NETHERITE_SWORD = createSwordItem(ToolMaterials.NETHERITE);
    public static final Item GLOWING_DIAMOND_SWORD = createSwordItem(ToolMaterials.DIAMOND);
    public static final Item GLOWING_GOLDEN_SWORD = createSwordItem(ToolMaterials.GOLD);
    public static final Item GLOWING_IRON_SWORD = createSwordItem(ToolMaterials.IRON);
    public static final Item GLOWING_STONE_SWORD = createSwordItem(ToolMaterials.STONE);
    public static final Item GLOWING_WOODEN_SWORD = createSwordItem(ToolMaterials.WOOD);

    public static final Item GLOWING_NETHERITE_HOE = createHoeItem(ToolMaterials.NETHERITE, -4, 0f);
    public static final Item GLOWING_DIAMOND_HOE = createHoeItem(ToolMaterials.DIAMOND, -3, 0f);
    public static final Item GLOWING_GOLDEN_HOE = createHoeItem(ToolMaterials.GOLD, 0, -3.0f);
    public static final Item GLOWING_IRON_HOE = createHoeItem(ToolMaterials.IRON, -2, -1.0f);
    public static final Item GLOWING_STONE_HOE = createHoeItem(ToolMaterials.STONE, -1, -2.0f);
    public static final Item GLOWING_WOODEN_HOE = createHoeItem(ToolMaterials.WOOD, 0, -3.0f);

    public static void registerItem(String key, Item item) {
        Registry.register(Registry.ITEM, new Identifier("glowing_tools", key), item);
    }
}
