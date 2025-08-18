package edu.lev.collections.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PersonOrder {

    private List<Person> persons;

    public PersonOrder() {
        this.persons = new ArrayList<>();
    }

    public void addPerson(String name, int age, double height) {
        Person person = new Person(name, age, height);
        persons.add(person);
    }

    public List<Person> orderByAge() {
        List<Person> personsByAge = new ArrayList<>(persons);
        Collections.sort(personsByAge);
        return personsByAge;
    }

    public List<Person> orderByHeight() {
        List<Person> personsByHeight = new ArrayList<>(persons);
        Collections.sort(personsByHeight, new ComparatorByHeight());
        return personsByHeight;
    }

    public static void main(String[] args) {
        PersonOrder personOrder = new PersonOrder();
        personOrder.addPerson("Alice", 30, 5.5);
        personOrder.addPerson("Bob", 25, 6.0);
        personOrder.addPerson("Charlie", 35, 5.8);

        System.out.println("Persons ordered by age:");
        for (Person person : personOrder.orderByAge()) {
            System.out.println(person);
        }
        System.out.println("=============");
        System.out.println("Persons ordered by age:");
        personOrder.orderByAge().forEach(System.out::println);

        System.out.println("=============");
        System.out.println("Persons ordered by height:");
        System.out.println(personOrder.orderByHeight());
        System.out.println("=============");

        System.out.println("\nPersons ordered by height:");
        for (Person person : personOrder.orderByHeight()) {
            System.out.println(person);
        }
    }
}
