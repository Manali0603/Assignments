package com.maersk;

import java.util.concurrent.*;

public class timeoutExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService executor = Executors.newFixedThreadPool(1);

        Future<String> future = executor.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                return "TASK IS DONE!";
            }
            catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted", e);
            }
        });

        System.out.println(future.get(3, TimeUnit.SECONDS));
        //System.out.println(future.get(1, TimeUnit.SECONDS));
        executor.shutdown();
    }
}
