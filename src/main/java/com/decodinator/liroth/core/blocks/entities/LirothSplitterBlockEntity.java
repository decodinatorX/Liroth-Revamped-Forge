package com.decodinator.liroth.core.blocks.entities;

import java.util.Map;

import javax.annotation.Nullable;

import com.decodinator.liroth.core.LirothBlockEntities;
import com.decodinator.liroth.core.LirothItems;
import com.decodinator.liroth.core.blocks.LirothSplitterBlock;
import com.google.common.collect.Maps;

import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.FurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ForgeHooks;

public class LirothSplitterBlockEntity extends BlockEntity implements MenuProvider, Container {
    private NonNullList<ItemStack> inventory =
    		NonNullList.withSize(5, ItemStack.EMPTY);
    FriendlyByteBuf extraData;
	private static final Map<Item, Integer> AVAILABLE_FUELS = Maps.newHashMap();
    private int timer;
    int burnTime;
    int fuelTime;
    int cookTime;
    int cookTimeTotal = this.getCookTime();
    protected final ContainerData propertyDelegate = new ContainerData() {
        @Override
        public int get(int index) {
            switch (index) {
                case 0: {
                    return LirothSplitterBlockEntity.this.burnTime;
                }
                case 1: {
                    return LirothSplitterBlockEntity.this.fuelTime;
                }
                case 2: {
                    return LirothSplitterBlockEntity.this.cookTime;
                }
                case 3: {
                    return LirothSplitterBlockEntity.this.cookTimeTotal;
                }
            }
            return 0;
        }

        @Override
        public void set(int index, int value) {
            switch (index) {
                case 0: {
                	LirothSplitterBlockEntity.this.burnTime = value;
                    break;
                }
                case 1: {
                	LirothSplitterBlockEntity.this.fuelTime = value;
                    break;
                }
                case 2: {
                	LirothSplitterBlockEntity.this.cookTime = value;
                    break;
                }
                case 3: {
                	LirothSplitterBlockEntity.this.cookTimeTotal = value;
                    break;
                }
            }
        }

        @Override
        public int getCount() {
            return 4;
        }
    };

	protected int processTime;
	protected int totalProcessTime;
	private int ticks;

	// uses for both tile entity and jei recipe viewer
	public static final int totalTime = 50;

	public int getField(int id) {
		switch (id) {
		case 0:
			return this.processTime;
		case 1:
			return this.totalProcessTime;
		default:
			return 0;
		}
	}

	public void setField(int id, int value) {
		switch (id) {
		case 0:
			this.processTime = value;
			break;
		case 1:
			this.totalProcessTime = value;
			break;
		}
	}

	public int getFieldCount() {
		return 2;
	}

    public LirothSplitterBlockEntity(BlockPos pos, BlockState state) {
        super(LirothBlockEntities.LIROTH_SPLITTER.get(), pos, state);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("container.liroth_splitter");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int syncId, Inventory inv, Player player) {
        return new LirothSplitterScreenHandler(syncId, inv, this, this, this.propertyDelegate);
    }

