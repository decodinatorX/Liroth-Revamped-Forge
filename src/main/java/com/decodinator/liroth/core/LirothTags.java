package com.decodinator.liroth.core;

import com.decodinator.liroth.Liroth;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;

public class LirothTags {
//	  public static final TagKey<Block> DIRT_ORE_REPLACEABLES = TagKey.create(Registry.BLOCK, new ResourceLocation("liroth", "dirt_ore_replaceables"));
	  public static final TagKey<Block> DIRT_ORE_REPLACEABLES = BlockTags.create(new ResourceLocation("liroth", "dirt_ore_replaceables"));
//	  public static final TagKey<Block> LIROTH_FARMLANDS = TagKey.of(Registry.BLOCK, new ResourceLocation("liroth", "liroth_farmlands"));
	  public static final TagKey<Block> LIROTH_FARMLANDS = BlockTags.create(new ResourceLocation("liroth", "liroth_farmlands"));
//	  public static final TagKey<Biome> LIROTH_BIOMES = TagKey.of(Registry.BIOME_SOURCE, new ResourceLocation("liroth", "liroth_biomes"));
	  public static final TagKey<Biome> LIROTH_BIOMES = create("liroth:liroth_biomes");
//	  public static final TagKey<Fluid> STICKY_FLUIDS = TagKey.of(Registry.FLUID, new ResourceLocation("liroth", "sticky_fluids"));
	  public static final TagKey<Fluid> STICKY_FLUIDS = FluidTags.create(new ResourceLocation("liroth", "sticky_fluids"));
//	  public static final TagKey<Item> TORCHES = TagKey.of(Registry.ITEM, new ResourceLocation("liroth", "torches"));
	  public static final TagKey<Item> TORCHES = ItemTags.create(new ResourceLocation("liroth", "torches"));

	  
	    private static TagKey<Biome> create(String id) {
	        return TagKey.create(Registries.BIOME, Liroth.createLocation(id));
	    }
}
