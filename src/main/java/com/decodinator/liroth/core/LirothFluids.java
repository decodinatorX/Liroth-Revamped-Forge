package com.decodinator.liroth.core;

import java.util.function.Supplier;

import com.decodinator.liroth.Liroth;

import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.WaterFluid;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class LirothFluids {

	public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, Liroth.MOD_ID);
	
	public static final RegistryObject<FlowingFluid> LIROTH_FLUID = FLUIDS.register("liroth_fluid", () -> new ForgeFlowingFluid.Source(Liroth.LIROTH_FLUID_PROPERTIES));
	public static final RegistryObject<FlowingFluid> FLOWING_LIROTH_FLUID = FLUIDS.register("flowing_liroth_fluid", () -> new ForgeFlowingFluid.Flowing(Liroth.LIROTH_FLUID_PROPERTIES));
	public static final RegistryObject<FlowingFluid> MOLTEN_SPINERIOS = FLUIDS.register("molten_spinerios", () -> new ForgeFlowingFluid.Source(Liroth.MOLTEN_SPINERIOS_PROPERTIES));
	public static final RegistryObject<FlowingFluid> FLOWING_MOLTEN_SPINERIOS = FLUIDS.register("flowing_molten_spinerios", () -> new ForgeFlowingFluid.Flowing(Liroth.MOLTEN_SPINERIOS_PROPERTIES));
	
}
