package com.main;

import java.util.*;

import com.booking.BookingRequest;
import com.controller.Controller;
import com.controller.Search;
import com.inventory.Inventory;

/*
 *
    ==========UC3==========
   	Accept booking requests
	Enforce arrival order
	Handle high-traffic scenarios
	
	@version 3.0
	@author Dilpreet
 */


public class Main {
	
	public static HashMap<String,Inventory> map = new HashMap<>();

	public static void main(String[] args) {
		
		map.put("Single",new Inventory(2000,5));
		map.put("Double",new Inventory(3000,3));
		map.put("Suite",new Inventory(4000,2));
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter your name: ");
		String user = sc.nextLine();
		System.out.print("Enter room type you want Single | Double | Suite: ");
		String roomType = sc.nextLine();
		boolean found = Search.searchRoom(roomType);
		
		int x = -1;
		while(x!=0) {
			System.out.print("Enter 1 to book room: ");
			System.out.print("\nEnter 2 to search for different room: ");
			System.out.print("\nEnter 0 to exit: ");
			x = sc.nextInt();
			sc.nextLine();
			if(x==0) {
				System.out.println("Exit!!!!");
				break;
			}
			else if(x==1) {
				if(found) {
					BookingRequest.booking(roomType,user);
				}
				break;
			}
			else if(x==2) {
				System.out.print("Enter room type you want Single | Double | Suite: \n");
				roomType = sc.nextLine();
				found = Search.searchRoom(roomType);
			}
		}

	}

}
