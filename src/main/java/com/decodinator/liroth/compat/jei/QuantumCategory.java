package com.decodinator.liroth.compat.jei;

import com.decodinator.liroth.core.LirothBlocks;
import com.decodinator.liroth.core.helpers.QuantumRecipe;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.RecipeType;

public class QuantumCategory extends AbstractQuantumCategory<QuantumRecipe> {
	public QuantumCategory(IGuiHelper guiHelper) {
		super(guiHelper, LirothBlocks.QUANTUM_EXTRACTOR.get(), "gui.jei.category." + JEILirothJEIConstants.QUANTUM_EXTRACTOR, 200);
	}

	@Override
	public RecipeType<QuantumRecipe> getRecipeType() {
		return AbstractQuantumCategory.TYPE;
	}
}
