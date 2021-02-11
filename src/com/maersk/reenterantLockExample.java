package com.maersk;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

//This gives a lock to the current working thread and blocks all other threads which are trying
// to take a lock on the shared resource.
//ReentrantLock allows threads to enter into the lock on a resource more than once.
// When the thread first enters into the lock, a hold count is set to one. Before unlocking the thread
// can re-enter into lock again and every time hold count is incremented by one. For every unlocks request,
// hold.
public class reenterantLockExample {
    ReentrantLock lock = new ReentrantLock();
    int count = 0;

    void increment() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        ReentrantLock lock = new ReentrantLock();
        readWriteLockExample obj=new readWriteLockExample();
        executor.submit(() -> {
            lock.lock();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        executor.submit(() -> {
            System.out.println("LOCKED ? : " + lock.isLocked());
            System.out.println("Held by me: " + lock.isHeldByCurrentThread());
            boolean locked = lock.tryLock();
            System.out.println("Lock acquired: " + locked);
        });


    }
}
