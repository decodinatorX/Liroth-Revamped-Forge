package com.decodinator.liroth.core;

import com.decodinator.liroth.Liroth;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class LirothSounds {
	public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Liroth.MOD_ID);
	
//    public static final ResourceLocation LIROTH_BLASTER_FIRING_SOUND_ID = new ResourceLocation("liroth:liroth_blaster_firing");
//    public static SoundEvent LIROTH_BLASTER_FIRING_SOUND_EVENT = new SoundEvent(LIROTH_BLASTER_FIRING_SOUND_ID);
    
    public static final RegistryObject<SoundEvent> LIROTH_BLASTER_FIRING = registerSoundEvent("liroth_blaster_firing");
    
    // Fungal Fiend
//    public static final ResourceLocation FUNGAL_FIEND_DEATH_SOUND_ID = new ResourceLocation("liroth:fungal_fiend_death");
//    public static SoundEvent FUNGAL_FIEND_DEATH_SOUND_EVENT = new SoundEvent(FUNGAL_FIEND_DEATH_SOUND_ID);    
//    public static final ResourceLocation FUNGAL_FIEND_HURT_SOUND_ID = new ResourceLocation("liroth:fungal_fiend_hurt");
//    public static SoundEvent FUNGAL_FIEND_HURT_SOUND_EVENT = new SoundEvent(FUNGAL_FIEND_HURT_SOUND_ID);
//    public static final ResourceLocation FUNGAL_FIEND_FUSE_SOUND_ID = new ResourceLocation("liroth:fungal_fiend_fuse");
//    public static SoundEvent FUNGAL_FIEND_FUSE_SOUND_EVENT = new SoundEvent(FUNGAL_FIEND_FUSE_SOUND_ID);
    
    public static final RegistryObject<SoundEvent> FUNGAL_FIEND_DEATH = registerSoundEvent("fungal_fiend_death");
    public static final RegistryObject<SoundEvent> FUNGAL_FIEND_HURT = registerSoundEvent("fungal_fiend_hurt");
    public static final RegistryObject<SoundEvent> FUNGAL_FIEND_FUSE = registerSoundEvent("fungal_fiend_fuse");
    
    // Warp
//    public static final ResourceLocation WARP_DEATH_SOUND_ID = new ResourceLocation("liroth:warp_death");
//    public static SoundEvent WARP_DEATH_SOUND_EVENT = new SoundEvent(WARP_DEATH_SOUND_ID);    
//    public static final ResourceLocation WARP_HURT_SOUND_ID = new ResourceLocation("liroth:warp_hurt");
//    public static SoundEvent WARP_HURT_SOUND_EVENT = new SoundEvent(WARP_HURT_SOUND_ID);
//    public static final ResourceLocation WARP_IDLE_SOUND_ID = new ResourceLocation("liroth:warp_idle");
//    public static SoundEvent WARP_IDLE_SOUND_EVENT = new SoundEvent(WARP_IDLE_SOUND_ID);
    
    public static final RegistryObject<SoundEvent> WARP_DEATH = registerSoundEvent("warp_death");
    public static final RegistryObject<SoundEvent> WARP_HURT = registerSoundEvent("warp_hurt");
    public static final RegistryObject<SoundEvent> WARP_IDLE = registerSoundEvent("warp_idle");
    
    // Shade
//    public static final ResourceLocation SHADE_DEATH_SOUND_ID = new ResourceLocation("liroth:shade_death");
//    public static SoundEvent SHADE_DEATH_SOUND_EVENT = new SoundEvent(SHADE_DEATH_SOUND_ID);    
//    public static final ResourceLocation SHADE_HURT_SOUND_ID = new ResourceLocation("liroth:shade_hurt");
//    public static SoundEvent SHADE_HURT_SOUND_EVENT = new SoundEvent(SHADE_HURT_SOUND_ID);
//    public static final ResourceLocation SHADE_IDLE_SOUND_ID = new ResourceLocation("liroth:shade_idle");
//    public static SoundEvent SHADE_IDLE_SOUND_EVENT = new SoundEvent(SHADE_IDLE_SOUND_ID);
    
    public static final RegistryObject<SoundEvent> SHADE_DEATH = registerSoundEvent("shade_death");
    public static final RegistryObject<SoundEvent> SHADE_HURT = registerSoundEvent("shade_hurt");
    public static final RegistryObject<SoundEvent> SHADE_IDLE = registerSoundEvent("shade_idle");
    
    // AMS - C418
