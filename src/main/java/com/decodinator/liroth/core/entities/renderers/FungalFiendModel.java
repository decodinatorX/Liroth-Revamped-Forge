package com.decodinator.liroth.core.entities.renderers;

import com.decodinator.liroth.Liroth;

import com.decodinator.liroth.core.entities.FungalFiendEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class FungalFiendModel<T extends FungalFiendEntity> extends DefaultedEntityGeoModel<FungalFiendEntity> {
	public FungalFiendModel() {
		super(new ResourceLocation(Liroth.MOD_ID, "fungal_fiend/fungal"));
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
	public void setCustomAnimations(FungalFiendEntity animatable, long instanceId, AnimationState<FungalFiendEntity> animationState) {
		CoreGeoBone head = getAnimationProcessor().getBone("head");

		if (head != null) {
			EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}
	}
}
