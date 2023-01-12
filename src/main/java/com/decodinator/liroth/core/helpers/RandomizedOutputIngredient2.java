package com.decodinator.liroth.core.helpers;

// COPY OF RandomizedOutputIngredient

import com.google.gson.JsonObject;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.ShapedRecipe;

public class RandomizedOutputIngredient2 {

  private static final String KEY_PERCENT = "percent2";
  private static final String KEY_BONUS = "bonus2";
  public ItemStack bonus = ItemStack.EMPTY;
  public int percent;

  public RandomizedOutputIngredient2(JsonObject json) {
    parseData(json);
  }

  public RandomizedOutputIngredient2(int readInt, ItemStack readItem) {
    this.percent = readInt;
    this.bonus = readItem;
  }

  private void parseData(JsonObject json) {
    if (json.has(KEY_BONUS) && json.has(KEY_PERCENT)) {
      bonus = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, KEY_BONUS));
      percent = json.get(KEY_PERCENT).getAsInt();
      percent = Math.max(0, percent);
      if (percent > 100) {
        percent = 100;
      }
    }
  }
}