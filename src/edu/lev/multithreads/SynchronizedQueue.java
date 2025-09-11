package edu.lev.multithreads;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class SynchronizedQueue {
    private final static Queue<Integer> numbers = new LinkedBlockingQueue<>(250_000);

    private static void inc(int number){
        numbers.add(number);
    }

    private static void show(){
        System.out.println(numbers);
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable inc = () -> {
            for (int i = 0; i < 10000; i++) {
                inc(i);
            }
        };

        Runnable dec = () -> {
            for (int i = 0; i > -10000; i--) {
                inc(i);
            }
        };

        Runnable show = () -> {
            for (int i = 0; i < 25000; i++) {
                show();
            }
        };

        var execInc = new Thread(inc);
        execInc.start();
        execInc.setName("Thread Inc");
        var execDec = new Thread(dec);
        execDec.start();
        execDec.setName("Thread Dec");
        execDec.join(Duration.ofSeconds(1)); // começa a priorizar a thread dec
        var execShow = new Thread(show);
        execShow.start();
        execShow.setName("Thread Show");

        System.out.println(execInc.getName());
        System.out.println(execDec.getName());
        System.out.println(execShow.getName());

    }
}
