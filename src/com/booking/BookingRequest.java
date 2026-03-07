package com.booking;

import java.util.*;
import java.util.concurrent.*;

import com.controller.Controller;
import com.main.Main;

public class BookingRequest {
    public static Queue<String> req = new LinkedList<>();
    private static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    
    public static void booking(String roomType, String user) {
        req.add(user);
        while (!req.isEmpty()) {
            book(roomType);
            req.remove();
        }
    }

    public static void book(String roomType) {
        ScheduledFuture<?> timeout = scheduler.schedule(() -> {
            System.out.println("Booking dismissed after 10 seconds");
        }, 10, TimeUnit.SECONDS);

        if (Main.map.get(roomType).count == 0) {
            System.out.println("Room not available");
            timeout.cancel(true);
        } else {
        	Main.assignedRooms.get(roomType).add(roomType + "" + Main.map.get(roomType).count);
        	Main.bookedRooms.add(roomType + "" + Main.map.get(roomType).count);
        	System.out.println("Room with ID " + roomType + "" + Main.map.get(roomType).count +" booked successfully");
            Controller.DecRoomCount(1, roomType);
            timeout.cancel(true);
        }
    }
}
;