package com.decodinator.liroth.portal_junk.mixin.client;

import net.minecraft.client.ClientRecipeBook;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.multiplayer.MultiPlayerGameMode;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.stats.StatsCounter;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import com.decodinator.liroth.portal_junk.interfaces.ClientPlayerInColoredPortal;

@Mixin(value = ClientPacketListener.class, remap=false)
public class ClientPlayNetworkHandlerMixin {

    @Redirect(method = "handleRespawn", at = @At(value = "INVOKE", target = "Lnet/minecraft/network/protocol/game/ClientGamePacketListener;handleRespawn(Lnet/minecraft/network/protocol/game/ClientboundRespawnPacket;)V"))
    public LocalPlayer teleported(MultiPlayerGameMode instance, ClientLevel world, StatsCounter statHandler, ClientRecipeBook recipeBook, boolean lastSneaking, boolean lastSprinting) {
        LocalPlayer newPlayer = instance.createPlayer(world, statHandler, recipeBook, lastSneaking, lastSprinting);
        ((ClientPlayerInColoredPortal) newPlayer).setLastUsedPortalColor(-999);
        return newPlayer;
    }
}