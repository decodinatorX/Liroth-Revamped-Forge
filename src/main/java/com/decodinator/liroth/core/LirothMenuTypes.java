package com.decodinator.liroth.core;

import com.decodinator.liroth.Liroth;
import com.decodinator.liroth.core.blocks.entities.LirothSplitterScreenHandler;
import com.decodinator.liroth.core.blocks.entities.QuantumExtractorScreenHandler;

import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class LirothMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.MENU_TYPES, Liroth.MOD_ID);

    public static final RegistryObject<MenuType<LirothSplitterScreenHandler>> LIROTH_SPLITTER_MENU =
            registerMenuType(LirothSplitterScreenHandler::new, "liroth_splitter");

    public static final RegistryObject<MenuType<QuantumExtractorScreenHandler>> QUANTUM_EXTRACTOR_MENU =
            registerMenuType(QuantumExtractorScreenHandler::new, "quantum_extractor");

    private static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>> registerMenuType(IContainerFactory<T> factory,
                                                                                                  String name) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }
}