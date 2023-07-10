package com.decodinator.liroth.portal_junk.portal;

import java.util.HashSet;
import java.util.function.BiFunction;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;

public class PortalIgnitionSource {
	@SuppressWarnings("deprecation")
	public final static PortalIgnitionSource FIRE = new PortalIgnitionSource(SourceType.BLOCKPLACED, BuiltInRegistries.BLOCK.getKey(Blocks.FIRE));
    public final static PortalIgnitionSource WATER = FluidSource(Fluids.WATER);

    public enum SourceType {
        USEITEM, BLOCKPLACED, FLUID, CUSTOM
    }

    private static final HashSet<Item> USEITEMS = new HashSet<>();
    public SourceType sourceType;
    public ResourceLocation ignitionSourceID;

    private PortalIgnitionSource(SourceType sourceType, ResourceLocation ignitionSourceID) {
        this.sourceType = sourceType;
        this.ignitionSourceID = ignitionSourceID;
    }

    @SuppressWarnings("deprecation")
	public static PortalIgnitionSource ItemUseSource(Item item) {
        USEITEMS.add(item);
        return new PortalIgnitionSource(SourceType.USEITEM, BuiltInRegistries.ITEM.getKey(item));
    }

    @SuppressWarnings("deprecation")
	public static PortalIgnitionSource FluidSource(Fluid fluid) {
        return new PortalIgnitionSource(SourceType.FLUID, BuiltInRegistries.FLUID.getKey(fluid));
    }

    public static PortalIgnitionSource CustomSource(ResourceLocation ignitionSourceID) {
        return new PortalIgnitionSource(SourceType.CUSTOM, ignitionSourceID);
    }

    // TODO: implement
    @Deprecated
    public void withCondition(BiFunction<Level, BlockPos, Boolean> condition) {

    }

    public boolean isWater() {
        return FluidTags.WATER.isFor(Registries.FLUID);
    }

    public boolean isLava() {
        return FluidTags.LAVA.isFor(Registries.FLUID);
    }

    public static boolean isRegisteredIgnitionSourceWith(Item item) {
        return USEITEMS.contains(item);
    }
}
