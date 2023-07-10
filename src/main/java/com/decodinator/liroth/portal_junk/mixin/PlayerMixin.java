package com.decodinator.liroth.portal_junk.mixin;

import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value = Player.class, remap=false)
public abstract class PlayerMixin extends LivingEntityMixin {
}
