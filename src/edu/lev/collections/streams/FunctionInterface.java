package edu.lev.collections.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionInterface {
    // represents a function that takes an argument of type T and returns a result of type R
    // used to map or transform elements in a stream, allowing for operations like filtering, mapping, and reducing
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Function<Integer, Integer> doubleFunction = number -> number * 2;

        List<Integer> doubledNumbers = numbers.stream()
                .map(doubleFunction)
                .toList();
        doubledNumbers.forEach(System.out::println);
    }
}