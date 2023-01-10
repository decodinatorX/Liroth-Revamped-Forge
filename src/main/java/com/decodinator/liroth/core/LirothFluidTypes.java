package com.decodinator.liroth.core;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.fluids.BaseFluidType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.common.SoundAction;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class LirothFluidTypes {
	public static final ResourceLocation LIROTH_FLUID_STILL = new ResourceLocation("liroth:blocks/liroth_fluid_still");
	public static final ResourceLocation LIROTH_FLUID_FLOWING = new ResourceLocation("liroth:blocks/liroth_fluid_flowing");
	public static final ResourceLocation MOLTEN_SPINERIOS_STILL = new ResourceLocation("liroth:blocks/molten_spinerios_still");
	public static final ResourceLocation MOLTEN_SPINERIOS_FLOWING = new ResourceLocation("liroth:blocks/molten_spinerios_flowing");
	
	public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, Liroth.MOD_ID);
	
	public static final RegistryObject<FluidType> LIROTH_FLUID_TYPE = registerLirothFluid("liroth_fluid", FluidType.Properties.create().lightLevel(0).density(15).viscosity(5).sound(SoundAction.get("drink"), SoundEvents.WATER_AMBIENT));
	public static final RegistryObject<FluidType> MOLTEN_SPINERIOS_TYPE = registerMoltenSpinerios("molten_spinerios", FluidType.Properties.create().lightLevel(0).density(15).viscosity(5).sound(SoundAction.get("drink"), SoundEvents.LAVA_AMBIENT));

	private static RegistryObject<FluidType> registerLirothFluid(String name, FluidType.Properties properties) {
		return FLUID_TYPES.register(name, () -> new BaseFluidType(LIROTH_FLUID_STILL, LIROTH_FLUID_FLOWING, properties));
	}
	
	private static RegistryObject<FluidType> registerMoltenSpinerios(String name, FluidType.Properties properties) {
		return FLUID_TYPES.register(name, () -> new BaseFluidType(MOLTEN_SPINERIOS_STILL, MOLTEN_SPINERIOS_FLOWING, properties));
	}
}
