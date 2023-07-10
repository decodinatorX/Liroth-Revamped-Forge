package com.decodinator.liroth.core.entities;

import java.util.Random;

import org.jetbrains.annotations.Nullable;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.LirothBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.SmoothSwimmingLookControl;
import net.minecraft.world.entity.ai.control.SmoothSwimmingMoveControl;
import net.minecraft.world.entity.ai.goal.FollowBoatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.goal.TryFindWaterGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.animal.Dolphin;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;

public class VileSharkEntity extends WaterAnimal {
    public static final int MAX_AIR = 4800;
    private static final EntityDataAccessor<Integer> MOISTNESS_LEVEL = SynchedEntityData.defineId(Dolphin.class, EntityDataSerializers.INT);
    private static final int MAX_MOISTNESS = 2400;
    
	public VileSharkEntity(EntityType<? extends WaterAnimal> entityType, Level world) {
		super(entityType, world);
        this.moveControl = new SmoothSwimmingMoveControl(this, 85, 10, 0.02f, 0.1f, true);
        this.lookControl = new SmoothSwimmingLookControl(this, 10);
        this.setPathfindingMalus(BlockPathTypes.WATER, 0.0f);
//      this.isInvulnerableTo(this.m_269291_().m_287172_());
    }

    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }
    
    @Override
    public MobType getMobType() {
        return MobType.WATER;
    }
    
    @Override
    public boolean checkSpawnObstruction(LevelReader p_30348_) {
        return p_30348_.isUnobstructed(this);
     }
    
    @Override
    protected PathNavigation createNavigation(Level p_28362_) {
        return new WaterBoundPathNavigation(this, p_28362_);
     }

    protected void handleAirSupply(int p_30344_) {
        if (this.isAlive() && !this.isInWaterOrBubble()) {
           this.setAirSupply(p_30344_ - 1);
           if (this.getAirSupply() == -20) {
              this.setAirSupply(0);
              this.hurt(this.m_269291_().m_269063_(), 2.0F);
           }
        } else {
           this.setAirSupply(300);
        }

     }

    @Override
    public void baseTick() {
        int i = this.getAirSupply();
        super.baseTick();
        this.handleAirSupply(i);
     }

    @Override
     public boolean isPushedByFluid() {
        return false;
     }

    @Override
     public boolean canBeLeashed(Player p_30346_) {
        return false;
     }

    public static boolean checkSurfaceWaterAnimalSpawnRules(EntityType<? extends WaterAnimal> p_218283_, LevelAccessor p_218284_, MobSpawnType p_218285_, BlockPos p_218286_, RandomSource p_218287_) {
        int i = p_218284_.getSeaLevel();
        int j = i - 13;
        return p_218286_.getY() >= j && p_218286_.getY() <= i && p_218284_.getFluidState(p_218286_.below()).is(FluidTags.WATER) && p_218284_.getBlockState(p_218286_.above()).is(Blocks.WATER);
     }
    
    public static AttributeSupplier.Builder createVileSharkAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.FOLLOW_RANGE, 35.0).add(Attributes.MOVEMENT_SPEED, 1.23f).add(Attributes.ATTACK_DAMAGE, 3.0).add(Attributes.ARMOR, 2.0).add(Attributes.SPAWN_REINFORCEMENTS_CHANCE);
    }
    
    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new MeleeAttackGoal(this, 1.2f, false));
        this.goalSelector.addGoal(1, new TryFindWaterGoal(this));
        this.goalSelector.addGoal(4, new RandomSwimmingGoal(this, 1.0, 10));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 6.0f));
        this.goalSelector.addGoal(8, new FollowBoatGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, ForsakenCorpseEntity.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, SkeletalFreakEntity.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, SoulArachnidEntity.class, true));
    }
    
/*    @Override
    public void travel(Vec3d movementInput) {
        if (this.canMoveVoluntarily() && this.isTouchingWater()) {
            this.updateVelocity(this.getMovementSpeed(), movementInput);
            this.move(MovementType.SELF, this.getVelocity());
            this.setVelocity(this.getVelocity().multiply(0.9));
            if (this.getTarget() == null) {
                this.setVelocity(this.getVelocity().add(0.0, -0.005, 0.0));
            }
        } else {
            super.travel(movementInput);
        }
    }*/
    
    public int getMoistnessLevel() {
        return this.entityData.get(MOISTNESS_LEVEL);
     }

     public void setMoisntessLevel(int p_28344_) {
        this.entityData.set(MOISTNESS_LEVEL, p_28344_);
     }
    
    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(MOISTNESS_LEVEL, 2400);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag nbt) {
        super.addAdditionalSaveData(nbt);
        nbt.putInt("Moistness", this.getMoistnessLevel());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag nbt) {
        super.readAdditionalSaveData(nbt);
        this.setMoisntessLevel(nbt.getInt("Moistness"));
    }
    
    @Override
    public void tick() {
        super.tick();
        if (this.isNoAi()) {
           this.setAirSupply(this.getMaxAirSupply());
        } else {
           if (this.isInWaterRainOrBubble()) {
              this.setMoisntessLevel(2400);
           } else {
              this.setMoisntessLevel(this.getMoistnessLevel() - 1);
              if (this.getMoistnessLevel() <= 0) {
                 this.hurt(this.m_269291_().m_269483_(), 1.0F);
              }

              if (this.isOnGround()) {
                 this.setDeltaMovement(this.getDeltaMovement().add((double)((this.random.nextFloat() * 2.0F - 1.0F) * 0.2F), 0.5D, (double)((this.random.nextFloat() * 2.0F - 1.0F) * 0.2F)));
                 this.setYRot(this.random.nextFloat() * 360.0F);
                 this.setOnGround(false);
                 this.hasImpulse = true;
              }
           }

           if (this.getLevel().isClientSide && this.isInWater() && this.getDeltaMovement().lengthSqr() > 0.03D) {
              Vec3 vec3 = this.getViewVector(0.0F);
              float f = Mth.cos(this.getYRot() * ((float)Math.PI / 180F)) * 0.3F;
              float f1 = Mth.sin(this.getYRot() * ((float)Math.PI / 180F)) * 0.3F;
              float f2 = 1.2F - this.random.nextFloat() * 0.7F;

              for(int i = 0; i < 2; ++i) {
                 this.getLevel().addParticle(ParticleTypes.DOLPHIN, this.getX() - vec3.x * (double)f2 + (double)f, this.getY() - vec3.y, this.getZ() - vec3.z * (double)f2 + (double)f1, 0.0D, 0.0D, 0.0D);
                 this.getLevel().addParticle(ParticleTypes.DOLPHIN, this.getX() - vec3.x * (double)f2 - (double)f, this.getY() - vec3.y, this.getZ() - vec3.z * (double)f2 - (double)f1, 0.0D, 0.0D, 0.0D);
              }
           }

        }
     }
    
    public boolean isAngryAt(Player player) {
        return true;
    }
}
