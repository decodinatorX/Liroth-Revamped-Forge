package com.decodinator.liroth.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

import com.decodinator.liroth.Liroth;

import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CarpetBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.LanternBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.MossBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SandBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TallFlowerBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.WoodButtonBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class LirothBlocks {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Liroth.MOD_ID);
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Liroth.MOD_ID);
    
    public static final RegistryObject<Block> ANOMALY = BLOCKS.register("anomaly", () -> new Block(Block.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> ANOMALY_BLOCK = BLOCKS.register("anomaly_block", () -> new Block(Block.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> BLUE_SAND = createSand(0, "blue_sand");
    public static final RegistryObject<Block> BLUE_SANDSTONE = createStone("blue_sandstone");
    public static final RegistryObject<Block> BLUE_SANDSTONE_SLAB = createStoneSlab("blue_sandstone_slab");
//    public static final RegistryObject<Block> BLUE_SANDSTONE_STAIRS = createStoneStairs("blue_sandstone_stairs");
    public static final RegistryObject<Block> BLUE_SANDSTONE_WALL = createStoneWall("blue_sandstone_wall");
    public static final RegistryObject<Block> CARVED_BLUE_SANDSTONE = createStone("carved_blue_sandstone");
    public static final RegistryObject<Block> CHARRED_ACCESSWAY_BLOCK = createStone("charred_accessway_block");
    public static final RegistryObject<Block> CHARRED_LIROTH_COBBLESTONE = createStone("charred_liroth_cobblestone");
    public static final RegistryObject<Block> CHARRED_LIROTH_COBBLESTONE_WALL = createStoneWall("charred_liroth_cobblestone_wall");
//    public static final RegistryObject<Block> CHARRED_LIROTH_COBBLESTONE_STAIRS = createStoneStairs("charred_liroth_cobblestone_stairs");
    public static final RegistryObject<Block> CHARRED_LIROTH_COBBLESTONE_SLAB = createStoneSlab("charred_liroth_cobblestone_slab");
    public static final RegistryObject<Block> CHARRED_LIROTH_GEM_ORE = createOre("charred_lirothian_liroth_gem_ore");
    public static final RegistryObject<Block> CHARRED_LIROTH_STONE_BLOCK = createStone("charred_liroth_stone");
    public static final RegistryObject<Block> CHARRED_LIROTH_STONE_WALL = createStoneWall("charred_liroth_stone_wall");
//    public static final RegistryObject<Block> CHARRED_LIROTH_STONE_STAIRS = createStoneStairs("charred_liroth_stone_stairs");
    public static final RegistryObject<Block> CHARRED_LIROTH_STONE_SLAB = createStoneSlab("charred_liroth_stone_slab");
    public static final RegistryObject<Block> CHARRED_LIROTH_STONE_BRICKS = createStone("charred_liroth_stone_bricks");
//    public static final RegistryObject<Block> CHARRED_LIROTH_STONE_BRICK_LOCK = createLockBlock("charred_liroth_stone_brick_lock");
    public static final RegistryObject<Block> CHARRED_LIROTH_STONE_BRICK_WALL = createStoneWall("charred_liroth_stone_brick_wall");
//    public static final RegistryObject<Block> CHARRED_LIROTH_STONE_BRICK_STAIRS = createStoneStairs("charred_liroth_stone_brick_stairs");
    public static final RegistryObject<Block> CHARRED_LIROTH_STONE_BRICK_SLAB = createStoneSlab("charred_liroth_stone_brick_slab");
    public static final RegistryObject<Block> CHISELED_DEVASTATED_BRICKS = createStone("chiseled_devastated_bricks");
//    public static final RegistryObject<Block> CORRUPTED_BREWING_STAND = createBrewingStand("corrupted_brewing_stand");
//    public static final RegistryObject<Block> CORRUPTED_JALSPHIRE_GEM_BLOCK = createMetalBlock("corrupted_jalsphire_gem_block");
//    public static final RegistryObject<Block> CORRUPTED_JALSPHIRE_ORE = createOre("corrupted_jalsphire_ore");
//    public static final RegistryObject<Block> CORRUPTED_LIROTH_GEM_BLOCK = createPillarMetalBlock("corrupted_liroth_gem_block");
//    public static final RegistryObject<Block> CORRUPTED_LIROTH_GEM_ORE = createOre("corrupted_liroth_gem_ore");
//    public static final RegistryObject<Block> DAMNATION_CRAFTING_TABLE = createCraftingTable("damnation_crafting_table");
//    public static final RegistryObject<Block> DAMNATION_CHEST = createChest("damnation_chest");
    public static final RegistryObject<Block> DAMNATION_FENCE = createFence("damnation_fence");
    public static final RegistryObject<Block> DAMNATION_FUNGAL_CLUSTER = createFungusClusterPlant("damnation_fungal_cluster");
//    public static final RegistryObject<Block> DAMNATION_FUNGUS = createFungusPlant("damnation_fungus");
    public static final RegistryObject<Block> DAMNATION_FUNGAL_CARPET = createMossCarpet("damnation_fungal_carpet");
    public static final RegistryObject<Block> DAMNATION_FUNGAL_HEAP = createFungalGrass("damnation_fungal_heap");
    public static final RegistryObject<Block> DAMNATION_FUNGAL_PATCH = createFungalGrass("damnation_fungal_patch");
    public static final RegistryObject<Block> DAMNATION_FUNGAL_FUSS = createFungalGrass("damnation_fungal_fuss");
    public static final RegistryObject<Block> DAMNATION_LEAVES = createLeaves("damnation_leaves");
    public static final RegistryObject<Block> DAMNATION_LOG = createDamnationLog("damnation_log");
    public static final RegistryObject<Block> DAMNATION_PLANKS = createPlanks("damnation_planks");
    public static final RegistryObject<Block> DAMNATION_SOIL = createDamnationSoil("damnation_soil");
    public static final RegistryObject<Block> DAMNATION_DOOR = createDoor("damnation_door");
    public static final RegistryObject<Block> DAMNATION_SLAB = createWoodSlab("damnation_slab");
//    public static final RegistryObject<Block> DAMNATION_STAIRS = createWoodStairs("damnation_stairs");
    public static final RegistryObject<Block> DAMNATION_TRAPDOOR = createTrapDoor("damnation_trapdoor");
    public static final RegistryObject<Block> DAMNATION_WART_BLOCK = createWartBlock("damnation_wart_block");
    public static final RegistryObject<Block> DAMNATION_WOOD = createWood("damnation_wood");
//    public static final RegistryObject<Block> DAMNATION_VINES = createWeepingVinesHead("damnation_vines");
//    public static final RegistryObject<Block> DAMNATION_VINES_PLANT = createWeepingVinesBody("damnation_vines_plant");
    public static final RegistryObject<Block> DAMNED_PASSAGEWAY = createStone("damned_passageway");
//    public static final RegistryObject<Block> DEAD_SEA_EYE = createDeadWaterPlant("dead_sea_eye");
    public static final RegistryObject<Block> DEEPSLATE_LIROTH_ORE = createDeepslateOre("deepslate_liroth_gem_ore");
    public static final RegistryObject<Block> DEEPSLATE_TOURMALINE_ORE = createMetalBlock("deepslate_tourmaline_ore");
    public static final RegistryObject<Block> DEVASTATED_BRICKS = createStone("devastated_bricks");
    public static final RegistryObject<Block> DEVASTATED_BRICK_SLAB = createStoneSlab("devastated_brick_slab");
//    public static final RegistryObject<Block> DEVASTATED_BRICK_STAIRS = createStoneStairs("devastated_brick_stairs");
    public static final RegistryObject<Block> DEVASTATED_BRICK_WALL = createStoneWall("devastated_brick_wall");
    public static final RegistryObject<Block> DEVASTATED_PILLAR_BLOCK = createPillarBlock("devastated_pillar_block");
//    public static final RegistryObject<Block> DIMENSIONAL_COMMUNICATOR = createPortalFrame("dimensional_communicator");
    public static final RegistryObject<Block> DIMENSIONAL_COMMUNICATOR_OFF = createMetalBlock("dimensional_communicator_off");
    public static final RegistryObject<Block> DIMENSIONAL_COMMUNICATOR_ON = createMetalBlock("dimensional_communicator_on");
    public static final RegistryObject<Block> END_LIROTH_GEM_ORE = createOre("end_liroth_gem_ore");
//    public static final RegistryObject<Block> FORCEFIELD = createForcefieldPane("forcefield");
//    public static final RegistryObject<Block> FUNGAL_CAMPFIRE = createCampfire("fungal_campfire");
    public static final RegistryObject<Block> FUNGAL_LANTERN = createLantern("fungal_lantern");
//    public static final RegistryObject<Block> FUNGAL_TORCH = createTorch("fungal_torch");
    public static final RegistryObject<Block> FUNGAL_LIGHT = createShroomlightBlock("fungallight");
    public static final RegistryObject<Block> GATEWAY_BLOCK = createObsidianBlock("gateway_block");
    public static final RegistryObject<Block> GLEEMSTONE = createGleemStone("gleemstone");
    public static final RegistryObject<Block> HAUNTED_THROUGHFARE_BLOCK = createMetalBlock("haunted_throughfare_block");
    public static final RegistryObject<Block> HILIGHT = createShroomlightBlock("hilight");
    public static final RegistryObject<Block> JALSPHIRE_CRYSTAL_BLOCK = createCrystalBlock("jalsphire_crystal_block");
    public static final RegistryObject<Block> JALSPHIRE_ORE = createDirtOre("jalsphire_ore");
    public static final RegistryObject<Block> JALSPHIRE_GEM_BLOCK = createMetalBlock("jalsphire_gem_block");
    public static final RegistryObject<Block> JALSPHIRE_ORE_STONE = createOre("jalsphire_stone_ore");
    public static final RegistryObject<Block> JALSPHIRE_TRACKWAY = createStone("jalsphire_trackway");
//    public static final RegistryObject<Block> JAPZ_BLOSSOM = createSporeBlossom("japz_blossom");
//    public static final RegistryObject<Block> JAPZ_CHEST = createChest("japz_chest");
//    public static final RegistryObject<Block> JAPZ_CRAFTING_TABLE = createCraftingTable("japz_crafting_table");
    public static final RegistryObject<Block> JAPZ_FENCE = createFence("japz_fence");
    public static final RegistryObject<Block> JAPZ_LEAVES = createLeaves("japz_leaves");
    public static final RegistryObject<Block> JAPZ_LOG = createLog("japz_log");
//    public static final RegistryObject<Block> JAPZ_MINI_TREE = createAzalea("japz_mini_tree");
    public static final RegistryObject<Block> JAPZ_MOSS = createMoss("japz_moss_block");
    public static final RegistryObject<Block> JAPZ_MOSS_CARPET = createMossCarpet("japz_moss_carpet");
    public static final RegistryObject<Block> JAPZ_PLANKS = createPlanks("japz_planks");
//    public static final RegistryObject<Block> JAPZ_STAIRS = createWoodStairs("japz_stairs");
    public static final RegistryObject<Block> JAPZ_DOOR = createDoor("japz_door");
    public static final RegistryObject<Block> JAPZ_SLAB = createWoodSlab("japz_slab");
    public static final RegistryObject<Block> JAPZ_TRAPDOOR = createTrapDoor("japz_trapdoor");
//    public static final RegistryObject<Block> JAPZ_VINES = createCaveVinesHead("japz_vines");
//    public static final RegistryObject<Block> JAPZ_VINES_PLANT = createCaveVinesBody("japz_vines_plant");
    public static final RegistryObject<Block> JAPZ_WOOD = createWood("japz_wood");
//    public static final RegistryObject<Block> KOOLAW_CHEST = createChest("koolaw_chest");
//    public static final RegistryObject<Block> KOOLAW_CRAFTING_TABLE = createCraftingTable("koolaw_crafting_table");
    public static final RegistryObject<Block> KOOLAW_FENCE = createFence("koolaw_fence");
    public static final RegistryObject<Block> KOOLAW_LEAVES = createLeaves("koolaw_leaves");
    public static final RegistryObject<Block> KOOLAW_LOG = createLog("koolaw_log");
    public static final RegistryObject<Block> KOOLAW_PLANKS = createPlanks("koolaw_planks");
//    public static final RegistryObject<Block> KOOLAW_STAIRS = createWoodStairs("koolaw_stairs");
    public static final RegistryObject<Block> KOOLAW_DOOR = createDoor("koolaw_door");
    public static final RegistryObject<Block> KOOLAW_SLAB = createWoodSlab("koolaw_slab");
    public static final RegistryObject<Block> KOOLAW_TRAPDOOR = createTrapDoor("koolaw_trapdoor");
    public static final RegistryObject<Block> KOOLAW_WOOD = createWood("koolaw_wood");
    public static final RegistryObject<Block> NETHER_LIROTH_GEM_ORE = createOre("nether_liroth_gem_ore");
    public static final RegistryObject<Block> LIROTH_BONE_BLOCK = createBoneBlock("liroth_bone_block");
//    public static final RegistryObject<Block> LIROTH_CHEST = createChest("liroth_chest");
    public static final RegistryObject<Block> LIROTH_COBBLESTONE = createStone("liroth_cobblestone");
    public static final RegistryObject<Block> LIROTH_COBBLESTONE_WALL = createStoneWall("liroth_cobblestone_wall");
//    public static final RegistryObject<Block> LIROTH_COBBLESTONE_STAIRS = createStoneStairs("liroth_cobblestone_stairs");
    public static final RegistryObject<Block> LIROTH_COBBLESTONE_SLAB = createStoneSlab("liroth_cobblestone_slab");
//    public static final RegistryObject<Block> LIROTH_CRAFTING_TABLE = createCraftingTable("liroth_crafting_table");
    public static final RegistryObject<Block> LIROTH_DIRT = createDirt("liroth_dirt");
//    public static final RegistryObject<Block> LIROTH_END_STONE = createStone("liroth_end_stone");
//    public static final RegistryObject<Block> LIROTH_FURNACE = createFurnace("liroth_furnace");
    public static final RegistryObject<Block> LIROTH_GEM_BLOCK = createPillarMetalBlock("liroth_gem_block");
    public static final RegistryObject<Block> LIROTH_GLASS_BLOCK = createGlassBlock("liroth_glass_block");
    public static final RegistryObject<Block> LIROTH_GRASS = createGrass("liroth_grass");
//    public static final RegistryObject<Block> LIROTH_GRASS_BLOCK = createLirothGrassBlock("liroth_grass_block");
//    public static final RegistryObject<Block> LIROTH_FARMLAND_BLOCK = createLirothFarmlandBlock("liroth_farmland");
//    public static final RegistryObject<Block> LIROTH_PATH_BLOCK = createLirothPathBlock("liroth_grass_path");
    public static final RegistryObject<Block> LIROTH_LEAVES = createLeaves("liroth_leaves");
    public static final RegistryObject<Block> LIROTH_LOG = createLog("liroth_log");
    public static final RegistryObject<Block> LIROTHIAN_LIROTH_ORE = createOre("lirothian_liroth_ore");
    public static final RegistryObject<Block> LIROTH_ORE = createOre("liroth_gem_ore");
    public static final RegistryObject<Block> LIROTH_PLANKS = createPlanks("liroth_planks");
    public static final RegistryObject<Block> LIROTH_ROSE = createFlower("liroth_rose");
    public static final RegistryObject<Block> LIROTH_SOUL_SAND = createLirothSoulSand("liroth_soul_sand");
    public static final RegistryObject<Block> LIROTH_STONE_BLOCK = createStone("liroth_stone");
    public static final RegistryObject<Block> LIROTH_STONE_WALL = createStoneWall("liroth_stone_wall");
//    public static final RegistryObject<Block> LIROTH_STONE_STAIRS = createStoneStairs("liroth_stone_stairs");
    public static final RegistryObject<Block> LIROTH_STONE_SLAB = createStoneSlab("liroth_stone_slab");
    public static final RegistryObject<Block> LIROTH_STONE_BRICKS = createStone("liroth_stone_bricks");
    public static final RegistryObject<Block> LIROTH_STONE_BRICK_WALL = createStoneWall("liroth_stone_brick_wall");
//    public static final RegistryObject<Block> LIROTH_STONE_BRICK_STAIRS = createStoneStairs("liroth_stone_brick_stairs");
    public static final RegistryObject<Block> LIROTH_STONE_BRICK_SLAB = createStoneSlab("liroth_stone_brick_slab");
    public static final RegistryObject<Block> LIROTH_DOOR = createDoor("liroth_door");
    public static final RegistryObject<Block> LIROTH_FENCE = createFence("liroth_fence");
    public static final RegistryObject<Block> LIROTH_SLAB = createWoodSlab("liroth_slab");
//    public static final RegistryObject<Block> LIROTH_STAIRS = createWoodStairs("liroth_stairs");
    public static final RegistryObject<Block> LIROTH_TRAPDOOR = createTrapDoor("liroth_trapdoor");
    public static final RegistryObject<Block> LIROTH_WOOD = createWood("liroth_wood");
    public static final RegistryObject<Block> LIROTHIAN_COBALT_BLOCK = createMetalBlock("lirothian_cobalt_block");
    public static final RegistryObject<Block> LIROTHIAN_COBALT_DOOR = createMetalDoor("lirothian_cobalt_door");
    public static final RegistryObject<Block> LIROTHIAN_COBALT_ORE = createOre("lirothian_cobalt_ore");
    public static final RegistryObject<Block> LIROTHIAN_COBALT_TRAPDOOR = createMetalTrapDoor("lirothian_cobalt_trapdoor");
    public static final RegistryObject<Block> LIROTHIAN_PETROLEUM_BLOCK = createCoalBlock("lirothian_petroleum_block");
    public static final RegistryObject<Block> LIROTHIAN_PETROLEUM_ORE = createOre("lirothian_petroleum_ore");
//    public static final RegistryObject<Block> LIROTHIAN_PETROLEUM_TORCH = createPetroleumTorch("lirothian_petroleum_torch");
    public static final RegistryObject<Block> LIROTHIAN_PETROLEUM_LANTERN = createLantern("lirothian_petroleum_lantern");
//    public static final RegistryObject<Block> LIROTHIAN_PETROLEUM_CAMPFIRE = createLirothianPetroleumCampfire("lirothian_petroleum_campfire");
    public static final RegistryObject<Block> OLDEN_LIROTH_GEM_BLOCK = createPillarMetalBlock("olden_liroth_gem_block");
//    public static final RegistryObject<Block> PETRIFIED_DAMNATION_CRAFTING_TABLE = createCraftingTable("petrified_damnation_crafting_table");
//    public static final RegistryObject<Block> PETRIFIED_DAMNATION_CHEST = createChest("petrified_damnation_chest");
    public static final RegistryObject<Block> PETRIFIED_DAMNATION_LOG = createLog("petrified_damnation_log");
    public static final RegistryObject<Block> PETRIFIED_DAMNATION_BRICKS = createStone("petrified_damnation_bricks");
//    public static final RegistryObject<Block> PETRIFIED_DAMNATION_BRICK_STAIRS = createStoneStairs("petrified_damnation_brick_stairs");
    public static final RegistryObject<Block> PETRIFIED_DAMNATION_BRICK_SLAB = createStoneSlab("petrified_damnation_brick_slab");
    public static final RegistryObject<Block> PETRIFIED_DAMNATION_BRICK_WALL = createStoneWall("petrified_damnation_brick_wall");
    public static final RegistryObject<Block> PETRIFIED_DAMNATION_DOOR = createDoor("petrified_damnation_door");
    public static final RegistryObject<Block> PETRIFIED_DAMNATION_PLANKS = createPlanks("petrified_damnation_planks");
//    public static final RegistryObject<Block> PETRIFIED_DAMNATION_STAIRS = createWoodStairs("petrified_damnation_stairs");
    public static final RegistryObject<Block> PETRIFIED_DAMNATION_SLAB = createWoodSlab("petrified_damnation_slab");
    public static final RegistryObject<Block> PETRIFIED_DAMNATION_TRAPDOOR = createTrapDoor("petrified_damnation_trapdoor");
    public static final RegistryObject<Block> PETRIFIED_DAMNATION_FENCE = createFence("petrified_damnation_fence");
    public static final RegistryObject<Block> PETRIFIED_DAMNATION_WOOD = createWood("petrified_damnation_wood");
    public static final RegistryObject<Block> PETRIFIED_CRYSTAL_BLOCK = createCrystalBlock("petrified_crystal_block");
    public static final RegistryObject<Block> PETRIFIED_MOSS_BLOCK = createMoss("petrified_moss_block");
    public static final RegistryObject<Block> PETRIFIED_MOSS_CARPET = createMossCarpet("petrified_moss_carpet");
//    public static final RegistryObject<Block> PETRIFIED_VINES = createPetrifiedCaveVinesHead("petrified_vines");
//    public static final RegistryObject<Block> PETRIFIED_VINES_PLANT = createPetrifiedCaveVinesBody("petrified_vines_plant");
//    public static final RegistryObject<Block> PETRIFIED_PLANT = createPetrifiedPlant("petrified_plant");
//    public static final RegistryObject<Block> PETRIFIED_FLOWER = createPetrifiedFlower("petrified_flower");
    public static final RegistryObject<Block> PIER_DIRT = createDirt("pier_dirt");
//    public static final RegistryObject<Block> PIER_GRASS_BLOCK = createPierGrassBlock("pier_grass_block");
//    public static final RegistryObject<Block> PIER_FARMLAND_BLOCK = createPierFarmlandBlock("pier_farmland");
//    public static final RegistryObject<Block> PIER_PATH_BLOCK = createPierPathBlock("pier_grass_path");
//    public static final RegistryObject<Block> POINTED_JALSPHIRE_CRYSTAL = createPointedCrystal("pointed_jalsphire_crystal");
//    public static final RegistryObject<Block> POINTED_PETRIFIED_CRYSTAL = createPointedPetrifiedCrystal("pointed_petrified_crystal");
    public static final RegistryObject<Block> POTESTIUM_ORE = createSoilOre("potestium_ore");
    public static final RegistryObject<Block> POTESTIUM_BLOCK = createMetalBlock("potestium_block");
//    public static final RegistryObject<Block> REDSTONE_BROKEN_STAGE_1 = createMetalBlock("redstone_broken_stage_1");
//    public static final RegistryObject<Block> REDSTONE_BROKEN_STAGE_2 = createMetalBlock("redstone_broken_stage_2");
//    public static final RegistryObject<Block> REDSTONE_BROKEN_STAGE_3 = createMetalBlock("redstone_broken_stage_3");
    public static final RegistryObject<Block> RAW_LIROTHIAN_COBALT_BLOCK = createMetalBlock("raw_lirothian_cobalt_block");
    public static final RegistryObject<Block> RUBY_ORE = createSoilOre("ruby_ore");
    public static final RegistryObject<Block> RUBY_BLOCK = createMetalBlock("ruby_block");
    public static final RegistryObject<Block> QUANTUM_DIAMOND_ORE = createSoilOre("quantum_diamond_ore");
    public static final RegistryObject<Block> QUANTUM_PLATE_BLOCK = createMetalBlock("quantum_plate_block");
//    public static final RegistryObject<Block> SEA_EYE = createWaterPlant("sea_eye");
    public static final RegistryObject<Block> SMOOTH_BLUE_SANDSTONE = createStone("smooth_blue_sandstone");
    public static final RegistryObject<Block> SMOOTH_BLUE_SANDSTONE_SLAB = createStoneSlab("smooth_blue_sandstone_slab");
//    public static final RegistryObject<Block> SMOOTH_BLUE_SANDSTONE_STAIRS = createStoneStairs("smooth_blue_sandstone_stairs");
    public static final RegistryObject<Block> SMOOTH_BLUE_SANDSTONE_WALL = createStoneWall("smooth_blue_sandstone_wall");
//    public static final RegistryObject<Block> SOULLESS_FLAME = createFireBlock("soulless_flame");
    public static final RegistryObject<Block> SOULLESS_SOIL = createSoullessSoil("soulless_soil");
//    public static final RegistryObject<Block> SOUL_ROD = createRod("soul_rod");
//    public static final RegistryObject<Block> SPICED_CRAFTING_TABLE = createCraftingTable("spiced_crafting_table");
//    public static final RegistryObject<Block> SPICED_CHEST = createChest("spiced_chest");
    public static final RegistryObject<Block> SPICED_LEAVES = createLeaves("spiced_leaves");
    public static final RegistryObject<Block> SPICED_LOG = createLog("spiced_log");
    public static final RegistryObject<Block> SPICED_PLANKS = createPlanks("spiced_planks");
    public static final RegistryObject<Block> SPICED_DOOR = createDoor("spiced_door");
    public static final RegistryObject<Block> SPICED_FENCE = createFence("spiced_fence");
    public static final RegistryObject<Block> SPICED_SLAB = createWoodSlab("spiced_slab");
//    public static final RegistryObject<Block> SPICED_STAIRS = createWoodStairs("spiced_stairs");
    public static final RegistryObject<Block> SPICED_TRAPDOOR = createTrapDoor("spiced_trapdoor");
    public static final RegistryObject<Block> SPICED_WOOD = createWood("spiced_wood");
    public static final RegistryObject<Block> SPINERIOS_COAL_ORE = createDirtOre("spinerios_coal_ore");
    public static final RegistryObject<Block> SPINERIOS_COBBLESTONE = createStone("spinerios_cobblestone");
    public static final RegistryObject<Block> SPINERIOS_COBBLESTONE_WALL = createStoneWall("spinerios_cobblestone_wall");
    public static final RegistryObject<Block> SPINERIOS_COBBLESTONE_SLAB = createStoneSlab("spinerios_cobblestone_slab");
//    public static final RegistryObject<Block> SPINERIOS_COBBLESTONE_STAIRS = createStoneStairs("spinerios_cobblestone_stairs");
    public static final RegistryObject<Block> SPINERIOS_COPPER_ORE = createDirtOre("spinerios_copper_ore");
    public static final RegistryObject<Block> SPINERIOS_DIAMOND_ORE = createDirtOre("spinerios_diamond_ore");
    public static final RegistryObject<Block> SPINERIOS_DIRT = createDirt("spinerios_dirt");
    public static final RegistryObject<Block> SPINERIOS_EMERALD_ORE = createDirtOre("spinerios_emerald_ore");
//    public static final RegistryObject<Block> SPINERIOS_FURNACE = createFurnace("spinerios_furnace");
    public static final RegistryObject<Block> SPINERIOS_GOLD_ORE = createDirtOre("spinerios_gold_ore");
//    public static final RegistryObject<Block> SPINERIOS_GRASS_BLOCK = createSpineriosGrassBlock("spinerios_grass_block");
//    public static final RegistryObject<Block> SPINERIOS_FARMLAND_BLOCK = createSpineriosFarmlandBlock("spinerios_farmland");
//    public static final RegistryObject<Block> SPINERIOS_PATH_BLOCK = createSpineriosPathBlock("spinerios_grass_path");
    public static final RegistryObject<Block> SPINERIOS_IRON_ORE = createDirtOre("spinerios_iron_ore");
    public static final RegistryObject<Block> SPINERIOS_LAPIS_ORE = createDirtOre("spinerios_lapis_ore");
    public static final RegistryObject<Block> SPINERIOS_LIROTH_ORE = createDirtOre("spinerios_liroth_ore");
    public static final RegistryObject<Block> SPINERIOS_QUARTZ_ORE = createDirtOre("spinerios_quartz_ore");
    public static final RegistryObject<Block> SPINERIOS_REDSTONE_ORE = createDirtOre("spinerios_redstone_ore");
    public static final RegistryObject<Block> SPINERIOS_ANCIENT_DEBRIS = createSpineriosAncientDebris("spinerios_ancient_debris");
    public static final RegistryObject<Block> SPINERIOS_STONE = createStone("spinerios_stone");
    public static final RegistryObject<Block> SPINERIOS_STONE_ORE = createDirtOre("spinerios_stone_ore");
    public static final RegistryObject<Block> SPINERIOS_STONE_WALL = createStoneWall("spinerios_stone_wall");
    public static final RegistryObject<Block> SPINERIOS_STONE_SLAB = createStoneSlab("spinerios_stone_slab");
//    public static final RegistryObject<Block> SPINERIOS_STONE_STAIRS = createStoneStairs("spinerios_stone_stairs");
    public static final RegistryObject<Block> SPINERIOS_STONE_BRICKS = createStone("spinerios_stone_bricks");
    public static final RegistryObject<Block> SPINERIOS_STONE_BRICK_WALL = createStoneWall("spinerios_stone_brick_wall");
    public static final RegistryObject<Block> SPINERIOS_STONE_BRICK_SLAB = createStoneSlab("spinerios_stone_brick_slab");
//    public static final RegistryObject<Block> SPINERIOS_STONE_BRICK_STAIRS = createStoneStairs("spinerios_stone_brick_stairs");
    public static final RegistryObject<Block> SPINERIOS_STONE_TOURMALINE_ORE = createOre("spinerios_stone_tourmaline_ore");
    public static final RegistryObject<Block> SPINERIOS_TOURMALINE_ORE = createDirtOre("spinerios_tourmaline_ore");
    public static final RegistryObject<Block> STRIPPED_LIROTH_LOG = createStrippedLog("stripped_liroth_log");
    public static final RegistryObject<Block> STRIPPED_SPICED_LOG = createStrippedLog("stripped_spiced_log");
    public static final RegistryObject<Block> STRIPPED_TALLPIER_LOG = createStrippedLog("stripped_tallpier_log");
    public static final RegistryObject<Block> STRIPPED_DAMNATION_LOG = createStrippedLog("stripped_damnation_log");
    public static final RegistryObject<Block> STRIPPED_JAPZ_LOG = createStrippedLog("stripped_japz_log");
    public static final RegistryObject<Block> STRIPPED_KOOLAW_LOG = createStrippedLog("stripped_koolaw_log");
    public static final RegistryObject<Block> STRIPPED_PETRIFIED_DAMNATION_LOG = createStrippedLog("stripped_petrified_damnation_log");
    public static final RegistryObject<Block> STRIPPED_LIROTH_WOOD = createWood("stripped_liroth_wood");
    public static final RegistryObject<Block> STRIPPED_SPICED_WOOD = createWood("stripped_spiced_wood");
    public static final RegistryObject<Block> STRIPPED_TALLPIER_WOOD = createWood("stripped_tallpier_wood");
    public static final RegistryObject<Block> STRIPPED_DAMNATION_WOOD = createWood("stripped_damnation_wood");
    public static final RegistryObject<Block> STRIPPED_JAPZ_WOOD = createWood("stripped_japz_wood");
    public static final RegistryObject<Block> STRIPPED_KOOLAW_WOOD = createWood("stripped_koolaw_wood");
    public static final RegistryObject<Block> STRIPPED_PETRIFIED_DAMNATION_WOOD = createWood("stripped_petrified_damnation_wood");
//    public static final RegistryObject<Block> TALLPIER_CRAFTING_TABLE = createCraftingTable("tallpier_crafting_table");
//    public static final RegistryObject<Block> TALLPIER_CHEST = createChest("tallpier_chest");
    public static final RegistryObject<Block> TALLPIER_LEAVES = createLeaves("tallpier_leaves");
    public static final RegistryObject<Block> TALLPIER_LOG = createLog("tallpier_log");
    public static final RegistryObject<Block> TALLPIER_PLANKS = createPlanks("tallpier_planks");
    public static final RegistryObject<Block> TALLPIER_DOOR = createDoor("tallpier_door");
    public static final RegistryObject<Block> TALLPIER_FENCE = createFence("tallpier_fence");
    public static final RegistryObject<Block> TALLPIER_SLAB = createWoodSlab("tallpier_slab");
//    public static final RegistryObject<Block> TALLPIER_STAIRS = createWoodStairs("tallpier_stairs");
    public static final RegistryObject<Block> TALLPIER_TRAPDOOR = createTrapDoor("tallpier_trapdoor");
    public static final RegistryObject<Block> TALLPIER_WOOD = createWood("tallpier_wood");
    public static final RegistryObject<Block> TOURMALINE_GEM_BLOCK = createMetalBlock("tourmaline_gem_block");
    public static final RegistryObject<Block> TOURMALINE_ORE = createStone("tourmaline_ore");
//    public static final RegistryObject<Block> VILE_TENTACLE_TIP = createUnderwaterReedTop("vile_tentacle_tip");
//    public static final RegistryObject<Block> VILE_TENTACLE = createUnderwaterReed("vile_tentacle");
//    public static final RegistryObject<Block> WALL_FUNGAL_TORCH = createWallTorch("wall_fungal_torch");
//    public static final RegistryObject<Block> WALL_LIROTHIAN_PETROLEUM_TORCH = createWallPetroleumTorch("wall_lirothian_petroleum_torch");
    public static final RegistryObject<Block> WILITING_LIROTH_ROSE = createFlower("wilting_liroth_rose");

    
    // RegistryObject<Block> With RegistryObject<Block> Entities
//    public static final RegistryObject<Block> JALSPHIRE_COMPACTOR = createJalsphireCompactor("jalsphire_compactor");
//    public static final RegistryObject<Block> LIROTH_DUST_COMPACTOR = createLirothDustCompactor("liroth_dust_compactor");
//    public static final RegistryObject<Block> LIROTH_SPLITTER = createLirothSplitter("liroth_splitter");
//    public static final RegistryObject<Block> LIROTHIAN_TRANSMUTATION_TABLE = createLirothianTransmutationTable("lirothian_transmutation_table");
//    public static final RegistryObject<Block> QUANTUM_EXTRACTOR = createQuantumExtractor("quantum_extractor");
    
    // Saplings
/*    public static final RegistryObject<Block> LIROTH_SAPLING = createLirothSapling("liroth_sapling");
    public static final RegistryObject<Block> SPICED_SAPLING = createSpicedSapling("spiced_sapling");
    public static final RegistryObject<Block> TALLPIER_SAPLING = createTallpierSapling("tallpier_sapling");
    public static final RegistryObject<Block> DAMNATION_SAPLING = createDamnationSapling("damnation_sapling");
    public static final RegistryObject<Block> JAPZ_SAPLING = createJapzSapling("japz_sapling");
    public static final RegistryObject<Block> KOOLAW_SAPLING = createKoolawSapling("koolaw_sapling");
    public static final RegistryObject<Block> PETRIFIED_DAMNATION_SAPLING = createPetrifiedSapling("petrified_damnation_sapling");*/

    // Potted Plants
/*    public static final RegistryObject<Block> LIROTH_SAPLING_POT = createPottedBlock(LIROTH_SAPLING, "liroth_sapling");
    public static final RegistryObject<Block> SPICED_SAPLING_POT = createPottedBlock(SPICED_SAPLING, "spiced_sapling");
    public static final RegistryObject<Block> TALLPIER_SAPLING_POT = createPottedBlock(TALLPIER_SAPLING, "tallpier_sapling");
    public static final RegistryObject<Block> DAMNATION_SAPLING_POT = createPottedBlock(DAMNATION_SAPLING, "damnation_sapling");
    public static final RegistryObject<Block> JAPZ_SAPLING_POT = createPottedBlock(JAPZ_SAPLING, "japz_sapling");
    public static final RegistryObject<Block> KOOLAW_SAPLING_POT = createPottedBlock(KOOLAW_SAPLING, "koolaw_sapling");
    public static final RegistryObject<Block> PETRIFIED_DAMNATION_SAPLING_POT = createPottedBlock(PETRIFIED_DAMNATION_SAPLING, "petrified_damnation_sapling");*/
        
    // BlockStates
	   public static final class States {
		      public static final BlockState LIROTH_LOG = LirothBlocks.LIROTH_LOG.get().defaultBlockState();
		      public static final BlockState LIROTH_LEAVES = LirothBlocks.LIROTH_LEAVES.get().defaultBlockState();
		      public static final BlockState SPICED_LOG = LirothBlocks.SPICED_LOG.get().defaultBlockState();
		      public static final BlockState SPICED_LEAVES = LirothBlocks.SPICED_LEAVES.get().defaultBlockState();
		      public static final BlockState TALLPIER_LOG = LirothBlocks.TALLPIER_LOG.get().defaultBlockState();
		      public static final BlockState TALLPIER_LEAVES = LirothBlocks.TALLPIER_LEAVES.get().defaultBlockState();
		      public static final BlockState DAMNATION_LOG = LirothBlocks.DAMNATION_LOG.get().defaultBlockState();
		      public static final BlockState DAMNATION_LEAVES = LirothBlocks.DAMNATION_LEAVES.get().defaultBlockState();
		      public static final BlockState JAPZ_LOG = LirothBlocks.JAPZ_LOG.get().defaultBlockState();
		      public static final BlockState JAPZ_LEAVES = LirothBlocks.JAPZ_LEAVES.get().defaultBlockState();
		      public static final BlockState PETRIFIED_DAMNATION_LOG = LirothBlocks.PETRIFIED_DAMNATION_LOG.get().defaultBlockState();
		      public static final BlockState KOOLAW_LOG = LirothBlocks.KOOLAW_LOG.get().defaultBlockState();
		      public static final BlockState KOOLAW_LEAVES = LirothBlocks.KOOLAW_LEAVES.get().defaultBlockState();
		      public static final BlockState LIROTH_GEM_BLOCK = LirothBlocks.LIROTH_GEM_BLOCK.get().defaultBlockState();
		      public static final BlockState DEVASTATED_BRICKS = LirothBlocks.DEVASTATED_BRICKS.get().defaultBlockState();
	   }
	   
    
   
    static RegistryObject<Block> createStone(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new Block(Block.Properties.copy(Blocks.STONE)));
        createBlockItems(id, createBlock);

        return createBlock;


    }
    

    static RegistryObject<Block> createGleemStone(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new Block(Block.Properties.copy(Blocks.GLOWSTONE).sound(SoundType.GLASS).lightLevel(state -> 15)));
        createBlockItems(id, createBlock);

        return createBlock;



    }
    
/*    static RegistryObject<Block> createLockBlock(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new LockBlock(Block.Properties.copy(Blocks.STONE)));
        


    }*/
    
    static RegistryObject<Block> createCoalBlock(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new Block(Block.Properties.copy(Blocks.COAL_BLOCK)));
        createBlockItems(id, createBlock);

        return createBlock;



    }
    
    static RegistryObject<Block> createPetrifiedCrystalBlock(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new Block(Block.Properties.copy(Blocks.GLASS)));
        createBlockItems(id, createBlock);

        return createBlock;


    }
    
