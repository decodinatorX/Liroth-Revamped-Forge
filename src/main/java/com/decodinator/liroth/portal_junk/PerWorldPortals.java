package com.decodinator.liroth.portal_junk;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import com.decodinator.liroth.portal_junk.util.PortalLink;

public class PerWorldPortals {
    private static final Set<Block> worldPortals = ConcurrentHashMap.newKeySet();

    public static void removeOldPortalsFromRegistry() {
        for (Block block : worldPortals) {
            CustomPortalApiRegistry.portals.remove(block);
        }
        worldPortals.clear();
    }

    @SuppressWarnings("deprecation")
	public static void registerWorldPortal(PortalLink portalLink) {
        if (!CustomPortalApiRegistry.portals.containsKey(BuiltInRegistries.BLOCK.get(portalLink.block))) {
            Block blockId = BuiltInRegistries.BLOCK.get(portalLink.block);
            worldPortals.add(blockId);
            CustomPortalApiRegistry.addPortal(blockId, portalLink);
        }
    }
}
