package com.decodinator.liroth.core.entities.renderers;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.LirothModelLayers;
import com.decodinator.liroth.core.entities.ForsakenCorpseEntity;

import net.minecraft.client.renderer.entity.AbstractZombieRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ForsakenCorpseEntityRenderer extends HumanoidMobRenderer<ForsakenCorpseEntity, ForsakenCorpseModel<ForsakenCorpseEntity>> {

    public ForsakenCorpseEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new ForsakenCorpseModel(context.bakeLayer(LirothModelLayers.FORSAKEN_CORPSE)), 0.5f);
        this.addLayer(new ForsakenCorpseFaceFeatureRenderer<ForsakenCorpseEntity>(this));
    }
 
    @Override
    public ResourceLocation getTextureLocation(ForsakenCorpseEntity entity) {
        return new ResourceLocation("liroth", "textures/entity/forsaken_corpse/forsaken_corpse.png");
        
    }
}
