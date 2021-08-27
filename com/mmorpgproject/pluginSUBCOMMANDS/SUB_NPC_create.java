package com.mmorpgproject.pluginSUBCOMMANDS;

import java.util.ArrayList;

import com.mmorpgproject.plugin.Main;
import com.mmorpgproject.plugin.ABSTRACT.ABSTSubCommand;

import net.md_5.bungee.api.ChatColor;

public class SUB_NPC_create extends ABSTSubCommand {
	
	Main main;
	
	public SUB_NPC_create(Main main) {
		this.main = main;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "create";
	}

	@Override
	public String getSyntax() {
		// TODO Auto-generated method stub
		return "/npc create <name> <color>";
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Create An Npc";
	}

	@Override
	public ArrayList<String> getArguments(int ArgNumber) {
		ArrayList<String> arguments = new ArrayList<>();
		
		switch (ArgNumber) {
		case 2:
			arguments.add("BLACK");
			arguments.add("DARK GREEN");
			arguments.add("GREEN");
			arguments.add("DARK RED");
			arguments.add("GOLD");
			arguments.add("DARK GRAY");
			arguments.add("GRAY");
			arguments.add("YELLOW");
			arguments.add("DARK BLUE");
			arguments.add("BLUE");
			arguments.add("DARK AQUA");
			arguments.add("AQUA");
			arguments.add("DARK PURPLE");
			arguments.add("LIGHT PURPLE");
			arguments.add("WHITE");
			
			break;

		default:
			break;
		}
		
		return null;
	}

	@Override
	public void perform() {
		// TODO Auto-generated method stub
		
	}

}
