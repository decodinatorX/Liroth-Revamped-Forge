package com.decodinator.liroth.core.entities.renderers;

import com.decodinator.liroth.Liroth;

import com.decodinator.liroth.core.entities.ForsakenCorpseEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class ForsakenCorpseModel<T extends ForsakenCorpseEntity> extends DefaultedEntityGeoModel<ForsakenCorpseEntity> {
    public ForsakenCorpseModel() {
        super(new ResourceLocation(Liroth.MOD_ID, "forsaken_corpse/corpse"));
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
    public void setCustomAnimations(ForsakenCorpseEntity animatable, long instanceId, AnimationState<ForsakenCorpseEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}
