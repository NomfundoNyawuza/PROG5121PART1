/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.prog5121part1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author nomfu
 */
public class PROG5121PART1IT {
    
    public PROG5121PART1IT() {
    }

 // Test that the username is correctly formatted
    @Test
    public void testCheckUserNameCorrect() {

        Login user = new Login(
                "kyl_1",
                "Ch&&sec@ke99!",
                "+27838968976",
                "John",
                "Smith"
        );

        assertTrue(user.checkUserName());
    }

    // Test that the username is incorrectly formatted
    @Test
    public void testCheckUserNameIncorrect() {

        Login user = new Login(
                "kyle!!!!!!!",
                "Ch&&sec@ke99!",
                "+27838968976",
                "John",
                "Smith"
        );

        assertFalse(user.checkUserName());
    }

    // Test that the password meets the complexity requirements
    @Test
    public void testCheckPasswordComplexityCorrect() {

        Login user = new Login(
                "kyl_1",
                "Ch&&sec@ke99!",
                "+27838968976",
                "John",
                "Smith"
        );

        assertTrue(user.checkPasswordComplexity());
    }

    // Test that the password does not meet the complexity requirements
    @Test
    public void testCheckPasswordComplexityIncorrect() {

        Login user = new Login(
                "kyl_1",
                "password",
                "+27838968976",
                "John",
                "Smith"
        );

        assertFalse(user.checkPasswordComplexity());
    }

    // Test that the cellphone number is correctly formatted
    @Test
    public void testCheckCellPhoneNumberCorrect() {

        Login user = new Login(
                "kyl_1",
                "Ch&&sec@ke99!",
                "+27838968976",
                "John",
                "Smith"
        );

        assertTrue(user.checkCellPhoneNumber());
    }

    // Test that the cellphone number is incorrectly formatted
    @Test
    public void testCheckCellPhoneNumberIncorrect() {

        Login user = new Login(
                "kyl_1",
                "Ch&&sec@ke99!",
                "08966553",
                "John",
                "Smith"
        );

        assertFalse(user.checkCellPhoneNumber());
    }

    // Test that login is successful with the correct username and password
    @Test
    public void testLoginSuccessful() {

        Login user = new Login(
                "kyl_1",
                "Ch&&sec@ke99!",
                "+27838968976",
                "John",
                "Smith"
        );

        assertTrue(
                user.loginUser("kyl_1", "Ch&&sec@ke99!")
        );
    }

    // Test that login fails with incorrect username and password
    @Test
    public void testLoginFailed() {

        Login user = new Login(
                "kyl_1",
                "Ch&&sec@ke99!",
                "+27838968976",
                "John",
                "Smith"
        );

        assertFalse(
                user.loginUser("wrong", "wrong")
        );
    }
}
