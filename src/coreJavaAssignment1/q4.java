package coreJavaAssignment1;

import java.util.Scanner;

class Rectangle1 {
    float length, breadth;

    Rectangle1() {
        length = 1;
        breadth = 1;
    }

    void set_length(float l) {
        if (l > 0.0f && l < 20.0f)
            length = l;
        else
            length = 1;
    }

    void set_breadth(float b) {
        if (b > 0.0f && b < 20.0f)
            breadth = b;
        else
            breadth = 1;
    }

    void calculate_area(float l, float b) {
        set_length(l);
        set_breadth(b);
        float area = length * breadth;
        System.out.println("area is : " + area);
    }

    void perimeter(float l, float b) {
        set_length(l);
        set_breadth(b);
        float pm = 2 * (length + breadth);
        System.out.println("perimeter is : " + pm);
    }

}

public class q4 {
    public static void main(String[] args) {
        Rectangle1 r = new Rectangle1();
        Scanner sc = new Scanner(System.in);
        float l = sc.nextFloat();
        float b = sc.nextFloat();
        r.set_length(l);
        r.set_breadth(b);
        r.calculate_area(l, b);
        r.perimeter(l, b);
    }
}
