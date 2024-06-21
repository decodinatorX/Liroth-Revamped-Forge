package com.decodinator.liroth.core.blocks;

import com.decodinator.liroth.core.LirothBlocks;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GrowingPlantBodyBlock;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

public class DamnationVinesBody extends GrowingPlantBodyBlock {
	public static final VoxelShape SHAPE = Block.box(1.0, 0.0, 1.0, 15.0, 16.0, 15.0);

	public DamnationVinesBody(BlockBehaviour.Properties arg) {
		super(arg, Direction.DOWN, SHAPE, false);
	}

	protected boolean canGrowInto(BlockState arg) {
		return arg.isAir();
	}

	protected GrowingPlantHeadBlock getHeadBlock() {
	      return (GrowingPlantHeadBlock)LirothBlocks.DAMNATION_VINES.get();
	   }

}