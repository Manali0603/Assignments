package com.maersk.java8Practice;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class reduceEx {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{78, 23, 89, 100, 15, 63, 72};
        System.out.println(arr);

        //CONVERTING THE ARRAY INTO LIST
        List<Integer> listOfIntegers = Arrays.asList(arr);

        //CALCULATING THE MAX
        Optional<Integer> max = listOfIntegers.stream().reduce(Math::max);


        //CALCULATING THE SUM
        int sum = listOfIntegers.stream().reduce(0, (el1, el2) -> el1 + el2);

        //PRINTING THE MAX AND THE SUM
        System.out.println("THE SUM = " + sum + "\n" + "THE MAX = " + max);

        List<String> names = Arrays.asList("manali", "siri", "aditya", "subhransu", "ankita");

        //COMBINE ALL NAMES INTO SINGLE STRING
        Optional<String> combine = names.stream().reduce((el1, el2) -> el1 + "-" + el2);

        //FIND THE LONGEST NAME
        Optional<String> maxLength = names.stream().reduce((el1, el2) -> (el1.length() > el2.length()) ? el1 : el2);

        //SORTING THE NAMES
        List<String> sortingNames = names.stream().sorted().collect(Collectors.toList());

        //PRINT THE COMBINE AND MAX-LENGTH
        System.out.println("\nAFTER COMBINING -> " + combine + "\nLONGEST NAME -> " + maxLength + "\nSORTED NAMES -> " + sortingNames);


        String[] studentList=new String[]{"Shreya","Aditya","Zoya","Rehmaan","Jasmine","Priya"};
        Arrays.sort(studentList,String::compareTo);
        System.out.println("\nSORTING THE NAMES USING METHOD REFERENCE -> ");
        for(String str: studentList)
            System.out.print(str+" ");
        //System.out.println(studentList);


    }
}
