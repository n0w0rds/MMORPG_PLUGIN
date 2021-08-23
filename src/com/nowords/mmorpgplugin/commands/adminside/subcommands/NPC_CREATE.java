package com.nowords.mmorpgplugin.commands.adminside.subcommands;

import java.util.ArrayList;

import com.nowords.mmorpgplugin.commands.abstractclass.ABST_SUBCOMMAND;

public class NPC_CREATE extends ABST_SUBCOMMAND {

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
	public void perform() {
		// TODO Auto-generated method stub
		
	}

}
