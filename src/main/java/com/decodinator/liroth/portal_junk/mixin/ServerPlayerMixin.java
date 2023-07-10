package com.decodinator.liroth.portal_junk.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundLevelEventPacket;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.portal_junk.interfaces.EntityInCustomPortal;
import com.decodinator.liroth.portal_junk.util.CustomPortalHelper;

@Mixin(value = ServerPlayer.class, remap=false)
public abstract class ServerPlayerMixin extends PlayerMixin implements EntityInCustomPortal {
    int portalFrameBlockID;

    @SuppressWarnings("deprecation")
	public ResourceKey<Level> CPApreventEndCredits(ServerLevel serverWorld) {
        if (this.didTeleport()) {
            Block portalFrame = CustomPortalHelper.getPortalBase(serverWorld, getInPortalPos());
            portalFrameBlockID = BuiltInRegistries.BLOCK.getId(portalFrame);
            return ResourceKey.create(Registries.DIMENSION, new ResourceLocation(Liroth.MOD_ID, "nullworld"));
        }
        return serverWorld.dimension();
    }

    @Inject(method = "createEndSpawnPlatform", at = @At("HEAD"), cancellable = true)
    public void CPAcancelEndPlatformSpawn(ServerLevel world, BlockPos centerPos, CallbackInfo ci) {
        if (this.didTeleport()) ci.cancel();
    }

    public void CPAmodifyWorldEventPacket(ServerGamePacketListenerImpl instance, Packet<?> packet) {
        if (packet instanceof ClientboundLevelEventPacket && portalFrameBlockID != 0) {
            instance.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, portalFrameBlockID, false));
            portalFrameBlockID = 0;
        } else
            instance.send(packet);
    }
}
