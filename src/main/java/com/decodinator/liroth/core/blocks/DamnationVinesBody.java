package com.decodinator.liroth.core.blocks;

import com.decodinator.liroth.core.LirothBlocks;

import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GrowingPlantBodyBlock;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.NetherVines;
import net.minecraft.world.level.block.WeepingVinesBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

public class DamnationVinesBody extends GrowingPlantBodyBlock {
	   public static final VoxelShape SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);

	   public DamnationVinesBody(BlockBehaviour.Properties p_154975_) {
	      super(p_154975_, Direction.DOWN, SHAPE, false);
	   }

	   protected GrowingPlantHeadBlock getHeadBlock() {
	      return (GrowingPlantHeadBlock)LirothBlocks.DAMNATION_VINES.get();
	   }
	}