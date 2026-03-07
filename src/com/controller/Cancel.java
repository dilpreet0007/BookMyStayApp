package com.controller;

import com.main.Main;

public class Cancel {
	public static void cancelRoom(String roomId,String roomType) {
		if(Main.bookedRooms.contains(roomId))Main.bookedRooms.remove(roomId);
		if(Main.assignedRooms.containsKey(roomType))Main.assignedRooms.get(roomType).remove(roomId);
		if(Main.Services.containsKey(roomId))Main.Services.remove(roomId);
	}
}
