package com.decodinator.liroth;


import net.minecraftforge.common.ForgeConfigSpec;

public class LirothConfig {

    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final LirothConfig CONFIG = new LirothConfig(BUILDER);

    public static final ForgeConfigSpec SPEC = BUILDER.build();

    // DO NOT DELETE THIS, IT IS THE TRUE/FALSE BOOLEAN FOR THE TITLE SCREEN  pls
    public final ForgeConfigSpec.BooleanValue titleScreen;

    public LirothConfig(ForgeConfigSpec.Builder builder) {
        builder.push("Liroth Revamped Config");

        titleScreen = builder
                .define("titleScreen", true);

        builder.pop();
    }
}
