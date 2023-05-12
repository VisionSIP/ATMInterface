import java.util.Scanner;

public class ATM {

    private static double balance = 1000.00;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        login();
    }

    public static void login() {
        System.out.println("Welcome to the ATM!");
        System.out.println("Please enter your PIN: ");
        int pin = scanner.nextInt();

        if (validatePIN(pin)) {
            displayMenu();
        } else {
            System.out.println("Invalid PIN. Please try again.");
            login();
        }
    }

    public static void displayMenu() {
        System.out.println("\nPlease select an option:");
        System.out.println("1. Check balance");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Exit");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                checkBalance();
                break;
            case 2:
                withdraw();
                break;
            case 3:
                deposit();
                break;
            case 4:
                System.out.println("Thank you for using the ATM!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                displayMenu();
        }
    }

    public static boolean validatePIN(int pin) {
        return (pin == 1234); // Change to your desired PIN
    }

    public static void checkBalance() {
        System.out.println("Your current balance is $" + balance);
        displayMenu();
    }

    public static void withdraw() {
        System.out.println("Please enter the amount to withdraw: ");
        double amount = scanner.nextDouble();

        if (amount <= balance) {
            balance -= amount;
            System.out.println("Please take your cash.");
            checkBalance();
        } else {
            System.out.println("Insufficient funds. Please try again.");
            withdraw();
        }
    }

    public static void deposit() {
        System.out.println("Please enter the amount to deposit: ");
        double amount = scanner.nextDouble();

        balance += amount;
        System.out.println("Deposit successful.");
        checkBalance();
    }
}