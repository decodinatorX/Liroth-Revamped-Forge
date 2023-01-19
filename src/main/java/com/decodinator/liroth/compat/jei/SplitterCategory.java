package com.decodinator.liroth.compat.jei;

import com.decodinator.liroth.core.LirothBlocks;
import com.decodinator.liroth.core.helpers.SplitterRecipe;

import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.RecipeType;

public class SplitterCategory extends AbstractSplitterCategory<SplitterRecipe> {
	public SplitterCategory(IGuiHelper guiHelper) {
		super(guiHelper, LirothBlocks.LIROTH_SPLITTER.get(), "gui.jei.category." + JEILirothJEIConstants.GEM_SPLITTER, 200);
	}

	@Override
	public RecipeType<SplitterRecipe> getRecipeType() {
		return AbstractSplitterCategory.TYPE;
	}
}
