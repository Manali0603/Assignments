package com.maersk.atomicVariableAndConcurrentMap;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class concurrentMapExample {
    public static void main(String[] args) {
        ConcurrentMap<String, String> map = new ConcurrentHashMap<>();
        map.put("B1", "MANALI");
        map.put("B2", "SIRI");
        //map.put("B2", "MANYA");
        map.put("B7", "ANKITA");
        map.put("B9", "RIYA");

        map.forEach((key, value) -> System.out.printf("%s = %s\n", key, value));

        //The method putIfAbsent() puts a new value into the map only if no value exists for the given key.
        String newValue = map.putIfAbsent("B7", "ARYA");
        System.out.println(newValue);

        //The method getOrDefault() returns the value for the given key. In case no entry exists for this
        // key the passed default value is returned
        String getDefaultValue = map.getOrDefault("B5", "NOT PRESENT");
        System.out.println(getDefaultValue);

        //using replace-all()
        map.replaceAll((key, value) -> "B2".equals(key) ? "SHREYA" : value);
        System.out.println(map.get("B2"));

        //using Compute()
        map.compute("B2", (key, value) -> value + " MEHTA");
        System.out.println(map.get("B2"));

        //using merge()
        map.merge("B1", "MANALI NAIK", (oldVal, newVal) -> newVal + " was " + oldVal);
        System.out.println(map.get("B1"));
    }
}
