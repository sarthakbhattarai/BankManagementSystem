package com.BankManagementSystem.Management;

import com.BankManagementSystem.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.Scanner;

@Component
public class BankManagementSystem {

    @Autowired
    private UserManagement userManagement;

    private static final String BANK_NAME = "SBI BANK";
    private Scanner scanner = new Scanner(System.in);

    @PostConstruct
    public void init() {
        run();
    }

    public void run() {
        while (true) {
            System.out.println("Welcome to " + BANK_NAME);
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    register();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void register() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter real name: ");
        String realName = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        boolean success = userManagement.registerUser(username, realName, password, accountNumber);
        if (success) {
            System.out.println("User registered successfully.");
        } else {
            System.out.println("Username already exists. Please choose a different username.");
        }
    }

    private void login() {
        System.out.println("The bank employee checking the data of User");
        System.out.println("Ask The User His/Her Username");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("Ask The User To Enter His/Her Password");
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User user = userManagement.loginUser(username, password);
        if (user != null) {
            userMenu(user);
        } else {
            System.out.println("Incorrect username or password.");
        }
    }

    private void userMenu(User user) {
        while (true) {
            System.out.println("Welcome " + user.getRealName());
            System.out.println("1. View Balance");
            System.out.println("2. Edit Amount");
            System.out.println("3. Delete Account");
            System.out.println("4. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Current Balance: " + user.getBalance());
                    break;
                case 2:
                    editAmount(user);
                    break;
                case 3:
                    deleteAccount(user);
                    return;
                case 4:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void editAmount(User user) {
        System.out.print("Enter amount to deposit (positive) or withdraw (negative): ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        double newBalance = user.getBalance() + amount;
        if (newBalance < 0) {
            System.out.println("Insufficient funds.");
        } else {
            user.setBalance(newBalance);
            System.out.println("Amount updated successfully. New Balance: " + newBalance);
        }
    }

    private void deleteAccount(User user) {
        boolean success = userManagement.deleteUser(user.getUsername());
        if (success) {
            System.out.println("Account deleted successfully.");
        } else {
            System.out.println("Failed to delete account.");
        }
    }
}
