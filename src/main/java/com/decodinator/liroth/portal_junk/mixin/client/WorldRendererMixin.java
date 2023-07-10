package com.decodinator.liroth.portal_junk.mixin.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import com.decodinator.liroth.portal_junk.CustomPortalApiRegistry;
import com.decodinator.liroth.portal_junk.util.PortalLink;

@Mixin(value = LevelRenderer.class, remap=false)
public class WorldRendererMixin {

    @Shadow
    @Final
    private Minecraft client;

    @Redirect(method = "levelEvent", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/sounds/SoundManager;play(Lnet/minecraft/client/resources/sounds/SoundInstance;)V"))
    public void CPA$postTPSoundEvent(SoundManager instance, SoundInstance sound, int eventId, BlockPos pos, int data) {
        if (eventId == 1032 && data != 0) {
            @SuppressWarnings("deprecation")
			Block block = BuiltInRegistries.BLOCK.byId(data);
            PortalLink link = CustomPortalApiRegistry.getPortalLinkFromBase(block);
            if (link != null && link.getPostTpPortalAmbienceEvent().hasEvent())
                instance.play(link.getPostTpPortalAmbienceEvent().execute(client.player).getInstance());
        } else {
            instance.play(sound);
        }
    }
}