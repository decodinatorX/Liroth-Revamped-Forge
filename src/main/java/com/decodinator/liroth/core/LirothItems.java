package com.decodinator.liroth.core;

import java.util.ArrayList;
import java.util.Collection;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.items.AnomalyChargeItem;
import com.decodinator.liroth.core.items.BeamItem;
import com.decodinator.liroth.core.items.DamnationChargeItem;
import com.decodinator.liroth.core.items.JalsphireIgnitorItem;
import com.decodinator.liroth.core.items.JantiroChargeItem;
import com.decodinator.liroth.core.items.KeyItem;
import com.decodinator.liroth.core.items.LirothBlaster;
import com.decodinator.liroth.core.items.LirothBoatItem;
import com.decodinator.liroth.core.items.LirothChargeItem;
import com.decodinator.liroth.core.items.PotestiumHelmetItem;
import com.decodinator.liroth.core.items.UnusedItem;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.HorseArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class LirothItems {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Liroth.MOD_ID);
    public static final Collection<RegistryObject<Item>> ITEMS_FOR_TAB_LIST = new ArrayList<>();
    public static final Collection<RegistryObject<Item>> COMBAT_ITEMS_FOR_TAB_LIST = new ArrayList<>();
    public static final Collection<RegistryObject<Item>> SPAWN_EGG_ITEMS_FOR_TAB_LIST = new ArrayList<>();

//    public static final RegistryObject<Item>TEMPLATE = createItem(new Item(new Item.Properties().group(LirothCreativeTab.creativeTab)), "template");
    
    public static final RegistryObject<AnomalyChargeItem>ANOMALY_CHARGE = createAnomalyChargeItem("anomaly_charge");
	
    public static final RegistryObject<Item>BLOODY_ENTRAILS = createFoodItem("bloody_entrails", Foods.ROTTEN_FLESH);
    
    public static final RegistryObject<Item>COOL_BEAM = createBeamItem("cool_beam");
    
    public static final RegistryObject<DamnationChargeItem> DAMNATION_CHARGE = createDamnationChargeItem("damnation_charge");
    
//    public static final RegistryObject<Item>CORRUPTED_JALSPHIRE_GEM = createItem("corrupted_jalsphire_gem");
    
//    public static final RegistryObject<Item>CORRUPTED_LIROTH_GEM = createItem("corrupted_liroth_gem");
    
//    public static final RegistryObject<Item>CORRUPTED_LIROTH_STAR = createItem("corrupted_liroth_star");
    
