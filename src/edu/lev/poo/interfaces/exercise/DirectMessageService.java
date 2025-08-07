package edu.lev.poo.interfaces.exercise;

public class DirectMessageService implements MessageService {
    @Override
    public void sendMessage(String msg) {
        System.out.println("Sending message via Instagram's DM: " + msg);
    }
}
