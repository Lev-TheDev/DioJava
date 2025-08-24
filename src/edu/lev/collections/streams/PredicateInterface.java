package edu.lev.collections.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateInterface {
    // The Predicate interface is a functional interface that takes an argument of type T and returns a boolean value.
    // It is often used for filtering or testing conditions on elements in a stream.

    public static void main(String[] args) {
        List<String> words = Arrays.asList(
                "apple", "banana", "cherry", "date", "elderberry", "fig", "grape"
        );
        Predicate<String> startsWithVowel = word -> {
            char firstChar = word.toLowerCase().charAt(0);
            return firstChar == 'a' || firstChar == 'e' || firstChar == 'i' ||
                   firstChar == 'o' || firstChar == 'u';
        };
        Predicate<String> moreThanFiveChars = word -> word.length() > 5;

        // Using Predicate to filter words that start with a vowel
        words.stream()
                .filter(startsWithVowel)
                .forEach(word -> System.out.println("Starts with vowel: " + word));
        // Using Predicate to filter words that have more than five characters
        words.stream()
                .filter(moreThanFiveChars)
                .forEach(word -> System.out.println("More than five characters: " + word));
        // Using Predicate to filter words that start with a vowel and have more than five characters
        words.stream()
                .filter(startsWithVowel.and(moreThanFiveChars))
                .forEach(word -> System.out.println("Starts with vowel and more than five characters: " + word));
        // Using Predicate to filter words that start with a vowel or have more than five characters
        words.stream()
                .filter(startsWithVowel.or(moreThanFiveChars))
                .forEach(word -> System.out.println("Starts with vowel or more than five characters: " + word));

    }
}
