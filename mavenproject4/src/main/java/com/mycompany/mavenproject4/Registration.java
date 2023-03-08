/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject4;

/**
 *
 * @author khyle
 */
import java.io.FileWriter;
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

    if (accountExists.equalsIgnoreCase("Y")) {

        String passwordfromTextFile = "";
        String accountTypeFromTextFile = "";

        System.out.println("Enter your username: ");
        String usernameinput = scan.next();
         boolean userFound = false; // to know if the user was found
        try {
            File myFile = new File("C:\\Users\\khyle\\OneDrive\\Documents\\accounts.txt");

            // Create an object from the Scanner class
            Scanner scan2 = new Scanner(myFile);
            // Reads the contents of the file
            while (scan2.hasNextLine()) {
                String data = scan2.nextLine();
                String[] split = data.split(",");

                String usernameFromFile = split[0];

                if (usernameFromFile.equals(usernameinput)) {
                    System.out.println(usernameinput + " exists!");
                    passwordfromTextFile = split[1];
                    accountTypeFromTextFile = split[2];
                     userFound = true; //true if the user was found
                    break;

                } 
                else {
                    System.out.println();
                }
            }
             if(!userFound) {
            System.out.println(usernameinput + " does not exist!");
            return; // Ends the method if the user was not found
             }
            String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
            

            while (true) {
                System.out.println("Enter your password: ");
                String passwordinput = scan.next();

                if (passwordfromTextFile.equals(passwordinput)) {
                    System.out.println("Login Successful");

                    if (accountTypeFromTextFile.equals("Y")) {
                        Student s = new Student();
                        s.enroll();
                    } else if (accountTypeFromTextFile.equals("N")) {
                        Faculty f = new Faculty();
                        f.encode();
                    }

                    break;
                } else if (!passwordinput.matches(passwordRegex)) {
                    System.out.println("Invalid password format. Please try again.");
                } else {
                    System.out.println("Incorrect Password. Please try again.");
                }
            }

            // Close scanner
            scan.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    } else if (accountExists.equalsIgnoreCase("N")) {
        register();
    }
}
    public void register() {
        Scanner scan = new Scanner(System.in);
    System.out.println("Enter your username: ");
    String username = scan.next();
    String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    while (true) {
             System.out.println("Password must have at least 8 characters");
             System.out.println("Password must contain at least 1 digit");
             System.out.println("Password must contain at least 1 lowercase character");
             System.out.println("Password must contain at least 1 uppercase character");
             System.out.println("Password must contain at least 1 special character");
        System.out.println("Enter your password: ");
        String password = scan.next();

        if (!password.matches(passwordRegex)) {
            System.out.println("Invalid password format. Please try again.");
        } else {
            try {
                FileWriter fileWriter = new FileWriter("C:\\Users\\khyle\\OneDrive\\Documents\\accounts.txt", true);
                //Registers the new account in account.txt
                fileWriter.write(username + "," + password + "," + "Y" + "\n");
                fileWriter.close();

                System.out.println("Account successfully created.");
                Registration r = new Registration();
                r.login();
                break;
            } catch (Exception e) {
                e.printStackTrace();
                
            }
        }
    }
    scan.close();
}
}