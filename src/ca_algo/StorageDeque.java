/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca_algo;

/**
 *
 * @author ella
 */

/**
 * StorageDeque - Array-based Double-Ended Queue.
 * Demonstrates the core data structure for the assignment.
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

    public boolean isEmpty() { return count == 0; }
    public boolean isFull()  { return count == capacity; }
    public int size()        { return count; }
    public int getCapacity() { return capacity; }
        /**
     * Add item to the FRONT of the deque. Time Complexity: O(1)
     */
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
        /**
     * Remove item from the FRONT. Time Complexity: O(1)
     */
    public FoodItem removeFront() {
        if (isEmpty()) {
            System.out.println("Storage is EMPTY! Nothing to remove.");
            return null;
        }
        FoodItem item = arr[front];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % capacity;
        }
        count--;
        System.out.println(item.getName() + " removed from FRONT of storage.");
        return item;
    }

    /**
     * Remove item from the REAR. Time Complexity: O(1)
     */
    public FoodItem removeRear() {
        if (isEmpty()) {
            System.out.println("Storage is EMPTY! Nothing to remove.");
            return null;
        }
        FoodItem item = arr[rear];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            rear = (rear - 1 + capacity) % capacity;
        }
        count--;
        System.out.println(item.getName() + " removed from REAR of storage.");
        return item;
    }
        /**
     * Peek at the FRONT item. Time Complexity: O(1)
     */
    public FoodItem peekFront() {
        if (isEmpty()) {
            System.out.println("Storage is EMPTY!");
            return null;
        }
        return arr[front];
    }

    /**
     * Peek at the REAR item. Time Complexity: O(1)
     */
    public FoodItem peekRear() {
        if (isEmpty()) {
            System.out.println("Storage is EMPTY!");
            return null;
        }
        return arr[rear];
    }
        /**
     * Display all items from front to rear. Time Complexity: O(n)
     */
    public void display() {
        if (isEmpty()) {
            System.out.println("Storage is EMPTY!");
            return;
        }
        System.out.println("\n===== STORAGE CONTENTS (Front -> Rear) =====");
        int i = front;
        int steps = 0;
        while (steps < count) {
            System.out.println("[" + (steps + 1) + "] " + arr[i]);
            i = (i + 1) % capacity;
            steps++;
        }
        System.out.println("Total items: " + count + "/" + capacity);
        System.out.println("=============================================\n");
    }

    /**
     * Display the top (front) item name only.
     */
    public void displayTop() {
        if (isEmpty()) {
            System.out.println("Storage is EMPTY!");
            return;
        }
        System.out.println("Top item (front): " + arr[front].getName());
    }

    /**
     * Linear search for a food item by name. Time Complexity: O(n)
     * Returns position from front (0-based) or -1 if not found.
     */
    public int search(String name) {
        if (isEmpty()) return -1;
        int i = front;
        int steps = 0;
        while (steps < count) {
            if (arr[i].getName().equalsIgnoreCase(name)) {
                return steps;
            }
            i = (i + 1) % capacity;
            steps++;
        }
        return -1;
    }
}