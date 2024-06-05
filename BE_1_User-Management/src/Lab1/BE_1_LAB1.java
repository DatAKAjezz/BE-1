package Lab1;

import java.util.*;
import java.io.*;

public class BE_1_LAB1{

    public static void printMenu(){

            System.out.println("_____________________MENU_____________________");
            System.out.println("----------------------------------------------");
            System.out.println("|  1   |   Create user account              |");
            System.out.println("----------------------------------------------");
            System.out.println("|  2   |   Check existing user              |");
            System.out.println("----------------------------------------------");
            System.out.println("|  3   |   Search user information by name  |");
            System.out.println("----------------------------------------------");
            System.out.println("|  4   |   Update/Delete user info          |");
            System.out.println("----------------------------------------------");
            System.out.println("|  5   |   Save to file                     |");
            System.out.println("----------------------------------------------");
            System.out.println("|  6   |   Print all list from file         |");
            System.out.println("----------------------------------------------");
            System.out.println("|  7   |   Exit                             |");
            System.out.println("----------------------------------------------");
            
    }
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean isValid;
        
        int choice;

        boolean kt = true;
        do{
            printMenu();
            System.out.print("Enter task number you want to do : ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    do{
                    System.out.print("Username: ");
                    String username = scanner.nextLine();
                    System.out.print("First Name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Last Name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Password: ");
                    String password = scanner.nextLine();
                    System.out.print("Confirm Password: ");
                    String confirmPassword = scanner.nextLine();
                    System.out.print("Phone: ");
                    String phone = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    User user = new User(username , firstName , lastName , password , confirmPassword , phone , email);
                    user.createUser();
                    //CREATE USERACCOUNT
                    System.out.print("Continue ? [Y/N] : ");
                    String ktt = scanner.nextLine();
                    if( ktt.equals("n") || ktt.equals("N")) break;
                    }while(true);
                    
                    break;
                case 2:
                    do{
                    System.out.println("Enter username you want to check: ");
                    String findUsername = scanner.nextLine();
                    UserChecker.checkExistUser(findUsername , User.getExistingUsernames());
                    System.out.print("Continue ? [Y/N] : ");
                    String ktt = scanner.nextLine();
                    if( ktt.equals("n") || ktt.equals("N")) break;
                    }while(true);
                    break; 
                case 3:
                    do{
                    System.out.println("Enter User's Name you want to search : ");
                    String searchString = scanner.nextLine();
                    UserSearch.searchUser(searchString);
                    System.out.print("Continue ? [Y/N] : ");
                    String ktt = scanner.nextLine();
                    if( ktt.equals("n") || ktt.equals("N")) break; 
                    }while(true);
                    break;
                case 4:
                    do{
                    System.out.print("Choose 1 out of 2 choices of task 4 : ");
                    int choice1 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("______________________LOGIN____________________");
                        System.out.print("Username : ");
                        String username1 = scanner.nextLine();
                        System.out.print("Passsword :");
                        String password1 = scanner.nextLine();
                    if (choice1 == 1){
                        if(UserUpdater.login(username1, password1, User.getUserList())){
                        
                            System.out.print("Enter update-First Name : ");String FN = scanner.nextLine();
                            System.out.print("Enter update-Last Name : ");String LN = scanner.nextLine();
                            System.out.print("Enter update-Phone Number : ");String PN = scanner.nextLine();
                            System.out.print("Enter update-Email : ");String EM = scanner.nextLine();
                        UserUpdater.updateUser(FN,LN, PN, EM);    
                        }
                    } 
                    else{
                      UserDeleter.login(username1, password1, User.getUserList());
                      UserDeleter.deleteUser(User.getUserList());
                    }
                    System.out.print("Continue ? [Y/N] : ");
                    String ktt = scanner.nextLine();
                    if( ktt.equals("n") || ktt.equals("N")) break;
                    }while(true);
                    break;
                case 5:
                    try {

                        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("user.dat"));

                        outputStream.writeObject(User.getUserList());
                        outputStream.close();

                        System.out.println("Data has been written to data.dat");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 6:
                    try {
                        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("user.dat"));

                        List<User> dataList = (List<User>) inputStream.readObject();
                        for (User data : dataList) {
                            System.out.println("---------------------------------------1"
                                    + "");
                            System.out.println(data.toString());
                        }
                        
                        inputStream.close();
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                default : break;
            }
            if ( choice > 6) {
                System.out.println("_________FINISHED!!!!_______");
                break;
                        
            }
        } while(kt);
        
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