package com.decodinator.liroth.core.entities.renderers;

import com.decodinator.liroth.Liroth;

import com.decodinator.liroth.core.entities.SkeletalFreakEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.texture.OverlayTexture;
import software.bernie.geckolib3.geo.render.built.GeoModel;
import software.bernie.geckolib3.renderers.geo.GeoLayerRenderer;
import software.bernie.geckolib3.renderers.geo.IGeoRenderer;


public class SkeletalFreakGlowLayer extends GeoLayerRenderer<SkeletalFreakEntity> {
    private static final ResourceLocation SKIN = new ResourceLocation(Liroth.MOD_ID + ":textures/entity/skeletal_freak/skeletal_freak_face.png");
    private static final ResourceLocation MODEL = new ResourceLocation(Liroth.MOD_ID + ":geo/skeletal_freak/skeletal.geo.json");

    public SkeletalFreakGlowLayer(IGeoRenderer<SkeletalFreakEntity> featureRendererContext) {
        super(featureRendererContext);
    }

    @Override
    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, SkeletalFreakEntity entityLivingBaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        GeoModel normalModel = this.getEntityModel().getModel(this.getEntityModel().getModelResource(null));
        VertexConsumer glower = bufferIn.getBuffer((RenderType.eyes(SKIN)));
        if (entityLivingBaseIn.isInvisible()) {
            return;
        }
        this.getRenderer().render(normalModel, entityLivingBaseIn, partialTicks, null, matrixStackIn, null,
                glower, packedLightIn, OverlayTexture.NO_OVERLAY, 1f, 1f, 1f, 1f);
    }


}
