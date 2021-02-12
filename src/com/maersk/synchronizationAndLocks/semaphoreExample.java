package com.maersk.synchronizationAndLocks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
//-If the semaphore’s count is greater than zero, then the thread acquires a permit, which causes the
// semaphore’s count to be decremented.
//-Otherwise, the thread will be blocked until a permit can be acquired.
//-When the thread no longer needs an access to the shared resource, it releases the permit, which causes
// the semaphore’s count to be incremented.
//-If there is another thread waiting for a permit, then that thread will acquire a permit at that time.
public class semaphoreExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        Semaphore semaphore = new Semaphore(5);

        Runnable SemaphoreTask = () -> {
            boolean permit = false;
            try {
                permit = semaphore.tryAcquire(1, TimeUnit.SECONDS);
                if (permit) {
                    System.out.println("Semaphore acquired");
                    Thread.sleep(2);
                } else {
                    System.out.println("Could not acquire semaphore");
                }
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            } finally {
                if (permit) {
                    semaphore.release();
                }
            }
        };

        IntStream.range(0, 10)
                .forEach(i -> executor.submit(SemaphoreTask));
        executor.shutdown();
    }
}
