package Banking;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);// to get inputs

        System.out.println("In Which bank you would like to create an account:"+'\n'+"1.SKbank"+'\n'+"2.SVbank"+'\n'+"Please Enter the exact name of the bank you choose.");

        String bank = sc.nextLine();

        System.out.println("Please enter your Full Name.");

        String name = sc.nextLine();

        System.out.println("Please enter your Account Number.");

        String accNo = sc.next();

        System.out.println("Enter your password.");

        String password = sc.next();

        System.out.println("Enter the amount you would like to deposit.");

        int amount = sc.nextInt();

        RBI bankAccount;

        if(bank.equals("SKbank")) {
            bankAccount = new SKbank(accNo, amount, password);
            System.out.println("Welcome to SK Bank Mr."+name+". Your account got created successfully.");
            System.out.println();
            System.out.println("Your Account details are: "+'\n'+"Account Holder Name: "+name+'\n'+"Account Number: "+accNo);
            System.out.println();
            System.out.println(bankAccount.checkBalance(password));
        }
        else {
            bankAccount = new SVbank(accNo, amount, password);
            System.out.println("Welcome to SV Bank Mr."+name+". Your account got created successfully.");
            System.out.println();
            System.out.println("Your Account details are: "+'\n'+"Account Holder Name: "+name+'\n'+"Account Number: "+accNo);
            System.out.println();
            System.out.println(bankAccount.checkBalance(password));
        }
        System.out.println();

        System.out.println("Would you like to proceed further or close the application."+'\n'+"Please enter YES to proceed or NO to close.(Note: it's Case Sensitive)");

        String userInput = sc.next();

        if(userInput.equals("YES")) {

            int option = 0;

            while(true) {
                System.out.println("What would you like do:"+'\n'+"1.Check Balance"+'\n'+"2.WithDraw Money"+'\n'+"3.Deposit Money"+'\n'+"4.Check Simple Interest"+'\n'+"5.Close Application"+'\n'+"Please enter serial number as input to process.");

                option = sc.nextInt();

                String response = null;

                if(option == 1) {
                    response = bankAccount.checkBalance(password);
                    System.out.println(response);
                    System.out.println();
                }
                else if(option == 2){
                    System.out.println("Enter the amount you would like to Withdraw.");
                    int money = sc.nextInt();
                    response = bankAccount.withDrawMoney(password, money);
                    System.out.println(response);
                }
                else if(option == 3){
                    System.out.println("Enter the amount you would like to deposit.");
                    int money = sc.nextInt();
                    response = bankAccount.depositMoney(password, money);
                    System.out.println(response);
                }
                else if(option == 4){
                    System.out.println("Enter the No.of years that you would like the rate of interest.");
                    int years = sc.nextInt();
                    System.out.println(bankAccount.calculateSimpleInterest(years));
                }
                else {
                    System.out.println("Thank you!. Have a Nice day.");
                    break;
                }
            }
            
        }
        else {
            System.out.println("Thank you!. Have a Nice day.");
        }

    }
}