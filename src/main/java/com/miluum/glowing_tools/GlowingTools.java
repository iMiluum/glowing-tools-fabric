package com.miluum.glowing_tools;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static com.miluum.glowing_tools.GlowingItems.*;

public class GlowingTools implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("glowing-tools");





    public static void registerBuiltinPack(String namespace, String path) {
        ModContainer mod = FabricLoader.getInstance().getModContainer("glowing_tools").orElseThrow();
        ResourceManagerHelper.registerBuiltinResourcePack(new Identifier(namespace, path), mod, "Legacy Glowing Tools", ResourcePackActivationType.NORMAL);
    }



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
        GlowingItems.registerItem("glowing_netherite_pickaxe", GLOWING_NETHERITE_PICKAXE);
        GlowingItems.registerItem("glowing_diamond_pickaxe", GLOWING_DIAMOND_PICKAXE);
        GlowingItems.registerItem("glowing_golden_pickaxe", GLOWING_GOLDEN_PICKAXE);
        GlowingItems.registerItem("glowing_iron_pickaxe", GLOWING_IRON_PICKAXE);
        GlowingItems.registerItem("glowing_stone_pickaxe", GLOWING_STONE_PICKAXE);
        GlowingItems.registerItem("glowing_wooden_pickaxe", GLOWING_WOODEN_PICKAXE);

        GlowingItems.registerItem("glowing_netherite_axe", GLOWING_NETHERITE_AXE);
        GlowingItems.registerItem("glowing_diamond_axe", GLOWING_DIAMOND_AXE);
        GlowingItems.registerItem("glowing_golden_axe", GLOWING_GOLDEN_AXE);
        GlowingItems.registerItem("glowing_iron_axe", GLOWING_IRON_AXE);
        GlowingItems.registerItem("glowing_stone_axe", GLOWING_STONE_AXE);
        GlowingItems.registerItem("glowing_wooden_axe", GLOWING_WOODEN_AXE);

        GlowingItems.registerItem("glowing_netherite_shovel", GLOWING_NETHERITE_SHOVEL);
        GlowingItems.registerItem("glowing_diamond_shovel", GLOWING_DIAMOND_SHOVEL);
        GlowingItems.registerItem("glowing_golden_shovel", GLOWING_GOLDEN_SHOVEL);
        GlowingItems.registerItem("glowing_iron_shovel", GLOWING_IRON_SHOVEL);
        GlowingItems.registerItem("glowing_stone_shovel", GLOWING_STONE_SHOVEL);
        GlowingItems.registerItem("glowing_wooden_shovel", GLOWING_WOODEN_SHOVEL);

        GlowingItems.registerItem("glowing_netherite_sword", GLOWING_NETHERITE_SWORD);
        GlowingItems.registerItem("glowing_diamond_sword", GLOWING_DIAMOND_SWORD);
        GlowingItems.registerItem("glowing_golden_sword", GLOWING_GOLDEN_SWORD);
        GlowingItems.registerItem("glowing_iron_sword", GLOWING_IRON_SWORD);
        GlowingItems.registerItem("glowing_stone_sword", GLOWING_STONE_SWORD);
        GlowingItems.registerItem("glowing_wooden_sword", GLOWING_WOODEN_SWORD);

        GlowingItems.registerItem("glowing_netherite_hoe", GLOWING_NETHERITE_HOE);
        GlowingItems.registerItem("glowing_diamond_hoe", GLOWING_DIAMOND_HOE);
        GlowingItems.registerItem("glowing_golden_hoe", GLOWING_GOLDEN_HOE);
        GlowingItems.registerItem("glowing_iron_hoe", GLOWING_IRON_HOE);
        GlowingItems.registerItem("glowing_stone_hoe", GLOWING_STONE_HOE);
        GlowingItems.registerItem("glowing_wooden_hoe", GLOWING_WOODEN_HOE);

        registerBuiltinPack("glowing_tools", "legacy_glowing_tools");

        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            ItemStack stack = player.getStackInHand(hand);
            if (!player.isSneaking()) return ActionResult.PASS;
            if (!(stack.getItem() instanceof ToolItem)) return ActionResult.PASS;
            if (stack.getItem() instanceof GlowingItem) return ActionResult.PASS;

            BlockPos pos = hitResult.getBlockPos();
            BlockState state = world.getBlockState(pos);
            if (state.getBlock() == Blocks.TORCH || state.getBlock() == Blocks.WALL_TORCH) {
                world.setBlockState(pos, Blocks.AIR.getDefaultState());
                GlowingItemTransformer.transformVanillaTool(stack, player);
                return ActionResult.SUCCESS;
            }
            return ActionResult.PASS;
        });
    }

}