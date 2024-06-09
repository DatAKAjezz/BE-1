/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

import object.User;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author datdat
 */
public class UserList {
    private static List<User> userList = new ArrayList<>();
    
    public void sortUsersByFirstName() {
        Collections.sort(userList, Comparator.comparing(user -> user.getFirstName()));
    }

    public static List<User> getUserList() {
        return userList;
    }
}
