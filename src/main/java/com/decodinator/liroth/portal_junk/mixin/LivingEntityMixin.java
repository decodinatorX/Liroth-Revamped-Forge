package com.decodinator.liroth.portal_junk.mixin;

import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value = LivingEntity.class, remap=false)
public abstract class LivingEntityMixin extends EntityMixin {
}
