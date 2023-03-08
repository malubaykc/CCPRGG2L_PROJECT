/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject4;

/**
 *
 * @author khyle
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;
public class Student {
      public void enroll(){

         try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Client\\Downloads\\courses.txt"));
             Scanner scanner = new Scanner(System.in);
             FileWriter writer = new FileWriter("C:\\Users\\Client\\Downloads\\accounts.txt", true);
             PrintWriter printer = new PrintWriter(writer)) {

            // Displays all of the available courses encoded by the admin to the student
            System.out.println("Available courses:");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // ask's the student to select a course 
            System.out.print("Enter the name of the course you want to take: ");
            String course = scanner.nextLine();

            // requires the student to enter his username in order to find his account 
            System.out.print("Enter your username: ");
            String username = scanner.nextLine();

            // finds the student account line with the use of his usernasme 
            File accountsFile = new File("C:\\Users\\Client\\Downloads\\accounts.txt");
            BufferedReader accountsReader = new BufferedReader(new FileReader(accountsFile));
            String accountLine;
            StringBuilder newAccountsFile = new StringBuilder();
            boolean usernameFound = false;
            while ((accountLine = accountsReader.readLine()) != null) {
                String[] splitAccountLine = accountLine.split(",");
                if (splitAccountLine[0].equals(username)) {
                    // adds the selected course by student in the same line in his account in account.txt
                    accountLine += "," + course;
                    usernameFound = true;
                }
                newAccountsFile.append(accountLine).append("\n");
            }
            accountsReader.close();

            if (!usernameFound) {
                System.out.println("User not found.");
                return;
            }

            // updates the account file in account.txt
            FileWriter accountsWriter = new FileWriter(accountsFile);
            accountsWriter.write(newAccountsFile.toString());
            accountsWriter.close();

            System.out.println("Course " + course + " has been added to your account.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    }
      

