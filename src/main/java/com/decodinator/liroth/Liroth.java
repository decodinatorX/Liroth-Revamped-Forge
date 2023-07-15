package com.decodinator.liroth;

import com.decodinator.liroth.core.LirothBiomeModifiers;
import com.decodinator.liroth.core.LirothBlockEntities;
import com.decodinator.liroth.core.LirothBlocks;
import com.decodinator.liroth.core.LirothConfiguredFeatures;
import com.decodinator.liroth.core.LirothEntities;
import com.decodinator.liroth.core.LirothFluidTypes;
import com.decodinator.liroth.core.LirothFluids;
import com.decodinator.liroth.core.LirothFeatures;
import com.decodinator.liroth.core.LirothItems;
import com.decodinator.liroth.core.LirothMenuTypes;
import com.decodinator.liroth.core.LirothParticles;
import com.decodinator.liroth.core.LirothPlacedFeatures;
import com.decodinator.liroth.core.LirothPortalBuilders;
import com.decodinator.liroth.core.LirothRecipeTypes;
import com.decodinator.liroth.core.LirothSounds;
import com.decodinator.liroth.core.LirothStructures;
import com.decodinator.liroth.core.blocks.entities.screens.LirothSplitterScreen;
import com.decodinator.liroth.core.blocks.entities.screens.QuantumExtractorScreen;
import com.decodinator.liroth.portal_junk.CustomPortalApiRegistry;
import com.decodinator.liroth.portal_junk.CustomPortalBlock;
import com.decodinator.liroth.portal_junk.LirothPOIs;
import com.decodinator.liroth.portal_junk.networking.NetworkManager;
import com.decodinator.liroth.portal_junk.portal.PortalIgnitionSource;
import com.decodinator.liroth.portal_junk.portal.PortalPlacer;
import com.decodinator.liroth.portal_junk.portal.frame.FlatPortalAreaHelper;
import com.decodinator.liroth.portal_junk.portal.frame.VanillaPortalAreaHelper;
import com.decodinator.liroth.portal_junk.portal.linking.PortalLinkingStorage;
import com.mojang.logging.LogUtils;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.PathPackResources;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.event.server.ServerStartedEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.function.Supplier;

