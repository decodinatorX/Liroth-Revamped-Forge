package com.decodinator.liroth.core.features;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class LirothBoneMushroomFeature
extends LirothSkeletonFeature {
    public LirothBoneMushroomFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    protected boolean generateCoral(LevelAccessor world, RandomSource random, BlockPos pos, BlockState state) {
        int i = random.nextInt(3) + 3;
        int j = random.nextInt(3) + 3;
        int k = random.nextInt(3) + 3;
        int l = random.nextInt(3) + 1;
        MutableBlockPos mutable = pos.mutable();
        for (int m = 0; m <= j; ++m) {
            for (int n = 0; n <= i; ++n) {
                for (int o = 0; o <= k; ++o) {
                    mutable.set(m + pos.getX(), n + pos.getY(), o + pos.getZ());
                    mutable.move(Direction.DOWN, l);
                    if ((m != 0 && m != j || n != 0 && n != i) && (o != 0 && o != k || n != 0 && n != i) && (m != 0 && m != j || o != 0 && o != k) && (m == 0 || m == j || n == 0 || n == i || o == 0 || o == k) && !(random.nextFloat() < 0.1f) && this.generateCoralPiece(world, random, mutable, state)) continue;
                }
            }
        }
        return true;
    }
}