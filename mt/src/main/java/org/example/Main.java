package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> chunk1 = numbers.subList(0, 5);
        List<Integer> chunk2 = numbers.subList(5, 10);

        System.out.println("Chunk1: " + chunk1);
        System.out.println("Chunk2: " + chunk2);

        List<Integer> results = Collections.synchronizedList(new ArrayList<>());

        Worker worker1 = new Worker(chunk1, results);
        Worker worker2 = new Worker(chunk2, results);

        Thread thread1 = new Thread(worker1);
        Thread thread2 = new Thread(worker2);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Results: " + results);


    }
}