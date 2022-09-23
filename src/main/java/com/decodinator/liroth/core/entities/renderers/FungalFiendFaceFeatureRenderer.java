package com.decodinator.liroth.core.entities.renderers;

import com.decodinator.liroth.core.entities.FungalFiendEntity;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class FungalFiendFaceFeatureRenderer<T extends FungalFiendEntity>
extends EyesLayer<T, FungalFiendModel<T>> {
    private static final RenderType SKIN = RenderType.eyes(new ResourceLocation("liroth", "textures/entity/fungal_fiend/fungal_fiend_face.png"));

    public FungalFiendFaceFeatureRenderer(RenderLayerParent<T, FungalFiendModel<T>> featureRendererContext) {
        super(featureRendererContext);
    }

    @Override
    public RenderType renderType() {
        return SKIN;
    }
}

