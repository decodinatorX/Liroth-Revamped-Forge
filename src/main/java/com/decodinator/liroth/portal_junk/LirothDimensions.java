package com.decodinator.liroth.portal_junk;

import com.decodinator.liroth.Liroth;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

public class LirothDimensions {

    public static final ResourceKey<Level> LIROTH = ResourceKey.create(Registry.DIMENSION_REGISTRY, name("liroth_dimension"));
    public static final ResourceKey<Level> DAMNATION = ResourceKey.create(Registry.DIMENSION_REGISTRY, name("damnation"));
    public static final ResourceKey<Level> JANTIROS_ESCAPE = ResourceKey.create(Registry.DIMENSION_REGISTRY, name("jantiros_escape_dimension"));
    public static final ResourceKey<Level> JALSPHIRE_PLAINS = ResourceKey.create(Registry.DIMENSION_REGISTRY, name("jalsphire_plains"));
    public static final ResourceKey<Level> DEVASTATED_PLAINS = ResourceKey.create(Registry.DIMENSION_REGISTRY, name("devastated_plains"));

    private static ResourceLocation name(String name) {
        return new ResourceLocation(Liroth.MOD_ID, name);
    }
}