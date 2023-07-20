package com.decodinator.liroth.core.helpers;

import com.decodinator.liroth.core.LirothBlocks;
import com.decodinator.liroth.core.LirothRecipeTypes;

import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

public class SplitterRecipe extends AbstractSplitterRecipe {
   public SplitterRecipe(ResourceLocation p_249157_, String p_250200_, Ingredient p_250340_, ItemStack p_250306_, RandomizedOutputIngredient bonus, RandomizedOutputIngredient2 bonus2, float p_249577_, int p_250030_) {
      super(LirothRecipeTypes.LIROTH_SPLITTING.get(), p_249157_, p_250200_, p_250340_, p_250306_, bonus, bonus2, p_249577_, p_250030_);
   }

   @Override
   public ItemStack assemble(Container p_44001_, RegistryAccess p_267165_) {
      return this.result.copy();
   }

   @Override
   public ItemStack getResultItem(RegistryAccess p_267052_) {
      return this.result;
   }

   public ItemStack getToastSymbol() {
      return new ItemStack(LirothBlocks.LIROTH_SPLITTER.get());
   }
}