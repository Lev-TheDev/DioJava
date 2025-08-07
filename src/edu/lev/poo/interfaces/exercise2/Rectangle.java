package edu.lev.poo.interfaces.exercise2;

public record Rectangle(double height, double base) implements Shape {
    @Override
    public double getArea() {
        return height * base;
    }
}
