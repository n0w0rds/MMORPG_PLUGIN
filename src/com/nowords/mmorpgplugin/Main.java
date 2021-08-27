package com.nowords.mmorpgplugin;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.nowords.mmorpgplugin.commands.ADMIN_COMMAND_MANAGER;
import com.nowords.mmorpgplugin.entities.NPC;
import com.nowords.mmorpgplugin.events.LISTENER_Player;
import com.nowords.mmorpgplugin.externalressources.MANAGER_Texture;

public class Main extends JavaPlugin{
	
	public HashMap<String, NPC> NPC_LIST = new HashMap<>();
	public MANAGER_Texture TEXTURE_LIST = new MANAGER_Texture(this);
	
	@Override
	public void onEnable() {
		getCommand("npc").setExecutor(new ADMIN_COMMAND_MANAGER(this));
		Bukkit.getPluginManager().registerEvents(new LISTENER_Player(this), this);
	}
}
