package com.nowords.mmorpgplugin;

import org.bukkit.plugin.java.JavaPlugin;

import com.nowords.mmorpgplugin.externalressources.TexturesAndModels;


public class Main extends JavaPlugin{
	
	public TexturesAndModels textures;
	
	@Override
	public void onEnable() {
		textures = new TexturesAndModels();
	}
}
