package com.decodinator.liroth.core.entities.renderers;

import com.decodinator.liroth.core.entities.FreakshowEntity;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class FreakshowTranslucentFeatureRenderer<T extends FreakshowEntity>
extends EyesLayer<T, FreakshowModel<T>> {
    private static final RenderType SKIN = RenderType.entityTranslucent(new ResourceLocation("liroth", "textures/entity/freakshow/freakshow.png"));

    public FreakshowTranslucentFeatureRenderer(RenderLayerParent<T, FreakshowModel<T>> featureRendererContext) {
        super(featureRendererContext);
    }

    @Override
    public RenderType renderType() {
        return SKIN;
    }
}

