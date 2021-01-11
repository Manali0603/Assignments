package com.maersk.java8Practice;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class forEachConsumerEx1 {
    public static void main(String[] args) {
        //consumer for the logic
        Consumer<List<Integer>> modifyList = list -> {
            for (int i = 0; i <list.size(); i++)
                list.set(i, 2 +list.get(i));

        };

        //consumer to display the elements
        Consumer<List<Integer>> displayList = list -> list.stream().forEach(a -> System.out.println(a + " "));

        //adding the elements to list
        List<Integer> list=new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(25);
        list.add(30);
        list.add(40);

        modifyList.accept(list);
        displayList.accept(list);

    }
}
