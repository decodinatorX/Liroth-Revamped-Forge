package com.decodinator.liroth;


import net.minecraftforge.common.ForgeConfigSpec;

public class LirothConfig {

    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final LirothConfig CONFIG = new LirothConfig(BUILDER);

    public static final ForgeConfigSpec SPEC = BUILDER.build();

    public final ForgeConfigSpec.BooleanValue titleScreen;

    public LirothConfig(ForgeConfigSpec.Builder builder) {
        builder.push("Liroth Revamped Config");

        titleScreen = builder
                .define("titleScreen", true);

        builder.pop();
    }
}