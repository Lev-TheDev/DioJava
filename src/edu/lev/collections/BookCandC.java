package edu.lev.collections;

import java.util.Comparator;

public class BookCandC implements Comparable<BookCandC>{
    private String title;
    private String author;
    private int year;

    public BookCandC(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    @Override
    public int compareTo(BookCandC other) {
        return this.title.compareTo(other.title);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                '}';
    }
}

class ComparatorByAuthor implements Comparator<BookCandC> {
    @Override
    public int compare(BookCandC b1, BookCandC b2) {
        return b1.getAuthor().compareTo(b2.getAuthor());
    }
}

class ComparatorByYear implements Comparator<BookCandC> {
    @Override
    public int compare(BookCandC b1, BookCandC b2) {
        if (b1.getYear() < b2.getYear()) {
            return -1;
        } else if (b1.getYear() > b2.getYear()) {
            return 1;
        } else {
            return 0;
        }
    }
}

class ComparatorByYearAuthorTitle implements Comparator<BookCandC> {
    @Override
    public int compare(BookCandC b1, BookCandC b2) {
        int yearComparison = Integer.compare(b1.getYear(), b2.getYear());
        if (yearComparison != 0) {
            return yearComparison;
        }
        int authorComparison = b1.getAuthor().compareTo(b2.getAuthor());
        if (authorComparison != 0) {
            return authorComparison;
        }
        return b1.getTitle().compareTo(b2.getTitle());
    }
}
