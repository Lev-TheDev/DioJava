package edu.lev.collections.streams;

public class PeopleStream {

    private String name;
    private double height;
    private int age;

    public PeopleStream(String name, double height, int age) {
        this.name = name;
        this.height = height;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public double getHeight() {
        return height;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "PeopleStream{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", age=" + age +
                '}';
    }
}
