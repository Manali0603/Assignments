package com.maersk.java8Practice;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class forEachConsumerEx2 {
    public static void main(String[] args) {
        Consumer<List<Integer>> findMax = list -> {
            int max = 0;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) > max)
                    max = list.get(i);
            }
            System.out.println("Largest number is : " + max);
        };

        Consumer<List<Integer>> display = list -> list.forEach(a -> System.out.println(a + " "));
        List<Integer> list = new ArrayList<>();

        list.add(67);
        list.add(23);
        list.add(100);
        list.add(65);
        list.add(45);


        display.accept(list);
        findMax.accept(list);

    }
}
