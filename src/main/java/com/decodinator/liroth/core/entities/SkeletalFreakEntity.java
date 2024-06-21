package com.decodinator.liroth.core.entities;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.LirothEntities;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.core.animation.RawAnimation;

public class SkeletalFreakEntity extends Skeleton implements GeoAnimatable {
    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);

	public SkeletalFreakEntity(EntityType<? extends Skeleton> entityType, Level world) {
		super(entityType, world);
	}

    public static AttributeSupplier.Builder createSkeletalFreakAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MOVEMENT_SPEED, 0.25);
    }
	
    @Override
    public void performRangedAttack(LivingEntity target, float pullProgress) {
        ItemStack itemStack = this.getProjectile(this.getItemInHand(ProjectileUtil.getWeaponHoldingHand(this, Items.BOW)));
        AbstractArrow persistentProjectileEntity = this.createBeamProjectile(itemStack, pullProgress);
        double d = target.getX() - this.getX();
        double e = target.getY(0.3333333333333333) - persistentProjectileEntity.getY();
        double f = target.getZ() - this.getZ();
        double g = Math.sqrt(d * d + f * f);
        persistentProjectileEntity.shoot(d, e + g * (double)0.2f, f, 1.6f, 14 - this.level().getDifficulty().getId() * 4);
        this.playSound(SoundEvents.SKELETON_SHOOT, 1.0f, 1.0f / (this.getRandom().nextFloat() * 0.4f + 0.8f));
        this.level().addFreshEntity(persistentProjectileEntity);
    }

    protected AbstractArrow createBeamProjectile(ItemStack arrow, float damageModifier) {
        return LirothEntities.createBeamProjectile(this, arrow, damageModifier);
    }
    
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.STRAY_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.STRAY_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.STRAY_DEATH;
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.WITHER_SKELETON_STEP;
    }

    private static final RawAnimation SKELETAL_WALK = RawAnimation.begin().thenPlay("skeletal_walk");
    private static final RawAnimation SKELETAL_IDLE = RawAnimation.begin().thenPlay("skeletal_idle");

    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
        if (!(swingTime > -0.15F && swingTime < 0.15F)) {
            event.getController().setAnimation(SKELETAL_WALK);
            return PlayState.CONTINUE;
        }

        if (event.isMoving()) {
            event.getController().setAnimation(SKELETAL_WALK);
            return PlayState.CONTINUE;
        }

        event.getController().setAnimation(SKELETAL_IDLE);
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar data) {
        data.add(new AnimationController<SkeletalFreakEntity>(this, "controller", 0, this::predicate));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.factory;
    }

    @Override
    public double getTick(Object age) {
        return ((Entity)age).tickCount;
    }
}
