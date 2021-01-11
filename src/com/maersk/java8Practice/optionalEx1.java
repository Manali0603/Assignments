package com.maersk.java8Practice;

import java.util.Optional;

public class optionalEx1 {
    public static void main(String[] args) {
        String[] str = new String[10];
        Optional<String> optional = Optional.ofNullable(str[8]);
        if (optional.isEmpty())
            System.out.println("No value present");
        else
            System.out.println(str[8].toLowerCase());

        //isPresent() checks if present or not
        str[8]="ManALi";
        Optional<String> optional1 = Optional.ofNullable(str[8]);
        if(optional1.isPresent())
            System.out.println(str[8].toLowerCase());
        else
            System.out.println("No value present");
    }
}
