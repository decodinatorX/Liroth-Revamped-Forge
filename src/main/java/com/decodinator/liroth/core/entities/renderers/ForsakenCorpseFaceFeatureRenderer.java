package com.decodinator.liroth.core.entities.renderers;

import com.decodinator.liroth.core.entities.ForsakenCorpseEntity;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ForsakenCorpseFaceFeatureRenderer<T extends ForsakenCorpseEntity>
extends EyesLayer<T, ForsakenCorpseModel<T>> {
    private static final RenderType SKIN = RenderType.eyes(new ResourceLocation("liroth", "textures/entity/forsaken_corpse/forsaken_corpse_face.png"));

    public ForsakenCorpseFaceFeatureRenderer(RenderLayerParent<T, ForsakenCorpseModel<T>> featureRendererContext) {
        super(featureRendererContext);
    }

    @Override
    public RenderType renderType() {
        return SKIN;
    }
}

