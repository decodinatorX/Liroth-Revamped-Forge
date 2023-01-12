package com.decodinator.liroth.core.blocks;

import com.decodinator.liroth.core.LirothRecipeTypes;
import com.decodinator.liroth.core.blocks.entities.LirothSplitterBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class SplitterBlockEntity extends LirothSplitterBlockEntity {

   public SplitterBlockEntity(BlockPos p_155545_, BlockState p_155546_) {
      super(p_155545_, p_155546_, LirothRecipeTypes.LIROTH_SPLITTING.get());
   }
}