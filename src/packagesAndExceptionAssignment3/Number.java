package packagesAndExceptionAssignment3;

import java.util.Scanner;

public class Number {
    int first_number;
    int second_number;
    double result;

    Number(int x, int y) {
        first_number = x;
        second_number = y;
    }

    public void add() {
        result = first_number + second_number;
        System.out.println("Addition is : " + result);
    }

    public void sub() {
        result = first_number - second_number;
        System.out.println("Subtraction is : " + result);
    }

    public void mul() {
        result = first_number * second_number;
        System.out.println("Multiplication is : " + result);
    }

    public void div() {
        try {
            result = first_number / second_number;
            System.out.println("Division is : " + result);
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by 0");
        }

    }

    public static void main(String[] args) {
        Number num = new Number(25, 0);
        Scanner in = new Scanner(System.in);
        int option = in.nextInt();
        switch (option) {
            case 1:
                num.add();
            case 2:
                num.sub();
            case 3:
                num.mul();
            case 4:
                num.div();
            default:
                System.out.println("You cannot enter more than 4");
        }
    }

}
