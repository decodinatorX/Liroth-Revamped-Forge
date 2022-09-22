package com.decodinator.liroth.core;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartNames;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.world.entity.LivingEntity;

public class PotestiumHelmetModel extends HumanoidModel<LivingEntity> {
	
	public PotestiumHelmetModel(ModelPart root) {
		super(root);
	}

	public static MeshDefinition createMesh() {
		var mesh = new MeshDefinition();
		var root = mesh.getRoot();

		PartDefinition Helm = root.addOrReplaceChild("Helm", CubeListBuilder.create().texOffs(0, 10).addBox(-4.0F, -33.0F, -5.0F, 8.0F, 9.0F, 8.0F)
		.texOffs(0, 0).addBox(-4.5F, -33.5F, -4.5F, 9.0F, 10.0F, 9.0F)
		.texOffs(36, 15).addBox(-1.0F, -32.75F, -6.25F, 2.0F, 2.0F, 1.0F)
		.texOffs(49, 15).addBox(1.5F, -33.25F, -5.75F, 2.0F, 2.0F, 1.0F)
		.texOffs(45, 15).addBox(-3.5F, -33.25F, -5.75F, 2.0F, 2.0F, 1.0F)
		.texOffs(47, 15).addBox(-4.5F, -34.25F, -5.75F, 2.0F, 2.0F, 1.0F)
		.texOffs(46, 15).addBox(2.5F, -34.25F, -5.75F, 2.0F, 2.0F, 1.0F)
		.texOffs(46, 14).addBox(-1.5F, -33.25F, -5.75F, 3.0F, 3.0F, 1.0F), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition cube_r1 = Helm.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 9).mirror().addBox(5.25F, -11.0F, 0.75F, 3.0F, 3.0F, 1.0F).mirror(false), PartPose.offsetAndRotation(-5.0F, -28.0F, -5.0F, 0.0873F, 0.0F, 1.0036F));

		PartDefinition cube_r2 = Helm.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 9).addBox(-3.0F, -2.5F, 0.0F, 3.0F, 3.0F, 1.0F), PartPose.offsetAndRotation(-5.0F, -28.0F, -5.0F, 0.0873F, 0.0F, -1.0036F));

		PartDefinition cube_r3 = Helm.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(36, 9).addBox(-6.5F, -4.75F, -8.5F, 5.0F, 1.0F, 9.0F), PartPose.offsetAndRotation(4.0F, -27.0F, 0.0F, -1.5708F, 0.4363F, -1.5708F));

		PartDefinition cube_r4 = Helm.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(36, 9).addBox(-9.25F, -7.75F, -4.5F, 5.0F, 1.0F, 9.0F), PartPose.offsetAndRotation(4.0F, -27.0F, 0.0F, 0.0F, 0.0F, -1.0036F));

		PartDefinition cube_r5 = Helm.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(36, 9).mirror().addBox(0.0F, -1.0F, -4.5F, 5.0F, 1.0F, 9.0F).mirror(false), PartPose.offsetAndRotation(4.0F, -27.0F, 0.0F, 0.0F, 0.0F, 1.0036F));

		PartDefinition cube_r6 = Helm.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(38, 19).addBox(-1.0F, -28.5F, -5.0F, 2.0F, 2.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition cube_r7 = Helm.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(22, 19).addBox(-1.5F, -28.5F, -5.0F, 3.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1745F, 0.0F, 0.0F));
		
		return mesh;
	}
}