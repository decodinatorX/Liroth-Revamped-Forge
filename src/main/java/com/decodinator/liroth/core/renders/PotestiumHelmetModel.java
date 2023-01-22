package com.decodinator.liroth.core.renders;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.items.PotestiumHelmetItem;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class PotestiumHelmetModel extends AnimatedGeoModel<PotestiumHelmetItem> {

	@Override
	public ResourceLocation getAnimationResource(PotestiumHelmetItem animatable) {
		return new ResourceLocation(Liroth.MOD_ID, "animations/item/armor/potestium_armor_helm.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(PotestiumHelmetItem object) {
		return new ResourceLocation(Liroth.MOD_ID, "geo/item/armor/potestium_armor_helm.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(PotestiumHelmetItem object) {
		return new ResourceLocation(Liroth.MOD_ID, "textures/item/armor/potestium_armor_helm.png");
	}
}