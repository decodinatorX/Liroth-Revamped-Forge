package com.decodinator.liroth.core.entities;

import com.decodinator.liroth.Liroth;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.Level;

public class ForsakenCorpseEntity extends Zombie {

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
}
