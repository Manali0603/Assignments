package packagesAndExceptionAssignment3.techm.itp.hyd1706333;

import java.util.Random;

public class Advisor {
    String[] messages = new String[5];

    public Advisor() {
        messages[0] = "The secrete to success is constancy.";
        messages[1] = "Take time to know yourself.";
        messages[1] = "Don't make assumptions";
        messages[1] = "Be patient and persistent";
        messages[1] = " In order to get, you have to give";
    }

    public String getAdvice() {
        Random random = new Random();
        int rand = random.nextInt(5);
        return messages[rand];
    }
}
