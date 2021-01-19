package com.maersk.java8Practice;

import java.util.*;
import java.util.function.Consumer;

class Employee {
    long id;
    String name;
    int age;
    double salary;

    Employee(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getId() {
        return (int) id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
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
}

public class streamsEx {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(new Employee(91, "Zoya", 22, 10000),
                new Employee(96, "Siri", 23, 18000),
                new Employee(99, "Ankita", 21, 15000),
                new Employee(90, "Manali", 25, 20000),
                new Employee(98, "Manali", 22, 15000),
                new Employee(94, "Siri", 22, 15000));

        //INCREMENTING THE SALARIES BASED ON ANNUAL SALARY
        Consumer<List<Employee>> empSalIncrement = list -> {
            for (int i = 0; i < employees.size(); i++) {
                double sal = list.get(i).getSalary();
                if (sal * 12 < 200000)
                    sal += sal * 0.15;
                else
                    sal += sal * 0.05;
                Employee e = new Employee(list.get(i).getId(), list.get(i).getName(), list.get(i).getAge(), sal);
                list.set(i, e);
            }
        };

        //sorting by name
        Consumer<List<Employee>> printEmployees = list -> list
                .stream()
                .sorted(Comparator.comparing(Employee::getName))
                .forEach(e -> System.out.println("SORTING BY NAME : " + e));
        //sorting by salary
        Consumer<List<Employee>> printEmployees1 = list -> list
                .stream()
                .sorted((Employee e1, Employee e2) -> (int) (e1.getSalary() - e2.getSalary()))
                .forEach(e -> System.out.println("SORTING BY SALARY : " + e));


        //counting the occurrence of same names
        Consumer<List<Employee>> countOccurance;
        countOccurance = c -> {
            Map<String, Integer> count = new HashMap<>();
            for (Employee employee : employees) {
                if (count.containsKey(employee.getName())) {
                    String keyName = employee.getName();
                    int valCount = count.get(keyName);
                    count.put(keyName, ++valCount);
                } else {
                    int j = 0;
                    count.put(employee.getName(), ++j);
                }
            }
            System.out.println(count);
        };


        //printing according to sorted names and sorted salaries
        empSalIncrement.andThen(printEmployees).andThen(printEmployees1).accept(employees);

        //printing the occurrence of names
        System.out.println("Printing the occurrence of names :");
        countOccurance.accept(employees);


    }
}
