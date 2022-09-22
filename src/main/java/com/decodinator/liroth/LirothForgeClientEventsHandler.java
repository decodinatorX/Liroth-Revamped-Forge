package com.decodinator.liroth;

import com.decodinator.liroth.core.LirothEntityRenderers;
import com.decodinator.liroth.core.LirothEntityRenderers.RegisterStrategy;

import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class LirothForgeClientEventsHandler {

    @SubscribeEvent
    public static void Liroth_onEntityRenderersEvent$RegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        LirothEntityRenderers.register(event::registerEntityRenderer);
    }
}