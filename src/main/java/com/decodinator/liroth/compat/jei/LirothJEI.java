package com.decodinator.liroth.compat.jei;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.LirothBlocks;
import com.decodinator.liroth.core.LirothRecipeTypes;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.helpers.IJeiHelpers;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeTransferRegistration;
import mezz.jei.api.runtime.IIngredientManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

@JeiPlugin
public class LirothJEI implements IModPlugin {
    public final static ResourceLocation PLUGIN_ID = new ResourceLocation(Liroth.MOD_ID, "jei_plugin");

	public void registerCategories(IRecipeCategoryRegistration registration) {
        IModPlugin.super.registerCategories(registration);

        IJeiHelpers jeiHelpers = registration.getJeiHelpers();
        IGuiHelper guiHelper = jeiHelpers.getGuiHelper();
        
        registration.addRecipeCategories(new QuantumCategory(guiHelper));
        registration.addRecipeCategories(new SplitterCategory(guiHelper));
	}
	
    @SuppressWarnings("unchecked")
	@Override
    public void registerRecipes(IRecipeRegistration registration) {
        Minecraft minecraft = Minecraft.getInstance();
        ClientLevel world = minecraft.level;
        var recipeManager = world.getRecipeManager();
        IIngredientManager ingredientManager = registration.getIngredientManager();

        IModPlugin.super.registerRecipes(registration);
        registration.addRecipes(QuantumCategory.TYPE, recipeManager.getAllRecipesFor(LirothRecipeTypes.QUANTUM_EXTRACTION.get()));
        registration.addRecipes(SplitterCategory.TYPE, recipeManager.getAllRecipesFor(LirothRecipeTypes.LIROTH_SPLITTING.get()));
    }
    
    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        IModPlugin.super.registerRecipeCatalysts(registration);
        registration.addRecipeCatalyst(
                new ItemStack(LirothBlocks.QUANTUM_EXTRACTOR.get()),
                QuantumCategory.TYPE
        );
        registration.addRecipeCatalyst(
                new ItemStack(LirothBlocks.LIROTH_SPLITTER.get()),
                SplitterCategory.TYPE
        );
    }

    @Override
    public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {
        IModPlugin.super.registerRecipeTransferHandlers(registration);
    }

	@Override
	public ResourceLocation getPluginUid() {
		return PLUGIN_ID;
	}
}
