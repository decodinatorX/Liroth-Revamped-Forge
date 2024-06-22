package com.decodinator.liroth.core;

import com.decodinator.liroth.core.renders.LirothBoatRenderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;

public class LirothEntityRenderers {

    public static <T extends Entity> void register(RegisterStrategy registerStrategy) {
        registerStrategy.register(LirothEntities.LIROTH_BOAT.get(), (EntityRendererProvider.Context context) -> new LirothBoatRenderer(context, false));
        registerStrategy.register(LirothEntities.LIROTH_CHEST_BOAT.get(), (EntityRendererProvider.Context context) -> new LirothBoatRenderer(context, true));
/*        registerStrategy.register(LirothEntities.FORSAKEN_CORPSE.get(), (EntityRendererProvider.Context context) -> new ForsakenCorpseEntityRenderer(context));
        registerStrategy.register(LirothEntities.FREAKSHOW.get(), (EntityRendererProvider.Context context) -> new FreakshowEntityRenderer(context));
        registerStrategy.register(LirothEntities.FUNGAL_FIEND.get(), (EntityRendererProvider.Context context) -> new FungalFiendEntityRenderer(context));
        registerStrategy.register(LirothEntities.LIROTHIAN_MIMIC.get(), (EntityRendererProvider.Context context) -> new LirothianMimicEntityRenderer(context));
        registerStrategy.register(LirothEntities.PIER_PEEP.get(), (EntityRendererProvider.Context context) -> new PierPeepEntityRenderer(context));
        registerStrategy.register(LirothEntities.PROWLER.get(), (EntityRendererProvider.Context context) -> new ProwlerEntityRenderer(context));
        registerStrategy.register(LirothEntities.SHADE.get(), (EntityRendererProvider.Context context) -> new ShadeEntityRenderer(context));
        registerStrategy.register(LirothEntities.SKELETAL_FREAK.get(), (EntityRendererProvider.Context context) -> new SkeletalFreakEntityRenderer(context));
        registerStrategy.register(LirothEntities.SOUL_ARACHNID.get(), (EntityRendererProvider.Context context) -> new SoulArachnidEntityRenderer(context));
        registerStrategy.register(LirothEntities.VILE_SHARK.get(), (EntityRendererProvider.Context context) -> new VileSharkEntityRenderer(context));
        registerStrategy.register(LirothEntities.WARP.get(), (EntityRendererProvider.Context context) -> new WarpEntityRenderer(context));*/

    }

    @FunctionalInterface
    public interface RegisterStrategy {
        <T extends Entity> void register(EntityType<? extends T> entityType, EntityRendererProvider<T> entityRendererProvider);
    }
}
