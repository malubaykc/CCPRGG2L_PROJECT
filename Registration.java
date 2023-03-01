

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enrollmentsystem;

/**
 *
 * @author malubaykc
 */

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class Registration {
    
    String name;
    String password;
    String accountType;
    
    public void login(){
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Do you have an account? Y or N");
        String accountExists = scan.next();
        
        if(accountExists.equals("Y")){
            
            String passwordfromTextFile = "";
            String accountTypeFromTextFile = "";
            
            System.out.println("Enter your username: ");
            String usernameinput = scan.next();

            
            try {
            // Create an object from the File class
            File myFile = new File("C:\\Users\\malubaykc\\Documents\\accounts.txt");
                
            // Create an object from the Scanner class
            Scanner scan2 = new Scanner(myFile);
            // Read the content of the file
            while (scan2.hasNextLine()) {
                String data = scan2.nextLine();
                String[] split = data.split(",");
                
                String usernameFromFile = split[0];
                
                if(usernameFromFile.equals(usernameinput)){
                    System.out.println(usernameinput + "exists!");
                    passwordfromTextFile = split[1];
                    accountTypeFromTextFile = split[2];
                    break;
                }
                else{
                    System.out.println(usernameinput + "does not exist!");
                    return;
                }
            }

            System.out.println("Enter your password: ");
            String passwordinput = scan.next();
            
            if(passwordfromTextFile.equals(passwordinput)){
                System.out.println("Login Successful");
                
                if(accountTypeFromTextFile.equals("Y")){
                     Student s = new Student();
                     s.enroll();
                }
                else if(accountTypeFromTextFile.equals("N")){
                    Faculty f = new Faculty();
                    f.encode();
                }
               
            }
            else
            {
                System.out.println("Incorrect Password");
            }
            
            // Close scanner
            scan.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
 
        }
        else if (accountExists.equals("N")) {
            register();
        }
    }
    
    public void register(){
        try 
        {
            FileWriter myWriter = new FileWriter("C:\\Users\\malubaykc\\Documents\\accounts.txt", true);

            Scanner scan = new Scanner(System.in);
            
            System.out.println("Creating an account");
            System.out.println("Enter your name: ");
            String accountName = scan.next();
            myWriter.write(accountName + ",");

            System.out.println("Enter your password: ");
            String accountPassword = scan.next();
            myWriter.write(accountPassword + ",");

            System.out.println("Are you a student? Y or N");
            String isStudent = scan.next();
            myWriter.write(isStudent + "\n");
            
           // Close FileWriter
            myWriter.close();
            
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
  
    }
    
}
