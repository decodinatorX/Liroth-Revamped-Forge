package com.decodinator.liroth.core.entities;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.LirothSounds;
import com.decodinator.liroth.core.LirothTags;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ShadeEntity extends Zombie {

	public ShadeEntity(EntityType<? extends Zombie> entityType, Level world) {
		super(entityType, world);
	}

    public static AttributeSupplier.Builder createShadeAttributes() {
        return Monster.createMonsterAttributes()
        		.add(Attributes.FOLLOW_RANGE, 100.0)
        		.add(Attributes.MOVEMENT_SPEED, 0.10f)
        		.add(Attributes.ATTACK_DAMAGE, 10.0)
        		.add(Attributes.ARMOR, 1000.0)
        		.add(Attributes.MAX_HEALTH, 1000.0)
        		.add(Attributes.SPAWN_REINFORCEMENTS_CHANCE);
    }
	
    @Override
    protected InteractionResult mobInteract(Player player2, InteractionHand hand) {
        ItemStack itemStack = player2.getItemInHand(hand);
        if (itemStack.is(LirothTags.TORCHES)) {
            this.level().playSound(player2, this.getX(), this.getY(), this.getZ(), SoundEvents.SOUL_SOIL_BREAK, this.getSoundSource(), 1.0f, this.random.nextFloat() * 0.4f + 0.8f);
            if (!this.level().isClientSide) {
                this.poof();
            }
            return InteractionResult.sidedSuccess(this.level().isClientSide);
        }
        return super.mobInteract(player2, hand);
    }
    
    public void poof() {
        this.kill();
    }
    
    @Override
    protected boolean convertsInWater() {
        return false;
     }
    
    @Override
    protected SoundEvent getAmbientSound() {
        return LirothSounds.SHADE_IDLE.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return LirothSounds.SHADE_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return LirothSounds.SHADE_DEATH.get();
    }

    protected SoundEvent getStepSound() {
    	return SoundEvents.SOUL_SAND_STEP;
	}
}
