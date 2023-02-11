package com.decodinator.liroth.core;

import org.jetbrains.annotations.NotNull;

import com.decodinator.liroth.core.entities.renderers.ForsakenCorpseEntityRenderer;
import com.decodinator.liroth.core.entities.renderers.FreakshowEntityRenderer;
import com.decodinator.liroth.core.entities.renderers.FungalFiendEntityRenderer;
import com.decodinator.liroth.core.entities.renderers.LirothianMimicEntityRenderer;
import com.decodinator.liroth.core.entities.renderers.PierPeepEntityRenderer;
import com.decodinator.liroth.core.entities.renderers.ProwlerEntityRenderer;
import com.decodinator.liroth.core.entities.renderers.ShadeEntityRenderer;
import com.decodinator.liroth.core.entities.renderers.SkeletalFreakEntityRenderer;
import com.decodinator.liroth.core.entities.renderers.SoulArachnidEntityRenderer;
import com.decodinator.liroth.core.entities.renderers.VileSharkEntityRenderer;
import com.decodinator.liroth.core.entities.renderers.WarpEntityRenderer;
import com.decodinator.liroth.core.renders.LirothBoatRenderer;

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
