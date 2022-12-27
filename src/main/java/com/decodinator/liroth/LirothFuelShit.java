package com.decodinator.liroth;

import com.decodinator.liroth.core.LirothBlocks;
import com.decodinator.liroth.core.LirothItems;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Liroth.MOD_ID)
public class LirothFuelShit {
    @SubscribeEvent
    public static void modifyFuelBurnTime(FurnaceFuelBurnTimeEvent event) {
        ItemStack stack = event.getItemStack();
        Item item = stack.getItem();
        if (item == LirothItems.LIROTHIAN_PETROLEUM.get()) {event.setBurnTime(1600);}
        if (item == LirothBlocks.LIROTHIAN_PETROLEUM_BLOCK.get().asItem()) {event.setBurnTime(16000);}
        if (item == LirothBlocks.DAMNATION_FUNGAL_CLUSTER.get().asItem()) {event.setBurnTime(3200);}
        if (item == LirothBlocks.DAMNATION_FUNGUS.get().asItem()) {event.setBurnTime(1600);}
    }
}
