package com.decodinator.liroth.core.blocks;

import java.util.function.Supplier;

import com.decodinator.liroth.core.LirothBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.RegistryAccess.RegistryEntry;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.FungusBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.HugeFungusConfiguration;

public class CustomFungalPlant extends FungusBlock {

	public CustomFungalPlant(BlockBehaviour.Properties settings, Supplier<Holder<ConfiguredFeature<HugeFungusConfiguration, ?>>> feature) {
		super(settings, feature);
	}

    @Override
    protected boolean mayPlaceOn(BlockState floor, BlockGetter world, BlockPos pos) {
        return floor.is(LirothBlocks.DAMNATION_SOIL.get()) || /* floor.isOf(Blocks.MYCELIUM) || floor.isOf(Blocks.SOUL_SOIL) ||*/ super.mayPlaceOn(floor, world, pos);
    }
	
}
