package com.decodinator.liroth;

import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import javax.swing.*;

// I hate setting up configs apparently  pls

public class LirothConfigGUI {

    public Screen getConfigScreen(Screen parent, boolean isTrans) {

        ConfigBuilder builder = ConfigBuilder.create().setParentScreen(parent).setTitle(Component.translatable("text.config.liroth.title"));
        builder.setDefaultBackgroundTexture(new ResourceLocation("liroth:textures/block/liroth_dirt.png"));
        ConfigCategory general = builder.getOrCreateCategory(Component.literal("general"));
        ConfigEntryBuilder configEntryBuilder = builder.entryBuilder();

        general.addEntry(
                configEntryBuilder
                        .startBooleanToggle(Component.translatable("text.config.liroth.option.titlescreen"), LirothConfig.CONFIG.titleScreen.get())
                        .setDefaultValue(true)
                        .setSaveConsumer(LirothConfig.CONFIG.titleScreen::set)
                        .build()
        );
        return builder.setTransparentBackground(isTrans).build();
    }
}
