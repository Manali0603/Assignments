import java.util.Scanner;

@FunctionalInterface
interface Addition
{
    int findAddition(int a,int b);

}
@FunctionalInterface
interface Subtraction
{
    int findSubtraction(int a,int b);

}
@FunctionalInterface
interface Multiplication
{
    int findMultiplication(int a,int b);

}
@FunctionalInterface
interface Division
{
    int findDivision(int a,int b);

}
public class functionalInterface1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the numbers :");
        int num1= sc.nextInt();
        int num2=sc.nextInt();
         System.out.println("Enter your option : ");
        int option=sc.nextInt();
        switch (option)
        {
            case 1:
            {
                Addition add=(int a,int b)->a+b;
                System.out.println("Addition = "+add.findAddition(num1,num2));
            }
            case 2:
            {
                Subtraction sub=(int a,int b)->a-b;
                System.out.println("Subtraction = "+sub.findSubtraction(num1,num2));
                break;
            }
            case 3:
            {
                Multiplication mul=(int a,int b)->a*b;
                System.out.println("Multiplication = "+mul.findMultiplication(num1,num2));
                break;
            }
            case 4:
            {
                Division div=(int a,int b)->a+b;
                System.out.println("Division = "+div.findDivision(num1,num2));
                break;
            }
            default:
                System.out.println("Wrong input");
                break;
        }
    }
}
