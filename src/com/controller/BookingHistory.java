package com.controller;

import java.util.*;

public class BookingHistory {
	public static ArrayList<String> history = new ArrayList<>();
	
	public static void add(String userName,String roomID) {
		history.add(userName + "->" + roomID);
	}
}
