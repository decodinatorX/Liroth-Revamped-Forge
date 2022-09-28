package com.decodinator.liroth.core.blocks;

import com.decodinator.liroth.core.LirothBlocks;
import com.decodinator.liroth.core.LirothFluids;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GrowingPlantBodyBlock;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.LiquidBlockContainer;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.Shapes;

public class VileTentacleBlock extends GrowingPlantBodyBlock implements LiquidBlockContainer {
	   public VileTentacleBlock(BlockBehaviour.Properties p_54323_) {
		      super(p_54323_, Direction.UP, Shapes.block(), true);
		   }

		   protected GrowingPlantHeadBlock getHeadBlock() {
		      return (GrowingPlantHeadBlock)LirothBlocks.VILE_TENTACLE_TIP.get();
		   }

		   public FluidState getFluidState(BlockState p_54336_) {
		      return LirothFluids.LIROTH_FLUID.get().getSource(false);
		   }

		   protected boolean canAttachTo(BlockState p_153457_) {
			   return true;
		   }

		   public boolean canPlaceLiquid(BlockGetter p_54325_, BlockPos p_54326_, BlockState p_54327_, Fluid p_54328_) {
		      return false;
		   }

		   public boolean placeLiquid(LevelAccessor p_54330_, BlockPos p_54331_, BlockState p_54332_, FluidState p_54333_) {
		      return false;
		   }
		}