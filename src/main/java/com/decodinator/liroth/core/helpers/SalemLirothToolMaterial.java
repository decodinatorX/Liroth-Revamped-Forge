package com.decodinator.liroth.core.helpers;

import com.decodinator.liroth.core.LirothItems;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class SalemLirothToolMaterial implements Tier {

	@Override
	public int getUses() {
		return 2531;
	}

	@Override
	public float getSpeed() {
		return 10.0f;
	}

	@Override
	public float getAttackDamageBonus() {
		return 5.0f;
	}

	@Override
	public int getLevel() {
		return 5;
	}

	@Override
	public int getEnchantmentValue() {
		return 20;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.of(LirothItems.LIROTH_GEM_SALEM.get());
	}

}
