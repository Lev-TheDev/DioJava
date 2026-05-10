package dio.springboot.app.service;

import dio.springboot.app.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MessageService implements CommandLineRunner {
    @Autowired
    private Sender sender;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello, " + sender.getName() + "!");
        System.out.println("Your email is: " + sender.getEmail());
        System.out.println("Your phone numbers are: " + sender.getPhoneNumbers());
        System.out.println("Your registration was approved!");
    }
}
