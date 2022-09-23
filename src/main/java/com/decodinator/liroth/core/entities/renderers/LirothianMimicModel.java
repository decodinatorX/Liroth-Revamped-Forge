package com.decodinator.liroth.core.entities.renderers;

import com.decodinator.liroth.core.entities.LirothianMimicEntity;
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

public class LirothianMimicModel<T extends LirothianMimicEntity> extends HierarchicalModel<T> {
    private final ModelPart root;
	private final ModelPart base;
	private final ModelPart lid;
//	private final ModelPart knob;
	private final ModelPart leg7;
	private final ModelPart leg6;
	private final ModelPart leg5;
	private final ModelPart leg4;
	private final ModelPart leg3;
	private final ModelPart leg2;
	private final ModelPart leg1;
	private final ModelPart leg0;
	private final ModelPart head;

	public LirothianMimicModel(ModelPart root) {
		this.root = root;
		this.base = root.getChild("base");
		this.lid = root.getChild("lid");
//		this.knob = root.getChild("knob");
		this.leg7 = root.getChild("leg7");
		this.leg6 = root.getChild("leg6");
		this.leg5 = root.getChild("leg5");
		this.leg4 = root.getChild("leg4");
		this.leg3 = root.getChild("leg3");
		this.leg2 = root.getChild("leg2");
		this.leg1 = root.getChild("leg1");
		this.leg0 = root.getChild("leg0");
		this.head = root.getChild("head");
	}

	public static LayerDefinition getTexturedModelData() {
		MeshDefinition MeshDefinition = new MeshDefinition();
		PartDefinition PartDefinition = MeshDefinition.getRoot();

		PartDefinition head = PartDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(74, 0).addBox(-4.0F, -8.0F, -3.0F, 8.0F, 5.0F, 6.0F), PartPose.offset(0.0F, 11.0F, 0.0F));

		PartDefinition leg0 = PartDefinition.addOrReplaceChild("leg0", CubeListBuilder.create().texOffs(74, 11).mirror().addBox(11.0F, 1.0F, -1.0F, 16.0F, 2.0F, 2.0F).mirror(false), PartPose.offset(4.0F, 11.0F, 2.0F));

		PartDefinition leg1 = PartDefinition.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(74, 11).mirror().addBox(-27.0F, 1.0F, -1.0F, 16.0F, 2.0F, 2.0F).mirror(false), PartPose.offset(-4.0F, 11.0F, 2.0F));

		PartDefinition leg2 = PartDefinition.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(74, 11).mirror().addBox(11.0F, 1.0F, -1.0F, 16.0F, 2.0F, 2.0F).mirror(false), PartPose.offset(4.0F, 11.0F, 1.0F));

		PartDefinition leg3 = PartDefinition.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(74, 11).mirror().addBox(-27.0F, 1.0F, -1.0F, 16.0F, 2.0F, 2.0F).mirror(false), PartPose.offset(-4.0F, 11.0F, 1.0F));

		PartDefinition leg4 = PartDefinition.addOrReplaceChild("leg4", CubeListBuilder.create().texOffs(74, 11).mirror().addBox(11.0F, 1.0F, -1.0F, 16.0F, 2.0F, 2.0F).mirror(false), PartPose.offset(4.0F, 11.0F, 0.0F));

		PartDefinition leg5 = PartDefinition.addOrReplaceChild("leg5", CubeListBuilder.create().texOffs(74, 12).mirror().addBox(-27.0F, 1.0F, -1.0F, 16.0F, 2.0F, 2.0F).mirror(false), PartPose.offset(-4.0F, 11.0F, 0.0F));

		PartDefinition leg6 = PartDefinition.addOrReplaceChild("leg6", CubeListBuilder.create().texOffs(74, 11).mirror().addBox(11.0F, 1.0F, -1.0F, 16.0F, 2.0F, 2.0F).mirror(false), PartPose.offset(4.0F, 11.0F, -1.0F));

		PartDefinition leg7 = PartDefinition.addOrReplaceChild("leg7", CubeListBuilder.create().texOffs(74, 11).mirror().addBox(-27.0F, 1.0F, -1.0F, 16.0F, 2.0F, 2.0F).mirror(false), PartPose.offset(-4.0F, 11.0F, -1.0F));

//		PartDefinition knob = leg7.addOrReplaceChild("knob", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -1.0F, 15.0F, 1.0F, 4.0F, 1.0F)
//		.texOffs(0, 0).addBox(-1.0F, -1.0F, 15.0F, 1.0F, 4.0F, 1.0F), PartPose.offsetandrotation(4.0F, -1.0F, 7.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition lid = PartDefinition.addOrReplaceChild("lid", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 15.0F, 5.0F, 14.0F).mirror(false)
		.texOffs(0, 0).addBox(-15.0F, 0.0F, 0.0F, 15.0F, 5.0F, 14.0F)
		.texOffs(0, 62).addBox(-15.0F, -2.0F, 14.0F, 30.0F, 2.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 9.0F, 7.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition teeth_left_r1 = lid.addOrReplaceChild("teeth_left_r1", CubeListBuilder.create().texOffs(2, 50).mirror().addBox(-15.0F, 10.0F, 2.0F, 0.0F, 1.0F, 13.0F).mirror(false)
		.texOffs(2, 50).mirror().addBox(15.0F, 10.0F, 2.0F, 0.0F, 1.0F, 13.0F).mirror(false), PartPose.offsetAndRotation(0.0F, 10.0F, -1.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition base = PartDefinition.addOrReplaceChild("base", CubeListBuilder.create().texOffs(0, 19).mirror().addBox(0.0F, 0.0F, 1.0F, 15.0F, 10.0F, 14.0F).mirror(false)
		.texOffs(0, 19).addBox(-15.0F, 0.0F, 1.0F, 15.0F, 10.0F, 14.0F)
		.texOffs(1, 49).mirror().addBox(-15.0F, 10.0F, 1.0F, 0.0F, 1.0F, 14.0F).mirror(false)
		.texOffs(1, 49).mirror().addBox(15.0F, 10.0F, 1.0F, 0.0F, 1.0F, 14.0F).mirror(false), PartPose.offsetAndRotation(0.0F, 18.0F, 8.0F, 3.1416F, 0.0F, 0.0F));

		PartDefinition teeth_front_r1 = base.addOrReplaceChild("teeth_front_r1", CubeListBuilder.create().texOffs(0, 62).addBox(-15.0F, -12.0F, 15.0F, 30.0F, 2.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

		return LayerDefinition.create(MeshDefinition, 128, 64);
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
		base.render(poseStack, buffer, packedLight, packedOverlay);
		lid.render(poseStack, buffer, packedLight, packedOverlay);
//		knob.render(poseStack, buffer, packedLight, packedOverlay);
		leg7.render(poseStack, buffer, packedLight, packedOverlay);
		leg6.render(poseStack, buffer, packedLight, packedOverlay);
		leg5.render(poseStack, buffer, packedLight, packedOverlay);
		leg4.render(poseStack, buffer, packedLight, packedOverlay);
		leg3.render(poseStack, buffer, packedLight, packedOverlay);
		leg2.render(poseStack, buffer, packedLight, packedOverlay);
		leg1.render(poseStack, buffer, packedLight, packedOverlay);
		leg0.render(poseStack, buffer, packedLight, packedOverlay);
		head.render(poseStack, buffer, packedLight, packedOverlay);
	}
	
    @Override
    public ModelPart root() {
        return this.root;
    }
}