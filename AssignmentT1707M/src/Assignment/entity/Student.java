/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment.entity;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author wLink
 */
public class Student {
    private int id;
    private String rollNumber;
    private String name;
    private String phone;
    private String email;
    private int status;

    public Student(int id, String rollNumber, String name, String phone, String email, int status) {
        this.id = id;
        this.rollNumber = rollNumber;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.status = status;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    Scanner sc = new Scanner(System.in);
    
    public void inputId() {
        System.out.print("Please enter student's id you want: ");
        this.id = sc.nextInt();
        sc.nextLine();
    }
    
    public void inputRollNumber() {
        System.out.print("Please enter student's roll number(>7 characters): ");
        this.rollNumber = sc.nextLine(); 
        while (rollNumber.length() < 7) {
            System.err.println("Student's roll number must has at least 7 characters!");
            System.out.print("Please re-enter student's roll number: ");
            this.rollNumber = sc.nextLine(); 
        }
    }

    public void inputName() {
        System.out.print("Please enter student's Name: ");
        this.name = sc.nextLine();
        while (name.length() < 1) {
            System.err.println("Student's name can not be blank!");
            System.out.print("Please re-enter student's name: ");
            this.rollNumber = sc.nextLine(); 
        }
    }
   
    public void inputEmail() {
            System.out.print("Please enter student's Email: ");
            this.email = sc.nextLine(); 
            String regexStr = "^[(a-zA-Z-0-9-\\_\\+\\.)]+@[(a-z-A-z)]+\\.[(a-zA-z)]{2,3}$";
            Pattern pattern = Pattern.compile(regexStr);
            Matcher matcher = pattern.matcher(email);
            while (!matcher.matches()) {
                System.err.println("Invalid email!");
                System.out.print("Please re-enter student's email: ");
                this.email = sc.nextLine();
                matcher = pattern.matcher(email);
            }
    }

    public void inputPhone() {
            System.out.print("Please enter student's phone number: ");
            this.phone = sc.nextLine();
            String regexStr = "^\\+?[0-9. ()-]{10,12}$";
            Pattern pattern = Pattern.compile(regexStr);
            Matcher matcher = pattern.matcher(phone);
            while (!matcher.matches()) {
                System.err.println("Invalid phone number!");
                System.out.print("Please re-enter student's phone number: ");
                this.phone = sc.nextLine();
                matcher = pattern.matcher(phone);
            }
    }
}
