package edu.lev.collections.set;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class ProductRegistration {

    private Set<Product> products;

    public ProductRegistration() {
        this.products = new HashSet<>();
    }

    public void addProduct(long id, String name, double price, int quantity) {
        products.add(new Product(id, name, price, quantity));
    }

    //public void showProductsByName() {
      //  Set<Product> productsByName = new TreeSet<>(products);
        //System.out.println(productsByName);
    //}

    public Set<Product> returnProductsByName() {
        Set<Product> productsByName = new TreeSet<>(products);
        return productsByName;
    }

    public void showProductsByPrice() {
        Set<Product> productsByPrice = new TreeSet<>(new ComparatorByPrice());
        productsByPrice.addAll(products);
        productsByPrice.forEach(System.out::println);
    }

    public static void main(String[] args) {
        ProductRegistration registration = new ProductRegistration();
        registration.addProduct(1, "Laptop", 1200.00, 5);
        registration.addProduct(2, "Smartphone", 800.00, 10);
        registration.addProduct(3, "Tablet", 400.00, 7);
        registration.addProduct(4, "Monitor", 300.00, 3);
        registration.addProduct(5, "Keyboard", 50.00, 15);

        System.out.println("Products ordered by name:");
        System.out.println(registration.returnProductsByName());
        System.out.println("=============");
        System.out.println("Products ordered by price:");
        registration.showProductsByPrice();
    }
}
