package com.nowords.mmorpgplugin.externalressources;

import java.util.ArrayList;
import java.util.HashMap;

import com.nowords.mmorpgplugin.Main;
import com.nowords.mmorpgplugin.entities.enums.NPC_STATE;

public class MANAGER_Texture {
	Main main;
	ArrayList<Texture> TEXTURES_LIST = new ArrayList<>();
	ArrayList<String> TYPE_LIST = new ArrayList<>();
	
	public MANAGER_Texture(Main main) {
		this.main = main;
		initTextures();
		initTypes();
	}
	
	
	//Add all the textures to the array
	private void initTextures() {
		TEXTURES_LIST.add(new Texture("test", NPC_STATE.IDLE, 0));
		TEXTURES_LIST.add(new Texture("test", NPC_STATE.WAVING, 1));
	}
	
	
	//Add all the types to the array
	private void initTypes() {
		TYPE_LIST.add("test");
	}
	
	
	//---------------------------------------
	//GET
	//---------------------------------------
	public ArrayList<Texture> getTextureList(){return TEXTURES_LIST;}
	
	public ArrayList<String> getTypes(){return TYPE_LIST;}
}
