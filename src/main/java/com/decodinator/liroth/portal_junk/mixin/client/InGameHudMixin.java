package com.decodinator.liroth.portal_junk.mixin.client;

import com.decodinator.liroth.core.LirothBlocks;
import com.decodinator.liroth.portal_junk.interfaces.ClientPlayerInColoredPortal;
import com.decodinator.liroth.portal_junk.util.ColorUtil;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.block.BlockModelShaper;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@OnlyIn(Dist.CLIENT)
@Mixin(value = Gui.class, remap=false)
public class InGameHudMixin {

    @Shadow
    @Final
    protected Minecraft client;

    @Redirect(method = "m_280379_", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphics;m_280246_(FFFF)V"))
    public void changeColor(GuiGraphics context, float red, float green, float blue, float alpha) {
        int color = ((ClientPlayerInColoredPortal) client.player).getLastUsedPortalColor();
        if (color >= 0) {
            float[] colors = ColorUtil.getColorForBlock(color);
            RenderSystem.setShaderColor(colors[0], colors[1], colors[2], alpha);
        } else
            RenderSystem.setShaderColor(red, green, blue, alpha);
    }

    @SuppressWarnings("deprecation")
	@Redirect(method = "m_280379_", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/block/BlockModelShaper;getParticleIcon(Lnet/minecraft/world/level/block/state/BlockState;)Lnet/minecraft/client/renderer/texture/TextureAtlasSprite;"))
    public TextureAtlasSprite renderCustomPortalOverlay(BlockModelShaper blockModels, BlockState blockState) {
        if (((ClientPlayerInColoredPortal) client.player).getLastUsedPortalColor() >= 0) {
            return this.client.getBlockRenderer().getBlockModelShaper().getParticleIcon(LirothBlocks.customPortalBlock.get().defaultBlockState());
        }
        return this.client.getBlockRenderer().getBlockModelShaper().getParticleIcon(Blocks.NETHER_PORTAL.defaultBlockState());
    }
}
