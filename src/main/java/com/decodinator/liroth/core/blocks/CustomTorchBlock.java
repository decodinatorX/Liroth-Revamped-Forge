package com.decodinator.liroth.core.blocks;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.level.block.TorchBlock;
import net.minecraftforge.registries.RegistryObject;

public class CustomTorchBlock extends TorchBlock {

	public CustomTorchBlock(Properties p_57491_, RegistryObject<SimpleParticleType> p_57492_) {
		super(p_57491_, p_57492_.get());
	}
}
