package edu.lev.collections.map;

import java.util.HashMap;
import java.util.Map;

public class MapProductStock {

    private Map<Long, MapProduct> mapProductStock;
    //private long id;

    public MapProductStock() {
        this.mapProductStock = new HashMap<>();
    }

    public void addProduct(long id, String name, double price, int quantity) {
        mapProductStock.put(id, new MapProduct(name, price, quantity));
    }

    public void showProducts() {
        if(!mapProductStock.isEmpty()) {
            for (Map.Entry<Long, MapProduct> entry : mapProductStock.entrySet()) {
                System.out.println("ID: " + entry.getKey() + ", Product: " + entry.getValue());
            }
        } else {
            System.out.println("No products available.");
        }
    }

    public double calculateTotalStockValue() {
        double totalValue = 0.0;
        if(!mapProductStock.isEmpty()) {
            for (Map.Entry<Long, MapProduct> entry : mapProductStock.entrySet()) {
                MapProduct product = entry.getValue();
                totalValue += product.getPrice() * product.getQuantity();
            }
        }
        return totalValue;
    }

    public MapProduct mostExpensiveProduct() {
        MapProduct mostExpensive = null;
        if(!mapProductStock.isEmpty()) {
            for (Map.Entry<Long, MapProduct> entry : mapProductStock.entrySet()) {
                MapProduct product = entry.getValue();
                if (mostExpensive == null || product.getPrice() > mostExpensive.getPrice()) {
                    mostExpensive = product;
                }
            }
        }
        return mostExpensive;
    }

    public MapProduct mostCheapProduct() {
        MapProduct mostCheap = null;
        if(!mapProductStock.isEmpty()) {
            for (Map.Entry<Long, MapProduct> entry : mapProductStock.entrySet()) {
                MapProduct product = entry.getValue();
                if (mostCheap == null || product.getPrice() < mostCheap.getPrice()) {
                    mostCheap = product;
                }
            }
        }
        return mostCheap;
    }

    public MapProduct mostQuantityProduct() {
        MapProduct mostQuantity = null;
        if(!mapProductStock.isEmpty()) {
            for (Map.Entry<Long, MapProduct> entry : mapProductStock.entrySet()) {
                MapProduct product = entry.getValue();
                if (mostQuantity == null || product.getQuantity() > mostQuantity.getQuantity()) {
                    mostQuantity = product;
                }
            }
        }
        return mostQuantity;
    }

    public static void main(String[] args) {
        MapProductStock productStock = new MapProductStock();
        productStock.addProduct(1, "Laptop", 1200.00, 5);
        productStock.addProduct(2, "Smartphone", 800.00, 10);
        productStock.addProduct(3, "Tablet", 300.00, 15);

        System.out.println("Products in stock:");
        productStock.showProducts();

        System.out.println("\nTotal stock value: $" + productStock.calculateTotalStockValue());

        MapProduct mostExpensive = productStock.mostExpensiveProduct();
        System.out.println("\nMost expensive product: " + mostExpensive);

        MapProduct mostCheap = productStock.mostCheapProduct();
        System.out.println("\nMost cheap product: " + mostCheap);

        MapProduct mostQuantity = productStock.mostQuantityProduct();
        System.out.println("\nMost quantity product: " + mostQuantity);
    }

}
