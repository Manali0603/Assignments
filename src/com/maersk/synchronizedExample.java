package com.maersk;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class synchronizedExample {
    private static int count = 0;

    synchronized void increment() {
        synchronized (this) {
            count = count + 1;
        }
    }

    public static void main(String[] args) {
        synchronizedExample obj = new synchronizedExample();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        System.out.println("CURRENT THREAD : " + Thread.currentThread().getName());

        IntStream.range(0, 100)
                .forEach(i -> executor.submit(obj::increment));

        System.out.println(count);
        executor.shutdown();

    }
}
