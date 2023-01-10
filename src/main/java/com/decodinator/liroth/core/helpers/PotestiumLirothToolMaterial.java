package com.decodinator.liroth.core.helpers;

import com.decodinator.liroth.core.LirothItems;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class PotestiumLirothToolMaterial implements Tier {

	@Override
	public int getUses() {
		return 4031;
	}

	@Override
	public float getSpeed() {
		return 11.0f;
	}

	@Override
	public float getAttackDamageBonus() {
		return 7.0f;
	}

	@Override
	public int getLevel() {
		return 7;
	}

	@Override
	public int getEnchantmentValue() {
		return 10;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.of(LirothItems.POTESTIUM_PLATE.get());
	}

}
