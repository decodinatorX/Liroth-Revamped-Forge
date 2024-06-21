package com.decodinator.liroth.core.entities.renderers;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.entities.WarpEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class WarpModel<T extends WarpEntity> extends DefaultedEntityGeoModel<WarpEntity> {
    public WarpModel() {
        super(new ResourceLocation(Liroth.MOD_ID, "warp/warp"));
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
    public void setCustomAnimations(WarpEntity animatable, long instanceId, AnimationState<WarpEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}
