package com.decodinator.liroth.core.entities.renderers;

import com.decodinator.liroth.Liroth;

import com.decodinator.liroth.core.entities.ForsakenCorpseEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.example.entity.GeoExampleEntity;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.AnimatedTickingGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class ForsakenCorpseModel<T extends ForsakenCorpseEntity> extends AnimatedGeoModel<ForsakenCorpseEntity> {
    public ForsakenCorpseModel() {
        super();
    }

    @Override
    public ResourceLocation getModelResource(ForsakenCorpseEntity object) {
        return new ResourceLocation(Liroth.MOD_ID, "geo/forsaken_corpse/corpse.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ForsakenCorpseEntity object) {
        return new ResourceLocation(Liroth.MOD_ID, "textures/entity/forsaken_corpse/forsaken_corpse.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ForsakenCorpseEntity animatable) {
        return new ResourceLocation(Liroth.MOD_ID, "animations/forsaken_corpse/forsaken.animation.json");
    }

    @Override
    public void setCustomAnimations(ForsakenCorpseEntity animatable, int instanceId, AnimationEvent animationEvent) {
        super.setCustomAnimations(animatable, instanceId, animationEvent);
        IBone head = this.getAnimationProcessor().getBone("head");

        EntityModelData extraData = (EntityModelData) animationEvent.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null) {
            head.setRotationX(extraData.headPitch * Mth.DEG_TO_RAD);
            head.setRotationY(extraData.netHeadYaw * Mth.DEG_TO_RAD);
        }
    }
}
