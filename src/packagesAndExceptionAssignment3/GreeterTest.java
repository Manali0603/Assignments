package packagesAndExceptionAssignment3;

import packagesAndExceptionAssignment3.techm.itp.hyd1706333.Advisor;
import packagesAndExceptionAssignment3.techm.itp.hyd1706333.Greeter;

public class GreeterTest {
    public static void main(String[] args) {
        //Greeter[] greet=new Greeter[args.length];
        for (int i = 0; i < args.length; i++) {
            Greeter greet = new Greeter(args[i]);
            System.out.println(greet.sayHello(args[i]));

        }
        Advisor advise = new Advisor();
        String message = advise.getAdvice();
        System.out.println(message);

        for (int i = args.length - 1; i >= 0; i--) {
            Greeter greet = new Greeter(args[i]);
            System.out.println(greet.sayGoodBye(args[i]));

        }

    }

}
