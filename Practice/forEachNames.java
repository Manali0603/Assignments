import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class forEachNames {
    public static void main(String[] args) {
        List<String> names = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);
        String name;
        System.out.println("Enter the names : ");
        for (int i = 0; i < 5; i++) {
            name = sc.nextLine();
            names.add(name);
        }

        //Printing the names before sort
        System.out.println("\nBefore Sorting : ");
        names.forEach(value -> System.out.print(value + " "));
        System.out.println("\n");
        String temp;


        //Sorting the names of list
        for (int i = 0; i < names.size(); i++) {
            for (int j = i + 1; j < names.size(); j++) {
                String eli = names.get(i), elj = names.get(j);
                if (eli.compareTo(elj) > 0) {
                    String tmp = eli;
                    eli = elj;
                    elj = tmp;
                    names.set(i, eli);
                    names.set(j, elj);
                }
            }
        }

        //Printing the list of names after sorting
        System.out.println("After Sorting : ");
        names.forEach(value -> System.out.print(value + " "));

    }
}
