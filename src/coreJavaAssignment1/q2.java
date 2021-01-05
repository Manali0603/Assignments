package coreJavaAssignment1;

import java.util.Scanner;

class Rectangle {
    private double length;
    private double width;

    public Rectangle() {
        length = 0.0;
        width = 0.0;
    }

    public Rectangle(double l, double w) {
        length = l;
        width = w;
    }

    public void set(double l, double w) {
        length = l;
        width = w;
    }

    public double getArea() {
        return length * width;
    }

    public double getPerimeter() {
        return 2 * (length + width);
    }

    void display() {
        System.out.println("area = " + getArea());
        System.out.println("perimeter  = " + getPerimeter());
    }
}

public class q2 {

    public static void main(String[] args) {
        double length, breadth;
        Scanner sc = new Scanner(System.in);
        length = sc.nextDouble();
        breadth = sc.nextDouble();
        Rectangle r = new Rectangle();
        Rectangle r1 = new Rectangle(length, breadth);
        r1.display();
        double length2, breadth2;
        length2 = sc.nextDouble();
        breadth2 = sc.nextDouble();
        Rectangle r2 = new Rectangle(length2, breadth2);
        r2.display();
        double length3, breadth3;
        length3 = sc.nextDouble();
        breadth3 = sc.nextDouble();
        Rectangle r3 = new Rectangle(length3, breadth3);
        r3.display();
        double length4, breadth4;
        length4 = sc.nextDouble();
        breadth4 = sc.nextDouble();
        Rectangle r4 = new Rectangle(length4, breadth4);
        r4.display();

    }
}
