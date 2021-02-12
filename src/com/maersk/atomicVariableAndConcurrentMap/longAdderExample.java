package com.maersk.atomicVariableAndConcurrentMap;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;

// instead of summing up a single result this class maintains a set of variables internally to reduce
// contention over threads. The actual result can be retrieved by calling sum() or sumThenReset().
public class longAdderExample {
    public static void main(String[] args) throws InterruptedException {
        LongAdder adder = new LongAdder();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        IntStream.range(0, 10)
                .forEach(i -> executor.submit(adder::increment));
        executor.awaitTermination(15, TimeUnit.SECONDS);
        System.out.println(adder.sum());


        int numberOfThreads = 4;
        int numberOfIncrements = 100;

        Runnable incrementAction = () -> IntStream
                .range(0, numberOfIncrements)
                .forEach(i -> adder.increment());

        for (int i = 0; i < numberOfThreads; i++) {
            executor.submit(incrementAction);
        }

        executor.shutdown();
        executor.awaitTermination(60, TimeUnit.SECONDS);

        System.out.println(adder.sum());

    }
}
