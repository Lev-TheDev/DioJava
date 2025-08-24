package edu.lev.collections.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class DesafioStreamAPI {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);
        // Task 1: show the list in ascending order
        System.out.println("Ascending order:");
        numbers.stream()
                .sorted()
                .forEach(System.out::println);

        // Task 2: show the sum of even numbers
        int sumOfEvens = numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Sum of even numbers: " + sumOfEvens);

        // Task 3: verify if all the numbers of the list are > 0
        boolean isPositive = numbers.stream()
                .allMatch(n -> n > 0);
        System.out.println("All numbers are positive? " + isPositive);

        // Task 4: remove all the odd numbers
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .toList();
        /*List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 != 0)
                .toList();
        numbers.removeAll(evenNumbers);*/
        System.out.println("List after removing odd numbers:");
        evenNumbers.forEach(System.out::println);

        // Task 5: calculate the mean of numbers > 5
        double meanOfGreaterThanFive = numbers.stream()
                .filter(n -> n > 5)
                .mapToDouble(n -> n)
                .average()
                .orElse(0.0);
        System.out.println("Mean of numbers greater than 5: " + meanOfGreaterThanFive);

        // Task 6: Verify if the list contains a number > 10
        boolean containsGreaterThanTen = numbers.stream()
                .anyMatch(n -> n > 10);
        System.out.println("List contains a number greater than 10? " + containsGreaterThanTen);
        /*List<Integer> greaterThanTen = numbers.stream()
                .anyMatch(n -> n > 10) ? List.of(1) : List.of(0);
                // If any number is greater than 10, return a list with 1
                // If no number is greater than 10, return a list with 0
        System.out.print("List contains a number greater than 10? ");
        if (greaterThanTen.get(0) == 1) {
            System.out.println("Yes.");
        } else {
            System.out.println("No.");
        }*/

        // Task 7: find the second largest number in the list
       /* Integer secondLargest = numbers.stream()
                .distinct() // Remove duplicates
                .sorted((a, b) -> b - a) // Sort in descending order
                .skip(1) // Skip the largest number
                .findFirst() // Get the next one
                .orElse(null); // If not found, return null*/
        Integer secondLargest = numbers.reversed()
                .stream()
                .distinct()
                .skip(1)
                .findFirst()
                .orElse(null); // If not found, return null
        System.out.println("Second largest number: " + secondLargest);

        // Task 8: sum all the numbers in the list
        /*int totalSum = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Total sum of all numbers: " + totalSum);*/
        int totalSum = numbers.stream()
                .mapToInt(Integer::intValue)
                .reduce(0, Integer::sum); // Using reduce to sum all numbers
        System.out.println("Total sum of all numbers: " + totalSum);

        // Task 9: verify if all the numbers of the list are distinct
        boolean allDistinct = numbers.stream()
                .distinct()
                .count() == numbers.size();
        System.out.println("All numbers are distinct? " + allDistinct);
        /*boolean isDistinct = numbers.stream()
                .anyMatch(n -> numbers.indexOf(n) != numbers.lastIndexOf(n));
        System.out.println("All numbers are distinct? " + !isDistinct);*/

        // Task 10: group odd values that are multiples of 3 or 5
        List<Integer> oddMultiplesOfThreeOrFive = numbers.stream()
                .filter(n -> n % 2 != 0 && (n % 3 == 0 || n % 5 == 0))
                .toList();
        System.out.println("Odd numbers that are multiples of 3 or 5:");
        if (oddMultiplesOfThreeOrFive.isEmpty()) {
            System.out.println("No odd numbers that are multiples of 3 or 5 found.");
        } else {
            oddMultiplesOfThreeOrFive.forEach(System.out::println);
        }

        // Task 11: find the sum of the squares of all the numbers in the list
        /*
        int sumOfSquares = numbers.stream()
                .mapToInt(n -> n * n)
                .sum();
        System.out.println("Sum of squares of all numbers: " + sumOfSquares);*/
        double sumOfSquares = numbers.stream()
                .mapToDouble(n -> Math.pow(n, 2))
                .sum();
        System.out.println("Sum of squares of all numbers: " + sumOfSquares);

        // Task 12: find the product of all the numbers in the list
        double productOfList = numbers.stream()
                .mapToDouble(n -> n)
                .reduce(1, (a, b) -> a * b);
        System.out.println("Product of all numbers: " + productOfList);

        // Task 13: filter numbers that fall within a range
        List<Integer> rangeFilteredNumbers = numbers.stream()
                .filter(n -> n >= 3 && n <= 7)
                .toList();
        if (rangeFilteredNumbers.isEmpty()) {
            System.out.println("No numbers found in the range [3, 7].");
        } else {
            System.out.println("Numbers in the range [3, 7]:");
            rangeFilteredNumbers.forEach(System.out::println);
        }

        // Task 14: find the largest prime number from the list
        Integer largestPrime = numbers.stream()
                .filter(DesafioStreamAPI::isPrime)
                .max(Integer::compareTo)
                .orElse(null);
        if (largestPrime != null) {
            System.out.println("Largest prime number: " + largestPrime);
        } else {
            System.out.println("No prime numbers found in the list.");
        }

        // Task 15: Check if the list contains at least one negative number
        boolean hasNegative = numbers.stream()
                .anyMatch(n -> n < 0);
        System.out.print("List contains at least one negative number? ");
        if (hasNegative) {
            System.out.println("Yes.");
        } else {
            System.out.println("No.");
        }

        // Task 16: Group the numbers into even and odd numbers:
        List<Integer> oddNumbersList = numbers.stream()
                .filter(n -> n % 2 != 0)
                .toList();
        List<Integer> evenNumbersList = numbers.stream()
                .filter(n -> n % 2 == 0)
                .toList();
        System.out.println("Even numbers:");
        evenNumbersList.forEach(System.out::println);
        System.out.println("Odd numbers:");
        oddNumbersList.forEach(System.out::println);

        // Task 17: Filter prime numbers from the list:
        List<Integer> primeNumbers = numbers.stream()
                .filter(DesafioStreamAPI::isPrime)
                .toList();
        if (primeNumbers.isEmpty()) {
            System.out.println("No prime numbers found in the list.");
        } else {
            System.out.println("Prime numbers:");
            primeNumbers.forEach(System.out::println);
        }

        // Task 18: Verify if all the numbers of the list are equals
       double areEqual = numbers.stream()
                .distinct()
                .count();
        boolean allEqual = areEqual == 1;
        if (allEqual) {
            System.out.println("All numbers in the list are equal.");
        } else {
            System.out.println("Not all numbers in the list are equal.");
        }

        // Task 19: Find the sum of the numbers divisible by 3 and 5:
        double sumOfDivisiblesByThreeAndFive = numbers.stream()
                .filter(n -> n % 3 == 0 || n % 5 == 0)
                .mapToDouble(n -> n)
                .sum();
        System.out.println("Sum of numbers divisible by 3 and 5: " + sumOfDivisiblesByThreeAndFive);






















    }

    private static boolean isPrime(Integer n) {
        if (n <= 1) return false;
        return IntStream.rangeClosed(2, (int) Math.sqrt(n)).noneMatch(i -> n % i == 0);
        /*for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;*/
    }
}
