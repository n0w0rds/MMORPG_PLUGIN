package com.nowords.mmorpgplugin.commands;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.core.config.plugins.util.ResolverUtil.Test;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import com.nowords.mmorpgplugin.Main;
import com.nowords.mmorpgplugin.commands.abstractclass.ABST_COMMAND;
import com.nowords.mmorpgplugin.commands.abstractclass.ABST_SUBCOMMAND;
import com.nowords.mmorpgplugin.commands.adminside.COMMAND_NPC;

import net.md_5.bungee.api.ChatColor;

public class ADMIN_COMMAND_MANAGER implements CommandExecutor,TabCompleter{
	Main main;
	ArrayList<ABST_COMMAND> COMMANDS_LIST = new ArrayList<>();
	public ADMIN_COMMAND_MANAGER(Main main) {
		this.main = main;
		//Load Commands
		COMMANDS_LIST.add(new COMMAND_NPC(main));
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		//Is the sender a player ?
		if(sender instanceof Player) {
			Player player = (Player) sender;
			boolean FOUND = false;
			
			//Is a Valid command ?
			for(ABST_COMMAND cmd: this.COMMANDS_LIST) {
				if(cmd.getName().equalsIgnoreCase(command.getName())){
					FOUND = true;
					
					//Is an admin command
					if(cmd.isAdmin()) {
						//Player is an admin
						if(player.isOp()) {
							//Perform the command
							cmd.perform(player,args);
						}else {
							player.sendMessage(ChatColor.RED + "You need to be an ADMIN in order to perform this command");
						}
					}else {
						//Perform the command
						cmd.perform(player,args);
					}
				}
			}
			
			//is invalid command
			if(!FOUND) {
				player.sendMessage(ChatColor.RED + command.getName() +" is not a valid command !!!");
			}
		
		}else {
			System.out.println("This command can only be run by a PLAYER");
		}
		return false;
	}

	
	
	
	
	
	
	
	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
		ArrayList<String> ARGUMENTS = new ArrayList<>();
		
		//Get the subcommands
		if(args.length == 1) {
			//Get the command subs
			for(ABST_COMMAND cmd: this.COMMANDS_LIST) {
				if(cmd.getName().equalsIgnoreCase(command.getName())) {
					//Add subs to the ARGUMENTS list
					for(ABST_SUBCOMMAND sub: cmd.getArguments()) {
						ARGUMENTS.add(sub.getName());
					}
				}
			}
		}else if(args.length >= 2) {
			//Get the subcommand
			for(ABST_COMMAND cmd: this.COMMANDS_LIST) {
				if(cmd.getName().equals(command.getName())) {
					for(ABST_SUBCOMMAND sub: cmd.getArguments()) {
						if(args[0].equals(sub.getName())) {
							ARGUMENTS = sub.getArgs(args.length - 1);
						}
					}
				}
				
			}
		}
		
		return ARGUMENTS;
	}
}