/*    static RegistryObject<Block> createPointedPetrifiedCrystal(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new PointedPetrifiedCrystal(Block.Properties.copy(Blocks.GLASS).dynamicBounds()));
        


    }
    
    static RegistryObject<Block> createPetrifiedCaveVinesHead(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new PetrifiedCaveVinesHeadBlock(Block.Properties.copy(Blocks.CAVE_VINES)));
        


    }
    
    static RegistryObject<Block> createPetrifiedCaveVinesBody(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new PetrifiedCaveVinesBodyBlock(Block.Properties.copy(Blocks.CAVE_VINES_PLANT)));
        


    }*/
    
    static RegistryObject<Block> createPetrifiedPlant(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new Block(Block.Properties.copy(Blocks.STONE)));
        createBlockItems(id, createBlock);

        return createBlock;


    }
    
    static RegistryObject<Block> createPetrifiedFlower(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new Block(Block.Properties.copy(Blocks.STONE)));
        createBlockItems(id, createBlock);

        return createBlock;



    }
    
    public  static RegistryObject<Block> createFungalGrass(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new GrassBlock(Block.Properties.copy(Blocks.CRIMSON_ROOTS).noCollission()));
        createBlockItems(id, createBlock);

        return createBlock;

    }
    
    static RegistryObject<Block> createMoss(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new MossBlock(Block.Properties.copy(Blocks.MOSS_BLOCK)));
        createBlockItems(id, createBlock);

        return createBlock;



    }
    
