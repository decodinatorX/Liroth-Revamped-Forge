package com.decodinator.liroth.core.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.level.block.state.BlockState;

public class LirothFarmBlock extends FarmBlock {
	
    public LirothFarmBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource random) {
    	serverLevel.setBlock(blockPos, blockState.setValue(MOISTURE, 7), 2);
    }

}
