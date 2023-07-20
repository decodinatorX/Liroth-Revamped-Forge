package com.decodinator.liroth.core.entities;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.LirothSounds;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.BlockPathTypes;

public class ProwlerEntity extends EnderMan {

	public ProwlerEntity(EntityType<? extends EnderMan> entityType, Level world) {
		super(entityType, world);
//        this.maxUpStep = 1.0f;
        this.setPathfindingMalus(BlockPathTypes.WATER, -1.0f);
	}

    public static AttributeSupplier.Builder createProwlerAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 40.0).add(Attributes.MOVEMENT_SPEED, 0.4f).add(Attributes.ATTACK_DAMAGE, 12.0).add(Attributes.FOLLOW_RANGE, 48.0);
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
}
