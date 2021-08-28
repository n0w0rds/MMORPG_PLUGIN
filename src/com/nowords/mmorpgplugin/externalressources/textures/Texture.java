package com.nowords.mmorpgplugin.externalressources.textures;

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
	
	
	//---------------------------------------
	//GET
	//---------------------------------------
	public NPC_STATE getState() {return STATE;}
	public int getCustomData() {return CUSTOM_DATA;}
	public String getType() {return TYPE;}
}