/*    static RegistryObject<Block> createWeepingVinesHead(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new CustomWeepingVinesBlock(Block.Properties.copy(Blocks.WEEPING_VINES).noCollission()));
        


    }
    
    static RegistryObject<Block> createWeepingVinesBody(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new CustomWeepingVinesPlantBlock(Block.Properties.copy(Blocks.WEEPING_VINES_PLANT).noCollission()));
        


    }
    
    static RegistryObject<Block> createCaveVinesHead(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new CustomCaveVinesHeadBlock(Block.Properties.copy(Blocks.CAVE_VINES)));
        


    }
    
    static RegistryObject<Block> createCaveVinesBody(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new CustomCaveVinesBodyBlock(Block.Properties.copy(Blocks.CAVE_VINES_PLANT)));
        


    }
    
    static RegistryObject<Block> createSporeBlossom(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new SporeBlossomBlock(Block.Properties.copy(Blocks.SPORE_BLOSSOM).lightLevel(state -> 8)));
        


    }
    
    static RegistryObject<Block> createAzalea(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new CustomAzaleaBlock(Block.Properties.copy(Blocks.AZALEA)));
        


    }*/
    
    static RegistryObject<Block> createMossCarpet(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new CarpetBlock(Block.Properties.copy(Blocks.MOSS_CARPET)));
        createBlockItems(id, createBlock);

        return createBlock;



    }
    
    static RegistryObject<Block> createCrystalBlock(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new Block(Block.Properties.copy(Blocks.GLASS).lightLevel(state -> 8)));
        createBlockItems(id, createBlock);

        return createBlock;


    }
    
