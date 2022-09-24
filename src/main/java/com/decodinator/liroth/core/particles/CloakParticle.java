package com.decodinator.liroth.core.particles;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class CloakParticle extends TextureSheetParticle {
	   protected CloakParticle(ClientLevel p_107631_, double p_107632_, double p_107633_, double p_107634_, double p_107635_, double p_107636_, double p_107637_) {
		      super(p_107631_, p_107632_, p_107633_, p_107634_, p_107635_, p_107636_, p_107637_);
		      this.friction = 0.96F;
		      this.xd = this.xd * (double)0.01F + p_107635_;
		      this.yd = this.yd * (double)0.01F + p_107636_;
		      this.zd = this.zd * (double)0.01F + p_107637_;
		      this.x += (double)((this.random.nextFloat() - this.random.nextFloat()) * 0.05F);
		      this.y += (double)((this.random.nextFloat() - this.random.nextFloat()) * 0.05F);
		      this.z += (double)((this.random.nextFloat() - this.random.nextFloat()) * 0.05F);
		      this.lifetime = (int)(8.0D / (Math.random() * 0.8D + 0.2D)) + 4;
		   }

	@Override
	   public ParticleRenderType getRenderType() {
	      return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
	   }
	
	   @OnlyIn(Dist.CLIENT)
	   public static class Provider implements ParticleProvider<SimpleParticleType> {
	      private final SpriteSet sprite;

	      public Provider(SpriteSet p_106827_) {
	         this.sprite = p_106827_;
	      }

	      public Particle createParticle(SimpleParticleType p_106838_, ClientLevel p_106839_, double p_106840_, double p_106841_, double p_106842_, double p_106843_, double p_106844_, double p_106845_) {
	    	  CloakParticle flameparticle = new CloakParticle(p_106839_, p_106840_, p_106841_, p_106842_, p_106843_, p_106844_, p_106845_);
	         flameparticle.pickSprite(this.sprite);
	         return flameparticle;
	      }
	   }
}