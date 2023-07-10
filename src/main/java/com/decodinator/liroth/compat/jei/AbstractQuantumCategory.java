package com.decodinator.liroth.compat.jei;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.LirothBlocks;
import com.decodinator.liroth.core.helpers.AbstractQuantumRecipe;
import com.decodinator.liroth.core.helpers.QuantumRecipe;
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
import net.minecraft.world.level.block.Blocks;

public abstract class AbstractQuantumCategory<T extends AbstractQuantumRecipe> extends FurnaceVariantCategory<T> {
    public static final RecipeType TYPE = RecipeType.create(
            Liroth.MOD_ID,
            "quantum_extraction",
            QuantumRecipe.class
    );

	private final IDrawable background;
	protected final IDrawableStatic staticFlame;
	protected final IDrawableAnimated animatedFlame;
	private final IDrawable icon;
    private final Component title;
	private final String localizedName;
	private final int regularCookTime;
	private final LoadingCache<Integer, IDrawableAnimated> cachedArrows;

	public AbstractQuantumCategory(IGuiHelper guiHelper, Block icon, String translationKey, int regularCookTime) {
		super(guiHelper);
		this.staticFlame = guiHelper.createDrawable(JEILirothJEIConstants.RECIPE_GUI_LIROTH_MOD, 79, 184, 14, 14);
		this.animatedFlame = guiHelper.createAnimatedDrawable(staticFlame, 300, IDrawableAnimated.StartDirection.TOP, true);
		title = Component.translatable(LirothBlocks.QUANTUM_EXTRACTOR.get().getDescriptionId());
		background = guiHelper.createDrawable(JEILirothJEIConstants.RECIPE_GUI_LIROTH_MOD, 0, 198, 79, 54);
		this.icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(LirothBlocks.QUANTUM_EXTRACTOR.get()));
		this.regularCookTime = regularCookTime;
		localizedName = I18n.get("gui.jei.category." + JEILirothJEIConstants.QUANTUM_EXTRACTOR);
		this.cachedArrows = CacheBuilder.newBuilder()
				.maximumSize(25)
				.build(new CacheLoader<>() {
					@Override
					public IDrawableAnimated load(Integer cookTime) {
						return guiHelper.drawableBuilder(Constants.RECIPE_GUI_VANILLA, 82, 128, 24, 17)
							.buildAnimated(cookTime, IDrawableAnimated.StartDirection.LEFT, false);
					}
				});	}

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
	
	protected IDrawableAnimated getArrow(AbstractQuantumRecipe recipe) {
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

	@Override
	public RecipeType<T> getRecipeType() {
		return TYPE;
	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, AbstractQuantumRecipe recipe, IFocusGroup focuses) {

		builder.addSlot(RecipeIngredientRole.INPUT, 1, 1).addIngredients(recipe.at(0));
		builder.addSlot(RecipeIngredientRole.INPUT, 1, 37).addItemStack(Blocks.REDSTONE_BLOCK.asItem().getDefaultInstance());
		builder.addSlot(RecipeIngredientRole.OUTPUT, 58, 5).addItemStack(recipe.getResultItem());
		if (!recipe.bonus.bonus.isEmpty() && recipe.bonus.percent > 0) {
			builder.addSlot(RecipeIngredientRole.OUTPUT, 58, 33).addItemStack(recipe.bonus.bonus);
		}
	}
}
