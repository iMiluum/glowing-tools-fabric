package com.miluum.glowing_tools;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.util.function.Predicate;

import static com.miluum.glowing_tools.GlowingTools.LOGGER;

public class GlowingItemTransformer {
    public static ItemStack getVanillaTool(ItemStack stack){
        Item item = stack.getItem();
        if(item instanceof GlowingAxeItem) return getVanillaAxeStack((AxeItem) item);
        else if(item instanceof GlowingHoeItem) return getVanillaHoeStack((HoeItem) item);
        else if(item instanceof GlowingPickaxeItem) return getVanillaPickaxeStack((PickaxeItem) item);
        else if(item instanceof GlowingShovelItem) return getVanillaShovelStack((ShovelItem) item);
        else if(item instanceof GlowingSwordItem) return getVanillaSwordStack((SwordItem) item);
        else return new ItemStack(Items.AIR);
    }

    public static ItemStack getGlowingTool(ItemStack stack){
        Item item = stack.getItem();
        if(item instanceof AxeItem) return getGlowingAxeStack((AxeItem) item);
        else if(item instanceof HoeItem) return getGlowingHoeStack((HoeItem) item);
        else if(item instanceof PickaxeItem) return getGlowingPickaxeStack((PickaxeItem) item);
        else if(item instanceof ShovelItem) return getGlowingShovelStack((ShovelItem) item);
        else if(item instanceof SwordItem) return getGlowingSwordStack((SwordItem) item);
        else return new ItemStack(Items.AIR);
    }

    public static ItemStack getVanillaAxeStack(AxeItem axe){
        AxeItem vanillaTool;
        ToolMaterial material = axe.getMaterial();
        if (material.equals(ToolMaterials.WOOD))
            vanillaTool = (AxeItem) Items.WOODEN_AXE;
        else if (material.equals(ToolMaterials.STONE))
            vanillaTool = (AxeItem) Items.STONE_AXE;
        else if (material.equals(ToolMaterials.IRON))
            vanillaTool = (AxeItem) Items.IRON_AXE;
        else if (material.equals(ToolMaterials.GOLD))
            vanillaTool = (AxeItem) Items.GOLDEN_AXE;
        else if (material.equals(ToolMaterials.DIAMOND))
            vanillaTool = (AxeItem) Items.DIAMOND_AXE;
        else if (material.equals(ToolMaterials.NETHERITE))
            vanillaTool = (AxeItem) Items.NETHERITE_AXE;
        else
            vanillaTool = (AxeItem) Items.WOODEN_AXE;
        return new ItemStack(vanillaTool);
    }

    public static ItemStack getVanillaHoeStack(HoeItem hoe){
        HoeItem vanillaTool;
        ToolMaterial material = hoe.getMaterial();
        if (material.equals(ToolMaterials.WOOD))
            vanillaTool = (HoeItem) Items.WOODEN_HOE;
        else if (material.equals(ToolMaterials.STONE))
            vanillaTool = (HoeItem) Items.STONE_HOE;
        else if (material.equals(ToolMaterials.IRON))
            vanillaTool = (HoeItem) Items.IRON_HOE;
        else if (material.equals(ToolMaterials.GOLD))
            vanillaTool = (HoeItem) Items.GOLDEN_HOE;
        else if (material.equals(ToolMaterials.DIAMOND))
            vanillaTool = (HoeItem) Items.DIAMOND_HOE;
        else if (material.equals(ToolMaterials.NETHERITE))
            vanillaTool = (HoeItem) Items.NETHERITE_HOE;
        else
            vanillaTool = (HoeItem) Items.WOODEN_HOE;
        return new ItemStack(vanillaTool);
    }

    public static ItemStack getVanillaPickaxeStack(PickaxeItem pickaxe){
        PickaxeItem vanillaTool;
        ToolMaterial material = pickaxe.getMaterial();
        if (material.equals(ToolMaterials.WOOD))
            vanillaTool = (PickaxeItem) Items.WOODEN_PICKAXE;
        else if (material.equals(ToolMaterials.STONE))
            vanillaTool = (PickaxeItem) Items.STONE_PICKAXE;
        else if (material.equals(ToolMaterials.IRON))
            vanillaTool = (PickaxeItem) Items.IRON_PICKAXE;
        else if (material.equals(ToolMaterials.GOLD))
            vanillaTool = (PickaxeItem) Items.GOLDEN_PICKAXE;
        else if (material.equals(ToolMaterials.DIAMOND))
            vanillaTool = (PickaxeItem) Items.DIAMOND_PICKAXE;
        else if (material.equals(ToolMaterials.NETHERITE))
            vanillaTool = (PickaxeItem) Items.NETHERITE_PICKAXE;
        else
            vanillaTool = (PickaxeItem) Items.WOODEN_PICKAXE;
        return new ItemStack(vanillaTool);
    }

