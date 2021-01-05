package coreJavaAssignment1;

public class q8 {
    public static void main(String[] args) {
        for (String i : args) {
            System.out.println(i);
        }
        System.out.println("-----------------------------");
        int a[] = {35, 29, 20, 3, 8};
        int num1 = Integer.parseInt(args[0]); //3
        int num2 = Integer.parseInt(args[1]);  //20
        Boolean b1 = false, b2 = false;
        for (int i : a) {
            if (i == num1)
                b1 = true;
            if (i == num2)
                b2 = true;
        }
        System.out.println("Your First Number is : " + num1);
        System.out.println("Your Second Number is : " + num2);
        if (b1 && b2)
            System.out.println("BINGO!");
        else
            System.out.println("Not Found !");

    }
}
