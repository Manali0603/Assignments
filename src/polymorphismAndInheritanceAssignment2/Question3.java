package polymorphismAndInheritanceAssignment2;

import java.util.Random;

class Medicine {
    String name;
    String address;

    void displayLabel() {
        name = "Zincon Medicines";
        address = "India";
        System.out.println(name + "  " + address);
    }
}

class Tablet extends Medicine {
    void displayLabel() {
        System.out.println("store in cool n dry place");
    }
}

class Syrup extends Medicine {
    void displayLabel() {
        System.out.println("take after taking food");
    }
}

class Ointment extends Medicine {
    void displayLabel() {
        System.out.println("for external use only");
    }
}

class TestMedicine {
    public static void main(String[] args) {
        Medicine m[] = new Medicine[10];
        Random rand = new Random();
        int i = rand.nextInt((4 - 1) + 1) + 1;
        System.out.println(i);
        switch (i) {
            case 1:
                m[0] = new Medicine();
                m[1] = new Tablet();
                m[0].displayLabel();
                m[1].displayLabel();
                break;

            case 2:
                m[2] = new Medicine();
                m[3] = new Syrup();
                m[2].displayLabel();
                m[3].displayLabel();
                break;
            case 3:
                m[4] = new Medicine();
                m[5] = new Ointment();
                m[4].displayLabel();
                m[5].displayLabel();
                break;
            default:
                System.out.println("Invalid Choice");
        }
    }
}

