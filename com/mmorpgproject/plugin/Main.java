package com.mmorpgproject.plugin;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.java.JavaPlugin;

import com.mmorpgproject.plugin.LISTENERS.LISTENER_customEntity;
import com.mmorpgproject.plugin.MANAGER.MANAGER_commands;
import com.mmorpgproject.plugin.MOBS.TEST;
import com.mmorpgproject.plugin.RUNNABLES.RUNNABLES_resetPitch;

public class Main extends JavaPlugin {
	
	public ArrayList<TEST> customEntities = new ArrayList<>();
	
	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new LISTENER_customEntity(this), this); //Register Entity Event
		RUNNABLES_resetPitch.setPitch(this); //Start Runables
		getCommand("npc").setExecutor(new MANAGER_commands(this)); //Set command executor
	}
}
