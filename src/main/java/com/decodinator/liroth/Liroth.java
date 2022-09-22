package com.decodinator.liroth;

import com.decodinator.liroth.core.LirothBlocks;
import com.decodinator.liroth.core.LirothBoat;
import com.decodinator.liroth.core.LirothBoatModel;
import com.decodinator.liroth.core.LirothEntities;
import com.decodinator.liroth.core.LirothEntityRenderers;
import com.decodinator.liroth.core.LirothEntityRenderers.RegisterStrategy;
import com.decodinator.liroth.core.LirothItems;
import com.decodinator.liroth.core.LirothModelLayers;
import com.decodinator.liroth.core.LirothRenders;
import com.decodinator.liroth.core.LirothSounds;
import com.decodinator.liroth.core.PotestiumHelmetItem;
import com.decodinator.liroth.core.PotestiumHelmetModel;
import com.decodinator.liroth.mixin.ItemBlockRenderTypeAccess;
import com.mojang.logging.LogUtils;
import com.teamabnormals.blueprint.client.renderer.BlueprintBoatRenderer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

import org.slf4j.Logger;
import net.minecraftforge.api.distmarker.Dist;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Liroth.MOD_ID)
public class Liroth
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "liroth";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();
    
	public static CreativeModeTab liroth_blocks_tab = new CreativeModeTab(Liroth.MOD_ID + ".liroth_blocks") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(LirothBlocks.LIROTH_GEM_BLOCK.get());
		}
	};
	
	public static CreativeModeTab liroth_items_tab = new CreativeModeTab(Liroth.MOD_ID + ".liroth_items") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(LirothItems.LIROTH_GEM.get());
		}
	};
    
	public static CreativeModeTab liroth_combat_tab = new CreativeModeTab(Liroth.MOD_ID + ".liroth_combat") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(LirothItems.LIROTH_GEM_ANSALUM.get());
		}
	};
	
    public Liroth()
    {
    	

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
        // Register the Deferred Register to the mod event bus so blocks get registered
		LirothBlocks.BLOCKS.register(modEventBus);
		LirothBlocks.ITEMS.register(modEventBus);
		LirothItems.ITEMS.register(modEventBus);
		LirothEntities.ENTITIES.register(modEventBus);
		LirothSounds.SOUND_EVENTS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so items get registered
//        ITEMS.register(modEventBus);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Some common setup code
//        LOGGER.info("HELLO FROM COMMON SETUP");
//        LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
//        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
    		LirothRenders.renderCutOuts();
            Liroth.registerLayerDefinitions(ForgeHooksClient::registerLayerDefinition);
//            Some client setup code
//            LOGGER.info("HELLO FROM CLIENT SETUP");
//            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
    
    public static ResourceLocation createLocation(String path) {
        return new ResourceLocation(MOD_ID, path);
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
    
    public static ModelLayerLocation createBoatModelName(LirothBoat.Type p_171290_) {
        return createLocation(Liroth.MOD_ID + "boat/" + p_171290_.getName(), "main");
     }
    
    public static ModelLayerLocation createChestBoatModelName(LirothBoat.Type p_233551_) {
        return createLocation(Liroth.MOD_ID + "chest_boat/" + p_233551_.getName(), "main");
     }
    
    public static void registerLayerDefinitions(final BiConsumer<ModelLayerLocation, Supplier<LayerDefinition>> consumer) {
        for (LirothBoat.Type value : LirothBoat.Type.values()) {
            consumer.accept(Liroth.createBoatModelName(value), () -> LirothBoatModel.createBodyModel(false));
            consumer.accept(Liroth.createChestBoatModelName(value), () -> LirothBoatModel.createBodyModel(true));
    		consumer.accept(LirothModelLayers.POTESTIUM_HELMET, () -> LayerDefinition.create(PotestiumHelmetModel.createMesh(), 64, 128));
        }
    }
}
