package com.decodinator.liroth.core.blocks;

import com.decodinator.liroth.core.LirothBlockEntities;
import com.decodinator.liroth.core.blocks.entities.JapzChestBlockEntity;
import com.decodinator.liroth.core.helpers.IChestBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class JapzChestBlock extends ChestBlock implements IChestBlock {
	public final String type;

	public JapzChestBlock(String type, Properties props) {
		super(props, LirothBlockEntities.JAPZ_CHEST::get);
		this.type = type;
	}

	@Override
	public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return false;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new JapzChestBlockEntity(pos, state);
	}

	@Override
	public String getChestType() {
		return type;
	}
}