package com.maersk.java8Practice;

import java.util.Scanner;

@FunctionalInterface
interface Type1 {
    String show();

    default void display() {
        System.out.println("This is a default method.");
    }
}

@FunctionalInterface
interface Type2 {
    int calculateSquare(int num);

    default void display() {
        System.out.println("It is not mandatory to call this method.");
    }
}

@FunctionalInterface
interface Type3 {
    Boolean Compare(int a, int b);
}

public class functionalInterfaceEx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two numbers : ");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        Type1 type1 = () -> {
            System.out.println("This is a parameter-less functional interface .");
            int a = 26, b = 100;
            int avg = (a + b) / 2;
            return "the average of a and b = " + avg;
        };
        System.out.println(type1.show());

        Type2 square = (num) -> num * num;
        System.out.println("\nSquare of the first number " + num1 + " is : " + square.calculateSquare(num1));

        Type3 type3 = (int a, int b) -> {
            if (a > b)
                return true;
            else
                return false;
        };
        System.out.println("\nComparing the two numbers " + num1 + " and " + num2 + " is : " + type3.Compare(num1, num2));
    }

}
