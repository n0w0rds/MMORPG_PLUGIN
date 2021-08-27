package com.nowords.mmorpgplugin.commands.adminside.subcommands;

import java.util.ArrayList;

import org.apache.logging.log4j.core.pattern.AbstractStyleNameConverter.Red;
import org.bukkit.entity.Player;

import com.nowords.mmorpgplugin.Main;
import com.nowords.mmorpgplugin.commands.abstractclass.ABST_SUBCOMMAND;
import com.nowords.mmorpgplugin.entities.NPC;

import net.md_5.bungee.api.ChatColor;

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
		ArrayList<String> ARGUMENTS = new ArrayList<>();
		switch (ARG_INDEX) {
		case 1:
			ARGUMENTS.add("<name>");
			break;
		case 2:
			ARGUMENTS = main.TEXTURE_LIST.getTypes();
			break;
		default:
			break;
		}
		
		return ARGUMENTS;
	}

	@Override
	public void perform(Player player, String[] args ) {
		if(args.length == 3) {
			/*Verifications
			 *-Valid Type
			 */
			if(main.TEXTURE_LIST.getTypes().contains(args[2])) {
				new NPC(args[1], args[2], player.getLocation(), player, main);
			}else {
				player.sendMessage(ChatColor.RED + "Invalid NPC Type");
			}
			
		}else {
			
		}
		
	}

}
