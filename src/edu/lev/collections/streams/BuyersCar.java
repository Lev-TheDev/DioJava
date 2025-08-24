package edu.lev.collections.streams;

import java.util.ArrayList;
import java.util.List;

public class BuyersCar {

    private List<Item> itemList;

    public BuyersCar() {
        this.itemList = new ArrayList<>();
    }

    public double calculateTotalPrice() {
        double totalValue = 0d;
        if (!itemList.isEmpty()) {
            for (Item item : itemList) {
                double itemPrice = item.getPrice() * item.getQuantity();
                totalValue += itemPrice;
            }
            return totalValue;
        } else {
            throw new RuntimeException("Item list is empty, cannot calculate total price.");
        }
    }

    public double calculateTotalPriceWithStream() {
        if (itemList.isEmpty()) {
            throw new RuntimeException("Item list is empty, cannot calculate total price.");
        }
        return itemList.stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();
    }

    public static void main(String[] args) {
        BuyersCar car = new BuyersCar();
        car.itemList.add(new Item("Apple", 0.5, 10));
        car.itemList.add(new Item("Banana", 0.2, 20));
        car.itemList.add(new Item("Orange", 0.3, 15));

        try {
            System.out.println("Total price (without stream): " + car.calculateTotalPrice());
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }

        try {
            System.out.println("Total price (with stream): " + car.calculateTotalPriceWithStream());
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }
    }
}
