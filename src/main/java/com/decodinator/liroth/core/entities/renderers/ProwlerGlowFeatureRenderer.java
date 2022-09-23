package com.decodinator.liroth.core.entities.renderers;

import com.decodinator.liroth.core.entities.ProwlerEntity;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ProwlerGlowFeatureRenderer<T extends ProwlerEntity>
extends EyesLayer<T, ProwlerModel<T>> {
    private static final RenderType SKIN = RenderType.eyes(new ResourceLocation("liroth", "textures/entity/prowler/prowler_glow.png"));

    public ProwlerGlowFeatureRenderer(RenderLayerParent<T, ProwlerModel<T>> featureRendererContext) {
        super(featureRendererContext);
    }

    @Override
    public RenderType renderType() {
        return SKIN;
    }
}