/*    static RegistryObject<Block> createPointedCrystal(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new PointedJalsphireCrystal(Block.Properties.copy(Blocks.GLASS).dynamicBounds().lightLevel(state -> 8)));
        


    }*/
    
/*    private static RegistryObject<Block> createLirothSplitter(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new LirothSplitterBlock(Block.Properties.of(Material.METAL).requiresCorrectToolForDrops().strength(3.5f).lightLevel(LirothBlocks.createLightLevelFromLitBlockState(13))));
        


	}

    private static RegistryObject<Block> createQuantumExtractor(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new QuantumExtractorBlock(Block.Properties.of(Material.METAL).requiresCorrectToolForDrops().strength(3.5f).noOcclusion().lightLevel(LirothBlocks.createLightLevelFromLitBlockState(13))));
        


	}*/
    
//    private static ToIntFunction<BlockState> createLightLevelFromLitBlockState(int litLevel) {
//        RegistryObject<Block> state -> state.get(BlockState.LIT) != false ? litLevel : 0;
//    }

/*	static RegistryObject<Block> createWaterPlant(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new CustomWaterPlant(DEAD_SEA_EYE, Block.Properties.copy(Blocks.FIRE_CORAL_FAN)));
        


    }
    
    static RegistryObject<Block> createDeadWaterPlant(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new CustomDeadWaterPlant(Block.Properties.copy(Blocks.DEAD_FIRE_CORAL_FAN)));
        


    }
    
    static RegistryObject<Block> createFungusPlant(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new CustomFungalPlant(Block.Properties.copy(Blocks.CRIMSON_FUNGUS).noCollission(), null);
        


    }*/
    
    static RegistryObject<Block> createWartBlock(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new Block(Block.Properties.copy(Blocks.NETHER_WART_BLOCK)));
        createBlockItems(id, createBlock);

        return createBlock;


    }
    
    static RegistryObject<Block> createShroomlightBlock(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new Block(Block.Properties.copy(Blocks.NETHER_WART_BLOCK).strength(1.0f).sound(SoundType.SHROOMLIGHT).lightLevel(state -> 15)));
        createBlockItems(id, createBlock);

        return createBlock;



    }
    
 /*   static RegistryObject<Block> createCampfire(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new FungalCampfireBlock(false, 1, Block.Properties.copy(Blocks.CAMPFIRE).lightLevel(LirothBlocks.createLightLevelFromLitBlockState(15)).noOcclusion()));
        


    }
    
    static RegistryObject<Block> createLirothianPetroleumCampfire(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new LirothianPetroleumCampfireBlock(false, 1, Block.Properties.copy(Blocks.CAMPFIRE).lightLevel(LirothBlocks.createLightLevelFromLitBlockState(15)).noOcclusion()));
        


    }
    
    static RegistryObject<Block> createTorch(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new CustomTorch(Block.Properties.copy(Blocks.TORCH).noCollission(), ParticleTypes.HAPPY_VILLAGER);
        


    }
    
    static RegistryObject<Block> createPetroleumTorch(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new CustomTorch(Block.Properties.copy(Blocks.TORCH).noCollission(), ParticleTypes.PORTAL);
        


    }
    
    static RegistryObject<Block> createWallPetroleumTorch(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new CustomWallTorch(Block.Properties.copy(Blocks.TORCH).noCollission().dropsLike(FUNGAL_TORCH), ParticleTypes.PORTAL);
        


    }*/
    
    static RegistryObject<Block> createLantern(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new LanternBlock(Block.Properties.copy(Blocks.LANTERN)));
        createBlockItems(id, createBlock);

        return createBlock;



    }
    
