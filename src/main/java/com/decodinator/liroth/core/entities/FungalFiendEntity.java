package com.decodinator.liroth.core.entities;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.LirothSounds;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class FungalFiendEntity extends Creeper implements GeoAnimatable {
    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);

	public FungalFiendEntity(EntityType<? extends Creeper> entityType, Level world) {
		super(entityType, world);
		this.xpReward = 20;
	}

	public static AttributeSupplier.Builder createFungalFiendAttributes() {
		return Monster.createMonsterAttributes()
				.add(Attributes.MOVEMENT_SPEED, 0.25D);
	}
	
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return LirothSounds.FUNGAL_FIEND_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return LirothSounds.FUNGAL_FIEND_DEATH.get();
    }

    private static final RawAnimation FUNGAL_WALK = RawAnimation.begin().thenPlay("fungal_walk");
    private static final RawAnimation FUNGAL_IDLE = RawAnimation.begin().thenPlay("fungal_idle");

    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
        if (!(swingTime > -0.15F && swingTime < 0.15F)) {
            event.getController().setAnimation(FUNGAL_WALK);
            return PlayState.CONTINUE;
        }

        if (event.isMoving()) {
            event.getController().setAnimation(FUNGAL_WALK);
            return PlayState.CONTINUE;
        }

        event.getController().setAnimation(FUNGAL_IDLE);
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar data) {
        data.add(new AnimationController<FungalFiendEntity>(this, "controller", 0, this::predicate));
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
