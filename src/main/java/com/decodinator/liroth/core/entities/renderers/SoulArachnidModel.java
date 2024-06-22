package com.decodinator.liroth.core.entities.renderers;

import com.decodinator.liroth.Liroth;

import com.decodinator.liroth.core.entities.SoulArachnidEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class SoulArachnidModel<T extends SoulArachnidEntity> extends AnimatedGeoModel<SoulArachnidEntity> {
	public SoulArachnidModel() {
		super();
	}

	@Override
	public ResourceLocation getModelResource(SoulArachnidEntity object) {
		return new ResourceLocation(Liroth.MOD_ID, "geo/soul_arachnid/soul_arachnid.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SoulArachnidEntity object) {
		return new ResourceLocation(Liroth.MOD_ID, "textures/entity/soul_arachnid/soul_arachnid.png");
	}

	@Override
	public ResourceLocation getAnimationResource(SoulArachnidEntity animatable) {
		return new ResourceLocation(Liroth.MOD_ID, "animations/soul_arachnid/soul_arachnid.animation.json");
	}

	@Override
	public void setCustomAnimations(SoulArachnidEntity animatable, int instanceId, AnimationEvent animationEvent) {
		super.setCustomAnimations(animatable, instanceId, animationEvent);
		IBone head = this.getAnimationProcessor().getBone("head");

		EntityModelData extraData = (EntityModelData) animationEvent.getExtraDataOfType(EntityModelData.class).get(0);
		if (head != null) {
			head.setRotationX(extraData.headPitch * Mth.DEG_TO_RAD);
			head.setRotationY(extraData.netHeadYaw * Mth.DEG_TO_RAD);
		}
	}
}
