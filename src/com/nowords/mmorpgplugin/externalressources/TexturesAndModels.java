package com.nowords.mmorpgplugin.externalressources;

import java.util.HashMap;

import com.nowords.mmorpgplugin.entities.enums.NPC_STATE;

public class TexturesAndModels {
	
	public HashMap<String, Texture> ENTITY_MODELS = new HashMap<>();
	
	public TexturesAndModels(){
		ENTITY_MODELS.put("test",new Texture(0, NPC_STATE.IDLE));
		ENTITY_MODELS.put("test",new Texture(1, NPC_STATE.WAVING));
	}
		
	

}
