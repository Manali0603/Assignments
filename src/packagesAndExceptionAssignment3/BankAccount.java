package packagesAndExceptionAssignment3;

public class BankAccount {
    int accNo;
    String custName ;
    String accType;
    float balance;

    public BankAccount(int account_number, String name, String account_type,
                       double balance) {

        accNo = account_number;
        custName = name;
        accType = account_type;
        this.balance = (float) balance;
        if(accType.equals("Savings"))
        {
            if (balance<1000)
            {
                try
                {
                    throw new NumberFormatException();
                }
                catch(NumberFormatException nf)
                {
                    System.out.println("Account Balance is low");
                }
            }
        }
        if(accType.equals("Current"))
        {
            if (balance<5000)
            {
                try
                {
                    throw new NumberFormatException();
                }
                catch(NumberFormatException nf)
                {
                    System.out.println("Account Balance  is low");
                }
            }
        }
    }
    void deposit(float amt) {
        if(amt<0)
        {
            try
            {
                throw new NumberFormatException();
            }
            catch(NumberFormatException nf)
            {
                System.out.println("Negative Amount cannot be deposited");
            }
        }
        else
        {
            balance=getBalance()+amt;
            System.out.println("Current balance is ="+balance);

        }
    }

    public void withdraw(double amt)
    {
        if (accType.equals("Savings")) {
            if (amt < 1000) {
                try {
                    throw new NumberFormatException();
                } catch (NumberFormatException nf) {
                    System.out.println("WE CANNOT DEPOSIT AMOUNT INSUFFICIENT BALANCE ");
                }
            } else {
                balance = (float) (getBalance() - amt);
                System.out.println("Current balance is =" + balance);

            }
        }
        if (accType.equals("Current"))
        {
            if (amt < 5000) {
                try {
                    throw new NumberFormatException();
                } catch (NumberFormatException nf) {
                    System.out.println("WE CANNOT DEPOSIT AMOUNT INSUFFICIENT BALANCE ");
                }
            } else {
                balance = (float) (getBalance() - amt);
                System.out.println("Current balance is =" + balance);

            }
        }
        deposit((float) amt);
    }
    float getBalance () {
        if( balance <1000)
        {
            try
            {
                throw new NumberFormatException();
            }
            catch(NumberFormatException nw)
            {
                System.out.println("Balance is low"+balance);
            }
        }
        return balance;
    }

    public static void main(String[] args) {
        BankAccount bank=new BankAccount(10006755,"Manali","Savings",500.50);
        float balance =bank.getBalance();
        System.out.println(balance);
        bank.deposit(10.89f);
        bank.withdraw(-20.5f);
        bank.deposit(2000.0f);
    }

}


