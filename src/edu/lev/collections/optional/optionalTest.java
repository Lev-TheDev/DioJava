package edu.lev.collections.optional;

public class optionalTest {
    // objects of Optional is used to avoid NullPointerException
    // permits encapsulate a value that may be null into an Optional object
    // requires that the code verify if the value is present or not

    public static void main(String[] args) {
        // Example of using Optional
        java.util.Optional<String> optionalString = java.util.Optional.ofNullable(null);

        // Check if value is present
        if (optionalString.isPresent()) {
            System.out.println("Value is present: " + optionalString.get());
        } else {
            System.out.println("Value is not present.");
        }

        // Using orElse to provide a default value
        String value = optionalString.orElse("Default Value");
        System.out.println("Value: " + value);

        // Using ifPresent to execute code if value is present
        optionalString.ifPresent(s -> System.out.println("Value is: " + s));
    }
}
