package com.nowords.mmorpgplugin.externalressources.textures;

import com.nowords.mmorpgplugin.entities.enums.ENUM_NpcState;

public class Texture {
	
	private ENUM_NpcState STATE;
	private int CUSTOM_DATA;
	private String TYPE;
	
	public Texture(String type,ENUM_NpcState state, int CUSTOMDATA) {
		this.TYPE = type;
		this.STATE = state;
		this.CUSTOM_DATA = CUSTOMDATA;
	}
	
	
	//---------------------------------------
	//GET
	//---------------------------------------
	public ENUM_NpcState getState() {return STATE;}
	public int getCustomData() {return CUSTOM_DATA;}
	public String getType() {return TYPE;}
}
