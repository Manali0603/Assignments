package packagesAndExceptionAssignment3.techm.itp.hyd1706333;

public class Greeter {
    String name;
    public Greeter(String name)
    {
        this.name=name;
    }
    public String sayHello(String name)
    {
        String helloMessage="HELLO "+name;
        return helloMessage;
    }
    public String sayGoodBye(String name)
    {
        String goodByeMessage="GOOD BYE!"+name;
        return goodByeMessage;
    }

}
