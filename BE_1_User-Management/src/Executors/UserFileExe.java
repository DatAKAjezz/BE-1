/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Executors;

import object.UserList;
import object.User;
import java.util.*;
import java.io.*;
/**
 *
 * @author datdat
 */
public class UserFileExe {
    private static final String FILE_NAME = "C:\\\\Users\\\\Admin\\\\Documents\\\\NetBeansProjects\\\\BE_1_User-Management\\\\src\\\\data\\\\data.txt";
    private static final List<User> u = new ArrayList<>();

    public static void SaveToFile() throws FileNotFoundException,IOException{
        File f = new File(FILE_NAME);
        FileWriter fw = new FileWriter(f);
        BufferedWriter bw = new BufferedWriter(fw);
        for (User it : UserList.getUserList()){
            bw.write(it.toString1() + "\n");
        }
        bw.close();
        fw.close();
    }
    
    public static void PrintFromFile() throws FileNotFoundException, IOException {

        File f = new File(FILE_NAME);
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        while(true){
            String line = br.readLine();    
            if( line == null) break;
            String[] info = line.split("[|]");
            String name = info[0].trim();
            String firstName = info[1].trim();
            String lastName = info[2].trim();
            String phone = info[3].trim();
            String email = info[4].trim();

            u.add(new User(name , firstName , lastName , phone , email));
        }
        br.close();
        fr.close();

    }
    public static void displayUserList(){
        if (u.isEmpty()){
            System.out.println("Nothing to display :<");
            return;
        }
        for (User it : u){
                System.out.println(it.toString1());
        }
        u.clear();
    }
}