package com.decodinator.liroth.core.blocks.entities;

import com.decodinator.liroth.core.LirothBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.FurnaceMenu;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class DamnationFurnaceBlockEntity extends AbstractFurnaceBlockEntity {
    public DamnationFurnaceBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(LirothBlockEntities.DAMNATION_FURNACE.get(), blockPos, blockState, RecipeType.SMELTING);
    }

    protected Component getDefaultName() {
        return Component.translatable("container.furnace");
    }

    protected AbstractContainerMenu createMenu(int syncId, Inventory playerInventory) {
        return new FurnaceMenu(syncId, playerInventory, this, this.dataAccess);
    }
}