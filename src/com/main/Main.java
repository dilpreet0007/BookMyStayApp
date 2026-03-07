package com.main;

import java.util.*;

import com.booking.BookingRequest;
import com.controller.Search;
import com.inventory.Inventory;

/*
 *
    ==========UC5==========
   	Attach services (breakfast, spa, pickup)
	Allow multiple services per booking
	Calculate the additional cost
	
	@version 5.0
	@author Dilpreet
 */

public class Main {
	
	public static HashMap<String,Inventory> map = new HashMap<>();
	public static HashSet<String> bookedRooms = new HashSet<>();
	public static HashMap<String,HashSet<String>> assignedRooms = new HashMap<>();
	public static HashMap<String,ArrayList<String>> Services = new HashMap<>();

	static {
		map.put("Single",new Inventory(2000,5));
		map.put("Double",new Inventory(3000,3));
		map.put("Suite",new Inventory(4000,2));
		
		assignedRooms.put("Single", new HashSet<>());
		assignedRooms.put("Double", new HashSet<>());
		assignedRooms.put("Suite", new HashSet<>());
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter your name: ");
		String user = sc.nextLine();
		System.out.println("Enter room type you want Single | Double | Suite: ");
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
					System.out.println("If Additional Services Required ? type Yes");
					String serviceInput = sc.nextLine();
					if(serviceInput.equals("Yes")) {
						System.out.println("Breakfast || Spa || Pickup");
						String services = sc.nextLine();
						String[] arr = services.split(" ");
						Services.put(roomType+(map.get(roomType).count+1), new ArrayList<>());
						for(String sr : arr) {
							Services.get(roomType+(map.get(roomType).count+1)).add(sr);
						}
					}
				}
			}
			else if(x==2) {
				System.out.println("Enter room type you want Single | Double | Suite:");
				roomType = sc.nextLine();
				found = Search.searchRoom(roomType);
			}
		}
		
		System.out.println("Booked rooms list: "+ bookedRooms);
		System.out.println(assignedRooms);
		System.out.println(Services);
		
		sc.close();
	}

}
