package com.decodinator.liroth.core;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.util.ModOrePlacement;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class LirothPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, Liroth.MOD_ID);
    
    public static final RegistryObject<PlacedFeature> LIROTH_ORE_PLACED = PLACED_FEATURES.register("liroth_ore_placed",
    		() -> new PlacedFeature(LirothConfiguredFeatures.LIROTH_ORE.getHolder().get(), ModOrePlacement.commonOrePlacement(2, // VeinsPerChunk
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));
    
    public static final RegistryObject<PlacedFeature> NETHER_LIROTH_ORE_PLACED = PLACED_FEATURES.register("nether_liroth_ore_placed",
    		() -> new PlacedFeature(LirothConfiguredFeatures.NETHER_LIROTH_ORE.getHolder().get(), ModOrePlacement.commonOrePlacement(4, // VeinsPerChunk
            		PlacementUtils.RANGE_10_10)));
    
    public static final RegistryObject<PlacedFeature> END_LIROTH_ORE_PLACED = PLACED_FEATURES.register("end_liroth_ore_placed",
    		() -> new PlacedFeature(LirothConfiguredFeatures.END_LIROTH_ORE.getHolder().get(), ModOrePlacement.commonOrePlacement(6, // VeinsPerChunk
            		PlacementUtils.RANGE_10_10)));
    
    public static final RegistryObject<PlacedFeature> LIROTHIAN_LIROTH_ORE_PLACED = PLACED_FEATURES.register("lirothian_liroth_ore_placed",
    		() -> new PlacedFeature(LirothConfiguredFeatures.LIROTHIAN_LIROTH_ORE.getHolder().get(), ModOrePlacement.commonOrePlacement(8, // VeinsPerChunk
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));

    public static final RegistryObject<PlacedFeature> TOURMALINE_ORE_PLACED = PLACED_FEATURES.register("tourmaline_ore_placed",
    		() -> new PlacedFeature(LirothConfiguredFeatures.TOURMALINE_ORE.getHolder().get(), ModOrePlacement.commonOrePlacement(1, // VeinsPerChunk
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));
}