/*    static RegistryObject<Block> createWallTorch(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new CustomWallTorch(Block.Properties.copy(Blocks.TORCH).noCollission().dropsLike(FUNGAL_TORCH), ParticleTypes.HAPPY_VILLAGER);
        


    }*/
    
    static RegistryObject<Block> createFungusClusterPlant(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new TallFlowerBlock(Block.Properties.copy(Blocks.CRIMSON_FUNGUS).noCollission()));
        createBlockItems(id, createBlock);

        return createBlock;


    }
    
/*    static RegistryObject<Block> createUnderwaterReedTop(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new CustomKelpBlock(Block.Properties.copy(Blocks.KELP)));
        


    }
    
    static RegistryObject<Block> createUnderwaterReed(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new CustomKelpPlantBlock(Block.Properties.copy(Blocks.KELP_PLANT)));
        


    }
    
    static RegistryObject<Block> createCraftingTable(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new CustomCraftingTable(Block.Properties.copy(Blocks.CRAFTING_TABLE)));
        


    }
    
    static RegistryObject<Block> createBrewingStand(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new BrewingStandBlock(Block.Properties.copy(Blocks.BREWING_STAND)));
        


    }
    
    static RegistryObject<Block> createFurnace(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new BaseFurnaceBlock(Block.Properties.copy(Blocks.STONE).lightLevel(LirothBlocks.createLightLevelFromLitBlockState(13))));
        


    }

    static RegistryObject<Block> createChest(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new BaseChestBlock(Blocks.CHEST);
        


    }*/
    
