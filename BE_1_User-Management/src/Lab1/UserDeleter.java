/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab1;

import java.util.*;
import java.io.*;
/**
 *
 * @author datdat
 */
public class UserDeleter {
    private static User currentUser; 

    public static void login(String username, String password , List<User> users) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                currentUser = user;
                return;
            }
        }
        System.out.println("Username does not exist");
    }

    public static void deleteUser(List<User> users) {
        if (currentUser != null) {
            users.remove(currentUser);
            System.out.println("Delete successful");
            currentUser = null; //xoaa
        } else {
            System.out.println("Please login first");
        }
    }
}