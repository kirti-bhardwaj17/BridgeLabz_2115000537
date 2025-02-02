class BankAccount {
    public int accountNumber;
    protected String accountHolder;
    private double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

class SavingsAccount extends BankAccount {
    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
    }

    public static void main(String[] args) {
        SavingsAccount account = new SavingsAccount();
        account.accountNumber = 1001;
        account.accountHolder = "Alice";
        account.setBalance(2000);
        account.displayAccountDetails();
        System.out.println("Balance: " + account.getBalance());
    }
}
