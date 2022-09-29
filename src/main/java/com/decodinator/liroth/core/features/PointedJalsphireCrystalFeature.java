package com.decodinator.liroth.core.features;

import java.util.Optional;
import java.util.OptionalInt;

import com.decodinator.liroth.core.LirothBlocks;
import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.ClampedNormalFloat;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Column;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.DripstoneClusterConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.PointedDripstoneConfiguration;
import net.minecraft.world.level.levelgen.placement.CaveSurface;

public class PointedJalsphireCrystalFeature
extends Feature<PointedDripstoneConfiguration> {
	   public PointedJalsphireCrystalFeature(Codec<PointedDripstoneConfiguration> p_191067_) {
	      super(p_191067_);
	   }

	   public boolean place(FeaturePlaceContext<PointedDripstoneConfiguration> p_191078_) {
	      LevelAccessor levelaccessor = p_191078_.level();
	      BlockPos blockpos = p_191078_.origin();
	      RandomSource randomsource = p_191078_.random();
	      PointedDripstoneConfiguration pointeddripstoneconfiguration = p_191078_.config();
	      Optional<Direction> optional = getTipDirection(levelaccessor, blockpos, randomsource);
	      if (optional.isEmpty()) {
	         return false;
	      } else {
	         BlockPos blockpos1 = blockpos.relative(optional.get().getOpposite());
	         createPatchOfDripstoneBlocks(levelaccessor, randomsource, blockpos1, pointeddripstoneconfiguration);
	         int i = randomsource.nextFloat() < pointeddripstoneconfiguration.chanceOfTallerDripstone && JalsphireCrystalHelper.isEmptyOrWater(levelaccessor.getBlockState(blockpos.relative(optional.get()))) ? 2 : 1;
	         JalsphireCrystalHelper.growPointedDripstone(levelaccessor, blockpos, optional.get(), i, false);
	         return true;
	      }
	   }

	   private static Optional<Direction> getTipDirection(LevelAccessor p_225199_, BlockPos p_225200_, RandomSource p_225201_) {
	      boolean flag = JalsphireCrystalHelper.isDripstoneBase(p_225199_.getBlockState(p_225200_.above()));
	      boolean flag1 = JalsphireCrystalHelper.isDripstoneBase(p_225199_.getBlockState(p_225200_.below()));
	      if (flag && flag1) {
	         return Optional.of(p_225201_.nextBoolean() ? Direction.DOWN : Direction.UP);
	      } else if (flag) {
	         return Optional.of(Direction.DOWN);
	      } else {
	         return flag1 ? Optional.of(Direction.UP) : Optional.empty();
	      }
	   }

	   private static void createPatchOfDripstoneBlocks(LevelAccessor p_225194_, RandomSource p_225195_, BlockPos p_225196_, PointedDripstoneConfiguration p_225197_) {
	      JalsphireCrystalHelper.placeDripstoneBlockIfPossible(p_225194_, p_225196_);

	      for(Direction direction : Direction.Plane.HORIZONTAL) {
	         if (!(p_225195_.nextFloat() > p_225197_.chanceOfDirectionalSpread)) {
	            BlockPos blockpos = p_225196_.relative(direction);
	            JalsphireCrystalHelper.placeDripstoneBlockIfPossible(p_225194_, blockpos);
	            if (!(p_225195_.nextFloat() > p_225197_.chanceOfSpreadRadius2)) {
	               BlockPos blockpos1 = blockpos.relative(Direction.getRandom(p_225195_));
	               JalsphireCrystalHelper.placeDripstoneBlockIfPossible(p_225194_, blockpos1);
	               if (!(p_225195_.nextFloat() > p_225197_.chanceOfSpreadRadius3)) {
	                  BlockPos blockpos2 = blockpos1.relative(Direction.getRandom(p_225195_));
	                  JalsphireCrystalHelper.placeDripstoneBlockIfPossible(p_225194_, blockpos2);
	               }
	            }
	         }
	      }

	   }
	}