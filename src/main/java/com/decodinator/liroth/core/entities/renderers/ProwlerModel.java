package com.decodinator.liroth.core.entities.renderers;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.entities.ProwlerEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class ProwlerModel<T extends ProwlerEntity> extends AnimatedGeoModel<ProwlerEntity> {
    public ProwlerModel() {
        super();
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
    public void setCustomAnimations(ProwlerEntity animatable, int instanceId, AnimationEvent animationEvent) {
        super.setCustomAnimations(animatable, instanceId, animationEvent);
        IBone head = this.getAnimationProcessor().getBone("head");

        EntityModelData extraData = (EntityModelData) animationEvent.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null) {
            head.setRotationX(extraData.headPitch * Mth.DEG_TO_RAD);
            head.setRotationY(extraData.netHeadYaw * Mth.DEG_TO_RAD);
        }
    }
}
