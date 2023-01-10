package com.decodinator.liroth.core;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.structures.LirothFortressStructure;
import com.decodinator.liroth.core.structures.NovaTowerStructure;
import com.decodinator.liroth.core.structures.OldenLirothPortalStructure;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class LirothStructures {

    public static final DeferredRegister<StructureType<?>> DEFERRED_REGISTRY_STRUCTURE = DeferredRegister.create(Registries.STRUCTURE_TYPE, Liroth.MOD_ID);
    
    public static final RegistryObject<StructureType<LirothFortressStructure>> LIROTH_FORTRESS = DEFERRED_REGISTRY_STRUCTURE.register("liroth_fortress", () -> () -> LirothFortressStructure.CODEC);
    public static final RegistryObject<StructureType<NovaTowerStructure>> NOVA_TOWER = DEFERRED_REGISTRY_STRUCTURE.register("nova_tower", () -> () -> NovaTowerStructure.CODEC);
    public static final RegistryObject<StructureType<OldenLirothPortalStructure>> OLDEN_LIROTH_PORTAL = DEFERRED_REGISTRY_STRUCTURE.register("olden_liroth_portal_structure", () -> () -> OldenLirothPortalStructure.CODEC);

}