package com.decodinator.liroth.core.items;

import java.util.List;
import javax.annotation.Nullable;

import com.decodinator.liroth.core.LirothItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;

public class LirothianShieldItem extends Item {

   public LirothianShieldItem(Item.Properties p_43089_) {
      super(p_43089_);
      DispenserBlock.registerBehavior(this, ArmorItem.DISPENSE_ITEM_BEHAVIOR);
   }

   public UseAnim getUseAnimation(ItemStack p_43105_) {
      return UseAnim.BLOCK;
   }

   public int getUseDuration(ItemStack p_43107_) {
      return 72000;
   }

   public InteractionResultHolder<ItemStack> use(Level p_43099_, Player p_43100_, InteractionHand p_43101_) {
      ItemStack itemstack = p_43100_.getItemInHand(p_43101_);
      p_43100_.startUsingItem(p_43101_);
      return InteractionResultHolder.consume(itemstack);
   }

   public boolean isValidRepairItem(ItemStack p_43091_, ItemStack p_43092_) {
      return p_43092_.is(LirothItems.LIROTH_GEM.get()) || super.isValidRepairItem(p_43091_, p_43092_);
   }

   /* ******************** FORGE START ******************** */

   @Override
   public boolean canPerformAction(ItemStack stack, net.minecraftforge.common.ToolAction toolAction) {
      return net.minecraftforge.common.ToolActions.DEFAULT_SHIELD_ACTIONS.contains(toolAction);
   }
}