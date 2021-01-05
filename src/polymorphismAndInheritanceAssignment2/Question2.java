package polymorphismAndInheritanceAssignment2;

import java.util.Random;

abstract class Compartment {
    public abstract void notice();
}

class FirstClass extends Compartment {

    @Override
    public void notice() {
        System.out.println("Notice : You are in First-class Compartment");

    }
}

class Ladies extends Compartment {

    @Override
    public void notice() {
        System.out.println("Notice : No gents allowed here ");

    }
}

class General extends Compartment {
    @Override
    public void notice() {
        System.out.println("Notice : You are in General Compartment ");
    }
}

class Luggage extends Compartment {
    @Override
    public void notice() {
        System.out.println("Notice : Keep your luggage at your own risk");

    }
}

class TestCompartment {
    public static void main(String[] args) {
        Compartment[] compartments = new Compartment[10];

        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            int randomNumber = rand.nextInt((4 - 1) + 1) + 1;

            if (randomNumber == 1)
                compartments[i] = new FirstClass();
            else if (randomNumber == 2)
                compartments[i] = new Ladies();
            else if (randomNumber == 3)
                compartments[i] = new General();
            else if (randomNumber == 4)
                compartments[i] = new Luggage();

            compartments[i].notice();
        }
    }
}
