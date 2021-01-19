package com.maersk.java8Practice;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;


class Employee1 {
    long id;
    String name;
    int age;
    double salary;

    Employee1(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return " Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                "}\n";
    }

    public String displayEmpName() {
        return this.name;
    }
}

public class reduceEx1 {
    public static void main(String[] args) {
        List<Employee1> employees = Arrays.asList(new Employee1(91, "Zoya", 24, 10000),
                new Employee1(96, "Swati", 23, 18000),
                new Employee1(99, "Ankita", 21, 15000),
                new Employee1(90, "Manali", 25, 20000),
                new Employee1(98, "Sriti", 26, 25000),
                new Employee1(94, "Siri", 22, 16000));


        //FINDING THE DETAILS OF EMPLOYEE HAVING MAXIMUM SALARY
        Optional<Employee1> maxSal = employees.stream().reduce((e1, e2) -> e1.getSalary() > e2.getSalary() ? e1 : e2);
        System.out.println("EMPLOYEE WITH MAXIMUM SALARY : ");
        maxSal.ifPresent(System.out::println);

        //FINDING THE DETAILS OF EMPLOYEE HAVING MINIMUM SALARY
        Optional<Employee1> minSal = employees.stream().reduce((e1, e2) -> e1.getSalary() < e2.getSalary() ? e1 : e2);
        System.out.println("EMPLOYEE WITH MINIMUM SALARY : ");
        minSal.ifPresent(System.out::println);


        //CALCULATING THE SUM OF ALL EMPLOYEES' AGE
        Consumer<List<Employee1>> totalAge = l -> System.out.println("Total Age is : " +
                l.stream()
                        .mapToInt(Employee1::getAge)
                        .reduce(0, (val1, val2) -> (val1 + val2)));

        totalAge.accept(employees);


        //JOINING THE NAMES OF EMPLOYEES
        List<String> empNames = employees.stream().map(u -> u.displayEmpName()).collect(Collectors.toList());
        String r = (String) Arrays.stream(empNames.toArray()).reduce("", (a, b) -> {
            if (!"".equals(a)) {
                return a + "|" + b;
            } else {
                return b;
            }
        });
        System.out.println("THE NAMES AFTER JOINING : " + r);

    }
}
