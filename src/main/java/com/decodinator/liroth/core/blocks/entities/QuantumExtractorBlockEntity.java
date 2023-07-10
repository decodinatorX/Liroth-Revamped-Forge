package com.decodinator.liroth.core.blocks.entities;

import java.util.List;
import javax.annotation.Nullable;

import com.decodinator.liroth.core.LirothBlockEntities;
import com.decodinator.liroth.core.LirothItems;
import com.decodinator.liroth.core.blocks.QuantumExtractorBlock;
import com.decodinator.liroth.core.helpers.AbstractQuantumRecipe;
import com.decodinator.liroth.core.helpers.QuantumRecipe;
import com.google.common.collect.Lists;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class QuantumExtractorBlockEntity extends BlockEntity implements MenuProvider, Container, WorldlyContainer {
	   private static final int[] SLOTS_FOR_UP = new int[]{0};
	   private static final int[] SLOTS_FOR_DOWN = new int[]{2, 1};
	   private static final int[] SLOTS_FOR_SIDES = new int[]{1};
		private final RecipeType<? extends AbstractQuantumRecipe> recipeType;
	private NonNullList<ItemStack> inventory =
    		NonNullList.withSize(4, ItemStack.EMPTY);
    int burnTime;
    int fuelTime;
    int cookTime;
    int cookTimeTotal = this.getCookTime();
    protected final ContainerData propertyDelegate = new ContainerData() {
        @Override
        public int get(int index) {
            switch (index) {
                case 0: {
                    return QuantumExtractorBlockEntity.this.burnTime;
                }
                case 1: {
                    return QuantumExtractorBlockEntity.this.fuelTime;
                }
                case 2: {
                    return QuantumExtractorBlockEntity.this.cookTime;
                }
                case 3: {
                    return QuantumExtractorBlockEntity.this.cookTimeTotal;
                }
            }
            return 0;
        }

        @Override
        public void set(int index, int value) {
            switch (index) {
                case 0: {
                	QuantumExtractorBlockEntity.this.burnTime = value;
                    break;
                }
                case 1: {
                	QuantumExtractorBlockEntity.this.fuelTime = value;
                    break;
                }
                case 2: {
                	QuantumExtractorBlockEntity.this.cookTime = value;
                    break;
                }
                case 3: {
                	QuantumExtractorBlockEntity.this.cookTimeTotal = value;
                    break;
                }
            }
        }

        @Override
        public int getCount() {
            return 4;
        }
    };
    private final Object2IntOpenHashMap<ResourceLocation> recipesUsed = new Object2IntOpenHashMap<>();
    private final RecipeManager.CachedCheck<Container, ? extends AbstractQuantumRecipe> quickCheck;


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

    public QuantumExtractorBlockEntity(BlockPos pos, BlockState state, RecipeType<? extends AbstractQuantumRecipe> recipeThingy) {
        super(LirothBlockEntities.QUANTUM_EXTRACTOR.get(), pos, state);
        this.quickCheck = RecipeManager.createCheck((RecipeType)recipeThingy);
        this.recipeType = recipeThingy;
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("container.quantum_extractor");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int syncId, Inventory inv, Player player) {
        return new QuantumExtractorScreenHandler(syncId, inv, this, this, this.propertyDelegate);
    }
    
    @Override
    public void load(CompoundTag p_155025_) {
        super.load(p_155025_);
        this.inventory = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        ContainerHelper.loadAllItems(p_155025_, this.inventory);
        this.burnTime = p_155025_.getInt("BurnTime");
        this.cookTime = p_155025_.getInt("CookTime");
        this.cookTimeTotal = p_155025_.getInt("CookTimeTotal");
        this.fuelTime = this.getFuelTime(this.inventory.get(1));
        CompoundTag compoundtag = p_155025_.getCompound("RecipesUsed");

        for(String s : compoundtag.getAllKeys()) {
           this.recipesUsed.put(new ResourceLocation(s), compoundtag.getInt(s));
        }

     }

    @Override
     protected void saveAdditional(CompoundTag p_187452_) {
        super.saveAdditional(p_187452_);
        p_187452_.putInt("BurnTime", this.burnTime);
        p_187452_.putInt("CookTime", this.cookTime);
        p_187452_.putInt("CookTimeTotal", this.cookTimeTotal);
        ContainerHelper.saveAllItems(p_187452_, this.inventory);
        CompoundTag compoundtag = new CompoundTag();
        this.recipesUsed.forEach((p_187449_, p_187450_) -> {
           compoundtag.putInt(p_187449_.toString(), p_187450_);
        });
        p_187452_.put("RecipesUsed", compoundtag);
     }
    
    public void forceUpdateAllStates() {
        BlockState state = level.getBlockState(worldPosition);
        if (state.getValue(QuantumExtractorBlock.LIT) != burnTime > 0) {
            level.setBlock(worldPosition, state.setValue(QuantumExtractorBlock.LIT, burnTime > 0), 3);
        }
    }
    
    public static void playSound(Level world, BlockPos pos, SoundEvent sound) {
        world.playSound(null, pos, sound, SoundSource.BLOCKS, 1.0f, 1.0f);
    }

    public static void serverTick(Level p_155014_, BlockPos p_155015_, BlockState p_155016_, QuantumExtractorBlockEntity p_155017_) {
        boolean flag = p_155017_.isBurning();
        boolean flag1 = false;
        if (p_155017_.isBurning()) {
           --p_155017_.burnTime;
        }

        ItemStack itemstack = p_155017_.inventory.get(1);
        boolean flag2 = !p_155017_.inventory.get(0).isEmpty();
        boolean flag3 = !itemstack.isEmpty();
        if (p_155017_.isBurning() || flag3 && flag2) {
           Recipe<?> recipe;
           if (flag2) {
              recipe = p_155017_.quickCheck.getRecipeFor(p_155017_, p_155014_).orElse(null);
           } else {
              recipe = null;
           }

           int i = p_155017_.getMaxStackSize();
           if (!p_155017_.isBurning() && p_155017_.canBurn(recipe, p_155017_.inventory, i)) {
              p_155017_.burnTime = p_155017_.getFuelTime(itemstack);
              p_155017_.fuelTime = p_155017_.burnTime;
              if (p_155017_.isBurning()) {
                 flag1 = true;
                 if (itemstack.hasCraftingRemainingItem())
                    p_155017_.inventory.set(1, itemstack.getCraftingRemainingItem());
                 else
                 if (flag3) {
                    Item item = itemstack.getItem();
                    itemstack.shrink(1);
                    if (itemstack.isEmpty()) {
                       p_155017_.inventory.set(1, itemstack.getCraftingRemainingItem());
                    }
                 }
              }
           }

           if (p_155017_.isBurning() && p_155017_.canBurn(recipe, p_155017_.inventory, i)) {
              ++p_155017_.cookTime;
              if (p_155017_.cookTime == p_155017_.cookTimeTotal) {
                 p_155017_.cookTime = 0;
                 p_155017_.cookTimeTotal = getTotalCookTime(p_155014_, p_155017_);
                 if (p_155017_.burn(recipe, p_155017_.inventory, i)) {
                    p_155017_.setRecipeUsed(recipe);
                 }

                 flag1 = true;
              }
           } else {
              p_155017_.cookTime = 0;
           }
        } else if (!p_155017_.isBurning() && p_155017_.cookTime > 0) {
           p_155017_.cookTime = Mth.clamp(p_155017_.cookTime - 2, 0, p_155017_.cookTimeTotal);
        }

        if (flag != p_155017_.isBurning()) {
           flag1 = true;
           p_155016_ = p_155016_.setValue(QuantumExtractorBlock.LIT, Boolean.valueOf(p_155017_.isBurning()));
           p_155014_.setBlock(p_155015_, p_155016_, 3);
        }

        if (flag1) {
           setChanged(p_155014_, p_155015_, p_155016_);
        }

     }
    
    private boolean canBurn(@Nullable Recipe<?> p_155006_, NonNullList<ItemStack> p_155007_, int p_155008_) {
        if (!p_155007_.get(0).isEmpty() && p_155006_ != null) {
           ItemStack itemstack = ((Recipe<WorldlyContainer>) p_155006_).assemble(this, this.level.m_9598_());
           if (itemstack.isEmpty()) {
              return false;
           } else {
              ItemStack itemstack1 = p_155007_.get(2);
              ItemStack itemstack2 = p_155007_.get(3);
               ItemStack itemStackSame1 = (ItemStack)p_155007_.get(2);
               ItemStack itemStackSame2 = (ItemStack)p_155007_.get(3);
               if (itemstack1.isEmpty()) {
                 return true;
              } else if (!itemstack1.sameItem(itemStackSame1, itemstack)) {
                 return false;
              } else if (itemstack1.getCount() + itemstack.getCount() <= p_155008_ && itemstack1.getCount() + itemstack.getCount() <= itemstack1.getMaxStackSize()) { // Forge fix: make furnace respect stack sizes in furnace recipes
                 return true;
              }
              if (itemstack2.isEmpty()) {
                 return true;
              } else if (!itemstack2.sameItem(itemStackSame2, itemstack)) {
                 return false;
              } else if (itemstack2.getCount() + itemstack.getCount() <= p_155008_ && itemstack1.getCount() + itemstack.getCount() <= itemstack1.getMaxStackSize()) { // Forge fix: make furnace respect stack sizes in furnace recipes
                 return true;
              } else {
                 return itemstack1.getCount() + itemstack.getCount() <= itemstack.getMaxStackSize() && itemstack2.getCount() + itemstack.getCount() <= itemstack.getMaxStackSize(); // Forge fix: make furnace respect stack sizes in furnace recipes
              }
           }
        } else {
           return false;
        }
     }

     private boolean burn(@Nullable Recipe<?> p_155027_, NonNullList<ItemStack> p_155028_, int p_155029_) {
        if (p_155027_ != null && this.canBurn(p_155027_, p_155028_, p_155029_)) {
           ItemStack itemstack = p_155028_.get(0);
           ItemStack itemstack1 = ((QuantumRecipe) p_155027_).assemble(this);
           ItemStack itemstack2 = p_155028_.get(2);
           ItemStack itemstack3 = p_155028_.get(3);
           AbstractQuantumRecipe fuckOff = ((QuantumRecipe) p_155027_);
           if (itemstack2.isEmpty()) {
              p_155028_.set(2, itemstack1.copy());
           } else if (itemstack2.is(itemstack1.getItem())) {
              itemstack2.grow(itemstack1.getCount());
           }
           if (itemstack3.isEmpty()) {
               p_155028_.set(3, fuckOff.createBonus(level.random));
            } else if (itemstack3.is(fuckOff.getBonusItem().bonus.getItem())) {
               itemstack3.grow(itemstack1.getCount());
            }

           if (itemstack.is(Blocks.WET_SPONGE.asItem()) && !p_155028_.get(1).isEmpty() && p_155028_.get(1).is(Items.BUCKET)) {
              p_155028_.set(1, new ItemStack(Items.WATER_BUCKET));
           }

           itemstack.shrink(1);
           return true;
        } else {
           return false;
        }
     }

    private static void craftQuantumItem(QuantumExtractorBlockEntity entity) {
    	
        entity.removeItem(0, 1);

        entity.setItem(2, new ItemStack(Items.DIAMOND, entity.getItem(2).getCount() + 1));
        entity.setItem(3, new ItemStack(LirothItems.QUANTUM_PLATE.get(), entity.getItem(3).getCount() + 1));
    }
    
    private static void craftPotestiumItem(QuantumExtractorBlockEntity entity) {
    	
        entity.removeItem(0, 1);

        entity.setItem(2, new ItemStack(LirothItems.RUBY.get(), entity.getItem(2).getCount() + 1));
        entity.setItem(3, new ItemStack(LirothItems.POTESTIUM_PLATE.get(), entity.getItem(3).getCount() + 1));
    }

    private static boolean hasQuantumDiamondRecipe(QuantumExtractorBlockEntity entity) {
        boolean hasItemInFirstSlot = entity.getItem(0).getItem() == LirothItems.QUANTUM_DIAMOND.get();

        return hasItemInFirstSlot;
    }
    
    private static boolean hasPotestiumShardRecipe(QuantumExtractorBlockEntity entity) {
        boolean hasItemInFirstSlot = entity.getItem(0).getItem() == LirothItems.POTESTIUM_SHARD.get();

        return hasItemInFirstSlot;
    }

    private static boolean hasNotReachedStackLimit(QuantumExtractorBlockEntity entity) {
        return /*entity.getStack(2).getCount() < entity.getStack(2).getMaxCount() ||*/
        	   entity.getItem(2).getCount() < entity.getItem(2).getCount() ||
        	   entity.getItem(3).getCount() < entity.getItem(3).getCount();
    }
    
    private int getCookTime() {
        return (200);
    }
    
    public boolean isBurning() {
        return this.burnTime > 0;
    }
    
	protected int getFuelTime(ItemStack fuel) {
		if (fuel.isEmpty()) {
			return 0;
		} else if (fuel.is(Blocks.REDSTONE_BLOCK.asItem())) {
			return 600;
/*		} else if (fuel.isOf(LirothBlocks.REDSTONE_BROKEN_STAGE_1.asItem())) {
			return 16000;
		} else if (fuel.isOf(LirothBlocks.REDSTONE_BROKEN_STAGE_2.asItem())) {
			return 16000;
		} else if (fuel.isOf(LirothBlocks.REDSTONE_BROKEN_STAGE_3.asItem())) {
			return 16000;*/
		} else {
	         return 0;
		}
	}
    
    @Override
    public boolean canPlaceItem(int p_58389_, ItemStack p_58390_) {
        if (p_58389_ == 2 || p_58389_ == 3) {
           return false;
        } else if (p_58389_ != 1) {
           return true;
        } else {
           ItemStack itemstack = this.inventory.get(1);
           return net.minecraftforge.common.ForgeHooks.getBurnTime(p_58390_, this.recipeType) > 0 || p_58390_.is(Items.BUCKET) && !itemstack.is(Items.BUCKET);
        }
     }
    
    private static boolean tickReached100(QuantumExtractorBlockEntity entity) {
    	return entity.ticks <= entity.getCookTime();
    }

	@Override
	public void clearContent() {
	      this.inventory.clear();
		
	}

	@Override
	public int getContainerSize() {
		return 4;
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
	   public void setItem(int p_58333_, ItemStack p_58334_) {
	      ItemStack itemstack = this.inventory.get(p_58333_);
          boolean bl = !p_58334_.isEmpty() && ItemStack.isSameItemSameTags(itemstack, p_58334_);
	      this.inventory.set(p_58333_, p_58334_);
	      if (p_58334_.getCount() > this.getMaxStackSize()) {
	         p_58334_.setCount(this.getMaxStackSize());
	      }

	      if (p_58333_ == 0 && !bl) {
	         this.cookTimeTotal = getTotalCookTime(this.level, this);
	         this.cookTime = 0;
	         this.setChanged();
	      }

	   }
	
	   private static int getTotalCookTime(Level p_222693_, QuantumExtractorBlockEntity p_222694_) {
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
    
    public int[] getSlotsForFace(Direction p_58363_) {
        if (p_58363_ == Direction.DOWN) {
           return SLOTS_FOR_DOWN;
        } else {
           return p_58363_ == Direction.UP ? SLOTS_FOR_UP : SLOTS_FOR_SIDES;
        }
     }

     public boolean canPlaceItemThroughFace(int p_58336_, ItemStack p_58337_, @Nullable Direction p_58338_) {
        return this.canPlaceItem(p_58336_, p_58337_);
     }

     public boolean canTakeItemThroughFace(int p_58392_, ItemStack p_58393_, Direction p_58394_) {
        if (p_58394_ == Direction.DOWN && p_58392_ == 1) {
           return p_58393_.is(Items.WATER_BUCKET) || p_58393_.is(Items.BUCKET);
        } else {
           return true;
        }
     }
     
     public void setRecipeUsed(@Nullable Recipe<?> p_58345_) {
         if (p_58345_ != null) {
            ResourceLocation resourcelocation = p_58345_.getId();
            this.recipesUsed.addTo(resourcelocation, 1);
         }

      }

      @Nullable
      public Recipe<?> getRecipeUsed() {
         return null;
      }
      
      public void awardUsedRecipes(Player p_58396_) {
      }

      public void awardUsedRecipesAndPopExperience(ServerPlayer p_155004_) {
          List<Recipe<?>> list = this.getRecipesToAwardAndPopExperience(p_155004_.m_284548_(), p_155004_.position());
         p_155004_.awardRecipes(list);
         this.recipesUsed.clear();
      }

      public List<Recipe<?>> getRecipesToAwardAndPopExperience(ServerLevel p_154996_, Vec3 p_154997_) {
         List<Recipe<?>> list = Lists.newArrayList();

         for(Object2IntMap.Entry<ResourceLocation> entry : this.recipesUsed.object2IntEntrySet()) {
            p_154996_.getRecipeManager().byKey(entry.getKey()).ifPresent((p_155023_) -> {
               list.add(p_155023_);
               createExperience(p_154996_, p_154997_, entry.getIntValue(), ((AbstractQuantumRecipe)p_155023_).getExperience());
            });
         }

         return list;
      }

      private static void createExperience(ServerLevel p_154999_, Vec3 p_155000_, int p_155001_, float p_155002_) {
         int i = Mth.floor((float)p_155001_ * p_155002_);
         float f = Mth.frac((float)p_155001_ * p_155002_);
         if (f != 0.0F && Math.random() < (double)f) {
            ++i;
         }

         ExperienceOrb.award(p_154999_, p_155000_, i);
      }

      public void fillStackedContents(StackedContents p_58342_) {
         for(ItemStack itemstack : this.inventory) {
            p_58342_.accountStack(itemstack);
         }

      }

      net.minecraftforge.common.util.LazyOptional<? extends net.minecraftforge.items.IItemHandler>[] handlers =
              net.minecraftforge.items.wrapper.SidedInvWrapper.create(this, Direction.UP, Direction.DOWN, Direction.NORTH);

      @Override
      public <T> net.minecraftforge.common.util.LazyOptional<T> getCapability(net.minecraftforge.common.capabilities.Capability<T> capability, @Nullable Direction facing) {
         if (!this.remove && facing != null && capability == net.minecraftforge.common.capabilities.ForgeCapabilities.ITEM_HANDLER) {
            if (facing == Direction.UP)
               return handlers[0].cast();
            else if (facing == Direction.DOWN)
               return handlers[1].cast();
            else
               return handlers[2].cast();
         }
         return super.getCapability(capability, facing);
      }

      @Override
      public void invalidateCaps() {
         super.invalidateCaps();
         for (int x = 0; x < handlers.length; x++)
           handlers[x].invalidate();
      }

      @Override
      public void reviveCaps() {
         super.reviveCaps();
         this.handlers = net.minecraftforge.items.wrapper.SidedInvWrapper.create(this, Direction.UP, Direction.DOWN, Direction.NORTH);
      }
}