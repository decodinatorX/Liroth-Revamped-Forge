package com.decodinator.liroth.core.helpers;

import com.decodinator.liroth.core.LirothItems;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class LirothianCobaltToolMaterial implements Tier {

	@Override
	public int getUses() {
		return 250;
	}

	@Override
	public float getSpeed() {
		return 6.0f;
	}

	@Override
	public float getAttackDamageBonus() {
		return 2.0f;
	}

	@Override
	public int getLevel() {
		return 2;
	}

	@Override
	public int getEnchantmentValue() {
		return 14;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.of(LirothItems.LIROTHIAN_COBALT_INGOT.get());
	}

}
