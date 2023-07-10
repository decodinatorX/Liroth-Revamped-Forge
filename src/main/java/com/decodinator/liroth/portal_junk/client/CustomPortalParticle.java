package com.decodinator.liroth.portal_junk.client;

import com.decodinator.liroth.portal_junk.CustomPortalApiRegistry;
import com.decodinator.liroth.portal_junk.util.ColorUtil;
import com.decodinator.liroth.portal_junk.util.PortalLink;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.PortalParticle;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class CustomPortalParticle extends PortalParticle {
    protected CustomPortalParticle(ClientLevel clientWorld, double d, double e, double f, double g, double h, double i) {
        super(clientWorld, d, e, f, g, h, i);
    }

    @OnlyIn(Dist.CLIENT)
    public static class Factory implements ParticleProvider<BlockParticleOption> {
        private final SpriteSet spriteProvider;

        public Factory(SpriteSet spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        public Particle createParticle(BlockParticleOption blockStateParticleEffect, ClientLevel clientWorld, double d, double e, double f, double g, double h, double i) {
            // Particle portalParticle = (new PortalParticle.Factory(spriteProvider).createParticle(null,clientWorld,d,e,f,g,h,i));
            CustomPortalParticle portalParticle = new CustomPortalParticle(clientWorld, d, e, f, g, h, i);
            portalParticle.pickSprite(this.spriteProvider);
            Block block = blockStateParticleEffect.getState().getBlock();
            PortalLink link = CustomPortalApiRegistry.getPortalLinkFromBase(block);
            if (link != null) {
                float[] rgb = ColorUtil.getColorForBlock(link.colorID);
                portalParticle.setColor(rgb[0], rgb[1], rgb[2]);
            }
            return portalParticle;
        }
    }
}
