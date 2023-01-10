package com.decodinator.liroth.core;

import java.util.List;
import java.util.OptionalInt;

import com.decodinator.liroth.Liroth;
import com.google.common.collect.ImmutableList;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.ThreeLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.AcaciaFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.DarkOakFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.MegaJungleFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.SpruceFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.LeaveVineDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TrunkVineDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.DarkOakTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.MegaJungleTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.registries.DeferredRegister;

public class LirothConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registries.CONFIGURED_FEATURE, Liroth.MOD_ID);
    
    BootstapContext<ConfiguredFeature<?, ?>> p_256317_;
    HolderGetter<Block> holdergetter = p_256317_.lookup(Registries.BLOCK);
    public static ResourceKey<ConfiguredFeature<?, ?>> LIROTH = FeatureUtils.createKey("liroth");
    public static ResourceKey<ConfiguredFeature<?, ?>> SPICED = FeatureUtils.createKey("spiced");
    public static ResourceKey<ConfiguredFeature<?, ?>> TALLPIER = FeatureUtils.createKey("tallpier");
    public static ResourceKey<ConfiguredFeature<?, ?>> DAMNATION = FeatureUtils.createKey("damnation");
    public static ResourceKey<ConfiguredFeature<?, ?>> JAPZ = FeatureUtils.createKey("japz");
    public static ResourceKey<ConfiguredFeature<?, ?>> KOOLAW = FeatureUtils.createKey("koolaw");
    public static ResourceKey<ConfiguredFeature<?, ?>> PETRIFIED = FeatureUtils.createKey("petrified");
	
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_LIROTH_ORE = FeatureUtils.createKey("liroth_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_LIROTH_ORE = FeatureUtils.createKey("nether_liroth_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_LIROTH_ORE = FeatureUtils.createKey("end_liroth_ore");
   
    public static final ResourceKey<ConfiguredFeature<?, ?>> TOURMALINE_ORE = FeatureUtils.createKey("tourmaline_ore");
    
    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> p_256319_) {
        FeatureUtils.register(p_256319_, LIROTH, Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(LirothBlocks.LIROTH_LOG.get()), new FancyTrunkPlacer(3, 11, 0), BlockStateProvider.simple(LirothBlocks.LIROTH_LEAVES.get()), new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))).ignoreVines().build());
        FeatureUtils.register(p_256319_, SPICED, Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(LirothBlocks.SPICED_LOG.get()), new ForkingTrunkPlacer(5, 2, 2), BlockStateProvider.simple(LirothBlocks.SPICED_LEAVES.get()), new AcaciaFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2))).ignoreVines().build());
        FeatureUtils.register(p_256319_, TALLPIER, Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(LirothBlocks.TALLPIER_LOG.get()), new MegaJungleTrunkPlacer(10, 2, 19), BlockStateProvider.simple(LirothBlocks.TALLPIER_LEAVES.get()), new MegaJungleFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 2), new TwoLayersFeatureSize(1, 1, 2))).decorators(ImmutableList.of(TrunkVineDecorator.INSTANCE, new LeaveVineDecorator(0.25F))).build());
        FeatureUtils.register(p_256319_, DAMNATION, Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(LirothBlocks.DAMNATION_LOG.get()), new DarkOakTrunkPlacer(6, 2, 1), BlockStateProvider.simple(LirothBlocks.DAMNATION_LEAVES.get()), new DarkOakFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), new ThreeLayersFeatureSize(1, 1, 0, 1, 2, OptionalInt.empty()))).ignoreVines().build());
        FeatureUtils.register(p_256319_, JAPZ, Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(LirothBlocks.JAPZ_LOG.get()), new StraightTrunkPlacer(5, 2, 1), BlockStateProvider.simple(LirothBlocks.JAPZ_LEAVES.get()), new SpruceFoliagePlacer(UniformInt.of(2, 3), UniformInt.of(0, 2), UniformInt.of(1, 2)), new TwoLayersFeatureSize(2, 0, 2))).ignoreVines().build());
        FeatureUtils.register(p_256319_, KOOLAW, Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(LirothBlocks.KOOLAW_LOG.get()), new StraightTrunkPlacer(4, 2, 0), BlockStateProvider.simple(LirothBlocks.KOOLAW_LEAVES.get()), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1)).build()));
        FeatureUtils.register(p_256319_, PETRIFIED, Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(LirothBlocks.PETRIFIED_DAMNATION_LOG.get()), new ForkingTrunkPlacer(5, 2, 2), BlockStateProvider.simple(LirothBlocks.DAMNATION_LEAVES.get()), new AcaciaFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2))).ignoreVines().build());
    
        RuleTest stoneTest = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepSlateTest = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherTest = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest endTest = new BlockMatchTest(Blocks.END_STONE);
        
        List<OreConfiguration.TargetBlockState> overworld_liroth_list = List.of(OreConfiguration.target(stoneTest, LirothBlocks.LIROTH_ORE.get().defaultBlockState()), OreConfiguration.target(deepSlateTest, LirothBlocks.DEEPSLATE_LIROTH_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> tourmaline_list = List.of(OreConfiguration.target(stoneTest, LirothBlocks.TOURMALINE_ORE.get().defaultBlockState()), OreConfiguration.target(deepSlateTest, LirothBlocks.DEEPSLATE_TOURMALINE_ORE.get().defaultBlockState()));
        CONFIGURED_FEATURES.register("liroth_ore", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(overworld_liroth_list, 4, 0.5F)));
        FeatureUtils.register(p_256319_, OVERWORLD_LIROTH_ORE, Feature.ORE, new OreConfiguration(overworld_liroth_list, 4, 0.5F));
        CONFIGURED_FEATURES.register("nether_liroth_ore", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(netherTest, LirothBlocks.NETHER_LIROTH_GEM_ORE.get().defaultBlockState(), 4)));
        FeatureUtils.register(p_256319_, NETHER_LIROTH_ORE, Feature.ORE, new OreConfiguration(netherTest, LirothBlocks.NETHER_LIROTH_GEM_ORE.get().defaultBlockState(), 4));
        CONFIGURED_FEATURES.register("end_liroth_ore", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(endTest, LirothBlocks.NETHER_LIROTH_GEM_ORE.get().defaultBlockState(), 4)));
        FeatureUtils.register(p_256319_, NETHER_LIROTH_ORE, Feature.ORE, new OreConfiguration(endTest, LirothBlocks.END_LIROTH_GEM_ORE.get().defaultBlockState(), 6));
        CONFIGURED_FEATURES.register("tourmaline_ore", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(tourmaline_list, 4, 0.5F)));
        FeatureUtils.register(p_256319_, TOURMALINE_ORE, Feature.ORE, new OreConfiguration(tourmaline_list, 4, 0.5F));
    }
}
