package com.decodinator.liroth.core.helpers;

import com.decodinator.liroth.core.LirothItems;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

public class AnsalumLirothArmorMaterial implements ArmorMaterial {
	private static final int[] BASE_DURABILITY = new int[] {13, 15, 16, 11};
	private static final int[] PROTECTION_VALUES = new int[] {4, 7, 9, 4}; 
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
		return 17;
	}

	@Override
	public SoundEvent getEquipSound() {
		return SoundEvents.ARMOR_EQUIP_NETHERITE;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.of(LirothItems.LIROTH_GEM_ANSALUM.get());

	}

	@Override
	public String getName() {
		return "ansalum_liroth";
	}

	@Override
	public float getToughness() {
		return 3.0F;
	}

	@Override
	public float getKnockbackResistance() {
		return 0.35F;
	}



}
