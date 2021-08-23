package com.nowords.mmorpgplugin.commands;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import com.nowords.mmorpgplugin.Main;

public class ADMIN_COMMAND_MANAGER implements CommandExecutor,TabCompleter{
	Main main;
	
	public ADMIN_COMMAND_MANAGER(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<String> onTabComplete(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		// TODO Auto-generated method stub
		return null;
	}
}
