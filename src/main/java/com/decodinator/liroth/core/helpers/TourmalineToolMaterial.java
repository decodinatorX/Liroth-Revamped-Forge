package com.decodinator.liroth.core.helpers;

import com.decodinator.liroth.core.LirothItems;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class TourmalineToolMaterial implements Tier {

	@Override
	public int getUses() {
		return 1561;
	}

	@Override
	public float getSpeed() {
		return 10.0f;
	}

	@Override
	public float getAttackDamageBonus() {
		return 3.0f;
	}

	@Override
	public int getLevel() {
		return 4;
	}

	@Override
	public int getEnchantmentValue() {
		return 22;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.of(LirothItems.TOURMALINE.get());
	}

}
