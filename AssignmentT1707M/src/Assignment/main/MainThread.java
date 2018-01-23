/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment.main;

import Assignment.controller.StudentController;
import java.util.Scanner;

/**
 *
 * @author wLink
 */
public class MainThread {
    
    public static void main(String[] args) { 
       while(true){
        int choice;
           StudentController menu = new StudentController();
           Scanner scanner = new Scanner(System.in);
            System.out.println("===============Student Manager==============");
            System.out.println("1. Student list.");
            System.out.println("2. Add student.");
            System.out.println("3. Edit student.");
            System.out.println("4. Get student detail.");
            System.out.println("5. Delete student.");
            System.out.println("6. Exit.");
            System.out.println("Please enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1: 
                    menu.printStudentList();
                    break;
                case 2: 
                    menu.addStudent();
                    break;
                case 3: 
                    menu.editStudent();
                    break;
                case 4:
                    menu.getStudentDetail();
                    break;
                case 5: 
                    menu.deleteStudent();
                    break;
                case 6: 
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter choice from 1 to 5.");
                    break;
            }

            System.out.println("");
        }  
    }   
}
