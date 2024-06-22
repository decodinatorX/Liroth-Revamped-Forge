package com.decodinator.liroth.core.entities.renderers;

import com.decodinator.liroth.Liroth;

import com.decodinator.liroth.core.entities.FungalFiendEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.geo.render.built.GeoModel;
import software.bernie.geckolib3.renderers.geo.GeoLayerRenderer;
import software.bernie.geckolib3.renderers.geo.IGeoRenderer;

public class FungalFiendGlowLayer extends GeoLayerRenderer<FungalFiendEntity> {
    private static final ResourceLocation SKIN = new ResourceLocation(Liroth.MOD_ID + ":textures/entity/fungal_fiend/fungal_fiend_face.png");
    private static final ResourceLocation MODEL = new ResourceLocation(Liroth.MOD_ID + ":geo/fungal_fiend/fungal.geo.json");

    public FungalFiendGlowLayer(IGeoRenderer<FungalFiendEntity> featureRendererContext) {
        super(featureRendererContext);
    }

    @Override
    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, FungalFiendEntity entityLivingBaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        GeoModel normalModel = this.getEntityModel().getModel(this.getEntityModel().getModelResource(null));
        VertexConsumer glower = bufferIn.getBuffer((RenderType.eyes(SKIN)));
        if (entityLivingBaseIn.isInvisible()) {
            return;
        }
        this.getRenderer().render(normalModel, entityLivingBaseIn, partialTicks, null, matrixStackIn, null,
                glower, packedLightIn, OverlayTexture.NO_OVERLAY, 1f, 1f, 1f, 1f);
    }

}
