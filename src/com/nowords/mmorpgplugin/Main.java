package com.nowords.mmorpgplugin;

import java.io.IOException;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import com.nowords.mmorpgplugin.commands.ADMIN_COMMAND_MANAGER;
import com.nowords.mmorpgplugin.entities.customentity.NPC;
import com.nowords.mmorpgplugin.events.LISTENER_Player;
import com.nowords.mmorpgplugin.externalressources.quests.READER_QuestFile;
import com.nowords.mmorpgplugin.externalressources.textures.MANAGER_Texture;

public class Main extends JavaPlugin{
	
	public HashMap<String, NPC> NPC_LIST = new HashMap<>();
	public MANAGER_Texture TEXTURE_LIST = new MANAGER_Texture(this);
	
	@Override
	public void onEnable() {
		getCommand("npc").setExecutor(new ADMIN_COMMAND_MANAGER(this));
		Bukkit.getPluginManager().registerEvents(new LISTENER_Player(this), this);
		
		//Setup config
		getConfig().options().copyDefaults();
		saveDefaultConfig();
		
		////////TEST
		
		READER_QuestFile file = new READER_QuestFile("quest_test.yml");
		file.getFile().options().copyDefaults(true);
		file.save();
		System.out.println(file.getId() + "\n" + file.get_isLinear() + "\n" + file.getRewards());
		
	}
}
