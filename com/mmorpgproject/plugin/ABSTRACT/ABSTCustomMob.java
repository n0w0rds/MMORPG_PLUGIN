package com.mmorpgproject.plugin.ABSTRACT;

import java.util.ArrayList;

import org.bukkit.entity.Entity;

public abstract class ABSTCustomMob {
	
	public abstract Entity getTexture(); //Get the entity that represent the texture
	
	public abstract Entity createEntity(); //Create the entity on instance creation

}
