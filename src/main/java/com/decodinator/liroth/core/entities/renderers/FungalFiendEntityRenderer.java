package com.decodinator.liroth.core.entities.renderers;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.LirothModelLayers;
import com.decodinator.liroth.core.entities.FungalFiendEntity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class FungalFiendEntityRenderer extends MobRenderer<FungalFiendEntity, FungalFiendModel<FungalFiendEntity>> {

    public FungalFiendEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new FungalFiendModel(context.bakeLayer(LirothModelLayers.FUNGAL_FIEND)), 0.5f);
        this.addLayer(new FungalFiendFaceFeatureRenderer<FungalFiendEntity>(this));
    }
 
    @Override
    public ResourceLocation getTextureLocation(FungalFiendEntity entity) {
        return new ResourceLocation("liroth", "textures/entity/fungal_fiend/fungal_fiend.png");
        
    }
}
