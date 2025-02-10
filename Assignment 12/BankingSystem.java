import java.util.*;
abstract class BankAccount{
	private int accountNumber;
	private String holderName;
	private double balance;
	public BankAccount(int accountNumber , String holderName , double balance){
	this.accountNumber = accountNumber;
	this.holderName = holderName;
	this.balance = balance;
	}
	public int getAccountNumber(){
	return accountNumber;
	}
	public String getholderName(){
	return holderName;
	}
	public double getbalance(){
	return balance;
	}
	public void deposit(double amount){
	System.out.println("Total balance is "+(balance+amount));
	}
	public void withdraw(double amount){
	System.out.println("Total balance is  "+(balance-amount));
	}
	public abstract double calculateInterest();
}
interface Loanable{
	void applyForLoan();
	void calculateLoanEligibility();
	}
class SavingsAccount extends BankAccount implements Loanable{
	public SavingsAccount(int accountNumber,String holderName, double balance){
	super(accountNumber, holderName, balance);
	}
	public double calculateInterest(){
	return getbalance()*0.05;
	}
	public void applyForLoan() {
        System.out.println(getholderName() + " has applied for a loan.");
    }

    public void calculateLoanEligibility() {
        if (getbalance() > 5000) {
            System.out.println(getholderName() + " is eligible for a loan.");
        } else {
            System.out.println(getholderName() + " is not eligible for a loan.");
        }
    }
}
	
class CurrentAccount extends BankAccount implements Loanable{
        public CurrentAccount(int accountNumber,String holderName, double balance){
        super(accountNumber, holderName, balance);
        }
        public double calculateInterest(){
        return getbalance()*0.07;
        }
public void applyForLoan() {
        System.out.println(getholderName() + " has applied for a loan.");
    }

    @Override
    public void calculateLoanEligibility() {
        if (getbalance() > 5000) {
            System.out.println(getholderName() + " is eligible for a loan.");
        } else {
            System.out.println(getholderName() + " is not eligible for a loan.");
        }
    }

        }
public class BankingSystem{
	public static void main(String args[]){
	List<BankAccount> Accounts = new ArrayList<>();
	Accounts.add(new SavingsAccount(1028979334 , "Kirti" , 9000089));
	Accounts.add(new CurrentAccount(465767862, "Divi" , 100000079));
	double amount = 6000;
	for(BankAccount account : Accounts){
	System.out.println("\nAccount Holder: "+ account.getholderName());
	 System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Balance: ₹" + account.getbalance());
            System.out.println("Interest Earned: ₹" + account.calculateInterest());

	account.deposit(amount);
	account.withdraw(amount);
if(account instanceof Loanable){
	Loanable loanableac = (Loanable) account;
	loanableac.applyForLoan();
	loanableac.calculateLoanEligibility();
}

	
}

}
}
