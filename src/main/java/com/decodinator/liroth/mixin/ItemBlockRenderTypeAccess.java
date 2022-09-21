package com.decodinator.liroth.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Map;

@Mixin(RenderType.class)
public interface ItemBlockRenderTypeAccess {

    @Accessor("BLOCKS")
    static Map<RegistryObject<Block>, RenderType> getTypeByBlock() {
        throw new Error("Mixin did not apply");
    }
}