import java.util.*;

class BankingSystem {
    private Map<Integer, Double> accounts = new HashMap<>();
    private TreeMap<Double, Integer> sortedAccounts = new TreeMap<>();
    private Queue<Integer> withdrawalQueue = new LinkedList<>();

    public void createAccount(int accountNumber, double balance) {
        accounts.put(accountNumber, balance);
        sortedAccounts.put(balance, accountNumber);
    }

    public void requestWithdrawal(int accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            withdrawalQueue.add(accountNumber);
        }
    }

    public void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            int accountNumber = withdrawalQueue.poll();
            System.out.println("Processing withdrawal for account: " + accountNumber);
        }
    }

    public void displaySortedAccounts() {
        System.out.println("Accounts sorted by balance: " + sortedAccounts);
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();
        bank.createAccount(101, 5000.0);
        bank.createAccount(102, 3000.0);
        bank.createAccount(103, 7000.0);

        bank.displaySortedAccounts();
        bank.requestWithdrawal(101);
        bank.processWithdrawals();
    }
}
