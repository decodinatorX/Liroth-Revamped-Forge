package com.decodinator.liroth.core.features;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class DamnationVinesFeature
extends Feature<NoneFeatureConfiguration> {
    private static final Direction[] DIRECTIONS = Direction.values();

    public DamnationVinesFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
    	WorldGenLevel structureWorldAccess = context.level();
        BlockPos blockPos = context.origin();
        RandomSource random = context.random();
        if (!structureWorldAccess.isEmptyBlock(blockPos)) {
            return false;
        }
        BlockState blockState = structureWorldAccess.getBlockState(blockPos.above());
        if (!blockState.is(Blocks.NETHERRACK) && !blockState.is(Blocks.NETHER_WART_BLOCK)) {
            return false;
        }
        this.generateNetherWartBlocksInArea(structureWorldAccess, random, blockPos);
        this.generateVinesInArea(structureWorldAccess, random, blockPos);
        return true;
    }

    private void generateNetherWartBlocksInArea(LevelAccessor world, RandomSource random, BlockPos pos) {
        world.setBlock(pos, Blocks.NETHER_WART_BLOCK.defaultBlockState(), Block.UPDATE_NEIGHBORS);
        MutableBlockPos mutable = new MutableBlockPos();
        MutableBlockPos mutable2 = new MutableBlockPos();
        for (int i = 0; i < 200; ++i) {
            mutable.setWithOffset(pos, random.nextInt(6) - random.nextInt(6), random.nextInt(2) - random.nextInt(5), random.nextInt(6) - random.nextInt(6));
            if (!world.isEmptyBlock(mutable)) continue;
            int j = 0;
            for (Direction direction : DIRECTIONS) {
                BlockState blockState = world.getBlockState(mutable2.setWithOffset((Vec3i)mutable, direction));
                if (blockState.is(Blocks.NETHERRACK) || blockState.is(Blocks.NETHER_WART_BLOCK)) {
                    ++j;
                }
                if (j > 1) break;
            }
            world.setBlock(mutable, Blocks.NETHER_WART_BLOCK.defaultBlockState(), Block.UPDATE_NEIGHBORS);
        }
    }

    private void generateVinesInArea(LevelAccessor world, RandomSource random, BlockPos pos) {
    	MutableBlockPos mutable = new MutableBlockPos();
        for (int i = 0; i < 100; ++i) {
            BlockState blockState;
            mutable.setWithOffset(pos, random.nextInt(8) - random.nextInt(8), random.nextInt(2) - random.nextInt(7), random.nextInt(8) - random.nextInt(8));
            if (!world.isEmptyBlock(mutable) || !(blockState = world.getBlockState((BlockPos)mutable.above())).is(Blocks.NETHERRACK) && !blockState.is(Blocks.NETHER_WART_BLOCK)) continue;
            int j = Mth.nextInt(random, 1, 8);
            if (random.nextInt(6) == 0) {
                j *= 2;
            }
            if (random.nextInt(5) == 0) {
                j = 1;
            }
            DamnationVinesFeature.generateVineColumn(world, random, mutable, j, 17, 25);
        }
    }

    public static void generateVineColumn(LevelAccessor world, RandomSource random, MutableBlockPos pos, int length, int minAge, int maxAge) {
        for (int i = 0; i <= length; ++i) {
            if (world.isEmptyBlock(pos)) {
                if (i == length || !world.isEmptyBlock((BlockPos)pos.below())) {
                    world.setBlock(pos, (BlockState)Blocks.WEEPING_VINES.defaultBlockState().setValue(GrowingPlantHeadBlock.AGE, Mth.nextInt(random, minAge, maxAge)), Block.UPDATE_NEIGHBORS);
                    break;
                }
                world.setBlock(pos, Blocks.WEEPING_VINES_PLANT.defaultBlockState(), Block.UPDATE_NEIGHBORS);
            }
            pos.move(Direction.DOWN);
        }
    }
}