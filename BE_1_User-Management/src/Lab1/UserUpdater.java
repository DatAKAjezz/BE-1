/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab1;

import java.util.*;
import java.util.regex.Pattern;

/**
 *
 * @author datdat
 */
public class UserUpdater {
    private static User currentUser; 

    public static boolean login(String username, String password,List<User> userList) {
        for (User user : userList  ) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                currentUser = user;
                return true;
            }
        }
        System.out.println("Wrong password or username!");
        return false;
    }

    public static void updateUser(String firstName, String lastName, String phone, String email) {
        if (currentUser != null) {
            if (!firstName.trim().isEmpty()) {
                currentUser.setFirstName(firstName);
            }
            if (!lastName.trim().isEmpty()) {
                currentUser.setLastName(lastName);
            }
            if (!phone.trim().isEmpty()) {
                currentUser.setPhone(phone);
            }
            if (!email.trim().isEmpty()) {
                currentUser.setEmail(email);
            }
            System.out.println("Update successful: " + currentUser.getUsername());
        } else {
            System.out.println("Please login first");
        }
    }
}