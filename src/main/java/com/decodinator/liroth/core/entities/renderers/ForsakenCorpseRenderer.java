package com.decodinator.liroth.core.entities.renderers;


import com.decodinator.liroth.core.entities.ForsakenCorpseEntity;
import com.decodinator.liroth.core.entities.renderers.ForsakenCorpseModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class ForsakenCorpseRenderer extends GeoEntityRenderer<ForsakenCorpseEntity> {
    public ForsakenCorpseRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ForsakenCorpseModel<ForsakenCorpseEntity>());
        this.addRenderLayer(new ForsakenCorpseGlowLayer(this));
    }
}
