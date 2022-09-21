package com.decodinator.liroth.core;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import com.decodinator.liroth.Liroth;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;


public class LirothRenders {
    public static void renderCutOuts() {
        Liroth.LOGGER.debug("Liroth: Rendering Texture Shits...");        
/*        ItemBlockRenderTypes.setRenderLayer(LirothBlocks.DAMNATION_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(LirothBlocks.JAPZ_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(LirothBlocks.KOOLAW_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(LirothBlocks.LIROTH_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(LirothBlocks.PETRIFIED_DAMNATION_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(LirothBlocks.SPICED_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(LirothBlocks.TALLPIER_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(LirothBlocks.LIROTH_GRASS.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(LirothBlocks.POINTED_JALSPHIRE_CRYSTAL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(LirothBlocks.POINTED_PETRIFIED_CRYSTAL.get(), RenderType.cutout());
        
        ItemBlockRenderTypes.setRenderLayer(LirothBlocks.DAMNATION_VINES_PLANT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(LirothBlocks.DAMNATION_VINES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(LirothBlocks.JAPZ_VINES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(LirothBlocks.JAPZ_VINES_PLANT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(LirothBlocks.PETRIFIED_VINES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(LirothBlocks.PETRIFIED_VINES_PLANT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(LirothBlocks.JAPZ_BLOSSOM.get(), RenderType.cutout());*/
        ItemBlockRenderTypes.setRenderLayer(LirothBlocks.DAMNATION_FUNGAL_FUSS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(LirothBlocks.DAMNATION_FUNGAL_HEAP.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(LirothBlocks.DAMNATION_FUNGAL_PATCH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(LirothBlocks.FUNGAL_LANTERN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(LirothBlocks.LIROTHIAN_PETROLEUM_LANTERN.get(), RenderType.cutout());
        
        ItemBlockRenderTypes.setRenderLayer(LirothBlocks.LIROTH_ROSE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(LirothBlocks.WILITING_LIROTH_ROSE.get(), RenderType.cutout());
//        ItemBlockRenderTypes.setRenderLayer(LirothBlocks.VILE_TENTACLE.get(), RenderType.cutout());
//        ItemBlockRenderTypes.setRenderLayer(LirothBlocks.VILE_TENTACLE_TIP.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(LirothBlocks.DAMNATION_FUNGAL_CLUSTER.get(), RenderType.cutout());
//        ItemBlockRenderTypes.setRenderLayer(LirothBlocks.DAMNATION_FUNGUS.get(), RenderType.cutout());
//        ItemBlockRenderTypes.setRenderLayer(LirothBlocks.SEA_EYE.get(), RenderType.cutout());
        
//        ItemBlockRenderTypes.setRenderLayer(LirothBlocks.CORRUPTED_BREWING_STAND.get(), RenderType.cutout());
        
/*        ItemBlockRenderTypes.setRenderLayer(LirothBlocks.FUNGAL_TORCH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(LirothBlocks.WALL_FUNGAL_TORCH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(LirothBlocks.LIROTHIAN_PETROLEUM_TORCH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(LirothBlocks.WALL_LIROTHIAN_PETROLEUM_TORCH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(LirothBlocks.FUNGAL_CAMPFIRE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(LirothBlocks.LIROTHIAN_PETROLEUM_CAMPFIRE.get(), RenderType.cutout());*/
        
        ItemBlockRenderTypes.setRenderLayer(LirothBlocks.DAMNATION_TRAPDOOR.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(LirothBlocks.JAPZ_TRAPDOOR.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(LirothBlocks.KOOLAW_TRAPDOOR.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(LirothBlocks.LIROTH_TRAPDOOR.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(LirothBlocks.PETRIFIED_DAMNATION_TRAPDOOR.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(LirothBlocks.SPICED_TRAPDOOR.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(LirothBlocks.TALLPIER_TRAPDOOR.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(LirothBlocks.LIROTHIAN_COBALT_TRAPDOOR.get(), RenderType.cutoutMipped());
        
        ItemBlockRenderTypes.setRenderLayer(LirothBlocks.DAMNATION_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(LirothBlocks.JAPZ_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(LirothBlocks.KOOLAW_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(LirothBlocks.LIROTH_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(LirothBlocks.PETRIFIED_DAMNATION_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(LirothBlocks.SPICED_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(LirothBlocks.TALLPIER_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(LirothBlocks.LIROTHIAN_COBALT_DOOR.get(), RenderType.cutout());
        
/*        ItemBlockRenderTypes.setRenderLayer(LirothBlocks.LIROTH_DIMENSION_PORTAL, RenderLayer.getTranslucent());
        ItemBlockRenderTypes.setRenderLayer(LirothBlocks.DAMNATION_DIMENSION_PORTAL, RenderLayer.getTranslucent());
        ItemBlockRenderTypes.setRenderLayer(LirothBlocks.JANTIRO_DIMENSION_PORTAL, RenderLayer.getTranslucent());
        ItemBlockRenderTypes.setRenderLayer(LirothBlocks.JALSPHIRE_DIMENSION_PORTAL, RenderLayer.getTranslucent());
        ItemBlockRenderTypes.setRenderLayer(LirothBlocks.DEVASTATED_DIMENSION_PORTAL, RenderLayer.getTranslucent());

        ItemBlockRenderTypes.setRenderLayer(LirothBlocks.LIROTH_FLUID, RenderLayer.getTranslucent());*/
        
        ItemBlockRenderTypes.setRenderLayer(LirothBlocks.LIROTH_GLASS_BLOCK.get(), RenderType.translucent());
//        ItemBlockRenderTypes.setRenderLayer(LirothBlocks.FORCEFIELD, RenderLayer.getTranslucent());
        
        Liroth.LOGGER.debug("Liroth: Texture Shits Rendered!");

    }
}