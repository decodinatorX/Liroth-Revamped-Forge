package com.decodinator.liroth.core.entities.renderers;

import com.decodinator.liroth.core.entities.FungalFiendEntity;
import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;

public class FungalFiendModel<T extends FungalFiendEntity>
extends HierarchicalModel<T> {
    private final ModelPart root;
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart leg0;
	private final ModelPart leg1;
	private final ModelPart leg2;
	private final ModelPart leg3;
    private static final int HEAD_AND_BODY_Y_PIVOT = 6;

	public FungalFiendModel(ModelPart root) {
        this.root = root;
		this.body = root.getChild("body");
		this.head = root.getChild("head");
		this.leg0 = root.getChild("leg0");
		this.leg1 = root.getChild("leg1");
		this.leg2 = root.getChild("leg2");
		this.leg3 = root.getChild("leg3");
	}

	public static LayerDefinition getTexturedModelData() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 16).mirror().addBox(-4.0F, -18.0F, -2.0F, 8.0F, 12.0F, 4.0F).mirror(false)
		.texOffs(16, 16).mirror().addBox(-3.0F, -22.0F, -2.0F, 6.0F, 4.0F, 4.0F).mirror(false)
		.texOffs(50, 27).addBox(-4.0F, -17.0F, 0.0F, -5.0F, 5.0F, 0.0F)
		.texOffs(40, 27).addBox(3.0F, -23.0F, 0.0F, 5.0F, 5.0F, 0.0F), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -12.0F, -4.0F, 8.0F, 8.0F, 8.0F).mirror(false), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition leg0 = partdefinition.addOrReplaceChild("leg0", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F).mirror(false), PartPose.offset(3.0F, 18.0F, 4.0F));

		PartDefinition leg1 = partdefinition.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F).mirror(false), PartPose.offset(-3.0F, 18.0F, 4.0F));

		PartDefinition leg2 = partdefinition.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F).mirror(false), PartPose.offset(3.0F, 18.0F, -4.0F));

		PartDefinition leg3 = partdefinition.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F).mirror(false), PartPose.offset(-3.0F, 18.0F, -4.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, buffer, packedLight, packedOverlay);
		head.render(poseStack, buffer, packedLight, packedOverlay);
		leg0.render(poseStack, buffer, packedLight, packedOverlay);
		leg1.render(poseStack, buffer, packedLight, packedOverlay);
		leg2.render(poseStack, buffer, packedLight, packedOverlay);
		leg3.render(poseStack, buffer, packedLight, packedOverlay);
	}
		@Override
	   public ModelPart root() {
		      return this.root;
		   }

		@Override
		   public void setupAnim(T p_102463_, float p_102464_, float p_102465_, float p_102466_, float p_102467_, float p_102468_) {
		      this.head.yRot = p_102467_ * ((float)Math.PI / 180F);
		      this.head.xRot = p_102468_ * ((float)Math.PI / 180F);
		      this.leg0.xRot = Mth.cos(p_102464_ * 0.6662F) * 1.4F * p_102465_;
		      this.leg1.xRot = Mth.cos(p_102464_ * 0.6662F + (float)Math.PI) * 1.4F * p_102465_;
		      this.leg2.xRot = Mth.cos(p_102464_ * 0.6662F + (float)Math.PI) * 1.4F * p_102465_;
		      this.leg3.xRot = Mth.cos(p_102464_ * 0.6662F) * 1.4F * p_102465_;
		   }
}