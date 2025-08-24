package edu.lev.collections.streams;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class SupplierInterface {
    // The Supplier interface does not accept any arguments and returns a T value.
    // It is often used to generate or provide instances of a type, such as creating new objects.

    public static void main(String[] args) {
        Supplier<String> saudation = () -> "Hello, World!";

        // Using Supplier to obtain a list of 5 saudations
        List<String> saudations = Stream.generate(saudation)
                .limit(5)
                .toList();
        saudations.forEach(System.out::println);
    }
}
