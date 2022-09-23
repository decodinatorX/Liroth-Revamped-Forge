package com.decodinator.liroth.core;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * A utility {@link BlockEntityWithoutLevelRenderer} extension for simple rendering of {@link BlockEntity} items.
 *
 * @param <BE> The type of {@link BlockEntity} the renderer is for.
 */
@OnlyIn(Dist.CLIENT)
public class TypedBlockEntityWithoutLevelRenderer<BE extends BlockEntity> extends BlockEntityWithoutLevelRenderer {
	private final BE be;

	public TypedBlockEntityWithoutLevelRenderer(BlockEntityRenderDispatcher dispatcher, EntityModelSet modelSet, BE be) {
		super(dispatcher, modelSet);
		this.be = be;
	}

	@Override
	public void renderByItem(ItemStack itemStackIn, ItemTransforms.TransformType transformType, PoseStack poseStack, MultiBufferSource source, int combinedLight, int combinedOverlay) {
		this.blockEntityRenderDispatcher.renderItem(this.be, poseStack, source, combinedLight, combinedOverlay);
	}
}