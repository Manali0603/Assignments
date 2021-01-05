package packagesAndExceptionAssignment3;

public class calcAverage {
    public double avgFirstN(int N)
    {
        if(N<0)
        {
            try{
                throw new NumberFormatException();
            }
            catch(NumberFormatException nf){
                System.out.println("We Must  Enter a Positive Number");
            }
        }
        else
        {
            int sum=0;
            for (int i=1;i<=N;i++)
                sum+=i;
            int average=sum/N;
            System.out.println("THe Average is  = "+average);
        }

        return N;
    }

    public static void main(String[] args) {
        calcAverage avg=new calcAverage();
        avg.avgFirstN(-20);
    }
}
