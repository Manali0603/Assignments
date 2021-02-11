package com.maersk;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class invokeAll_InvokeAnyExample {

    static Callable<String> callable(String result, long sleepSeconds) {
        return () -> {
            TimeUnit.SECONDS.sleep(sleepSeconds);
            return result;
        };
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newWorkStealingPool();

        //Example for invoke_all()
        List<Callable<String>> task1 = Arrays.asList(
                () -> "ACTIVITY1 is complete!",
                () -> "ACTIVITY2 is complete!",
                () -> "ACTIVITY3 is complete!");

        //Example for invoke_any()
        List<Callable<String>> task2 = Arrays.asList(
                callable("task1 is done!", 2),
                callable("task2 is done!", 1),
                callable("task3 is done!", 3));


        //print task1 invokeAll
        executor.invokeAll(task1)
                .stream()
                .map(future -> {
                    try {
                        return future.get();
                    } catch (Exception e) {
                        throw new IllegalStateException(e);
                    }
                })
                .forEach(System.out::println);

        //print task2 invokeAny
        String result = executor.invokeAny(task2);
        System.out.println("----------\n" + result);

        executor.shutdown();
    }
}
