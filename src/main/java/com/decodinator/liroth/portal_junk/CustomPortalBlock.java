package com.decodinator.liroth.portal_junk;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

import com.decodinator.liroth.core.LirothParticles;
import com.decodinator.liroth.portal_junk.portal.frame.PortalFrameTester;
import com.decodinator.liroth.portal_junk.util.CustomPortalHelper;
import com.decodinator.liroth.portal_junk.util.CustomTeleporter;
import com.decodinator.liroth.portal_junk.util.PortalLink;

import com.decodinator.liroth.portal_junk.interfaces.EntityInCustomPortal;

public class CustomPortalBlock extends Block {
    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.AXIS;
    protected static final VoxelShape X_SHAPE = Block.box(0.0D, 0.0D, 6.0D, 16.0D, 16.0D, 10.0D);
    protected static final VoxelShape Z_SHAPE = Block.box(6.0D, 0.0D, 0.0D, 10.0D, 16.0D, 16.0D);
    protected static final VoxelShape Y_SHAPE = Block.box(0.0D, 6.0D, 0.0D, 16.0D, 10.0D, 16.0D);

    public CustomPortalBlock(Properties settings) {
        super(settings);
        this.registerDefaultState(this.stateDefinition.any().setValue(AXIS, Direction.Axis.X));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(AXIS)) {
            case Z -> Z_SHAPE;
            case Y -> Y_SHAPE;
            default -> X_SHAPE;
        };
    }

    @SuppressWarnings("deprecation")
	public BlockState m_7417_(BlockState state, Direction direction, BlockState newState, LevelAccessor world, BlockPos pos, BlockPos posFrom) {
        Block block = getPortalBase((Level) world, pos);
        PortalLink link = CustomPortalApiRegistry.getPortalLinkFromBase(block);
        if (link != null) {
            PortalFrameTester portalFrameTester = link.getFrameTester().createInstanceOfPortalFrameTester().init(world, pos, CustomPortalHelper.getAxisFrom(state), block);
            if (portalFrameTester.isAlreadyLitPortalFrame())
                return super.updateShape(state, direction, newState, world, pos, posFrom);
        }
        //todo handle unknown portallink

        return Blocks.AIR.defaultBlockState();
    }

    protected void m_7926_(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AXIS);
    }

    @OnlyIn(Dist.CLIENT)
    public ItemStack m_7397_(BlockGetter world, BlockPos pos, BlockState state) {
        return ItemStack.EMPTY;
    }

    @OnlyIn(Dist.CLIENT)
    public void randomDisplayTick(BlockState state, Level world, BlockPos pos, Random random) {
        if (random.nextInt(100) == 0) {
            world.playLocalSound((double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D, SoundEvents.PORTAL_AMBIENT, SoundSource.BLOCKS, 0.5F, random.nextFloat() * 0.4F + 0.8F, false);
        }

        for (int i = 0; i < 4; ++i) {
            double d = (double) pos.getX() + random.nextDouble();
            double e = (double) pos.getY() + random.nextDouble();
            double f = (double) pos.getZ() + random.nextDouble();
            double g = ((double) random.nextFloat() - 0.5D) * 0.5D;
            double h = ((double) random.nextFloat() - 0.5D) * 0.5D;
            double j = ((double) random.nextFloat() - 0.5D) * 0.5D;
            int k = random.nextInt(2) * 2 - 1;
            if (!world.getBlockState(pos.west()).is(this) && !world.getBlockState(pos.east()).is(this)) {
                d = (double) pos.getX() + 0.5D + 0.25D * (double) k;
                g = random.nextFloat() * 2.0F * (float) k;
            } else {
                f = (double) pos.getZ() + 0.5D + 0.25D * (double) k;
                j = random.nextFloat() * 2.0F * (float) k;
            }
            world.addParticle(new BlockParticleOption(LirothParticles.CUSTOMPORTALPARTICLE.get(), getPortalBase(world, pos).defaultBlockState()), d, e, f, g, h, j);
        }
    }


    @Override
    public void entityInside(BlockState state, Level world, BlockPos pos, Entity entity) {
        EntityInCustomPortal entityInPortal = (EntityInCustomPortal) entity;
        entityInPortal.tickInPortal(pos.immutable());
        if (!entityInPortal.didTeleport()) {
            if (entityInPortal.getTimeInPortal() >= entity.getPortalWaitTime()) {
                entityInPortal.setDidTP(true);
                if (!world.isClientSide)
                    CustomTeleporter.TPToDim(world, entity, getPortalBase(world, pos), pos);
            }
        }
    }

    public Block getPortalBase(Level world, BlockPos pos) {
        return CustomPortalHelper.getPortalBaseDefault(world, pos);
    }
}