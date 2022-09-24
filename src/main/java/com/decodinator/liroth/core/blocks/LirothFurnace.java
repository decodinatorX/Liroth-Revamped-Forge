package com.decodinator.liroth.core.blocks;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.Nullable;

import com.decodinator.liroth.core.LirothBlockEntities;
import com.decodinator.liroth.core.LirothBlocks;
import com.decodinator.liroth.core.LirothParticles;
import com.decodinator.liroth.core.blocks.entities.LirothFurnaceBlockEntity;
import com.decodinator.liroth.core.helpers.BasePatterns;
import com.decodinator.liroth.core.helpers.BlockModelProvider;
import com.decodinator.liroth.core.helpers.ModelsHelper;
import com.decodinator.liroth.core.helpers.PatternsHelper;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.resources.model.UnbakedModel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FurnaceBlock;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;

public class LirothFurnace extends FurnaceBlock implements BlockModelProvider {
    public LirothFurnace(Block source) {
        this(Properties.copy(source).lightLevel(state -> state.getValue(LIT) ? 13 : 0));
    }

    public LirothFurnace(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new LirothFurnaceBlockEntity(blockPos, blockState);
    }

    @Override
    protected void openContainer(Level world, BlockPos pos, Player player) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof LirothFurnaceBlockEntity) {
            player.openMenu((MenuProvider) blockEntity);
            player.awardStat(Stats.INTERACT_WITH_FURNACE);
        }
    }

    @Override
    public @Nullable BlockModel getBlockModel(ResourceLocation blockId, BlockState blockState) {
        String blockName = blockId.getPath();
        Map<String, String> textures = Maps.newHashMap();
        textures.put("%modid%", blockId.getNamespace());
        textures.put("%top%", blockName + "_top");
        textures.put("%side%", blockName + "_side");
        Optional<String> pattern;
        if (blockState.getValue(LIT)) {
            textures.put("%front%", blockName + "_front_on");
            textures.put("%glow%", blockName + "_glow");
            pattern = PatternsHelper.createJson(BasePatterns.BLOCK_FURNACE_LIT, textures);
        } else {
            textures.put("%front%", blockName + "_front");
            pattern = PatternsHelper.createJson(BasePatterns.BLOCK_FURNACE, textures);
        }
        return ModelsHelper.fromPattern(pattern);
    }

    @Override
    public BlockModel getItemModel(ResourceLocation resourceLocation) {
        return getBlockModel(resourceLocation, defaultBlockState());
    }

    @Override
    public UnbakedModel getModelVariant(
            ResourceLocation stateId,
            BlockState blockState,
            Map<ResourceLocation, UnbakedModel> modelCache
    ) {
        String lit = blockState.getValue(LIT) ? "_lit" : "";
        ResourceLocation modelId = new ResourceLocation(stateId.getNamespace(), "block/" + stateId.getPath() + lit);
        registerBlockModel(stateId, modelId, blockState, modelCache);
        return ModelsHelper.createFacingModel(modelId, blockState.getValue(FACING), false, true);
    }

    @Override
    @SuppressWarnings("deprecation")
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        List<ItemStack> drop = Lists.newArrayList(new ItemStack(this));
        BlockEntity blockEntity = builder.getOptionalParameter(LootContextParams.BLOCK_ENTITY);
        if (blockEntity instanceof LirothFurnaceBlockEntity) {
        	LirothFurnaceBlockEntity entity = (LirothFurnaceBlockEntity) blockEntity;
            for (int i = 0; i < entity.getContainerSize(); i++) {
                drop.add(entity.getItem(i));
            }
        }
        return drop;
    }

    @Override
    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(
            Level level,
            BlockState blockState,
            BlockEntityType<T> blockEntityType
    ) {
        return createFurnaceTicker(level, blockEntityType, LirothBlockEntities.LIROTH_FURNACE.get());
    }

    @Nullable
    protected static <T extends BlockEntity> BlockEntityTicker<T> createFurnaceTicker(
            Level level,
            BlockEntityType<T> blockEntityType,
            BlockEntityType<? extends AbstractFurnaceBlockEntity> blockEntityType2
    ) {
        return level.isClientSide ? null : createTickerHelper(
                blockEntityType,
                blockEntityType2,
                AbstractFurnaceBlockEntity::serverTick
        );
    }
    
    @Override
    public void animateTick(BlockState p_221253_, Level p_221254_, BlockPos p_221255_, RandomSource p_221256_) {
        if (p_221253_.getValue(LIT)) {
           double d0 = (double)p_221255_.getX() + 0.5D;
           double d1 = (double)p_221255_.getY();
           double d2 = (double)p_221255_.getZ() + 0.5D;
           if (p_221256_.nextDouble() < 0.1D) {
              p_221254_.playLocalSound(d0, d1, d2, SoundEvents.FURNACE_FIRE_CRACKLE, SoundSource.BLOCKS, 1.0F, 1.0F, false);
           }

           Direction direction = p_221253_.getValue(FACING);
           Direction.Axis direction$axis = direction.getAxis();
           double d3 = 0.52D;
           double d4 = p_221256_.nextDouble() * 0.6D - 0.3D;
           double d5 = direction$axis == Direction.Axis.X ? (double)direction.getStepX() * 0.52D : d4;
           double d6 = p_221256_.nextDouble() * 6.0D / 16.0D;
           double d7 = direction$axis == Direction.Axis.Z ? (double)direction.getStepZ() * 0.52D : d4;
           p_221254_.addParticle(ParticleTypes.SMOKE, d0 + d5, d1 + d6, d2 + d7, 0.0D, 0.0D, 0.0D);
           p_221254_.addParticle(LirothParticles.PURPLE_FLAME.get(), d0 + d5, d1 + d6, d2 + d7, 0.0D, 0.0D, 0.0D);
        }
     }
}