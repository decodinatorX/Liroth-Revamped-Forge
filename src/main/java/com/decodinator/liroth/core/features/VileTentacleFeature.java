package com.decodinator.liroth.core.features;

import com.decodinator.liroth.core.LirothBlocks;
import com.decodinator.liroth.core.blocks.VileTentacleTipBlock;
import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class VileTentacleFeature 
extends Feature<NoneFeatureConfiguration> {
    public VileTentacleFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        int i = 0;
        WorldGenLevel structureWorldAccess = context.level();
        BlockPos blockPos = context.origin();
        RandomSource random = context.random();
        int j = structureWorldAccess.getHeight(Heightmap.Types.OCEAN_FLOOR, blockPos.getX(), blockPos.getZ());
        BlockPos blockPos2 = new BlockPos(blockPos.getX(), j, blockPos.getZ());
        if (structureWorldAccess.getBlockState(blockPos2).is(LirothBlocks.LIROTH_FLUID_BLOCK.get())) {
            BlockState blockState = LirothBlocks.VILE_TENTACLE_TIP.get().defaultBlockState();
            BlockState blockState2 = LirothBlocks.VILE_TENTACLE.get().defaultBlockState();
            int k = 1 + random.nextInt(10);
            for (int l = 0; l <= k; ++l) {
                if (structureWorldAccess.getBlockState(blockPos2).is(LirothBlocks.LIROTH_FLUID_BLOCK.get()) && structureWorldAccess.getBlockState(blockPos2.above()).is(LirothBlocks.LIROTH_FLUID_BLOCK.get()) && blockState2.canSurvive(structureWorldAccess, blockPos2)) {
                    if (l == k) {
                        structureWorldAccess.setBlock(blockPos2, (BlockState)blockState.setValue(VileTentacleTipBlock.AGE, random.nextInt(4) + 20), Block.UPDATE_NEIGHBORS);
                        ++i;
                    } else {
                        structureWorldAccess.setBlock(blockPos2, blockState2, Block.UPDATE_NEIGHBORS);
                    }
                } else if (l > 0) {
                    BlockPos blockPos3 = blockPos2.below();
                    if (!blockState.canSurvive(structureWorldAccess, blockPos3) || structureWorldAccess.getBlockState(blockPos3.below()).is(LirothBlocks.VILE_TENTACLE_TIP.get())) break;
                    structureWorldAccess.setBlock(blockPos3, (BlockState)blockState.setValue(VileTentacleTipBlock.AGE, random.nextInt(4) + 20), Block.UPDATE_NEIGHBORS);
                    ++i;
                    break;
                }
                blockPos2 = blockPos2.above();
            }
        }
        return i > 0;
    }
}