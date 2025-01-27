package org.example;

import java.util.List;

public class Worker implements Runnable {
    private final List<Integer> numbers;
    private final List<Integer> results;

    public Worker(List<Integer> numbers, List<Integer> results) {
        this.numbers = numbers;
        this.results = results;
    }

    @Override
    public void run() {
        for (Integer num : numbers) {
            int squared = num * num;
            synchronized (results) {
                results.add(squared);
            }
        }
    }
}
