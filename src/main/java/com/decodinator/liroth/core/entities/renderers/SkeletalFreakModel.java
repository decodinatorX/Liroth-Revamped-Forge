package com.decodinator.liroth.core.entities.renderers;

import com.decodinator.liroth.Liroth;

import com.decodinator.liroth.core.entities.SkeletalFreakEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class SkeletalFreakModel<T extends SkeletalFreakEntity> extends AnimatedGeoModel<SkeletalFreakEntity> {
	public SkeletalFreakModel() {
		super();
	}

	@Override
	public ResourceLocation getModelResource(SkeletalFreakEntity object) {
		return new ResourceLocation(Liroth.MOD_ID, "geo/skeletal_freak/skeletal.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SkeletalFreakEntity object) {
		return new ResourceLocation(Liroth.MOD_ID, "textures/entity/skeletal_freak/skeletal_freak.png");
	}

	@Override
	public ResourceLocation getAnimationResource(SkeletalFreakEntity animatable) {
		return new ResourceLocation(Liroth.MOD_ID, "animations/skeletal_freak/skeletal.animation.json");
	}

	@Override
	public void setCustomAnimations(SkeletalFreakEntity animatable, int instanceId, AnimationEvent animationEvent) {
		super.setCustomAnimations(animatable, instanceId, animationEvent);
		IBone head = this.getAnimationProcessor().getBone("head");

		EntityModelData extraData = (EntityModelData) animationEvent.getExtraDataOfType(EntityModelData.class).get(0);
		if (head != null) {
			head.setRotationX(extraData.headPitch * Mth.DEG_TO_RAD);
			head.setRotationY(extraData.netHeadYaw * Mth.DEG_TO_RAD);
		}
	}
}
