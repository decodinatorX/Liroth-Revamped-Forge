package com.decodinator.liroth.core;

import com.decodinator.liroth.Liroth;
import com.mojang.serialization.Codec;

import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class LirothParticles {
	
	public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, Liroth.MOD_ID);

	public static final RegistryObject<SimpleParticleType> PURPLE_FLAME = PARTICLES.register("purple_flame", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> GREEN_FLAME = PARTICLES.register("green_flame", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> CLOAK = PARTICLES.register("cloak", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> SPORE = PARTICLES.register("green_spore", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> LIROTH_PORTAL = PARTICLES.register("liroth_portal", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> DAMNATION_PORTAL = PARTICLES.register("damnation_portal", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> JANTIRO_PORTAL = PARTICLES.register("jantiro_portal", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> JALSPHIRE_PORTAL = PARTICLES.register("jalsphire_portal", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> DEVASTATED_PORTAL = PARTICLES.register("devastated_portal", () -> new SimpleParticleType(true));
    public static final RegistryObject<ParticleType<BlockParticleOption>> CUSTOMPORTALPARTICLE = PARTICLES.register("customportalparticle", () -> new ParticleType<BlockParticleOption>(false, BlockParticleOption.DESERIALIZER) {
        private Codec<BlockParticleOption> codec = BlockParticleOption.codec(this);
        @Override
        public Codec<BlockParticleOption> codec() {
            return codec;
        }
    });}
