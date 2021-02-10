package com.maersk;

import java.util.Scanner;

class demoMultiThread implements Runnable {

    public void run() {
        int a, b;
        Scanner input = new Scanner(System.in);
        System.out.println("ENTER THE VALUES.....");
        a = input.nextInt();
        b = input.nextInt();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }

        System.out.println("Thread State of: " + Thread.currentThread().getName() + " - " + Thread.currentThread().getState());

        int answer = a * b;
        System.out.println("THE MULTIPLICATION IS : " + answer);

        System.out.println("Exit of Thread: " + Thread.currentThread().getName());


    }


}

public class multiThreadingPractice1 {
    public static void main(String[] args) {
        demoMultiThread demo = new demoMultiThread();
        Thread thread1 = new Thread(demo, "THREAD1");
        thread1.start();
        System.out.println("Thread State of thread1 in Main after start : " + thread1.getState());

        //SETTING THE PRIORITY OF THREAD
        thread1.setPriority(1);
        //PRINTING THE THREAD PRIORITY
        System.out.println("THREAD PRIORITY : " + thread1.getPriority());

    }
}
