package coreJavaAssignment1;

import java.util.Scanner;

class Date {
    static int MAX_VALID_YR = 9999;
    static int MIN_VALID_YR = 1800;
    int d, m, y;

    Date(int d, int m, int y) {
        this.d = d;
        this.m = m;
        this.y = y;
    }

    static boolean isLeap(int year) {
        return (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0));
    }


    static boolean isValidDate(int d, int m, int y) {

        if (y > MAX_VALID_YR || y < MIN_VALID_YR)
            return false;
        if (m < 1 || m > 12)
            return false;
        if (d < 1 || d > 31)
            return false;
        if (m == 2) {
            if (isLeap(y))
                return (d <= 29);
            else
                return (d <= 28);
        }
        if (m == 4 || m == 6 || m == 9 || m == 11)
            return (d <= 30);
        return true;

    }
}

class Employee {
    int empNum = 0;
    String empName = "n";
    Date joiningDate = null;
}

public class q5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Employee[] emp = new Employee[5];
        for (int i = 0; i < 1; i++) {
            Employee empNew = new Employee();
            System.out.println("enter employee number of " + (i + 1) + " employee");
            empNew.empNum = input.nextInt();
            input.nextLine();
            System.out.println("enter employee name of " + (i + 1) + " employee");
            empNew.empName = input.nextLine();
            System.out.println("enter employee joining date  of " + (i + 1) + " employee");
            int d, m, y;
            d = input.nextInt();
            m = input.nextInt();
            y = input.nextInt();

            if (Date.isValidDate(d, m, y)) {
                empNew.joiningDate = new Date(d, m, y);
            } else
                System.out.println("Invalid Date");

            emp[i] = empNew;
        }
        String employeeName = "Employee Name";
        String employeeNumber = "Employee Number";
        String joinDate = "Joining Date";
        System.out.printf("%-20s %-20s %s\n", employeeNumber, employeeName, joinDate);
        for (int i = 0; i < 5; i++) {
            System.out.printf("%-20s %-20s %s.%s.%s\n", emp[i].empNum, emp[i].empName, emp[i].joiningDate.d, emp[i].joiningDate.m, emp[i].joiningDate.y);
        }

    }
}

