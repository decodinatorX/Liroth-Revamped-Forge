package com.decodinator.liroth.core.entities;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.LirothSounds;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class FungalFiendEntity extends Creeper {

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

}
