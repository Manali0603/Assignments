package com.maersk.java8Practice;

import java.util.ArrayList;
import java.util.List;

class Student {
    String name;
    int age;

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    Student(String n, int a ){
        name = n;
        age = a;

    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class forEachEx {
    public static void main(String[] args) {
        List<Student> studentDetails = new ArrayList<Student>();
        studentDetails.add(new Student("manali", 22));
        studentDetails.add(new Student("Siri", 19));
        studentDetails.add(new Student("ankita", 23));
        studentDetails.add(new Student("sowmya", 20));
        studentDetails.add(new Student("zoya", 18));

        //Before sorting
        System.out.println("Before Sorting the student data:");
        studentDetails.forEach((s)->System.out.println(s));

        //sort according to the age
        studentDetails.sort((Student s1, Student s2)->s1.getAge()-s2.getAge());
        System.out.println("\nAfter Sorting the student data according to age :");
        studentDetails.forEach((s)->System.out.println(s));

        //sort according to name
        studentDetails.sort((Student s1, Student s2)->s1.getName().compareTo(s2.getName()));
        System.out.println("\nAfter Sorting the student data according to name :");
        studentDetails.forEach((s)->System.out.println(s));
    }
}
