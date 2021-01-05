package polymorphismAndInheritanceAssignment2;

abstract class Instrument {
    public abstract void play();
}

class Piano extends Instrument {

    @Override
    public void play() {
        System.out.println("Piano is playing  tan tan tan tan  ");
    }
}

class Flute extends Instrument {

    @Override
    public void play() {
        System.out.println("Flute is playing  toot toot toot toot");
    }
}

class Guitar extends Instrument {

    @Override
    public void play() {
        System.out.println("Guitar is playing  tin  tin  tin ");
    }
}

public class Question1 {
    public static void main(String[] args) {
        Instrument[] instrument = new Instrument[10];
        instrument[0] = new Piano();
        instrument[1] = new Flute();
        instrument[2] = new Guitar();
        instrument[3] = new Piano();
        instrument[4] = new Flute();
        instrument[5] = new Guitar();
        instrument[6] = new Piano();
        instrument[7] = new Flute();
        instrument[8] = new Guitar();
        instrument[9] = new Piano();
        for (int i = 0; i < instrument.length; i++) {
            if (instrument[i] instanceof Piano) {
                System.out.println(" It is a Piano");
                instrument[i].play();
            }

            if (instrument[i] instanceof Flute) {
                System.out.println("It is a Flute");
                instrument[i].play();
            }
            if (instrument[i] instanceof Guitar) {
                System.out.println("It is a Guitar");
                instrument[i].play();
            }

        }
    }
}

