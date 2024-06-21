package com.decodinator.liroth.core.blocks;

import com.decodinator.liroth.core.LirothBlocks;

import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.NetherVines;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

public class DamnationVinesHead extends GrowingPlantHeadBlock {
	protected static final VoxelShape SHAPE = Block.box(4.0, 9.0, 4.0, 12.0, 16.0, 12.0);

	public DamnationVinesHead(BlockBehaviour.Properties arg) {
		super(arg, Direction.DOWN, SHAPE, false, 0.1);
	}

	protected int getBlocksToGrowWhenBonemealed(RandomSource arg) {
		return NetherVines.getBlocksToGrowWhenBonemealed(arg);
	}


	   protected Block getBodyBlock() {
	      return LirothBlocks.DAMNATION_VINES_PLANT.get();
	   }

	protected boolean canGrowInto(BlockState arg) {
		return arg.isAir();
	}
}