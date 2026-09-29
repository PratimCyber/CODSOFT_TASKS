import java.util.Scanner;
// Bank Account class
class BankAccount {
    private double balance;
    // Constructor
    BankAccount(double balance) {
        this.balance = balance;
    }
    // Deposit money
    void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Amount deposited successfully.");
        } else {
            System.out.println("Invalid amount.");
        }
    }
    // Withdraw money
    void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount.");
        }
        else if (amount > balance) {
            System.out.println("Insufficient balance.");
        }
        else {
            balance = balance - amount;
            System.out.println("Please collect your cash.");
        }
    }
    // Check balance
    void checkBalance() {
        System.out.println("Your balance is: Rs. " + balance);
    }
}
// ATM class
public class task_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Create bank account with initial balance
        BankAccount account = new BankAccount(10000);
        int choice;
        do {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    account.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
        sc.close();
    }
}