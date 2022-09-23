package com.decodinator.liroth.core.blocks.entities;

import com.decodinator.liroth.core.LirothBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

public class SpicedChestBlockEntity extends ChestBlockEntity {

	protected SpicedChestBlockEntity(BlockEntityType<?> typeIn, BlockPos pos, BlockState state) {
		super(typeIn, pos, state);
	}

	public SpicedChestBlockEntity(BlockPos pos, BlockState state) {
		super(LirothBlockEntities.SPICED_CHEST.get(), pos, state);
	}

	@Override
	public AABB getRenderBoundingBox() {
		BlockPos worldPos = this.worldPosition;
		int x = worldPos.getX();
		int y = worldPos.getY();
		int z = worldPos.getZ();
		return new AABB(x - 1, y, z - 1, x + 2, y + 2, z + 2);
	}

}