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
}