package com.decodinator.liroth.core.renders;

import com.decodinator.liroth.core.items.PotestiumHelmetItem;

import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class PotestiumHelmetRenderer extends GeoArmorRenderer<PotestiumHelmetItem> {
	public PotestiumHelmetRenderer() {
		super(new PotestiumHelmetModel());
	}
}