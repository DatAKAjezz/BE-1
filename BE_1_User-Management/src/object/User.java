/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

/**
 *
 * @author datdat
 */
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class User implements Serializable {

    private static Set<String> existingUsernames = new HashSet<>();

    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String confirmPassword;
    private String phone;
    private String email;

    public User(String username, String firstName, String lastName, String phone, String email) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.phone = phone;
        this.email = email;
    }

    public User(String username, String firstName, String lastName, String password, String confirmPassword, String phone, String email) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.phone = phone;
        this.email = email;
    }

    public String toString1() {
        return username + "|  " + firstName + "|  " + lastName
                + "| " + phone + "|  " + email;
    }

    @Override
    public String toString() {
        return "Username: " + username + ", First Name: " + firstName + ", Last Name: " + lastName
                + ", Phone: " + phone + ", Email: " + email;
    }

    private boolean validateUsername() {
        if (username.length() < 5 || username.contains(" ")) {
            System.out.println("Username must be at least five characters and contain no spaces.");
            return false;
        }
        for (User user : UserList.getUserList()) {
            if (user.getUsername().equals(username)) {
                System.out.println("Username already exists in the database.");
                return false;
            }
        }
        return true;
    }

    private boolean validatePassword() {
        if (password.length() < 6 || password.contains(" ")) {
            System.out.println("Password must be at least six characters and contain no spaces.");
            return false;
        }
        if (!password.equals(confirmPassword)) {
            System.out.println("Password and confirm password do not match.");
            return false;
        }
        return true;
    }

    private boolean validatePhone() {
        if (!Pattern.matches("\\d{10}", phone)) {
            System.out.println("The phone number must contain exactly 10 digits.");
            return false;
        }
        return true;
    }

    private boolean validateEmail() {
        if (!Pattern.matches("[^@]+@[^@]+\\.[^@]+", email)) {
            System.out.println("Email must follow standard format.");
            return false;
        }
        return true;
    }

    public boolean validateUser() {
        boolean c1 = validateUsername();
        boolean c2 = validatePhone();
        boolean c3 = validatePassword();
        boolean c4 = validateEmail();
        return c1 && c2 && c3 && c4;
    }

    public void createUser() {
        if (!validateUser()) {
            return;
        }
        UserList.getUserList().add(this);
        existingUsernames.add(username);
        System.out.println("[ALERT] The user has been created successfully!");
    }

    public static Set<String> getExistingUsernames() {
        return existingUsernames;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
    //Setters

    public static void setExistingUsernames(Set<String> existingUsernames) {
        User.existingUsernames = existingUsernames;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
