package com.decodinator.liroth.core.entities;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.LirothSounds;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.Level;

public class FreakshowEntity extends Zombie {

	public FreakshowEntity(EntityType<? extends Zombie> entityType, Level world) {
		super(entityType, world);
	}

    public static AttributeSupplier.Builder createFreakshowAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.FOLLOW_RANGE, 256.0).add(Attributes.MOVEMENT_SPEED, 0.15f).add(Attributes.ATTACK_DAMAGE, 20.0).add(Attributes.ARMOR, 2.0).add(Attributes.SPAWN_REINFORCEMENTS_CHANCE);
    }
    
    @Override
    protected boolean convertsInWater() {
        return false;
     }
    
    @Override
    protected SoundEvent getAmbientSound() {
        return LirothSounds.WARP_IDLE.get();
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
