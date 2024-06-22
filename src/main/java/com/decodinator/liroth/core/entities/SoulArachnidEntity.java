package com.decodinator.liroth.core.entities;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class SoulArachnidEntity extends Spider implements GeoAnimatable {
    private AnimatableInstanceCache factory = GeckoLibUtil.createInstanceCache(this);

	public SoulArachnidEntity(EntityType<? extends Spider> entityType, Level world) {
		super(entityType, world);
	}
	
    public static AttributeSupplier.Builder createSoulArachnidAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 16.0).add(Attributes.MOVEMENT_SPEED, 0.3f);
    }

    private static final RawAnimation WALK = RawAnimation.begin().thenPlay("animation.soul_arachnid.walk");
    private static final RawAnimation IDLE = RawAnimation.begin().thenPlay("animation.soul_arachnid.idle");

    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
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
    public void registerControllers(AnimatableManager.ControllerRegistrar data) {
        data.add(new AnimationController<SoulArachnidEntity>(this, "controller", 0, this::predicate));
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
