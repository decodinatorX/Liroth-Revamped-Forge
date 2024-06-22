package com.decodinator.liroth.core.entities;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.level.Level;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

public class SoulArachnidEntity extends Spider implements IAnimatable {
    private AnimationFactory factory = GeckoLibUtil.createFactory(this);

	public SoulArachnidEntity(EntityType<? extends Spider> entityType, Level world) {
		super(entityType, world);
	}
	
    public static AttributeSupplier.Builder createSoulArachnidAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 16.0).add(Attributes.MOVEMENT_SPEED, 0.3f);
    }

    private static final AnimationBuilder WALK = new AnimationBuilder().addAnimation("animation.soul_arachnid.walk");
    private static final AnimationBuilder IDLE = new AnimationBuilder().addAnimation("animation.soul_arachnid.idle");

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (!(swingTime > -0.15F && swingTime < 0.15F)) {
            event.getController().setAnimation(WALK);
            return PlayState.CONTINUE;
        }

        if (event.isMoving()) {
            event.getController().setAnimation(WALK);
            return PlayState.CONTINUE;
        }

        event.getController().setAnimation(IDLE);
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(final AnimationData data) {
        data.addAnimationController(new AnimationController<SoulArachnidEntity>(this, "controller", 0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

}
