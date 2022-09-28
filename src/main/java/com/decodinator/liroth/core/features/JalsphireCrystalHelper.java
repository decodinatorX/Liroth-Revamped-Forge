package com.decodinator.liroth.core.features;

import java.util.function.Consumer;

import com.decodinator.liroth.core.LirothBlocks;
import com.decodinator.liroth.core.blocks.PointedJalsphireCrystal;

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

public class JalsphireCrystalHelper {
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
        if (JalsphireCrystalHelper.canGenerateOrLava(world, pos)) {
            return false;
        }
        float f = 6.0f;
        float g = 6.0f / (float)height;
        for (float h = 0.0f; h < (float)Math.PI * 2; h += g) {
            int j;
            int i = (int)(Mth.cos(h) * (float)height);
            if (!JalsphireCrystalHelper.canGenerateOrLava(world, pos.offset(i, 0, j = (int)(Mth.sin(h) * (float)height)))) continue;
            return false;
        }
        return true;
    }

    protected static boolean canGenerate(LevelAccessor world, BlockPos pos) {
        return world.isStateAtPosition(pos, JalsphireCrystalHelper::canGenerate);
    }

    protected static boolean canGenerateOrLava(LevelAccessor world, BlockPos pos) {
        return world.isStateAtPosition(pos, JalsphireCrystalHelper::canGenerateOrLava);
    }

    protected static void getDripstoneThickness(Direction direction, int height, boolean merge, Consumer<BlockState> callback) {
        if (height >= 3) {
            callback.accept(JalsphireCrystalHelper.getState(direction, DripstoneThickness.BASE));
            for (int i = 0; i < height - 3; ++i) {
                callback.accept(JalsphireCrystalHelper.getState(direction, DripstoneThickness.MIDDLE));
            }
        }
        if (height >= 2) {
            callback.accept(JalsphireCrystalHelper.getState(direction, DripstoneThickness.FRUSTUM));
        }
        if (height >= 1) {
            callback.accept(JalsphireCrystalHelper.getState(direction, merge ? DripstoneThickness.TIP_MERGE : DripstoneThickness.TIP));
        }
    }

    protected static void generatePointedDripstone(LevelAccessor world, BlockPos pos, Direction direction, int height, boolean merge) {
        if (!JalsphireCrystalHelper.canReplace(world.getBlockState(pos.relative(direction.getOpposite())))) {
            return;
        }
        MutableBlockPos mutable = pos.mutable();
        JalsphireCrystalHelper.getDripstoneThickness(direction, height, merge, state -> {
            if (state.is(LirothBlocks.POINTED_JALSPHIRE_CRYSTAL.get())) {
                state = (BlockState)state.setValue(PointedJalsphireCrystal.WATERLOGGED, world.isWaterAt(mutable));
            }
            world.setBlock(mutable, (BlockState)state, Block.UPDATE_NEIGHBORS);
            mutable.move(direction);
        });
    }

    protected static boolean generateDripstoneBlock(LevelAccessor world, BlockPos pos) {
        BlockState blockState = world.getBlockState(pos);
        if (blockState.is(BlockTags.DRIPSTONE_REPLACEABLE)) {
            world.setBlock(pos, LirothBlocks.JALSPHIRE_CRYSTAL_BLOCK.get().defaultBlockState(), Block.UPDATE_NEIGHBORS);
            return true;
        }
        return false;
    }

    private static BlockState getState(Direction direction, DripstoneThickness thickness) {
        return (BlockState)((BlockState)LirothBlocks.POINTED_JALSPHIRE_CRYSTAL.get().defaultBlockState().setValue(PointedJalsphireCrystal.TIP_DIRECTION, direction)).setValue(PointedJalsphireCrystal.THICKNESS, thickness);
    }

    public static boolean canReplaceOrLava(BlockState state) {
        return JalsphireCrystalHelper.canReplace(state) || state.is(Blocks.LAVA);
    }

    public static boolean canReplace(BlockState state) {
        return state.is(LirothBlocks.JALSPHIRE_CRYSTAL_BLOCK.get()) || state.is(BlockTags.DRIPSTONE_REPLACEABLE);
    }

    public static boolean canGenerate(BlockState state) {
        return state.isAir() || state.is(Blocks.WATER);
    }

    public static boolean canGenerateOrLava(BlockState state) {
        return state.isAir() || state.is(Blocks.WATER) || state.is(Blocks.LAVA);
    }
}