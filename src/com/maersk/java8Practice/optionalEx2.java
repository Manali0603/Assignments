package com.maersk.java8Practice;


import java.util.Optional;

public class optionalEx2 {
    public static int sum(Optional<Integer> a, Optional<Integer> b) {

        // checks the value is present or not
        System.out.println("First parameter is present: " + a.isPresent());
        System.out.println("Second parameter is present: " + b.isPresent());

        // returns the value if present otherwise returns the default value passed.
        Integer value1 = a.orElse(1);

        //Optional.get - gets the value, value should be present
        Integer value2 = b.get();
        return value1 + value2;
    }

    public static void main(String[] args) {
        optionalEx2 test = new optionalEx2();
        Integer value1 = null;
        Integer value2 = 10;

        // allows passed parameter to be null.
        Optional<Integer> a = Optional.ofNullable(value1);

        // throws NullPointerException if passed parameter is null
        Optional<Integer> b = Optional.of(value2);
        System.out.println("The sum is : "+sum(a, b));
    }


}
