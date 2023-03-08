/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject4;

/**
 *
 * @author khyle
 */
import java.io.*;

public class Faculty extends Course {
    public void encode(){
 String filename = "courses.txt";
    boolean continueAddingCourses = true;

    try {
        FileWriter writer = new FileWriter("C:\\Users\\Client\\Downloads\\courses.txt", true); // modified to append to the file
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        while (continueAddingCourses) {
            // requires the admin to enter the name of the course 
            System.out.print("Enter the name of the course you want to encode (or 'quit' to exit): ");
            String courseName = reader.readLine();
            
            if (courseName.equalsIgnoreCase("quit")) {
                continueAddingCourses = false;
                break;
            }
            
            System.out.print("Enter the course code: ");
            String courseCode = reader.readLine();
                        
            System.out.print("Enter the semester: ");
            int semester = Integer.parseInt(reader.readLine());
            
            // create a Course object and set its properties
            Course course = new Course();
            course.setName(courseName);
            course.setCode(courseCode);
            course.setSemester(semester);
            
            // writes the course encoded by the admin to course.txt
            String encodedCourse = course.encodeCourse();
            writer.write(encodedCourse + "\n");
            
            System.out.println("Course added successfully.");                   
        }
        writer.close(); // modified to close the writer
        System.out.println("The course was encoded to " + filename);
    } catch (IOException e) {           
        System.out.println("An error occurred: " + e.getMessage());
}
    }
}

