package com.decodinator.liroth.core.blocks;

import com.decodinator.liroth.core.LirothParticles;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EndRodBlock;
import net.minecraft.world.level.block.state.BlockState;

public class LirothSoulRod extends EndRodBlock {

	public LirothSoulRod(Properties p_53085_) {
		super(p_53085_);
	}
	
	@Override
	   public void animateTick(BlockState p_221107_, Level p_221108_, BlockPos p_221109_, RandomSource p_221110_) {
	      Direction direction = p_221107_.getValue(FACING);
	      double d0 = (double)p_221109_.getX() + 0.55D - (double)(p_221110_.nextFloat() * 0.1F);
	      double d1 = (double)p_221109_.getY() + 0.55D - (double)(p_221110_.nextFloat() * 0.1F);
	      double d2 = (double)p_221109_.getZ() + 0.55D - (double)(p_221110_.nextFloat() * 0.1F);
	      double d3 = (double)(0.4F - (p_221110_.nextFloat() + p_221110_.nextFloat()) * 0.4F);
	      if (p_221110_.nextInt(5) == 0) {
	         p_221108_.addParticle(LirothParticles.CLOAK.get(), d0 + (double)direction.getStepX() * d3, d1 + (double)direction.getStepY() * d3, d2 + (double)direction.getStepZ() * d3, p_221110_.nextGaussian() * 0.005D, p_221110_.nextGaussian() * 0.005D, p_221110_.nextGaussian() * 0.005D);
	      }

	   }

}
