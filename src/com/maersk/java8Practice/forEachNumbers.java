package com.maersk.java8Practice;

import java.util.*;

public class forEachNumbers {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int number;

        //taking user input
        System.out.println("Enter the numbers : ");
        for (int i = 0; i < 4; i++) {
            number = sc.nextInt();
            list.add(number);
        }

        //Printing the elements before sort
        System.out.println("Before Sorting : ");
        list.forEach((Integer num) -> System.out.print(num + " "));
        System.out.println("\n");


        //Sorting the elements of list
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                int eli = list.get(i), elj = list.get(j);
                if (eli > elj) {
                    int tmp = eli;
                    eli = elj;
                    elj = tmp;
                    list.set(i, eli);
                    list.set(j, elj);
                }
            }
        }

        //Printing the sorted elements
        System.out.println("After Sorting : ");
        list.forEach((Integer num) -> System.out.print(num + " "));


    }
}
