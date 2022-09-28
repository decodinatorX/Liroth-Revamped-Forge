package com.decodinator.liroth.core;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.features.DamnationVinesFeature;
import com.decodinator.liroth.core.features.JalsphireCrystalClusterFeature;
import com.decodinator.liroth.core.features.LirothBoneClawFeature;
import com.decodinator.liroth.core.features.LirothBoneMushroomFeature;
import com.decodinator.liroth.core.features.LirothBoneTreeFeature;
import com.decodinator.liroth.core.features.ObsidianSpikeFeature;
import com.decodinator.liroth.core.features.PetrifiedCrystalClusterFeature;
import com.decodinator.liroth.core.features.VileTentacleFeature;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.RandomPatchFeature;
import net.minecraft.world.level.levelgen.feature.configurations.DripstoneClusterConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class LirothFeatures {
	public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, Liroth.MOD_ID);
	
	  private static final RegistryObject<ObsidianSpikeFeature> OBSIDIAN_SPIKE = FEATURES.register("obsidian_spike", () -> new ObsidianSpikeFeature(NoneFeatureConfiguration.CODEC));
	  private static final RegistryObject<VileTentacleFeature> VILE_TENTALCE = FEATURES.register("vile_tentacle", () -> new VileTentacleFeature(NoneFeatureConfiguration.CODEC));
	  private static final RegistryObject<LirothBoneClawFeature> LIROTH_BONE_CLAW = FEATURES.register("liroth_bone_claw", () -> new LirothBoneClawFeature(NoneFeatureConfiguration.CODEC));
	  private static final RegistryObject<LirothBoneMushroomFeature> LIROTH_BONE_MUSHROOM = FEATURES.register("liroth_bone_mushroom", () -> new LirothBoneMushroomFeature(NoneFeatureConfiguration.CODEC));
	  private static final RegistryObject<LirothBoneTreeFeature> LIROTH_BONE_TREE = FEATURES.register("liroth_bone_tree", () -> new LirothBoneTreeFeature(NoneFeatureConfiguration.CODEC));
	  private static final RegistryObject<JalsphireCrystalClusterFeature> JALSPHIRE_CRYSTAL_CLUSTER = FEATURES.register("jalsphire_crystal_cluster", () -> new JalsphireCrystalClusterFeature(DripstoneClusterConfiguration.CODEC));
	  private static final RegistryObject<PetrifiedCrystalClusterFeature> PETRIFIED_CRYSTAL_CLUSTER = FEATURES.register("petrified_crystal_cluster", () ->new PetrifiedCrystalClusterFeature(DripstoneClusterConfiguration.CODEC));
	  private static final RegistryObject<DamnationVinesFeature> DAMNATION_VINES = FEATURES.register("damnation_vines", () -> new DamnationVinesFeature(NoneFeatureConfiguration.CODEC));
	  private static final RegistryObject<RandomPatchFeature> WILTING_LIROTH_ROSES = FEATURES.register("wilting_liroth_roses", () -> new RandomPatchFeature(RandomPatchConfiguration.CODEC));
}
