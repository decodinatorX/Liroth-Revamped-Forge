package com.decodinator.liroth.core;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.helpers.AbstractQuantumRecipe;
import com.decodinator.liroth.core.helpers.AbstractSplitterRecipe;
import com.decodinator.liroth.core.helpers.QuantumRecipe;
import com.decodinator.liroth.core.helpers.SimpleQuantumSerializer;
import com.decodinator.liroth.core.helpers.SimpleSplitterSerializer;
import com.decodinator.liroth.core.helpers.SplitterRecipe;

import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class LirothRecipeTypes {
	  public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, Liroth.MOD_ID);
	  public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Liroth.MOD_ID);
	  
	  public static final RegistryObject<RecipeType<AbstractQuantumRecipe>> QUANTUM_EXTRACTION = RECIPE_TYPES.register("quantum_extraction", () -> new RecipeType<AbstractQuantumRecipe>() {});
	  public static final RegistryObject<SimpleQuantumSerializer<AbstractQuantumRecipe>> QUANTUM_EXTRACTION_S = RECIPE_SERIALIZERS.register("quantum_extraction", () -> new SimpleQuantumSerializer<>(QuantumRecipe::new, 200));

	  public static final RegistryObject<RecipeType<AbstractSplitterRecipe>> LIROTH_SPLITTING = RECIPE_TYPES.register("liroth_splitting", () -> new RecipeType<AbstractSplitterRecipe>() {});
	  public static final RegistryObject<SimpleSplitterSerializer<AbstractSplitterRecipe>> LIROTH_SPLITTING_S = RECIPE_SERIALIZERS.register("liroth_splitting", () -> new SimpleSplitterSerializer<>(SplitterRecipe::new, 200));
}
