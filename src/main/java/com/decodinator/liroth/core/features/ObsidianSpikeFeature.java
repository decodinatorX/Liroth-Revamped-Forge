package com.decodinator.liroth.core.features;

import com.decodinator.liroth.core.LirothBlocks;
import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.StructureAccess;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class ObsidianSpikeFeature
extends Feature<NoneFeatureConfiguration> {
    public ObsidianSpikeFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        int l;
        int k;
        BlockPos blockPos = context.origin();
        RandomSource random = context.random();
        WorldGenLevel structureWorldAccess = context.level();
        while (structureWorldAccess.isEmptyBlock(blockPos) && blockPos.getY() > structureWorldAccess.getMinBuildHeight() + 2) {
            blockPos = blockPos.below();
        }
        if (!structureWorldAccess.getBlockState(blockPos).is(Blocks.GRASS_BLOCK)) {
            return false;
        }
        blockPos = blockPos.above(random.nextInt(4));
        int i = random.nextInt(4) + 7;
        int j = i / 4 + random.nextInt(2);
        if (j > 1 && random.nextInt(60) == 0) {
            blockPos = blockPos.above(10 + random.nextInt(30));
        }
        for (k = 0; k < i; ++k) {
            float f = (1.0f - (float)k / (float)i) * (float)j;
            l = Mth.ceil(f);
            for (int m = -l; m <= l; ++m) {
                float g = (float)Mth.abs(m) - 0.25f;
                for (int n = -l; n <= l; ++n) {
                    float h = (float)Mth.abs(n) - 0.25f;
                    if ((m != 0 || n != 0) && g * g + h * h > f * f || (m == -l || m == l || n == -l || n == l) && random.nextFloat() > 0.75f) continue;
                    BlockState blockState = structureWorldAccess.getBlockState(blockPos.offset(m, k, n));
                    if (blockState.isAir() || ObsidianSpikeFeature.isDirt(blockState) || blockState.is(Blocks.GRASS_BLOCK) || blockState.is(Blocks.DIRT)) {
                        this.setBlock(structureWorldAccess, blockPos.offset(m, k, n), Blocks.OBSIDIAN.defaultBlockState());
                    }
                    if (k == 0 || l <= 1 || !(blockState = structureWorldAccess.getBlockState(blockPos.offset(m, -k, n))).isAir() && !ObsidianSpikeFeature.isDirt(blockState) && !blockState.is(Blocks.GRASS_BLOCK) && !blockState.is(Blocks.DIRT)) continue;
                    this.setBlock(structureWorldAccess, blockPos.offset(m, -k, n), Blocks.OBSIDIAN.defaultBlockState());
                }
            }
        }
        k = j - 1;
        if (k < 0) {
            k = 0;
        } else if (k > 1) {
            k = 1;
        }
        for (int o = -k; o <= k; ++o) {
            for (l = -k; l <= k; ++l) {
                BlockState blockState2;
                BlockPos blockPos2 = blockPos.offset(o, -1, l);
                int p = 50;
                if (Math.abs(o) == 1 && Math.abs(l) == 1) {
                    p = random.nextInt(5);
                }
                while (blockPos2.getY() > 50 && ((blockState2 = structureWorldAccess.getBlockState(blockPos2)).isAir() || ObsidianSpikeFeature.isDirt(blockState2) || blockState2.is(Blocks.GRASS_BLOCK) || blockState2.is(Blocks.DIRT) || blockState2.is(LirothBlocks.KOOLAW_LEAVES.get()))) {
                    this.setBlock(structureWorldAccess, blockPos2, Blocks.OBSIDIAN.defaultBlockState());
                    blockPos2 = blockPos2.below();
                    if (--p > 0) continue;
                    blockPos2 = blockPos2.below(random.nextInt(5) + 1);
                    p = random.nextInt(5);
                }
            }
        }
        return true;
    }
}