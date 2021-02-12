package com.maersk.threadsAndExecutors;

import java.util.concurrent.*;
//Callables are functional interfaces just like runnables but instead of being void they return a value.
public class callableExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> task = () -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                return "TASK DONE!";
            } catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted", e);
            }
        };

        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<String> future = executor.submit(task);

        System.out.println("future task done? " + future.isDone());

        String result = future.get();

        System.out.println("future task done? " + future.isDone());
        System.out.print("result: " + result);
        executor.shutdown();
    }
}
