package com.decodinator.liroth.core.entities.renderers;


import com.decodinator.liroth.core.entities.SkeletalFreakEntity;
import com.decodinator.liroth.core.entities.renderers.SkeletalFreakGlowLayer;
import com.decodinator.liroth.core.entities.renderers.SkeletalFreakModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class SkeletalFreakRenderer extends GeoEntityRenderer<SkeletalFreakEntity> {
    public SkeletalFreakRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SkeletalFreakModel<SkeletalFreakEntity>());
        addLayer(new SkeletalFreakGlowLayer(this));
    }
}
