/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.prog5121part1;
import java.util.Scanner;

/**
 *
 * @author nomfu
 */
public class PROG5121PART1 {

    public static void main(String[] args) {
        
   Scanner scanner = new Scanner(System.in);

        //Variables used to store the user's registration information
        String firstName = "";
        String lastName = "";
        String username = "";
        String password = "";
        String cellPhoneNumber = "";

        // Login object used to store the registered user's details
        Login user = null;

        // Keeps track of whether the user has successfully registered
        boolean registered = false;
        // Controls whether the program continues running
        boolean running = true;

        // Display the welcome message
        System.out.println("Welcome to the ChatApp!");
        
        while (running) {

            // Display the main menu
            System.out.println("\nPlease select an option:");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

             // Get the user's menu choice
            String choice = scanner.nextLine();

            switch (choice) {

                // Registration option
                case "1":

                    System.out.println("\nRegistration");

                     // Get the user's first name
                    System.out.print("Enter your first name: ");
                    firstName = scanner.nextLine();

                     // Get the user's last name
                    System.out.print("Enter your last name: ");
                    lastName = scanner.nextLine();

                     // Get the username
                    System.out.print("Enter your username: ");
                    username = scanner.nextLine();

                     // Get the password
                    System.out.print("Enter your password: ");
                    password = scanner.nextLine();

                     // Get the user's cellphone number
                    System.out.print("Enter your cellphone number: ");
                    cellPhoneNumber = scanner.nextLine();

                    user = new Login(username,password,cellPhoneNumber,firstName,lastName);

                     // Validate the registration information
                    String registrationMessage = user.registerUser();

                    System.out.println("\n" + registrationMessage);

                    // Check whether all registration requirements have been met
                    if (user.checkUserName()
                            && user.checkPasswordComplexity()
                            && user.checkCellPhoneNumber()) {

                        registered = true;

                        // After successful registration, give the user the option to login or exit
                        System.out.println("\nRegistration successful!");
                        System.out.println("Please select an option:");
                        System.out.println("1. Login");
                        System.out.println("2. Exit");
                        System.out.print("Enter your choice: ");

                        String registrationChoice = scanner.nextLine();

                         // Allow the registered user to login
                        if (registrationChoice.equals("1")) {

                            System.out.println("\nLogin");

                            // Ask the for the username
                            System.out.print("Enter your username: ");
                            String loginUsername = scanner.nextLine();

                            // Ask the for the username
                            System.out.print("Enter your password: ");
                            String loginPassword = scanner.nextLine();

                            // Check whether the login details are correct
                            boolean loginSuccessful = user.loginUser(loginUsername,loginPassword);

                            // Check whether the entered login details match the registered details
                            System.out.println(user.returnLoginStatus(loginSuccessful));

                            if (loginSuccessful) {
                                
                            running = false;
                            
                            }
                        } else if (registrationChoice.equals("2")) {

                            running = false;

                            System.out.println("\nThank you for using the ChatApp!");

                        } else {

                            System.out.println("\nInvalid option. Please select 1 or 2.");
                        }
                    }

                    break;

                case "2":

                    System.out.println("\nLogin");

                    if (!registered) {

                        System.out.println(
                                "You cannot login without registering first."
                        );

                    } else {

                        System.out.print("Enter your username: ");
                        String loginUsername = scanner.nextLine();

                        System.out.print("Enter your password: ");
                        String loginPassword = scanner.nextLine();

                        // Check whether the login details are correct
                        boolean loginSuccessful = user.loginUser(loginUsername,loginPassword);

                        // Display the login result
                        System.out.println(user.returnLoginStatus(loginSuccessful));
                    }

                    break;

                case "3":

                    // Stop the program
                    running = false;

                     // Display the exit message
                    System.out.println("\nThank you for using the ChatApp.");

                    break;

                // Handle an invalid menu choice
                default:

                    System.out.println("\nInvalid option. Please select 1, 2 or 3.");
            }
        }

         // Close the Scanner when the program ends
        scanner.close();
    }
}
