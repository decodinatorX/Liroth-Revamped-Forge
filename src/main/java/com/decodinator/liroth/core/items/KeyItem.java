package com.decodinator.liroth.core.items;

import com.decodinator.liroth.core.LirothBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

public class KeyItem extends Item {

	public KeyItem(Properties settings) {
        super(settings);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        BlockPos blockPos;
        Player playerEntity = context.getPlayer();
        Level world = context.getLevel();
        BlockState blockState = world.getBlockState(blockPos = context.getClickedPos());
        if (blockState.is(LirothBlocks.CHARRED_LIROTH_STONE_BRICK_LOCK.get())) {
            world.playSound(playerEntity, blockPos, SoundEvents.LODESTONE_COMPASS_LOCK, SoundSource.BLOCKS, 1.0f, world.getRandom().nextFloat() * 0.4f + 0.8f);
            world.destroyBlock(blockPos, canBeDepleted());
            world.gameEvent((Entity)playerEntity, GameEvent.BLOCK_DESTROY, blockPos);
            if (playerEntity != null) {
                context.getItemInHand().hurtAndBreak(1, playerEntity, p -> p.broadcastBreakEvent(context.getHand()));
            }
            return InteractionResult.sidedSuccess(world.isClientSide());
        }
        return InteractionResult.FAIL;
    }
}