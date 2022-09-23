package com.decodinator.liroth.core;

import com.decodinator.liroth.core.entities.projectiles.BeamLaserProjectileEntity;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class BeamItem extends Item {

	public BeamItem(Properties settings) {
		super(settings);
	}
	
    public AbstractArrow createBeam(Level world, ItemStack stack, LivingEntity shooter) {
        BeamLaserProjectileEntity beamEntity = new BeamLaserProjectileEntity(world, shooter);
        beamEntity.initFromStack(stack);
        return beamEntity;
    }
}