import org.slf4j.Logger;

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
    
	public static CreativeModeTab liroth_blocks_tab;
	public static CreativeModeTab liroth_items_tab;
	public static CreativeModeTab liroth_combat_tab;
	public static CreativeModeTab liroth_entities_tab;
	public static CreativeModeTab liroth_plants_tab;

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

    @SuppressWarnings("unchecked")
	private static final RegistrySetBuilder BUILDER = (new RegistrySetBuilder()).add(Registries.CONFIGURED_FEATURE, (RegistrySetBuilder.RegistryBootstrap)LirothConfiguredFeatures::bootstrap).add(Registries.PLACED_FEATURE, (RegistrySetBuilder.RegistryBootstrap)LirothPlacedFeatures::bootstrap);
    
    public static HashMap<ResourceLocation, ResourceKey<Level>> dims = new HashMap<>();
    public static ResourceLocation VANILLAPORTAL_FRAMETESTER = new ResourceLocation(MOD_ID, "vanillanether");
    public static ResourceLocation FLATPORTAL_FRAMETESTER = new ResourceLocation(MOD_ID, "flat");
    public static PortalLinkingStorage portalLinkingStorage;
    
    public Liroth()
    {
    	

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
        // Register the Deferred Register to the mod event bus so blocks get registered
		LirothParticles.PARTICLES.register(modEventBus);
		LirothEntities.ENTITIES_TYPES.register(modEventBus);
		LirothBlocks.BLOCKS.register(modEventBus);
		if (FMLEnvironment.dist == Dist.CLIENT) {
		LirothMenuTypes.MENUS.register(modEventBus);
		}
		LirothBlockEntities.BLOCK_ENTITIES.register(modEventBus);
		LirothBlocks.ITEMS.register(modEventBus);
		LirothItems.ITEMS.register(modEventBus);
		LirothSounds.SOUND_EVENTS.register(modEventBus);
		LirothFluidTypes.FLUID_TYPES.register(modEventBus);
		LirothFluids.FLUIDS.register(modEventBus);
		LirothFeatures.FEATURES.register(modEventBus);
		LirothStructures.DEFERRED_REGISTRY_STRUCTURE.register(modEventBus);
		LirothPOIs.POI.register(modEventBus);
		LirothConfiguredFeatures.CONFIGURED_FEATURES.register(modEventBus);
		LirothPlacedFeatures.PLACED_FEATURES.register(modEventBus);
		LirothBiomeModifiers.BIOME_MODIFIERS.register(modEventBus);
		LirothRecipeTypes.RECIPE_TYPES.register(modEventBus);
		LirothRecipeTypes.RECIPE_SERIALIZERS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so items get registered
		// ITEMS.register(modEventBus);
        // Register ourselves for server and other game events we are interested in
		modEventBus.addListener(this::registerTabs);
        MinecraftForge.EVENT_BUS.register(this);
        Liroth.BUILDER.getEntryKeys();
        
        onInitialize(modEventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
		LirothPortalBuilders.init();
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
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
        	if (FMLEnvironment.dist == Dist.CLIENT) {
            MenuScreens.register(LirothMenuTypes.LIROTH_SPLITTER_MENU.get(), LirothSplitterScreen::new);
            MenuScreens.register(LirothMenuTypes.QUANTUM_EXTRACTOR_MENU.get(), QuantumExtractorScreen::new);
//    		LirothRenders.renderCutOuts();
            LirothForgeClientEventsHandler.registerLayerDefinitions(ForgeHooksClient::registerLayerDefinition); 
            ItemBlockRenderTypes.setRenderLayer(LirothFluids.LIROTH_FLUID.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(LirothFluids.FLOWING_LIROTH_FLUID.get(), RenderType.translucent());
        	}
//            Some client setup code
//            LOGGER.info("HELLO FROM CLIENT SETUP");
//            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
    
    private void onServerStart(ServerStartedEvent event) {
        for (ResourceKey<Level> registryKey : event.getServer().levelKeys()) {
            dims.put(registryKey.location(), registryKey);
        }
        portalLinkingStorage = (PortalLinkingStorage) event.getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(PortalLinkingStorage::fromNbt, PortalLinkingStorage::new, MOD_ID);
    }

    private void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
        Entity entity = event.getEntity();
        Level world = event.getLevel();
        InteractionHand hand = event.getHand();

        if (entity instanceof Player player) {
            ItemStack stack = player.getItemInHand(hand);
            if (!world.isClientSide) {
                Item item = stack.getItem();
                if (PortalIgnitionSource.isRegisteredIgnitionSourceWith(item)) {
                    HitResult hit = player.pick(6, 1, false);
                    if (hit.getType() == HitResult.Type.BLOCK) {
                        BlockHitResult blockHit = (BlockHitResult) hit;
                        BlockPos usedBlockPos = blockHit.getBlockPos();
                        if (PortalPlacer.attemptPortalLight(world, usedBlockPos.relative(blockHit.getDirection()), PortalIgnitionSource.ItemUseSource(item))) {
                            event.setResult(Event.Result.ALLOW);
                        }
                    }
                }
            }
        }
    }
    
    public void onInitialize(IEventBus bus) {
        MinecraftForge.EVENT_BUS.addListener(this::onServerStart);
        CustomPortalApiRegistry.registerPortalFrameTester(VANILLAPORTAL_FRAMETESTER, VanillaPortalAreaHelper::new);
        CustomPortalApiRegistry.registerPortalFrameTester(FLATPORTAL_FRAMETESTER, FlatPortalAreaHelper::new);
        MinecraftForge.EVENT_BUS.addListener(this::onRightClickItem);

    }
    
	@SubscribeEvent
	public static void addClassicPack(AddPackFindersEvent event) {
		if (event.getPackType() == PackType.CLIENT_RESOURCES) {
			var resourcePath = ModList.get().getModFileById(Liroth.MOD_ID).getFile().findResource("classic");
			var pack = Pack.readMetaAndCreate("builtin/liroth_classic_resources", Component.literal("Liroth: Legacy"), false,
					path -> new PathPackResources(path, resourcePath, true), PackType.CLIENT_RESOURCES, Pack.Position.TOP, PackSource.BUILT_IN);
			event.addRepositorySource(consumer -> consumer.accept(pack));
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

    public void registerTabs(BuildCreativeModeTabContentsEvent event) {
        final RegistryObject<CreativeModeTab> liroth_blocks_tab = CREATIVE_MODE_TABS.register(MOD_ID + ".liroth_blocks", () -> CreativeModeTab.builder()
                .icon(() -> new ItemStack(LirothBlocks.LIROTH_GEM_BLOCK.get().asItem()))
                .title(Component.translatable("itemGroup." + MOD_ID + ".liroth_blocks"))
                .displayItems((parameters, output) -> {
                    LirothBlocks.BLOCK_ITEMS_FOR_TAB_LIST.forEach(registryObject -> output.accept(new ItemStack(registryObject.get())));
                }).build()
        );

        final RegistryObject<CreativeModeTab> liroth_items_tab = CREATIVE_MODE_TABS.register(MOD_ID + ".liroth_items", () -> CreativeModeTab.builder()
                .icon(() -> new ItemStack(LirothItems.LIROTH_GEM.get()))
                .title(Component.translatable("itemGroup." + MOD_ID + ".liroth_items"))
                .displayItems((parameters, output) -> {
                    LirothItems.ITEMS_FOR_TAB_LIST.forEach(registryObject -> output.accept(new ItemStack(registryObject.get())));
                    LirothItems.LIROTH_FLUID_BUCKET.get();
                    LirothItems.MOLTEN_SPINERIOS_BUCKET.get();
                }).build()
        );

        final RegistryObject<CreativeModeTab> liroth_combat_tab = CREATIVE_MODE_TABS.register(MOD_ID + ".liroth_combat", () -> CreativeModeTab.builder()
                .icon(() -> new ItemStack(LirothItems.LIROTH_SWORD.get()))
                .title(Component.translatable("itemGroup." + MOD_ID + ".liroth_combat"))
                .displayItems((parameters, output) -> {
                    LirothItems.COMBAT_ITEMS_FOR_TAB_LIST.forEach(registryObject -> output.accept(new ItemStack(registryObject.get())));
                }).build()
        );

        final RegistryObject<CreativeModeTab> liroth_entities_tab = CREATIVE_MODE_TABS.register(MOD_ID + ".liroth_entities", () -> CreativeModeTab.builder()
                .icon(() -> new ItemStack(LirothItems.UNUSED_SPAWN_EGG.get()))
                .title(Component.translatable("itemGroup." + MOD_ID + ".liroth_entities"))
                .displayItems((parameters, output) -> {
                    LirothItems.SPAWN_EGG_ITEMS_FOR_TAB_LIST.forEach(registryObject -> output.accept(new ItemStack(registryObject.get())));
                    output.accept(LirothItems.FORSAKEN_CORPSE_SPAWN_EGG.get());
                    output.accept(LirothItems.FREAKSHOW_SPAWN_EGG.get());
                    output.accept(LirothItems.FUNGAL_FIEND_SPAWN_EGG.get());
                    output.accept(LirothItems.LIROTHIAN_MIMIC_SPAWN_EGG.get());
                    output.accept(LirothItems.PIER_PEEP_SPAWN_EGG.get());
                    output.accept(LirothItems.PROWLER_SPAWN_EGG.get());
                    output.accept(LirothItems.SHADE_SPAWN_EGG.get());
                    output.accept(LirothItems.SKELETAL_FREAK_SPAWN_EGG.get());
                    output.accept(LirothItems.SOUL_ARACHNID_SPAWN_EGG.get());
                    output.accept(LirothItems.VILE_SHARK_SPAWN_EGG.get());
                    output.accept(LirothItems.WARP_SPAWN_EGG.get());
                }).build()
        );

        final RegistryObject<CreativeModeTab> liroth_plants_tab = CREATIVE_MODE_TABS.register(MOD_ID + ".liroth_plants", () -> CreativeModeTab.builder()
                .icon(() -> new ItemStack(LirothBlocks.LIROTH_ROSE.get().asItem()))
                .title(Component.translatable("itemGroup." + MOD_ID + ".liroth_plants"))
                .displayItems((parameters, output) -> {
                    LirothBlocks.PLANT_ITEMS_FOR_TAB_LIST.forEach(registryObject -> output.accept(new ItemStack(registryObject.get())));
                }).build()
        );
    }
    

    public static void logError(String message) {
        System.out.println("[" + MOD_ID + "]ERROR: " + message);
    }

    public static CustomPortalBlock getDefaultPortalBlock() {
        return LirothBlocks.customPortalBlock.get();
    }

    // to guarantee block exists before use, unsure how safe this is but works for now. Don't want to switch to using a custom entrypoint to break compatibility with existing mods just yet
    //todo fix this with CustomPortalBuilder?

    @SubscribeEvent
    public static void onCommonStartUp(FMLCommonSetupEvent event) {
        NetworkManager.register();
 //       CustomPortalBuilder.beginPortal().frameBlock(Blocks.GLOWSTONE).destDimID(new Identifier("the_nether")).lightWithWater().tintColor(46, 5, 25).registerPortal();
 //       CustomPortalBuilder.beginPortal().frameBlock(Blocks.DIAMOND_BLOCK).destDimID(new Identifier("the_nether")).tintColor(66, 135, 245).registerPortal();
 //       CustomPortalBuilder.beginPortal().frameBlock(Blocks.COBBLESTONE).lightWithItem(Items.STICK).destDimID(new Identifier("the_end")).tintColor(45, 24, 45).flatPortal().registerPortal();
 //       CustomPortalBuilder.beginPortal().frameBlock(Blocks.EMERALD_BLOCK).lightWithWater().destDimID(new Identifier("the_end")).tintColor(25, 76, 156).flatPortal().registerPortal();
   
    }

}
