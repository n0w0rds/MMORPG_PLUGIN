package com.mmorpgproject.plugin.COMMANDS;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.mmorpgproject.plugin.Main;
import com.mmorpgproject.plugin.ABSTRACT.ABSTCommand;
import com.mmorpgproject.plugin.ABSTRACT.ABSTSubCommand;
import com.mmorpgproject.plugin.MOBS.TEST;

public class COMMAND_npc extends ABSTCommand {
	Main main;
	
	public COMMAND_npc(Main main) {
		// TODO Auto-generated constructor stub
		this.main = main;
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "npc";
	}

	@Override
	public String getSyntax() {
		// TODO Auto-generated method stub
		return "/npc <SubCommand>";
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Interact/Customize/Spawn Npcs";
	}

	@Override
	public ArrayList<ABSTSubCommand> getSubCommands() {
		// TODO Auto-generated method stub
		ArrayList<ABSTSubCommand> subCommands = new ArrayList<>();
		return subCommands;
	}

	@Override
	public void perform(Player player, String[] args) {
		// TODO Auto-generated method stub
		System.out.println("BEFORE");
	 	
	    System.out.println("AFTER");
		//new TEST(player,main);
		
	}

}
