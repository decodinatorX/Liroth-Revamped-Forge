package com.decodinator.liroth.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.decodinator.liroth.core.LirothBoat;
import com.mojang.authlib.GameProfile;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.player.Input;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.player.ProfilePublicKey;

@Mixin(LocalPlayer.class)
public abstract class ClientPlayerEntityMixin extends AbstractClientPlayer {
	
    @Shadow(remap = true)
    private boolean handsBusy;

    @Shadow(remap = false)
    public Input input;

    public ClientPlayerEntityMixin(ClientLevel world, GameProfile profile, ProfilePublicKey publicKey) {
        super(world, profile, publicKey);
    }


    @Inject(at = @At("HEAD"), method = "rideTick", remap = false)
    public void rideTick(CallbackInfo ci) {
        this.handsBusy = false;
        if (this.getVehicle() instanceof LirothBoat) {
        	LirothBoat boatEntity = (LirothBoat)this.getVehicle();
            boatEntity.setInput(this.input.left, this.input.right, this.input.up, this.input.down);
            this.handsBusy |= this.input.left || this.input.right || this.input.up || this.input.down;
        }
    }
}