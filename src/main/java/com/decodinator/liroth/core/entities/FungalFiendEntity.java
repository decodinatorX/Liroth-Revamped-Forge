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
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

public class FungalFiendEntity extends Creeper implements IAnimatable {
    private AnimationFactory factory = GeckoLibUtil.createFactory(this);

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

    private static final AnimationBuilder FUNGAL_WALK = new AnimationBuilder().addAnimation("fungal_walk");
    private static final AnimationBuilder FUNGAL_IDLE = new AnimationBuilder().addAnimation("fungal_idle");

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
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
    public void registerControllers(final AnimationData data) {
        data.addAnimationController(new AnimationController<FungalFiendEntity>(this, "controller", 0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

}
