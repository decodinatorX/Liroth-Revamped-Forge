package com.decodinator.liroth;

import com.decodinator.liroth.core.LirothEntities;
import com.decodinator.liroth.core.LirothEntityRenderers;
import com.decodinator.liroth.core.LirothModelLayers;
import com.decodinator.liroth.core.LirothEntityRenderers.RegisterStrategy;
import com.decodinator.liroth.core.entities.renderers.BeamLaserProjectileEntityRenderer;
import com.decodinator.liroth.core.entities.renderers.ForsakenCorpseEntityRenderer;
import com.decodinator.liroth.core.entities.renderers.ForsakenCorpseModel;
import com.decodinator.liroth.core.entities.renderers.FreakshowEntityRenderer;
import com.decodinator.liroth.core.entities.renderers.FreakshowModel;
import com.decodinator.liroth.core.entities.renderers.FungalFiendEntityRenderer;
import com.decodinator.liroth.core.entities.renderers.FungalFiendModel;
import com.decodinator.liroth.core.entities.renderers.LirothianMimicEntityRenderer;
import com.decodinator.liroth.core.entities.renderers.LirothianMimicModel;
import com.decodinator.liroth.core.entities.renderers.PierPeepEntityRenderer;
import com.decodinator.liroth.core.entities.renderers.PierPeepModel;
import com.decodinator.liroth.core.entities.renderers.ProwlerEntityRenderer;
import com.decodinator.liroth.core.entities.renderers.ProwlerModel;
import com.decodinator.liroth.core.entities.renderers.ShadeEntityRenderer;
import com.decodinator.liroth.core.entities.renderers.ShadeModel;
import com.decodinator.liroth.core.entities.renderers.SkeletalFreakEntityRenderer;
import com.decodinator.liroth.core.entities.renderers.SkeletalFreakModel;
import com.decodinator.liroth.core.entities.renderers.SoulArachnidEntityRenderer;
import com.decodinator.liroth.core.entities.renderers.SoulArachnidModel;
import com.decodinator.liroth.core.entities.renderers.VileSharkEntityRenderer;
import com.decodinator.liroth.core.entities.renderers.VileSharkModel;
import com.decodinator.liroth.core.entities.renderers.WarpEntityRenderer;
import com.decodinator.liroth.core.entities.renderers.WarpModel;

import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
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
    public static void registerLayerDefinitionsAgain(EntityRenderersEvent.RegisterLayerDefinitions event) {
    	event.registerLayerDefinition(LirothModelLayers.FORSAKEN_CORPSE, () -> ForsakenCorpseModel.getTexturedModelData());
    	event.registerLayerDefinition(LirothModelLayers.FREAKSHOW, () -> FreakshowModel.getTexturedModelData());
    	event.registerLayerDefinition(LirothModelLayers.FUNGAL_FIEND, () -> FungalFiendModel.getTexturedModelData());
    	event.registerLayerDefinition(LirothModelLayers.LIROTHIAN_MIMIC, () -> LirothianMimicModel.getTexturedModelData());
    	event.registerLayerDefinition(LirothModelLayers.PIER_PEEP, () -> PierPeepModel.getTexturedModelData());
    	event.registerLayerDefinition(LirothModelLayers.PROWLER, () -> ProwlerModel.getTexturedModelData());
    	event.registerLayerDefinition(LirothModelLayers.SHADE, () -> ShadeModel.getTexturedModelData());
    	event.registerLayerDefinition(LirothModelLayers.SKELETAL_FREAK, () -> SkeletalFreakModel.getTexturedModelData());
    	event.registerLayerDefinition(LirothModelLayers.SOUL_ARACHNID, () -> SoulArachnidModel.getTexturedModelData());
    	event.registerLayerDefinition(LirothModelLayers.VILE_SHARK, () -> VileSharkModel.getTexturedModelData());
    	event.registerLayerDefinition(LirothModelLayers.WARP, () -> WarpModel.getTexturedModelData());
    }
    
    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
    	event.registerEntityRenderer(LirothEntities.FORSAKEN_CORPSE.get(), ForsakenCorpseEntityRenderer::new);
    	event.registerEntityRenderer(LirothEntities.FREAKSHOW.get(), FreakshowEntityRenderer::new);
    	event.registerEntityRenderer(LirothEntities.FUNGAL_FIEND.get(), FungalFiendEntityRenderer::new);
    	event.registerEntityRenderer(LirothEntities.LIROTHIAN_MIMIC.get(), LirothianMimicEntityRenderer::new);
    	event.registerEntityRenderer(LirothEntities.PIER_PEEP.get(), PierPeepEntityRenderer::new);
    	event.registerEntityRenderer(LirothEntities.PROWLER.get(), ProwlerEntityRenderer::new);
    	event.registerEntityRenderer(LirothEntities.SHADE.get(), ShadeEntityRenderer::new);
    	event.registerEntityRenderer(LirothEntities.SKELETAL_FREAK.get(), SkeletalFreakEntityRenderer::new);
    	event.registerEntityRenderer(LirothEntities.SOUL_ARACHNID.get(), SoulArachnidEntityRenderer::new);
    	event.registerEntityRenderer(LirothEntities.VILE_SHARK.get(), VileSharkEntityRenderer::new);
    	event.registerEntityRenderer(LirothEntities.WARP.get(), WarpEntityRenderer::new);
    	event.registerEntityRenderer(LirothEntities.BEAM_LASER_PROJECTILE.get(), BeamLaserProjectileEntityRenderer::new);
    }
}