package com.decodinator.liroth.core.entities.renderers;

import com.decodinator.liroth.Liroth;

import com.decodinator.liroth.core.entities.ForsakenCorpseEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoLayerRenderer;
import software.bernie.geckolib3.renderers.geo.IGeoRenderer;
import software.bernie.geckolib3.geo.render.built.GeoModel;

public class ForsakenCorpseGlowLayer extends GeoLayerRenderer<ForsakenCorpseEntity> {
    private static final ResourceLocation SKIN = new ResourceLocation(Liroth.MOD_ID + ":textures/entity/forsaken_corpse/forsaken_corpse_face.png");

    public ForsakenCorpseGlowLayer(IGeoRenderer<ForsakenCorpseEntity> featureRendererContext) {
        super(featureRendererContext);
    }

    @Override
    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, ForsakenCorpseEntity entityLivingBaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        GeoModel normalModel = this.getEntityModel().getModel(this.getEntityModel().getModelResource(null));
        VertexConsumer glower = bufferIn.getBuffer((RenderType.eyes(SKIN)));
        if (entityLivingBaseIn.isInvisible()) {
            return;
        }
        this.getRenderer().render(normalModel, entityLivingBaseIn, partialTicks, null, matrixStackIn, null,
                glower, packedLightIn, OverlayTexture.NO_OVERLAY, 1f, 1f, 1f, 1f);
    }
}
