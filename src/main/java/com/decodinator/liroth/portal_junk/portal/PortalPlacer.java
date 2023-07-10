package com.decodinator.liroth.portal_junk.portal;

import net.minecraft.BlockUtil.FoundRectangle;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.border.WorldBorder;
import java.util.Optional;

import com.decodinator.liroth.portal_junk.CustomPortalApiRegistry;
import com.decodinator.liroth.portal_junk.portal.frame.PortalFrameTester;
import com.decodinator.liroth.portal_junk.util.CustomPortalHelper;
import com.decodinator.liroth.portal_junk.util.PortalLink;

public class PortalPlacer {
    public static boolean attemptPortalLight(Level world, BlockPos portalPos, PortalIgnitionSource ignitionSource) {
        return attemptPortalLight(world, portalPos, CustomPortalHelper.getClosestFrameBlock(world, portalPos), ignitionSource);
    }

    public static boolean attemptPortalLight(Level world, BlockPos portalPos, BlockPos framePos, PortalIgnitionSource ignitionSource) {
        Block foundationBlock = world.getBlockState(framePos).getBlock();
        PortalLink link = CustomPortalApiRegistry.getPortalLinkFromBase(foundationBlock);

        if (link == null || !link.doesIgnitionMatch(ignitionSource) || !link.canLightInDim(world.dimension().location()))
            return false;
        return createPortal(link, world, portalPos, foundationBlock);
    }

    private static boolean createPortal(PortalLink link, Level world, BlockPos pos, Block foundationBlock) {
        Optional<PortalFrameTester> optional = link.getFrameTester().createInstanceOfPortalFrameTester().getNewPortal(world, pos, Direction.Axis.X, foundationBlock);
        //is valid frame, and is correct size(if applicable)
        if (optional.isPresent()) {
            if (optional.get().isRequestedSize(link.forcedWidth, link.forcedHeight))
                optional.get().lightPortal(foundationBlock);
            return true;
        }
        return false;
    }

    public static Optional<FoundRectangle> createDestinationPortal(Level world, BlockPos blockPos, BlockState frameBlock, Direction.Axis axis) {
        WorldBorder worldBorder = world.getWorldBorder();
        PortalLink link = CustomPortalApiRegistry.getPortalLinkFromBase(frameBlock.getBlock());
        PortalFrameTester portalFrameTester = link.getFrameTester().createInstanceOfPortalFrameTester();
        for (BlockPos.MutableBlockPos mutable : BlockPos.spiralAround(blockPos, 16, Direction.WEST, Direction.SOUTH)) {
            BlockPos testingPos = mutable.immutable();
            if (!worldBorder.isWithinBounds(testingPos)) continue;

            int solidY = Math.min(world.getMaxBuildHeight(), world.getMinBuildHeight() + world.dimensionType().height()) - 5;
            BlockPos pos = null;
            while (solidY >= 3) {
                if (canHoldPortal(world.getBlockState(testingPos.atY(solidY)))) {
                    BlockPos testRect = portalFrameTester.doesPortalFitAt(world, testingPos.atY(solidY + 1), axis);
                    if (testRect != null) {
                        pos = testRect;
                        break;
                    }
                }
                solidY--;
            }

            if (pos != null) {
                portalFrameTester.createPortal(world, pos, frameBlock, axis);
                return Optional.of(portalFrameTester.getRectangle());
            }
        }
        portalFrameTester.createPortal(world, blockPos, frameBlock, axis);
        return Optional.of(portalFrameTester.getRectangle());
    }

    private static boolean canHoldPortal(BlockState state) {
        return state.m_280296_();
    }
}