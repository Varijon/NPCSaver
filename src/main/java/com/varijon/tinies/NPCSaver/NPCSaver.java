package com.varijon.tinies.NPCSaver;

import com.pixelmonmod.pixelmon.Pixelmon;

import net.minecraft.nbt.NBTException;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(modid="npcsaver", version="1.0.0", acceptableRemoteVersions="*")
public class NPCSaver
{
	public static String MODID = "modid";
	public static String VERSION = "version";
		
	@EventHandler
	public void preInit(FMLPreInitializationEvent e)
	{


	}
	
	@EventHandler
	public void init(FMLInitializationEvent e)
	{
		MinecraftForge.EVENT_BUS.register(new NPCSaverHandler());
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e)
	{
		
	}

	 @EventHandler
	 public void serverLoad(FMLServerStartingEvent event)
	 {
//		 event.registerServerCommand(new LastLegendSpawnCommand());
	 }

}