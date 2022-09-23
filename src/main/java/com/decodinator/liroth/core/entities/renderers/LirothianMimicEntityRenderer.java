package com.decodinator.liroth.core.entities.renderers;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.LirothModelLayers;
import com.decodinator.liroth.core.entities.LirothianMimicEntity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class LirothianMimicEntityRenderer extends MobRenderer<LirothianMimicEntity, LirothianMimicModel<LirothianMimicEntity>> {

    public LirothianMimicEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new LirothianMimicModel(context.bakeLayer(LirothModelLayers.LIROTHIAN_MIMIC)), 0.5f);
    }
 
    @Override
    public ResourceLocation getTextureLocation(LirothianMimicEntity entity) {
        return new ResourceLocation("liroth", "textures/entity/lirothian_mimic/lirothian_mimic.png");
        
    }
}
