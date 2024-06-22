package com.decodinator.liroth;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

import com.decodinator.liroth.core.LirothBlockEntities;
import com.decodinator.liroth.core.LirothBoat;
import com.decodinator.liroth.core.LirothBoatModel;
import com.decodinator.liroth.core.LirothEntities;
import com.decodinator.liroth.core.LirothEntityRenderers;
import com.decodinator.liroth.core.LirothModelLayers;
import com.decodinator.liroth.core.LirothParticles;
import com.decodinator.liroth.core.blocks.FungalCampfireRenderer;
import com.decodinator.liroth.core.blocks.LirothianPetroleumCampfireRenderer;
import com.decodinator.liroth.core.entities.renderers.*;
import com.decodinator.liroth.core.particles.CloakParticle;
import com.decodinator.liroth.core.particles.DamnationPortalParticle;
import com.decodinator.liroth.core.particles.DevastatedPortalParticle;
import com.decodinator.liroth.core.particles.GreenFlameParticle;
import com.decodinator.liroth.core.particles.JalsphirePortalParticle;
import com.decodinator.liroth.core.particles.JantiroPortalParticle;
import com.decodinator.liroth.core.particles.LirothPortalParticle;
import com.decodinator.liroth.core.particles.PurpleFlameParticle;
import com.decodinator.liroth.core.particles.SporeParticle;
import com.decodinator.liroth.core.renders.LirothChestBlockEntityRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = Liroth.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class LirothForgeClientEventsHandler {

    @SubscribeEvent
    public static void Liroth_onEntityRenderersEvent$RegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        LirothEntityRenderers.register(event::registerEntityRenderer);
    }
    
    @SubscribeEvent
    public static void registerArmorRenderer(final EntityRenderersEvent.AddLayers event) {
    }
    
    @SubscribeEvent
    public static void registerLayerDefinitionsAgain(EntityRenderersEvent.RegisterLayerDefinitions event) {
    	event.registerLayerDefinition(LirothModelLayers.FREAKSHOW, () -> FreakshowModel.getTexturedModelData());
    	event.registerLayerDefinition(LirothModelLayers.LIROTHIAN_MIMIC, () -> LirothianMimicModel.getTexturedModelData());
    	event.registerLayerDefinition(LirothModelLayers.PIER_PEEP, () -> PierPeepModel.getTexturedModelData());
    	event.registerLayerDefinition(LirothModelLayers.SHADE, () -> ShadeModel.getTexturedModelData());
    	event.registerLayerDefinition(LirothModelLayers.VILE_SHARK, () -> VileSharkModel.getTexturedModelData());
		event.registerLayerDefinition(LirothModelLayers.MODEL_LIROTH_BOAT_LAYER, () -> LirothBoatModel.createBodyModel(false));
		event.registerLayerDefinition(LirothModelLayers.MODEL_CHEST_LIROTH_BOAT_LAYER, () -> LirothBoatModel.createBodyModel(true));
    }
    
    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
    	event.registerEntityRenderer(LirothEntities.FORSAKEN_CORPSE.get(), ForsakenCorpseRenderer::new);
    	event.registerEntityRenderer(LirothEntities.FREAKSHOW.get(), FreakshowEntityRenderer::new);
    	event.registerEntityRenderer(LirothEntities.FUNGAL_FIEND.get(), FungalFiendRenderer::new);
    	event.registerEntityRenderer(LirothEntities.LIROTHIAN_MIMIC.get(), LirothianMimicEntityRenderer::new);
    	event.registerEntityRenderer(LirothEntities.PIER_PEEP.get(), PierPeepEntityRenderer::new);
    	event.registerEntityRenderer(LirothEntities.PROWLER.get(), ProwlerRenderer::new);
    	event.registerEntityRenderer(LirothEntities.SHADE.get(), ShadeEntityRenderer::new);
    	event.registerEntityRenderer(LirothEntities.SKELETAL_FREAK.get(), SkeletalFreakRenderer::new);
    	event.registerEntityRenderer(LirothEntities.SOUL_ARACHNID.get(), SoulArachnidEntityRenderer::new);
    	event.registerEntityRenderer(LirothEntities.VILE_SHARK.get(), VileSharkEntityRenderer::new);
    	event.registerEntityRenderer(LirothEntities.WARP.get(), WarpRenderer::new);
    	event.registerEntityRenderer(LirothEntities.BEAM_LASER_PROJECTILE.get(), BeamLaserProjectileEntityRenderer::new);
    	event.registerBlockEntityRenderer(LirothBlockEntities.LIROTH_CHEST.get(), LirothChestBlockEntityRenderer::new);
    	event.registerBlockEntityRenderer(LirothBlockEntities.DAMNATION_CHEST.get(), LirothChestBlockEntityRenderer::new);
    	event.registerBlockEntityRenderer(LirothBlockEntities.JAPZ_CHEST.get(), LirothChestBlockEntityRenderer::new);
    	event.registerBlockEntityRenderer(LirothBlockEntities.KOOLAW_CHEST.get(), LirothChestBlockEntityRenderer::new);
    	event.registerBlockEntityRenderer(LirothBlockEntities.PETRIFIED_DAMNATION_CHEST.get(), LirothChestBlockEntityRenderer::new);
    	event.registerBlockEntityRenderer(LirothBlockEntities.SPICED_CHEST.get(), LirothChestBlockEntityRenderer::new);
    	event.registerBlockEntityRenderer(LirothBlockEntities.TALLPIER_CHEST.get(), LirothChestBlockEntityRenderer::new);
    	event.registerBlockEntityRenderer(LirothBlockEntities.FUNGAL_CAMPFIRE.get(), FungalCampfireRenderer::new);
    	event.registerBlockEntityRenderer(LirothBlockEntities.LIROTHIAN_PETROLEUM_CAMPFIRE.get(), LirothianPetroleumCampfireRenderer::new);
    }
    
    @SubscribeEvent
    public static void registerParticleFactories(final RegisterParticleProvidersEvent event) {
    	Minecraft.getInstance().particleEngine.register(LirothParticles.PURPLE_FLAME.get(), PurpleFlameParticle.Provider::new);
    	Minecraft.getInstance().particleEngine.register(LirothParticles.GREEN_FLAME.get(), GreenFlameParticle.Provider::new);
    	Minecraft.getInstance().particleEngine.register(LirothParticles.CLOAK.get(), CloakParticle.Provider::new);
    	Minecraft.getInstance().particleEngine.register(LirothParticles.SPORE.get(), SporeParticle.Provider::new);
    	Minecraft.getInstance().particleEngine.register(LirothParticles.LIROTH_PORTAL.get(), LirothPortalParticle.Provider::new);
    	Minecraft.getInstance().particleEngine.register(LirothParticles.DAMNATION_PORTAL.get(), DamnationPortalParticle.Provider::new);
    	Minecraft.getInstance().particleEngine.register(LirothParticles.JANTIRO_PORTAL.get(), JantiroPortalParticle.Provider::new);
    	Minecraft.getInstance().particleEngine.register(LirothParticles.JALSPHIRE_PORTAL.get(), JalsphirePortalParticle.Provider::new);
    	Minecraft.getInstance().particleEngine.register(LirothParticles.DEVASTATED_PORTAL.get(), DevastatedPortalParticle.Provider::new);
    }
    
    public static ModelLayerLocation createBoatModelName(LirothBoat.LirothType p_171290_) {
        return createLocation(Liroth.MOD_ID + "boat/" + p_171290_.getName(), "main");
     }
    
    public static ModelLayerLocation createChestBoatModelName(LirothBoat.LirothType p_233551_) {
        return createLocation(Liroth.MOD_ID + "chest_boat/" + p_233551_.getName(), "main");
     }
    
    
    public static ResourceLocation createLocation(String path) {
        return new ResourceLocation(Liroth.MOD_ID, path);
    }

    public static ResourceLocation createLocation(ResourceKey<?> path) {
        return path.location();
    }

    public static ResourceLocation createLocation(Holder<?> holder) {
        return createLocation(holder.unwrapKey().orElseThrow());
    }
    
    private static ModelLayerLocation createLocation(String p_171301_, String p_171302_) {
        return new ModelLayerLocation(new ResourceLocation("minecraft", p_171301_), p_171302_);
     }
    
    
    public static void registerLayerDefinitions(final BiConsumer<ModelLayerLocation, Supplier<LayerDefinition>> consumer) {
        for (LirothBoat.LirothType value : LirothBoat.LirothType.values()) {
            consumer.accept(createBoatModelName(value), () -> LirothBoatModel.createBodyModel(false));
        }
		for (LirothBoat.LirothType value : LirothBoat.LirothType.values()) {
			consumer.accept(createChestBoatModelName(value), () -> LirothBoatModel.createBodyModel(true));
		}
		consumer.accept(LirothModelLayers.FREAKSHOW, () -> FreakshowModel.getTexturedModelData());
		consumer.accept(LirothModelLayers.LIROTHIAN_MIMIC, () -> LirothianMimicModel.getTexturedModelData());
		consumer.accept(LirothModelLayers.PIER_PEEP, () -> PierPeepModel.getTexturedModelData());
		consumer.accept(LirothModelLayers.SHADE, () -> ShadeModel.getTexturedModelData());
		consumer.accept(LirothModelLayers.VILE_SHARK, () -> VileSharkModel.getTexturedModelData());
		consumer.accept(LirothModelLayers.MODEL_LIROTH_BOAT_LAYER, () -> LirothBoatModel.createBodyModel(false));
		consumer.accept(LirothModelLayers.MODEL_CHEST_LIROTH_BOAT_LAYER, () -> LirothBoatModel.createBodyModel(true));
    }
}