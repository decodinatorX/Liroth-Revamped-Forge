package com.decodinator.liroth.portal_junk.interfaces;

import net.minecraft.core.BlockPos;

public interface EntityInCustomPortal {

    int getTimeInPortal();

    boolean didTeleport();

    void setDidTP(boolean didTP);

    void tickInPortal(BlockPos portalPos);

    BlockPos getInPortalPos();
}
