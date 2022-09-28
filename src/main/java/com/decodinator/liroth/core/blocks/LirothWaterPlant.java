package com.decodinator.liroth.core.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import com.decodinator.liroth.core.LirothFluids;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;

public class LirothWaterPlant extends LirothDeadPlantBlock {
    private final Block deadCoralBlock;

    public LirothWaterPlant(Block deadCoralBlock, Block.Properties settings) {
        super(settings);
        this.deadCoralBlock = deadCoralBlock;
    }

    @Override
    public void tick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        if (!LirothWaterPlant.scanForWater(state, world, pos)) {
            world.setBlock(pos, (BlockState)this.deadCoralBlock.defaultBlockState().setValue(WATERLOGGED, false), Block.UPDATE_NEIGHBORS);
        }
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor world, BlockPos pos, BlockPos neighborPos) {
        if (direction == Direction.DOWN && !state.canSurvive(world, pos)) {
            return Blocks.AIR.defaultBlockState();
        }
        this.canSurvive(state, world, pos);
        if (state.getValue(WATERLOGGED).booleanValue()) {
            world.scheduleTick(pos, LirothFluids.LIROTH_FLUID.get(), LirothFluids.LIROTH_FLUID.get().getTickDelay(world));
        }
        return super.updateShape(state, direction, neighborState, world, pos, neighborPos);
    }
}