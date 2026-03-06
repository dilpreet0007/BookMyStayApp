package com.main;

import java.util.*;

import com.controller.Controller;
import com.inventory.Inventory;

/*
             ==========UC1==========
   	Initialize room types (Single, Double, Suite)
	Store room counts and prices
	Support dynamic inventory updates
	Provide real-time availability status
	
	@version 1.0
	@author Dilpreet
 */

public class Main {
	
	public static HashMap<String,Inventory> map = new HashMap<>();

	public static void main(String[] args) {
		
		map.put("Single",new Inventory(2000,5));
		map.put("Double",new Inventory(3000,3));
		map.put("Suite",new Inventory(4000,2));
		
		for(String s : map.keySet()) {
			System.out.println(s + " " + map.get(s).count + " " + map.get(s).price);
		}
		
		Controller.IncRoomCount(2, "Single");
		Controller.updatePrice(3500, "Double");
		
		for(String s : map.keySet()) {
			System.out.println(s + " " + map.get(s).count + " " + map.get(s).price);
		}
		

	}

}
