package com.decodinator.liroth.core.entities.renderers;

import com.decodinator.liroth.core.entities.projectiles.BeamLaserProjectileEntity;

import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BeamLaserProjectileEntityRenderer
extends ArrowRenderer<BeamLaserProjectileEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("liroth", "textures/entity/beam.png");

    public BeamLaserProjectileEntityRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(BeamLaserProjectileEntity arrowEntity) {
        return TEXTURE;
    }
}
