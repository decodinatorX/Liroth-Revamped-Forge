package com.decodinator.liroth.compat.jei;

import java.util.Locale;

import com.decodinator.liroth.Liroth;

import net.minecraft.resources.ResourceLocation;

public class JEILirothJEIConstants {

	public static final String GEM_SPLITTER = "liroth.gem.splitter";
	public static final String QUANTUM_EXTRACTOR = "quantum.extractor";
	
	public static final String RESOURCE_DOMAIN = Liroth.MOD_ID.toLowerCase(Locale.ENGLISH);
	public static final String TEXTURE_GUI_PATH = "textures/gui/";

	public static final String TEXTURE_GUI_VANILLA = TEXTURE_GUI_PATH + "gui_liroth.png";

	public static final ResourceLocation RECIPE_GUI_LIROTH_MOD = new ResourceLocation(RESOURCE_DOMAIN, TEXTURE_GUI_VANILLA);

}