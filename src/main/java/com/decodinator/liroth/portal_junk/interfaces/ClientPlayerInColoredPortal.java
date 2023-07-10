package com.decodinator.liroth.portal_junk.interfaces;


import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public interface ClientPlayerInColoredPortal {

    void setLastUsedPortalColor(int color);

    int getLastUsedPortalColor();

}
