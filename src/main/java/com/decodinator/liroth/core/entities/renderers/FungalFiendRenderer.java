package com.decodinator.liroth.core.entities.renderers;

import com.decodinator.liroth.core.entities.FungalFiendEntity;
import com.decodinator.liroth.core.entities.renderers.FungalFiendModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class FungalFiendRenderer extends GeoEntityRenderer<FungalFiendEntity> {
    public FungalFiendRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new FungalFiendModel<FungalFiendEntity>());
        addLayer(new FungalFiendGlowLayer(this));
    }
}
