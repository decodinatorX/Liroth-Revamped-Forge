package com.decodinator.liroth.core.entities.renderers;

import com.decodinator.liroth.core.entities.SoulArachnidEntity;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SoulArachnidGlowFeatureRenderer<T extends SoulArachnidEntity>
extends EyesLayer<T, SoulArachnidModel<T>> {
    private static final RenderType SKIN = RenderType.eyes(new ResourceLocation("liroth", "textures/entity/soul_arachnid/soul_arachnid_glow.png"));

    public SoulArachnidGlowFeatureRenderer(RenderLayerParent<T, SoulArachnidModel<T>> featureRendererContext) {
        super(featureRendererContext);
    }

    @Override
    public RenderType renderType() {
        return SKIN;
    }
}

