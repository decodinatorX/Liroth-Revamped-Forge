package com.decodinator.liroth.portal_junk.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import java.util.function.Consumer;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.LirothBlocks;
import com.decodinator.liroth.portal_junk.CustomPortalApiRegistry;
import com.decodinator.liroth.portal_junk.CustomPortalBlock;
import com.decodinator.liroth.portal_junk.portal.PortalIgnitionSource;
import com.decodinator.liroth.portal_junk.portal.frame.PortalFrameTester;

public class PortalLink {
    public ResourceLocation block;
    public PortalIgnitionSource portalIgnitionSource = PortalIgnitionSource.FIRE;
    private CustomPortalBlock portalBlock = LirothBlocks.customPortalBlock.get();
    public ResourceLocation dimID;
    public ResourceLocation returnDimID = new ResourceLocation("overworld");
    public boolean onlyIgnitableInReturnDim = false;
    public int colorID;
    public int forcedWidth, forcedHeight;
    public ResourceLocation portalFrameTester = Liroth.VANILLAPORTAL_FRAMETESTER;

    private Consumer<Entity> postTPEvent;
    private final CPAEvent<Entity, SHOULDTP> beforeTPEvent = new CPAEvent<>(SHOULDTP.CONTINUE_TP);
    private final CPAEvent<Player, CPASoundEventData> inPortalAmbienceEvent = new CPAEvent<>();
    private final CPAEvent<Player, CPASoundEventData> postTpPortalAmbienceEvent = new CPAEvent<>();

    public PortalLink() {

    }

    public PortalLink(ResourceLocation blockID, ResourceLocation dimID, int colorID) {
        this.block = blockID;
        this.dimID = dimID;
        this.colorID = colorID;
    }

    public CustomPortalBlock getPortalBlock() {
        return portalBlock;
    }

    public void setPortalBlock(CustomPortalBlock block) {
        this.portalBlock = block;
    }

    public boolean doesIgnitionMatch(PortalIgnitionSource attemptedSource) {
        return portalIgnitionSource.sourceType == attemptedSource.sourceType && portalIgnitionSource.ignitionSourceID.equals(attemptedSource.ignitionSourceID);
    }

    public boolean canLightInDim(ResourceLocation dim) {
        if (!onlyIgnitableInReturnDim) return true;
        return dim.equals(returnDimID) || dim.equals(dimID);
    }


    public CPAEvent<Entity, SHOULDTP> getBeforeTPEvent() {
        return beforeTPEvent;
    }

    public CPAEvent<Player, CPASoundEventData> getInPortalAmbienceEvent() {
        return inPortalAmbienceEvent;
    }

    public CPAEvent<Player, CPASoundEventData> getPostTpPortalAmbienceEvent() {
        return postTpPortalAmbienceEvent;
    }

    public void setPostTPEvent(Consumer<Entity> event) {
        postTPEvent = event;
    }

    public void executePostTPEvent(Entity entity) {
        if (postTPEvent != null)
            postTPEvent.accept(entity);
    }

    public PortalFrameTester.PortalFrameTesterFactory getFrameTester() {
        return CustomPortalApiRegistry.getPortalFrameTester(portalFrameTester);
    }
}