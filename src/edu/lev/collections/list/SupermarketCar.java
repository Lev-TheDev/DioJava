package edu.lev.collections.list;

import java.util.ArrayList;
import java.util.List;

public class SupermarketCar {

    List<SupermarketItem> items;

    public SupermarketCar() {
        this.items = new ArrayList<>();
    }

    public void addItem(String name, double price, int quantity) {
        SupermarketItem item = new SupermarketItem(name, price, quantity);
        items.add(item);
    }

    public void removeItem(String name) {
        items.removeIf(item -> item.getName().equals(name));
    }

    public double calculateTotal() {
        return items.stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();
    }

    public void showItems() {
        if (!items.isEmpty()) {
            System.out.println("Items in the cart:");
            for (SupermarketItem item : items) {
                System.out.println(item.getName() + " - " + item.getPrice() + " x " + item.getQuantity());
            }
        } else {
            System.out.println("The cart is empty.");
        }
    }

    public static void main(String[] args) {
        SupermarketCar car = new SupermarketCar();
        car.addItem("Apple", 0.5, 10);
        car.addItem("Banana", 0.3, 5);
        car.addItem("Orange", 0.8, 8);

        car.showItems();
        car.removeItem("Banana");
        car.showItems();
        System.out.println("Total cost: " + car.calculateTotal());
    }
}