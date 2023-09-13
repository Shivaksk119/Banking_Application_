package Banking;

public class SVbank implements RBI {

    private String accNo;
    private int balance;
    private String password;

    public static final double rateofInterest = 8.4;

    public SVbank(String accNo, int balance, String password) {
        this.accNo = accNo;
        this.balance = balance;
        this.password = password;
    }


    @Override
    public String checkBalance(String enteredPassword) {
        //validate password
        if(!enteredPassword.equals(password)){
            return "!!Sorry... Entered Password is incorrect";
        }
        return "Your current bank balance is: "+balance;
    }

    @Override
    public String depositMoney(String enteredPassword, int money) {

        if(!enteredPassword.equals(password)){
            return "!!Sorry... Entered Password is incorrect.";
        }
        balance+=money;
        return "Your current balance after adding money is: "+balance+".";
    }

    @Override
    public String withDrawMoney(String enteredPassword, int money) {
        if(!enteredPassword.equals(password)){
            return "!!Sorry... Entered Password is incorrect.";
        }

        //condition insufficient balance
        if(balance<money) {
            return "!!Oops... Insufficient Balance in your bank.";
        }

        //condition : should maintain a min balance of RS.5000
        if((balance-money)<5000) {
            return "Sorry unable to withdraw money... Please maintain a min balance of Rs.5000.";
        }

        balance-=money;
        return "Money Withdrawn is of: "+money+'\n'+"Remaining amount in your bank is: "+balance+".";
    }

    @Override
    public double calculateSimpleInterest(int years) {
        return (rateofInterest*years*balance*1.00)/100;
    }
}
