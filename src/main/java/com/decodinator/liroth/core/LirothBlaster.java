package com.decodinator.liroth.core;

import java.util.function.Predicate;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.LirothItems;

import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

public class LirothBlaster extends BowItem {

	public LirothBlaster(Properties settings) {
		super(settings);
	}
	
    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player user, InteractionHand hand) {
        boolean bl;
        ItemStack itemStack = user.getItemInHand(hand);
        boolean bl2 = bl = !user.getProjectile(itemStack).isEmpty();
        if (user.getAbilities().instabuild || bl) {
            user.startUsingItem(hand);
            return InteractionResultHolder.consume(itemStack);
        }
        return InteractionResultHolder.consume(itemStack);
    }

    @Override
    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return ARROW_ONLY;
     }
    
    @Override
    public int getDefaultProjectileRange() {
        return 50;
    }
    
    @Override
    public void releaseUsing(ItemStack stack, Level world, LivingEntity user, int remainingUseTicks) {
        boolean bl2;
        int i;
        float f;
        if (!(user instanceof Player)) {
            return;
        }
        Player playerEntity = (Player)user;
        boolean bl = playerEntity.getAbilities().instabuild || EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, stack) > 0;
        ItemStack itemStack = playerEntity.getProjectile(stack);
        if (itemStack.isEmpty() && !bl) {
            return;
        }
        if (itemStack.isEmpty()) {
            itemStack = new ItemStack(Items.ARROW);
        }
        if ((double)(f = LirothBlaster.getPowerForTime(i = this.getUseDuration(stack) - remainingUseTicks)) < 0.1) {
            return;
        }
        boolean bl3 = bl2 = bl && itemStack.is(Items.ARROW);
        if (!world.isClientSide) {
            int k;
            int j;
            ArrowItem arrowItem = (ArrowItem)(itemStack.getItem() instanceof ArrowItem ? itemStack.getItem() : Items.ARROW);
            AbstractArrow persistentProjectileEntity = arrowItem.createArrow(world, itemStack, playerEntity);
            persistentProjectileEntity.shootFromRotation(playerEntity, playerEntity.getXRot(), playerEntity.getYRot(), 0.0f, f * 7.0f, 1.0f);
            if (f == 5.0f) {
                persistentProjectileEntity.setCritArrow(true);
            }
            if ((j = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.POWER_ARROWS, stack)) > 0) {
                persistentProjectileEntity.setBaseDamage(persistentProjectileEntity.getBaseDamage() + (double)j * 0.5 + 0.5);
            }
            if ((k = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.PUNCH_ARROWS, stack)) > 0) {
                persistentProjectileEntity.setKnockback(k);
            }
            if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FLAMING_ARROWS, stack) > 0) {
                persistentProjectileEntity.setSecondsOnFire(100);
            }
            stack.hurtAndBreak(1, playerEntity, p -> p.broadcastBreakEvent(playerEntity.getUsedItemHand()));
            if (bl2 || playerEntity.getAbilities().instabuild && (itemStack.is(Items.SPECTRAL_ARROW) || itemStack.is(Items.TIPPED_ARROW))) {
                persistentProjectileEntity.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
            }
            world.addFreshEntity(persistentProjectileEntity);
        }
        world.playSound(null, playerEntity.getX(), playerEntity.getY(), playerEntity.getZ(), LirothSounds.LIROTH_BLASTER_FIRING.get(), SoundSource.PLAYERS, 1.0f, 1.0f / (world.getRandom().nextFloat() * 0.4f + 1.2f) + f * 0.5f);
        if (!bl2 && !playerEntity.getAbilities().instabuild) {
            itemStack.shrink(1);
            if (itemStack.isEmpty()) {
                playerEntity.getInventory().removeItem(itemStack);
            }
        }
        playerEntity.awardStat(Stats.ITEM_USED.get(this));
    }

}
