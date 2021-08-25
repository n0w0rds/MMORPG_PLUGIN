package com.nowords.mmorpgplugin.commands.adminside.subcommands;

import java.util.ArrayList;

import org.bukkit.entity.Player;

import com.nowords.mmorpgplugin.Main;
import com.nowords.mmorpgplugin.commands.abstractclass.ABST_SUBCOMMAND;

public class NPC_CREATE extends ABST_SUBCOMMAND {
	
	Main main;
	
	public NPC_CREATE(Main main) {
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
		return "/npc create <name> <texture>";
	}

	@Override
	public boolean isAdmin() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public ArrayList<String> getArgs(int ARG_INDEX) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void perform(Player player, String[] args ) {
		// TODO Auto-generated method stub
		
	}

}
