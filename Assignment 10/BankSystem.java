import java.util.*;
class Account {
    private String accountNumber;
    private double balance;

    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds!");
        }
    }
}
class Customer {
    private String name;
    private ArrayList<Account> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void openAccount(Account account) {
        accounts.add(account);
    }

    public void viewBalances() {
        System.out.println(name + "'s Accounts:");
        for (Account account : accounts) {
            System.out.println("Account Number: " + account.getAccountNumber() + " | Balance: $" + account.getBalance());
        }
    }

    public void viewBalance(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                System.out.println("Account Number: " + account.getAccountNumber() + " | Balance: $" + account.getBalance());
                return;
            }
        }
        System.out.println("Account not found!");
    }

    public Account getAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
}
class Bank {
    private String name;
    private ArrayList<Customer> customers;

    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void openAccount(Customer customer, String accountNumber, double initialBalance) {
        Account newAccount = new Account(accountNumber, initialBalance);
        customer.openAccount(newAccount);
    }
}
public class BankSystem {
    public static void main(String[] args) {
        Bank bank = new Bank("Global Bank");

        Customer customer1 = new Customer("John Doe");
        Customer customer2 = new Customer("Jane Smith");

        bank.addCustomer(customer1);
        bank.addCustomer(customer2);

        bank.openAccount(customer1, "12345", 1000.0);
        bank.openAccount(customer1, "12346", 500.0);
        bank.openAccount(customer2, "54321", 2000.0);

        customer1.viewBalances();
        customer2.viewBalances();

        customer1.viewBalance("12345");
        customer1.viewBalance("12346");

        Account account1 = customer1.getAccount("12345");
        account1.deposit(500.0);
        account1.withdraw(200.0);

        customer1.viewBalance("12345");
    }
}


