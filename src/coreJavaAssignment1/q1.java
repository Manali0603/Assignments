package coreJavaAssignment1;

import java.util.Scanner;

public class q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        for (int i = 0; i <= n; i++) {
            if (i % 2 == 0)
                count++;
        }
        System.out.println("Number of even numbers = " + count);
    }
}
