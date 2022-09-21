package com.decodinator.liroth.core;

import com.decodinator.liroth.Liroth;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.HorseArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class LirothItems {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Liroth.MOD_ID);
    
//    public static final RegistryObject<Item>TEMPLATE = createItem(new Item(new Item.Properties().group(LirothCreativeTab.creativeTab)), "template");
    
    public static final RegistryObject<Item>BLOODY_ENTRAILS = createFoodItem("bloody_entrails", Foods.ROTTEN_FLESH);
    
//    public static final RegistryObject<Item>COOL_BEAM = createItem(new BeamItem(new Item.Properties()), "cool_beam");
    
//    public static final RegistryObject<Item>CORRUPTED_JALSPHIRE_GEM = createItem("corrupted_jalsphire_gem");
    
//    public static final RegistryObject<Item>CORRUPTED_LIROTH_GEM = createItem("corrupted_liroth_gem");
    
//    public static final RegistryObject<Item>CORRUPTED_LIROTH_STAR = createItem("corrupted_liroth_star");
    
//    public static final RegistryObject<Item>CORRUPTED_ROD = createItem(new Item(new Item.Properties().group(LirothCreativeTab.creativeTab)), "corrupted_rod"); IS NOW THE COOL BEAM
    
    
//    public static final RegistryObject<Item>EMBUED_LIROTH_GEM = createItem("embued_liroth_gem");
    
    public static final RegistryObject<Item>GLEEMSTONE_DUST = createItem("gleemstone_dust");
    
    public static final RegistryObject<Item>JALSPHIRE_DUST = createItem("jalsphire_dust");
    public static final RegistryObject<Item>JALSPHIRE_DUST_HEAP = createItem("jalsphire_dust_heap");
    public static final RegistryObject<Item>JALSPHIRE_GEM = createItem("jalsphire_gem");
    
    public static final RegistryObject<Item>LIROTH_GEM_ANSALUM = createItem("liroth_gem_ansalum");

    public static final RegistryObject<Item>LIROTH_BERRY = createFoodItem("liroth_berry", Foods.SUSPICIOUS_STEW);

//    public static final RegistryObject<Item>LIROTH_BLASTER = createRangedItem(new LirothBlaster(new Item.Properties().tab(Liroth.liroth_combat_tab).stacksTo(1)), "liroth_blaster");
    
