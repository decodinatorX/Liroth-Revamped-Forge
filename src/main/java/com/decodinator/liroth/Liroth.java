package com.decodinator.liroth;

import com.decodinator.liroth.core.LirothBlockEntities;
import com.decodinator.liroth.core.LirothBlocks;
import com.decodinator.liroth.core.LirothBoat;
import com.decodinator.liroth.core.LirothBoatModel;
import com.decodinator.liroth.core.LirothConfiguredFeatures;
import com.decodinator.liroth.core.LirothEntities;
import com.decodinator.liroth.core.LirothEntityRenderers;
import com.decodinator.liroth.core.LirothFluidTypes;
import com.decodinator.liroth.core.LirothFluids;
import com.decodinator.liroth.core.LirothEntityRenderers.RegisterStrategy;
import com.decodinator.liroth.core.LirothFeatures;
import com.decodinator.liroth.core.LirothItems;
import com.decodinator.liroth.core.LirothMenuTypes;
import com.decodinator.liroth.core.LirothModelLayers;
import com.decodinator.liroth.core.LirothParticles;
import com.decodinator.liroth.core.LirothPlacedFeatures;
import com.decodinator.liroth.core.LirothRenders;
import com.decodinator.liroth.core.LirothSounds;
import com.decodinator.liroth.core.blocks.entities.LirothSplitterScreenHandler;
import com.decodinator.liroth.core.blocks.entities.screens.LirothSplitterScreen;
import com.decodinator.liroth.core.blocks.entities.screens.QuantumExtractorScreen;
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
import com.decodinator.liroth.core.items.PotestiumHelmetItem;
import com.decodinator.liroth.core.renders.PotestiumHelmetModel;
import com.decodinator.liroth.mixin.ItemBlockRenderTypeAccess;
import com.mojang.logging.LogUtils;
import com.mojang.serialization.Codec;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.core.Holder;
import net.minecraft.core.RegistryAccess.RegistryEntry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fluids.ForgeFlowingFluid;
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

import java.util.Arrays;
import java.util.List;
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
        
	public static final ForgeFlowingFluid.Properties LIROTH_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(LirothFluidTypes.LIROTH_FLUID_TYPE, LirothFluids.LIROTH_FLUID, LirothFluids.FLOWING_LIROTH_FLUID).slopeFindDistance(2).levelDecreasePerBlock(2).block(LirothBlocks.LIROTH_FLUID_BLOCK).bucket(LirothItems.LIROTH_FLUID_BUCKET);
	public static final ForgeFlowingFluid.Properties MOLTEN_SPINERIOS_PROPERTIES = new ForgeFlowingFluid.Properties(LirothFluidTypes.MOLTEN_SPINERIOS_TYPE, LirothFluids.MOLTEN_SPINERIOS, LirothFluids.FLOWING_MOLTEN_SPINERIOS).slopeFindDistance(2).levelDecreasePerBlock(2).block(LirothBlocks.MOLTEN_SPINERIOS_BLOCK).bucket(LirothItems.MOLTEN_SPINERIOS_BUCKET);
    
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
			return new ItemStack(LirothItems.LIROTH_SWORD.get());
		}
	};
	
	public static CreativeModeTab liroth_entities_tab = new CreativeModeTab(Liroth.MOD_ID + ".liroth_entities") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(LirothItems.FORSAKEN_CORPSE_SPAWN_EGG.get());
		}
	};
	
	public static CreativeModeTab liroth_plants_tab = new CreativeModeTab(Liroth.MOD_ID + ".liroth_plants") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(LirothBlocks.LIROTH_ROSE.get());
		}
	};
	
    public static final RuleTest END_STONE = new BlockMatchTest(Blocks.END_STONE);
	
    public Liroth()
    {
    	

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
        // Register the Deferred Register to the mod event bus so blocks get registered
		LirothParticles.PARTICLES.register(modEventBus);
		LirothEntities.ENTITIES_TYPES.register(modEventBus);
		LirothBlocks.BLOCKS.register(modEventBus);
		LirothMenuTypes.MENUS.register(modEventBus);
		LirothBlockEntities.BLOCK_ENTITIES.register(modEventBus);
		LirothBlocks.ITEMS.register(modEventBus);
		LirothItems.ITEMS.register(modEventBus);
		LirothSounds.SOUND_EVENTS.register(modEventBus);
		LirothFluidTypes.FLUID_TYPES.register(modEventBus);
		LirothFluids.FLUIDS.register(modEventBus);
		LirothFeatures.FEATURES.register(modEventBus);
		LirothConfiguredFeatures.CONFIGURED_FEATURES.register(modEventBus);
		LirothPlacedFeatures.PLACED_FEATURES.register(modEventBus);
        // Register the Deferred Register to the mod event bus so items get registered
//        ITEMS.register(modEventBus);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        MenuScreens.register(LirothMenuTypes.LIROTH_SPLITTER_MENU.get(), LirothSplitterScreen::new);
        MenuScreens.register(LirothMenuTypes.QUANTUM_EXTRACTOR_MENU.get(), QuantumExtractorScreen::new);
//    	ForgeRegistries.MENU_TYPES.register(Liroth.QUANTUM_EXTRACTOR_SCREEN_HANDLER, QuantumExtractorScreen::new);
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
            ItemBlockRenderTypes.setRenderLayer(LirothFluids.LIROTH_FLUID.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(LirothFluids.FLOWING_LIROTH_FLUID.get(), RenderType.translucent());
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
    		consumer.accept(LirothModelLayers.FORSAKEN_CORPSE, () -> ForsakenCorpseModel.getTexturedModelData());
    		consumer.accept(LirothModelLayers.FREAKSHOW, () -> FreakshowModel.getTexturedModelData());
    		consumer.accept(LirothModelLayers.FUNGAL_FIEND, () -> FungalFiendModel.getTexturedModelData());
    		consumer.accept(LirothModelLayers.LIROTHIAN_MIMIC, () -> LirothianMimicModel.getTexturedModelData());
    		consumer.accept(LirothModelLayers.PIER_PEEP, () -> PierPeepModel.getTexturedModelData());
    		consumer.accept(LirothModelLayers.PROWLER, () -> ProwlerModel.getTexturedModelData());
    		consumer.accept(LirothModelLayers.SHADE, () -> ShadeModel.getTexturedModelData());
    		consumer.accept(LirothModelLayers.SKELETAL_FREAK, () -> SkeletalFreakModel.getTexturedModelData());
    		consumer.accept(LirothModelLayers.SOUL_ARACHNID, () -> SoulArachnidModel.getTexturedModelData());
    		consumer.accept(LirothModelLayers.VILE_SHARK, () -> VileSharkModel.getTexturedModelData());
    		consumer.accept(LirothModelLayers.WARP, () -> WarpModel.getTexturedModelData());
        }
    }

}