/*    static LirothPortalBlock createLirothPortal(String id) {
    	LirothPortalBlock createBlock = BLOCKS.register(id, () -> new LirothPortalBlock(Block.Properties.copy(Blocks.END_PORTAL)));
        


    }*/
    
    static RegistryObject<Block> createAnomalyBlock(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new Block(Block.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));
        createBlockItems(id, createBlock);

        return createBlock;



    }
    
/*    static RegistryObject<Block> createPortalFrame(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new CustomPortalFrameBlock(Block.Properties.copy(Blocks.OBSIDIAN).noOcclusion()));
        


    }*/
    
    static RegistryObject<Block> createBoneBlock(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new RotatedPillarBlock(Block.Properties.copy(Blocks.BONE_BLOCK)));
        createBlockItems(id, createBlock);

        return createBlock;


    }
    
    static RegistryObject<Block> createSpineriosAncientDebris(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new Block(Block.Properties.copy(Blocks.ANCIENT_DEBRIS)));
        createBlockItems(id, createBlock);

        return createBlock;



	}

/*	static RegistryObject<Block> createFireBlock(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new FireBlock(Block.Properties.copy(Blocks.FIRE)));
        


    }
    
    static RegistryObject<Block> createRod(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new CustomRod(Block.Properties.copy(Blocks.STONE)));
        


    }*/
    
    static RegistryObject<Block> createGlassBlock(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new Block(Block.Properties.copy(Blocks.GLASS)));
        createBlockItems(id, createBlock);

        return createBlock;



    }
    
