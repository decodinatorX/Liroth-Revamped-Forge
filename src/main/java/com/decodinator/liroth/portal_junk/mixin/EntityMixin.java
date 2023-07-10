package com.decodinator.liroth.portal_junk.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.portal.PortalInfo;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.decodinator.liroth.portal_junk.interfaces.CustomTeleportingEntity;
import com.decodinator.liroth.portal_junk.interfaces.EntityInCustomPortal;

@Mixin(value = Entity.class,remap=false)
public abstract class EntityMixin implements EntityInCustomPortal, CustomTeleportingEntity {

    @Unique
    boolean didTP = false;

    @Unique
    int timeInPortal = 0, maxTimeInPortal = 80, cooldown = 0;

    @Unique
    private BlockPos inPortalPos;

    @Unique
    @Override
    public boolean didTeleport() {
        return didTP;
    }

    @Unique
    @Override
    public void setDidTP(boolean didTP) {
        this.didTP = didTP;
        if (didTP) {
            timeInPortal = maxTimeInPortal;
            cooldown = 10;
        } else {
            timeInPortal = 0;
            cooldown = 0;
        }
        //inPortalPos = null;
    }

    @Unique
    @Override
    public int getTimeInPortal() {
        return timeInPortal;
    }

    @Unique
    @Override
    public void tickInPortal(BlockPos portalPos) {
        cooldown = 10;
        inPortalPos = portalPos;
    }

    @Unique
    @Override
    public BlockPos getInPortalPos() {
        return inPortalPos;
    }

    @Inject(method = "tick", at = @At(value = "TAIL"))
    public void CPAinCustomPortal(CallbackInfo ci) {
        if (cooldown > 0) {
            cooldown--;
            timeInPortal = Math.min(timeInPortal + 1, maxTimeInPortal);
            if (cooldown <= 0) {
                setDidTP(false);
            }
        }
    }

    private PortalInfo customTPTarget;

    @Unique
    @Override
    public void setCustomTeleportTarget(PortalInfo teleportTarget) {
        this.customTPTarget = teleportTarget;
    }

    @Unique
    @Override
    public PortalInfo getCustomTeleportTarget() {
        return customTPTarget;
    }

    @Inject(method = "findDimensionEntryPoint", at = @At("HEAD"), cancellable = true)
    public void CPAgetCustomTPTarget(ServerLevel destination, CallbackInfoReturnable<PortalInfo> cir) {
        if (this.didTeleport())
            cir.setReturnValue(getCustomTeleportTarget());
    }

//    @Redirect(method = "moveToWorld", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/world/ServerWorld;createEndSpawnPlatform(Lnet/minecraft/server/world/ServerWorld;)V"))
//    public void CPAcancelEndPlatformSpawn(ServerWorld world) {
//        if (this.didTeleport())
//            return;
//        ServerWorld.createEndSpawnPlatform(world);
//    }

//    @Redirect(method = "moveToWorld", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/world/ServerWorld;getRegistryKey()Lnet/minecraft/util/registry/RegistryKey;", ordinal = 0))
//    public abstract RegistryKey<World> CPApreventEndCredits(ServerWorld serverWorld);


    @Inject(method = "load", at = @At(value = "TAIL"))
    public void CPAreadCustomPortalFromTag(CompoundTag tag, CallbackInfo ci) {
        this.didTP = tag.getBoolean("cpadidTP");
        this.cooldown = tag.getInt("cpaCooldown");
    }

    @Inject(method = "saveWithoutId", at = @At(value = "RETURN"))
    public void CPAwriteCustomPortalToTag(CompoundTag tag, CallbackInfoReturnable<CompoundTag> cir) {
        cir.getReturnValue().putBoolean("cpadidTP", didTP);
        cir.getReturnValue().putInt("cpaCooldown", cooldown);
    }

//    @Redirect(method = "moveToWorld", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/network/ServerPlayNetworkHandler;sendPacket(Lnet/minecraft/network/Packet;)V"))
//    public abstract void CPAmodifyWorldEventPacket(ServerPlayNetworkHandler instance, Packet<?> packet);
}