package edu.lev.collections;

import java.util.ArrayList;
import java.util.Collections;

public class MainComparator {
    public static void main(String[] args) {
        System.out.println("=============");
        ArrayList<BookCandC> books = new ArrayList<>() {
            {
                add(new BookCandC("Java Programming", "John Doe", 2020));
                add(new BookCandC("Python Programming", "Jane Smith", 2019));
                add(new BookCandC("C++ Programming", "Alice Johnson", 2021));
                add(new BookCandC("JavaScript Programming", "Bob Brown", 2018));
                add(new BookCandC("Ruby Programming", "Charlie White", 2022));
            }
        };

        System.out.println("Books sorted by title:");
        Collections.sort(books);
        for (BookCandC book : books) {
            System.out.println(book.getTitle() + " - " +
                    book.getAuthor() + " - " +
                    book.getYear());
        }

        System.out.println("=============");
        System.out.println("Books sorted by author:");
        Collections.sort(books, new ComparatorByAuthor());
        for (BookCandC book : books) {
            System.out.println(book.getTitle() + " - " +
                    book.getAuthor() + " - " +
                    book.getYear());
        }
        System.out.println("=============");
        System.out.println("Books sorted by year:");
        Collections.sort(books, new ComparatorByYear());
        for (BookCandC book : books) {
            System.out.println(book.getTitle() + " - " +
                    book.getAuthor() + " - " +
                    book.getYear());
        }
        System.out.println("=============");

    }
}
