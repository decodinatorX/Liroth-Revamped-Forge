package com.decodinator.liroth.core;

import org.jetbrains.annotations.NotNull;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;

public class LirothEntityRenderers {

    public static <T extends Entity> void register(RegisterStrategy registerStrategy) {
        registerStrategy.register(LirothEntities.LIROTH_BOAT.get(), (EntityRendererProvider.Context context) -> new LirothBoatRenderer(context, false));
        registerStrategy.register(LirothEntities.LIROTH_CHEST_BOAT.get(), (EntityRendererProvider.Context context) -> new LirothBoatRenderer(context, true));
    }

    @FunctionalInterface
    public interface RegisterStrategy {
        <T extends Entity> void register(EntityType<? extends T> entityType, EntityRendererProvider<T> entityRendererProvider);
    }
}
