package com.decodinator.liroth.portal_junk;

import java.util.Set;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.LirothBlocks;
import com.google.common.collect.ImmutableSet;

import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class LirothPOIs {

    public static final DeferredRegister<PoiType> POI = DeferredRegister.create(ForgeRegistries.POI_TYPES, Liroth.MOD_ID);

/*    public static final RegistryObject<PoiType> LIROTH_PORTAL = POI.register("liroth_portal", () -> new PoiType(getBlockStates(LirothBlocks.LIROTH_DIMENSION_PORTAL.get()), 0, 1));
    public static final RegistryObject<PoiType> DAMNATION_PORTAL = POI.register("damnation_portal", () -> new PoiType(getBlockStates(LirothBlocks.DAMNATION_DIMENSION_PORTAL.get()), 0, 1));
    public static final RegistryObject<PoiType> JANTIRO_PORTAL = POI.register("jantiro_portal", () -> new PoiType(getBlockStates(LirothBlocks.JANTIRO_DIMENSION_PORTAL.get()), 0, 1));
    public static final RegistryObject<PoiType> JALSPHIRE_PORTAL = POI.register("jalsphire_portal", () -> new PoiType(getBlockStates(LirothBlocks.JALSPHIRE_DIMENSION_PORTAL.get()), 0, 1));
    public static final RegistryObject<PoiType> DEVASTATED_PORTAL = POI.register("devastated_portal", () -> new PoiType(getBlockStates(LirothBlocks.DEVASTATED_DIMENSION_PORTAL.get()), 0, 1));
*/
    private static Set<BlockState> getBlockStates(Block block) {
        return ImmutableSet.copyOf(block.getStateDefinition().getPossibleStates());
    }
}
