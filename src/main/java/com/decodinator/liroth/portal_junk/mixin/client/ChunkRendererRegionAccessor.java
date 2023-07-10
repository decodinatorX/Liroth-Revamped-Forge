package com.decodinator.liroth.portal_junk.mixin.client;

import net.minecraft.client.renderer.chunk.RenderChunkRegion;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value = RenderChunkRegion.class, remap=false)
public interface ChunkRendererRegionAccessor {

    @Accessor("level")
    Level getWorld();

}
