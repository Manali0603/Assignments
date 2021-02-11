package com.maersk;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.StampedLock;

//The optimistic lock is valid right after acquiring the lock. In contrast to normal read locks an optimistic
// lock doesn't prevent other threads to obtain a write lock instantaneously. After sending the first thread
// to sleep for one second, the second thread obtains a write lock without waiting for the optimistic read lock
// to be released. From this point the optimistic read lock is no longer valid. Even when the write lock is
// released the optimistic read locks stays invalid.
public class optimisticLockExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        StampedLock lock = new StampedLock();

        executor.submit(() -> {
            long stamp = lock.tryOptimisticRead();
            try {
                System.out.println("Optimistic Lock Valid: " + lock.validate(stamp));
                Thread.sleep(1);
                System.out.println("Optimistic Lock Valid: " + lock.validate(stamp));
                Thread.sleep(2);
                System.out.println("Optimistic Lock Valid: " + lock.validate(stamp));
            }catch (InterruptedException e) {
                e.getStackTrace();
            } finally {
                lock.unlock(stamp);
            }
        });

        executor.submit(() -> {
            long stamp = lock.writeLock();
            try {
                System.out.println("Write Lock acquired");
                Thread.sleep(2);
            }catch (InterruptedException e) {
                e.getStackTrace();
            } finally {
                lock.unlock(stamp);
                System.out.println("Write done");
            }
        });

        executor.shutdown();
    }
}
