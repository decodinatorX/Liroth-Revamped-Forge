package com.decodinator.liroth.core.renders;

import com.decodinator.liroth.core.items.PotestiumHelmetItem;

import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public final class PotestiumHelmetRenderer extends GeoArmorRenderer<PotestiumHelmetItem> {
/*	public PotestiumHelmetRenderer() {
		super(new DefaultedItemGeoModel<>(new ResourceLocation(Liroth.MOD_ID, "armor/potestium_armor_helm")));
	}*/
	public PotestiumHelmetRenderer() {
		super(new PotestiumHelmetModel());
	}
}