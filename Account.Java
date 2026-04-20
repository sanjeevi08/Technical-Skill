package mini.project;
import java.util.ArrayList;
public class Account {
    private String accountNumber;
    private int pin;
    private double balance;
    private ArrayList<Transaction> transactions;
    public Account(String accountNumber, int pin, double balance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public boolean validatePin(int inputPin) {
        return this.pin == inputPin;
    }
    public double getBalance() {
        return balance;
    }
    public void deposit(double amount) throws Exception {
        if (amount <= 0) {
            throw new Exception("Invalid deposit amount!");
        }
        balance += amount;
        transactions.add(new Transaction("DEPOSIT", amount));
    }
    public void withdraw(double amount) throws Exception {
        if (amount <= 0) {
            throw new Exception("Invalid withdrawal amount!");
        }
        if (amount > balance) {
            throw new Exception("Insufficient balance!");
        }
        balance -= amount;
        transactions.add(new Transaction("WITHDRAW", amount));
    }
    public void showTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
            return;
        }
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }
}
