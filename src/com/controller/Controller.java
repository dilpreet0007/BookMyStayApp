package com.controller;

import com.main.Main;

public class Controller {
	
	public static void IncRoomCount(int noOfRooms,String roomtType) {
		int x = Main.map.get(roomtType).getCount();
		Main.map.get(roomtType).setCount(x+noOfRooms);
	}
	public static void DecRoomCount(int noOfRooms,String roomtType) {
		int x = Main.map.get(roomtType).getCount();
		Main.map.get(roomtType).setCount(x-noOfRooms);
	}
	
	public static void updatePrice(int price,String roomtType) {
		Main.map.get(roomtType).setPrice(price);
	}

}