/*    public static final LirothBoatItem LIROTH_BOAT = new LirothBoatItem(false, new FabricItemSettings().group(ItemGroup.TRANSPORTATION).stacksTo(1));
    public static final LirothBoatItem CHEST_LIROTH_BOAT = new LirothBoatItem(true, new FabricItemSettings().group(ItemGroup.TRANSPORTATION).stacksTo(1));
    public static final DamnationBoatItem DAMNATION_BOAT = new DamnationBoatItem(false, new FabricItemSettings().group(ItemGroup.TRANSPORTATION).stacksTo(1));
    public static final DamnationBoatItem CHEST_DAMNATION_BOAT = new DamnationBoatItem(true, new FabricItemSettings().group(ItemGroup.TRANSPORTATION).stacksTo(1));
    public static final SpicedBoatItem SPICED_BOAT = new SpicedBoatItem(false, new FabricItemSettings().group(ItemGroup.TRANSPORTATION).stacksTo(1));
    public static final SpicedBoatItem CHEST_SPICED_BOAT = new SpicedBoatItem(true, new FabricItemSettings().group(ItemGroup.TRANSPORTATION).stacksTo(1));
    public static final PierBoatItem PIER_BOAT = new PierBoatItem(false, new FabricItemSettings().group(ItemGroup.TRANSPORTATION).stacksTo(1));
    public static final PierBoatItem CHEST_PIER_BOAT = new PierBoatItem(true, new FabricItemSettings().group(ItemGroup.TRANSPORTATION).stacksTo(1));
    public static final JapzBoatItem JAPZ_BOAT = new JapzBoatItem(false, new FabricItemSettings().group(ItemGroup.TRANSPORTATION).stacksTo(1));
    public static final JapzBoatItem CHEST_JAPZ_BOAT = new JapzBoatItem(true, new FabricItemSettings().group(ItemGroup.TRANSPORTATION).stacksTo(1));
    public static final KoolawBoatItem KOOLAW_BOAT = new KoolawBoatItem(false, new FabricItemSettings().group(ItemGroup.TRANSPORTATION).stacksTo(1));
    public static final KoolawBoatItem CHEST_KOOLAW_BOAT = new KoolawBoatItem(true, new FabricItemSettings().group(ItemGroup.TRANSPORTATION).stacksTo(1));
    public static final PetrifiedBoatItem PETRIFIED_BOAT = new PetrifiedBoatItem(false, new FabricItemSettings().group(ItemGroup.TRANSPORTATION).stacksTo(1));
    public static final PetrifiedBoatItem CHEST_PETRIFIED_BOAT = new PetrifiedBoatItem(true, new FabricItemSettings().group(ItemGroup.TRANSPORTATION).stacksTo(1));*/
    
    public static final RegistryObject<Item>LIROTH_BONE = createItem("liroth_bone");

    public static final RegistryObject<Item>LIROTH_DUST_ANSALUM = createItem("liroth_dust_ansalum");
    public static final RegistryObject<Item>LIROTH_DUST_LUX = createItem("liroth_dust_lux");
    public static final RegistryObject<Item>LIROTH_DUST_SALEM = createItem("liroth_dust_salem");
    
    public static final RegistryObject<Item>LIROTH_GEM = createItem("liroth_gem");
    public static final RegistryObject<Item>LIROTH_GEM_DUST = createItem("liroth_gem_dust");
    public static final RegistryObject<Item>LIROTH_GEM_DUST_HEAP = createItem("liroth_gem_dust_heap");
    
    //It's got that extreme pulp of taking a big ass bite out of a lemon and the tanginess of blackberries while the taste itself is a strawberry metallic flavor
    public static final RegistryObject<Item>LIROTH_COATED_BREAD = createFoodItem("liroth_coated_bread", Foods.BREAD);
    
    public static final RegistryObject<Item>LIROTH_GEM_LUX = createItem("liroth_gem_lux");

    // HMMMMMMMMMMM
//    public static final RegistryObject<Item>LIROTHIAN_DUNGEON_KEY = createItem(new KeyItem(new Item.Properties().tab(Liroth.liroth_items_tab).maxDamage(1)), "lirothian_dungeon_key");
    
    public static final RegistryObject<Item>LIROTH_GEM_SALEM = createItem("liroth_gem_salem");
    
    public static final RegistryObject<Item>LIROTHIAN_COBALT_INGOT = createItem("lirothian_cobalt_ingot");
    public static final RegistryObject<Item>LIROTHIAN_COBALT_NUGGET = createItem("lirothian_cobalt_nugget");
    public static final RegistryObject<Item>LIROTHIAN_COBALT_HORSE_ARMOR = createHonseArmorItem("lirothian_cobalt_horse_armor");
    public static final RegistryObject<Item>RAW_LIROTHIAN_COBALT = createItem("raw_lirothian_cobalt");

    public static final RegistryObject<Item>LIROTHIAN_PETROLEUM = createItem("lirothian_petroleum");
    
