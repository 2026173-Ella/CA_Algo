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

}
