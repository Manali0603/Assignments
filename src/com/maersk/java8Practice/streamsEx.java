package com.maersk.java8Practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                "}\n";
    }


}

public class streamsEx {


    static double increment(double sal) {

        if (sal * 12 < 200000)
            sal = sal + (.15 * 200000);

        else
            sal = sal + (.05 * 200000);

        return sal;
    }

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(new Employee(91, "Zoya", 22, 10000),
                new Employee(96, "Siri", 23, 18000),
                new Employee(99, "Ankita", 21, 15000),
                new Employee(90, "Manali", 25, 20000));


//        List<Double> filteredEmployees = employees
//                .stream()
//                .map((emp -> streamsEx.increment(emp.salary)))
//                .collect(Collectors.toList());

       List<Employee> ls=employees.stream().map(e->{
           double sal=streamsEx.increment(e.salary);
           e.setSalary(sal);
           return e;
       }).collect(Collectors.toList());

       //map.values().stream()
        //            .flatMap(m -> m.values().stream())
        //            .forEach(l -> l.sort(cmp.thenComparing(cmp1)));

        Comparator<Employee> compareByName = Comparator
                .comparing(Employee::getName);
        List<Employee> sortedEmployees = employees.stream()
                .sorted(compareByName)
                .collect(Collectors.toList());
        System.out.println("Based on Names : \n"+sortedEmployees);

        Comparator<Employee> compareBySalary = Comparator
                .comparing(Employee::getSalary);

        List<Employee> sortedEmployees1 = employees.stream()
                .sorted(compareBySalary)
                .collect(Collectors.toList());
        System.out.println("Based on Salary : \n"+sortedEmployees1);

    }
}
