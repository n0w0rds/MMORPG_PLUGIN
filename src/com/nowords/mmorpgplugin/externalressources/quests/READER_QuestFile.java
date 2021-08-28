package com.nowords.mmorpgplugin.externalressources.quests;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.nowords.mmorpgplugin.jobs.ENUM_Jobs;

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
	public String getName() {return this.QuestFile.getString("name");}
	
	//Is the quest linear
	public boolean get_isLinear() {return Boolean.parseBoolean((this.QuestFile.getString("is_linear")));}
	
	
	//Get Prerequisites Job
	public ENUM_Jobs getPrerequisiteJob() {return ENUM_Jobs.valueOf(this.QuestFile.getString("prerequisite.job"));}
	
	
	//Check Prerequisites
	public boolean check_prerequisites(int LEVEL) {
		boolean IS_VALID = false;
		int READ_LEVEL = Integer.parseInt(this.QuestFile.getString("prerequisite.level"));
		
		//If there is no prerequisite or the player's level is high enough 
		if(this.QuestFile.getString("prerequisite.job").equals("null") || READ_LEVEL <= LEVEL) {
			IS_VALID = true;
		}
			
		return IS_VALID;
	}
	
	
	//Get the ammount of steps
	public int getAmmountStep() {return this.QuestFile.getConfigurationSection("steps").getKeys(false).size();}
	
	
	//Get a specific step's task
	public String getStepTask(int STEP_INDEX) {return this.QuestFile.getString("steps." +STEP_INDEX+ ".task");}
		
	
	//Get a specific step's location
	public Location getStepLocation(int STEP_INDEX, Player player) {
		
		int x = Integer.parseInt(this.QuestFile.getString("steps." +STEP_INDEX+ ".x"));
		int y = Integer.parseInt(this.QuestFile.getString("steps." +STEP_INDEX+ ".y"));
		int z = Integer.parseInt(this.QuestFile.getString("steps." +STEP_INDEX+ ".z"));
		
		return new Location(player.getWorld(), x, y, z);
	}
		
	//Get a specific step's Action type
	


	//Get a specific step's Action target
		
		
	//Get a specific step's item to give
		
	
	//Get the REWARDS
	
	
	//Get the next QUESTS
	
	
	//Get the Story Line INFOS
	
	
	//---------------------------------------
	//GET
	//---------------------------------------
	public FileConfiguration getFile() {return QuestFile;}
	
	
}
