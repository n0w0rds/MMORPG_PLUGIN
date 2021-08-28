package com.nowords.mmorpgplugin.externalressources.quests;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class READER_QuestFile {
	
	private File file;
	private FileConfiguration QuestFile;
	
	//Setup the file access
	public READER_QuestFile(String FILE_NAME) {
		try {
			file = new File(Bukkit.getServer().getPluginManager().getPlugin("MMORPGPLUGIN").getDataFolder(),FILE_NAME);
			//Create the file if doesn't exist
			if(!file.exists()){
				file.createNewFile();
				
			}
			
			//Load the configuration
			QuestFile = YamlConfiguration.loadConfiguration(file);
		} catch (Exception e) {
			// TODO: handle exception
		}
			
	}
	
	//---------------------------------------
	//FUNCTION
	//---------------------------------------
	
	//Save the file modifications
	public void save(){try {QuestFile.save(file);} catch (Exception e) {}}
		
	//Reload the file
	public void reload() {QuestFile = YamlConfiguration.loadConfiguration(file);}
	
	
	
	
	
	
	//Read the ID
	public int getId() {
		int QUEST_ID = 0;
		
		//Make sure it is an Integer
		try {
			QUEST_ID = Integer.parseInt(this.QuestFile.getString("id"));
		} catch (Exception e) {
			System.out.println("LOADING ERROR -> INVALID QUEST ID");
		}
		return QUEST_ID;
	}
	
	
	//Read the NAME
	
	
	//Is the quest linear
	
	
	//Check Prerequisites
	
	
	//Get the ammount of steps
	
	
	//Get a specific step's infos
	
	
	//Get the REWARDS
	
	
	//Get the next QUESTS
	
	
	//Get the Story Line INFOS
	
	
	//---------------------------------------
	//GET
	//---------------------------------------
	public FileConfiguration getFile() {return QuestFile;}
	
	
}
