package com.decodinator.liroth.core.entities.renderers;

import com.decodinator.liroth.core.entities.SkeletalFreakEntity;
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
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SkeletalFreakModel<T extends SkeletalFreakEntity> extends EntityModel<T> {
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart rightArm;
	private final ModelPart leftArm;
	private final ModelPart rightLeg;
	private final ModelPart leftLeg;
    public float pissnshit;


	public SkeletalFreakModel(ModelPart root) {
		this.body = root.getChild("body");
		this.head = root.getChild("head");
		this.rightArm = root.getChild("rightArm");
		this.leftArm = root.getChild("leftArm");
		this.rightLeg = root.getChild("rightLeg");
		this.leftLeg = root.getChild("leftLeg");
	}

	public static LayerDefinition getTexturedModelData() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(21, 10).addBox(-3.0F, 6.0F, -2.0F, 6.0F, 1.0F, 1.0F)
		.texOffs(14, 12).addBox(-4.0F, 2.0F, -2.0F, 8.0F, 3.0F, 1.0F)
		.texOffs(17, 14).addBox(-4.0F, 10.0F, -2.0F, 8.0F, 2.0F, 1.0F)
		.texOffs(21, 12).addBox(1.0F, 1.0F, -2.0F, 3.0F, 1.0F, 1.0F)
		.texOffs(21, 12).addBox(1.0F, 0.0F, 2.0F, 3.0F, 1.0F, 1.0F)
		.texOffs(21, 12).addBox(1.0F, 2.0F, 2.0F, 3.0F, 1.0F, 1.0F)
		.texOffs(21, 12).addBox(1.0F, 4.0F, 2.0F, 3.0F, 1.0F, 1.0F)
		.texOffs(21, 12).addBox(-4.0F, 4.0F, 2.0F, 3.0F, 1.0F, 1.0F)
		.texOffs(21, 12).addBox(-4.0F, 2.0F, 2.0F, 3.0F, 1.0F, 1.0F)
		.texOffs(21, 12).addBox(-4.0F, 0.0F, 2.0F, 3.0F, 1.0F, 1.0F)
		.texOffs(21, 12).addBox(-4.0F, 1.0F, -2.0F, 3.0F, 1.0F, 1.0F)
		.texOffs(21, 12).addBox(-4.0F, 0.0F, -2.0F, 2.0F, 1.0F, 1.0F)
		.texOffs(21, 12).addBox(-1.0F, 9.0F, 1.0F, 2.0F, 1.0F, 1.0F)
		.texOffs(21, 12).addBox(2.0F, 0.0F, -2.0F, 2.0F, 1.0F, 1.0F)
		.texOffs(21, 12).addBox(-1.0F, 5.0F, -2.0F, 2.0F, 1.0F, 1.0F)
		.texOffs(21, 12).addBox(-1.0F, 7.0F, -2.0F, 2.0F, 3.0F, 1.0F)
		.texOffs(27, 8).addBox(-1.0F, 0.0F, 2.0F, 2.0F, 10.0F, 1.0F)
		.texOffs(15, 15).addBox(-4.0F, 10.0F, 1.0F, 8.0F, 2.0F, 1.0F)
		.texOffs(10, 2).addBox(4.0F, 10.0F, -1.0F, 1.0F, 2.0F, 2.0F)
		.texOffs(10, 2).addBox(-5.0F, 10.0F, -1.0F, 1.0F, 2.0F, 2.0F)
		.texOffs(1, 5).addBox(-5.0F, 4.0F, -1.0F, 1.0F, 1.0F, 3.0F)
		.texOffs(46, 10).addBox(-5.0F, 2.0F, -1.0F, 1.0F, 1.0F, 3.0F)
		.texOffs(18, 22).addBox(-5.0F, 0.0F, -1.0F, 1.0F, 1.0F, 3.0F)
		.texOffs(8, 19).addBox(4.0F, 0.0F, -1.0F, 1.0F, 1.0F, 3.0F)
		.texOffs(21, 9).addBox(4.0F, 4.0F, -1.0F, 1.0F, 1.0F, 3.0F)
		.texOffs(41, 20).addBox(4.0F, 2.0F, -1.0F, 1.0F, 1.0F, 3.0F)
		.texOffs(58, 19).addBox(0.0F, 0.0F, 3.0F, 0.0F, 10.0F, 3.0F)
		.texOffs(56, 8).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 14.0F, 0.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F).mirror(false)
		.texOffs(56, 8).addBox(0.0F, -6.0F, 0.0F, 4.0F, 4.0F, 0.0F)
		.texOffs(56, 8).addBox(-4.0F, -6.0F, 0.0F, 4.0F, 4.0F, 0.0F)
		.texOffs(56, 8).addBox(-2.0F, -8.0F, 0.0F, 4.0F, 4.0F, 0.0F)
		.texOffs(56, 8).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 0.0F)
		.texOffs(48, 0).addBox(-2.0F, -6.0F, -2.0F, 4.0F, 4.0F, 4.0F), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(58, 19).addBox(0.0F, -3.0F, 4.0F, 0.0F, 8.0F, 3.0F)
		.texOffs(64, 25).addBox(0.0F, -3.0F, -4.0F, 0.0F, 8.0F, -3.0F), PartPose.offsetAndRotation(0.0F, -5.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition rightArm = partdefinition.addOrReplaceChild("rightArm", CubeListBuilder.create(), PartPose.offset(8.0F, 2.0F, 0.0F));

		PartDefinition leftArm = partdefinition.addOrReplaceChild("leftArm", CubeListBuilder.create(), PartPose.offset(-8.0F, 2.0F, 0.0F));

		PartDefinition rightLeg = partdefinition.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(0.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F).mirror(false), PartPose.offset(2.0F, 12.0F, 0.0F));

		PartDefinition leftLeg = partdefinition.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F), PartPose.offset(-2.0F, 12.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}
	
    protected float lerpAngle(float angleOne, float angleTwo, float magnitude) {
        float f = (magnitude - angleTwo) % ((float)Math.PI * 2);
        if (f < (float)(-Math.PI)) {
            f += (float)Math.PI * 2;
        }
        if (f >= (float)Math.PI) {
            f -= (float)Math.PI * 2;
        }
        return angleTwo + angleOne * f;
    }

    private float method_2807(float f) {
        return -65.0f * f + f * f;
    }

    @Override
    public void setupAnim(T livingEntity, float f, float g, float h, float i, float j) {
        boolean bl3;
        boolean bl = ((LivingEntity)livingEntity).getFallFlyingTicks() > 4;
        boolean bl2 = ((LivingEntity)livingEntity).isVisuallySwimming();
        this.head.yRot = i * ((float)Math.PI / 180);
        this.head.xRot = bl ? -0.7853982f : (this.pissnshit > 0.0f ? (bl2 ? this.lerpAngle(this.pissnshit, this.head.xRot, -0.7853982f) : this.lerpAngle(this.pissnshit, this.head.xRot, j * ((float)Math.PI / 180))) : j * ((float)Math.PI / 180));
        this.body.yRot = 0.0f;
        this.rightArm.z = 0.0f;
        this.leftArm.z = 0.0f;
        float k = 1.0f;
        if (bl) {
            k = (float)((Entity)livingEntity).getDeltaMovement().lengthSqr();
            k /= 0.2f;
            k *= k * k;
        }
        if (k < 1.0f) {
            k = 1.0f;
        }
        this.rightArm.xRot = Mth.cos(f * 0.6662f + (float)Math.PI) * 2.0f * g * 0.5f / k;
        this.leftArm.xRot = Mth.cos(f * 0.6662f) * 2.0f * g * 0.5f / k;
        this.rightArm.zRot = 0.0f;
        this.leftArm.zRot = 0.0f;
        this.rightLeg.xRot = Mth.cos(f * 0.6662f) * 1.4f * g / k;
        this.leftLeg.xRot = Mth.cos(f * 0.6662f + (float)Math.PI) * 1.4f * g / k;
        this.rightLeg.yRot = 0.0f;
        this.leftLeg.yRot = 0.0f;
        this.rightLeg.zRot = 0.0f;
        this.leftLeg.zRot = 0.0f;
        if (this.riding) {
            this.rightArm.xRot += -0.62831855f;
            this.leftArm.xRot += -0.62831855f;
            this.rightLeg.xRot = -1.4137167f;
            this.rightLeg.yRot = 0.31415927f;
            this.rightLeg.zRot = 0.07853982f;
            this.leftLeg.xRot = -1.4137167f;
            this.leftLeg.yRot = -0.31415927f;
            this.leftLeg.zRot = -0.07853982f;
        }
        this.rightArm.yRot = 0.0f;
        this.leftArm.yRot = 0.0f;
            float p = 0.33333334f;
            this.leftLeg.xRot = Mth.lerp(this.pissnshit, this.leftLeg.xRot, 0.3f * Mth.cos(f * 0.33333334f + (float)Math.PI));
            this.rightLeg.xRot = Mth.lerp(this.pissnshit, this.rightLeg.xRot, 0.3f * Mth.cos(f * 0.33333334f));
            
    }

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, buffer, packedLight, packedOverlay);
		head.render(poseStack, buffer, packedLight, packedOverlay);
		rightArm.render(poseStack, buffer, packedLight, packedOverlay);
		leftArm.render(poseStack, buffer, packedLight, packedOverlay);
		rightLeg.render(poseStack, buffer, packedLight, packedOverlay);
		leftLeg.render(poseStack, buffer, packedLight, packedOverlay);
	}
}