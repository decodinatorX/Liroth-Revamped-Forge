package com.decodinator.liroth.core.items;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class UnusedItem extends Item {

	public UnusedItem(Properties p_41383_) {
		super(p_41383_);
	}
	
    @Override
    public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> p_41423_, TooltipFlag p_41424_) {
    	p_41423_.add(Component.translatable("item.liroth.anomaly_charge.desc"));
    }
}
