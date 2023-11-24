package com.miluum.glowing_tools;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class GlowingShovelItem extends ShovelItem {
    public GlowingShovelItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.glowing_tools.default.tooltip").formatted(Formatting.GRAY));
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        ItemStack stack = context.getStack();
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        PlayerEntity miner = context.getPlayer();
        Direction side = context.getSide();


        assert miner != null;
        if (miner.isSneaking()) GlowingItemTransformer.transformGlowingTool(stack, world, pos, miner, side);
        else super.useOnBlock(context);

        return ActionResult.SUCCESS;
    }

    public boolean isGlowing(ItemStack stack) {
        return stack.getItem() instanceof GlowingItem;
    }
}
