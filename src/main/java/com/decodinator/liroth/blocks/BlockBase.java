package com.decodinator.liroth.blocks;

import com.decodinator.liroth.core.LirothBlocks;
import com.decodinator.liroth.core.LirothItems;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block {

	public BlockBase(String name, Material materialIn) {
		super(materialIn);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MISC);
		
		LirothBlocks.BLOCKS.add(this);
		LirothItems.BLOCKITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
}
