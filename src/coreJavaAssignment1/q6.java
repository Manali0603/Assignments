package coreJavaAssignment1;

public class q6 {
    public static int isPalindrome(String str) {
        int n = str.length();
        for (int i = 0; i < n / 2; i++)
            if (str.charAt(i) != str.charAt(n - i - 1))
                return 0;
        return 1;
    }

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            int res = isPalindrome(args[i]);
            System.out.println("length of string : " + args[i].toUpperCase() + " is ->" + args[i].length());

            if (res == 0)
                System.out.println("Not a palindrome\n");
            else
                System.out.println("Yes it is a palindrome\n");
        }
    }
}
