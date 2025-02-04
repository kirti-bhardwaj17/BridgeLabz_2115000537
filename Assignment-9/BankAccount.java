import java.util.*;
class Bank {
 static String BankName = "Divyansh Bank";
 static int acc = 0;
 String AccountHolder;
 final int AccountNumber;
Bank(String AccountHolder, int AccountNumber) {

        this.AccountHolder = AccountHolder;
        this.AccountNumber = AccountNumber;
        acc++;
    }
    public void Display() {
        System.out.println("BANK NAME IS: " + BankName);
        System.out.println("Account Holder: " + AccountHolder);
        System.out.println("Account Number: " + AccountNumber);
    }

    public static void getTotalAccounts() {
        System.out.println("Total Accounts: " + acc);
    }
}

public class BankAccount {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Account Holder Name: ");
        String accHolder1 = scanner.nextLine();
        System.out.print("Enter Account Number: ");
        int accNumber1 = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Account Holder Name: ");
        String accHolder2 = scanner.nextLine();
        System.out.print("Enter Account Number: ");
        int accNumber2 = scanner.nextInt();

        Bank account1 = new Bank(accHolder1, accNumber1);
        Bank account2 = new Bank(accHolder2, accNumber2);

        account1.Display();
        account2.Display();

        Bank.getTotalAccounts();
}
}
