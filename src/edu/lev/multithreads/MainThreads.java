package edu.lev.multithreads;

import java.util.concurrent.atomic.AtomicInteger;

public class MainThreads {
    private static AtomicInteger number = new AtomicInteger(0);

    public static void main(String[] args) {
        //StringBuffer = multithread

        Runnable inc = () -> {
            for (int i = 0; i < 100000; i++) {
                number.incrementAndGet();
            }
        };

        Runnable dec = () -> {
            for (int i = 0; i > -100000; i--) {
                number.decrementAndGet();
            }
        };

        Runnable show = () -> {
            for (int i = 0; i < 250000; i++) {
                System.out.println(number);
            }
        };

        var execInc = new Thread(inc);
        execInc.start();
        execInc.setName("Thread Inc");
        var execDec = new Thread(dec);
        execDec.start();
        execDec.setName("Thread Dec");
        var execShow = new Thread(show);
        execShow.start();
        execShow.setName("Thread Show");

        System.out.println(execInc.getName());
        System.out.println(execDec.getName());
        System.out.println(execShow.getName());
    }
}
