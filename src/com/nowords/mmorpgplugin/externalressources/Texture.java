package com.nowords.mmorpgplugin.externalressources;

import com.nowords.mmorpgplugin.entities.enums.NPC_STATE;

public class Texture {
	
	private int CUSTOM_DATA;
	private NPC_STATE STATE;
	
	public Texture(int cs, NPC_STATE state) {
		this.CUSTOM_DATA = cs;
		this.STATE = state;
	}
	
	public int getCustomData() {return CUSTOM_DATA;}
	
	public NPC_STATE getState(){return STATE;}
}
