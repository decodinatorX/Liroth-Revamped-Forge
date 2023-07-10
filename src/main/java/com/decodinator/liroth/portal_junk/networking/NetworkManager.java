package com.decodinator.liroth.portal_junk.networking;

import com.decodinator.liroth.Liroth;
import com.google.common.collect.ImmutableList;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

import java.util.function.BiConsumer;

public class NetworkManager {
    private static final String PROTOCOL_VERSION = "1.6";
    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(Liroth.MOD_ID, "main"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals
    );
    private static int nextId = 0;

    public static void register() {
        ImmutableList.<BiConsumer<SimpleChannel, Integer>>builder()
                .add(ForcePlacePortalPacket::register)
                .add(PortalRegistrySyncPacket::register)
                .build().forEach(consumer -> consumer.accept(INSTANCE, getNextId()));
    }


    private static int getNextId() {
        return nextId++;
    }


}