package com.decodinator.liroth.portal_junk.mixin.client;

import com.decodinator.liroth.portal_junk.CustomPortalApiRegistry;
import com.decodinator.liroth.portal_junk.interfaces.ClientPlayerInColoredPortal;
import com.decodinator.liroth.portal_junk.interfaces.EntityInCustomPortal;
import com.decodinator.liroth.portal_junk.util.CustomPortalHelper;
import com.decodinator.liroth.portal_junk.util.PortalLink;
import com.mojang.authlib.GameProfile;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@OnlyIn(Dist.CLIENT)
@Mixin(value = LocalPlayer.class, remap=false)
public abstract class ClientPlayerMixin extends Player implements EntityInCustomPortal, ClientPlayerInColoredPortal {

    @Shadow
    public float nauseaIntensity;

    @Shadow
    public float prevNauseaIntensity;

    @Shadow
    @Final
    protected Minecraft client;

    public ClientPlayerMixin(Level world, BlockPos pos, float yaw, GameProfile profile) {
        super(world, pos, yaw, profile);
    }

    @Shadow
    public abstract void m_6915_();

    int portalColor;

    @Override
    public void setLastUsedPortalColor(int color) {
        this.portalColor = color;

    }

    @Override
    public int getLastUsedPortalColor() {
        return portalColor;
    }


    @Inject(method = "handleNetherPortalClient", at = @At(value = "HEAD"), cancellable = true)
    public void injectCustomNausea(CallbackInfo ci) {
        if (this.isInsidePortal) {
            setLastUsedPortalColor(-1);
        } else if (this.getTimeInPortal() > 0) {
            int previousColor = getLastUsedPortalColor();
            PortalLink link = this.getInPortalPos() != null ? CustomPortalApiRegistry.getPortalLinkFromBase(CustomPortalHelper.getPortalBase(this.level(), this.getInPortalPos())) : null;
            if (link != null)
                setLastUsedPortalColor(link.colorID);
            updateCustomNausea(previousColor);
            ci.cancel();
        }
    }

    @Unique
    private void updateCustomNausea(int previousColor) {
        this.prevNauseaIntensity = this.nauseaIntensity;
        if (this.getTimeInPortal() > 0) {
            if (this.client.screen != null && !this.client.screen.isPauseScreen()) {
                if (this.client.screen instanceof AbstractContainerScreen) {
                    this.m_6915_();
                }
                this.client.setScreen(null);
            }

            if (this.nauseaIntensity == 0.0F && previousColor != -999) { //previous color prevents this from playing after a teleport. A tp sets the previousColor to -999
                PortalLink link = CustomPortalApiRegistry.getPortalLinkFromBase(CustomPortalHelper.getPortalBase(level(), getInPortalPos()));
                if (link != null && link.getInPortalAmbienceEvent().hasEvent()) {
                    this.client.getSoundManager().play(link.getInPortalAmbienceEvent().execute(this).getInstance());
                } else
                    this.client.getSoundManager().play(SimpleSoundInstance.forLocalAmbience(SoundEvents.PORTAL_TRIGGER, this.random.nextFloat() * 0.4F + 0.8F, 0.25F));
            }

            this.nauseaIntensity += 0.0125F;
            if (this.nauseaIntensity >= 1.0F) {
                this.nauseaIntensity = 1.0F;
            }
        } else if (this.hasEffect(MobEffects.CONFUSION) && this.getEffect(MobEffects.CONFUSION).getDuration() > 60) {
            this.nauseaIntensity += 0.006666667F;
            if (this.nauseaIntensity > 1.0F) {
                this.nauseaIntensity = 1.0F;
            }
        } else {
            if (this.nauseaIntensity > 0.0F) {
                this.nauseaIntensity -= 0.05F;
            }

            if (this.nauseaIntensity < 0.0F) {
                this.nauseaIntensity = 0.0F;
            }
        }
    }
}
