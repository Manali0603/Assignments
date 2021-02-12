package com.maersk.atomicVariableAndConcurrentMap;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class atomicIntegerExample {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger atomicInt1 = new AtomicInteger(0);

        ExecutorService executor = Executors.newFixedThreadPool(2);

        //using increment-And-Get
        //is equivalent to y = ++i;
        IntStream.range(0, 10)
                .forEach(i -> executor.submit(atomicInt1::incrementAndGet));



        //using update-And-Get
        //method updateAndGet() accepts a lambda expression in order to perform arbitrary arithmetic
        // operations upon the integer
        AtomicInteger atomicInt2 = new AtomicInteger(0);
        IntStream.range(0, 10)
                .forEach(i -> {
                    Runnable task = () ->
                            atomicInt2.updateAndGet(n -> n + 2);
                    executor.submit(task);
                });



        //using accumulate-and-get
        //We use this method to sum up all values from 0 to 1000 concurrently
        //This method accepts as parameter an integer value y and an IntBinaryOperator function. It applies
        // the given function to the current value of the object and the value passed
        AtomicInteger atomicInt3 = new AtomicInteger(0);
        IntStream.range(0, 10)
                .forEach(i -> {
                    Runnable task = () ->
                            atomicInt3.accumulateAndGet(i, (n, m) -> n + m);
                    executor.submit(task);
                });


        executor.shutdown();
        executor.awaitTermination(60, TimeUnit.SECONDS);
        System.out.println(atomicInt1.get());
        System.out.println(atomicInt2.get());
        System.out.println(atomicInt3.get());


    }
}