//    public static final RegistryObject<Item>CORRUPTED_ROD = createItem(new Item(new Item.Properties().group(LirothCreativeTab.creativeTab)), "corrupted_rod"); IS NOW THE COOL BEAM
    
    
    public static final RegistryObject<Item> EMBUED_LIROTH_GEM = createUnusedItem("embued_liroth_gem");
    
    public static final RegistryObject<Item>GLEEMSTONE_DUST = createItem("gleemstone_dust");
    
    public static final RegistryObject<JalsphireIgnitorItem> JALSPHIRE_CHARGE = createJalpshireChargeItem("jalsphire_charge");
    public static final RegistryObject<Item>JALSPHIRE_DUST = createItem("jalsphire_dust");
    public static final RegistryObject<Item>JALSPHIRE_DUST_HEAP = createItem("jalsphire_dust_heap");
    public static final RegistryObject<Item>JALSPHIRE_GEM = createItem("jalsphire_gem");
    
    public static final RegistryObject<JantiroChargeItem> JANTIRO_CHARGE = createJantiroChargeItem("jantiro_charge");
    
    public static final RegistryObject<LirothChargeItem>LIROTH_CHARGE = createLirothChargeItem("liroth_charge");
    
    public static final RegistryObject<Item>LIROTH_GEM_ANSALUM = createItem("liroth_gem_ansalum");

    public static final RegistryObject<Item>LIROTH_BERRY = createFoodItem("liroth_berry", Foods.SWEET_BERRIES);

    public static final RegistryObject<Item>LIROTH_BLASTER = createRangedItem("liroth_blaster");
    
    public static final RegistryObject<Item> LIROTH_BOAT = createBoatItem("liroth_boat", LirothBoat.LirothType.LIROTH);
    public static final RegistryObject<Item> CHEST_LIROTH_BOAT = createChestBoatItem("liroth_chest_boat", LirothBoat.LirothType.LIROTH);
    public static final RegistryObject<Item> DAMNATION_BOAT = createBoatItem("damnation_boat", LirothBoat.LirothType.DAMNATION);
    public static final RegistryObject<Item> CHEST_DAMNATION_BOAT = createChestBoatItem("damnation_chest_boat", LirothBoat.LirothType.DAMNATION);
    public static final RegistryObject<Item> SPICED_BOAT = createBoatItem("spiced_boat", LirothBoat.LirothType.SPICED);
    public static final RegistryObject<Item> CHEST_SPICED_BOAT = createChestBoatItem("spiced_chest_boat", LirothBoat.LirothType.SPICED);
    public static final RegistryObject<Item> PIER_BOAT = createBoatItem("tallpier_boat", LirothBoat.LirothType.PIER);
    public static final RegistryObject<Item> CHEST_PIER_BOAT = createChestBoatItem("tallpier_chest_boat", LirothBoat.LirothType.PIER);
    public static final RegistryObject<Item> JAPZ_BOAT = createBoatItem("japz_boat", LirothBoat.LirothType.JAPZ);
    public static final RegistryObject<Item> CHEST_JAPZ_BOAT = createChestBoatItem("japz_chest_boat", LirothBoat.LirothType.JAPZ);
    public static final RegistryObject<Item> KOOLAW_BOAT = createBoatItem("koolaw_boat", LirothBoat.LirothType.KOOLAW);
    public static final RegistryObject<Item> CHEST_KOOLAW_BOAT = createChestBoatItem("koolaw_chest_boat", LirothBoat.LirothType.KOOLAW);
    public static final RegistryObject<Item> PETRIFIED_BOAT = createBoatItem("petrified_boat", LirothBoat.LirothType.PETRIFIED);
    public static final RegistryObject<Item> CHEST_PETRIFIED_BOAT = createChestBoatItem("petrified_chest_boat", LirothBoat.LirothType.PETRIFIED);
    
    public static final RegistryObject<Item>LIROTH_BONE = createItem("liroth_bone");

    public static final RegistryObject<Item>LIROTH_DUST_ANSALUM = createItem("liroth_dust_ansalum");
    public static final RegistryObject<Item>LIROTH_DUST_LUX = createItem("liroth_dust_lux");
    public static final RegistryObject<Item>LIROTH_DUST_SALEM = createItem("liroth_dust_salem");
    
    public static final FoodProperties LIROTH_GEM_FOOD = (new FoodProperties.Builder()).nutrition(4).saturationMod(1.2F).effect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 1), 1.0F).effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2400, 0), 1.0F).alwaysEat().build();

    public static final RegistryObject<Item>LIROTH_GEM = createFoodItem("liroth_gem", LIROTH_GEM_FOOD);
    public static final RegistryObject<Item>LIROTH_GEM_DUST = createItem("liroth_gem_dust");
    public static final RegistryObject<Item>LIROTH_GEM_DUST_HEAP = createItem("liroth_gem_dust_heap");
    
    //It's got that extreme pulp of taking a big ass bite out of a lemon and the tanginess of blackberries while the taste itself is a strawberry metallic flavor
    public static final RegistryObject<Item>LIROTH_COATED_BREAD = createFoodItem("liroth_coated_bread", Foods.GOLDEN_APPLE);
    
    public static final RegistryObject<Item>LIROTH_GEM_LUX = createItem("liroth_gem_lux");

    // HMMMMMMMMMMM
    public static final RegistryObject<Item>LIROTHIAN_DUNGEON_KEY = createKeyItem("lirothian_dungeon_key");
    
    public static final RegistryObject<Item>LIROTH_GEM_SALEM = createItem("liroth_gem_salem");
    
    public static final RegistryObject<Item>LIROTHIAN_COBALT_INGOT = createItem("lirothian_cobalt_ingot");
    public static final RegistryObject<Item>LIROTHIAN_COBALT_NUGGET = createItem("lirothian_cobalt_nugget");
    public static final RegistryObject<Item>LIROTHIAN_COBALT_HORSE_ARMOR = createHonseArmorItem(5, "lirothian_cobalt_horse_armor");
    public static final RegistryObject<Item>LIROTH_HORSE_ARMOR = createHonseArmorItem(9, "liroth_horse_armor");
    public static final RegistryObject<Item>QUANTUM_HORSE_ARMOR = createHonseArmorItem(10, "quantum_horse_armor");
    public static final RegistryObject<Item>RUBY_HORSE_ARMOR = createHonseArmorItem(7, "ruby_horse_armor");
    public static final RegistryObject<Item>POTESTIUM_HORSE_ARMOR = createHonseArmorItem(10, "potestium_horse_armor");
    public static final RegistryObject<Item>TOURMALINE_HORSE_ARMOR = createHonseArmorItem(8, "tourmaline_horse_armor");
    public static final RegistryObject<Item>NETHERITE_HORSE_ARMOR = createHonseArmorItem(8, "netherite_horse_armor");

    public static final RegistryObject<Item>RAW_LIROTHIAN_COBALT = createItem("raw_lirothian_cobalt");

    public static final RegistryObject<Item>LIROTHIAN_PETROLEUM = createItem("lirothian_petroleum");
    
    public static final RegistryObject<Item>LIROTH_SHIELD = createShieldItem("liroth_shield");
    public static final RegistryObject<Item>ANSALUM_LIROTH_SHIELD = createShieldItem("ansalum_liroth_shield");
    public static final RegistryObject<Item>LUX_LIROTH_SHIELD = createShieldItem("lux_liroth_shield");
    public static final RegistryObject<Item>SALEM_LIROTH_SHIELD = createShieldItem("salem_liroth_shield");
    public static final RegistryObject<Item>QUANTUM_LIROTH_SHIELD = createShieldItem("quantum_liroth_shield");
    
    public static final RegistryObject<Item>LIROTH_SOUL_DUST = createItem("liroth_soul_dust");
    
