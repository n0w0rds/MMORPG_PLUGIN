package com.nowords.mmorpgplugin.commands.abstractclass;

import java.util.ArrayList;

public abstract class ABST_SUBCOMMAND {
	
public abstract String getName();
	
	public abstract String getSyntax();
	
	public abstract boolean isAdmin();
	
	public abstract ArrayList<String> getArgs(int ARG_INDEX);
	
	public abstract void perform();
}
