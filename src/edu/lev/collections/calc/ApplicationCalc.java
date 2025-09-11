package edu.lev.collections.calc;

import java.util.Arrays;
import java.util.Scanner;

public class ApplicationCalc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which operation number do you want to perform? (1-SUM, 2-SUBTRACTION)");
        var numberOp = scanner.nextInt();
        while (numberOp > 2 || numberOp < 1) {
            System.out.println("Invalid operation! Please enter 1 for SUM or 2 for SUBTRACTION.");
            numberOp = scanner.nextInt();
        }
        //var selectedOp = numberOp == 1 ? Operation.SUM : Operation.SUBTRACTION;
        var selectedOp = Operation.values()[numberOp - 1];
        System.out.println("Enter the numbers to perform the operation separated by comma (ex. 23,58): ");
        var numbers = scanner.next();
        var numbersArray = Arrays.stream(numbers.split(","))
                .mapToLong(Long::parseLong)
                .toArray();
        var result = selectedOp.getOperationCallback().exec(numbersArray);
        var operationToShow = numbers.replaceAll(",", selectedOp.getSignal());
        System.out.printf("The result of the operation %s is: %s\n", operationToShow, result);
    }
}
