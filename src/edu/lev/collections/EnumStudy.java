package edu.lev.collections;

import java.util.Scanner;

public class EnumStudy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var option = -1;
        while (option != 5) {
            System.out.println("Choose an option: ");
            System.out.println("1 - SUM");
            System.out.println("2 - SUBTRACTION");
            System.out.println("3 - MULTIPLICATION");
            System.out.println("4 - DIVISION");
            System.out.println("5 - EXIT");
            option = scanner.nextInt();

            if (option > 5 || option < 1) {
                System.out.println("Invalid option, try again.");
            } else if (option == 5) {
                System.out.println("Exiting...");
                break;
            }
            var operation = OperationsEnum.values()[option - 1];
            System.out.println("You chose: " + operation);

            System.out.println("Enter the first number: ");
            var firstNumber = scanner.nextInt();
            System.out.println("Enter the second number: ");
            var secondNumber = scanner.nextInt();
            var result = operation.getCalculate().apply(firstNumber, secondNumber);
            System.out.printf("The result of %s calculated by [%d %s %d] is: %d%n",
                              OperationsEnum.values()[option - 1],
                              firstNumber,
                              operation.getSymbol(),
                              secondNumber,
                              result);
            System.out.println("===================================");


        }
    }
}
