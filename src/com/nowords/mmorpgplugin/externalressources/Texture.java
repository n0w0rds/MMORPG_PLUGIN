package com.nowords.mmorpgplugin.externalressources;

import com.nowords.mmorpgplugin.entities.enums.NPC_STATE;

public class Texture {
	
	private NPC_STATE STATE;
	private int CUSTOM_DATA;
	private String TYPE;
	
	public Texture(String type,NPC_STATE state, int CUSTOMDATA) {
		this.TYPE = type;
		this.STATE = state;
		this.CUSTOM_DATA = CUSTOMDATA;
	}
}