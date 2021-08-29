package com.nowords.mmorpgplugin.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import com.nowords.mmorpgplugin.Main;
import com.nowords.mmorpgplugin.entities.enums.ENUM_NpcState;

public class LISTENER_Player implements Listener {
	
	Main main;
	
	public LISTENER_Player(Main main) {
		this.main = main;
	}
	
	@EventHandler
	public void onEntityClick(PlayerInteractAtEntityEvent event) {
		/*String clickedEntity = event.getRightClicked().getName();
		
		for(String key: main.NPC_LIST.keySet()) {
			if(key.equals(clickedEntity)) {
				main.NPC_LIST.get(key).stateChanger(NPC_STATE.WAVING);
			}
		}*/
	}
	
}
