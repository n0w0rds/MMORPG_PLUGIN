package com.nowords.mmorpgplugin.externalressources.quests;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.nowords.mmorpgplugin.entities.enums.ENUM_EntitiesTypes;
import com.nowords.mmorpgplugin.jobs.ENUM_Jobs;
import com.nowords.mmorpgplugin.quests.ENUM_ActionTypes;

public class READER_QuestFile {
	
	private File 					file;
	private FileConfiguration 		QuestFile;
	
	
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
	
	
	//Get Quest Item
		public ItemStack getQuestItem() {
			ItemStack stack = null;
			
			if(!(this.QuestFile.getString("quest_item.item").equals("null"))) {
				int ammount = Integer.parseInt(this.QuestFile.getString(this.QuestFile.getString("quest_item.quantity")));
				
				stack = new ItemStack(Material.valueOf(this.QuestFile.getString("quest_item.item")),ammount);
				ItemMeta meta = stack.getItemMeta();
				
				//Set Custom Data
				meta.setCustomModelData(this.QuestFile.getInt("quest_item.custom_data"));
				stack.setItemMeta(meta);
			}
			
			return stack;
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
	public ENUM_ActionTypes getActionType(int STEP_INDEX) {return ENUM_ActionTypes.valueOf(this.QuestFile.getString("steps." + STEP_INDEX + ".action.type"));}


	//Get a specific step's Action target
	public ENUM_EntitiesTypes getActionTarget(int STEP_INDEX) {return ENUM_EntitiesTypes.valueOf(this.QuestFile.getString("steps." + STEP_INDEX + ".action.target"));}

		
	
	//Get a specific step's item to give
	public ItemStack getStepItem(int STEP_INDEX) {
		ItemStack stack = null;
		
		if(!(this.QuestFile.getString("steps." + STEP_INDEX + ".give.item").equals("null"))) {
			int ammount = Integer.parseInt(this.QuestFile.getString(this.QuestFile.getString("steps." + STEP_INDEX + ".give.quantity")));
			
			stack = new ItemStack(Material.valueOf(this.QuestFile.getString("steps." + STEP_INDEX + ".give.item")),ammount);
			ItemMeta meta = stack.getItemMeta();
			
			//Set Custom Data
			meta.setCustomModelData(this.QuestFile.getInt("steps." + STEP_INDEX + ".give.custom_data"));
			stack.setItemMeta(meta);
		}
		
		return stack;
	}
	
	
	
	//Get the REWARDS
	public ArrayList<ItemStack> getRewards(){
		ArrayList<ItemStack> REWARDS = new ArrayList<>();
		
		//Get all the rewards and add them to the rewards list
		for(int i = 1; i <= this.QuestFile.getConfigurationSection("rewards").getKeys(false).size(); i++) {
			ItemStack stack = new ItemStack(Material.valueOf(this.QuestFile.getString("rewards." + i + ".item")), this.QuestFile.getInt("rewards." + i + ".quantity"));
			ItemMeta meta = stack.getItemMeta();
			meta.setCustomModelData(this.QuestFile.getInt("rewards." + i + ".custom_data"));
			stack.setItemMeta(meta);
			REWARDS.add(stack);
		}
		
		
		return REWARDS;
	}
	
	
	
	//Get the next QUESTS
	public ArrayList<String> getNextQuests(){
		ArrayList<String> NEXT_QUEST = new ArrayList<>();
		
		//Get all the next quest and add them to the array
		for(int i = 1; i <= this.QuestFile.getConfigurationSection("next_quest").getKeys(false).size(); i++) {
			NEXT_QUEST.add(this.QuestFile.getString("next_quest." + i));
		}
		
		return NEXT_QUEST;
	}
	
	
	//Get the Story Line name
	public String getStoryLine() {return this.QuestFile.getString("story_line.name");}
	
	
	//Get the Previous Quests
	public ArrayList<String> getPreviousQuest(){
		ArrayList<String> PREVIOUS_QUEST = new ArrayList<>();
		
		//Get all the previous quest
		for(int i = 1; i <= this.QuestFile.getConfigurationSection("previous_quest").getKeys(false).size(); i++) {
			PREVIOUS_QUEST.add(this.QuestFile.getString("previous_quest." + i));
		}
		
		return PREVIOUS_QUEST;
	}
	
	
	
	//---------------------------------------
	//GET
	//---------------------------------------
	public FileConfiguration getFile() {return QuestFile;}
	
	
}
