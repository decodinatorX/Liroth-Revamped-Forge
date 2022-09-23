package com.decodinator.liroth.core;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.blocks.entities.DamnationChestBlockEntity;
import com.decodinator.liroth.core.blocks.entities.JapzChestBlockEntity;
import com.decodinator.liroth.core.blocks.entities.KoolawChestBlockEntity;
import com.decodinator.liroth.core.blocks.entities.LirothChestBlockEntity;
import com.decodinator.liroth.core.blocks.entities.PetrifiedDamnationChestBlockEntity;
import com.decodinator.liroth.core.blocks.entities.SpicedChestBlockEntity;
import com.decodinator.liroth.core.blocks.entities.TallpierChestBlockEntity;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class LirothBlockEntities {
	
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Liroth.MOD_ID);

	public static final RegistryObject<BlockEntityType<LirothChestBlockEntity>> LIROTH_CHEST = BLOCK_ENTITIES.register("liroth_chest", () -> BlockEntityType.Builder.of(LirothChestBlockEntity::new, LirothBlocks.LIROTH_CHEST.get()).build(null));
	public static final RegistryObject<BlockEntityType<DamnationChestBlockEntity>> DAMNATION_CHEST = BLOCK_ENTITIES.register("damnation_chest", () -> BlockEntityType.Builder.of(DamnationChestBlockEntity::new, LirothBlocks.DAMNATION_CHEST.get()).build(null));
	public static final RegistryObject<BlockEntityType<SpicedChestBlockEntity>> SPICED_CHEST = BLOCK_ENTITIES.register("spiced_chest", () -> BlockEntityType.Builder.of(SpicedChestBlockEntity::new, LirothBlocks.SPICED_CHEST.get()).build(null));
	public static final RegistryObject<BlockEntityType<TallpierChestBlockEntity>> TALLPIER_CHEST = BLOCK_ENTITIES.register("tallpier_chest", () -> BlockEntityType.Builder.of(TallpierChestBlockEntity::new, LirothBlocks.TALLPIER_CHEST.get()).build(null));
	public static final RegistryObject<BlockEntityType<JapzChestBlockEntity>> JAPZ_CHEST = BLOCK_ENTITIES.register("japz_chest", () -> BlockEntityType.Builder.of(JapzChestBlockEntity::new, LirothBlocks.JAPZ_CHEST.get()).build(null));
	public static final RegistryObject<BlockEntityType<KoolawChestBlockEntity>> KOOLAW_CHEST = BLOCK_ENTITIES.register("koolaw_chest", () -> BlockEntityType.Builder.of(KoolawChestBlockEntity::new, LirothBlocks.KOOLAW_CHEST.get()).build(null));
	public static final RegistryObject<BlockEntityType<PetrifiedDamnationChestBlockEntity>> PETRIFIED_DAMNATION_CHEST = BLOCK_ENTITIES.register("petrified_damnation_chest", () -> BlockEntityType.Builder.of(PetrifiedDamnationChestBlockEntity::new, LirothBlocks.PETRIFIED_DAMNATION_CHEST.get()).build(null));

}
