package com.mmorpgproject.plugin.ABSTRACT;

import java.util.ArrayList;

public abstract class ABSTSubCommand {
	
public abstract String getName(); //Get the name of the command
	
	public abstract String getSyntax();	//Get the Syntax of the command
	
	public abstract String getDescription(); //Get the description of the command
	
	public abstract ArrayList<String> getArguments(int ArgNumber); //Get the arguments depending of is index
	
	public abstract void perform(); //Perform the command
}
