package com.decodinator.liroth.core.entities.renderers;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.entities.ProwlerEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class ProwlerModel<T extends ProwlerEntity> extends DefaultedEntityGeoModel<ProwlerEntity> {
    public ProwlerModel() {
        super(new ResourceLocation(Liroth.MOD_ID, "prowler/prowler"));
    }

    @Override
    public ResourceLocation getModelResource(ProwlerEntity object) {
        return new ResourceLocation(Liroth.MOD_ID, "geo/prowler/prowler.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ProwlerEntity object) {
        return new ResourceLocation(Liroth.MOD_ID, "textures/entity/prowler/prowler.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ProwlerEntity animatable) {
        return new ResourceLocation(Liroth.MOD_ID, "animations/prowler/prowler.animation.json");
    }

    @Override
    public void setCustomAnimations(ProwlerEntity animatable, long instanceId, AnimationState<ProwlerEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}
