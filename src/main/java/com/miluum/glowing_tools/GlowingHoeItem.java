package com.miluum.glowing_tools;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

import java.util.List;

public class GlowingHoeItem extends HoeItem implements GlowingItem {
    public GlowingHoeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.glowing_tools.default.tooltip.description").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("item.glowing_tools.default.tooltip.instruction1").formatted(Formatting.GRAY));
        tooltip.add(Text.translatable("item.glowing_tools.default.tooltip.instruction2").formatted(Formatting.GRAY));
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
        else return super.useOnBlock(context);

        return ActionResult.SUCCESS;
    }

    public boolean isGlowing(ItemStack stack) {
        return stack.getItem() instanceof GlowingItem;
    }
}
