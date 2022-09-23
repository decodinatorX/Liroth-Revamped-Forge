package com.decodinator.liroth.core;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.entities.ForsakenCorpseEntity;
import com.decodinator.liroth.core.entities.FreakshowEntity;
import com.decodinator.liroth.core.entities.FungalFiendEntity;
import com.decodinator.liroth.core.entities.LirothianMimicEntity;
import com.decodinator.liroth.core.entities.PierPeepEntity;
import com.decodinator.liroth.core.entities.ProwlerEntity;
import com.decodinator.liroth.core.entities.ShadeEntity;
import com.decodinator.liroth.core.entities.SkeletalFreakEntity;
import com.decodinator.liroth.core.entities.SoulArachnidEntity;
import com.decodinator.liroth.core.entities.VileSharkEntity;
import com.decodinator.liroth.core.entities.WarpEntity;
import com.decodinator.liroth.core.entities.projectiles.BeamLaserProjectileEntity;
import com.decodinator.liroth.core.items.BeamItem;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType.Builder;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class LirothEntities {

	public static final DeferredRegister<EntityType<?>> ENTITIES_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Liroth.MOD_ID);

	public static final RegistryObject<EntityType<LirothBoat>> LIROTH_BOAT = ENTITIES_TYPES.register("liroth_boat", () -> EntityType.Builder.<LirothBoat>of(LirothBoat::new, MobCategory.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10).build(new ResourceLocation(Liroth.MOD_ID, "liroth_boat").toString()));
	public static final RegistryObject<EntityType<LirothBoat>> LIROTH_CHEST_BOAT = ENTITIES_TYPES.register("liroth_chest_boat", () -> EntityType.Builder.<LirothBoat>of(LirothBoat::new, MobCategory.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10).build(new ResourceLocation(Liroth.MOD_ID, "liroth_boat").toString()));

	public static final RegistryObject<EntityType<BeamLaserProjectileEntity>> BEAM_LASER_PROJECTILE = ENTITIES_TYPES.register("beam_laser_projectile_entity", () -> EntityType.Builder.<BeamLaserProjectileEntity>of(BeamLaserProjectileEntity::new, MobCategory.MISC).sized(0.25F, 0.25F).clientTrackingRange(4).updateInterval(10).build(new ResourceLocation(Liroth.MOD_ID, "beam_laser_projectile_entity").toString()));
	public static AbstractArrow createBeamProjectile(LivingEntity p_37301_, ItemStack p_37302_, float p_37303_) {
			  BeamItem arrowitem = (BeamItem)(p_37302_.getItem() instanceof BeamItem ? p_37302_.getItem() : LirothItems.COOL_BEAM.get());
		      AbstractArrow abstractarrow = arrowitem.createBeam(p_37301_.level, p_37302_, p_37301_);
		      abstractarrow.setEnchantmentEffectsFromEntity(p_37301_, p_37303_);
		      return abstractarrow;
		   }
	
	public static final RegistryObject<EntityType<FungalFiendEntity>> FUNGAL_FIEND = ENTITIES_TYPES.register("fungal_fiend", () -> EntityType.Builder.<FungalFiendEntity>of(FungalFiendEntity::new, MobCategory.MONSTER).sized(0.6f, 2f).build(new ResourceLocation(Liroth.MOD_ID, "fungal_fiend").toString()));
	public static final RegistryObject<EntityType<ForsakenCorpseEntity>> FORSAKEN_CORPSE = ENTITIES_TYPES.register("forsaken_corpse", () -> EntityType.Builder.<ForsakenCorpseEntity>of(ForsakenCorpseEntity::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(Liroth.MOD_ID, "forsaken_corpse").toString()));
	public static final RegistryObject<EntityType<SkeletalFreakEntity>> SKELETAL_FREAK = ENTITIES_TYPES.register("skeletal_freak", () -> EntityType.Builder.<SkeletalFreakEntity>of(SkeletalFreakEntity::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(Liroth.MOD_ID, "skeletal_freak").toString()));
	public static final RegistryObject<EntityType<WarpEntity>> WARP = ENTITIES_TYPES.register("warp", () -> EntityType.Builder.<WarpEntity>of(WarpEntity::new, MobCategory.MONSTER).sized(0.6f, 2.9f).build(new ResourceLocation(Liroth.MOD_ID, "warp").toString()));
	public static final RegistryObject<EntityType<SoulArachnidEntity>> SOUL_ARACHNID = ENTITIES_TYPES.register("soul_arachnid", () -> EntityType.Builder.<SoulArachnidEntity>of(SoulArachnidEntity::new, MobCategory.MONSTER).sized(0.6f, 2.9f).build(new ResourceLocation(Liroth.MOD_ID, "soul_arachnid").toString()));
	public static final RegistryObject<EntityType<PierPeepEntity>> PIER_PEEP = ENTITIES_TYPES.register("pier_peep", () -> EntityType.Builder.<PierPeepEntity>of(PierPeepEntity::new, MobCategory.MONSTER).sized(0.6f, 2.9f).build(new ResourceLocation(Liroth.MOD_ID, "pier_peep").toString()));
	public static final RegistryObject<EntityType<ShadeEntity>> SHADE = ENTITIES_TYPES.register("shade", () -> EntityType.Builder.<ShadeEntity>of(ShadeEntity::new, MobCategory.MONSTER).sized(0.6f, 1.95f).build(new ResourceLocation(Liroth.MOD_ID, "shade").toString()));
	public static final RegistryObject<EntityType<ProwlerEntity>> PROWLER = ENTITIES_TYPES.register("prowler", () -> EntityType.Builder.<ProwlerEntity>of(ProwlerEntity::new, MobCategory.MONSTER).sized(0.6f, 2.9f).build(new ResourceLocation(Liroth.MOD_ID, "prowler").toString()));
	public static final RegistryObject<EntityType<FreakshowEntity>> FREAKSHOW = ENTITIES_TYPES.register("freakshow", () -> EntityType.Builder.<FreakshowEntity>of(FreakshowEntity::new, MobCategory.MONSTER).sized(0.6f, 2.9f).build(new ResourceLocation(Liroth.MOD_ID, "freakshow").toString()));
	public static final RegistryObject<EntityType<VileSharkEntity>> VILE_SHARK = ENTITIES_TYPES.register("vile_shark", () -> EntityType.Builder.<VileSharkEntity>of(VileSharkEntity::new, MobCategory.MONSTER).sized(0.6f, 2.9f).build(new ResourceLocation(Liroth.MOD_ID, "vile_shark").toString()));
	public static final RegistryObject<EntityType<LirothianMimicEntity>> LIROTHIAN_MIMIC = ENTITIES_TYPES.register("lirothian_mimic", () -> EntityType.Builder.<LirothianMimicEntity>of(LirothianMimicEntity::new, MobCategory.MONSTER).sized(0.6f, 2.9f).build(new ResourceLocation(Liroth.MOD_ID, "lirothian_mimic").toString()));

}
