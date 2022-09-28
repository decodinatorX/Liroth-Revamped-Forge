package com.decodinator.liroth.core.features;

import java.util.function.Consumer;

import com.decodinator.liroth.core.LirothBlocks;
import com.decodinator.liroth.core.blocks.PointedPetrifiedCrystal;

import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DripstoneThickness;

public class PetrifiedCrystalHelper {
    protected static double scaleHeightFromRadius(double radius, double scale, double heightScale, double bluntness) {
        if (radius < bluntness) {
            radius = bluntness;
        }
        double d = 0.384;
        double e = radius / scale * 0.384;
        double f = 0.75 * Math.pow(e, 1.3333333333333333);
        double g = Math.pow(e, 0.6666666666666666);
        double h = 0.3333333333333333 * Math.log(e);
        double i = heightScale * (f - g - h);
        i = Math.max(i, 0.0);
        return i / 0.384 * scale;
    }

    protected static boolean canGenerateBase(WorldGenLevel world, BlockPos pos, int height) {
        if (PetrifiedCrystalHelper.canGenerateOrLava(world, pos)) {
            return false;
        }
        float f = 6.0f;
        float g = 6.0f / (float)height;
        for (float h = 0.0f; h < (float)Math.PI * 2; h += g) {
            int j;
            int i = (int)(Mth.cos(h) * (float)height);
            if (!PetrifiedCrystalHelper.canGenerateOrLava(world, pos.offset(i, 0, j = (int)(Mth.sin(h) * (float)height)))) continue;
            return false;
        }
        return true;
    }

    protected static boolean canGenerate(LevelAccessor world, BlockPos pos) {
        return world.isStateAtPosition(pos, PetrifiedCrystalHelper::canGenerate);
    }

    protected static boolean canGenerateOrLava(LevelAccessor world, BlockPos pos) {
        return world.isStateAtPosition(pos, PetrifiedCrystalHelper::canGenerateOrLava);
    }

    protected static void getDripstoneThickness(Direction direction, int height, boolean merge, Consumer<BlockState> callback) {
        if (height >= 3) {
            callback.accept(PetrifiedCrystalHelper.getState(direction, DripstoneThickness.BASE));
            for (int i = 0; i < height - 3; ++i) {
                callback.accept(PetrifiedCrystalHelper.getState(direction, DripstoneThickness.MIDDLE));
            }
        }
        if (height >= 2) {
            callback.accept(PetrifiedCrystalHelper.getState(direction, DripstoneThickness.FRUSTUM));
        }
        if (height >= 1) {
            callback.accept(PetrifiedCrystalHelper.getState(direction, merge ? DripstoneThickness.TIP_MERGE : DripstoneThickness.TIP));
        }
    }

    protected static void generatePointedDripstone(LevelAccessor world, BlockPos pos, Direction direction, int height, boolean merge) {
        if (!PetrifiedCrystalHelper.canReplace(world.getBlockState(pos.relative(direction.getOpposite())))) {
            return;
        }
        MutableBlockPos mutable = pos.mutable();
        PetrifiedCrystalHelper.getDripstoneThickness(direction, height, merge, state -> {
            if (state.is(LirothBlocks.POINTED_PETRIFIED_CRYSTAL.get())) {
                state = (BlockState)state.setValue(PointedPetrifiedCrystal.WATERLOGGED, world.isWaterAt(mutable));
            }
            world.setBlock(mutable, (BlockState)state, Block.UPDATE_NEIGHBORS);
            mutable.move(direction);
        });
    }

    protected static boolean generateDripstoneBlock(LevelAccessor world, BlockPos pos) {
        BlockState blockState = world.getBlockState(pos);
        if (blockState.is(BlockTags.DRIPSTONE_REPLACEABLE)) {
            world.setBlock(pos, LirothBlocks.PETRIFIED_CRYSTAL_BLOCK.get().defaultBlockState(), Block.UPDATE_NEIGHBORS);
            return true;
        }
        return false;
    }

    private static BlockState getState(Direction direction, DripstoneThickness thickness) {
        return (BlockState)((BlockState)LirothBlocks.POINTED_PETRIFIED_CRYSTAL.get().defaultBlockState().setValue(PointedPetrifiedCrystal.TIP_DIRECTION, direction)).setValue(PointedPetrifiedCrystal.THICKNESS, thickness);
    }

    public static boolean canReplaceOrLava(BlockState state) {
        return PetrifiedCrystalHelper.canReplace(state) || state.is(Blocks.LAVA);
    }

    public static boolean canReplace(BlockState state) {
        return state.is(LirothBlocks.PETRIFIED_CRYSTAL_BLOCK.get()) || state.is(BlockTags.DRIPSTONE_REPLACEABLE);
    }

    public static boolean canGenerate(BlockState state) {
        return state.isAir() || state.is(Blocks.WATER);
    }

    public static boolean canGenerateOrLava(BlockState state) {
        return state.isAir() || state.is(Blocks.WATER) || state.is(Blocks.LAVA);
    }
}