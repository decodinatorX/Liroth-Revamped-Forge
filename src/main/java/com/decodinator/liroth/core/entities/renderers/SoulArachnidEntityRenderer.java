package com.decodinator.liroth.core.entities.renderers;

import com.decodinator.liroth.core.entities.SoulArachnidEntity;
import com.decodinator.liroth.core.entities.renderers.SoulArachnidModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SoulArachnidEntityRenderer extends GeoEntityRenderer<SoulArachnidEntity> {
    public SoulArachnidEntityRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SoulArachnidModel<SoulArachnidEntity>());
        this.addRenderLayer(new SoulArachnidGlowFeatureRenderer(this));
    }
}