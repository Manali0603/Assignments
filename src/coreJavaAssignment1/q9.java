package coreJavaAssignment1;

public class q9 {
    public static void main(String[] args) {
        int arr[] = {3, 2, 4, 5, 6, 4, 5, 7, 3, 2, 3, 4, 7, 1, 2, 0, 0, 0};
        for (int i = 0; i < 18; i++)
            System.out.println(arr[i] + " ");
        System.out.println("-------------------------");
        int sum = 0, avg, smallest = arr[0];
        for (int i = 0; i < 18; i++) {
            if (i < 15)
                sum += arr[i];
            if (arr[i] < smallest)
                smallest = arr[i];
        }
        arr[15] = sum;
        arr[16] = sum / 18;
        arr[17] = smallest;
        System.out.println("After the alterations : ");
        for (int i = 0; i < 18; i++)
            System.out.println(arr[i]);
    }
}