//    public static final ResourceLocation LIROTH_BIOME_MUSIC_SOUND_ID = new ResourceLocation("liroth:music.liroth.liroth_biome");
//    public static SoundEvent LIROTH_BIOME_MUSIC_SOUND_EVENT = new SoundEvent(LIROTH_BIOME_MUSIC_SOUND_ID);
    
    public static final RegistryObject<SoundEvent> LIROTH_BIOME = registerSoundEvent("music.liroth.liroth_biome");
    
    // ATX - C418
//    public static final ResourceLocation TALLPIER_BIOME_MUSIC_SOUND_ID = new ResourceLocation("liroth:music.liroth.tallpier_biome");
//    public static SoundEvent TALLPIER_BIOME_MUSIC_SOUND_EVENT = new SoundEvent(TALLPIER_BIOME_MUSIC_SOUND_ID);
    
    public static final RegistryObject<SoundEvent> TALLPIER_BIOME = registerSoundEvent("music.liroth.tallpier_biome");
    
    // Fake Triplets - C418
//    public static final ResourceLocation SPICED_DESERT_MUSIC_SOUND_ID = new ResourceLocation("liroth:music.liroth.spiced_desert");
//    public static SoundEvent SPICED_DESERT_MUSIC_SOUND_EVENT = new SoundEvent(SPICED_DESERT_MUSIC_SOUND_ID);
    
    public static final RegistryObject<SoundEvent> SPICED_DESERT = registerSoundEvent("music.liroth.spiced_desert");
    
    // Home - C418
//    public static final ResourceLocation DAMNATION_MUSIC_SOUND_ID = new ResourceLocation("liroth:music.liroth.damnation");
//    public static SoundEvent DAMNATION_MUSIC_SOUND_EVENT = new SoundEvent(DAMNATION_MUSIC_SOUND_ID);
    
    public static final RegistryObject<SoundEvent> DAMNATION = registerSoundEvent("music.liroth.damnation");
    
    // Hope - C418
//    public static final ResourceLocation ESCAPE_MUSIC_SOUND_ID = new ResourceLocation("liroth:music.liroth.escape");
//    public static SoundEvent ESCAPE_MUSIC_SOUND_EVENT = new SoundEvent(ESCAPE_MUSIC_SOUND_ID);
    
    public static final RegistryObject<SoundEvent> ESCAPE = registerSoundEvent("music.liroth.escape");
    
    // Keighley - C418
//    public static final ResourceLocation JALSPHIRE_MUSIC_SOUND_ID = new ResourceLocation("liroth:music.liroth.jalsphire");
//    public static SoundEvent JALSPHIRE_MUSIC_SOUND_EVENT = new SoundEvent(JALSPHIRE_MUSIC_SOUND_ID);
    
    public static final RegistryObject<SoundEvent> JALSPHIRE = registerSoundEvent("music.liroth.jalsphire");
    
    // Impostor Syndrome - C418
//    public static final ResourceLocation DESOLATE_MUSIC_SOUND_ID = new ResourceLocation("liroth:music.liroth.desolate");
//    public static SoundEvent DESOLATE_MUSIC_SOUND_EVENT = new SoundEvent(DESOLATE_MUSIC_SOUND_ID);    

    public static final RegistryObject<SoundEvent> DESOLATE = registerSoundEvent("music.liroth.desolate");
    
    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
    	return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Liroth.MOD_ID, name)));
    }
    
    public static void register(IEventBus eventBus) {
    	SOUND_EVENTS.register(eventBus);
    }
    
    public static void init() {
    }
}
