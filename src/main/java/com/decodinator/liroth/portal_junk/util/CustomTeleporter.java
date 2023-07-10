package com.decodinator.liroth.portal_junk.util;

import net.minecraft.BlockUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.border.WorldBorder;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.portal.PortalInfo;
import net.minecraft.world.phys.Vec3;
import java.util.Optional;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.portal_junk.CustomPortalApiRegistry;
import com.decodinator.liroth.portal_junk.portal.PortalPlacer;
import com.decodinator.liroth.portal_junk.portal.frame.PortalFrameTester;
import com.decodinator.liroth.portal_junk.portal.linking.DimensionalBlockPos;

import com.decodinator.liroth.portal_junk.interfaces.CustomTeleportingEntity;

public class CustomTeleporter {

    public static void TPToDim(Level world, Entity entity, Block portalBase, BlockPos portalPos) {
        PortalLink link = CustomPortalApiRegistry.getPortalLinkFromBase(portalBase);
        if (link == null) return;
        if (link.getBeforeTPEvent().execute(entity) == SHOULDTP.CANCEL_TP)
            return;
        ResourceKey<Level> destKey = world.dimension() == Liroth.dims.get(link.dimID) ? Liroth.dims.get(link.returnDimID) : Liroth.dims.get(link.dimID);
        ServerLevel destination = ((ServerLevel) world).getServer().getLevel(destKey);
        if (destination == null) return;

        PortalInfo target = customTPTarget(destination, entity, portalPos, portalBase, link.getFrameTester());

        ((CustomTeleportingEntity) entity).setCustomTeleportTarget(target);
        entity = entity.changeDimension(destination);
        if (entity != null) {
            entity.setYRot(target.yRot);
            entity.setXRot(target.xRot);
            if (entity instanceof ServerPlayer)
                entity.moveTo(target.pos);
            link.executePostTPEvent(entity);
        }
    }


    public static PortalInfo customTPTarget(ServerLevel destinationWorld, Entity entity, BlockPos enteredPortalPos, Block frameBlock, PortalFrameTester.PortalFrameTesterFactory portalFrameTesterFactory) {
        Direction.Axis portalAxis = CustomPortalHelper.getAxisFrom(entity.getCommandSenderWorld().getBlockState(enteredPortalPos));
        BlockUtil.FoundRectangle fromPortalRectangle = portalFrameTesterFactory.createInstanceOfPortalFrameTester().init(entity.getCommandSenderWorld(), enteredPortalPos, portalAxis, frameBlock).getRectangle();
        DimensionalBlockPos destinationPos = Liroth.portalLinkingStorage.getDestination(fromPortalRectangle.minCorner, entity.getCommandSenderWorld().dimension());

        if (destinationPos != null && destinationPos.dimensionType.equals(destinationWorld.dimension().location())) {
            PortalFrameTester portalFrameTester = portalFrameTesterFactory.createInstanceOfPortalFrameTester().init(destinationWorld, destinationPos.pos, portalAxis, frameBlock);
            if (portalFrameTester.isValidFrame()) {
                if (!portalFrameTester.isAlreadyLitPortalFrame()) {
                    portalFrameTester.lightPortal(frameBlock);
                }
                return portalFrameTester.getTPTargetInPortal(portalFrameTester.getRectangle(), portalAxis, portalFrameTester.getEntityOffsetInPortal(fromPortalRectangle, entity, portalAxis), entity);
            }
        }
        return createDestinationPortal(destinationWorld, entity, portalAxis, fromPortalRectangle, frameBlock.defaultBlockState());
    }

    public static PortalInfo createDestinationPortal(ServerLevel destination, Entity entity, Direction.Axis axis, BlockUtil.FoundRectangle portalFramePos, BlockState frameBlock) {
        WorldBorder worldBorder = destination.getWorldBorder();
        double xMin = Math.max(-2.9999872E7D, worldBorder.getMinX() + 16.0D);
        double zMin = Math.max(-2.9999872E7D, worldBorder.getMinZ() + 16.0D);
        double xMax = Math.min(2.9999872E7D, worldBorder.getMaxX() - 16.0D);
        double zMax = Math.min(2.9999872E7D, worldBorder.getMaxZ() - 16.0D);
        double scaleFactor = DimensionType.getTeleportationScale(entity.getCommandSenderWorld().dimensionType(), destination.dimensionType());
        BlockPos blockPos3 = new BlockPos((int) Mth.clamp(entity.getX() * scaleFactor, xMin, xMax), (int) entity.getY(), (int) Mth.clamp(entity.getZ() * scaleFactor, zMin, zMax));
        Optional<BlockUtil.FoundRectangle> portal = PortalPlacer.createDestinationPortal(destination, blockPos3, frameBlock, axis);
        if (portal.isPresent()) {
            PortalFrameTester portalFrameTester = CustomPortalApiRegistry.getPortalLinkFromBase(frameBlock.getBlock()).getFrameTester().createInstanceOfPortalFrameTester();

            Liroth.portalLinkingStorage.createLink(portalFramePos.minCorner, entity.getCommandSenderWorld().dimension(), portal.get().minCorner, destination.dimension());
            return portalFrameTester.getTPTargetInPortal(portal.get(), axis, portalFrameTester.getEntityOffsetInPortal(portalFramePos, entity, axis), entity);
        }
        return idkWhereToPutYou(destination, entity, blockPos3);
    }


    protected static PortalInfo idkWhereToPutYou(ServerLevel world, Entity entity, BlockPos pos) {
    	Liroth.logError("Unable to find tp location, forced to place on top of world");
        BlockPos destinationPos = world.getHeightmapPos(Heightmap.Types.WORLD_SURFACE, pos);
        return new PortalInfo(new Vec3(destinationPos.getX() + .5, destinationPos.getY(), destinationPos.getZ() + .5), entity.getDeltaMovement(), entity.getYRot(), entity.getXRot());
    }
}