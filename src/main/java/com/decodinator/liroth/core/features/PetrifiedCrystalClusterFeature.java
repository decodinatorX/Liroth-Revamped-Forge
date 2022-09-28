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
import net.minecraft.world.level.levelgen.placement.CaveSurface;

public class PetrifiedCrystalClusterFeature
extends Feature<DripstoneClusterConfiguration> {
    public PetrifiedCrystalClusterFeature(Codec<DripstoneClusterConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<DripstoneClusterConfiguration> context) {
    	WorldGenLevel structureWorldAccess = context.level();
        BlockPos blockPos = context.origin();
        DripstoneClusterConfiguration dripstoneClusterFeatureConfig = context.config();
        RandomSource random = context.random();
        if (!PetrifiedCrystalHelper.canGenerate(structureWorldAccess, blockPos)) {
            return false;
        }
        int i = dripstoneClusterFeatureConfig.height.sample(random);
        float f = dripstoneClusterFeatureConfig.wetness.sample(random);
        float g = dripstoneClusterFeatureConfig.density.sample(random);
        int j = dripstoneClusterFeatureConfig.radius.sample(random);
        int k = dripstoneClusterFeatureConfig.radius.sample(random);
        for (int l = -j; l <= j; ++l) {
            for (int m = -k; m <= k; ++m) {
                double d = this.dripstoneChance(j, k, l, m, dripstoneClusterFeatureConfig);
                BlockPos blockPos2 = blockPos.offset(l, 0, m);
                this.generate(structureWorldAccess, random, blockPos2, l, m, f, d, i, g, dripstoneClusterFeatureConfig);
            }
        }
        return true;
    }

    private void generate(WorldGenLevel world, RandomSource random, BlockPos pos, int localX, int localZ, float wetness, double dripstoneChance, int height, float density, DripstoneClusterConfiguration config) {
        boolean bl4;
        int t;
        int m;
        boolean bl3;
        int l;
        int j;
        boolean bl2;
        Column caveSurface;
        boolean bl;
        Optional<Column> optional = Column.scan(world, pos, config.floorToCeilingSearchRange, PetrifiedCrystalHelper::canGenerate, PetrifiedCrystalHelper::canReplaceOrLava);
        if (!optional.isPresent()) {
            return;
        }
        OptionalInt optionalInt = optional.get().getCeiling();
        OptionalInt optionalInt2 = optional.get().getFloor();
        if (!optionalInt.isPresent() && !optionalInt2.isPresent()) {
            return;
        }
        boolean bl5 = bl = random.nextFloat() < wetness;
        if (bl && optionalInt2.isPresent() && this.canWaterSpawn(world, pos.atY(optionalInt2.getAsInt()))) {
            int i = optionalInt2.getAsInt();
            caveSurface = optional.get().withFloor(OptionalInt.of(i - 1));
            world.setBlock(pos.atY(i), Blocks.WATER.defaultBlockState(), 2);
        } else {
            caveSurface = optional.get();
        }
        OptionalInt optionalInt3 = caveSurface.getHeight();
        boolean bl6 = bl2 = random.nextDouble() < dripstoneChance;
        if (optionalInt.isPresent() && bl2 && !this.isLava(world, pos.atY(optionalInt.getAsInt()))) {
            j = config.dripstoneBlockLayerThickness.sample(random);
            this.placeDripstoneBlocks(world, pos.atY(optionalInt.getAsInt()), j, Direction.UP);
            int k = optionalInt3.isPresent() ? Math.min(height, optionalInt.getAsInt() - optionalInt3.getAsInt()) : height;
            l = this.getHeight(random, localX, localZ, density, k, config);
        } else {
            l = 0;
        }
        boolean bl7 = bl3 = random.nextDouble() < dripstoneChance;
        if (optionalInt3.isPresent() && bl3 && !this.isLava(world, pos.atY(optionalInt3.getAsInt()))) {
            m = config.dripstoneBlockLayerThickness.sample(random);
            this.placeDripstoneBlocks(world, pos.atY(optionalInt3.getAsInt()), m, Direction.DOWN);
            j = optionalInt.isPresent() ? Math.max(0, l + Mth.randomBetweenInclusive(random, -config.maxStalagmiteStalactiteHeightDiff, config.maxStalagmiteStalactiteHeightDiff)) : this.getHeight(random, localX, localZ, density, height, config);
        } else {
            j = 0;
        }
        if (optionalInt.isPresent() && optionalInt3.isPresent() && optionalInt.getAsInt() - l <= optionalInt3.getAsInt() + j) {
            int n = optionalInt3.getAsInt();
            int o = optionalInt.getAsInt();
            int p = Math.max(o - l, n + 1);
            int q = Math.min(n + j, o - 1);
            int r = Mth.randomBetweenInclusive(random, p, q + 1);
            int s = r - 1;
            m = o - r;
            t = s - n;
        } else {
            m = l;
            t = j;
        }
        boolean bl8 = bl4 = random.nextBoolean() && m > 0 && t > 0 && caveSurface.getHeight().isPresent() && m + t == caveSurface.getHeight().getAsInt();
        if (optionalInt.isPresent()) {
        	PetrifiedCrystalHelper.generatePointedDripstone(world, pos.atY(optionalInt.getAsInt() - 1), Direction.DOWN, m, bl4);
        }
        if (optionalInt3.isPresent()) {
        	PetrifiedCrystalHelper.generatePointedDripstone(world, pos.atY(optionalInt3.getAsInt() + 1), Direction.UP, t, bl4);
        }
    }

    private boolean isLava(LevelReader world, BlockPos pos) {
        return world.getBlockState(pos).is(Blocks.LAVA);
    }

    private int getHeight(RandomSource random, int localX, int localZ, float density, int height, DripstoneClusterConfiguration config) {
        if (random.nextFloat() > density) {
            return 0;
        }
        int i = Math.abs(localX) + Math.abs(localZ);
        float f = (float)Mth.clampedMap((double)i, 0.0, (double)config.maxDistanceFromCenterAffectingHeightBias, (double)height / 2.0, 0.0);
        return (int)PetrifiedCrystalClusterFeature.clampedGaussian(random, 0.0f, height, f, config.heightDeviation);
    }

    private boolean canWaterSpawn(WorldGenLevel world, BlockPos pos) {
        BlockState blockState = world.getBlockState(pos);
        if (blockState.is(Blocks.WATER) || blockState.is(LirothBlocks.PETRIFIED_CRYSTAL_BLOCK.get()) || blockState.is(LirothBlocks.POINTED_PETRIFIED_CRYSTAL.get())) {
            return false;
        }
        for (Direction direction : Direction.Plane.HORIZONTAL) {
            if (this.isStoneOrWater(world, pos.relative(direction))) continue;
            return false;
        }
        return this.isStoneOrWater(world, pos.below());
    }

    private boolean isStoneOrWater(LevelAccessor world, BlockPos pos) {
        BlockState blockState = world.getBlockState(pos);
        return blockState.is(BlockTags.BASE_STONE_OVERWORLD) || blockState.getFluidState().is(FluidTags.WATER);
    }

    private void placeDripstoneBlocks(WorldGenLevel world, BlockPos pos, int height, Direction direction) {
        MutableBlockPos mutable = pos.mutable();
        for (int i = 0; i < height; ++i) {
            if (!PetrifiedCrystalHelper.generateDripstoneBlock(world, mutable)) {
                return;
            }
            mutable.move(direction);
        }
    }

    private double dripstoneChance(int radiusX, int radiusZ, int localX, int localZ, DripstoneClusterConfiguration config) {
        int i = radiusX - Math.abs(localX);
        int j = radiusZ - Math.abs(localZ);
        int k = Math.min(i, j);
        return Mth.clampedMap(k, 0.0f, config.maxDistanceFromCenterAffectingHeightBias, config.chanceOfDripstoneColumnAtMaxDistanceFromCenter, 1.0f);
    }

    private static float clampedGaussian(RandomSource random, float min, float max, float mean, float deviation) {
        return ClampedNormalFloat.sample(random, mean, deviation, min, max);
    }
}