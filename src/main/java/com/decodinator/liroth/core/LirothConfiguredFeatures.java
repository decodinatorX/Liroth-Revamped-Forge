package com.decodinator.liroth.core;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.Supplier;

import com.decodinator.liroth.Liroth;
import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableList;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
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
import net.minecraft.world.level.levelgen.feature.foliageplacers.RandomSpreadFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.SpruceFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.rootplacers.AboveRootPlacement;
import net.minecraft.world.level.levelgen.feature.rootplacers.MangroveRootPlacement;
import net.minecraft.world.level.levelgen.feature.rootplacers.MangroveRootPlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.LeaveVineDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TrunkVineDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.DarkOakTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.MegaJungleTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.UpwardsBranchingTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class LirothConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, Liroth.MOD_ID);
	
   	public static final RegistryObject<ConfiguredFeature<TreeConfiguration, ?>> LIROTH = CONFIGURED_FEATURES.register("liroth", () -> new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(LirothBlocks.LIROTH_LOG.get()), new FancyTrunkPlacer(3, 11, 0), BlockStateProvider.simple(LirothBlocks.LIROTH_LEAVES.get()), new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))).ignoreVines().build()));
    public static final RegistryObject<ConfiguredFeature<TreeConfiguration, ?>> SPICED = CONFIGURED_FEATURES.register("spiced", () -> new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(LirothBlocks.SPICED_LOG.get()), new ForkingTrunkPlacer(5, 2, 2), BlockStateProvider.simple(LirothBlocks.SPICED_LEAVES.get()), new AcaciaFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2)).ignoreVines().build()));
    public static final RegistryObject<ConfiguredFeature<TreeConfiguration, ?>> TALLPIER = CONFIGURED_FEATURES.register("tallpier", () -> new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(LirothBlocks.TALLPIER_LOG.get()), new MegaJungleTrunkPlacer(10, 2, 19), BlockStateProvider.simple(LirothBlocks.TALLPIER_LEAVES.get()), new MegaJungleFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 2), new TwoLayersFeatureSize(1, 1, 2)).decorators(ImmutableList.of(TrunkVineDecorator.INSTANCE, new LeaveVineDecorator(0.25F))).build()));
    public static final RegistryObject<ConfiguredFeature<TreeConfiguration, ?>> DAMNATION = CONFIGURED_FEATURES.register("damnation", () -> new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(LirothBlocks.DAMNATION_LOG.get()), new DarkOakTrunkPlacer(6, 2, 1), BlockStateProvider.simple(LirothBlocks.DAMNATION_LEAVES.get()), new DarkOakFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), new ThreeLayersFeatureSize(1, 1, 0, 1, 2, OptionalInt.empty())).ignoreVines().build()));
    public static final RegistryObject<ConfiguredFeature<TreeConfiguration, ?>> JAPZ = CONFIGURED_FEATURES.register("japz", () -> new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(LirothBlocks.JAPZ_LOG.get()), new StraightTrunkPlacer(5, 2, 1), BlockStateProvider.simple(LirothBlocks.JAPZ_LEAVES.get()), new SpruceFoliagePlacer(UniformInt.of(2, 3), UniformInt.of(0, 2), UniformInt.of(1, 2)), new TwoLayersFeatureSize(2, 0, 2)).ignoreVines().build()));
    public static final RegistryObject<ConfiguredFeature<TreeConfiguration, ?>> KOOLAW = CONFIGURED_FEATURES.register("koolaw", () -> new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(LirothBlocks.KOOLAW_LOG.get()), new StraightTrunkPlacer(5, 2, 0), BlockStateProvider.simple(LirothBlocks.KOOLAW_LEAVES.get()), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1)).build()));
    public static final RegistryObject<ConfiguredFeature<TreeConfiguration, ?>> PETRIFIED = CONFIGURED_FEATURES.register("petrified", () -> new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(LirothBlocks.PETRIFIED_DAMNATION_LOG.get()), new UpwardsBranchingTrunkPlacer(2, 1, 4, UniformInt.of(1, 4), 0.5F, UniformInt.of(0, 1), Registry.BLOCK.getOrCreateTag(BlockTags.MANGROVE_LOGS_CAN_GROW_THROUGH)), BlockStateProvider.simple(LirothBlocks.DAMNATION_LEAVES.get()), new RandomSpreadFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), ConstantInt.of(2), 70), Optional.of(new MangroveRootPlacer(UniformInt.of(1, 3), BlockStateProvider.simple(LirothBlocks.PETRIFIED_DAMNATION_WOOD.get()), Optional.of(new AboveRootPlacement(BlockStateProvider.simple(LirothBlocks.PETRIFIED_MOSS_CARPET.get()), 0.5F)), new MangroveRootPlacement(Registry.BLOCK.getOrCreateTag(BlockTags.MANGROVE_ROOTS_CAN_GROW_THROUGH), HolderSet.direct(Block::builtInRegistryHolder, LirothBlocks.SOULLESS_SOIL.get(), LirothBlocks.PETRIFIED_DAMNATION_LOG.get()), BlockStateProvider.simple(LirothBlocks.PETRIFIED_DAMNATION_WOOD.get()), 8, 15, 0.2F))), new TwoLayersFeatureSize(2, 0, 2)).ignoreVines().build()));
	
    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_LIROTH_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, LirothBlocks.LIROTH_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, LirothBlocks.DEEPSLATE_LIROTH_ORE.get().defaultBlockState())));

    public static final RegistryObject<ConfiguredFeature<?, ?>> LIROTH_ORE = CONFIGURED_FEATURES.register("liroth_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_LIROTH_ORES.get(),2)));
    
    public static final Supplier<List<OreConfiguration.TargetBlockState>> NETHER_LIROTH_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES, LirothBlocks.NETHER_LIROTH_GEM_ORE.get().defaultBlockState())));

    public static final RegistryObject<ConfiguredFeature<?, ?>> NETHER_LIROTH_ORE = CONFIGURED_FEATURES.register("nether_liroth_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(NETHER_LIROTH_ORES.get(),4)));
    
    public static final Supplier<List<OreConfiguration.TargetBlockState>> END_LIROTH_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(Liroth.END_STONE, LirothBlocks.END_LIROTH_GEM_ORE.get().defaultBlockState())));

    public static final RegistryObject<ConfiguredFeature<?, ?>> END_LIROTH_ORE = CONFIGURED_FEATURES.register("end_liroth_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(END_LIROTH_ORES.get(),6)));
    
    public static final Supplier<List<OreConfiguration.TargetBlockState>> LIROTHIAN_LIROTH_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, LirothBlocks.LIROTH_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, LirothBlocks.DEEPSLATE_LIROTH_ORE.get().defaultBlockState())));

    public static final RegistryObject<ConfiguredFeature<?, ?>> LIROTHIAN_LIROTH_ORE = CONFIGURED_FEATURES.register("lirothian_liroth_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_LIROTH_ORES.get(),8)));
    
    public static final Supplier<List<OreConfiguration.TargetBlockState>> TOURMALINE_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, LirothBlocks.TOURMALINE_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, LirothBlocks.DEEPSLATE_TOURMALINE_ORE.get().defaultBlockState())));

    public static final RegistryObject<ConfiguredFeature<?, ?>> TOURMALINE_ORE = CONFIGURED_FEATURES.register("tourmaline_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(TOURMALINE_ORES.get(),1)));
}
