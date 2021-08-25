package com.nowords.mmorpgplugin.entities;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.nowords.mmorpgplugin.Main;
import com.nowords.mmorpgplugin.entities.enums.NPC_STATE;
import com.nowords.mmorpgplugin.externalressources.Texture;

import net.minecraft.server.v1_16_R3.World;

public class NPC {
	
	Main main;
	
	private String NPC_NAME;
	private Location NPC_LOC;
	private ArmorStand NPC_ENTIY;
	private String NPC_TYPE;
	private HashMap<NPC_STATE, Integer> NPC_TEXTURES = new HashMap<>();
	
	public NPC(String name,String type,Location loc, Player player, Main main) {
		this.main = main;		
		this.NPC_TYPE = type;
		this.NPC_NAME = name;
		this.NPC_LOC = loc;
		
		loadTexture(this.NPC_TYPE);
		create(player);
	}
	
	
	//---------------------------------------
	//FUNCTION
	//---------------------------------------
	
	//LOAD TEXTURE FROM TEXTURE LIST
	private void loadTexture(String type) {
		//Get textures with valid type
		for(Texture index: main.TEXTURE_LIST.getTextureList()) {
			if(index.getType().equalsIgnoreCase(this.NPC_TYPE)) {
				this.NPC_TEXTURES.put(index.getState(), index.getCustomData());
			}
		}
	}
	
	
	
	
	
	//SPAWN THE ENTITY
	private void spawn(Player player, NPC_STATE state) {
		//Create Entity
		this.NPC_ENTIY = (ArmorStand) player.getWorld().spawnEntity(NPC_LOC, EntityType.ARMOR_STAND);
		
		//Texture
		ItemStack texture = new ItemStack(Material.CARVED_PUMPKIN);
		ItemMeta meta = texture.getItemMeta();
		meta.setCustomModelData(NPC_TEXTURES.get(state));
		texture.setItemMeta(meta);
		
		//Entity Properties
		this.NPC_ENTIY.getEquipment().setHelmet(texture);
		this.NPC_ENTIY.setInvisible(true);
		this.NPC_ENTIY.setCustomName(NPC_NAME);
		this.NPC_ENTIY.setCustomNameVisible(true);
	}
	
	
	
	//Create the NPC
	private void create(Player player) {
		spawn(player, NPC_STATE.IDLE);
		
		//Register the NPC
		this.main.NPC_LIST.put(NPC_NAME, this);
	}
	
	
	
	//Change the state
	public void stateChanger(NPC_STATE state) {
		//Texture
		ItemStack texture = new ItemStack(Material.CARVED_PUMPKIN);
		ItemMeta meta = texture.getItemMeta();
		meta.setCustomModelData(NPC_TEXTURES.get(state));
		texture.setItemMeta(meta);
		
		this.NPC_ENTIY.getEquipment().setHelmet(texture);		
	}
	
	
	//What to do when a player interact
	public void interaction() {
		
	}
	
	
	//---------------------------------------
	//GET
	//---------------------------------------
	public String getName() {
		return this.NPC_NAME;
	}
	
	public Location getLocation() {
		return this.NPC_LOC;
	}
	
	public ArmorStand getEntity() {
		return this.NPC_ENTIY;
	}
	
	
	
	//---------------------------------------
	//SET
	//---------------------------------------
	
	
	
}
