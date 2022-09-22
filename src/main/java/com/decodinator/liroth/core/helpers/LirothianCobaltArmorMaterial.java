package com.decodinator.liroth.core.helpers;

import com.decodinator.liroth.core.LirothItems;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

public class LirothianCobaltArmorMaterial implements ArmorMaterial {
	private static final int[] BASE_DURABILITY = new int[] {13, 15, 16, 11};
	private static final int[] PROTECTION_VALUES = new int[] {2, 5, 6, 2}; 
	// In which A is helmet, B chestplate, C leggings and D boots. 
	// For reference, Leather uses {1, 2, 3, 1}, and Diamond/Netherite {3, 6, 8, 3}
	@Override
	public int getDurabilityForSlot(EquipmentSlot var1) {
		return BASE_DURABILITY[var1.getIndex()] * 15;
	}

	@Override
	public int getDefenseForSlot(EquipmentSlot var1) {
		return PROTECTION_VALUES[var1.getIndex()];
	}

	@Override
	public int getEnchantmentValue() {
		return 9;
	}

	@Override
	public SoundEvent getEquipSound() {
		return SoundEvents.ARMOR_EQUIP_IRON;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.of(LirothItems.LIROTHIAN_COBALT_INGOT.get());

	}

	@Override
	public String getName() {
		return "lirothian_cobalt";
	}

	@Override
	public float getToughness() {
		return 0.0F;
	}

	@Override
	public float getKnockbackResistance() {
		return 0.0F;
	}



}
