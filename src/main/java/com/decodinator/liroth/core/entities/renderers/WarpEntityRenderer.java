package com.decodinator.liroth.core.entities.renderers;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.LirothModelLayers;
import com.decodinator.liroth.core.entities.WarpEntity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class WarpEntityRenderer extends MobRenderer<WarpEntity, WarpModel<WarpEntity>> {

    public WarpEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new WarpModel(context.bakeLayer(LirothModelLayers.WARP)), 0.5f);
        this.addLayer(new WarpGlowFeatureRenderer<WarpEntity>(this));
    }
 
    @Override
    public ResourceLocation getTextureLocation(WarpEntity entity) {
        return new ResourceLocation("liroth", "textures/entity/warp/warp.png");
        
    }
}
