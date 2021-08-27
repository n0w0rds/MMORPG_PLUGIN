package com.mmorpgproject.plugin.MOBS;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Illusioner;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.mmorpgproject.plugin.Main;
import com.mmorpgproject.plugin.ABSTRACT.ABSTCustomMob;

import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_16_R3.EntityInsentient;

public class TEST extends ABSTCustomMob{
	
	Main main;
	private Player player;
	private ArmorStand texture;
	
	public TEST(Player player, Main main) {
		this.player = player;
		this.main = main;
		this.texture = createEntity();
		main.customEntities.add(this);
		System.out.println(texture.getEntityId());
		System.out.println(main.customEntities);
	}
	
	

	@Override
	public ArmorStand createEntity() {
		//Spawn the entity
		Location location = player.getLocation();
	
		//Add custom texture
		ItemStack item = new ItemStack(Material.CARVED_PUMPKIN);
		ItemMeta meta = item.getItemMeta();
		meta.setCustomModelData(12); //Apply custom data
		item.setItemMeta(meta); //Apply Meta to the stack
		ArmorStand holo = (ArmorStand) player.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
		holo.getEquipment().setHelmet(item); //Add the item to the entity
		holo.setInvisible(true);
		holo.setCustomNameVisible(true);
		holo.setCustomName(ChatColor.BOLD.DARK_BLUE + "Quest Giver (TEST)");
		holo.setCollidable(false);
		holo.setInvulnerable(true);
		return holo;
		
	}
	
	



	@Override
	public ArmorStand getTexture() {
		// TODO Auto-generated method stub
		return texture;
	}



	


}
