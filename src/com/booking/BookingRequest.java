package com.booking;

import java.util.*;
import java.util.concurrent.*;

import com.controller.BookingHistory;
import com.controller.Controller;
import com.main.Main;

public class BookingRequest {
    public static Queue<String> req = new LinkedList<>();
    private static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    
    public static void booking(String roomType, String user) {
        req.add(user);
        while (!req.isEmpty()) {
            book(roomType,user);
            req.remove();
        }
    }

    public static void book(String roomType,String user) {
        ScheduledFuture<?> timeout = scheduler.schedule(() -> {
            System.out.println("Booking dismissed after 10 seconds");
        }, 10, TimeUnit.SECONDS);

        if (Main.map.get(roomType).count == 0) {
            System.out.println("Room not available");
            timeout.cancel(true);
        } else {
        	String roomID = roomType + "" + Main.map.get(roomType).count;
        	BookingHistory.add(user,roomID);
        	Main.assignedRooms.get(roomType).add(roomID);
        	Main.bookedRooms.add(roomID);
        	System.out.println("Room with ID " + roomID +" booked successfully");
            Controller.DecRoomCount(1, roomType);
            timeout.cancel(true);
        }
    }
}
;