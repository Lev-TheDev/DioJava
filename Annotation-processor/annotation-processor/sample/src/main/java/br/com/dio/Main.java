package br.com.dio;

import br.com.dio.model.PersonBuilder;

public class Main {
    public static void main(String[] args) {
        var person = new PersonBuilder()
                .name("John Doe")
                .id(1)
                .build();
        System.out.println(person);
    }
}
