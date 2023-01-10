package com.decodinator.liroth.core.features.trees;

import com.decodinator.liroth.core.LirothConfiguredFeatures;

import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class JapzTreeGrower extends AbstractTreeGrower {
	   protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource p_256119_, boolean p_256536_) {
		   return LirothConfiguredFeatures.JAPZ;
		   }
}