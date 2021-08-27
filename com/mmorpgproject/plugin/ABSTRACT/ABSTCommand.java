package com.mmorpgproject.plugin.ABSTRACT;

import java.util.ArrayList;

import org.bukkit.entity.Player;

public abstract class ABSTCommand {
	
	public abstract String getName(); //Get the name of the command
	
	public abstract String getSyntax();	//Get the Syntax of the command
	
	public abstract String getDescription(); //Get the description of the command
	
	public abstract ArrayList<ABSTSubCommand> getSubCommands(); //Get the subcommands for this command
		
	public abstract void perform(Player player, String[] args); //Perform the command
}
