package com.decodinator.liroth.core.helpers;

import com.decodinator.liroth.core.LirothRecipeTypes;

import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public abstract class AbstractQuantumRecipe implements Recipe<Container> {
   protected final RecipeType<?> type;
   protected final ResourceLocation id;
   public final String group;
   public final Ingredient ingredient;
   public final ItemStack result;
   public final RandomizedOutputIngredient bonus;
   public final float experience;
   public final int cookingTime;

   public AbstractQuantumRecipe(RecipeType<?> p_250197_, ResourceLocation p_249379_, String p_249518_, Ingredient p_251354_, ItemStack p_252185_, RandomizedOutputIngredient bonus, float p_252165_, int p_250256_) {
      this.type = p_250197_;
      this.id = p_249379_;
      this.group = p_249518_;
      this.ingredient = p_251354_;
      this.result = p_252185_;
      this.bonus = bonus;
      this.experience = p_252165_;
      this.cookingTime = p_250256_;
   }

   public boolean matches(Container p_43748_, Level p_43749_) {
      return this.ingredient.test(p_43748_.getItem(0));
   }

   public ItemStack assemble(Container p_43746_) {
      return this.result.copy();
   }

   public boolean canCraftInDimensions(int p_43743_, int p_43744_) {
      return true;
   }

   public NonNullList<Ingredient> getIngredients() {
      NonNullList<Ingredient> nonnulllist = NonNullList.create();
      nonnulllist.add(this.ingredient);
      return nonnulllist;
   }

   public float getExperience() {
      return this.experience;
   }

   public ItemStack getResultItem() {
      return this.result;
   }
   
   public RandomizedOutputIngredient getBonusItem() {
	  return this.bonus;
   }

   public String getGroup() {
      return this.group;
   }

   public int getCookingTime() {
      return this.cookingTime;
   }

   public ResourceLocation getId() {
      return this.id;
   }

   public RecipeType<?> getType() {
      return this.type;
   }
   
   @Override
   public RecipeSerializer<?> getSerializer() {
	  return LirothRecipeTypes.QUANTUM_EXTRACTION_S.get();
   }
   
   public ItemStack createBonus(RandomSource rand) {
	    ItemStack getBonus = this.bonus.bonus.copy();
	    if (this.bonus.bonus.getCount() > 1) {
	      //if its 1 just leave it. otherwise RNG
	      //so if getCount==3 , then get rand [0,2] + 1 = [1,3]
	      getBonus.setCount(1 + rand.nextInt(this.bonus.bonus.getCount()));
	    }
	    return getBonus;
	  }
}