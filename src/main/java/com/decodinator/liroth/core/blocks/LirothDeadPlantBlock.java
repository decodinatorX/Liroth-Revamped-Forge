package com.decodinator.liroth.core.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class LirothDeadPlantBlock extends LirothWaterPlantTypeBlock {
	   protected static final float AABB_OFFSET = 6.0F;
	   protected static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 15.0D, 14.0D);

	   public LirothDeadPlantBlock(BlockBehaviour.Properties p_49151_) {
	      super(p_49151_);
	   }

	   public VoxelShape getShape(BlockState p_49153_, BlockGetter p_49154_, BlockPos p_49155_, CollisionContext p_49156_) {
	      return SHAPE;
	   }
	}