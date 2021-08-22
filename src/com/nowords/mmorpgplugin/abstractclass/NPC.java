package com.nowords.mmorpgplugin.abstractclass;

import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_16_R3.World;

public class NPC {
	
	private String NPC_NAM;
	private Location NPC_LOC;
	private ArmorStand NPC_ENTIY;
	private int NPC_TEXTURE_ID;
	
	public NPC(String name,Location loc, int textureId,Player player) {
		this.NPC_NAME = name;
		this.NPC_LOC = loc;
		this.NPC_TEXTURE_ID = textureId;
		
		create(player);
	}
	
	
	//---------------------------------------
	//FUNCTION
	//---------------------------------------
	
	
	//Create the NPC
	private void create(Player player) {
		ArmorStand entity = (ArmorStand) player.getWorld().spawnEntity(NPC_LOC, EntityType.ARMOR_STAND);
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
