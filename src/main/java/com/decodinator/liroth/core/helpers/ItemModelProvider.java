package com.decodinator.liroth.core.helpers;

import com.decodinator.liroth.Liroth;

import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

public interface ItemModelProvider {
    default BlockModel getItemModel(ResourceLocation resourceLocation) {
        return ModelsHelper.createItemModel(resourceLocation);
    }
}