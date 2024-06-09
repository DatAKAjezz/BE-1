package Executors;

import object.UserList;
import object.User;
import java.util.*;
import java.io.*;
import Consoler.ConsoleLog;

public class main{

    
    public static int getChoiceInp(){
        int choice = -1;
        while ( choice == -1)
        try{
        System.out.print("Input task number you want to execute : " );
        Scanner scanner = new Scanner(System.in);
        choice = scanner.nextInt();
        return choice;
        } catch (Exception e){
            System.out.println("That is not a valid choice , TRY AGAIN !");
        }
        return 0;
    }
    public static boolean GoAhead(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Continue ? [Y/N] : ");
        String ktt = scanner.nextLine();
        if( !ktt.equals("y") && !ktt.equals("Y")) return false;
        return true;
    }
 
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

//        boolean isValid;
        
        int choice;

        boolean kt = true;
        try {
        do{
            ConsoleLog.printMenu();
            choice = getChoiceInp();
            switch (choice){
                case 1:
                    do{
                    System.out.print("Username [contain no space]: ");
                    String username = scanner.nextLine();
                    System.out.print("First Name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Last Name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Password [at least 6 character]: ");
                    String password = scanner.nextLine();
                    System.out.print("Confirm Password: ");
                    String confirmPassword = scanner.nextLine();
                    System.out.print("Phone [requires exact 10 numbers]: ");
                    String phone = scanner.nextLine();
                    System.out.print("Email [ex : \"user@example.com\"]: ");
                    String email = scanner.nextLine();
                    User user = new User(username , firstName , lastName , password , confirmPassword , phone , email);
                    user.createUser();
                    //CREATE USERACCOUNT
                    if (!GoAhead()) break;
                    }while(true);
                    
                    break;
                case 2:
                    do{
                    System.out.print("Enter username you want to check: ");
                    String findUsername = scanner.nextLine();
                    UserChecker.checkExistUser(findUsername , User.getExistingUsernames());
                    if (!GoAhead()) break;
                    }while(true);
                    break; 
                case 3:
                    do{
                    System.out.print("Enter User's Name [a part of first name or last name] : ");
                    String searchString = scanner.nextLine();
                    UserSearch.searchUser(searchString);
                    if (!GoAhead()) break;
                    }while(true);
                    break;
                case 4:
                    do{
                    System.out.println("1. Update User" + "\n" + "2. Delete User");
                    System.out.println("Choose 1 out of 2 choices of task 4 : ");int choice1 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("______________________LOGIN____________________");
                        System.out.print("Username : ");
                        String username1 = scanner.nextLine();
                        System.out.print("Passsword :");
                        String password1 = scanner.nextLine();
                    if (choice1 == 1){
                        if(UserUpdater.login(username1, password1, UserList.getUserList())){
                        
                            System.out.print("Updated-First Name : ");String FN = scanner.nextLine();
                            System.out.print("Updated-Last Name : ");String LN = scanner.nextLine();
                            System.out.print("Updated-Phone Number : ");String PN = scanner.nextLine();
                            System.out.print("Updated-Email : ");String EM = scanner.nextLine();
                        UserUpdater.updateUser(FN,LN, PN, EM);    
                        }
                    } 
//                    
                    else{
                      UserDeleter.login(username1, password1, UserList.getUserList());
                      UserDeleter.deleteUser(UserList.getUserList());
                    }
                    if (!GoAhead()) break;
                    }while(true);
                    break;
                case 5:
                    do{
                        UserFileExe.SaveToFile();
                        System.out.println("Users' data has been saved to File!");
                        if (!GoAhead()) break;
                    }while(true);
                    break;
//                
                case 6:
                    do{
                        UserFileExe.PrintFromFile();
                        System.out.println("User List from file : ");
                        UserFileExe.displayUserList();
                        if (!GoAhead()) break;
                    }while(true);
                    break;
                case -1 :
                    do{
                        System.out.println("_________USER_LIST_________");
                        if (!UserList.getUserList().isEmpty()) System.out.println("Nothing to display:(");
                        for (User it : UserList.getUserList()){
                            System.out.println(it.toString());
                        }
                        if (!GoAhead()) break;
                    }while(true);
                    break;
                default : break;
            }
            if ( choice > 6) {
                System.out.println("_________SEE YOU AGAIN!_______");
                break;         
            }
        } while(kt);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
            } catch (IOException e) {
            System.out.println("I/O error: " + e.getMessage());
        }
    }
    
}
//        User user = new User(username , firstName , lastName , password , confirmPassword , phone , email);
//        
//        if (user.createUser()){
//            System.out.println("Account is valid");
//            User.getUserList().add(user);
//        } else System.out.println("INVALID ACCOUNT");
//        
//        UserChecker.checkExistUser(user.getUsername() , User.getExistingUsernames());
//        
//        UserUpdater.login(username, password, User.getUserList());
//        UserUpdater.updateUser(firstName, lastName, phone, email);