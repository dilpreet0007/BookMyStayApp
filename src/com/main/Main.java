package com.main;

import java.util.*;

import com.controller.Controller;
import com.controller.Search;
import com.inventory.Inventory;

/*
 *
    ==========UC2==========
   	Display available room types
	Show pricing and amenities
	Prevent booking unavailable rooms
	
	@version 2.0
	@author Dilpreet
 */

public class Main {
	
	public static HashMap<String,Inventory> map = new HashMap<>();

	public static void main(String[] args) {
		
		map.put("Single",new Inventory(2000,5));
		map.put("Double",new Inventory(3000,3));
		map.put("Suite",new Inventory(4000,0));
		
		Search.searchRoom("Suite");

	}

}
