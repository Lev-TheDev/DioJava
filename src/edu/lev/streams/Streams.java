package edu.lev.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        System.out.println("Streams");
        // Example of using streams in Java
        // You can use streams to process collections of data in a functional style.
        // For example, you can filter, map, and reduce collections using streams.
        var value1 = Stream.generate(() -> new Random().nextInt())
                .limit(5)
                .toArray(Integer[]::new);

        for(var v : value1) {
            System.out.println(v);
        }

        var value2 = IntStream.generate(() -> new Random().nextInt())
                .limit(50)
                .filter(v -> v % 2 == 0) // Filter even numbers
                .map(v -> v * 2) // Double the value
                .toArray();

        System.out.println("==========");

        for(var v : value2) {
            System.out.println(v);
        }

        System.out.println("==========");

        Stream.of("Java", "Python", "C++", "JavaScript")
                .filter(s -> s.startsWith("J")) // Filter strings that start with 'J'
                .map(String::toUpperCase) // Convert to uppercase
                .forEach(System.out::println); // Print each string
        System.out.println("==========");

        List<String> debugNames = new ArrayList<>();
        var value3 = Stream.of("João", "Maria", "Tony", "Caio", "Cleber")
                .peek(debugNames::add) // Peek to add names to debugNames list
                .filter(n -> n.endsWith("o")) // Filter names that end with 'o'
                .toList();
        // The peek method is used to perform an action on each element of the stream
        System.out.println("Debug Names: " + debugNames);
        System.out.println(value3);
        System.out.println("==========");
        // anyMatch, allMatch, noneMatch
        // These methods are used to check if any, all, or none of the elements in the stream match a given predicate.
        // findAny, findFirst
        // findAny returns any sorted element from the stream, while findFirst returns the first element that matches the predicate.
        // reduce
        // The reduce method is used to combine the elements of the stream into a single result.
        var sum = Stream.of(1, 2, 3, 4, 5)
                .reduce(0, Integer::sum); // Sum all elements in the stream
        System.out.println("Sum: " + sum);
        var names = Stream.of("João", "Maria", "Tony", "Caio", "Cleber")
                .reduce("", (a, b) -> a + ", " + b) // Concatenate all names in the stream
                .replaceFirst(", ", ""); // Remove the first comma and space
        System.out.println("Names: " + names);
        var average = IntStream.of(1, 2, 2, 3, 4, 5, 5)
                .distinct() // Remove duplicate elements
                .average(); // Calculate the average of the elements in the stream
        System.out.println("Average: " + average.orElse(0.0)); // Print the average, or 0.0 if the stream is empty
    }
}
