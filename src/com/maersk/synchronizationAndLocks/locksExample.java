package com.maersk.synchronizationAndLocks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class locksExample {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        ReentrantLock lock = new ReentrantLock();

        executor.submit(() -> {
            System.out.println("LOCK ACQUIRED BY CURRENT THREAD : " + lock.isHeldByCurrentThread());
            lock.lock();
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("LOCK ACQUIRED BY CURRENT THREAD : " + Thread.currentThread());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        executor.submit(() -> {
            System.out.println("Locked: " + lock.isLocked());
            System.out.println("Held by me: " + lock.isHeldByCurrentThread());
            boolean locked = lock.tryLock();
            System.out.println("Lock acquired: " + locked);
        });

        executor.shutdown();
    }
}
