package mini.project;

import java.util.HashMap;
import java.util.Scanner;

public class ATM {
    private HashMap<String, Account> accounts;
    private Scanner scanner;

    public ATM() {
        accounts = new HashMap<>();
        scanner = new Scanner(System.in);

        // Sample accounts
        accounts.put("1001", new Account("1001", 1234, 5000));
        accounts.put("1002", new Account("1002", 4321, 3000));
    }

    public void start() {
        System.out.println("===== ATM SYSTEM =====");

        System.out.print("Enter Account Number: ");
        String accNo = scanner.nextLine();

        System.out.print("Enter PIN: ");
        int pin = scanner.nextInt();

        Account acc = accounts.get(accNo);

        if (acc == null || !acc.validatePin(pin)) {
            System.out.println("Invalid credentials!");
            return;
        }

        System.out.println("Login successful!");

        int choice;
        do {
            System.out.println("\n1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.println("Balance: ₹" + acc.getBalance());
                        break;

                    case 2:
                        System.out.print("Enter amount: ");
                        double dep = scanner.nextDouble();
                        acc.deposit(dep);
                        System.out.println("Deposit successful!");
                        break;

                    case 3:
                        System.out.print("Enter amount: ");
                        double wd = scanner.nextDouble();
                        acc.withdraw(wd);
                        System.out.println("Withdrawal successful!");
                        break;

                    case 4:
                        acc.showTransactions();
                        break;

                    case 5:
                        System.out.println("Thank you!");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (choice != 5);
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.start();
    }
}
