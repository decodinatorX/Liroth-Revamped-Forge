package com.decodinator.liroth.core.entities.projectiles;

import com.decodinator.liroth.core.LirothEntities;
import com.decodinator.liroth.core.LirothItems;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

public class BeamLaserProjectileEntity extends AbstractArrow {
	   private static final EntityDataAccessor<Integer> ID_EFFECT_COLOR = SynchedEntityData.defineId(Arrow.class, EntityDataSerializers.INT);
	
	public BeamLaserProjectileEntity(EntityType<? extends AbstractArrow> entityType, Level world) {
		super(entityType, world);
		
	}
 
	public BeamLaserProjectileEntity(Level world, LivingEntity owner) {
		super(LirothEntities.BEAM_LASER_PROJECTILE.get(), owner, world);
	}
 
	public BeamLaserProjectileEntity(Level world, double x, double y, double z) {
		super(LirothEntities.BEAM_LASER_PROJECTILE.get(), x, y, z, world);
	}
 
    public int getColor() {
        return this.entityData.get(ID_EFFECT_COLOR);
    }
 
	protected void onHitEntity(EntityHitResult entityHitResult) { // called on entity hit.
		super.onHitEntity(entityHitResult);
		Entity entity = entityHitResult.getEntity(); // sets a new Entity instance as the EntityHitResult (victim)
		int i = entity instanceof Blaze ? 3 : 0; // sets i to 3 if the Entity instance is an instance of BlazeEntity
		entity.hurt(DamageSource.thrown(this, this.getOwner()), (float)i); // deals damage
 
		if (entity instanceof LivingEntity livingEntity) { // checks if entity is an instance of LivingEntity (meaning it is not a boat or minecart)
			livingEntity.addEffect((new MobEffectInstance(MobEffects.BLINDNESS, 20 * 3, 0))); // applies a status effect
			livingEntity.playSound(SoundEvents.AMBIENT_CAVE.get(), 2F, 1F); // plays a sound for the entity hit only
		}
	}
 
	protected void onHitBlock(BlockHitResult hitResult) { // called on collision with a block
		super.onHitBlock(hitResult);
		if (!this.level.isClientSide) { // checks if the world is client
			this.level.broadcastEntityEvent(this, (byte)3); // particle?
		}
 
	}

	@Override
	protected ItemStack getPickupItem() {
		return null;
	}
    
    public void initFromStack(ItemStack stack) {
    	if (stack.is(LirothItems.COOL_BEAM.get())) {
        }
    }


    public void setEffectsFromItem(ItemStack p_36879_) {
    	if (p_36879_.is(Items.ARROW)) {
          this.entityData.set(ID_EFFECT_COLOR, -1);
    	}
    }
}