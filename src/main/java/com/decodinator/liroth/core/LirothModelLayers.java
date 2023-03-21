package com.decodinator.liroth.core;

import com.decodinator.liroth.Liroth;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class LirothModelLayers {
	public static final ModelLayerLocation MODEL_LIROTH_BOAT_LAYER = new ModelLayerLocation(new ResourceLocation(Liroth.MOD_ID, "liroth_boat"), "main");
	public static final ModelLayerLocation MODEL_CHEST_LIROTH_BOAT_LAYER = new ModelLayerLocation(new ResourceLocation(Liroth.MOD_ID, "chest_liroth_boat"), "main");
	public static final ModelLayerLocation FORSAKEN_CORPSE = make("forsaken_corpse");
	public static final ModelLayerLocation FREAKSHOW = make("freakshow");
	public static final ModelLayerLocation FUNGAL_FIEND = make("fungal_fiend");
	public static final ModelLayerLocation LIROTHIAN_MIMIC = make("lirothian_mimic");
	public static final ModelLayerLocation PIER_PEEP = make("pier_peep");
	public static final ModelLayerLocation PROWLER = make("prowler");
	public static final ModelLayerLocation SHADE = make("shade");
	public static final ModelLayerLocation SKELETAL_FREAK = make("skeletal_freak");
	public static final ModelLayerLocation SOUL_ARACHNID = make("soul_arachnid");
	public static final ModelLayerLocation VILE_SHARK = make("vile_shark");
	public static final ModelLayerLocation WARP = make("warp");

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