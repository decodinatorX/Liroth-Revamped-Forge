package com.decodinator.liroth.portal_junk.client;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.portal_junk.networking.ForcePlacePortalPacket;
import com.decodinator.liroth.portal_junk.util.CustomPortalHelper;

import net.minecraft.client.Minecraft;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class ClientHandler {
    public static void forcePortal(ForcePlacePortalPacket packet) {
        Minecraft.getInstance().execute(() -> {
            @SuppressWarnings("resource")
			Level world = Minecraft.getInstance().level;
            BlockState oldState = world.getBlockState(packet.pos());
            world.setBlockAndUpdate(packet.pos(), CustomPortalHelper.blockWithAxis(Liroth.getDefaultPortalBlock().defaultBlockState(), CustomPortalHelper.getAxisFrom(oldState)));
        });
    }
}
