package com.decodinator.liroth.core.entities.renderers;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.LirothModelLayers;
import com.decodinator.liroth.core.entities.SkeletalFreakEntity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SkeletalFreakEntityRenderer extends MobRenderer<SkeletalFreakEntity, SkeletalFreakModel<SkeletalFreakEntity>> {

    public SkeletalFreakEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new SkeletalFreakModel(context.bakeLayer(LirothModelLayers.SKELETAL_FREAK)), 0.5f);
        this.addLayer(new SkeletalFreakFaceFeatureRenderer<SkeletalFreakEntity>(this));
    }
 
    @Override
    public ResourceLocation getTextureLocation(SkeletalFreakEntity entity) {
        return new ResourceLocation("liroth", "textures/entity/skeletal_freak/skeletal_freak.png");
        
    }
}
