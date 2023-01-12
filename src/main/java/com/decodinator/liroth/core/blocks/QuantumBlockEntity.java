package com.decodinator.liroth.core.blocks;

import com.decodinator.liroth.core.LirothRecipeTypes;
import com.decodinator.liroth.core.blocks.entities.QuantumExtractorBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class QuantumBlockEntity extends QuantumExtractorBlockEntity {

   public QuantumBlockEntity(BlockPos p_155545_, BlockState p_155546_) {
      super(p_155545_, p_155546_, LirothRecipeTypes.QUANTUM_EXTRACTION.get());
   }
}