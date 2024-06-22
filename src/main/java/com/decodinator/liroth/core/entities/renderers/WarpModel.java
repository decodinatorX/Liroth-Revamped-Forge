package com.decodinator.liroth.core.entities.renderers;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.entities.WarpEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class WarpModel<T extends WarpEntity> extends AnimatedGeoModel<WarpEntity> {
    public WarpModel() {
        super();
    }

    @Override
    public ResourceLocation getModelResource(WarpEntity object) {
        return new ResourceLocation(Liroth.MOD_ID, "geo/warp/warp.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(WarpEntity object) {
        return new ResourceLocation(Liroth.MOD_ID, "textures/entity/warp/warp.png");
    }

    @Override
    public ResourceLocation getAnimationResource(WarpEntity animatable) {
        return new ResourceLocation(Liroth.MOD_ID, "animations/warp/warp.animation.json");
    }

    @Override
    public void setCustomAnimations(WarpEntity animatable, int instanceId, AnimationEvent animationEvent) {
        super.setCustomAnimations(animatable, instanceId, animationEvent);
        IBone head = this.getAnimationProcessor().getBone("head");

        EntityModelData extraData = (EntityModelData) animationEvent.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null) {
            head.setRotationX(extraData.headPitch * Mth.DEG_TO_RAD);
            head.setRotationY(extraData.netHeadYaw * Mth.DEG_TO_RAD);
        }
    }
}
