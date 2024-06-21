package com.decodinator.liroth.core.entities.renderers;

import com.decodinator.liroth.Liroth;

import com.decodinator.liroth.core.entities.SkeletalFreakEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.model.data.EntityModelData;
import net.minecraft.util.Mth;

public class SkeletalFreakModel<T extends SkeletalFreakEntity> extends DefaultedEntityGeoModel<SkeletalFreakEntity> {
	public SkeletalFreakModel() {
		super(new ResourceLocation(Liroth.MOD_ID, "skeletal_freak/skeletal"));
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
	public void setCustomAnimations(SkeletalFreakEntity animatable, long instanceId, AnimationState<SkeletalFreakEntity> animationState) {
		CoreGeoBone head = getAnimationProcessor().getBone("head");

		if (head != null) {
			EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}
	}
}
