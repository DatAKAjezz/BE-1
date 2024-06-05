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
public class UserFileHandler {
    private static final String FILE_NAME = "user.dat";

    public static void saveToFile() {

        try (FileOutputStream fileOut = new FileOutputStream(FILE_NAME);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
             for (User user : User.getUserList()) {
                objectOut.writeObject(user);
            }
            System.out.println("User data saved to " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Error saving user data: " + e.getMessage());
        }
    }

    public static void printFromFile() {
        List<User> users;
        try (FileInputStream fileIn = new FileInputStream(FILE_NAME);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            users = (List<User>) objectIn.readObject();
            Collections.sort(users, Comparator.comparing(user -> user.getFirstName()));//sxep
            for (User user : users) {
                System.out.println(user);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading user data: " + e.getMessage());
        }
    }
}