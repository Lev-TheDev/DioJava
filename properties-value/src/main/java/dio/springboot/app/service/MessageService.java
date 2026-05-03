package dio.springboot.app.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MessageService implements CommandLineRunner {

    private String name = "Jon Doe";
    private String email = "jondoe@dio.com";
    private List<Long> phoneNumbers = List.of(123456789L, 987654321L);

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello, " + name + "!");
        System.out.println("Your email is: " + email);
        System.out.println("Your phone numbers are: " + phoneNumbers);
        System.out.println("Your registration was approved!");
    }
}
