package com.decodinator.liroth.compat.jei;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.LirothBlocks;
import com.decodinator.liroth.core.blocks.entities.LirothSplitterBlockEntity;
import com.decodinator.liroth.core.helpers.AbstractSplitterRecipe;
import com.decodinator.liroth.core.helpers.SplitterRecipe;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.mojang.blaze3d.vertex.PoseStack;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

public class AbstractSplitterCategory<T extends AbstractSplitterRecipe> extends FurnaceVariantCategory<T>{
    public static final RecipeType TYPE = RecipeType.create(
            Liroth.MOD_ID,
            "liroth_splitting",
            SplitterRecipe.class
    );
	protected final IDrawableStatic staticFlame;
	protected final IDrawableAnimated animatedFlame;
	private final IDrawable background;
	private final IDrawable icon;
    private final Component title;
	private final String localizedName;
	private final int regularCookTime;
	private final LoadingCache<Integer, IDrawableAnimated> cachedArrows;


	public AbstractSplitterCategory(IGuiHelper guiHelper, Block icon, String translationKey, int regularCookTime) {
		super(guiHelper);
		this.staticFlame = guiHelper.createDrawable(JEILirothJEIConstants.RECIPE_GUI_LIROTH_MOD, 93, 184, 14, 14);
		this.animatedFlame = guiHelper.createAnimatedDrawable(staticFlame, 300, IDrawableAnimated.StartDirection.TOP, true);
		title = Component.translatable(LirothBlocks.LIROTH_SPLITTER.get().getDescriptionId());
		this.regularCookTime = regularCookTime;
		background = guiHelper.createDrawable(JEILirothJEIConstants.RECIPE_GUI_LIROTH_MOD, 0, 0, 82, 78);
		this.icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(LirothBlocks.LIROTH_SPLITTER.get()));
		localizedName = I18n.get("gui.jei.category." + JEILirothJEIConstants.GEM_SPLITTER);
		this.cachedArrows = CacheBuilder.newBuilder()
			.build(new CacheLoader<>() {
				@Override
				public IDrawableAnimated load(Integer cookTime) {
					return guiHelper.drawableBuilder(JEILirothJEIConstants.RECIPE_GUI_LIROTH_MOD, 103, 198, 34, 53).buildAnimated(LirothSplitterBlockEntity.totalTime, IDrawableAnimated.StartDirection.LEFT, false);
				}
			});
		}

	@Override
	public IDrawable getBackground() {
		return background;
	}

	@Override
	public IDrawable getIcon() {
		return icon;
	}

	@Override
	public Component getTitle() {
		return title;
	}
	
	protected IDrawableAnimated getArrow(AbstractSplitterRecipe recipe) {
		int cookTime = recipe.getCookingTime();
		if (cookTime <= 0) {
			cookTime = regularCookTime;
		}
		return this.cachedArrows.getUnchecked(cookTime);
	}

	protected static final int inputSlot_0 = 0;
	protected static final int inputSlot_1 = 1;
	protected static final int outputSlot_0 = 2;
	protected static final int outputSlot_1 = 3;
	protected static final int outputSlot_2 = 4;

	@Override
	public RecipeType<T> getRecipeType() {
		return TYPE;
	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, AbstractSplitterRecipe recipe, IFocusGroup focuses) {

		builder.addSlot(RecipeIngredientRole.INPUT, 1, 13).addIngredients(recipe.at(0));
		builder.addSlot(RecipeIngredientRole.OUTPUT, 61, 5).addItemStack(recipe.getResultItem());
	    if (!recipe.bonus.bonus.isEmpty() && recipe.bonus.percent > 0) {
	    	builder.addSlot(RecipeIngredientRole.OUTPUT, 61, 31).addItemStack(recipe.bonus.bonus);
	    }
	    if (!recipe.bonus2.bonus.isEmpty() && recipe.bonus2.percent > 0) {
	    	builder.addSlot(RecipeIngredientRole.OUTPUT, 61, 57).addItemStack(recipe.bonus2.bonus);
	    }
	}
	
	@Override
	public void draw(T recipe, IRecipeSlotsView recipeSlotsView, PoseStack poseStack, double mouseX, double mouseY) {
		animatedFlame.draw(poseStack, 1, 32);

		IDrawableAnimated arrow = getArrow(recipe);
		arrow.draw(poseStack, 22, 12);
	}
}
