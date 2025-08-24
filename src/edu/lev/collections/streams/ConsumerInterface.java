package edu.lev.collections.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerInterface {
    // accept a T type and perform an action, no return value
    // used to process elements in a stream, without modifying them
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Consumer<Integer> printingPairs = number -> {
            if (number % 2 == 0) {
                System.out.println("Even number: " + number);
            }
        };

        // Using Consumer to print each number
        numbers.forEach(printingPairs);
    }
}
