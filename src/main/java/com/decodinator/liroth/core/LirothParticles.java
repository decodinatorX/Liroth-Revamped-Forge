package com.decodinator.liroth.core;

import com.decodinator.liroth.Liroth;

import net.minecraft.client.particle.Particle;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistry;
import net.minecraftforge.registries.RegistryObject;

public class LirothParticles {
	
	public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, Liroth.MOD_ID);

	public static final RegistryObject<SimpleParticleType> PURPLE_FLAME = PARTICLES.register("purple_flame", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> GREEN_FLAME = PARTICLES.register("green_flame", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> CLOAK = PARTICLES.register("cloak", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> SPORE = PARTICLES.register("green_spore", () -> new SimpleParticleType(true));
}
