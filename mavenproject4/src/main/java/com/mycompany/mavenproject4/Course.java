/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject4;

/**
 *
 * @author Client
 */
public class Course {
     public String name;
    public String code;
    public int semester;
    
    // define setters for the course properties
    public void setName(String name) {
        this.name = name;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public void setSemester(int semester) {
        this.semester = semester;
    }
    
    // define the method to encode the course
    public String encodeCourse() {
        String encodedCourse = "";
        encodedCourse += name.charAt(0);
        encodedCourse += name.charAt(name.length() - 1);
        encodedCourse += code.substring(2);
        encodedCourse += semester;
        return encodedCourse;
}
}