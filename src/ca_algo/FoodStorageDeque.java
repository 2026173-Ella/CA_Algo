/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ca_algo;

import java.util.Scanner;
/**
 *
 * @author ella
 */



/**
 * Main application - Fast-Food Restaurant Storage System.
 * Data Structure: Double-Ended Queue (Deque)
 */
public class FoodStorageDeque {

    private static final int MAX_CAPACITY = 8;
    private static final String[] VALID_FOODS = {"Burger", "Pizza", "Fries", "Sandwich", "Hotdog"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StorageDeque storage = new StorageDeque(MAX_CAPACITY);

        System.out.println("=========================================");
        System.out.println("  FAST-FOOD RESTAURANT STORAGE SYSTEM    ");
        System.out.println("  Data Structure: Double-Ended Queue     ");
        System.out.println("  Maximum Capacity: " + MAX_CAPACITY);
        System.out.println("=========================================");

        boolean running = true;
        while (running) {
            printMenu();
            int choice = readInt(sc);

            switch (choice) {
                case 1: addItem(sc, storage, true); break;
                case 2: addItem(sc, storage, false); break;
                case 3:
                    FoodItem f1 = storage.removeFront();
                    if (f1 != null) System.out.println("Removed: " + f1.getName());
                    break;
                case 4:
                    FoodItem f2 = storage.removeRear();
                    if (f2 != null) System.out.println("Removed: " + f2.getName());
                    break;
                case 5:
                    FoodItem pf = storage.peekFront();
                    if (pf != null) System.out.println("Front item: " + pf);
                    break;
                case 6:
                    FoodItem pr = storage.peekRear();
                    if (pr != null) System.out.println("Rear item: " + pr);
                    break;
                case 7: storage.display(); break;
                case 8: searchItem(sc, storage); break;
                case 9:
                    System.out.println("Current size: " + storage.size() + "/" + MAX_CAPACITY);
                    break;
                case 10:
                    running = false;
                    System.out.println("Exiting application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter 1-10.");
            }
        }
        sc.close();
    }

    private static void printMenu() {
        System.out.println("\n--- STORAGE OPERATIONS ---");
        System.out.println("1. Add item to FRONT  (single-ended mode)");
        System.out.println("2. Add item to REAR   (double-ended mode)");
        System.out.println("3. Remove item from FRONT");
        System.out.println("4. Remove item from REAR");
        System.out.println("5. Peek at FRONT");
        System.out.println("6. Peek at REAR");
        System.out.println("7. Display all items");
        System.out.println("8. Search for item by name");
        System.out.println("9. Show current size");
        System.out.println("10. Exit");
        System.out.print("Choose an option (1-10): ");
    }

    private static int readInt(Scanner sc) {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input! Enter a number: ");
            }
        }
    }

    // Placeholder methods filled in the next commits
        /**
     * Handles adding a food item with validation.
     */
    private static void addItem(Scanner sc, StorageDeque storage, boolean toFront) {
        if (storage.isFull()) {
            System.out.println("Storage is FULL (" + MAX_CAPACITY + " items max). Cannot add.");
            return;
        }

        System.out.println("\nValid foods: Burger, Pizza, Fries, Sandwich, Hotdog");
        System.out.print("Enter food name: ");
        String name = sc.nextLine().trim();

        if (!isValidFood(name)) {
            System.out.println("Invalid food name! Must be one of the 5 listed items.");
            return;
        }

        System.out.print("Enter weight (grams): ");
        double weight;
        try {
            weight = Double.parseDouble(sc.nextLine().trim());
            if (weight <= 0) {
                System.out.println("Weight must be positive.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid weight! Please enter a number.");
            return;
        }

        // Date validation added in the next commit
        java.time.LocalDate bestBefore = java.time.LocalDate.now().plusDays(7);

        FoodItem item = new FoodItem(name, weight, bestBefore);
        if (toFront) {
            storage.addFront(item);
        } else {
            storage.addRear(item);
        }
    }

    private static boolean isValidFood(String name) {
        for (String f : VALID_FOODS) {
            if (f.equalsIgnoreCase(name)) return true;
        }
        return false;
    }

    private static void searchItem(Scanner sc, StorageDeque storage) {
        System.out.println("(searchItem not yet implemented)");
    }
    
}
