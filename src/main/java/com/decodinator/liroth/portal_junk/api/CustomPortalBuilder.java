package com.decodinator.liroth.portal_junk.api;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import java.util.function.Consumer;
import java.util.function.Function;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.portal_junk.CustomPortalApiRegistry;
import com.decodinator.liroth.portal_junk.CustomPortalBlock;
import com.decodinator.liroth.portal_junk.portal.PortalIgnitionSource;
import com.decodinator.liroth.portal_junk.util.CPASoundEventData;
import com.decodinator.liroth.portal_junk.util.ColorUtil;
import com.decodinator.liroth.portal_junk.util.PortalLink;
import com.decodinator.liroth.portal_junk.util.SHOULDTP;

public class CustomPortalBuilder {
    private final PortalLink portalLink;

    private CustomPortalBuilder() {
        portalLink = new PortalLink();
    }

    /**
     * Begin the creation of a new Portal
     *
     * @return an instance of CustomPortalBuilder to begin configuring the portal
     */
    public static CustomPortalBuilder beginPortal() {
        return new CustomPortalBuilder();
    }

    /**
     * Register the portal when completed.
     * This should be called last, only when you are finished configuring the portal
     */
    @SuppressWarnings("deprecation")
	public void registerPortal() {
        CustomPortalApiRegistry.addPortal(BuiltInRegistries.BLOCK.get(portalLink.block), portalLink);
    }

    /**
     * Specify the Block Identifier to be used as the Frame
     *
     * @param blockID Block identifier of the portal's frame block
     */
    public CustomPortalBuilder frameBlock(ResourceLocation blockID) {
        portalLink.block = blockID;
        return this;
    }

    /**
     * Specify the Block to be used as the Frame
     *
     * @param block The Block to be used as the portal's frame block
     */
    @SuppressWarnings("deprecation")
	public CustomPortalBuilder frameBlock(Block block) {
        portalLink.block = BuiltInRegistries.BLOCK.getKey(block);
        return this;
    }

    /**
     * Specify the destination for the portal
     *
     * @param dimID Identifier of the Dimension the portal will travel to
     */
    public CustomPortalBuilder destDimID(ResourceLocation dimID) {
        portalLink.dimID = dimID;
        return this;
    }

    /**
     * Specify the color to be used to tint the portal block.
     *
     * @param color Single Color int value used for tinting. See {@link net.minecraft.world.item.DyeColor}
     */
    public CustomPortalBuilder tintColor(int color) {
        portalLink.colorID = color;
        return this;
    }

    /**
     * Specify the color in RGB to be used to tint the portal block.
     */
    public CustomPortalBuilder tintColor(int r, int g, int b) {
        portalLink.colorID = ColorUtil.getColorFromRGB(r, g, b);
        return this;
    }

    /**
     * This portal will be ignited by water
     */
    public CustomPortalBuilder lightWithWater() {
        portalLink.portalIgnitionSource = PortalIgnitionSource.WATER;
        return this;
    }

    /**
     * This portal will be ignited by an item
     *
     * @param item Item to be used to ignite the portal
     */
    public CustomPortalBuilder lightWithItem(Item item) {
        portalLink.portalIgnitionSource = PortalIgnitionSource.ItemUseSource(item);
        return this;
    }

    /**
     * This portal will be ignited by a fluid
     *
     * @param fluid Fluid to be used to ignite the portal
     */
    public CustomPortalBuilder lightWithFluid(Fluid fluid) {
        portalLink.portalIgnitionSource = PortalIgnitionSource.FluidSource(fluid);
        return this;
    }

    /**
     * Specify a Custom Ignition Source to be used to ignite the portal. You must manually trigger the ignition yourself.
     */
    public CustomPortalBuilder customIgnitionSource(ResourceLocation customSourceID) {
        portalLink.portalIgnitionSource = PortalIgnitionSource.CustomSource(customSourceID);
        return this;
    }

    /**
     * Specify a Custom Ignition Source to be used to ignite the portal. You must manually trigger the ignition yourself.
     */
    public CustomPortalBuilder customIgnitionSource(PortalIgnitionSource ignitionSource) {
        portalLink.portalIgnitionSource = ignitionSource;
        return this;
    }

    /**
     * Specify the forced size of the portal
     * Portal will only be ignitable for these exact dimensions
     *
     * @param width  Forced width of portal
     * @param height Forced height of portal
     */
    public CustomPortalBuilder forcedSize(int width, int height) {
        portalLink.forcedWidth = width;
        portalLink.forcedHeight = height;
        return this;
    }

    /**
     * Specify a custom block to be used as the portal block. Block must extend CustomPortalBlock
     */
    public CustomPortalBuilder customPortalBlock(CustomPortalBlock portalBlock) {
        portalLink.setPortalBlock(portalBlock);
        return this;
    }

    /**
     * Specify the dimension this portal will return you to
     *
     * @param returnDimID              Identifer of the dimmension the portal will return you to when leaving destination
     * @param onlyIgnitableInReturnDim Should this portal only be ignitable in returnDimID
     */
    public CustomPortalBuilder returnDim(ResourceLocation returnDimID, boolean onlyIgnitableInReturnDim) {
        portalLink.returnDimID = returnDimID;
        portalLink.onlyIgnitableInReturnDim = onlyIgnitableInReturnDim;
        return this;
    }

    /**
     * Specify that this portal can only be ignited in the Overworld
     * Attempting to light it in other dimensions will fail
     */
    public CustomPortalBuilder onlyLightInOverworld() {
        portalLink.onlyIgnitableInReturnDim = true;
        return this;
    }

    /**
     * Specify that this is a flat portal (end portal style)
     */
    public CustomPortalBuilder flatPortal() {
        portalLink.portalFrameTester = Liroth.FLATPORTAL_FRAMETESTER;
        return this;
    }

    /**
     * Specify a custom portal frame tester to be used.
     */
    public CustomPortalBuilder customFrameTester(ResourceLocation frameTester) {
        portalLink.portalFrameTester = frameTester;
        return this;
    }
    /**
     * Register an event to be called immediately before the specified entity is teleported.
     * The teleportation can be cancelled by returning SHOULDTP.CANCEL_TP
     */
    public CustomPortalBuilder registerBeforeTPEvent(Function<Entity, SHOULDTP> event) {
        portalLink.getBeforeTPEvent().register(event);
        return this;
    }

    /**
     * Register a sound to be played when the player in standing in the portal
     * CPASoundEventData is just a stub for PositionSoundAmbience as it does not exist serverside
     */
    public CustomPortalBuilder registerInPortalAmbienceSound(Function<Player, CPASoundEventData> event) {
        portalLink.getInPortalAmbienceEvent().register(event);
        return this;
    }

    /**
     * Register a sound to be played when the player teleports
     * CPASoundEventData is just a stub for PositionSoundAmbience as it does not exist serverside
     */
    public CustomPortalBuilder registerPostTPPortalAmbience(Function<Player, CPASoundEventData> event) {
        portalLink.getPostTpPortalAmbienceEvent().register(event);
        return this;
    }

    /**
     * Register an event to be called after the specified entity is teleported.
     */
    public CustomPortalBuilder registerPostTPEvent(Consumer<Entity> event) {
        portalLink.setPostTPEvent(event);
        return this;
    }
}
