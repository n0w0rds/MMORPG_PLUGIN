package com.mmorpgproject.plugin.LISTENERS;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.mmorpgproject.plugin.Main;
import com.mmorpgproject.plugin.MOBS.TEST;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;

public class LISTENER_customEntity implements Listener{
	
	Main main;
	
	public LISTENER_customEntity(Main main) {
		this.main = main;
	}
	
	@EventHandler
	public void onBlockClick(PlayerInteractAtEntityEvent event) throws InterruptedException {
		System.out.println("Yeah !!!");
		
		/*for(TEST entity: main.customEntities) {
			System.out.println(entity.getTexture().getCustomName());
			System.out.println(event.getRightClicked().getCustomName());
			if(entity.getTexture().getCustomName().equals(event.getRightClicked().getCustomName())) {
	
				entity.getTexture().getEquipment().setHelmet(null);
				
				
					ItemStack stack = new ItemStack(Material.CARVED_PUMPKIN);
					ItemMeta meta = stack.getItemMeta();
					meta.setCustomModelData(0);
					stack.setItemMeta(meta);
					entity.getTexture().getEquipment().setHelmet(stack);
					event.getPlayer().getInventory().addItem(stack);
					System.out.println(entity.getTexture().getEquipment().getHelmet().getItemMeta().getCustomModelData());
					
				
				//entity.runAnimations();
			}*/
	}
		
}
	
	