/*    public static final RegistryObject<Item>LIROTH_SHIELD = createShieldItem(new LirothShield(new Item.Properties().tab(Liroth.liroth_combat_tab).stacksTo(1)), "liroth_shield");
    public static final RegistryObject<Item>ANSALUM_LIROTH_SHIELD = createAnsalumShieldItem(new AnsalumLirothShield(new Item.Properties().tab(Liroth.liroth_combat_tab).stacksTo(1)), "ansalum_liroth_shield");
    public static final RegistryObject<Item>LUX_LIROTH_SHIELD = createLuxShieldItem(new LuxLirothShield(new Item.Properties().tab(Liroth.liroth_combat_tab).stacksTo(1)), "lux_liroth_shield");
    public static final RegistryObject<Item>SALEM_LIROTH_SHIELD = createSalemShieldItem(new SalemLirothShield(new Item.Properties().tab(Liroth.liroth_combat_tab).stacksTo(1)), "salem_liroth_shield");
    public static final RegistryObject<Item>QUANTUM_LIROTH_SHIELD = createQuantumShieldItem(new QuantumLirothShield(new Item.Properties().tab(Liroth.liroth_combat_tab).stacksTo(1)), "quantum_liroth_shield");
    */
    public static final RegistryObject<Item>LIROTH_SOUL_DUST = createItem("liroth_soul_dust");
    
//    public static final RegistryObject<Item>LIROTH_STAR = createItem("liroth_star");

    public static final RegistryObject<Item>LIROTH_TEAR = createItem("liroth_tear");
        
    public static final RegistryObject<Item>PURPETUATED_AMETHYST_SHARD = createItem("purpetuated_amethyst_shard");
//    public static final RegistryObject<Item>PURPETUATED_SPYGLASS = createItem(new PurpetuatedSpyglassItem(new Item.Properties().group(LirothCreativeTab.creativeTab)), "purpetuated_spyglass");
    
    public static final RegistryObject<Item>QUANTUM_DIAMOND = createItem("quantum_diamond");
    
    public static final RegistryObject<Item>QUANTUM_PLATE = createItem("quantum_plate");
    public static final RegistryObject<Item>RUBY = createItem("ruby");
    public static final RegistryObject<Item>POTESTIUM_SHARD = createItem("potestium_shard");
//    public static final RegistryObject<Item>SOUL_GLASS_BOTTLE = createItem("soul_glass_bottle");
    public static final RegistryObject<Item>SPINERIOS_STONE_PEBBLE = createItem("spinerios_stone_pebble");
    
    public static final RegistryObject<Item>TOURMALINE = createItem("tourmaline");
        
