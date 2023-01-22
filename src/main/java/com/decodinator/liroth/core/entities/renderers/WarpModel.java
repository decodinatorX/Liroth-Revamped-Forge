package com.decodinator.liroth.core.entities.renderers;

import com.decodinator.liroth.core.entities.WarpEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
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
public class WarpModel<T extends WarpEntity> extends EntityModel<T> {
    public boolean carryingBlock;
    public boolean angry;
    public float leaningPitch;

	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart hat;
	private final ModelPart rightArm;
	private final ModelPart leftArm;
	private final ModelPart rightLeg;
	private final ModelPart leftLeg;

	public WarpModel(ModelPart root) {
		this.body = root.getChild("body");
		this.head = root.getChild("head");
		this.hat = root.getChild("hat");
		this.rightArm = root.getChild("rightArm");
		this.leftArm = root.getChild("leftArm");
		this.rightLeg = root.getChild("rightLeg");
		this.leftLeg = root.getChild("leftLeg");
	}

	public static LayerDefinition getTexturedModelData() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition ModelPartData = meshdefinition.getRoot();

		ModelPartData.addOrReplaceChild("body", CubeListBuilder.create().texOffs(28, 14).addBox(-4.0F, 4.0F, -2.0F, 8.0F, 8.0F, 4.0F)
		.texOffs(8, 34).addBox(-0.5F, 0.0F, -2.0F, 6.0F, 4.0F, 4.0F)
		.texOffs(24, 0).addBox(-5.5F, 0.0F, -2.0F, 6.0F, 4.0F, 4.0F), PartPose.offset(0.0F, -18.0F, 0.0F));

