package edu.lev.poo.interfaces.exercise;

import java.util.List;

public class Notify {

    private final List<MessageService> services;

    public Notify(List<MessageService> services) {
        this.services = services;
    }

    public void sendToAll(String msg) {
        System.out.println("\n--- Notification ---");
        for (MessageService service : this.services) {
            service.sendMessage(msg);
        }
        System.out.println("--- The end ---");
    }
}