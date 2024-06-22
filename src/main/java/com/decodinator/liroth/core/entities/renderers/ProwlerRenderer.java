package com.decodinator.liroth.core.entities.renderers;


import com.decodinator.liroth.core.entities.ProwlerEntity;
import com.decodinator.liroth.core.entities.renderers.ProwlerModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class ProwlerRenderer extends GeoEntityRenderer<ProwlerEntity> {
    public ProwlerRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ProwlerModel<ProwlerEntity>());
        addLayer(new ProwlerGlowLayer(this));
    }
}
