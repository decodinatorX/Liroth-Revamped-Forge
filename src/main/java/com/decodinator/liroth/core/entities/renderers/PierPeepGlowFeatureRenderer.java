package com.decodinator.liroth.core.entities.renderers;

import com.decodinator.liroth.core.entities.PierPeepEntity;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class PierPeepGlowFeatureRenderer<T extends PierPeepEntity>
extends EyesLayer<T, PierPeepModel<T>> {
    private static final RenderType SKIN = RenderType.eyes(new ResourceLocation("liroth", "textures/entity/pier_peep/pier_peep_glow.png"));

    public PierPeepGlowFeatureRenderer(RenderLayerParent<T, PierPeepModel<T>> featureRendererContext) {
        super(featureRendererContext);
    }

    @Override
    public RenderType renderType() {
        return SKIN;
    }
}

