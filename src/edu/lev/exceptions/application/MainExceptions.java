package edu.lev.exceptions.application;

import edu.lev.exceptions.dao.UserDAO;
import edu.lev.exceptions.model.MenuOption;
import edu.lev.exceptions.model.UserModel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MainExceptions {

    private final static UserDAO dao = new UserDAO();

    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
    /*    try {
            test();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    // unchecked = RuntimeException
        // checked = Exception
    }

    private static void test() throws FileNotFoundException {
        var stream = new FileOutputStream("");
        // propaga para a classe que chamou o método, que deve tratá-la.
    }
    */

        while (true) {
            System.out.println("Welcome to CRUD Application! \nPlease, enter your operation number:");
            System.out.println("1 - Create user \n2 - Read user \n3 - Update user \n4 - Delete user \n5 - List all users \n6 - Exit");
            var userInput = scanner.nextInt();
            if (userInput < 1 || userInput > 6) {
                System.out.println("Invalid option. Please, enter a valid operation number:");
                userInput = scanner.nextInt();
            }
            var selectedOption = MenuOption.values()[userInput - 1];
            switch (selectedOption) {
                case SAVE -> {
                    System.out.println("Creating user...");
                    var user = dao.save(requestToSave());
                    System.out.println("User created successfully!");
                    System.out.println(user);
                }
                case UPDATE -> {
                    System.out.println("Updating user...");
                    var user = dao.update(requestToUpdate());
                    System.out.println("User updated successfully!");
                    System.out.println(user);
                }
                case DELETE -> {
                    System.out.println("Deleting user...");
                    dao.delete(requestId());
                    System.out.println("User deleted successfully!");
                }
                case FIND_BY_ID -> {
                    System.out.println("Finding user...");
                    var user = dao.findById(requestId());
                    System.out.println("User found successfully!");
                    System.out.println(user);
                }
                case FIND_ALL -> {
                    System.out.println("Listing all users...");
                    dao.findAll().forEach(System.out::println);
                    System.out.println("All users listed successfully!");
                }
                case EXIT -> {
                    System.out.println("Exiting application...");
                    System.exit(0);
                }
            }
        }
    }

    private static long requestId(){
        System.out.println("Enter user id:");
        return scanner.nextLong();
    }

    private static UserModel requestToSave(){
        System.out.println("Enter user name:");
        var name = scanner.next();
        System.out.println("Enter user email:");
        var email = scanner.next();
        System.out.println("Enter user birthdate (dd/MM/yyyy):");
        var birthdateStr = scanner.next();
        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var birthdate = LocalDate.parse(birthdateStr, formatter);
        return new UserModel(0L, name, email, birthdate);
    }

    private static UserModel requestToUpdate(){
        System.out.println("Enter user id:");
        var id = scanner.nextLong();
        System.out.println("Enter user name:");
        var name = scanner.next();
        System.out.println("Enter user email:");
        var email = scanner.next();
        System.out.println("Enter user birthdate (YYYY-MM-DDTHH:MM:SSZ):");
        var birthdateStr = scanner.next();
        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var birthdate = LocalDate.parse(birthdateStr, formatter);
        return new UserModel(id, name, email, birthdate);
    }
}
