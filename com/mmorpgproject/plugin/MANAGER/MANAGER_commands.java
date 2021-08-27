package com.mmorpgproject.plugin.MANAGER;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import com.mmorpgproject.plugin.Main;
import com.mmorpgproject.plugin.ABSTRACT.ABSTCommand;
import com.mmorpgproject.plugin.COMMANDS.COMMAND_npc;

public class MANAGER_commands implements CommandExecutor,TabCompleter{

	ArrayList<ABSTCommand> commandsList = new ArrayList<>();
	Main main;
	public MANAGER_commands(Main main) {
		this.main = main;
		commandsList.add(new COMMAND_npc(main));
	}
	
	@Override
	public List<String> onTabComplete(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		
		return null;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) { //Check if the sender is a player
			Player player = (Player)sender;
			for(ABSTCommand cmd: commandsList) { //Check if valid command
				if(command.getName().equals(cmd.getName())) {
					cmd.perform(player, null); //Perform the command
				}
			}
		}
		return false;
	}
	
}
