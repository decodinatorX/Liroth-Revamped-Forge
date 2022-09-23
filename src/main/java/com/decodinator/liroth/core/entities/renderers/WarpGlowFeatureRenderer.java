package com.decodinator.liroth.core.entities.renderers;

import com.decodinator.liroth.core.entities.WarpEntity;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class WarpGlowFeatureRenderer<T extends WarpEntity>
extends EyesLayer<T, WarpModel<T>> {
    private static final RenderType SKIN = RenderType.eyes(new ResourceLocation("liroth", "textures/entity/warp/warp_glow.png"));

    public WarpGlowFeatureRenderer(RenderLayerParent<T, WarpModel<T>> featureRendererContext) {
        super(featureRendererContext);
    }

    @Override
    public RenderType renderType() {
        return SKIN;
    }
}

