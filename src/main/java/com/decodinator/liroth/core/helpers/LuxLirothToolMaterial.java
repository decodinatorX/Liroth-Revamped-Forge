package com.decodinator.liroth.core.helpers;

import com.decodinator.liroth.core.LirothItems;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class LuxLirothToolMaterial implements Tier {

	@Override
	public int getUses() {
		return 1031;
	}

	@Override
	public float getSpeed() {
		return 20.0f;
	}

	@Override
	public float getAttackDamageBonus() {
		return 4.0f;
	}

	@Override
	public int getLevel() {
		return 5;
	}

	@Override
	public int getEnchantmentValue() {
		return 25;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.of(LirothItems.LIROTH_GEM_LUX.get());
	}

}
