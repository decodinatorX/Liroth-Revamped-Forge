package com.decodinator.liroth.core;

import com.decodinator.liroth.Liroth;
import com.teamabnormals.blueprint.common.entity.BlueprintBoat;
import com.teamabnormals.blueprint.common.entity.BlueprintChestBoat;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityType.Builder;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class LirothEntities {

	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Liroth.MOD_ID);

	public static final RegistryObject<EntityType<LirothBoat>> LIROTH_BOAT = ENTITIES.register("liroth_boat", () -> EntityType.Builder.<LirothBoat>of(LirothBoat::new, MobCategory.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10).build(new ResourceLocation(Liroth.MOD_ID, "liroth_boat").toString()));
	public static final RegistryObject<EntityType<LirothBoat>> LIROTH_CHEST_BOAT = ENTITIES.register("liroth_chest_boat", () -> EntityType.Builder.<LirothBoat>of(LirothBoat::new, MobCategory.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10).build(new ResourceLocation(Liroth.MOD_ID, "liroth_boat").toString()));

}
