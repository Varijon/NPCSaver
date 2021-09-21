package com.varijon.tinies.NPCSaver;

import java.io.File;
import java.io.FileWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pixelmonmod.pixelmon.entities.npcs.EntityNPC;
import com.pixelmonmod.pixelmon.entities.npcs.NPCChatting;
import com.pixelmonmod.pixelmon.entities.npcs.NPCNurseJoy;
import com.pixelmonmod.pixelmon.entities.npcs.NPCRelearner;
import com.pixelmonmod.pixelmon.entities.npcs.NPCShopkeeper;
import com.pixelmonmod.pixelmon.entities.npcs.NPCTrader;
import com.pixelmonmod.pixelmon.entities.npcs.NPCTrainer;
import com.pixelmonmod.pixelmon.entities.npcs.NPCTutor;
import com.pixelmonmod.pixelmon.entities.pixelmon.EntityPixelmon;
import com.pixelmonmod.pixelmon.enums.EnumNPCType;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class NPCSaverHandler 
{
	@SubscribeEvent
	public void onNPCSpawn(EntityJoinWorldEvent event)
	{	
		if(event.getEntity() instanceof EntityNPC)
		{
			EntityNPC npc = (EntityNPC) event.getEntity();
			if(!npc.writeToNBT(new NBTTagCompound()).getBoolean("IsPersistent"))
			{
				return;
			}
			if(npc instanceof NPCShopkeeper)
			{
				writeNPCData(npc,"ShopKeeper");				
			}
			if(npc instanceof NPCChatting)
			{
				writeNPCData(npc,"Chatting");				
			}
			if(npc instanceof NPCRelearner)
			{
				writeNPCData(npc,"Relearner");				
			}
			if(npc instanceof NPCTutor)
			{
				writeNPCData(npc,"Tutor");				
			}
			if(npc instanceof NPCTrainer)
			{
				writeNPCData(npc,"Trainer");							
			}
			if(npc instanceof NPCTrader)
			{
				writeNPCData(npc,"Trader");							
			}
			if(npc instanceof NPCNurseJoy)
			{
				writeNPCData(npc,"Nurse");							
			}
		}
	}
	
	public static void writeNPCData(EntityNPC npc, String type)
	{
		String basefolder = new File("").getAbsolutePath();
        String source = basefolder + "/config/NPCSaver";
		
		try
		{
			File dir = new File(source);
			if(!dir.exists())
			{
				dir.mkdirs();
			}
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			
			NPCStore npcStore = new NPCStore(npc.writeToNBT(new NBTTagCompound()).toString(), type, npc.getUniqueID().toString(), npc.dimension);
			
			FileWriter writer = new FileWriter(source + "/" + npc.getUniqueID() + ".json");
			gson.toJson(npcStore, writer);
			writer.close();
		}
			
		catch (Exception ex) 
		{
		    ex.printStackTrace();
		}
	}
}
