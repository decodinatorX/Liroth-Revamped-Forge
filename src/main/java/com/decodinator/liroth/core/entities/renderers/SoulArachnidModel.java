package com.decodinator.liroth.core.entities.renderers;

import com.decodinator.liroth.Liroth;

import com.decodinator.liroth.core.entities.SoulArachnidEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class SoulArachnidModel<T extends SoulArachnidEntity> extends DefaultedEntityGeoModel<SoulArachnidEntity> {
	public SoulArachnidModel() {
		super(new ResourceLocation(Liroth.MOD_ID, "soul_arachnid/soul_arachnid"));
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
	public void setCustomAnimations(SoulArachnidEntity animatable, long instanceId, AnimationState<SoulArachnidEntity> animationState) {
		CoreGeoBone head = getAnimationProcessor().getBone("head");

		if (head != null) {
			EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}
	}
}
