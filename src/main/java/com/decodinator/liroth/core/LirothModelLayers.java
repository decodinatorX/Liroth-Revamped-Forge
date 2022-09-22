package com.decodinator.liroth.core;

import com.decodinator.liroth.Liroth;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class LirothModelLayers {

	public static final ModelLayerLocation POTESTIUM_HELMET = make("potestium_helmet");

	private static ModelLayerLocation make(String name) {
		return make(name, "main");
	}

	private static ModelLayerLocation make(String name, String layer) {
		// Don't add to vanilla's ModelLayers. It seems to only be used for error checking
		// And would be annoying to do under Forge's parallel mod loading
		return new ModelLayerLocation(prefix(name), layer);
	}
	
	public static ResourceLocation prefix(String path) {
		return new ResourceLocation(Liroth.MOD_ID, path);
	}

	public static void init() {}
}