/*    public static final RegistryObject<Item>LIROTH_HELMET = createArmorItem(new ArmorItem(LirothArmorMaterials.LIROTH_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Properties().tab(Liroth.liroth_combat_tab)), "liroth_helmet");
    public static final RegistryObject<Item>LIROTH_CHESTPLATE = createArmorItem(new ArmorItem(LirothArmorMaterials.LIROTH_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Properties().tab(Liroth.liroth_combat_tab)), "liroth_chestplate");
    public static final RegistryObject<Item>LIROTH_LEGGINGS = createArmorItem(new ArmorItem(LirothArmorMaterials.LIROTH_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Properties().tab(Liroth.liroth_combat_tab)), "liroth_leggings");
    public static final RegistryObject<Item>LIROTH_BOOTS = createArmorItem(new ArmorItem(LirothArmorMaterials.LIROTH_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Properties().tab(Liroth.liroth_combat_tab)), "liroth_boots");
    
    public static final RegistryObject<Item>LIROTHIAN_COBALT_HELMET = createArmorItem(new ArmorItem(LirothArmorMaterials.LIROTHIAN_COBALT_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Properties().tab(Liroth.liroth_combat_tab)), "lirothian_cobalt_helmet");
    public static final RegistryObject<Item>LIROTHIAN_COBALT_CHESTPLATE = createArmorItem(new ArmorItem(LirothArmorMaterials.LIROTHIAN_COBALT_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Properties().tab(Liroth.liroth_combat_tab)), "lirothian_cobalt_chestplate");
    public static final RegistryObject<Item>LIROTHIAN_COBALT_LEGGINGS = createArmorItem(new ArmorItem(LirothArmorMaterials.LIROTHIAN_COBALT_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Properties().tab(Liroth.liroth_combat_tab)), "lirothian_cobalt_leggings");
    public static final RegistryObject<Item>LIROTHIAN_COBALT_BOOTS = createArmorItem(new ArmorItem(LirothArmorMaterials.LIROTHIAN_COBALT_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Properties().tab(Liroth.liroth_combat_tab)), "lirothian_cobalt_boots");
    
    public static final RegistryObject<Item>ANSALUM_LIROTH_HELMET = createArmorItem(new AnsalumArmorItem(LirothArmorMaterials.ANSALUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Properties().tab(Liroth.liroth_combat_tab)), "ansalum_liroth_helmet");
    public static final RegistryObject<Item>ANSALUM_LIROTH_CHESTPLATE = createArmorItem(new AnsalumArmorItem(LirothArmorMaterials.ANSALUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Properties().tab(Liroth.liroth_combat_tab)), "ansalum_liroth_chestplate");
    public static final RegistryObject<Item>ANSALUM_LIROTH_LEGGINGS = createArmorItem(new AnsalumArmorItem(LirothArmorMaterials.ANSALUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Properties().tab(Liroth.liroth_combat_tab)), "ansalum_liroth_leggings");
    public static final RegistryObject<Item>ANSALUM_LIROTH_BOOTS = createArmorItem(new AnsalumArmorItem(LirothArmorMaterials.ANSALUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Properties().tab(Liroth.liroth_combat_tab)), "ansalum_liroth_boots");
    
    public static final RegistryObject<Item>ANSALUM_LIROTH_AXE = createToolItem(new CustomAxeItem(LirothToolMaterials.ANSALUM_LIROTH_TOOL_MATERIAL, 7.0f, -3.0f, new Item.Properties().tab(Liroth.liroth_combat_tab).fireproof()), "ansalum_liroth_axe");
    public static final RegistryObject<Item>LUX_LIROTH_KATANA = createToolItem(new SwordItem(LirothToolMaterials.LUX_LIROTH_TOOL_MATERIAL, 2, -1.4f, new Item.Properties().tab(Liroth.liroth_combat_tab).fireproof()), "lux_liroth_katana");
    public static final RegistryObject<Item>SALEM_LIROTH_FALCHION = createToolItem(new SwordItem(LirothToolMaterials.SALEM_LIROTH_TOOL_MATERIAL, 4, -2.4f, new Item.Properties().tab(Liroth.liroth_combat_tab).fireproof()), "salem_liroth_falchion");
    
    public static final RegistryObject<Item>QUANTUM_LIROTH_SWORD = createToolItem(new SwordItem(LirothToolMaterials.QUANTUM_LIROTH_TOOL_MATERIAL, 4, -2.4f, new Item.Properties().tab(Liroth.liroth_combat_tab).fireproof()), "quantum_liroth_sword");
    public static final RegistryObject<Item>QUANTUM_LIROTH_SHOVEL = createToolItem(new ShovelItem(LirothToolMaterials.QUANTUM_LIROTH_TOOL_MATERIAL, 1.5f, -3.0f, new Item.Properties().tab(Liroth.liroth_combat_tab).fireproof()), "quantum_liroth_shovel");
    public static final RegistryObject<Item>QUANTUM_LIROTH_PICKAXE = createToolItem(new CustomPickaxeItem(LirothToolMaterials.QUANTUM_LIROTH_TOOL_MATERIAL, 1, -2.8f, new Item.Properties().tab(Liroth.liroth_combat_tab).fireproof()), "quantum_liroth_pickaxe");
    public static final RegistryObject<Item>QUANTUM_LIROTH_AXE = createToolItem(new CustomAxeItem(LirothToolMaterials.QUANTUM_LIROTH_TOOL_MATERIAL, 5.0f, -3.0f, new Item.Properties().tab(Liroth.liroth_combat_tab).fireproof()), "quantum_liroth_axe");
    public static final RegistryObject<Item>QUANTUM_LIROTH_HOE = createToolItem(new CustomHoeItem(LirothToolMaterials.QUANTUM_LIROTH_TOOL_MATERIAL, -4, 0.0f, new Item.Properties().tab(Liroth.liroth_combat_tab).fireproof()), "quantum_liroth_hoe");
    
    public static final RegistryObject<Item>LUX_LIROTH_HELMET = createArmorItem(new LuxArmorItem(LirothArmorMaterials.LUX_LIROTH_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Properties().tab(Liroth.liroth_combat_tab)), "lux_liroth_helmet");
    public static final RegistryObject<Item>LUX_LIROTH_CHESTPLATE = createArmorItem(new LuxArmorItem(LirothArmorMaterials.LUX_LIROTH_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Properties().tab(Liroth.liroth_combat_tab)), "lux_liroth_chestplate");
    public static final RegistryObject<Item>LUX_LIROTH_LEGGINGS = createArmorItem(new LuxArmorItem(LirothArmorMaterials.LUX_LIROTH_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Properties().tab(Liroth.liroth_combat_tab)), "lux_liroth_leggings");
    public static final RegistryObject<Item>LUX_LIROTH_BOOTS = createArmorItem(new LuxArmorItem(LirothArmorMaterials.LUX_LIROTH_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Properties().tab(Liroth.liroth_combat_tab)), "lux_liroth_boots");
    
    public static final RegistryObject<Item>SALEM_LIROTH_HELMET = createArmorItem(new SalemArmorItem(LirothArmorMaterials.SALEM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Properties().tab(Liroth.liroth_combat_tab)), "salem_liroth_helmet");
    public static final RegistryObject<Item>SALEM_LIROTH_CHESTPLATE = createArmorItem(new SalemArmorItem(LirothArmorMaterials.SALEM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Properties().tab(Liroth.liroth_combat_tab)), "salem_liroth_chestplate");
    public static final RegistryObject<Item>SALEM_LIROTH_LEGGINGS = createArmorItem(new SalemArmorItem(LirothArmorMaterials.SALEM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Properties().tab(Liroth.liroth_combat_tab)), "salem_liroth_leggings");
    public static final RegistryObject<Item>SALEM_LIROTH_BOOTS = createArmorItem(new SalemArmorItem(LirothArmorMaterials.SALEM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Properties().tab(Liroth.liroth_combat_tab)), "salem_liroth_boots");
    
    public static final RegistryObject<Item>QUANTUM_LIROTH_HELMET = createArmorItem(new QuantumArmorItem(LirothArmorMaterials.QUANTUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Properties().tab(Liroth.liroth_combat_tab)), "quantum_liroth_helmet");
    public static final RegistryObject<Item>QUANTUM_LIROTH_CHESTPLATE = createArmorItem(new QuantumArmorItem(LirothArmorMaterials.QUANTUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Properties().tab(Liroth.liroth_combat_tab)), "quantum_liroth_chestplate");
    public static final RegistryObject<Item>QUANTUM_LIROTH_LEGGINGS = createArmorItem(new QuantumArmorItem(LirothArmorMaterials.QUANTUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Properties().tab(Liroth.liroth_combat_tab)), "quantum_liroth_leggings");
    public static final RegistryObject<Item>QUANTUM_LIROTH_BOOTS = createArmorItem(new QuantumArmorItem(LirothArmorMaterials.QUANTUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Properties().tab(Liroth.liroth_combat_tab)), "quantum_liroth_boots");
    
    public static final RegistryObject<Item>POTESTIUM_LIROTH_HELMET = createArmorItem(new PotestiumHelmItem(LirothArmorMaterials.POTESTIUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Properties().tab(Liroth.liroth_combat_tab)), "potestium_liroth_helmet");
    public static final RegistryObject<Item>POTESTIUM_LIROTH_CHESTPLATE = createArmorItem(new PotestiumArmorItem(LirothArmorMaterials.POTESTIUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Properties().tab(Liroth.liroth_combat_tab)), "potestium_liroth_chestplate");
    public static final RegistryObject<Item>POTESTIUM_LIROTH_LEGGINGS = createArmorItem(new PotestiumArmorItem(LirothArmorMaterials.POTESTIUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Properties().tab(Liroth.liroth_combat_tab)), "potestium_liroth_leggings");
    public static final RegistryObject<Item>POTESTIUM_LIROTH_BOOTS = createArmorItem(new PotestiumArmorItem(LirothArmorMaterials.POTESTIUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Properties().tab(Liroth.liroth_combat_tab)), "potestium_liroth_boots");
    
    public static final RegistryObject<Item>POTESTIUM_SCYTHE = createToolItem(new CustomScytheItem(LirothToolMaterials.QUANTUM_LIROTH_TOOL_MATERIAL, 3, 0.0f, new Item.Properties().tab(Liroth.liroth_combat_tab).fireproof()), "potestium_scythe");
    
    public static final RegistryObject<Item>LIROTH_SWORD = createToolItem(new SwordItem(LirothToolMaterials.LIROTH_TOOL_MATERIAL, 3, -2.4f, new Item.Properties().tab(Liroth.liroth_combat_tab).fireproof()), "liroth_sword");
    public static final RegistryObject<Item>LIROTH_SHOVEL = createToolItem(new ShovelItem(LirothToolMaterials.LIROTH_TOOL_MATERIAL, 1.5f, -3.0f, new Item.Properties().tab(Liroth.liroth_combat_tab).fireproof()), "liroth_shovel");
    public static final RegistryObject<Item>LIROTH_PICKAXE = createToolItem(new CustomPickaxeItem(LirothToolMaterials.LIROTH_TOOL_MATERIAL, 1, -2.8f, new Item.Properties().tab(Liroth.liroth_combat_tab).fireproof()), "liroth_pickaxe");
    public static final RegistryObject<Item>LIROTH_AXE = createToolItem(new CustomAxeItem(LirothToolMaterials.LIROTH_TOOL_MATERIAL, 5.0f, -3.0f, new Item.Properties().tab(Liroth.liroth_combat_tab).fireproof()), "liroth_axe");
    public static final RegistryObject<Item>LIROTH_HOE = createToolItem(new CustomHoeItem(LirothToolMaterials.LIROTH_TOOL_MATERIAL, -4, 0.0f, new Item.Properties().tab(Liroth.liroth_combat_tab).fireproof()), "liroth_hoe");
    
    public static final RegistryObject<Item>LIROTHIAN_COBALT_SWORD = createToolItem(new SwordItem(LirothToolMaterials.LIROTHIAN_COBALT_TOOL_MATERIAL, 3, -2.4f, new Item.Properties().tab(Liroth.liroth_combat_tab).fireproof()), "lirothian_cobalt_sword");
    public static final RegistryObject<Item>LIROTHIAN_COBALT_SHOVEL = createToolItem(new ShovelItem(LirothToolMaterials.LIROTHIAN_COBALT_TOOL_MATERIAL, 1.5f, -3.0f, new Item.Properties().tab(Liroth.liroth_combat_tab).fireproof()), "lirothian_cobalt_shovel");
    public static final RegistryObject<Item>LIROTHIAN_COBALT_PICKAXE = createToolItem(new CustomPickaxeItem(LirothToolMaterials.LIROTHIAN_COBALT_TOOL_MATERIAL, 1, -2.8f, new Item.Properties().tab(Liroth.liroth_combat_tab).fireproof()), "lirothian_cobalt_pickaxe");
    public static final RegistryObject<Item>LIROTHIAN_COBALT_AXE = createToolItem(new CustomAxeItem(LirothToolMaterials.LIROTHIAN_COBALT_TOOL_MATERIAL, 5.0f, -3.0f, new Item.Properties().tab(Liroth.liroth_combat_tab).fireproof()), "lirothian_cobalt_axe");
    public static final RegistryObject<Item>LIROTHIAN_COBALT_HOE = createToolItem(new CustomHoeItem(LirothToolMaterials.LIROTHIAN_COBALT_TOOL_MATERIAL, -4, 0.0f, new Item.Properties().tab(Liroth.liroth_combat_tab).fireproof()), "lirothian_cobalt_hoe");
    
    public static final RegistryObject<Item>TOURMALINE_HELMET = createArmorItem(new ArmorItem(LirothArmorMaterials.TOURMALINE_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Properties().tab(Liroth.liroth_combat_tab)), "tourmaline_helmet");
    public static final RegistryObject<Item>TOURMALINE_CHESTPLATE = createArmorItem(new ArmorItem(LirothArmorMaterials.TOURMALINE_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Properties().tab(Liroth.liroth_combat_tab)), "tourmaline_chestplate");
    public static final RegistryObject<Item>TOURMALINE_LEGGINGS = createArmorItem(new ArmorItem(LirothArmorMaterials.TOURMALINE_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Properties().tab(Liroth.liroth_combat_tab)), "tourmaline_leggings");
    public static final RegistryObject<Item>TOURMALINE_BOOTS = createArmorItem(new ArmorItem(LirothArmorMaterials.TOURMALINE_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Properties().tab(Liroth.liroth_combat_tab)), "tourmaline_boots");
    
    public static final RegistryObject<Item>TOURMALINE_SWORD = createToolItem(new SwordItem(LirothToolMaterials.TOURMALINE_TOOL_MATERIAL, 3, -2.4f, new Item.Properties().tab(Liroth.liroth_combat_tab).fireproof()), "tourmaline_sword");
    public static final RegistryObject<Item>TOURMALINE_SHOVEL = createToolItem(new ShovelItem(LirothToolMaterials.TOURMALINE_TOOL_MATERIAL, 1.5f, -3.0f, new Item.Properties().tab(Liroth.liroth_combat_tab).fireproof()), "tourmaline_shovel");
    public static final RegistryObject<Item>TOURMALINE_PICKAXE = createToolItem(new CustomPickaxeItem(LirothToolMaterials.TOURMALINE_TOOL_MATERIAL, 1, -2.8f, new Item.Properties().tab(Liroth.liroth_combat_tab).fireproof()), "tourmaline_pickaxe");
    public static final RegistryObject<Item>TOURMALINE_AXE = createToolItem(new CustomAxeItem(LirothToolMaterials.TOURMALINE_TOOL_MATERIAL, 5.0f, -3.0f, new Item.Properties().tab(Liroth.liroth_combat_tab).fireproof()), "tourmaline_axe");
    public static final RegistryObject<Item>TOURMALINE_HOE = createToolItem(new CustomHoeItem(LirothToolMaterials.TOURMALINE_TOOL_MATERIAL, -4, 0.0f, new Item.Properties().tab(Liroth.liroth_combat_tab).fireproof()), "tourmaline_hoe");
    
    public static final RegistryObject<Item>FUNGAL_FIEND_SPAWN_EGG = new SpawnEggItem(LirothEntities.FUNGAL_FIEND, 1315860, 2031360, new Item.Properties().group(LirothCreativeTab.creativeEntitiesTab));
    public static final RegistryObject<Item>FORSAKEN_CORPSE_SPAWN_EGG = new SpawnEggItem(LirothEntities.FORSAKEN_CORPSE, 1842204, 10551525, new Item.Properties().group(LirothCreativeTab.creativeEntitiesTab));
    public static final RegistryObject<Item>SKELETAL_FREAK_SPAWN_EGG = new SpawnEggItem(LirothEntities.SKELETAL_FREAK, 1513239, 16711900, new Item.Properties().group(LirothCreativeTab.creativeEntitiesTab));
    public static final RegistryObject<Item>WARP_SPAWN_EGG = new SpawnEggItem(LirothEntities.WARP, 524305, 4260003, new Item.Properties().group(LirothCreativeTab.creativeEntitiesTab));
    public static final RegistryObject<Item>SOUL_ARACHNID_SPAWN_EGG = new SpawnEggItem(LirothEntities.SOUL_ARACHNID, 73758, 5078138, new Item.Properties().group(LirothCreativeTab.creativeEntitiesTab));
    public static final RegistryObject<Item>PIER_PEEP_SPAWN_EGG = new SpawnEggItem(LirothEntities.PIER_PEEP, 1638400, 11665663, new Item.Properties().group(LirothCreativeTab.creativeEntitiesTab));
    public static final RegistryObject<Item>SHADE_SPAWN_EGG = new SpawnEggItem(LirothEntities.SHADE, 328965, 1579032, new Item.Properties().group(LirothCreativeTab.creativeEntitiesTab));
    public static final RegistryObject<Item>PROWLER_SPAWN_EGG = new SpawnEggItem(LirothEntities.PROWLER, 16312063, 4260003, new Item.Properties().group(LirothCreativeTab.creativeEntitiesTab));
    public static final RegistryObject<Item>FREAKSHOW_SPAWN_EGG = new SpawnEggItem(LirothEntities.FREAKSHOW, 524305, 1579032, new Item.Properties().group(LirothCreativeTab.creativeEntitiesTab));
    public static final RegistryObject<Item>VILE_SHARK_SPAWN_EGG = new SpawnEggItem(LirothEntities.VILE_SHARK, 5963996, 7667865, new Item.Properties().group(LirothCreativeTab.creativeEntitiesTab));
    public static final RegistryObject<Item>LIROTHIAN_MIMIC_SPAWN_EGG = new SpawnEggItem(LirothEntities.LIROTHIAN_MIMIC, 41655, 10551525, new Item.Properties().group(LirothCreativeTab.creativeEntitiesTab));
*/

 /*   private static RegistryObject<Item>createArmorItem(ArmorItem armorItem, String id) {
      return armorItem;
	}
    
    private static RegistryObject<Item>createShieldItem(LirothShield shieldItem, String id) {
      return shieldItem;
	}
    
    private static RegistryObject<Item>createAnsalumShieldItem(AnsalumLirothShield shieldItem, String id) {
      return shieldItem;
	}
    
    private static RegistryObject<Item>createLuxShieldItem(LuxLirothShield shieldItem, String id) {
      return shieldItem;
	}
    
    private static RegistryObject<Item>createSalemShieldItem(SalemLirothShield shieldItem, String id) {
      return shieldItem;
	}
    
    private static RegistryObject<Item>createQuantumShieldItem(QuantumLirothShield shieldItem, String id) {
      return shieldItem;
	}
    
    private static RegistryObject<Item>createToolItem(ToolItem toolItem, String id) {
      return toolItem;
	}
    
    private static RegistryObject<Item>createRangedItem(LirothBlaster blasterItem, String id) {
      return blasterItem;
	}*/
	
    static RegistryObject<Item> createItem(String id) {
		RegistryObject<Item> createItem = ITEMS.register(id, () -> new Item(new Item.Properties().tab(Liroth.liroth_items_tab)));
        return createItem;    
    }
    
    static RegistryObject<Item> createHonseArmorItem(String id) {
		RegistryObject<Item> createItem = ITEMS.register(id, () -> new HorseArmorItem(5, id, new Item.Properties().tab(Liroth.liroth_combat_tab)));
        return createItem;    
    }
    
    static RegistryObject<Item> createFoodItem(String id, FoodProperties food) {
		RegistryObject<Item> createItem = ITEMS.register(id, () -> new Item(new Item.Properties().tab(Liroth.liroth_items_tab).food(food)));
        return createItem;    
    }

	public static void init() {
		
	}
}