//    public static final RegistryObject<Item>LIROTH_STAR = createItem("liroth_star");

    public static final RegistryObject<Item>LIROTH_TEAR = createItem("liroth_tear");
        
    public static final RegistryObject<Item>PURPETUATED_AMETHYST_SHARD = createUnusedItem("purpetuated_amethyst_shard");
//    public static final RegistryObject<Item>PURPETUATED_SPYGLASS = createItem(new PurpetuatedSpyglassItem(new Item.Properties().group(LirothCreativeTab.creativeTab)), "purpetuated_spyglass");
    
    public static final RegistryObject<Item>QUANTUM_DIAMOND = createItem("quantum_diamond");
    
    public static final RegistryObject<Item>QUANTUM_PLATE = createItem("quantum_plate");
    public static final RegistryObject<Item>RUBY = createItem("ruby");
    public static final RegistryObject<Item>POTESTIUM_SHARD = createItem("potestium_shard");
    public static final RegistryObject<Item>POTESTIUM_PLATE = createItem("potestium_plate");
//    public static final RegistryObject<Item>SOUL_GLASS_BOTTLE = createItem("soul_glass_bottle");
    public static final RegistryObject<Item>SPINERIOS_STONE_PEBBLE = createItem("spinerios_stone_pebble");
    
    public static final RegistryObject<Item>TOURMALINE = createItem("tourmaline");
        
    public static final RegistryObject<Item>LIROTH_HELMET = createArmorItem(LirothArmorMaterials.LIROTH_ARMOR_MATERIAL, EquipmentSlot.HEAD, "liroth_helmet");
    public static final RegistryObject<Item>LIROTH_CHESTPLATE = createArmorItem(LirothArmorMaterials.LIROTH_ARMOR_MATERIAL, EquipmentSlot.CHEST, "liroth_chestplate");
    public static final RegistryObject<Item>LIROTH_LEGGINGS = createArmorItem(LirothArmorMaterials.LIROTH_ARMOR_MATERIAL, EquipmentSlot.LEGS, "liroth_leggings");
    public static final RegistryObject<Item>LIROTH_BOOTS = createArmorItem(LirothArmorMaterials.LIROTH_ARMOR_MATERIAL, EquipmentSlot.FEET, "liroth_boots");
    
    public static final RegistryObject<Item>LIROTHIAN_COBALT_HELMET = createArmorItem(LirothArmorMaterials.LIROTHIAN_COBALT_ARMOR_MATERIAL, EquipmentSlot.HEAD, "lirothian_cobalt_helmet");
    public static final RegistryObject<Item>LIROTHIAN_COBALT_CHESTPLATE = createArmorItem(LirothArmorMaterials.LIROTHIAN_COBALT_ARMOR_MATERIAL, EquipmentSlot.CHEST, "lirothian_cobalt_chestplate");
    public static final RegistryObject<Item>LIROTHIAN_COBALT_LEGGINGS = createArmorItem(LirothArmorMaterials.LIROTHIAN_COBALT_ARMOR_MATERIAL, EquipmentSlot.LEGS, "lirothian_cobalt_leggings");
    public static final RegistryObject<Item>LIROTHIAN_COBALT_BOOTS = createArmorItem(LirothArmorMaterials.LIROTHIAN_COBALT_ARMOR_MATERIAL, EquipmentSlot.FEET, "lirothian_cobalt_boots");
    
    public static final RegistryObject<Item>ANSALUM_LIROTH_HELMET = createArmorItem(LirothArmorMaterials.ANSALUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.HEAD, "ansalum_liroth_helmet");
    public static final RegistryObject<Item>ANSALUM_LIROTH_CHESTPLATE = createArmorItem(LirothArmorMaterials.ANSALUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.CHEST, "ansalum_liroth_chestplate");
    public static final RegistryObject<Item>ANSALUM_LIROTH_LEGGINGS = createArmorItem(LirothArmorMaterials.ANSALUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.LEGS, "ansalum_liroth_leggings");
    public static final RegistryObject<Item>ANSALUM_LIROTH_BOOTS = createArmorItem(LirothArmorMaterials.ANSALUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.FEET, "ansalum_liroth_boots");
    
    public static final RegistryObject<Item>ANSALUM_LIROTH_AXE = createAxeItem(LirothToolMaterials.ANSALUM_LIROTH_TOOL_MATERIAL, 7.0f, -3.0f, "ansalum_liroth_axe");
    public static final RegistryObject<Item>LUX_LIROTH_KATANA = createSwordItem(LirothToolMaterials.LUX_LIROTH_TOOL_MATERIAL, 2, -1.4f, "lux_liroth_katana");
    public static final RegistryObject<Item>SALEM_LIROTH_FALCHION = createSwordItem(LirothToolMaterials.SALEM_LIROTH_TOOL_MATERIAL, 4, -2.4f, "salem_liroth_falchion");
    
    public static final RegistryObject<Item>QUANTUM_LIROTH_SWORD = createSwordItem(LirothToolMaterials.QUANTUM_LIROTH_TOOL_MATERIAL, 4, -2.4f, "quantum_liroth_sword");
    public static final RegistryObject<Item>QUANTUM_LIROTH_SHOVEL = createShovelItem(LirothToolMaterials.QUANTUM_LIROTH_TOOL_MATERIAL, 1.5f, -3.0f, "quantum_liroth_shovel");
    public static final RegistryObject<Item>QUANTUM_LIROTH_PICKAXE = createPickaxeItem(LirothToolMaterials.QUANTUM_LIROTH_TOOL_MATERIAL, 1, -2.8f, "quantum_liroth_pickaxe");
    public static final RegistryObject<Item>QUANTUM_LIROTH_AXE = createAxeItem(LirothToolMaterials.QUANTUM_LIROTH_TOOL_MATERIAL, 5.0f, -3.0f, "quantum_liroth_axe");
    public static final RegistryObject<Item>QUANTUM_LIROTH_HOE = createHoeItem(LirothToolMaterials.QUANTUM_LIROTH_TOOL_MATERIAL, -4, 0.0f, "quantum_liroth_hoe");
    
    public static final RegistryObject<Item>LUX_LIROTH_HELMET = createArmorItem(LirothArmorMaterials.LUX_LIROTH_ARMOR_MATERIAL, EquipmentSlot.HEAD, "lux_liroth_helmet");
    public static final RegistryObject<Item>LUX_LIROTH_CHESTPLATE = createArmorItem(LirothArmorMaterials.LUX_LIROTH_ARMOR_MATERIAL, EquipmentSlot.CHEST, "lux_liroth_chestplate");
    public static final RegistryObject<Item>LUX_LIROTH_LEGGINGS = createArmorItem(LirothArmorMaterials.LUX_LIROTH_ARMOR_MATERIAL, EquipmentSlot.LEGS, "lux_liroth_leggings");
    public static final RegistryObject<Item>LUX_LIROTH_BOOTS = createArmorItem(LirothArmorMaterials.LUX_LIROTH_ARMOR_MATERIAL, EquipmentSlot.FEET, "lux_liroth_boots");
    
    public static final RegistryObject<Item>SALEM_LIROTH_HELMET = createArmorItem(LirothArmorMaterials.SALEM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.HEAD, "salem_liroth_helmet");
    public static final RegistryObject<Item>SALEM_LIROTH_CHESTPLATE = createArmorItem(LirothArmorMaterials.SALEM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.CHEST, "salem_liroth_chestplate");
    public static final RegistryObject<Item>SALEM_LIROTH_LEGGINGS = createArmorItem(LirothArmorMaterials.SALEM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.LEGS, "salem_liroth_leggings");
    public static final RegistryObject<Item>SALEM_LIROTH_BOOTS = createArmorItem(LirothArmorMaterials.SALEM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.FEET, "salem_liroth_boots");
    
    public static final RegistryObject<Item>QUANTUM_LIROTH_HELMET = createArmorItem(LirothArmorMaterials.QUANTUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.HEAD, "quantum_liroth_helmet");
    public static final RegistryObject<Item>QUANTUM_LIROTH_CHESTPLATE = createArmorItem(LirothArmorMaterials.QUANTUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.CHEST, "quantum_liroth_chestplate");
    public static final RegistryObject<Item>QUANTUM_LIROTH_LEGGINGS = createArmorItem(LirothArmorMaterials.QUANTUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.LEGS, "quantum_liroth_leggings");
    public static final RegistryObject<Item>QUANTUM_LIROTH_BOOTS = createArmorItem(LirothArmorMaterials.QUANTUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.FEET, "quantum_liroth_boots");
    
    public static final RegistryObject<Item>POTESTIUM_LIROTH_HELMET = createPotestiumHelmetItem(LirothArmorMaterials.POTESTIUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.HEAD, "potestium_liroth_helmet");
    public static final RegistryObject<Item>POTESTIUM_LIROTH_CHESTPLATE = createArmorItem(LirothArmorMaterials.POTESTIUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.CHEST, "potestium_liroth_chestplate");
    public static final RegistryObject<Item>POTESTIUM_LIROTH_LEGGINGS = createArmorItem(LirothArmorMaterials.POTESTIUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.LEGS, "potestium_liroth_leggings");
    public static final RegistryObject<Item>POTESTIUM_LIROTH_BOOTS = createArmorItem(LirothArmorMaterials.POTESTIUM_LIROTH_ARMOR_MATERIAL, EquipmentSlot.FEET, "potestium_liroth_boots");

    public static final RegistryObject<Item>RUBY_HELMET = createArmorItem(LirothArmorMaterials.RUBY_ARMOR_MATERIAL, EquipmentSlot.HEAD, "ruby_helmet");
    public static final RegistryObject<Item>RUBY_CHESTPLATE = createArmorItem(LirothArmorMaterials.RUBY_ARMOR_MATERIAL, EquipmentSlot.CHEST, "ruby_chestplate");
    public static final RegistryObject<Item>RUBY_LEGGINGS = createArmorItem(LirothArmorMaterials.RUBY_ARMOR_MATERIAL, EquipmentSlot.LEGS, "ruby_leggings");
    public static final RegistryObject<Item>RUBY_BOOTS = createArmorItem(LirothArmorMaterials.RUBY_ARMOR_MATERIAL, EquipmentSlot.FEET, "ruby_boots");
    
    public static final RegistryObject<Item>POTESTIUM_SCYTHE = createHoeItem(LirothToolMaterials.POTESTIUM_LIROTH_TOOL_MATERIAL, 3, 0.0f, "potestium_scythe");
    
    public static final RegistryObject<Item>LIROTH_SWORD = createSwordItem(LirothToolMaterials.LIROTH_TOOL_MATERIAL, 3, -2.4f, "liroth_sword");
    public static final RegistryObject<Item>LIROTH_SHOVEL = createShovelItem(LirothToolMaterials.LIROTH_TOOL_MATERIAL, 1.5f, -3.0f, "liroth_shovel");
    public static final RegistryObject<Item>LIROTH_PICKAXE = createPickaxeItem(LirothToolMaterials.LIROTH_TOOL_MATERIAL, 1, -2.8f, "liroth_pickaxe");
    public static final RegistryObject<Item>LIROTH_AXE = createAxeItem(LirothToolMaterials.LIROTH_TOOL_MATERIAL, 5.0f, -3.0f, "liroth_axe");
    public static final RegistryObject<Item>LIROTH_HOE = createHoeItem(LirothToolMaterials.LIROTH_TOOL_MATERIAL, -4, 0.0f, "liroth_hoe");
    
    public static final RegistryObject<Item>LIROTHIAN_COBALT_SWORD = createSwordItem(LirothToolMaterials.LIROTHIAN_COBALT_TOOL_MATERIAL, 3, -2.4f, "lirothian_cobalt_sword");
    public static final RegistryObject<Item>LIROTHIAN_COBALT_SHOVEL = createShovelItem(LirothToolMaterials.LIROTHIAN_COBALT_TOOL_MATERIAL, 1.5f, -3.0f, "lirothian_cobalt_shovel");
    public static final RegistryObject<Item>LIROTHIAN_COBALT_PICKAXE = createPickaxeItem(LirothToolMaterials.LIROTHIAN_COBALT_TOOL_MATERIAL, 1, -2.8f, "lirothian_cobalt_pickaxe");
    public static final RegistryObject<Item>LIROTHIAN_COBALT_AXE = createAxeItem(LirothToolMaterials.LIROTHIAN_COBALT_TOOL_MATERIAL, 5.0f, -3.0f, "lirothian_cobalt_axe");
    public static final RegistryObject<Item>LIROTHIAN_COBALT_HOE = createHoeItem(LirothToolMaterials.LIROTHIAN_COBALT_TOOL_MATERIAL, -4, 0.0f, "lirothian_cobalt_hoe");
    
    public static final RegistryObject<Item>TOURMALINE_HELMET = createArmorItem(LirothArmorMaterials.TOURMALINE_ARMOR_MATERIAL, EquipmentSlot.HEAD, "tourmaline_helmet");
    public static final RegistryObject<Item>TOURMALINE_CHESTPLATE = createArmorItem(LirothArmorMaterials.TOURMALINE_ARMOR_MATERIAL, EquipmentSlot.CHEST, "tourmaline_chestplate");
    public static final RegistryObject<Item>TOURMALINE_LEGGINGS = createArmorItem(LirothArmorMaterials.TOURMALINE_ARMOR_MATERIAL, EquipmentSlot.LEGS, "tourmaline_leggings");
    public static final RegistryObject<Item>TOURMALINE_BOOTS = createArmorItem(LirothArmorMaterials.TOURMALINE_ARMOR_MATERIAL, EquipmentSlot.FEET, "tourmaline_boots");
    
    public static final RegistryObject<Item>TOURMALINE_SWORD = createSwordItem(LirothToolMaterials.TOURMALINE_TOOL_MATERIAL, 3, -2.4f, "tourmaline_sword");
    public static final RegistryObject<Item>TOURMALINE_SHOVEL = createShovelItem(LirothToolMaterials.TOURMALINE_TOOL_MATERIAL, 1.5f, -3.0f, "tourmaline_shovel");
    public static final RegistryObject<Item>TOURMALINE_PICKAXE = createPickaxeItem(LirothToolMaterials.TOURMALINE_TOOL_MATERIAL, 1, -2.8f, "tourmaline_pickaxe");
    public static final RegistryObject<Item>TOURMALINE_AXE = createAxeItem(LirothToolMaterials.TOURMALINE_TOOL_MATERIAL, 5.0f, -3.0f, "tourmaline_axe");
    public static final RegistryObject<Item>TOURMALINE_HOE = createHoeItem(LirothToolMaterials.TOURMALINE_TOOL_MATERIAL, -4, 0.0f, "tourmaline_hoe");
    
    public static final RegistryObject<Item>RUBY_SWORD = createSwordItem(LirothToolMaterials.RUBY_TOOL_MATERIAL, 3, -2.4f, "ruby_sword");
    public static final RegistryObject<Item>RUBY_SHOVEL = createShovelItem(LirothToolMaterials.RUBY_TOOL_MATERIAL, 1.5f, -3.0f, "ruby_shovel");
    public static final RegistryObject<Item>RUBY_PICKAXE = createPickaxeItem(LirothToolMaterials.RUBY_TOOL_MATERIAL, 1, -2.8f, "ruby_pickaxe");
    public static final RegistryObject<Item>RUBY_AXE = createAxeItem(LirothToolMaterials.RUBY_TOOL_MATERIAL, 5.0f, -3.0f, "ruby_axe");
    public static final RegistryObject<Item>RUBY_HOE = createHoeItem(LirothToolMaterials.RUBY_TOOL_MATERIAL, -4, 0.0f, "ruby_hoe");
    
    public static final RegistryObject<Item> FUNGAL_FIEND_SPAWN_EGG = ITEMS.register("fungal_fiend_spawn_egg", () -> new ForgeSpawnEggItem(LirothEntities.FUNGAL_FIEND, 1315860, 2031360, new Item.Properties()));
    public static final RegistryObject<Item> FORSAKEN_CORPSE_SPAWN_EGG = ITEMS.register("forsaken_corpse_spawn_egg", () -> new ForgeSpawnEggItem(LirothEntities.FORSAKEN_CORPSE, 1842204, 10551525, new Item.Properties()));
    public static final RegistryObject<Item> SKELETAL_FREAK_SPAWN_EGG = ITEMS.register("skeletal_freak_spawn_egg", () -> new ForgeSpawnEggItem(LirothEntities.SKELETAL_FREAK, 1513239, 16711900, new Item.Properties()));
    public static final RegistryObject<Item> WARP_SPAWN_EGG = ITEMS.register("warp_spawn_egg", () -> new ForgeSpawnEggItem(LirothEntities.WARP, 524305, 4260003, new Item.Properties()));
    public static final RegistryObject<Item> SOUL_ARACHNID_SPAWN_EGG = ITEMS.register("soul_arachnid_spawn_egg", () -> new ForgeSpawnEggItem(LirothEntities.SOUL_ARACHNID, 73758, 5078138, new Item.Properties()));
    public static final RegistryObject<Item> PIER_PEEP_SPAWN_EGG = ITEMS.register("pier_peep_spawn_egg", () -> new ForgeSpawnEggItem(LirothEntities.PIER_PEEP, 1638400, 11665663, new Item.Properties()));
    public static final RegistryObject<Item> SHADE_SPAWN_EGG = ITEMS.register("shade_spawn_egg", () -> new ForgeSpawnEggItem(LirothEntities.SHADE, 328965, 1579032, new Item.Properties()));
    public static final RegistryObject<Item> PROWLER_SPAWN_EGG = ITEMS.register("prowler_spawn_egg", () -> new ForgeSpawnEggItem(LirothEntities.PROWLER, 16312063, 4260003, new Item.Properties()));
    public static final RegistryObject<Item> FREAKSHOW_SPAWN_EGG = ITEMS.register("freakshow_spawn_egg", () -> new ForgeSpawnEggItem(LirothEntities.FREAKSHOW, 524305, 1579032, new Item.Properties()));
    public static final RegistryObject<Item> VILE_SHARK_SPAWN_EGG = ITEMS.register("vile_shark_spawn_egg", () -> new ForgeSpawnEggItem(LirothEntities.VILE_SHARK, 5963996, 7667865, new Item.Properties()));
    public static final RegistryObject<Item> LIROTHIAN_MIMIC_SPAWN_EGG = ITEMS.register("lirothian_mimic_spawn_egg", () -> new ForgeSpawnEggItem(LirothEntities.LIROTHIAN_MIMIC, 41655, 10551525, new Item.Properties()));

    public static final RegistryObject<Item> UNUSED_SPAWN_EGG = ITEMS.register("unused_forsaken_corpse_spawn_egg", () -> new ForgeSpawnEggItem(LirothEntities.FORSAKEN_CORPSE, 1842204, 10551525, new Item.Properties()));
    
	public static final RegistryObject<Item> LIROTH_FLUID_BUCKET = ITEMS.register("liroth_fluid_bucket", () -> new BucketItem(LirothFluids.LIROTH_FLUID, new Item.Properties()));
	public static final RegistryObject<Item> MOLTEN_SPINERIOS_BUCKET = ITEMS.register("molten_spinerios_bucket", () -> new BucketItem(LirothFluids.MOLTEN_SPINERIOS, new Item.Properties()));
	
    static RegistryObject<Item> createItem(String id) {
		RegistryObject<Item> createItem = ITEMS.register(id, () -> new Item(new Item.Properties()));
		ITEMS_FOR_TAB_LIST.add(createItem);
		return createItem;    
    }
    
    static RegistryObject<Item> createUnusedItem(String id) {
		RegistryObject<Item> createItem = ITEMS.register(id, () -> new UnusedItem(new Item.Properties()));
		ITEMS_FOR_TAB_LIST.add(createItem);
		return createItem;    
    }
    
    private static RegistryObject<AnomalyChargeItem> createAnomalyChargeItem(String id) {
		RegistryObject<AnomalyChargeItem> createItem = ITEMS.register(id, () -> new AnomalyChargeItem());
        return createItem;    
	}
    
    private static RegistryObject<DamnationChargeItem> createDamnationChargeItem(String id) {
		RegistryObject<DamnationChargeItem> createItem = ITEMS.register(id, () -> new DamnationChargeItem());
        return createItem;    
	}
    
    private static RegistryObject<JalsphireIgnitorItem> createJalpshireChargeItem(String id) {
		RegistryObject<JalsphireIgnitorItem> createItem = ITEMS.register(id, () -> new JalsphireIgnitorItem());
        return createItem;    
	}
    
    private static RegistryObject<JantiroChargeItem> createJantiroChargeItem(String id) {
		RegistryObject<JantiroChargeItem> createItem = ITEMS.register(id, () -> new JantiroChargeItem());
        return createItem;    
	}
    
    private static RegistryObject<LirothChargeItem> createLirothChargeItem(String id) {
		RegistryObject<LirothChargeItem> createItem = ITEMS.register(id, () -> new LirothChargeItem());
		return createItem;    
	}

	static RegistryObject<Item> createKeyItem(String id) {
		RegistryObject<Item> createItem = ITEMS.register(id, () -> new KeyItem(new Item.Properties()));
		ITEMS_FOR_TAB_LIST.add(createItem);
		return createItem;    
    }
    
    static RegistryObject<Item> createSpawnEggItem(String id) {
		RegistryObject<Item> createItem = ITEMS.register(id, () -> new Item(new Item.Properties()));
		SPAWN_EGG_ITEMS_FOR_TAB_LIST.add(createItem);
		return createItem;    
    }
    
    static RegistryObject<Item> createBeamItem(String id) {
		RegistryObject<Item> createItem = ITEMS.register(id, () -> new BeamItem(new Item.Properties()));
		ITEMS_FOR_TAB_LIST.add(createItem);
		return createItem;    
    }
    
    static RegistryObject<Item> createRangedItem(String id) {
		RegistryObject<Item> createItem = ITEMS.register(id, () -> new LirothBlaster(new Item.Properties()));
		COMBAT_ITEMS_FOR_TAB_LIST.add(createItem);
		return createItem;    
    }
    
    static RegistryObject<Item> createSwordItem(Tier tier, int damage, float speed, String id) {
		RegistryObject<Item> createItem = ITEMS.register(id, () -> new SwordItem(tier, damage, speed, new Item.Properties()));
		COMBAT_ITEMS_FOR_TAB_LIST.add(createItem);
		return createItem;  
  	}
    
    static RegistryObject<Item> createAxeItem(Tier tier, float damage, float speed, String id) {
		RegistryObject<Item> createItem = ITEMS.register(id, () -> new AxeItem(tier, damage, speed, new Item.Properties()));
		COMBAT_ITEMS_FOR_TAB_LIST.add(createItem);
		return createItem;  
  	}
    
    static RegistryObject<Item> createPickaxeItem(Tier tier, int damage, float speed, String id) {
		RegistryObject<Item> createItem = ITEMS.register(id, () -> new PickaxeItem(tier, damage, speed, new Item.Properties()));
		COMBAT_ITEMS_FOR_TAB_LIST.add(createItem);
		return createItem;  
  	}
    
    static RegistryObject<Item> createShovelItem(Tier tier, float damage, float speed, String id) {
		RegistryObject<Item> createItem = ITEMS.register(id, () -> new ShovelItem(tier, damage, speed, new Item.Properties()));
		COMBAT_ITEMS_FOR_TAB_LIST.add(createItem);
		return createItem;  
  	}
    
    static RegistryObject<Item> createHoeItem(Tier tier, int damage, float speed, String id) {
		RegistryObject<Item> createItem = ITEMS.register(id, () -> new HoeItem(tier, damage, speed, new Item.Properties()));
		COMBAT_ITEMS_FOR_TAB_LIST.add(createItem);
		return createItem;  
  	}
    
    static RegistryObject<Item> createArmorItem(ArmorMaterial tier, EquipmentSlot slot, String id) {
		RegistryObject<Item> createItem = ITEMS.register(id, () -> new ArmorItem(tier, slot, new Item.Properties()));
		COMBAT_ITEMS_FOR_TAB_LIST.add(createItem);
		return createItem;  
  	}
    
    static RegistryObject<Item> createPotestiumHelmetItem(ArmorMaterial tier, EquipmentSlot slot, String id) {
		RegistryObject<Item> createItem = ITEMS.register(id, () -> new PotestiumHelmetItem(tier, slot, new Item.Properties()));
		COMBAT_ITEMS_FOR_TAB_LIST.add(createItem);
		return createItem;  
  	}
    
    static RegistryObject<Item> createShieldItem(String id) {
		RegistryObject<Item> createItem = ITEMS.register(id, () -> new ShieldItem(new Item.Properties()));
		COMBAT_ITEMS_FOR_TAB_LIST.add(createItem);
		return createItem;    
    }
    
    static RegistryObject<Item> createBoatItem(String id, LirothBoat.LirothType type) {
		RegistryObject<Item> createItem = ITEMS.register(id, () -> new LirothBoatItem(false, type, new Item.Properties()));
		ITEMS_FOR_TAB_LIST.add(createItem);
		return createItem;    
    }
    
    static RegistryObject<Item> createChestBoatItem(String id, LirothBoat.LirothType type) {
		RegistryObject<Item> createItem = ITEMS.register(id, () -> new LirothBoatItem(true, type, new Item.Properties()));
		ITEMS_FOR_TAB_LIST.add(createItem);
		return createItem;    
    }
    
    static RegistryObject<Item> createHonseArmorItem(int strength, String id) {
		RegistryObject<Item> createItem = ITEMS.register(id, () -> new HorseArmorItem(strength, id, new Item.Properties()));
		COMBAT_ITEMS_FOR_TAB_LIST.add(createItem);
		return createItem;    
    }
    
    static RegistryObject<Item> createFoodItem(String id, FoodProperties food) {
		RegistryObject<Item> createItem = ITEMS.register(id, () -> new Item(new Item.Properties().food(food)));
		ITEMS_FOR_TAB_LIST.add(createItem);
		return createItem;    
    }

	public static void init() {
		
	}
}