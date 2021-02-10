package com.maersk;

import java.util.concurrent.*;

public class executorExample {
    private static void Task1(String name) {
        System.out.println("I'm task1! " + name);
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(1);

        executor.submit(() -> System.out.println("I'm Runnable task."));
        Future<Integer> futureTask1 = executor.submit(() -> {
            System.out.println("I'm Callable task.");
            return 6 * 5;
        });

        try {

            Task1("Before Future Result");

            // block until future returned a result,
            // timeout if the future takes more than 5 seconds to return the result
            Integer result = futureTask1.get(5, TimeUnit.SECONDS);

            System.out.println("Get future result : " + result);

            Task1("After Future Result");


        } catch (InterruptedException e) {// thread was interrupted
            e.printStackTrace();
        } catch (ExecutionException e) {// thread threw an exception
            e.printStackTrace();
        } catch (TimeoutException e) {// timeout before the future task is complete
            e.printStackTrace();
        } finally {

            // shut down the executor manually
            executor.shutdown();
        }
    }
}
