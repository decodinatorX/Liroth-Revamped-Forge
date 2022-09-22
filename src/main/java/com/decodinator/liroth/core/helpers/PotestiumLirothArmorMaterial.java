package com.decodinator.liroth.core.helpers;

import com.decodinator.liroth.core.LirothItems;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

public class PotestiumLirothArmorMaterial implements ArmorMaterial {
	private static final int[] BASE_DURABILITY = new int[] {15, 17, 18, 13};
	private static final int[] PROTECTION_VALUES = new int[] {6, 9, 11, 6}; 
	// In which A is helmet, B chestplate, C leggings and D boots. 
	// For reference, Leather uses {1, 2, 3, 1}, and Diamond/Netherite {3, 6, 8, 3}
	@Override
	public int getDurabilityForSlot(EquipmentSlot var1) {
		return BASE_DURABILITY[var1.getIndex()] * 37;
	}

	@Override
	public int getDefenseForSlot(EquipmentSlot var1) {
		return PROTECTION_VALUES[var1.getIndex()];
	}

	@Override
	public int getEnchantmentValue() {
		return 14;
	}

	@Override
	public SoundEvent getEquipSound() {
		return SoundEvents.ARMOR_EQUIP_NETHERITE;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.of(LirothItems.QUANTUM_DIAMOND.get());

	}

	@Override
	public String getName() {
		return "potestium";
	}

	@Override
	public float getToughness() {
		return 4.0F;
	}

	@Override
	public float getKnockbackResistance() {
		return 0.25F;
	}
}
