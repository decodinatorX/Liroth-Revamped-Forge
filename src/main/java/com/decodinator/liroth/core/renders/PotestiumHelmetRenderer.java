package com.decodinator.liroth.core.renders;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.items.PotestiumHelmetItem;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public final class PotestiumHelmetRenderer extends GeoArmorRenderer<PotestiumHelmetItem> {
	public PotestiumHelmetRenderer() {
		super(new DefaultedItemGeoModel<>(new ResourceLocation(Liroth.MOD_ID, "armor/potestium_armor_helm")));
	}
}