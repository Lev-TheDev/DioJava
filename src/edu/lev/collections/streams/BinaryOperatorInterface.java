package edu.lev.collections.streams;

import java.util.List;
import java.util.function.BinaryOperator;

public class BinaryOperatorInterface {
    // The BinaryOperator interface is a specialization of the BiFunction interface for cases where the operands and the result are of the same type.
    // It takes two arguments of type T and returns a result of type T.
    // It is often used in operations like addition, multiplication, or combining two values of the same type.

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        BinaryOperator<Integer> sumOperator = (a, b) -> a + b;

        int result = numbers.stream()
                .reduce(0, sumOperator);
        System.out.println("Sum of numbers: " + result);
    }
}
