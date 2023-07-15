package com.decodinator.liroth;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import org.apache.logging.log4j.Logger;

import com.decodinator.liroth.proxy.CommonProxy;
import com.decodinator.liroth.util.handlers.RegistryHandler;

@Mod(modid = Liroth.MODID, name = Liroth.NAME, version = Liroth.VERSION)
public class Liroth
{
    public static final String MODID = "liroth";
    public static final String NAME = "Liroth Revamped";
    public static final String VERSION = "1.0";
	public static final String CLIENT_PROXY_CLASS = "com.decodinator.liroth.proxy.ClientProxy";
	public static final String COMMON_PROXY_CLASS = "com.decodinator.liroth.proxy.CommonProxy";
    
	@SidedProxy(clientSide = CLIENT_PROXY_CLASS, serverSide = COMMON_PROXY_CLASS)
	public static CommonProxy proxy;

    @SuppressWarnings("unused")
	private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
		RegistryHandler.preInitRegistries(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		RegistryHandler.initRegistries();
    }
    
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		RegistryHandler.postInitRegistries();
	}
	
	@EventHandler
	public void serverInit(FMLServerStartingEvent event)
	{
		RegistryHandler.serverRegistries(event);
	}
}
