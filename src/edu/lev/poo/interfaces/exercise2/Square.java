package edu.lev.poo.interfaces.exercise2;

public record Square(double side) implements Shape {
    @Override
    public double getArea() {
        return side * side;
    }
}
