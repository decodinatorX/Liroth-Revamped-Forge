package com.decodinator.liroth.core.entities;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.LirothSounds;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

public class WarpEntity extends EnderMan implements IAnimatable {
    private AnimationFactory factory = GeckoLibUtil.createFactory(this);

    public WarpEntity(EntityType<? extends EnderMan> entityType, Level world) {
        super(entityType, world);
//        this.maxUpStep = 1.0f;
        this.setPathfindingMalus(BlockPathTypes.WATER, -1.0f);
    }

    public static AttributeSupplier.Builder createWarpAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 40.0).add(Attributes.MOVEMENT_SPEED, 0.3f).add(Attributes.ATTACK_DAMAGE, 7.0).add(Attributes.FOLLOW_RANGE, 64.0);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return this.isAngry() ? SoundEvents.ENDERMAN_SCREAM : LirothSounds.WARP_IDLE.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return LirothSounds.WARP_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return LirothSounds.WARP_DEATH.get();
    }

    private static final AnimationBuilder WARP_WALK = new AnimationBuilder().addAnimation("warp_walk");
    private static final AnimationBuilder WARP_CHASE = new AnimationBuilder().addAnimation("warp_chase");
    private static final AnimationBuilder WARP_IDLE = new AnimationBuilder().addAnimation("warp_idle");

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (!(swingTime > -0.15F && swingTime < 0.15F) && !this.isAggressive()) {
            event.getController().setAnimation(WARP_WALK);
            return PlayState.CONTINUE;
        }

        if (event.isMoving() && !this.isAggressive()) {
            event.getController().setAnimation(WARP_WALK);
            return PlayState.CONTINUE;
        }

        if (!(swingTime > -0.15F && swingTime < 0.15F) && this.isAggressive()) {
            event.getController().setAnimation(WARP_CHASE);
            return PlayState.CONTINUE;
        }

        if (event.isMoving() && this.isAggressive()) {
            event.getController().setAnimation(WARP_CHASE);
            return PlayState.CONTINUE;
        }

        event.getController().setAnimation(WARP_IDLE);
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(final AnimationData data) {
        data.addAnimationController(new AnimationController<WarpEntity>(this, "controller", 0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

}
