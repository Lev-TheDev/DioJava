package edu.lev.poo.interfaces.exercise;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        MessageService emailService = new EmailService();
        MessageService smsService = new SmsService();
        MessageService dmService = new DirectMessageService();

        String msg = "Congratulations! You've earned a 25% Discount Coupon on Amazon store! We're waiting for you! Bye!";

        List<MessageService> allServices = List.of(emailService, smsService, dmService);
        Notify notifyAll = new Notify(allServices);
        notifyAll.sendToAll(msg);

    }
}
