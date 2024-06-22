package com.decodinator.liroth.core.entities;

import com.decodinator.liroth.Liroth;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.Level;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

public class ForsakenCorpseEntity extends Zombie implements IAnimatable {
    private AnimationFactory factory = GeckoLibUtil.createFactory(this);

	public ForsakenCorpseEntity(EntityType<? extends Zombie> entityType, Level world) {
		super(entityType, world);
		this.xpReward = 20;
	}

    public static AttributeSupplier.Builder createForsakenCorpseAttributes() {
        return Monster.createMonsterAttributes()
        		.add(Attributes.FOLLOW_RANGE, 35.0)
        		.add(Attributes.MOVEMENT_SPEED, 0.23f)
        		.add(Attributes.ATTACK_DAMAGE, 6.0)
        		.add(Attributes.ARMOR, 4.0)
        		.add(Attributes.SPAWN_REINFORCEMENTS_CHANCE);
    }

    @Override
    protected boolean convertsInWater() {
        return false;
     }
    

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.DROWNED_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.DROWNED_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.DROWNED_DEATH;
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.DROWNED_STEP;
    }
    private static final AnimationBuilder CORPSE_WALK = new AnimationBuilder().addAnimation("corpse_walk");
    private static final AnimationBuilder CORPSE_CHASE = new AnimationBuilder().addAnimation("corpse_chase");
    private static final AnimationBuilder CORPSE_IDLE = new AnimationBuilder().addAnimation("corpse_idle");

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (!(swingTime > -0.15F && swingTime < 0.15F) && !this.isAggressive()) {
            event.getController().setAnimation(CORPSE_WALK);
            return PlayState.CONTINUE;
        }

        if (event.isMoving()&& !this.isAggressive()) {
            event.getController().setAnimation(CORPSE_WALK);
            return PlayState.CONTINUE;
        }

        if (!(swingTime > -0.15F && swingTime < 0.15F) && this.isAggressive()) {
            event.getController().setAnimation(CORPSE_CHASE);
            return PlayState.CONTINUE;
        }

        if (event.isMoving() && this.isAggressive()) {
            event.getController().setAnimation(CORPSE_CHASE);
            return PlayState.CONTINUE;
        }

        event.getController().setAnimation(CORPSE_IDLE);
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(final AnimationData data) {
        data.addAnimationController(new AnimationController<ForsakenCorpseEntity>(this, "controller", 0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }
}
