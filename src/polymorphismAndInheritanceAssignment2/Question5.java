package polymorphismAndInheritanceAssignment2;

class Car {
    private int speed, noOfGear;

    public void drive() {
        speed = 60;
        noOfGear = 4;
    }

    public void display() {
        System.out.println("Speed is " + speed + "\nNo. of gears are " + noOfGear);
    }
}

class SportCar extends Car {
    private String s = "Air Ballon Type";

    public void display() {
        super.display();
        System.out.println("Spl Feature : " + s);
    }
}

public class Question5 {
    public static void main(String[] args) {
        SportCar sc = new SportCar();
        sc.drive();
        sc.display();
    }

}
