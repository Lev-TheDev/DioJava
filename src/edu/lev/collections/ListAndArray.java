package edu.lev.collections;

import java.util.ArrayList;
import java.util.List;

public class ListAndArray {
    // declaração de Lista com tipos genéricos
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }
    // declaração de Lista com tipos primitivos
    public static void printIntArray(int[] array) {
        for (int element : array) {
            System.out.println(element);
        }
    }

    public static void main(String[] args) {
        List<String> test = new ArrayList<>();
        test.add("Hello");
        test.add("World");

        int[] codes = new int[2];
        codes[0] = 789;
        codes[1] = 123;
        System.out.println(codes.length);
        System.out.println(codes[0]);
        // List não trabalha com tipos primitivos
        // List usa tipos wrapper
        List<Integer> codes2 = new ArrayList<>();
        codes2.add(codes[0]);
        codes2.add(codes[1]);
        codes2.forEach(System.out::println);

        List<User> users = new ArrayList<>();
        var user = new User(1, "João");
        users.add(user);
        boolean contains = users.contains(user);
        System.out.println(users.size());
        System.out.println(users.isEmpty());
        System.out.println(users.getFirst());
        System.out.println(users.getLast());
        System.out.println(users.contains(new User(1, "João"))); // true, porque o equals foi sobrescrito


    }




}
