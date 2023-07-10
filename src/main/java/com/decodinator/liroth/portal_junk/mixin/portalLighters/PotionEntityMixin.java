package com.decodinator.liroth.portal_junk.mixin.portalLighters;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.decodinator.liroth.portal_junk.portal.PortalIgnitionSource;
import com.decodinator.liroth.portal_junk.portal.PortalPlacer;

@Mixin(value=ThrownPotion.class,remap=false)
public abstract class PotionEntityMixin extends ThrowableItemProjectile {

    public PotionEntityMixin(EntityType<? extends ThrowableItemProjectile> entityType, Level world) {
        super(entityType, world);
    }

    @Inject(method = "dowseFire", at = @At("HEAD"))
    public void attemptPortalLight(BlockPos pos, CallbackInfo ci) {
        PortalPlacer.attemptPortalLight(this.getLevel(), pos, PortalIgnitionSource.WATER);
    }
}
