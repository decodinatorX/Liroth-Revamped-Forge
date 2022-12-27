package com.decodinator.liroth.core.items;

import java.util.List;

import javax.annotation.Nullable;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.LirothBlocks;
import com.decodinator.liroth.portal_junk.JantiroPortalBlock;
import com.decodinator.liroth.portal_junk.LirothDimensions;
import com.decodinator.liroth.portal_junk.LirothPortalBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class JantiroChargeItem extends Item {
    public JantiroChargeItem() {
        super(new Properties()
                .tab(Liroth.liroth_items_tab)
                .stacksTo(1)
                .rarity(Rarity.RARE)
        );
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
/*        if(context.getPlayer() != null) {
            if(context.getPlayer().level.dimension() == LirothDimensions.JANTIROS_ESCAPE
                    || context.getPlayer().level.dimension() == Level.OVERWORLD) {
                for(Direction direction : Direction.Plane.VERTICAL) {
                    BlockPos framePos = context.getClickedPos().relative(direction);
                    if(((JantiroPortalBlock) LirothBlocks.JANTIRO_DIMENSION_PORTAL.get()).trySpawnPortal(context.getLevel(), framePos)) {
                        context.getLevel().playSound(context.getPlayer(), framePos,
                                SoundEvents.PORTAL_TRIGGER, SoundSource.BLOCKS, 1.0F, 1.0F);
                        return InteractionResult.CONSUME;
                    }
                    else return InteractionResult.FAIL;
                }
            }
        }*/
        return InteractionResult.FAIL;
    }
    
    @Override
    public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> p_41423_, TooltipFlag p_41424_) {
    	p_41423_.add(Component.translatable("item.liroth.anomaly_charge.desc"));
    }
}