    public static ItemStack getVanillaShovelStack(ShovelItem shovel){
        ShovelItem vanillaTool;
        ToolMaterial material = shovel.getMaterial();
        if (material.equals(ToolMaterials.WOOD))
            vanillaTool = (ShovelItem) Items.WOODEN_SHOVEL;
        else if (material.equals(ToolMaterials.STONE))
            vanillaTool = (ShovelItem) Items.STONE_SHOVEL;
        else if (material.equals(ToolMaterials.IRON))
            vanillaTool = (ShovelItem) Items.IRON_SHOVEL;
        else if (material.equals(ToolMaterials.GOLD))
            vanillaTool = (ShovelItem) Items.GOLDEN_SHOVEL;
        else if (material.equals(ToolMaterials.DIAMOND))
            vanillaTool = (ShovelItem) Items.DIAMOND_SHOVEL;
        else if (material.equals(ToolMaterials.NETHERITE))
            vanillaTool = (ShovelItem) Items.NETHERITE_SHOVEL;
        else
            vanillaTool = (ShovelItem) Items.WOODEN_SHOVEL;
        return new ItemStack(vanillaTool);
    }

    public static ItemStack getVanillaSwordStack(SwordItem sword){
        SwordItem vanillaTool;
        ToolMaterial material = sword.getMaterial();
        if (material.equals(ToolMaterials.WOOD))
            vanillaTool = (SwordItem) Items.WOODEN_SWORD;
        else if (material.equals(ToolMaterials.STONE))
            vanillaTool = (SwordItem) Items.STONE_SWORD;
        else if (material.equals(ToolMaterials.IRON))
            vanillaTool = (SwordItem) Items.IRON_SWORD;
        else if (material.equals(ToolMaterials.GOLD))
            vanillaTool = (SwordItem) Items.GOLDEN_SWORD;
        else if (material.equals(ToolMaterials.DIAMOND))
            vanillaTool = (SwordItem) Items.DIAMOND_SWORD;
        else if (material.equals(ToolMaterials.NETHERITE))
            vanillaTool = (SwordItem) Items.NETHERITE_SWORD;
        else
            vanillaTool = (SwordItem) Items.WOODEN_SWORD;
        return new ItemStack(vanillaTool);
    }

    public static ItemStack getGlowingAxeStack(AxeItem axe){
        GlowingAxeItem glowingTool;
        ToolMaterial material = axe.getMaterial();
        if (material.equals(ToolMaterials.WOOD))
            glowingTool = (GlowingAxeItem) GlowingItems.GLOWING_WOODEN_AXE;
        else if (material.equals(ToolMaterials.STONE))
            glowingTool = (GlowingAxeItem) GlowingItems.GLOWING_STONE_AXE;
        else if (material.equals(ToolMaterials.IRON))
            glowingTool = (GlowingAxeItem) GlowingItems.GLOWING_IRON_AXE;
        else if (material.equals(ToolMaterials.GOLD))
            glowingTool = (GlowingAxeItem) GlowingItems.GLOWING_GOLDEN_AXE;
        else if (material.equals(ToolMaterials.DIAMOND))
            glowingTool = (GlowingAxeItem) GlowingItems.GLOWING_DIAMOND_AXE;
        else if (material.equals(ToolMaterials.NETHERITE))
            glowingTool = (GlowingAxeItem) GlowingItems.GLOWING_NETHERITE_AXE;
        else
            glowingTool = (GlowingAxeItem) GlowingItems.GLOWING_WOODEN_AXE;

        return new ItemStack(glowingTool);
    }

