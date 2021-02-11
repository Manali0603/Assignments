package com.maersk;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class readWriteLockExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Map<String, String> map = new HashMap<>();

        Scanner input = new Scanner(System.in);
        ReadWriteLock lock = new ReentrantReadWriteLock();

        System.out.println("ENTER KEY-VALUE PAIR INTO MAP : ");
        for (int i = 0; i < 5; i++) {

            String key = input.nextLine();
            String value = input.nextLine();
            map.put(key, value);
        }

        Runnable writeTask = () -> {
            lock.writeLock().lock();
            try {
                Thread.sleep(1);
                map.put("two","aditya");

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.writeLock().unlock();
            }
        };

        Runnable readTask = () -> {
            lock.readLock().lock();
            try {
                System.out.println("ENTER THE KEY WHOSE VALUE YOU WANT : ");
                String key = input.nextLine();
                System.out.println(map.get(key));
                Thread.sleep(1);

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.readLock().unlock();
            }
        };

        executor.submit(writeTask);
        executor.submit(readTask);


        executor.shutdown();
    }
}
