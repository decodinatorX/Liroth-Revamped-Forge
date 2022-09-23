package com.decodinator.liroth.core.entities;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.LirothSounds;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.level.Level;

public class LirothianMimicEntity extends Spider {

	public LirothianMimicEntity(EntityType<? extends Spider> entityType, Level world) {
		super(entityType, world);
	}
	
    public static AttributeSupplier.Builder createLirothianMimicAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 16.0).add(Attributes.MOVEMENT_SPEED, 0.3f);
    }
    
    @Override
    protected SoundEvent getAmbientSound() {
        return LirothSounds.SHADE_IDLE.get();
    }
}
