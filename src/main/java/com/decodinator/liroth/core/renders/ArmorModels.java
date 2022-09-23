package com.decodinator.liroth.core.renders;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import org.jetbrains.annotations.Nullable;

import com.decodinator.liroth.core.LirothModelLayers;
import com.decodinator.liroth.core.items.PotestiumHelmetItem;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class ArmorModels {
	private static Map<EquipmentSlot, PotestiumHelmetModel> potestium = Collections.emptyMap();

	private static Map<EquipmentSlot, PotestiumHelmetModel> make(EntityRendererProvider.Context ctx, ModelLayerLocation helm) {
		Map<EquipmentSlot, PotestiumHelmetModel> ret = new EnumMap<>(EquipmentSlot.class);
		for (var slot : EquipmentSlot.values()) {
			var mesh = ctx.bakeLayer(helm);
			ret.put(slot, new PotestiumHelmetModel(mesh));
		}
		return ret;
	}

	public static void init(EntityRendererProvider.Context ctx) {
		potestium = make(ctx, LirothModelLayers.POTESTIUM_HELMET);
	}

	@Nullable
	public static PotestiumHelmetModel get(ItemStack stack) {
		Item item = stack.getItem();
		if (item instanceof PotestiumHelmetItem armor) {
			return potestium.get(armor.getSlot());
		}

		return null;
	}
}