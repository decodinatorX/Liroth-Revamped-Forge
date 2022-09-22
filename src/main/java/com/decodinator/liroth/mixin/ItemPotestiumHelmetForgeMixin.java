package com.decodinator.liroth.mixin;

import java.util.function.Consumer;

import org.spongepowered.asm.mixin.Mixin;

import com.decodinator.liroth.core.ArmorModels;
import com.decodinator.liroth.core.PotestiumHelmetItem;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

@Mixin(PotestiumHelmetItem.class)
public abstract class ItemPotestiumHelmetForgeMixin extends Item {
	private ItemPotestiumHelmetForgeMixin(Properties props) {
		super(props);
	}

	@Override
	public void initializeClient(Consumer<IClientItemExtensions> consumer) {
		consumer.accept(new IClientItemExtensions() {
			@Override
			public HumanoidModel<?> getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel<?> defaultModel) {
				return ArmorModels.get(stack);
			}
		});
	}
}