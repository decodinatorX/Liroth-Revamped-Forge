package com.decodinator.liroth.core.features;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;

import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class LirothBoneClawFeature
extends LirothSkeletonFeature {
    public LirothBoneClawFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    protected boolean generateCoral(LevelAccessor world, RandomSource random, BlockPos pos, BlockState state) {
        if (!this.generateCoralPiece(world, random, pos, state)) {
            return false;
        }
        Direction direction = Direction.Plane.HORIZONTAL.getRandomDirection(random);
        int i = random.nextInt(2) + 2;
        ArrayList<Direction> list = Lists.newArrayList(direction, direction.getClockWise(), direction.getCounterClockWise());
        Collections.shuffle(list);
        List<Direction> list2 = list.subList(0, i);
        block0: for (Direction direction2 : list2) {
            int l;
            int k;
            Direction direction3;
            MutableBlockPos mutable = pos.mutable();
            int j = random.nextInt(2) + 1;
            mutable.move(direction2);
            if (direction2 == direction) {
                direction3 = direction;
                k = random.nextInt(3) + 2;
            } else {
                mutable.move(Direction.UP);
                Direction[] directions = new Direction[]{direction2, Direction.UP};
                direction3 = Util.getRandom(directions, random);
                k = random.nextInt(3) + 3;
            }
            for (l = 0; l < j && this.generateCoralPiece(world, random, mutable, state); ++l) {
                mutable.move(direction3);
            }
            mutable.move(direction3.getOpposite());
            mutable.move(Direction.UP);
            for (l = 0; l < k; ++l) {
                mutable.move(direction);
                if (!this.generateCoralPiece(world, random, mutable, state)) continue block0;
                if (!(random.nextFloat() < 0.25f)) continue;
                mutable.move(Direction.UP);
            }
        }
        return true;
    }
}