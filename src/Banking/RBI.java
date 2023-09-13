package Banking;

public interface RBI {

    public String checkBalance(String password);

    public String depositMoney(String password, int money);

    public String withDrawMoney(String password, int money);

    //Changing password is my task

    public double calculateSimpleInterest(int years);
}
