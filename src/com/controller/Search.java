package com.controller;

import java.util.*;

import com.inventory.Amenities;
import com.inventory.Inventory;
import com.main.Main;

public class Search {
	static HashMap<String,Inventory> map = Main.map;
	
	public static boolean searchRoom(String roomType) {
		if(map.get(roomType).count==0) {
			System.out.println("Room not available");
			return false;
		}
		
		else if(map.get(roomType).count > 1) System.out.println(map.get(roomType).count+ " " + roomType +  " Rooms Available");
		
		else System.out.println(map.get(roomType).count+ " " + roomType +  " Room Available");
		System.out.println();
		
		if(roomType.equals("Single")) System.out.println(Amenities.singleRoom);
		else if(roomType.equals("Double")) System.out.println(Amenities.doubleRoom);
		else if(roomType.equals("Suite")) System.out.println(Amenities.suiteRoom);
		
		return true;
	}
}
