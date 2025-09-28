package edu.lev.exceptions.exceptions;

public class UserNotFoundException extends RuntimeException {
    //public UserNotFoundException() {
    //    super("User not found");
    //}
    public UserNotFoundException(final String message) {
        super(message);
    }
}
