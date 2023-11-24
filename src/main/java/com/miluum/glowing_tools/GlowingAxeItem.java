package com.miluum.glowing_tools;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.NbtList;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

import java.util.List;

public class GlowingAxeItem extends AxeItem implements GlowingItem{
    public GlowingAxeItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings, Logger LOGGER) {
        super(material, attackDamage, attackSpeed, settings);
        this.LOGGER = LOGGER;
    }

    private final Logger LOGGER;

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.glowing_tools.default.tooltip").formatted(Formatting.GRAY));
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (!world.isClient && state.getHardness(world, pos) != 0.0F) {
            stack.damage(1, miner, (e) -> {
                e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
            });
        }
        return true;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        ItemStack stack = context.getStack();
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        LivingEntity miner = context.getPlayer();
        Direction side = context.getSide();

        if (isGlowing(stack)) {
            placeTorch(world, pos, side);
            turnToNormalAxe(stack, miner);
        }
        return ActionResult.SUCCESS;
    }

    public boolean isGlowing(ItemStack stack) {
        return stack.getItem() instanceof GlowingAxeItem;
    }

    private void placeTorch(World world, BlockPos pos, Direction side) {
        BlockState torchState;
        if (side == Direction.UP) {
            torchState = Blocks.TORCH.getDefaultState();
        }
        else if (side == Direction.DOWN) {
            torchState = Blocks.WALL_TORCH.getDefaultState();
        }
        else {
            torchState = Blocks.WALL_TORCH.getDefaultState().with(Properties.HORIZONTAL_FACING, side);
        }
        BlockPos torchPos = pos.offset(side);

        world.setBlockState(torchPos, torchState);
    }

    private ItemStack getVanillaTool(ItemStack stack){
        AxeItem normalAxe;
        if (getMaterial().equals(ToolMaterials.WOOD))
            normalAxe = (AxeItem) Items.WOODEN_AXE;
        else if (getMaterial().equals(ToolMaterials.STONE))
            normalAxe = (AxeItem) Items.STONE_AXE;
        else if (getMaterial().equals(ToolMaterials.IRON))
            normalAxe = (AxeItem) Items.IRON_AXE;
        else if (getMaterial().equals(ToolMaterials.GOLD))
            normalAxe = (AxeItem) Items.GOLDEN_AXE;
        else if (getMaterial().equals(ToolMaterials.DIAMOND))
            normalAxe = (AxeItem) Items.DIAMOND_AXE;
        else if (getMaterial().equals(ToolMaterials.NETHERITE))
            normalAxe = (AxeItem) Items.NETHERITE_AXE;
        else
            normalAxe = (AxeItem) Items.WOODEN_AXE;
        return new ItemStack(normalAxe);
    }

    private void copyData(ItemStack stack, ItemStack normalAxeStack) {
        EnchantmentHelper.set(EnchantmentHelper.get(stack), normalAxeStack);
    }

    private void turnToNormalAxe(ItemStack stack, LivingEntity miner) {
        try {
            ItemStack normalAxeStack = getVanillaTool(stack);
            copyData(stack, normalAxeStack);
            stack.decrement(1);
            miner.equipStack(EquipmentSlot.MAINHAND, normalAxeStack);
        }
        catch (Exception e) {
            LOGGER.error("E: " + e);
        }
    }

}