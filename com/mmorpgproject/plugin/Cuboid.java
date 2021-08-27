package com.mmorpgproject.plugin;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.util.Vector;


public class Cuboid {
	
	private String worldName; //The name of the world
	private World world; //Copy of the world instance
	private Vector location1V, location2V; //Two vector that are representing the cuboid
	private Location centerPoint; //Center of the cuboid
	private Location corner1,corner2; //The 2 corner of the cuboid
	private int size; //The size of the cuboid (size *2 = cuboid diagonal)
	


	//Constructor
	public Cuboid(Location centerPoint, int size) {
		this.size = size;
		worldName = centerPoint.getWorld().getName();
		world = centerPoint.getWorld();
		this.centerPoint = centerPoint;
		cuboidcalculation();
	}
	
	//get-ters
	public Location getCenterLocation() {//Method to acces the center location
		return centerPoint;
	}
	public int getsize() {return size;} //Get the actual size of this cuboid
	public ArrayList<Location> getCorner(){ //Get the 4 corners locations
		ArrayList<Location> corners = new ArrayList<>();
		corners.add(new Location(world, centerPoint.getX() + size, 0, centerPoint.getZ() + size));
		corners.add(new Location(world, centerPoint.getX() - size, 0, centerPoint.getZ() + size));
		corners.add(new Location(world, centerPoint.getX() - size, 0, centerPoint.getZ() - size));
		corners.add(new Location(world, centerPoint.getX() + size, 0, centerPoint.getZ() - size));
		return corners;
	}
	
	//Return TRUE if the location is inside the cuboid or FALSE if it's not
	public boolean containsLocation(Location location) {
		return location.toVector().isInAABB(location1V, location2V);
	}
	

	//Resize the cuboid dimensions
	public void resizeCuboid(int size) { 
		this.size = size; //Update the size value
		cuboidcalculation(); //Recreate the cuboid
	}
	

	//This function calculate the cuboid
	private void cuboidcalculation() {
		corner1 = new Location(world,centerPoint.getX() + size, 0 , centerPoint.getZ() + size); //Setting corner1's coordinates
		corner2 = new Location(world,centerPoint.getX() - size, 256 , centerPoint.getZ() - size); //Setting corner2's coordinates

		double xPos1 = Math.min(corner1.getX(), corner2.getX()); //Min X between two corner
		double yPos1 = Math.min(corner1.getY(), corner2.getY()); //Min Z between two corner
		double zPos1 = Math.min(corner1.getZ(), corner2.getZ()); //Min Z between two corner
		double xPos2 = Math.max(corner1.getX(), corner2.getX()); //Max X between two corner
		double yPos2 = Math.max(corner1.getY(), corner2.getY()); //Min Z between two corner
		double zPos2 = Math.max(corner1.getZ(), corner2.getZ()); //Max Z between two corner
		
		location1V = new Vector(xPos1,yPos1,zPos1); //Defining location1V
		location2V = new Vector(xPos2,yPos2,zPos2); //Defining location2V
	}
	
}
