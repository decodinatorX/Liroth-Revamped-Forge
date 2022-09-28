package com.decodinator.liroth.core.features.trees;

import com.decodinator.liroth.core.LirothConfiguredFeatures;

import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class JapzTreeGrower extends AbstractTreeGrower {
	protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource p_222938_, boolean p_222939_) {
		   return LirothConfiguredFeatures.JAPZ.getHolder().get();
	   }
}