/*    static RegistryObject<Block> createForcefieldPane(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new CustomPane(Block.Properties.copy(Blocks.BARRIER).noOcclusion()));
        


    }*/

    static RegistryObject<Block> createObsidianBlock(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new Block(Block.Properties.copy(Blocks.OBSIDIAN)));
        createBlockItems(id, createBlock);

        return createBlock;



    }
    
    static RegistryObject<Block> createFence(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new FenceBlock(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2.0f, 3.0f)));
        createBlockItems(id, createBlock);

        return createBlock;



    }

    static RegistryObject<Block> createFenceGate(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new FenceGateBlock(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2.0f, 3.0f)));
        
        createBlockItems(id, createBlock);


        return createBlock;

    }

    static RegistryObject<Block> createSand(int dustColor, String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new SandBlock(dustColor, Block.Properties.of(Material.SAND).sound(SoundType.SAND).strength(0.2f)));
        createBlockItems(id, createBlock);

        return createBlock;


    }
    
    static RegistryObject<Block> createNonFallingSand(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new Block(Block.Properties.copy(Blocks.DIRT).sound(SoundType.SAND).strength(0.2f).requiresCorrectToolForDrops()));
        
        createBlockItems(id, createBlock);

        return createBlock;


    }
    
    static RegistryObject<Block> createDamnationSoil(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new Block(Block.Properties.copy(Blocks.DIRT).sound(SoundType.SOUL_SAND).strength(0.2f).requiresCorrectToolForDrops()));
        
        createBlockItems(id, createBlock);

        return createBlock;


    }

    static RegistryObject<Block> createLirothSoulSand(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new Block(Block.Properties.copy(Blocks.DIRT).sound(SoundType.SOUL_SAND).strength(0.2f).requiresCorrectToolForDrops()));
        
        createBlockItems(id, createBlock);

        return createBlock;


    }
    
    static RegistryObject<Block> createSoullessSoil(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new Block(Block.Properties.copy(Blocks.DIRT).sound(SoundType.SOUL_SOIL).strength(0.2f).requiresCorrectToolForDrops()));
        

        createBlockItems(id, createBlock);

        return createBlock;

    }
    
    static RegistryObject<Block> createWoodSlab(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new SlabBlock(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2.0f, 3.0f)));
        
        createBlockItems(id, createBlock);


        return createBlock;

    }

    static RegistryObject<Block> createStoneSlab(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new SlabBlock(Block.Properties.of(Material.STONE).sound(SoundType.STONE).strength(2.0f, 6.0f)));
        createBlockItems(id, createBlock);

        return createBlock;



    }

    static RegistryObject<Block> createStoneWall(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new WallBlock(Block.Properties.of(Material.STONE).sound(SoundType.STONE).strength(2.0f, 6.0f)));
        createBlockItems(id, createBlock);



        return createBlock;

    }

    static RegistryObject<Block> createWoodPressurePlate(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.of(Material.WOOD).sound(SoundType.WOOD).noCollission().strength(0.5F)));
        createBlockItems(id, createBlock);

        return createBlock;

    }

    static RegistryObject<Block> createWoodStairs(Block block, String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new StairBlock(block.defaultBlockState(), Block.Properties.copy(Blocks.STONE).sound(SoundType.WOOD).strength(2.0f, 3.0f)));
        createBlockItems(id, createBlock);

        return createBlock;

    }
    
    static RegistryObject<Block> createStoneStairs(Block block, String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new StairBlock(block.defaultBlockState(), Block.Properties.copy(Blocks.STONE).sound(SoundType.WOOD).strength(2.0f, 3.0f)));
        createBlockItems(id, createBlock);

        return createBlock;

    }

    static RegistryObject<Block> createTrapDoor(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new TrapDoorBlock(Block.Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).sound(SoundType.WOOD).strength(2.0f, 3.0f).noOcclusion()));
        createBlockItems(id, createBlock);

        return createBlock;

    }
    
    static RegistryObject<Block> createMetalTrapDoor(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new TrapDoorBlock(Block.Properties.of(Material.METAL, MaterialColor.COLOR_BLUE).sound(SoundType.METAL).strength(3.0f, 4.0f).noOcclusion()));
        createBlockItems(id, createBlock);

        return createBlock;

    }

    static RegistryObject<Block> createWoodButton(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new WoodButtonBlock(Block.Properties.of(Material.DECORATION).sound(SoundType.WOOD).noCollission().strength(0.5F)));
        createBlockItems(id, createBlock);

        return createBlock;

    }

    static RegistryObject<Block> createDoor(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new DoorBlock(Block.Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).sound(SoundType.WOOD).strength(2.0f, 3.0f).noOcclusion()));
        createBlockItems(id, createBlock);

        return createBlock;

    }
    
    static RegistryObject<Block> createMetalDoor(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new DoorBlock(Block.Properties.of(Material.METAL, MaterialColor.COLOR_BLUE).sound(SoundType.METAL).strength(3.0f, 4.0f).noOcclusion()));
        createBlockItems(id, createBlock);

        return createBlock;


    }

    static RegistryObject<Block> createPlanks(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new Block(Block.Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).sound(SoundType.WOOD).strength(2.0f, 3.0f)));
        createBlockItems(id, createBlock);

        return createBlock;



    }

    static RegistryObject<Block> createWood(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new RotatedPillarBlock(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2.0f)));
        
        createBlockItems(id, createBlock);

        return createBlock;


    }

    static RegistryObject<Block> createStrippedLog(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new RotatedPillarBlock(Block.Properties.of(Material.WOOD, MaterialColor.COLOR_BLACK).sound(SoundType.WOOD).strength(2.0f)));
        createBlockItems(id, createBlock);

        return createBlock;



    }

    static RegistryObject<Block> createLog(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new RotatedPillarBlock(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2.0f)));
        

        createBlockItems(id, createBlock);

        return createBlock;

    }
    
    static RegistryObject<Block> createDamnationLog(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new RotatedPillarBlock(Block.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2.0f)));
        createBlockItems(id, createBlock);

        return createBlock;



    }

    static RegistryObject<Block> createFlower(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new FlowerBlock(MobEffects.CONFUSION, 0, Block.Properties.copy(Blocks.POPPY)));
        createBlockItems(id, createBlock);

        return createBlock;

    }

    static RegistryObject<Block> createTallFlower(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new TallFlowerBlock(Block.Properties.of(Material.REPLACEABLE_PLANT).sound(SoundType.GRASS).strength(0.0f).noCollission().noOcclusion()));
        createBlockItems(id, createBlock);

        return createBlock;




    }

    static RegistryObject<Block> createPottedBlock(Block blockForPot, String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new FlowerPotBlock(blockForPot, Block.Properties.of(Material.WOOD).instabreak().noOcclusion()));
        createBlockItems(id, createBlock);

        return createBlock;

    }

    static RegistryObject<Block> createShroomlight(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new Block(Block.Properties.of(Material.FROGLIGHT, MaterialColor.COLOR_PURPLE).strength(1.0F).sound(SoundType.SHROOMLIGHT).lightLevel((state) -> 14)));
        createBlockItems(id, createBlock);

        return createBlock;



    }

    static RegistryObject<Block> createLeaves(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new LeavesBlock(Block.Properties.of(Material.LEAVES).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isSuffocating((state, world, pos) -> false).isSuffocating((state, world, pos) -> false)));
        createBlockItems(id, createBlock);

        return createBlock;




    }

    static RegistryObject<Block> createGlowingLeaves(String id) {
        return createGlowingLeaves(15, id);
    }

    static RegistryObject<Block> createGlowingLeaves(int lightLevel, String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new LeavesBlock(Block.Properties.of(Material.LEAVES).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isSuffocating((state, world, pos) -> false).isSuffocating((state, world, pos) -> false).lightLevel((state) -> lightLevel)));
        
        createBlockItems(id, createBlock);

        return createBlock;


    }

    static RegistryObject<Block> createPetal(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new Block(Block.Properties.of(Material.LEAVES).sound(SoundType.GRASS).strength(0.2f).noOcclusion()));
        createBlockItems(id, createBlock);


        return createBlock;


    }

    static RegistryObject<Block> createDirt(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new Block(Block.Properties.of(Material.DIRT).sound(SoundType.GRAVEL).strength(0.2f).randomTicks()));
        createBlockItems(id, createBlock);

        return createBlock;



    }
    
    static RegistryObject<Block> createOre(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new Block(Block.Properties.copy(Blocks.DIAMOND_ORE)));
        createBlockItems(id, createBlock);

        return createBlock;


    }
    
    static RegistryObject<Block> createSoilOre(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new Block(Block.Properties.copy(Blocks.SOUL_SOIL)));
        createBlockItems(id, createBlock);

        return createBlock;


    }


    static RegistryObject<Block> createDirtOre(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new Block(Block.Properties.copy(Blocks.DIRT)));
        createBlockItems(id, createBlock);

        return createBlock;


    }
    
    static RegistryObject<Block> createDeepslateOre(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new Block(Block.Properties.copy(Blocks.DEEPSLATE_DIAMOND_ORE)));
        createBlockItems(id, createBlock);

        return createBlock;


    }
    
    static RegistryObject<Block> createMetalBlock(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new Block(Block.Properties.copy(Blocks.IRON_BLOCK)));
        createBlockItems(id, createBlock);

        return createBlock;


    }
    
    static RegistryObject<Block> createPillarMetalBlock(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new RotatedPillarBlock(Block.Properties.copy(Blocks.IRON_BLOCK)));
        createBlockItems(id, createBlock);

        return createBlock;


    }
    
    static RegistryObject<Block> createPillarBlock(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new RotatedPillarBlock(Block.Properties.copy(Blocks.STONE)));
        createBlockItems(id, createBlock);

        return createBlock;


    }
    
    public static RegistryObject<Block> createGrassBlock(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new Block(Block.Properties.of(Material.MOSS).sound(SoundType.GRASS).strength(0.2f).randomTicks()));
        createBlockItems(id, createBlock);

        return createBlock;

    }
    
