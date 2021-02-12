package com.maersk.synchronizationAndLocks;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.StampedLock;

//Stamped-Lock returns a stamp represented by a long value. You can use these stamps to either release a lock or to check
// if the lock is still valid.
public class stampedLockExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Map<String, String> map = new HashMap<>();
        StampedLock lock = new StampedLock();

        Scanner input = new Scanner(System.in);
        System.out.println("ENTER KEY-VALUE PAIR INTO MAP : ");
        for (int i = 0; i < 5; i++) {

            String key = input.nextLine();
            String value = input.nextLine();
            map.put(key, value);
        }

        executor.submit(() -> {
            long stamp = lock.writeLock();
            try {
                Thread.sleep(1);
                map.put("1", "manali");
            } catch (InterruptedException e) {
                e.getStackTrace();
            } finally {
                lock.unlockWrite(stamp);
            }
        });

        Runnable writeTask2=() -> {
            long stamp = lock.writeLock();
            try {
                Thread.sleep(1);
                map.replace("1", "aditya");
            } catch (InterruptedException e) {
                e.getStackTrace();
            } finally {
                lock.unlockWrite(stamp);
            }
        };

        Runnable readTask = () -> {
            long stamp = lock.readLock();
            try {
                System.out.println(map.get("1"));
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.getStackTrace();
            } finally {
                lock.unlockRead(stamp);
            }
        };

        executor.submit(writeTask2);
        executor.submit(readTask);
        executor.shutdown();
    }
}
