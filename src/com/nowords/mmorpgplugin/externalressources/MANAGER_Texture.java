package com.nowords.mmorpgplugin.externalressources;

import java.util.ArrayList;
import java.util.HashMap;

import com.nowords.mmorpgplugin.Main;
import com.nowords.mmorpgplugin.entities.enums.NPC_STATE;

public class MANAGER_Texture {
	Main main;
	ArrayList<Texture> TEXTURES_LIST;
	
	public MANAGER_Texture(Main main) {
		this.main = main;
		TEXTURES_LIST.add(new Texture("test", NPC_STATE.IDLE, 0));
		TEXTURES_LIST.add(new Texture("test", NPC_STATE.WAVING, 1));
	}
	
	
	//---------------------------------------
	//GET
	//---------------------------------------
	public ArrayList<Texture> getTextureList(){return TEXTURES_LIST;}
}
