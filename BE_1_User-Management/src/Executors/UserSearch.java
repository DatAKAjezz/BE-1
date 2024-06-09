/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Executors;

import object.UserList;
import object.User;
import java.util.*;
import java.util.regex.Pattern;
/**
 *
 * @author datdat
 */
public class UserSearch {
    static boolean kt = false;
    static List<User> result = new ArrayList<>();
    public static void searchUser(String searchString) {
        for (User user : UserList.getUserList()) {
            if (user.getFirstName().toLowerCase().contains(searchString.toLowerCase()) ||
                user.getLastName().toLowerCase().contains(searchString.toLowerCase())) {
                kt = true;
                result.add(user);
            }
        }
        if (kt) {
            for (User it : result){
                System.out.println(it.toString());
            }
            result.clear();
        } 
        else System.out.println("Have no any user");
       
    }
}
