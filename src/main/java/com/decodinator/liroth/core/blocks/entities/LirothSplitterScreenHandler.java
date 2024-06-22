package com.decodinator.liroth.core.blocks.entities;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.LirothMenuTypes;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class LirothSplitterScreenHandler extends AbstractContainerMenu {
    public final LirothSplitterBlockEntity blockEntityGay;
    private final Container inventory;
    private final Level world;
    private final ContainerData propertyDelegate;
	private Player entity;

    public LirothSplitterScreenHandler(int syncId, Inventory playerInventory, FriendlyByteBuf extraData) {
        this(syncId, playerInventory, playerInventory.player.level.getBlockEntity(extraData.readBlockPos()), new SimpleContainer(5), new SimpleContainerData(4));
    }

    public LirothSplitterScreenHandler(int syncId, Inventory playerInventory, BlockEntity blockEntity, Container simpleContainer, ContainerData data) {
        super(LirothMenuTypes.LIROTH_SPLITTER_MENU.get(), syncId);
        checkContainerSize(simpleContainer, 5);
        this.inventory = simpleContainer;
        this.world = playerInventory.player.level;
        simpleContainer.startOpen(playerInventory.player);
        this.propertyDelegate = data;
        blockEntityGay = (LirothSplitterBlockEntity) blockEntity;

        // Our Slots
        this.addSlot(new Slot(simpleContainer, 0, 52, 16));
        this.addSlot(new Slot(simpleContainer, 1, 52, 52));
        this.addSlot(new Slot(simpleContainer, 2, 112, 8));
        this.addSlot(new Slot(simpleContainer, 3, 112, 34));
        this.addSlot(new Slot(simpleContainer, 4, 112, 60));

        for(int i = 0; i < 3; ++i) {
           for(int j = 0; j < 9; ++j) {
              this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
           }
        }

        for(int k = 0; k < 9; ++k) {
           this.addSlot(new Slot(playerInventory, k, 8 + k * 18, 142));
        }

        this.addDataSlots(data);
     }

    public LirothSplitterBlockEntity getBlockEntity() {
        return this.blockEntityGay;
    }

    @Override
    public boolean stillValid(Player p_38974_) {
        return this.inventory.stillValid(p_38974_);
     }

    @Override
    public ItemStack quickMoveStack(Player player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot != null && slot.hasItem()) {
            ItemStack originalStack = slot.getItem();
            newStack = originalStack.copy();
            if (invSlot < this.inventory.getMaxStackSize()) {
                if (!this.moveItemStackTo(originalStack, this.inventory.getMaxStackSize(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(originalStack, 0, this.inventory.getMaxStackSize(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }

        return newStack;
    }
    
	@OnlyIn(Dist.CLIENT)
	public int getCookProgress(int pixels) {
		int time = propertyDelegate.get(2);
		int timeTotal = propertyDelegate.get(3);
		return timeTotal != 0 && time != 0 ? time * pixels / timeTotal : 0;
	}
	
	@OnlyIn(Dist.CLIENT)
    public int getFuelProgress() {
        int i = this.propertyDelegate.get(1);
        if (i == 0) {
            i = 200;
        }
        return this.propertyDelegate.get(0) * 13 / i;
    }
	
	@OnlyIn(Dist.CLIENT)
    public boolean isBurning() {
        return this.propertyDelegate.get(0) > 0;
    }
}