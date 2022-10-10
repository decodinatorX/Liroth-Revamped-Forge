package com.decodinator.liroth.core.entities.renderers;

import com.decodinator.liroth.core.entities.VileSharkEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class VileSharkModel<T extends VileSharkEntity> extends EntityModel<T> {
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart tail;
	private final ModelPart tail_fin;
	private final ModelPart back_fin;
	private final ModelPart left_fin;
	private final ModelPart right_fin;
	private final ModelPart nose;

	public VileSharkModel(ModelPart root) {
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.tail = root.getChild("tail");
		this.tail_fin = root.getChild("tail_fin");
		this.back_fin = root.getChild("back_fin");
		this.left_fin = root.getChild("left_fin");
		this.right_fin = root.getChild("right_fin");
		this.nose = root.getChild("nose");
	}

	public static LayerDefinition getTexturedModelData() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(26, 28).addBox(-5.0F, -4.0F, -8.0F, 10.0F, 5.0F, 8.0F)
		.texOffs(33, 0).addBox(-5.0F, 2.0F, -6.0F, 10.0F, 1.0F, 6.0F), PartPose.offset(0.0F, 20.0F, -3.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 42).addBox(-6.0F, -5.0F, 0.0F, 12.0F, 9.0F, 13.0F), PartPose.offset(0.0F, 20.0F, -3.0F));

		PartDefinition tail = partdefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 20).addBox(-3.0F, -2.5F, 0.0F, 6.0F, 5.0F, 11.0F), PartPose.offset(0.0F, 20.5F, 10.0F));

		PartDefinition tail_fin = partdefinition.addOrReplaceChild("tail_fin", CubeListBuilder.create().texOffs(23, 20).addBox(-6.0F, -0.5F, -1.0F, 12.0F, 1.0F, 6.0F), PartPose.offset(0.0F, 20.5F, 20.0F));

		PartDefinition back_fin = partdefinition.addOrReplaceChild("back_fin", CubeListBuilder.create(), PartPose.offset(0.0F, 16.0F, 5.0F));

		PartDefinition back_fin_r1 = back_fin.addOrReplaceChild("back_fin_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -12.0F, 3.0F, 1.0F, 5.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 7.0F, -5.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition left_fin = partdefinition.addOrReplaceChild("left_fin", CubeListBuilder.create().texOffs(0, 36).addBox(-8.0F, -1.0F, -1.0F, 8.0F, 1.0F, 4.0F), PartPose.offset(-6.0F, 22.0F, -1.0F));

		PartDefinition right_fin = partdefinition.addOrReplaceChild("right_fin", CubeListBuilder.create().texOffs(33, 7).addBox(0.0F, -1.0F, -1.0F, 8.0F, 1.0F, 4.0F), PartPose.offset(6.0F, 22.0F, -1.0F));

		PartDefinition nose = partdefinition.addOrReplaceChild("nose", CubeListBuilder.create(), PartPose.offset(0.0F, 20.0F, -11.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

    @Override
    public void setupAnim(T p_102475_, float p_102476_, float p_102477_, float p_102478_, float p_102479_, float p_102480_) {
//       this.body.xRot = p_102480_ * ((float)Math.PI / 180F);
//       this.body.yRot = p_102479_ * ((float)Math.PI / 180F);
       if (p_102475_.getDeltaMovement().horizontalDistanceSqr() > 1.0E-7D) {
//          this.body.xRot += -0.05F - 0.05F * Mth.cos(p_102478_ * 0.3F);
           this.tail.xRot = -0.1F * Mth.cos(p_102478_ * 0.3F);
           this.tail_fin.xRot = -0.2F * Mth.cos(p_102478_ * 0.3F);
       }

    }

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, buffer, packedLight, packedOverlay);
		body.render(poseStack, buffer, packedLight, packedOverlay);
		tail.render(poseStack, buffer, packedLight, packedOverlay);
		tail_fin.render(poseStack, buffer, packedLight, packedOverlay);
		back_fin.render(poseStack, buffer, packedLight, packedOverlay);
		left_fin.render(poseStack, buffer, packedLight, packedOverlay);
		right_fin.render(poseStack, buffer, packedLight, packedOverlay);
		nose.render(poseStack, buffer, packedLight, packedOverlay);
	}
}