package com.decodinator.liroth.core.features.trees;

import com.decodinator.liroth.core.LirothConfiguredFeatures;

import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class DamnationTreeGrower extends AbstractTreeGrower {
	   protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource p_256119_, boolean p_256536_) {
		   return LirothConfiguredFeatures.DAMNATION.getHolder().get();	   
	}
}