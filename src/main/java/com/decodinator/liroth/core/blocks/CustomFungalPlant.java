package com.decodinator.liroth.core.blocks;

import com.decodinator.liroth.core.LirothBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FungusBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class CustomFungalPlant extends FungusBlock {

	public CustomFungalPlant(BlockBehaviour.Properties settings, ResourceKey<ConfiguredFeature<?, ?>> feature, Block requiredBlock) {
		super(settings, feature, requiredBlock);
	}

    @Override
    protected boolean mayPlaceOn(BlockState floor, BlockGetter world, BlockPos pos) {
        return floor.is(LirothBlocks.DAMNATION_SOIL.get()) || /* floor.isOf(Blocks.MYCELIUM) || floor.isOf(Blocks.SOUL_SOIL) ||*/ super.mayPlaceOn(floor, world, pos);
    }
	
}
