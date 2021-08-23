package com.nowords.mmorpgplugin;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.nowords.mmorpgplugin.commands.ADMIN_COMMAND_MANAGER;
import com.nowords.mmorpgplugin.entities.NPC;

public class Main extends JavaPlugin{
	
	public HashMap<String, NPC> NPC_LIST = new HashMap<>();
	
	@Override
	public void onEnable() {
		getCommand("Admin").setExecutor(new ADMIN_COMMAND_MANAGER(this));
	}
}
