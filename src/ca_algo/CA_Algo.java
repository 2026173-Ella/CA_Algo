/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca_algo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author ella
 */
public class CA_Algo {

    /**
     * Add item to the FRONT of the deque. Time Complexity: O(1)
     */
    

    /**
     * FoodItem class - represents a food item stored in the storage unit.
     * Demonstrates OOP: Encapsulation
     */
    public class FoodItem {

        private String name;
        private double weight; // in grams
        private LocalDate bestBefore;
        private LocalDateTime storedAt;

        public FoodItem(String name, double weight, LocalDate bestBefore) {
            this.name = name;
            this.weight = weight;
            this.bestBefore = bestBefore;
            this.storedAt = LocalDateTime.now();
        }

        public String getName() {
            return name;
        }

        public double getWeight() {
            return weight;
        }

        public LocalDate getBestBefore() {
            return bestBefore;
        }

        public LocalDateTime getStoredAt() {
            return storedAt;
        }

        @Override
        public String toString() {
            DateTimeFormatter dateFmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            DateTimeFormatter dateTimeFmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            return String.format("Name: %-10s | Weight: %6.1fg | Best Before: %s | Stored At: %s",
                    name, weight, bestBefore.format(dateFmt), storedAt.format(dateTimeFmt));
        }
    }

    /**
     * StorageDeque - Array-based Double-Ended Queue. Demonstrates the core data
     * structure for the assignment.
     */
    public class StorageDeque {

        private FoodItem[] arr;
        private int front;
        private int rear;
        private int capacity;
        private int count;

        public StorageDeque(int capacity) {
            this.capacity = capacity;
            this.arr = new FoodItem[capacity];
            this.front = -1;
            this.rear = -1;
            this.count = 0;
        }

        public boolean isEmpty() {
            return count == 0;
        }

        public boolean isFull() {
            return count == capacity;
        }

        public int size() {
            return count;
        }

        public int getCapacity() {
            return capacity;
        }
        public boolean addFront(FoodItem item) {
        if (isFull()) {
            System.out.println("Storage is FULL! Cannot add more items.");
            return false;
        }
        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            front = (front - 1 + capacity) % capacity;
        }
        arr[front] = item;
        count++;
        System.out.println(item.getName() + " added to FRONT of storage.");
        return true;
    }

    /**
     * Add item to the REAR of the deque. Time Complexity: O(1)
     */
    public boolean addRear(FoodItem item) {
        if (isFull()) {
            System.out.println("Storage is FULL! Cannot add more items.");
            return false;
        }
        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % capacity;
        }
        arr[rear] = item;
        count++;
        System.out.println(item.getName() + " added to REAR of storage.");
        return true;
    }
    }
}
