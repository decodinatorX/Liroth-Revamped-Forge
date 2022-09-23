package com.decodinator.liroth.core.entities.renderers;

import com.decodinator.liroth.core.entities.SkeletalFreakEntity;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SkeletalFreakFaceFeatureRenderer<T extends SkeletalFreakEntity>
extends EyesLayer<T, SkeletalFreakModel<T>> {
    private static final RenderType SKIN = RenderType.eyes(new ResourceLocation("liroth", "textures/entity/skeletal_freak/skeletal_freak_face.png"));

    public SkeletalFreakFaceFeatureRenderer(RenderLayerParent<T, SkeletalFreakModel<T>> featureRendererContext) {
        super(featureRendererContext);
    }

    @Override
    public RenderType renderType() {
        return SKIN;
    }
}

