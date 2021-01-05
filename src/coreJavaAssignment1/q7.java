package coreJavaAssignment1;

public class q7 {
    public static void main(String[] args) {
        System.out.println("Initially : " + args[0] + " " + args[1]);
        int second_last = Integer.parseInt(args[0]);
        int last = Integer.parseInt(args[1]);
        for (int i = 1; i <= 13; i++) {
            int new_num = second_last + last;
            System.out.println(new_num);
            second_last = last;
            last = new_num;
        }
    }
}