    public static ItemStack getGlowingHoeStack(HoeItem hoe){
        GlowingHoeItem glowingTool;
        ToolMaterial material = hoe.getMaterial();
        if (material.equals(ToolMaterials.WOOD))
            glowingTool = (GlowingHoeItem) GlowingItems.GLOWING_WOODEN_HOE;
        else if (material.equals(ToolMaterials.STONE))
            glowingTool = (GlowingHoeItem) GlowingItems.GLOWING_STONE_HOE;
        else if (material.equals(ToolMaterials.IRON))
            glowingTool = (GlowingHoeItem) GlowingItems.GLOWING_IRON_HOE;
        else if (material.equals(ToolMaterials.GOLD))
            glowingTool = (GlowingHoeItem) GlowingItems.GLOWING_GOLDEN_HOE;
        else if (material.equals(ToolMaterials.DIAMOND))
            glowingTool = (GlowingHoeItem) GlowingItems.GLOWING_DIAMOND_HOE;
        else if (material.equals(ToolMaterials.NETHERITE))
            glowingTool = (GlowingHoeItem) GlowingItems.GLOWING_NETHERITE_HOE;
        else
            glowingTool = (GlowingHoeItem) GlowingItems.GLOWING_WOODEN_HOE;

        return new ItemStack(glowingTool);
    }

    public static ItemStack getGlowingPickaxeStack(PickaxeItem pickaxe){
        GlowingPickaxeItem glowingTool;
        ToolMaterial material = pickaxe.getMaterial();
        if (material.equals(ToolMaterials.WOOD))
            glowingTool = (GlowingPickaxeItem) GlowingItems.GLOWING_WOODEN_PICKAXE;
        else if (material.equals(ToolMaterials.STONE))
            glowingTool = (GlowingPickaxeItem) GlowingItems.GLOWING_STONE_PICKAXE;
        else if (material.equals(ToolMaterials.IRON))
            glowingTool = (GlowingPickaxeItem) GlowingItems.GLOWING_IRON_PICKAXE;
        else if (material.equals(ToolMaterials.GOLD))
            glowingTool = (GlowingPickaxeItem) GlowingItems.GLOWING_GOLDEN_PICKAXE;
        else if (material.equals(ToolMaterials.DIAMOND))
            glowingTool = (GlowingPickaxeItem) GlowingItems.GLOWING_DIAMOND_PICKAXE;
        else if (material.equals(ToolMaterials.NETHERITE))
            glowingTool = (GlowingPickaxeItem) GlowingItems.GLOWING_NETHERITE_PICKAXE;
        else
            glowingTool = (GlowingPickaxeItem) GlowingItems.GLOWING_WOODEN_PICKAXE;

        return new ItemStack(glowingTool);
    }

    public static ItemStack getGlowingShovelStack(ShovelItem shovel){
        GlowingShovelItem glowingTool;
        ToolMaterial material = shovel.getMaterial();
        if (material.equals(ToolMaterials.WOOD))
            glowingTool = (GlowingShovelItem) GlowingItems.GLOWING_WOODEN_SHOVEL;
        else if (material.equals(ToolMaterials.STONE))
            glowingTool = (GlowingShovelItem) GlowingItems.GLOWING_STONE_SHOVEL;
        else if (material.equals(ToolMaterials.IRON))
            glowingTool = (GlowingShovelItem) GlowingItems.GLOWING_IRON_SHOVEL;
        else if (material.equals(ToolMaterials.GOLD))
            glowingTool = (GlowingShovelItem) GlowingItems.GLOWING_GOLDEN_SHOVEL;
        else if (material.equals(ToolMaterials.DIAMOND))
            glowingTool = (GlowingShovelItem) GlowingItems.GLOWING_DIAMOND_SHOVEL;
        else if (material.equals(ToolMaterials.NETHERITE))
            glowingTool = (GlowingShovelItem) GlowingItems.GLOWING_NETHERITE_SHOVEL;
        else
            glowingTool = (GlowingShovelItem) GlowingItems.GLOWING_WOODEN_SHOVEL;

        return new ItemStack(glowingTool);
    }

    public static ItemStack getGlowingSwordStack(SwordItem sword){
        GlowingSwordItem glowingTool;
        ToolMaterial material = sword.getMaterial();
        if (material.equals(ToolMaterials.WOOD))
            glowingTool = (GlowingSwordItem) GlowingItems.GLOWING_WOODEN_SWORD;
        else if (material.equals(ToolMaterials.STONE))
            glowingTool = (GlowingSwordItem) GlowingItems.GLOWING_STONE_SWORD;
        else if (material.equals(ToolMaterials.IRON))
            glowingTool = (GlowingSwordItem) GlowingItems.GLOWING_IRON_SWORD;
        else if (material.equals(ToolMaterials.GOLD))
            glowingTool = (GlowingSwordItem) GlowingItems.GLOWING_GOLDEN_SWORD;
        else if (material.equals(ToolMaterials.DIAMOND))
            glowingTool = (GlowingSwordItem) GlowingItems.GLOWING_DIAMOND_SWORD;
        else if (material.equals(ToolMaterials.NETHERITE))
            glowingTool = (GlowingSwordItem) GlowingItems.GLOWING_NETHERITE_SWORD;
        else
            glowingTool = (GlowingSwordItem) GlowingItems.GLOWING_WOODEN_SWORD;

        return new ItemStack(glowingTool);
    }

