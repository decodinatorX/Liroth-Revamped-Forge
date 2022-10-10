package com.decodinator.liroth.core.renders;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.LirothForgeClientEventsHandler;
import com.decodinator.liroth.core.LirothBoat;
import com.decodinator.liroth.core.LirothBoatModel;
import com.google.common.collect.ImmutableMap;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.datafixers.util.Pair;
import com.mojang.math.Quaternion;
import com.mojang.math.Vector3f;
import java.util.Map;
import java.util.stream.Stream;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class LirothBoatRenderer extends EntityRenderer<LirothBoat> {
   private final Map<LirothBoat.LirothType, Pair<ResourceLocation, LirothBoatModel>> boatResources;

   public LirothBoatRenderer(EntityRendererProvider.Context p_234563_, boolean p_234564_) {
      super(p_234563_);
      this.shadowRadius = 0.8F;
      this.boatResources = Stream.of(LirothBoat.LirothType.values()).collect(ImmutableMap.toImmutableMap((p_173938_) -> {
         return p_173938_;
      }, (p_234575_) -> {
         return Pair.of(new ResourceLocation(getTextureLocation(p_234575_, p_234564_)), this.createBoatModel(p_234563_, p_234575_, p_234564_));
      }));
   }

   private LirothBoatModel createBoatModel(EntityRendererProvider.Context p_234569_, LirothBoat.LirothType p_234570_, boolean p_234571_) {
      ModelLayerLocation modellayerlocation = p_234571_ ? LirothForgeClientEventsHandler.createChestBoatModelName(p_234570_) : LirothForgeClientEventsHandler.createBoatModelName(p_234570_);
      return new LirothBoatModel(p_234569_.bakeLayer(modellayerlocation), p_234571_);
   }

   private static String getTextureLocation(LirothBoat.LirothType p_234566_, boolean p_234567_) {
      return p_234567_ ? "liroth:textures/entity/chest_boat/" + p_234566_.getName() + ".png" : "liroth:textures/entity/boat/" + p_234566_.getName() + ".png";
   }

   public void render(LirothBoat p_113929_, float p_113930_, float p_113931_, PoseStack p_113932_, MultiBufferSource p_113933_, int p_113934_) {
      p_113932_.pushPose();
      p_113932_.translate(0.0D, 0.375D, 0.0D);
      p_113932_.mulPose(Vector3f.YP.rotationDegrees(180.0F - p_113930_));
      float f = (float)p_113929_.getHurtTime() - p_113931_;
      float f1 = p_113929_.getDamage() - p_113931_;
      if (f1 < 0.0F) {
         f1 = 0.0F;
      }

      if (f > 0.0F) {
         p_113932_.mulPose(Vector3f.XP.rotationDegrees(Mth.sin(f) * f * f1 / 10.0F * (float)p_113929_.getHurtDir()));
      }

      float f2 = p_113929_.getBubbleAngle(p_113931_);
      if (!Mth.equal(f2, 0.0F)) {
         p_113932_.mulPose(new Quaternion(new Vector3f(1.0F, 0.0F, 1.0F), p_113929_.getBubbleAngle(p_113931_), true));
      }

      Pair<ResourceLocation, LirothBoatModel> pair = getModelWithLocation(p_113929_);
      ResourceLocation resourcelocation = pair.getFirst();
      LirothBoatModel boatmodel = pair.getSecond();
      p_113932_.scale(-1.0F, -1.0F, 1.0F);
      p_113932_.mulPose(Vector3f.YP.rotationDegrees(90.0F));
      boatmodel.setupAnim(p_113929_, p_113931_, 0.0F, -0.1F, 0.0F, 0.0F);
      VertexConsumer vertexconsumer = p_113933_.getBuffer(boatmodel.renderType(resourcelocation));
      boatmodel.renderToBuffer(p_113932_, vertexconsumer, p_113934_, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
      if (!p_113929_.isUnderWater()) {
         VertexConsumer vertexconsumer1 = p_113933_.getBuffer(RenderType.waterMask());
         boatmodel.waterPatch().render(p_113932_, vertexconsumer1, p_113934_, OverlayTexture.NO_OVERLAY);
      }

      p_113932_.popPose();
      super.render(p_113929_, p_113930_, p_113931_, p_113932_, p_113933_, p_113934_);
   }

   @Deprecated // forge: override getModelWithLocation to change the texture / model
   public ResourceLocation getTextureLocation(LirothBoat p_113927_) {
      return getModelWithLocation(p_113927_).getFirst();
   }

   public Pair<ResourceLocation, LirothBoatModel> getModelWithLocation(LirothBoat p_113929_) { return this.boatResources.get(p_113929_.getLirothBoatType()); }
}