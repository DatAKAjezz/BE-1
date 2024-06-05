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
public class UserChecker {
   
    public static boolean checkExistUser(String username , Set<String> usernames) {
        if (usernames.contains(username)) {
            System.out.println("Exist User");
            return true;
        } else {
            System.out.println("No User Found!");
            return false;
        }
    }
    
}

