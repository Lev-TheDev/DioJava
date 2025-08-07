package edu.lev.poo.interfaces.exercise;

public class SmsService implements MessageService {
    @Override
    public void sendMessage(String msg) {
        System.out.println("Sending message via SMS: " + msg);
    }
}
