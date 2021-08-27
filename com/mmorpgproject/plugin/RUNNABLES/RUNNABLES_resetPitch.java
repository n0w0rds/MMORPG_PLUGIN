package com.mmorpgproject.plugin.RUNNABLES;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.scheduler.BukkitTask;

import com.mmorpgproject.plugin.Main;

public class RUNNABLES_resetPitch {
	
	
	
	@SuppressWarnings("deprecation")
	public static void setPitch(Main main) {
		
		int id = main.getServer().getScheduler().scheduleSyncRepeatingTask(main, new Runnable() {
			
			@Override
			public void run() {
				World world = main.getServer().getWorlds().get(0);
				ArrayList<Entity> nearMobs = (ArrayList<Entity>) world.getEntities();
				//System.out.println("---------------------------------- \n"+nearMobs);
				for(Entity ent: nearMobs) {
					if(ent.getLocation().getPitch() != 0 && ent.getType() == EntityType.ZOMBIE) {
						Location location = ent.getLocation();
						location.setPitch(0);
						ent.teleport(location);
						
					}
				}
				
			}
		}, 0, 1);
			
		
	}
	
	public static void runAnimation(Main main) {
		
		int id = main.getServer().getScheduler().scheduleSyncRepeatingTask(main, new Runnable() {
			
			@Override
			public void run() {
				
				
			}
		}, 200,1 );
	}
}
