# BookMyStay – Hotel Booking Management System

## Overview

**BookMyStay** is a hotel booking management system that allows guests to search and reserve rooms on a **first-come, first-served basis**. The system manages live room inventory, processes booking requests, and allows guests to add additional services such as breakfast, spa access, and airport pickup.

The application maintains real-time availability and updates inventory automatically after each confirmed reservation, preventing double-booking.

This project demonstrates **Core Java concepts and Data Structures** through a practical system design approach. Each feature is implemented using appropriate data structures to simulate real-world backend systems.

---

# System Features

* Room inventory management
* Real-time room availability search
* First-come-first-served booking queue
* Unique room allocation
* Add-on service selection
* Booking history and reporting
* Double-booking prevention

---

# Technologies & Concepts Used

* **Java (Core Java)**
* **Data Structures**

  * HashMap
  * HashSet
  * Queue (LinkedList)
  * List (ArrayList)
* **Object Oriented Programming**
* **System Design Concepts**
* **Data Consistency & Integrity**

---

# Use Cases

## 1. Room Inventory Setup & Management

### Goal

Maintain a centralized and accurate record of hotel room inventory.

### Actors

* Hotel Admin
* Inventory Service

### Data Structures Used

* `HashMap<String, Integer>` → Room Type → Available Count
* `HashMap<String, Double>` → Room Type → Price Per Night

### Key Requirements

* Initialize room types (Single, Double, Suite)
* Store room counts and pricing
* Allow dynamic inventory updates
* Provide real-time availability status

### Flow

1. Admin adds room types
2. System stores data in HashMaps
3. Room counts and prices can be updated
4. Availability is maintained in real time

### Benefits

* O(1) fast inventory lookup
* Centralized room management
* Easy scalability for new room types

---

# 2. Room Search & Availability Check

### Goal

Allow guests to search available rooms without modifying inventory.

### Actors

* Guest
* Search Service

### Data Structures Used

* `HashMap<String, Integer>`
* `HashMap<String, Double>`

### Key Requirements

* Display available room types
* Show pricing and amenities
* Prevent booking unavailable rooms

### Flow

1. Guest sends search request
2. System checks HashMap for room availability
3. Filters available rooms
4. Displays results to the user

### Benefits

* Fast response time
* Accurate availability information
* Safe read-only access to inventory

---

# 3. Booking Request (First-Come First-Served)

### Goal

Ensure fairness in booking during high demand.

### Actors

* Guest
* Booking Queue Service

### Data Structures Used

* `Queue<Reservation>` (LinkedList)

### Key Requirements

* Accept booking requests
* Process requests in order of arrival
* Handle high traffic booking scenarios

### Flow

1. Guest submits booking request
2. Request is added to the queue
3. Requests are processed in FIFO order

### Benefits

* Predictable booking order
* Fair allocation system
* Prevents race conditions

---

# 4. Reservation Confirmation & Room Allocation

### Goal

Prevent double-booking by ensuring unique room assignments.

### Actors

* Booking Service
* Inventory Service

### Data Structures Used

* `HashSet<String>` → Booked Room IDs
* `HashMap<String, Set<String>>` → Room Type → Assigned Rooms

### Key Requirements

* Assign unique room IDs
* Prevent duplicate room allocation
* Update room availability immediately

### Flow

1. Booking request is dequeued
2. System assigns a unique room ID
3. Room ID stored in HashSet
4. Inventory count decreases

### Benefits

* Zero double-booking
* Immediate inventory updates
* Conflict-free reservations

---

# 5. Add-On Service Selection

### Goal

Allow guests to enhance bookings with optional services.

### Actors

* Guest
* Service Management Module

### Data Structures Used

* `Map<String, List<Service>>`
* Reservation ID → List of Services

### Example Services

* Breakfast
* Airport Pickup
* Spa Access

### Key Requirements

* Attach services to reservations
* Support multiple services per booking
* Calculate additional costs

### Flow

1. Guest selects additional services
2. Services are added to a list
3. Services are mapped to reservation ID

### Benefits

* Flexible service management
* Easy service expansion
* Clear service-reservation relationship

---

# 6. Booking History & Reporting

### Goal

Maintain a complete history of reservations for tracking and reporting.

### Actors

* Admin
* Reporting Service

### Data Structures Used

* `List<Reservation>`

### Key Requirements

* Store confirmed bookings
* Allow cancellations
* Generate reports and booking history

### Flow

1. Booking is confirmed
2. Reservation is stored in a list
3. Data can be retrieved for reporting

### Benefits

* Reliable booking history
* Easy audit and reporting
* Better customer support

---

# Key System Advantages

* Prevents double booking
* Real-time inventory updates
* Efficient data management using appropriate structures
* Fair booking system using FIFO queue
* Expandable architecture for future features

---