/*    public static RegistryObject<Block> createLirothGrassBlock(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new LirothGrassBlock(Block.Properties.copy(Blocks.GRASS_BLOCK)));
        createBlock(createBlock, id);

    }
    
    public static RegistryObject<Block> createLirothFarmlandBlock(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new LirothFarmlandBlock(Block.Properties.copy(Blocks.FARMLAND)));
        createBlock(createBlock, id);

    }
    
    public static RegistryObject<Block> createLirothPathBlock(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new LirothPathBlock(Block.Properties.copy(Blocks.DIRT_PATH)));
        createBlock(createBlock, id);

    }
    
    public static RegistryObject<Block> createPierGrassBlock(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new PierGrassBlock(Block.Properties.copy(Blocks.GRASS_BLOCK)));
        createBlock(createBlock, id);

    }
    
    public static RegistryObject<Block> createPierFarmlandBlock(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new PierFarmlandBlock(Block.Properties.copy(Blocks.FARMLAND)));
        createBlock(createBlock, id);

    }
    
    public static RegistryObject<Block> createPierPathBlock(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new PierPathBlock(Block.Properties.copy(Blocks.DIRT_PATH)));
        createBlock(createBlock, id);

    }
    
    public static RegistryObject<Block> createSpineriosGrassBlock(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new SpineriosGrassBlock(Block.Properties.copy(Blocks.GRASS_BLOCK)));
        createBlock(createBlock, id);

    }
    
    public static RegistryObject<Block> createSpineriosFarmlandBlock(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new SpineriosFarmlandBlock(Block.Properties.copy(Blocks.FARMLAND)));
        createBlock(createBlock, id);

    }
    
    public static RegistryObject<Block> createSpineriosPathBlock(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new SpineriosPathBlock(Block.Properties.copy(Blocks.DIRT_PATH)));
        createBlock(createBlock, id);

    }*/
    
    public  static RegistryObject<Block> createGrass(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new GrassBlock(Block.Properties.copy(Blocks.GRASS)));
        createBlockItems(id, createBlock);

        return createBlock;
    }
    
    public static RegistryObject<Item> createBlockItems(String id, RegistryObject<Block> block) {
    	RegistryObject<Item> createItem = ITEMS.register(id, () -> new BlockItem(block.get(), new Item.Properties().tab(Liroth.liroth_blocks_tab)));
		return createItem;
    }
    
/*    public static RegistryObject<Block> createLirothSapling(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new CustomSapling(new LirothTree(), Block.Properties.of(Material.PLANT).noCollission().randomTicks().breakInstantly().sound(SoundType.GRASS)));
        createBlock(createBlock, id);

    }
    
    public static RegistryObject<Block> createSpicedSapling(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new CustomSapling(new SpicedTree(), Block.Properties.of(Material.PLANT).noCollission().randomTicks().breakInstantly().sound(SoundType.GRASS)));
        createBlock(createBlock, id);

    }
    
    public static RegistryObject<Block> createTallpierSapling(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new CustomSapling(new TallpierTree(), Block.Properties.of(Material.PLANT).noCollission().randomTicks().breakInstantly().sound(SoundType.GRASS)));
        createBlock(createBlock, id);

    }
    
    public static RegistryObject<Block> createJapzSapling(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new CustomSapling(new JapzTree(), Block.Properties.of(Material.PLANT).noCollission().randomTicks().breakInstantly().sound(SoundType.GRASS)));
        createBlock(createBlock, id);

    }
    
    public static RegistryObject<Block> createKoolawSapling(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new CustomSapling(new KoolawTree(), Block.Properties.of(Material.PLANT).noCollission().randomTicks().breakInstantly().sound(SoundType.GRASS)));
        createBlock(createBlock, id);

    }
    
    public static RegistryObject<Block> createDamnationSapling(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new CustomSapling(new DamnationTree(), Block.Properties.of(Material.PLANT).noCollission().randomTicks().breakInstantly().sound(SoundType.GRASS)));
        createBlock(createBlock, id);

    }
    
    public static RegistryObject<Block> createPetrifiedSapling(String id) {
        RegistryObject<Block> createBlock = BLOCKS.register(id, () -> new CustomSapling(new PetrifiedDamnationTree(), Block.Properties.of(Material.PLANT).noCollission().randomTicks().breakInstantly().sound(SoundType.GRASS)));
        createBlock(createBlock, id);

    }*/
    
    static RegistryObject<Block> createBlock(RegistryObject<Block> block, String id) {
        createBlockItems(id, block);
        return block;
    }
    
    static RegistryObject<Item> createItem(RegistryObject<Item> item, String id) {
        return item;
    }
    
    private static boolean always(BlockState state, BlockModel world, BlockPos pos) {
        return true;
    }

    public static void init() {
 /*       BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> { 
        	final Item.Properties properties = new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS);
            final BlockItem blockItem;
            blockItem = new BlockItem(block, properties);
            blockItem.create(Objects.requireNonNull(block.getName().toString()));

        });*/
    }
    
}
