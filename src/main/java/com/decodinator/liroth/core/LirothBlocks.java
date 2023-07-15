package com.decodinator.liroth.core;

import com.decodinator.liroth.blocks.BlockBase;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class LirothBlocks {
	
	public static final List<Block> BLOCKS = new ArrayList<Block>();

	public static final Block LIROTH_GEM_BLOCK = new BlockBase("liroth_gem_block", Material.IRON).setHardness(1.5f).setResistance(5);
}