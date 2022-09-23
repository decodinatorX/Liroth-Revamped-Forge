package com.decodinator.liroth.core.entities.renderers;

import com.decodinator.liroth.core.entities.ShadeEntity;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ShadeShadedFeatureRenderer<T extends ShadeEntity>
extends EyesLayer<T, ShadeModel<T>> {
    private static final RenderType SKIN = RenderType.entityTranslucent(new ResourceLocation("liroth", "textures/entity/shade/shade_shaded.png"));

    public ShadeShadedFeatureRenderer(RenderLayerParent<T, ShadeModel<T>> featureRendererContext) {
        super(featureRendererContext);
    }

    @Override
    public RenderType renderType() {
        return SKIN;
    }
}

