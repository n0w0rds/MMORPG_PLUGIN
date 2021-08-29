package com.nowords.mmorpgplugin.commands.adminside;

import java.util.ArrayList;

import org.bukkit.entity.Player;

import com.nowords.mmorpgplugin.Main;
import com.nowords.mmorpgplugin.commands.abstractclass.ABST_COMMAND;
import com.nowords.mmorpgplugin.commands.abstractclass.ABST_SUBCOMMAND;
import com.nowords.mmorpgplugin.commands.adminside.subcommands.NPC_CREATE;


import net.md_5.bungee.api.ChatColor;

public class COMMAND_NPC extends ABST_COMMAND {

	Main main;
	ArrayList<ABST_SUBCOMMAND> subcommands = new ArrayList<>();
	
	public COMMAND_NPC(Main main) {
		this.main = main;
		
		//Load SubCommands
		this.subcommands.add(new NPC_CREATE(this.main));
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
	public void perform(Player player, String[] args ) {
		//There is a subcommands
		if(args.length >= 1) {
			//Is a valid sub commands
			for(ABST_SUBCOMMAND sub: this .subcommands) {
				if(sub.getName().equalsIgnoreCase(args[0])) {sub.perform(player, args);}
			}
		}else {
			player.sendMessage(ChatColor.RED + "This command need a subcommand in order to be perform");
		}
		
	}

}
