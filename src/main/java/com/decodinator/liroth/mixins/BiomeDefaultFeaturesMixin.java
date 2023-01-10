package com.decodinator.liroth.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.decodinator.liroth.core.LirothPlacedFeatures;

import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.levelgen.GenerationStep;

@Mixin(BiomeDefaultFeatures.class)
public class BiomeDefaultFeaturesMixin {

	@Inject(method = "addDefaultOres()V", at = @At("TAIL"), remap = false)
	private void putLirothOresInDef(BiomeGenerationSettings.Builder p_194723_, boolean p_194724_, CallbackInfo ci) {
	      p_194723_.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, LirothPlacedFeatures.OVERWORLD_LIROTH_ORE);
	      p_194723_.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, LirothPlacedFeatures.TOURMALINE_ORE);
	}
	
	@Inject(method = "addDefaultOres()V", at = @At("TAIL"), remap = false)
	private void putNetherLirothOresInDef(BiomeGenerationSettings.Builder p_194723_, CallbackInfo ci) {
	      p_194723_.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, LirothPlacedFeatures.NETHER_LIROTH_ORE);
	}
}
