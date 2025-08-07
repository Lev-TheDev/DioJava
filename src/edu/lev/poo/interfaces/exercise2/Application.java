package edu.lev.poo.interfaces.exercise2;

import java.util.Scanner;

public class Application {

    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int option = -1;
        Shape shape = null;
        while (true) {
            System.out.println("Choose the shape to calculate the area:");
            System.out.println("1 - Square");
            System.out.println("2 - Rectangle");
            System.out.println("3 - Circle");
            System.out.println("4 - Exit");

            option = scanner.nextInt();
            if (option == 1) {
                shape = createSquare();
            } else if (option == 2) {
                shape = createRectangle();
            } else if (option == 3) {
                shape = createCircle();
            } else if (option == 4) {
                break;
            } else {
                System.out.println("Invalid option!");
                continue;
            }
            System.out.println("The chosen shape's area is: " + shape.getArea());
            break;
        }
    }

    private static Shape createSquare(){
        System.out.println("Side size:");
        var side = scanner.nextDouble();
        return new Square(side);
    }

    private static Shape createRectangle(){
        System.out.println("Height size:");
        var height = scanner.nextDouble();
        System.out.println("Base size:");
        var base = scanner.nextDouble();
        return new Rectangle(height, base);
    }

    private static Shape createCircle(){
        System.out.println("Radius size:");
        var radius = scanner.nextDouble();
        return new Circle(radius);
    }






}
