package com.miluum.glowing_tools;

import com.ibm.icu.impl.Row;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.minecraft.item.*;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
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

    private static void registerItem(String key, Item item) {
        Registry.register(Registries.ITEM, new Identifier("glowing_tools", key), item);
    }

    public static void registerBuiltinPack(String namespace, String path) {
        ModContainer mod = FabricLoader.getInstance().getModContainer("glowing_tools").orElseThrow();
        ResourceManagerHelper.registerBuiltinResourcePack(new Identifier(namespace, path), mod, ResourcePackActivationType.NORMAL);
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

    public static final ItemGroup ITEM_GROUP = FabricItemGroup.builder()
            .displayName(Text.translatable("itemGroup.glowing_tools.tools"))
            .icon(() -> new ItemStack(GLOWING_NETHERITE_PICKAXE))
            .entries((context, entries) -> entries.addAll(itemList))
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

        registerItem("glowing_netherite_shovel", GLOWING_NETHERITE_SHOVEL);
        registerItem("glowing_diamond_shovel", GLOWING_DIAMOND_SHOVEL);
        registerItem("glowing_golden_shovel", GLOWING_GOLDEN_SHOVEL);
        registerItem("glowing_iron_shovel", GLOWING_IRON_SHOVEL);
        registerItem("glowing_stone_shovel", GLOWING_STONE_SHOVEL);
        registerItem("glowing_wooden_shovel", GLOWING_WOODEN_SHOVEL);

        registerItem("glowing_netherite_sword", GLOWING_NETHERITE_SWORD);
        registerItem("glowing_diamond_sword", GLOWING_DIAMOND_SWORD);
        registerItem("glowing_golden_sword", GLOWING_GOLDEN_SWORD);
        registerItem("glowing_iron_sword", GLOWING_IRON_SWORD);
        registerItem("glowing_stone_sword", GLOWING_STONE_SWORD);
        registerItem("glowing_wooden_sword", GLOWING_WOODEN_SWORD);

        registerItem("glowing_netherite_hoe", GLOWING_NETHERITE_HOE);
        registerItem("glowing_diamond_hoe", GLOWING_DIAMOND_HOE);
        registerItem("glowing_golden_hoe", GLOWING_GOLDEN_HOE);
        registerItem("glowing_iron_hoe", GLOWING_IRON_HOE);
        registerItem("glowing_stone_hoe", GLOWING_STONE_HOE);
        registerItem("glowing_wooden_hoe", GLOWING_WOODEN_HOE);

        Registry.register(Registries.ITEM_GROUP, new Identifier("glowing_tools", "tools"), ITEM_GROUP);

        registerBuiltinPack("glowing_tools", "legacy_glowing_tools");
    }

}