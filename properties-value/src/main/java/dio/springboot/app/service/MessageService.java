package dio.springboot.app.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MessageService implements CommandLineRunner {

    @Value("${name:New User}") // se a propriedade "name" não for encontrada, usará "Default Name"
    private String name;
    @Value("${email}")
    private String email;
    @Value("${phoneNumbers}")
    private List<Long> phoneNumbers;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello, " + name + "!");
        System.out.println("Your email is: " + email);
        System.out.println("Your phone numbers are: " + phoneNumbers);
        System.out.println("Your registration was approved!");
    }
}
