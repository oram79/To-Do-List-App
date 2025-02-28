package com.todo;

import java.util.Scanner;

public class Main {
    private static User[] users = new User[100];
    private static int userCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nTo-Do List Manager");
            System.out.println("1. Create User");
            System.out.println("2. Add Task");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. View all Tasks");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createUser(scanner);
                    break;
                case 2:
                    addTask(scanner);
                    break;
                case 3:
                    markTaskAsCompleted(scanner);
                    break;
                case 4:
                    viewTasks(scanner);
                    break;
                case 5:
                    System.out.println("Thank You");
                    break;
                default:
                    System.out.println("Invalid Choice. Please Try Again.");
            }
        } while (choice != 5);

        scanner.close();
    }

    // Method to create a new user
    private static void createUser(Scanner scanner) {
        if (userCount >= users.length) {
            System.out.println("Cannot Add  An User, Please Try Again Later");
            return;
        }

        System.out.print("Enter User's First Name: ");
        String fName = scanner.nextLine();
        System.out.print("Enter User's Last Name: ");
        String lName = scanner.nextLine();
        users[userCount++] = new User(fName, lName);
        System.out.println("User Created As: " + fName + " " + lName);
    }

    // Method to add a task to a user's to-do list
    private static void addTask(Scanner scanner) {
        User user = findUser(scanner);

        if (user != null) {
            System.out.print("Enter Task Description ");
            String description = scanner.nextLine();
            user.addTask(description);
            System.out.println("Task Added Successfully.");
        }
    }

    // Method to mark a task as completed
    private static void markTaskAsCompleted(Scanner scanner) {
        User user = findUser(scanner);

        if (user != null) {
            System.out.print("Enter Task Description To Mark As Completed: ");
            String description = scanner.nextLine();
            user.markTaskCompleted(description);
        }
    }

    // Method to view all tasks for a user
    private static void viewTasks(Scanner scanner) {
        User user = findUser(scanner);

        if (user != null) {
            user.printTasks();
        }
    }

    // Helper method to find a user by their name
    private static User findUser(Scanner scanner) {
        System.out.print("Enter User's First Name: ");
        String fName = scanner.nextLine();
        System.out.println("Enter User's Last Name: ");
        String lName = scanner.nextLine();

        for (int i = 0; i < userCount; i++) {
            if (users[i].getfName().equals(fName) && users[i].getlName().equals(lName)) {
                return users[i];
            }
        }

        System.out.println("User Not Found.");
        return null;
    }
}