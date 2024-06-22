package com.decodinator.liroth.core.entities.renderers;


import com.decodinator.liroth.core.entities.WarpEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class WarpRenderer extends GeoEntityRenderer<WarpEntity> {
    public WarpRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new WarpModel<WarpEntity>());
        addLayer(new WarpGlowLayer(this));
    }
}
