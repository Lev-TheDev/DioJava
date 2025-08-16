package edu.lev.collections;

import java.util.Optional;

public class OptionalStudy {
    public static void main(String[] args) {
        Optional<UserRecEnum> optional = Optional.of(new UserRecEnum("João", 30, SexEnum.MALE));
        System.out.println(optional.isEmpty()); // true
        System.out.println(optional.isPresent()); // false

        Optional<UserRecEnum> optional2 = Optional.ofNullable(new UserRecEnum("Mayk", 25, SexEnum.MALE));
        System.out.println(optional2);

        Optional<UserRecEnum> optional3 = Optional.ofNullable(null);
        optional3.ifPresent(System.out::println);
        optional3.ifPresentOrElse(
            user -> System.out.println("User found: " + user),
            () -> System.out.println("No user found")
        );
        System.out.println("========");

        System.out.println(optional3.orElse(new UserRecEnum("Clara", 19, SexEnum.FEMALE)));
        System.out.println(optional2.orElse(new UserRecEnum("Clara", 19, SexEnum.FEMALE)));
        // se retornar um valor vazio, ele cria um novo objeto servindo de default
        System.out.println(optional2.orElseThrow(() -> new RuntimeException("User not found")));
        // dispara uma exception se for vazio
        System.out.println("========");
    }
}
