package com.controller;

import com.main.Main;

public class Controller {
	
	public static void IncRoomCount(int n,String s) {
		int x = Main.map.get(s).getCount();
		Main.map.get(s).setCount(x+n);
	}
	public static void DecRoomCount(int n,String s) {
		int x = Main.map.get(s).getCount();
		Main.map.get(s).setCount(x-n);
	}
	
	public static void updatePrice(int price,String s) {
		Main.map.get(s).setPrice(price);
	}

}
