package com.decodinator.liroth.items;

import com.decodinator.liroth.core.LirothItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item {

	public ItemBase(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MISC);
		
		LirothItems.ITEMS.add(this);
	}	
}