package edu.lev.poo.interfaces.exercise;

public class EmailService implements MessageService {
    @Override
    public void sendMessage(String msg) {
        System.out.println("Sending message via e-mail: " + msg);
    }
}
