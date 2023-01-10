package com.decodinator.liroth.core.helpers;

import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.resources.ResourceLocation;

public interface ItemModelProvider {
    default BlockModel getItemModel(ResourceLocation resourceLocation) {
        return ModelsHelper.createItemModel(resourceLocation);
    }
}