package com.decodinator.liroth.core.blocks;

import com.decodinator.liroth.core.LirothBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class JapzMiniTree  extends BushBlock {
	   private static final VoxelShape SHAPE = Shapes.or(Block.box(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.box(6.0D, 0.0D, 6.0D, 10.0D, 8.0D, 10.0D));

	   public JapzMiniTree(BlockBehaviour.Properties p_152067_) {
	      super(p_152067_);
	   }

	   public VoxelShape getShape(BlockState p_152084_, BlockGetter p_152085_, BlockPos p_152086_, CollisionContext p_152087_) {
	      return SHAPE;
	   }

	   protected boolean mayPlaceOn(BlockState p_152089_, BlockGetter p_152090_, BlockPos p_152091_) {
	      return p_152089_.is(LirothBlocks.SPINERIOS_DIRT.get()) || super.mayPlaceOn(p_152089_, p_152090_, p_152091_);
	   }

	   public boolean isValidBonemealTarget(BlockGetter p_152074_, BlockPos p_152075_, BlockState p_152076_, boolean p_152077_) {
	      return p_152074_.getFluidState(p_152075_.above()).isEmpty();
	   }

	   public boolean isBonemealSuccess(Level p_220712_, RandomSource p_220713_, BlockPos p_220714_, BlockState p_220715_) {
	      return (double)p_220712_.random.nextFloat() < 0.45D;
	   }
	}