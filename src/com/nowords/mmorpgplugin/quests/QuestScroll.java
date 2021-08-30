package com.nowords.mmorpgplugin.quests;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class QuestScroll {
	
	public QuestScroll() {
		// TODO Auto-generated constructor stub
	}
	
	
	//---------------------------------------
	//FUNCTION
	//---------------------------------------

	//Give to a player the Quest Scroll int the last hotbar slot
	public static void give_QuestScroll(Player player) {
		//Create the ItemStack
		ItemStack QUEST_SCROLL = new ItemStack(Material.BOOK);
		ItemMeta QUEST_SCROLL_META = QUEST_SCROLL.getItemMeta();
		QUEST_SCROLL_META.setDisplayName(ChatColor.LIGHT_PURPLE + "QUEST SCROLL");
		QUEST_SCROLL.setItemMeta(QUEST_SCROLL_META);
		
		player.getInventory().setItem(9, QUEST_SCROLL);
	}
	
	
	//Run this method when a player right click the scroll
	public static void open_QuestList(Player player) {
		
	}
}
