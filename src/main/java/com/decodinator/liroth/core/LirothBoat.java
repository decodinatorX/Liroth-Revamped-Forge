package com.decodinator.liroth.core;

import com.decodinator.liroth.Liroth;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.Nullable;

import org.jetbrains.annotations.NotNull;

import net.minecraft.BlockUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.protocol.game.ServerboundPaddleBoatPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.IndirectEntityDamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.DismountHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WaterlilyBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.registries.RegistryObject;

public class LirothBoat extends Boat {
    private static final EntityDataAccessor<Integer> LIROTH_BOAT_TYPE = SynchedEntityData.defineId(LirothBoat.class, EntityDataSerializers.INT);
    private static final LootContextParamSet LOOT_CONTEXT_PARAM_SETS = LootContextParamSet.builder()
            .required(LootContextParams.THIS_ENTITY)
            .required(LootContextParams.THIS_ENTITY)
            .required(LootContextParams.ORIGIN)
            .required(LootContextParams.DAMAGE_SOURCE)
            .build();
    private double lastYd;
    private LirothBoat.Status status;


    public LirothBoat(Level worldIn, double x, double y, double z) {
        this(LirothEntities.LIROTH_BOAT.get(), worldIn);
        this.setPos(x, y, z);
        this.setDeltaMovement(Vec3.ZERO);
        this.xo = x;
        this.yo = y;
        this.zo = z;
    }

    public LirothBoat(EntityType<? extends Boat> boatEntityType, Level worldType) {
        super(boatEntityType, worldType);
    }

    @Override
    public Item getDropItem() {
        switch (this.getLirothBoatType()) {
           case LIROTH:
           default:
              return LirothItems.LIROTH_BOAT.get();
           case DAMNATION:
              return LirothItems.DAMNATION_BOAT.get();
           case SPICED:
              return LirothItems.SPICED_BOAT.get();
           case PIER:
              return LirothItems.PIER_BOAT.get();
           case JAPZ:
              return LirothItems.JAPZ_BOAT.get();
           case KOOLAW:
              return LirothItems.KOOLAW_BOAT.get();
           case PETRIFIED:
              return LirothItems.PETRIFIED_BOAT.get();
        }
     }

    public LirothType getLirothBoatType() {
        return LirothType.byId(this.entityData.get(LIROTH_BOAT_TYPE));
    }

    public void setLirothBoatType(LirothType boatLirothType) {
        this.entityData.set(LIROTH_BOAT_TYPE, boatLirothType.ordinal());
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(LIROTH_BOAT_TYPE, LirothType.LIROTH.ordinal());
    }


    @Override
    protected void addAdditionalSaveData(CompoundTag compound) {
        compound.putString("LirothType", this.getLirothBoatType().getName());
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compound) {
        if (compound.contains("LirothType", 8)) {
            this.setLirothBoatType(LirothType.byName(compound.getString("LirothType")));
        }
    }

    @Override
    public void animateHurt() {
        this.setHurtDir(-this.getHurtDir());
        this.setHurtTime(10);
        this.setDamage(this.getDamage() * 11.0F);
    }

    @Override
    protected void checkFallDamage(double p_38307_, boolean p_38308_, BlockState p_38309_, BlockPos p_38310_) {
        this.lastYd = this.getDeltaMovement().y;
        if (!this.isPassenger()) {
           if (p_38308_) {
              if (this.fallDistance > 3.0F) {
                 if (this.status != LirothBoat.Status.ON_LAND) {
                    this.resetFallDistance();
                    return;
                 }

                 this.causeFallDamage(this.fallDistance, 1.0F, DamageSource.FALL);
                 if (!this.level.isClientSide && !this.isRemoved()) {
                    this.kill();
                    if (this.level.getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
                       for(int i = 0; i < 3; ++i) {
                          this.spawnAtLocation(this.getLirothBoatType().getPlanks());
                       }

                       for(int j = 0; j < 2; ++j) {
                          this.spawnAtLocation(Items.STICK);
                       }
                    }
                 }
              }

              this.resetFallDistance();
           } else if (!(this.level.getFluidState(this.blockPosition().below()).is(FluidTags.WATER)) && p_38307_ < 0.0D) {
              this.fallDistance -= (float)p_38307_;
           }

        }
     }
    @Override
    public boolean hurt(DamageSource p_38319_, float p_38320_) {
        if (this.isInvulnerableTo(p_38319_)) {
           return false;
        } else if (!this.level.isClientSide && !this.isRemoved()) {
           this.setHurtDir(-this.getHurtDir());
           this.setHurtTime(10);
           this.setDamage(this.getDamage() + p_38320_ * 10.0F);
           this.markHurt();
           this.gameEvent(GameEvent.ENTITY_DAMAGE, p_38319_.getEntity());
           boolean flag = p_38319_.getEntity() instanceof Player && ((Player)p_38319_.getEntity()).getAbilities().instabuild;
           if (flag || this.getDamage() > 40.0F) {
              if (!flag && this.level.getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
                 this.destroy(p_38319_);
              }

              this.discard();
           }

           return true;
        } else {
           return true;
        }
     }

    @Override
    public @NotNull Packet<ClientGamePacketListener> getAddEntityPacket() {
        //TODO: Is this right?
        return new ClientboundAddEntityPacket(this);
    }

    public static enum LirothType {
        LIROTH(LirothBlocks.LIROTH_PLANKS, "liroth"),
        DAMNATION(LirothBlocks.DAMNATION_PLANKS, "damnation"),
        SPICED(LirothBlocks.SPICED_PLANKS, "spiced"),
        PIER(LirothBlocks.TALLPIER_PLANKS, "tallpier"),
        JAPZ(LirothBlocks.JAPZ_PLANKS, "japz"),
        KOOLAW(LirothBlocks.KOOLAW_PLANKS, "koolaw"),
        PETRIFIED(LirothBlocks.PETRIFIED_DAMNATION_PLANKS, "petrified_damnation");

        private final String name;
        private final RegistryObject<Block> planks;

        private LirothType(RegistryObject<Block> lirothPlanks, String p_38428_) {
           this.name = p_38428_;
           this.planks = lirothPlanks;
        }

        public String getName() {
           return this.name;
        }

        public @NotNull Block getPlanks() {
           return this.planks.get();
        }

        public String toString() {
           return this.name;
        }

        public static LirothBoat.LirothType byId(int p_38431_) {
           LirothBoat.LirothType[] aboat$type = values();
           if (p_38431_ < 0 || p_38431_ >= aboat$type.length) {
              p_38431_ = 0;
           }

           return aboat$type[p_38431_];
        }

        public static LirothBoat.LirothType byName(String p_38433_) {
           LirothBoat.LirothType[] aboat$type = values();

           for(int i = 0; i < aboat$type.length; ++i) {
              if (aboat$type[i].getName().equals(p_38433_)) {
                 return aboat$type[i];
              }
           }

           return aboat$type[0];
        }
     }
}