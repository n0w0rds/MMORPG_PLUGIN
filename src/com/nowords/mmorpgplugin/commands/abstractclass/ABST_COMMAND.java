package com.nowords.mmorpgplugin.commands.abstractclass;

import java.util.ArrayList;

public abstract class ABST_COMMAND {
	
	public abstract String getName();
	
	public abstract String getSyntax();
	
	public abstract boolean isAdmin();
	
	public abstract ArrayList<ABST_SUBCOMMAND> getArguments();
	
	public abstract void perform();
}
