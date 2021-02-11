package com.maersk;

class RunnableDemo extends Thread {
    private Thread t;
    private final String threadName;

    RunnableDemo(String name) {
        threadName = name;
        System.out.println("Creating " + threadName);
    }

    public void run() {
        System.out.println("Running " + threadName);
        System.out.println("THE CURRENT THREAD IS : " + Thread.currentThread().getName());
        for (int i = 4; i > 0; i--) {
            System.out.println("Thread: " + threadName + ", " + i);

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.out.println("Thread " + threadName + " interrupted.");
            }
        }
        System.out.println(threadName + " exiting.");
    }

    public void start() {
        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}

public class multiThreadingPractice2 {
    public static void main(String[] args) {
        RunnableDemo T1 = new RunnableDemo("Thread-1");
        System.out.println("Thread State of T1 before calling start: "+T1.getState());
        T1.start();

        RunnableDemo T2 = new RunnableDemo("Thread-2");
        T2.start();

    }
}
