package com.decodinator.liroth.core.entities.renderers;

import com.decodinator.liroth.core.entities.SoulArachnidEntity;
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
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SoulArachnidModel<T extends SoulArachnidEntity> extends HierarchicalModel<T> {
    private final ModelPart root;
	private final ModelPart head;
	private final ModelPart body0;
	private final ModelPart body1;
	private final ModelPart leg0;
	private final ModelPart leg1;
	private final ModelPart leg2;
	private final ModelPart leg3;
	private final ModelPart leg4;
	private final ModelPart leg5;
	private final ModelPart leg6;
	private final ModelPart leg7;

	public SoulArachnidModel(ModelPart root) {
		this.root = root;
		this.head = root.getChild("head");
		this.body0 = root.getChild("body0");
		this.body1 = root.getChild("body1");
		this.leg0 = root.getChild("leg0");
		this.leg1 = root.getChild("leg1");
		this.leg2 = root.getChild("leg2");
		this.leg3 = root.getChild("leg3");
		this.leg4 = root.getChild("leg4");
		this.leg5 = root.getChild("leg5");
		this.leg6 = root.getChild("leg6");
		this.leg7 = root.getChild("leg7");
	}

	public static LayerDefinition getTexturedModelData() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition MeshDefinition = meshdefinition.getRoot();

		PartDefinition head = MeshDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 20).addBox(-4.0F, -4.0F, -8.0F, 8.0F, 8.0F, 8.0F), PartPose.offset(0.0F, 15.0F, -3.0F));

		PartDefinition body0 = MeshDefinition.addOrReplaceChild("body0", CubeListBuilder.create().texOffs(30, 36).addBox(-3.0F, -3.0F, -3.5F, 6.0F, 6.0F, 6.0F), PartPose.offset(0.0F, 15.0F, 1.0F));

		PartDefinition body1 = MeshDefinition.addOrReplaceChild("body1", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -4.0F, 0.0F, 10.0F, 8.0F, 12.0F)
		.texOffs(0, 24).addBox(-1.0F, -6.0F, 11.0F, 2.0F, 2.0F, 2.0F)
		.texOffs(0, 8).addBox(1.0F, -6.0F, 11.0F, 2.0F, 2.0F, 2.0F)
		.texOffs(0, 4).addBox(-3.0F, -6.0F, 11.0F, 2.0F, 2.0F, 2.0F)
		.texOffs(0, 40).addBox(-2.5F, -8.0F, 12.0F, 5.0F, 2.0F, 2.0F)
		.texOffs(0, 0).addBox(-1.5F, -10.0F, 13.0F, 3.0F, 2.0F, 2.0F)
		.texOffs(0, 20).addBox(-1.0F, -12.0F, 12.0F, 2.0F, 2.0F, 2.0F)
		.texOffs(6, 6).addBox(-0.5F, -13.0F, 10.0F, 1.0F, 2.0F, 2.0F)
		.texOffs(6, 2).addBox(0.0F, -12.0F, 8.0F, 0.0F, 2.0F, 2.0F), PartPose.offset(0.0F, 15.0F, -3.0F));

		PartDefinition leg0 = MeshDefinition.addOrReplaceChild("leg0", CubeListBuilder.create().texOffs(0, 36).addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F), PartPose.offset(4.0F, 15.0F, 2.0F));

		PartDefinition leg1 = MeshDefinition.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(0, 36).mirror().addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F).mirror(false), PartPose.offset(-4.0F, 15.0F, 2.0F));

		PartDefinition leg2 = MeshDefinition.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(0, 36).addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F), PartPose.offset(4.0F, 15.0F, 1.0F));

		PartDefinition leg3 = MeshDefinition.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(0, 36).mirror().addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F).mirror(false), PartPose.offset(-4.0F, 15.0F, 1.0F));

		PartDefinition leg4 = MeshDefinition.addOrReplaceChild("leg4", CubeListBuilder.create().texOffs(0, 36).addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F), PartPose.offset(4.0F, 15.0F, 0.0F));

		PartDefinition leg5 = MeshDefinition.addOrReplaceChild("leg5", CubeListBuilder.create().texOffs(0, 36).mirror().addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F).mirror(false), PartPose.offset(-4.0F, 15.0F, 0.0F));

		PartDefinition leg6 = MeshDefinition.addOrReplaceChild("leg6", CubeListBuilder.create().texOffs(0, 36).addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F), PartPose.offset(4.0F, 15.0F, -1.0F));

		PartDefinition leg7 = MeshDefinition.addOrReplaceChild("leg7", CubeListBuilder.create().texOffs(0, 36).mirror().addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F).mirror(false), PartPose.offset(-4.0F, 15.0F, -1.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

    @Override
    public void setupAnim(T entity, float limbAngle, float limbDistance, float animationProgress, float headyRot, float headPitch) {
        this.head.yRot = headyRot * ((float)Math.PI / 180);
        this.head.xRot = headPitch * ((float)Math.PI / 180);
        float f = 0.7853982f;
        this.leg1.zRot = -0.7853982f;
        this.leg0.zRot = 0.7853982f;
        this.leg3.zRot = -0.58119464f;
        this.leg2.zRot = 0.58119464f;
        this.leg5.zRot = -0.58119464f;
        this.leg4.zRot = 0.58119464f;
        this.leg7.zRot = -0.7853982f;
        this.leg6.zRot = 0.7853982f;
        float g = -0.0f;
        float h = 0.3926991f;
        this.leg1.yRot = 0.7853982f;
        this.leg0.yRot = -0.7853982f;
        this.leg3.yRot = 0.3926991f;
        this.leg2.yRot = -0.3926991f;
        this.leg5.yRot = -0.3926991f;
        this.leg4.yRot = 0.3926991f;
        this.leg7.yRot = -0.7853982f;
        this.leg6.yRot = 0.7853982f;
        float i = -(Mth.cos(limbAngle * 0.6662f * 2.0f + 0.0f) * 0.4f) * limbDistance;
        float j = -(Mth.cos(limbAngle * 0.6662f * 2.0f + (float)Math.PI) * 0.4f) * limbDistance;
        float k = -(Mth.cos(limbAngle * 0.6662f * 2.0f + 1.5707964f) * 0.4f) * limbDistance;
        float l = -(Mth.cos(limbAngle * 0.6662f * 2.0f + 4.712389f) * 0.4f) * limbDistance;
        float m = Math.abs(Mth.sin(limbAngle * 0.6662f + 0.0f) * 0.4f) * limbDistance;
        float n = Math.abs(Mth.sin(limbAngle * 0.6662f + (float)Math.PI) * 0.4f) * limbDistance;
        float o = Math.abs(Mth.sin(limbAngle * 0.6662f + 1.5707964f) * 0.4f) * limbDistance;
        float p = Math.abs(Mth.sin(limbAngle * 0.6662f + 4.712389f) * 0.4f) * limbDistance;
        this.leg1.yRot += i;
        this.leg0.yRot += -i;
        this.leg3.yRot += j;
        this.leg2.yRot += -j;
        this.leg5.yRot += k;
        this.leg4.yRot += -k;
        this.leg7.yRot += l;
        this.leg6.yRot += -l;
        this.leg1.zRot += m;
        this.leg0.zRot += -m;
        this.leg3.zRot += n;
        this.leg2.zRot += -n;
        this.leg5.zRot += o;
        this.leg4.zRot += -o;
        this.leg7.zRot += p;
        this.leg6.zRot += -p;
    }

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, buffer, packedLight, packedOverlay);
		body0.render(poseStack, buffer, packedLight, packedOverlay);
		body1.render(poseStack, buffer, packedLight, packedOverlay);
		leg0.render(poseStack, buffer, packedLight, packedOverlay);
		leg1.render(poseStack, buffer, packedLight, packedOverlay);
		leg2.render(poseStack, buffer, packedLight, packedOverlay);
		leg3.render(poseStack, buffer, packedLight, packedOverlay);
		leg4.render(poseStack, buffer, packedLight, packedOverlay);
		leg5.render(poseStack, buffer, packedLight, packedOverlay);
		leg6.render(poseStack, buffer, packedLight, packedOverlay);
		leg7.render(poseStack, buffer, packedLight, packedOverlay);
	}

    @Override
    public ModelPart root() {
        return this.root;
    }
}