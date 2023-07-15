package com.decodinator.liroth.core.helpers;

import com.decodinator.liroth.core.LirothItems;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

public class TourmalineArmorMaterial implements ArmorMaterial {
	private static final int[] BASE_DURABILITY = new int[] {13, 15, 16, 11};
	private static final int[] PROTECTION_VALUES = new int[] {4, 7, 9, 4}; 
	// In which A is helmet, B chestplate, C leggings and D boots. 
	// For reference, Leather uses {1, 2, 3, 1}, and Diamond/Netherite {3, 6, 8, 3}
	@Override
	public int getDurabilityForType(ArmorItem.Type var1) {
		return BASE_DURABILITY[var1.ordinal()] * 37;
	}

	@Override
	public int getDefenseForType(ArmorItem.Type var1) {
		return PROTECTION_VALUES[var1.ordinal()];
	}

	@Override
	public int getEnchantmentValue() {
		return 25;
	}

	@Override
	public SoundEvent getEquipSound() {
		return SoundEvents.ARMOR_EQUIP_NETHERITE;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.of(LirothItems.TOURMALINE.get());

	}

	@Override
	public String getName() {
		return "tourmaline";
	}

	@Override
	public float getToughness() {
		return 2.0F;
	}

	@Override
	public float getKnockbackResistance() {
		return 0.15F;
	}



}
