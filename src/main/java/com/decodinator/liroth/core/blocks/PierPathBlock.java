package com.decodinator.liroth.core.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DirtPathBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PierPathBlock
extends DirtPathBlock {
    protected static final VoxelShape SHAPE = Block.box(0.0, 0.0, 0.0, 16.0, 15.0, 16.0);

    public PierPathBlock(BlockBehaviour.Properties settings) {
        super(settings);
    }
}

