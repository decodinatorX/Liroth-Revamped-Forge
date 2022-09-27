package com.decodinator.liroth.core.blocks;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.level.block.WallTorchBlock;
import net.minecraftforge.registries.RegistryObject;

public class CustomWallTorchBlock extends WallTorchBlock {

	public CustomWallTorchBlock(Properties p_57491_, RegistryObject<SimpleParticleType> p_57492_) {
		super(p_57491_, p_57492_.get());
	}
}