    public static boolean placeTorch(World world, BlockPos pos, Direction side, PlayerEntity miner){
        if(!(world.getBlockState(pos).isSolidBlock(world, pos))) return false;
        BlockState torchState;
        if (side == Direction.UP) torchState = Blocks.TORCH.getDefaultState();
        else if (side == Direction.DOWN) return false;
        else torchState = Blocks.WALL_TORCH.getDefaultState().with(Properties.HORIZONTAL_FACING, side);
        BlockPos torchPos = pos.offset(side);
        if (!(world.getBlockState(torchPos).isAir()))  return false;
        world.setBlockState(torchPos, torchState);
        world.playSound(null, torchPos, Blocks.TORCH.getSoundGroup(torchState).getPlaceSound(), SoundCategory.BLOCKS, 1.0F, 1.0F);
        ItemStack torchStack = new ItemStack(Items.TORCH);
        if (miner.getInventory().contains(torchStack)) {
            miner.getInventory().remove(itemStack -> itemStack.getItem() == Items.TORCH, 1, miner.getInventory());
            return false;
        }
        return true;
    }

    public static ActionResult pickUpTorch(PlayerEntity player, World world, Hand hand, BlockHitResult hitResult){
        ItemStack stack = player.getStackInHand(hand);
        if (!player.isSneaking()) return ActionResult.PASS;
        if (!(stack.getItem() instanceof ToolItem)) return ActionResult.PASS;

        BlockPos pos = hitResult.getBlockPos();
        BlockState state = world.getBlockState(pos);

        if (!(state.getBlock() == Blocks.TORCH || state.getBlock() == Blocks.WALL_TORCH)) return ActionResult.PASS;

        world.setBlockState(pos, Blocks.AIR.getDefaultState());
        world.playSound(null, pos, Blocks.TORCH.getSoundGroup(state).getBreakSound(), SoundCategory.BLOCKS, 1.0F, 1.0F);

        if (stack.getItem() instanceof GlowingItem) {

            player.getInventory().offerOrDrop(new ItemStack(Blocks.TORCH));
            return ActionResult.SUCCESS;
        }
        else {
            GlowingItemTransformer.transformVanillaTool(stack, player);
        }
        return ActionResult.SUCCESS;
    }

    public static void copyData(ItemStack stack, ItemStack vanillaToolStack) {
        vanillaToolStack.setDamage(stack.getDamage());
        EnchantmentHelper.set(EnchantmentHelper.get(stack), vanillaToolStack);
    }

    public static void turnToVanillaTool(ItemStack stack, LivingEntity miner) {
        try {
            ItemStack vanillaToolStack = GlowingItemTransformer.getVanillaTool(stack);
            copyData(stack, vanillaToolStack);
            stack.decrement(1);
            miner.equipStack(EquipmentSlot.MAINHAND, vanillaToolStack);
        }
        catch (Exception e) {
            LOGGER.error("E: " + e);
        }
    }

    public static void turnToGlowingTool(ItemStack stack, LivingEntity miner) {
        try {
            ItemStack glowingToolStack = GlowingItemTransformer.getGlowingTool(stack);
            copyData(stack, glowingToolStack);
            stack.decrement(1);
            miner.equipStack(EquipmentSlot.MAINHAND, glowingToolStack);
        }
        catch (Exception e) {
            LOGGER.error("E: " + e);
        }
    }

    public static void transformGlowingTool(ItemStack stack, World world, BlockPos pos, PlayerEntity miner, Direction side){
        if(GlowingItemTransformer.placeTorch(world, pos, side, miner)) GlowingItemTransformer.turnToVanillaTool(stack, miner);
    }

    public static void transformVanillaTool(ItemStack stack, PlayerEntity miner){
        GlowingItemTransformer.turnToGlowingTool(stack, miner);
    }
}
