/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prog5121part1;

/**
 *
 * @author nomfu
 */
public class Login {
    
    private String username;
    private String password;
    private String cellPhoneNumber;
    private String firstName;
    private String lastName;

    public Login(String username, String password, String cellPhoneNumber,
                 String firstName, String lastName) {

        this.username = username;
        this.password = password;
        this.cellPhoneNumber = cellPhoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    // Checks whether the username contains an underscore and is no more than five characters long
    public boolean checkUserName() {

        return username.contains("_") && username.length() <= 5;
    }
    
    // Checks whether the password has at least eight characters,a capital letter, a number and a special character
    public boolean checkPasswordComplexity() {

        return password.length() >= 8
                && password.matches(".*[A-Z].*")
                && password.matches(".*[0-9].*")
                && password.matches(".*[^a-zA-Z0-9].*");
    }

    // Checks whether the cellphone number uses the South African international code +27 followed by nine digits
    public boolean checkCellPhoneNumber() {

        return cellPhoneNumber.matches("^\\+27[0-9]{9}$");
    }

    public String registerUser() {

        if (!checkUserName()) {

            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }

        if (!checkPasswordComplexity()) {

            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }

        if (!checkCellPhoneNumber()) {

            return "Cell phone number incorrectly formatted or does not contain international code.";
        }

        return "User has been registered successfully.";
    }

    public boolean loginUser(String username, String password) {

        return this.username.equals(username)
                && this.password.equals(password);
    }

    public String returnLoginStatus(boolean loginSuccessful) {

        if (loginSuccessful) {

            return "Welcome " + firstName + " " + lastName
                    + ", it is great to see you again.";

        } else {

            return "Username or password incorrect, please try again.";
        }
    }
}
