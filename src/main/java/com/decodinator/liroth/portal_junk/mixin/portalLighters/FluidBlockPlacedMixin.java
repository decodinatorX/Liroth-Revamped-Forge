package com.decodinator.liroth.portal_junk.mixin.portalLighters;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.decodinator.liroth.portal_junk.portal.PortalIgnitionSource;
import com.decodinator.liroth.portal_junk.portal.PortalPlacer;

@Mixin(value=LiquidBlock.class,remap=false)
public abstract class FluidBlockPlacedMixin {

    @Inject(method = "onPlace", at = @At("HEAD"))
    public void fluidPlacedAttemptPortalLight(BlockState state, Level world, BlockPos pos, BlockState oldState, boolean notify, CallbackInfo ci) {
        if (state.getFluidState().isSource())
            PortalPlacer.attemptPortalLight(world, pos, PortalIgnitionSource.FluidSource(state.getFluidState().getType()));
    }
}
