package com.maersk.atomicVariableAndConcurrentMap;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.function.LongBinaryOperator;
import java.util.stream.IntStream;

// this class is only applicable to functions for which the order of accumulation does not matter.
// the accumulator takes a binary operator and combines initial value with every accumulated value
public class longAccumulatorExample {
    public static void main(String[] args) throws InterruptedException {
        LongBinaryOperator op = (x, y) -> 2 * x + y;
        LongAccumulator accumulator = new LongAccumulator(op, 1L);

        ExecutorService executor = Executors.newFixedThreadPool(2);

        IntStream.range(0, 10)
                .forEach(i -> executor.submit(() -> accumulator.accumulate(i)));

        executor.shutdown();
        executor.awaitTermination(30, TimeUnit.SECONDS);
        System.out.println(accumulator.getThenReset());
    }
}
