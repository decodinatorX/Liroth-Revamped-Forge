package com.decodinator.liroth.core.entities.renderers;

import com.decodinator.liroth.Liroth;

import com.decodinator.liroth.core.entities.FungalFiendEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class FungalFiendModel<T extends FungalFiendEntity> extends AnimatedGeoModel<FungalFiendEntity> {
	public FungalFiendModel() {
		super();
	}

	@Override
	public ResourceLocation getModelResource(FungalFiendEntity object) {
		return new ResourceLocation(Liroth.MOD_ID, "geo/fungal_fiend/fungal.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(FungalFiendEntity object) {
		return new ResourceLocation(Liroth.MOD_ID, "textures/entity/fungal_fiend/fungal_fiend.png");
	}

	@Override
	public ResourceLocation getAnimationResource(FungalFiendEntity animatable) {
		return new ResourceLocation(Liroth.MOD_ID, "animations/fungal_fiend/fungal.animation.json");
	}

	@Override
	public void setCustomAnimations(FungalFiendEntity animatable, int instanceId, AnimationEvent animationEvent) {
		super.setCustomAnimations(animatable, instanceId, animationEvent);
		IBone head = this.getAnimationProcessor().getBone("head");

		EntityModelData extraData = (EntityModelData) animationEvent.getExtraDataOfType(EntityModelData.class).get(0);
		if (head != null) {
			head.setRotationX(extraData.headPitch * Mth.DEG_TO_RAD);
			head.setRotationY(extraData.netHeadYaw * Mth.DEG_TO_RAD);
		}
	}
}
