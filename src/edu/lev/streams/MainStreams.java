package edu.lev.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static edu.lev.streams.ContactType.EMAIL;
import static edu.lev.streams.ContactType.PHONE;
import static edu.lev.streams.Sex.FEMALE;
import static edu.lev.streams.Sex.MALE;

public class MainStreams {

    public static void main(String[] args) {

        List<UserStreams> users = new ArrayList<>(generateUsers());
        users.sort(Comparator.comparing(UserStreams::name));
        users.stream()
                .filter(u -> u.contacts().size() >= 2)
                .forEach(System.out::println);
        System.out.println("==================================");
        var values = users.stream()
                .flatMap(u -> u.contacts().stream())
                .filter(c -> c.type() == EMAIL)
                .sorted(Comparator.comparing(ContactStreams::description))
                .map(c -> String.format("{\n    \"type\": \"%s\",\n    \"description\": \"%s\"\n}", c.type(), c.description()))
                .toList();
        values.forEach(System.out::println);

    }

    private static List<UserStreams> generateUsers(){
        var contacts1 = List.of(
                new ContactStreams("(19)75785845", PHONE),
                new ContactStreams("joao@gmail.com", EMAIL)
        );

        var contacts2 = List.of(
                new ContactStreams("(19)757845", PHONE)
        );

        var contacts3 = List.of(
                new ContactStreams("lucas@outlook.com", EMAIL)
        );

        var contacts4 = List.of(
                new ContactStreams("andreia@outlook.com", EMAIL),
                new ContactStreams("andreia@gmail.com", EMAIL)
        );

        var contacts5 = List.of(
                new ContactStreams("(19)9743726", PHONE),
                new ContactStreams("(19)9346745", PHONE)
        );

        var user1 = new UserStreams("João", 26, MALE, new ArrayList<>(contacts1));
        var user2 = new UserStreams("Maria", 28, FEMALE, new ArrayList<>(contacts2));
        var user3 = new UserStreams("Lucas", 19, MALE, new ArrayList<>(contacts3));
        var user4 = new UserStreams("Andreia", 20, FEMALE, new ArrayList<>(contacts4));
        var user5 = new UserStreams("Vitor", 30, MALE, new ArrayList<>(contacts5));
        var user6 = new UserStreams("Bruna", 36, FEMALE, new ArrayList<>());


        return List.of(user1, user2, user3, user4, user5, user6);
    }
}