		PartDefinition head = ModelPartData.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F)
		.texOffs(52, 28).addBox(2.0F, -12.0F, -1.0F, 2.0F, 2.0F, 2.0F)
		.texOffs(24, 34).addBox(3.0F, -14.0F, -1.0F, 2.0F, 2.0F, 2.0F)
		.texOffs(32, 8).addBox(5.0F, -14.0F, -1.0F, 2.0F, 2.0F, 2.0F)
		.texOffs(0, 22).addBox(6.0F, -16.0F, -1.0F, 2.0F, 2.0F, 2.0F)
		.texOffs(0, 18).addBox(5.0F, -12.0F, -1.0F, 2.0F, 2.0F, 2.0F)
		.texOffs(0, 4).addBox(5.0F, -18.0F, -1.0F, 2.0F, 2.0F, 2.0F)
		.texOffs(0, 0).addBox(3.0F, -18.0F, -1.0F, 2.0F, 2.0F, 2.0F)
		.texOffs(32, 12).addBox(4.0F, -6.0F, 0.0F, 4.0F, 1.0F, 1.0F)
		.texOffs(40, 0).addBox(4.0F, -7.0F, 0.0F, 5.0F, 1.0F, 1.0F)
		.texOffs(40, 0).addBox(4.0F, -5.0F, 0.0F, 5.0F, 1.0F, 1.0F)
		.texOffs(40, 0).mirror().addBox(-9.0F, -5.0F, 0.0F, 5.0F, 1.0F, 1.0F).mirror(false)
		.texOffs(32, 12).mirror().addBox(-8.0F, -6.0F, 0.0F, 4.0F, 1.0F, 1.0F).mirror(false)
		.texOffs(40, 0).mirror().addBox(-9.0F, -7.0F, 0.0F, 5.0F, 1.0F, 1.0F).mirror(false), PartPose.offset(0.0F, -18.0F, 0.0F));

		head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 4).addBox(5.0F, -18.0F, -1.0F, 2.0F, 2.0F, 2.0F)
		.texOffs(0, 18).addBox(5.0F, -12.0F, -1.0F, 2.0F, 2.0F, 2.0F)
		.texOffs(0, 22).addBox(6.0F, -16.0F, -1.0F, 2.0F, 2.0F, 2.0F)
		.texOffs(32, 8).addBox(5.0F, -14.0F, -1.0F, 2.0F, 2.0F, 2.0F)
		.texOffs(24, 34).addBox(3.0F, -14.0F, -1.0F, 2.0F, 2.0F, 2.0F)
		.texOffs(52, 28).addBox(2.0F, -12.0F, -1.0F, 2.0F, 2.0F, 2.0F)
		.texOffs(0, 0).addBox(3.0F, -18.0F, -1.0F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1416F, 0.0F, 3.1416F));

		ModelPartData.addOrReplaceChild("hat", CubeListBuilder.create().texOffs(0, 18).addBox(-4.0F, -7.5F, -4.0F, 8.0F, 8.0F, 8.0F), PartPose.offset(0.0F, -18.0F, 0.0F));

		ModelPartData.addOrReplaceChild("rightArm", CubeListBuilder.create().texOffs(20, 42).addBox(0.0F, -2.0F, -1.0F, 2.0F, 17.0F, 2.0F)
		.texOffs(10, 43).addBox(0.0F, 15.0F, -0.5F, 2.0F, 13.0F, 2.0F), PartPose.offset(5.5F, -16.0F, 0.0F));

		ModelPartData.addOrReplaceChild("leftArm", CubeListBuilder.create().texOffs(20, 42).addBox(-2.0F, -2.0F, -1.0F, 2.0F, 17.0F, 2.0F)
		.texOffs(10, 43).mirror().addBox(-2.0F, 15.0F, -0.5F, 2.0F, 13.0F, 2.0F).mirror(false), PartPose.offset(-5.5F, -16.0F, 0.0F));

		ModelPartData.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(0, 34).addBox(0.0F, 5.0F, -1.0F, 2.0F, 25.0F, 2.0F)
		.texOffs(41, 5).addBox(-0.5F, 0.0F, -1.5F, 3.0F, 5.0F, 3.0F), PartPose.offset(2.0F, -6.0F, 0.0F));

		ModelPartData.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(0, 34).addBox(-2.0F, 5.0F, -1.0F, 2.0F, 25.0F, 2.0F)
		.texOffs(41, 5).addBox(-2.5F, 0.0F, -1.5F, 3.0F, 5.0F, 3.0F), PartPose.offset(-2.0F, -6.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
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

    @Override
    public void setupAnim(T livingEntity, float f, float g, float h, float i, float j) {
        boolean bl = ((LivingEntity)livingEntity).getFallFlyingTicks() > 4;
        boolean bl2 = ((LivingEntity)livingEntity).isVisuallySwimming();
        this.head.yRot = i * ((float)Math.PI / 180);
        this.head.xRot = bl ? -0.7853982f : (this.leaningPitch > 0.0f ? (bl2 ? this.lerpAngle(this.leaningPitch, this.head.xRot, -0.7853982f) : this.lerpAngle(this.leaningPitch, this.head.xRot, j * ((float)Math.PI / 180))) : j * ((float)Math.PI / 180));
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
        if (this.carryingBlock) {
            this.rightArm.xRot = -0.5f;
            this.leftArm.xRot = -0.5f;
            this.rightArm.zRot = 0.05f;
            this.leftArm.zRot = -0.05f;
        }
        if (this.angry) {
            this.head.y -= 5.0f;
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
            this.leftLeg.xRot = Mth.lerp(this.leaningPitch, this.leftLeg.xRot, 0.3f * Mth.cos(f * 0.33333334f + (float)Math.PI));
            this.rightLeg.xRot = Mth.lerp(this.leaningPitch, this.rightLeg.xRot, 0.3f * Mth.cos(f * 0.33333334f));
            
    }

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, buffer, packedLight, packedOverlay);
		head.render(poseStack, buffer, packedLight, packedOverlay);
		hat.render(poseStack, buffer, packedLight, packedOverlay);
		rightArm.render(poseStack, buffer, packedLight, packedOverlay);
		leftArm.render(poseStack, buffer, packedLight, packedOverlay);
		rightLeg.render(poseStack, buffer, packedLight, packedOverlay);
		leftLeg.render(poseStack, buffer, packedLight, packedOverlay);
	}
}