    @Override
    public void saveAdditional(CompoundTag nbt) {
        super.saveAdditional(nbt);
        nbt.putInt("BurnTime", this.burnTime);
        nbt.putInt("CookTime", this.cookTime);
        nbt.putInt("CookTimeTotal", this.cookTimeTotal);
        ContainerHelper.saveAllItems(nbt, this.inventory);
        CompoundTag compoundtag = new CompoundTag();
        nbt.put("RecipesUsed", compoundtag);
     }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        this.inventory = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        ContainerHelper.loadAllItems(nbt, this.inventory);
        this.burnTime = nbt.getInt("BurnTime");
        this.cookTime = nbt.getInt("CookTime");
        this.cookTimeTotal = nbt.getInt("CookTimeTotal");
        this.fuelTime = this.getFuelTime(this.inventory.get(1));
        CompoundTag compoundtag = nbt.getCompound("RecipesUsed");
        }
    
    public void forceUpdateAllStates() {
        BlockState state = level.getBlockState(worldPosition);
        if (state.getValue(LirothSplitterBlock.LIT) != burnTime > 0) {
            level.setBlock(worldPosition, state.setValue(LirothSplitterBlock.LIT, burnTime > 0), 3);
        }
    }
    
    public static void playSound(Level world, BlockPos pos, SoundEvent sound) {
        world.playSound(null, pos, sound, SoundSource.BLOCKS, 1.0f, 1.0f);
    }

    public static void serverTick(Level world, BlockPos pos, BlockState state, LirothSplitterBlockEntity entity) {
        boolean bl = entity.isBurning();
        boolean bl2 = false;
        if (entity.isBurning()) {
            --entity.burnTime;
        }
        ItemStack itemStack = entity.inventory.get(1);
        if (entity.isBurning() || !itemStack.isEmpty() && !entity.inventory.get(0).isEmpty()) {
            int i = entity.getContainerSize();
            if (!entity.isBurning()) {
                entity.fuelTime = entity.burnTime = entity.getFuelTime(itemStack);
                if (entity.isBurning() && LirothSplitterBlockEntity.hasRecipe(entity)) {
                    bl2 = true;
                    if (!itemStack.isEmpty()) {
                        Item item = itemStack.getItem();
                        itemStack.shrink(1);
                        if (itemStack.isEmpty()) {
                            Item item2 = item.getCraftingRemainingItem();
                            entity.inventory.set(1, item2 == null ? ItemStack.EMPTY : new ItemStack(item2));
                        }
                    }
                }
            }
            if (entity.isBurning() && LirothSplitterBlockEntity.hasRecipe(entity)) {
                ++entity.cookTime;
                if (entity.cookTime == entity.cookTimeTotal) {
                    entity.cookTime = 0;
                    entity.cookTimeTotal = LirothSplitterBlockEntity.getCookTime();
                    LirothSplitterBlockEntity.craftItem(entity);
                    bl2 = true;
                }
            } else {
                entity.cookTime = 0;
            }
        } else if (!entity.isBurning() && entity.cookTime > 0) {
            entity.cookTime = Mth.clamp(entity.cookTime - 2, 0, entity.cookTimeTotal);
        }
        if (bl != entity.isBurning()) {
            bl2 = true;
            state = (BlockState)state.setValue(LirothSplitterBlock.LIT, entity.isBurning());
            world.setBlock(pos, state, Block.UPDATE_ALL);
        }
        if (bl2) {
        	LirothSplitterBlockEntity.setChanged(world, pos, state);
        }
    }

    private static void craftItem(LirothSplitterBlockEntity entity) {
    	
        entity.removeItem(0, 1);

        entity.setItem(2, new ItemStack(LirothItems.LIROTH_DUST_ANSALUM.get(), entity.getItem(2).getCount() + 1));
        entity.setItem(3, new ItemStack(LirothItems.LIROTH_DUST_LUX.get(), entity.getItem(3).getCount() + 1));
        entity.setItem(4, new ItemStack(LirothItems.LIROTH_DUST_SALEM.get(), entity.getItem(4).getCount() + 1));
        
        entity.ticks = 0;
    }

    private static boolean hasRecipe(LirothSplitterBlockEntity entity) {
        boolean hasItemInFirstSlot = entity.getItem(0).getItem() == LirothItems.LIROTH_GEM.get();

        return hasItemInFirstSlot;
    }

    private static boolean hasNotReachedStackLimit(LirothSplitterBlockEntity entity) {
        return entity.getItem(2).getCount() < entity.getItem(2).getCount() ||
        	   entity.getItem(3).getCount() < entity.getItem(3).getCount() ||
        	   entity.getItem(4).getCount() < entity.getItem(4).getCount();
    }
    
    private static int getCookTime() {
        return (200);
    }
    
    public boolean isBurning() {
        return this.burnTime > 0;
    }
    
    protected int getFuelTime(ItemStack p_58343_) {
        if (p_58343_.isEmpty()) {
           return 0;
        } else {
           Item item = p_58343_.getItem();
           return net.minecraftforge.common.ForgeHooks.getBurnTime(p_58343_, null);
        }
     }
    
    @Override
    public boolean canPlaceItem(int slot, ItemStack stack) {
        if (slot == 2 || slot == 3 || slot == 4) {
            return false;
        }
        if (slot == 1) {
            ItemStack itemStack = this.inventory.get(1);
            return AbstractFurnaceBlockEntity.isFuel(stack) || stack.is(Items.BUCKET) && !itemStack.is(Items.BUCKET);
        }
        return true;
    }
    
	public static boolean canUseAsFuel(ItemStack stack) {
		return AVAILABLE_FUELS.containsKey(stack.getItem()) || net.minecraftforge.common.ForgeHooks.getBurnTime(stack, null) > 2000;
	}
	
	public static Map<Item, Integer> availableFuels() {
		return AVAILABLE_FUELS;
	}
    
    private static boolean tickReached100(LirothSplitterBlockEntity entity) {
    	return entity.ticks <= getCookTime();
    }

	@Override
	public void clearContent() {
	      this.inventory.clear();
		
	}

	@Override
	public int getContainerSize() {
		return 5;
	}

	@Override
	public boolean isEmpty() {
	      for(ItemStack itemstack : this.inventory) {
	          if (!itemstack.isEmpty()) {
	             return false;
	          }
	       }

	       return true;
	    }

	@Override
	public ItemStack getItem(int p_18941_) {
	      return this.inventory.get(p_18941_);

	}

	@Override
	public ItemStack removeItem(int p_18942_, int p_18943_) {
	      return ContainerHelper.removeItem(this.inventory, p_18942_, p_18943_);
	   }

	@Override
	public ItemStack removeItemNoUpdate(int p_18951_) {
	      return ContainerHelper.takeItem(this.inventory, p_18951_);
	}

	@Override
	public void setItem(int p_18944_, ItemStack p_18945_) {
	      ItemStack itemstack = this.inventory.get(p_18944_);
	      boolean flag = !p_18945_.isEmpty() && p_18945_.sameItem(itemstack) && ItemStack.tagMatches(p_18945_, itemstack);
	      this.inventory.set(p_18944_, p_18945_);
	      if (p_18945_.getCount() > this.getMaxStackSize()) {
	         p_18945_.setCount(this.getMaxStackSize());
	      }

	      if (p_18944_ == 0 && !flag) {
	         this.cookTimeTotal = getTotalCookTime(this.level, this);
	         this.cookTime = 0;
	         this.setChanged();
	      }		
	}
	
	   private static int getTotalCookTime(Level p_222693_, LirothSplitterBlockEntity p_222694_) {
		      return 200;
		   }
	   
	@Override
	public boolean stillValid(Player p_18946_) {
	      if (this.level.getBlockEntity(this.worldPosition) != this) {
	          return false;
	       } else {
	          return p_18946_.distanceToSqr((double)this.worldPosition.getX() + 0.5D, (double)this.worldPosition.getY() + 0.5D, (double)this.worldPosition.getZ() + 0.5D) <= 64.0D;
	       }
	    }
	
    public void drops() {
        SimpleContainer inventoryDrop = new SimpleContainer(inventory.size());
        for (int i = 0; i < inventory.size(); i++) {
            inventory.set(i, inventory.get(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventoryDrop);
    }
}