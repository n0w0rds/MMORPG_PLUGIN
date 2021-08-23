package com.nowords.mmorpgplugin.commands.adminside;

import java.util.ArrayList;

import com.nowords.mmorpgplugin.Main;
import com.nowords.mmorpgplugin.commands.abstractclass.ABST_COMMAND;
import com.nowords.mmorpgplugin.commands.abstractclass.ABST_SUBCOMMAND;

public class COMMAND_NPC extends ABST_COMMAND {

	Main main;
	ArrayList<ABST_SUBCOMMAND> subcommands = new ArrayList<>();
	
	public COMMAND_NPC(Main main) {
		this.main = main;
	}
	
	@Override
	public String getName() {return "npc";}

	@Override
	public String getSyntax() {return "/npc";}

	@Override
	public boolean isAdmin() {return true;}

	@Override
	public ArrayList<ABST_SUBCOMMAND> getArguments() {return subcommands;}

	@Override
	public void perform() {
		
		
	}

}
