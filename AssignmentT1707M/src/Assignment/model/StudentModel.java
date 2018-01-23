/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment.model;

import Assignment.entity.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author wLink
 */
public class StudentModel {

    /**
     * @param args the command line arguments
     * @return 
     */
    Connection connection = ConnectionHelper.getConnection();    
    
    public ArrayList<Student> getListStudent() {
        ArrayList<Student> listStudent = new ArrayList<>();
        if (connection == null) {
            System.err.println("Can not connect to database");
        }
        else {
            try {
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("SELECT*FROM students");
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String rollNumber = rs.getString("rollNumber");
                    String name = rs.getString("name");
                    String phone = rs.getString("phone");
                    String email = rs.getString("email");
                    int status = rs.getInt("status");
                    Student students = new Student(id, rollNumber, name, phone, email, status);
                    listStudent.add(students);
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        return listStudent;     
    }
    
    public boolean insertStudent(Student student) {
        if (connection == null) {
            System.err.println("Can not connect to database");
        }
        else {
            try {
                student.inputRollNumber();
                student.inputName();
                student.inputPhone();
                student.inputEmail();
                Statement statement = connection.createStatement();
                PreparedStatement stm = null;
                String sqlInsert = "INSERT INTO students(rollNumber, name, phone, email) VALUES (?,?,?,?)";
                stm = connection.prepareStatement(sqlInsert);
                stm.setString(1, student.getRollNumber());
                stm.setString(2, student.getName());
                stm.setString(3, student.getPhone());
                stm.setString(4, student.getEmail());
                stm.execute();
                System.out.println("==================Add student successfully!==================");
                }
            catch (SQLException e) {
                System.err.println(e.getMessage());
            } 
        }
        return false;
    }
    
    public boolean updateStudent(Student student) {
        if (connection == null) {
            System.err.println("Can not connect to database");
        }
        else {
            Scanner sc = new Scanner(System.in);
             try {
                 Statement statement = connection.createStatement();
                 studentDetail(student);
                 System.out.println("You sure want to edit this student? (1.Yes / 2.No): ");
                     int choice = sc.nextInt();
                     while (choice != 1 && choice != 2) {
                         System.out.println("Please re-enter your choice (1.Yes / 2.No):");
                         choice = sc.nextInt();
                     }
                     if (choice == 1) {
                         Student st = new Student();
                         st.inputRollNumber(); 
                         st.inputName();
                         st.inputPhone();
                         st.inputEmail();
                     PreparedStatement stm = null;
                     String sqlUpdate = "UPDATE students SET rollNumber= ?, name= ?, phone= ?, email= ? WHERE id= ?";
                     stm = connection.prepareStatement(sqlUpdate);
                     stm.setString(1, st.getRollNumber());
                     stm.setString(2, st.getName());
                     stm.setString(3, st.getPhone());
                     stm.setString(4, st.getEmail());
                     stm.setInt(5, student.getId());

                     stm.execute();
                     System.out.println("==================Edit student successfully!==================");
                     }
                     else {
                            System.out.println("Cancel statement.");
                            return false; 
                         }     
                 }
             catch (SQLException e) {
                 System.err.println(e.getMessage());
             }
        }
        return false;
    }
    
    public boolean deleteStudent(Student student) {
            Scanner sc = new Scanner(System.in);
            try {
                Statement statement = connection.createStatement();
                studentDetail(student);
                    System.out.println("You sure want to delete this student? (1.Yes / 2.No): ");
                    int choice = sc.nextInt();
                    while (choice != 1 && choice != 2) {
                        System.out.println("Please re-enter your choice (1.Yes / 2.No):");
                        choice = sc.nextInt();
                    }
                    if (choice == 1) {
                       statement.execute("DELETE FROM Students Where id=" + student.getId());
                       System.out.println("==================Delete student successfully!=================="); 
                    }
                    else {
                           System.out.println("Cancel statement.");
                           return false; 
                        } 
                }
            catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        
        return false;
    }
    
    public void studentDetail(Student student) {
        if (connection == null) {
            System.err.println("Can not connect to database");
        }
        else {
            ArrayList<Student> listStudent = new ArrayList<>();
            try {
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("SELECT*FROM students WHERE id=" + student.getId());
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String rollNumber = rs.getString("rollNumber");
                    String name = rs.getString("name");
                    String phone = rs.getString("phone");
                    String email = rs.getString("email");
                    int status = rs.getInt("status");
                    Student students = new Student(id, rollNumber, name, phone, email, status);
                    listStudent.add(students);
                }

                if (listStudent.isEmpty()) {
                    System.err.println("There isn't any student with this id!");
                }
                else {
                    System.out.println("=======================Student detail========================");
                    for (int i = 0; i < listStudent.size(); i++) {
                    Student students = listStudent.get(i);
                    System.out.println(students.getId()+"\t"+students.getRollNumber()+"\t"+students.getName()+"\t"+students.getPhone()+"\t"+students.getEmail());
                    System.out.println("=============================================================");
            }
                }
            }
            catch (SQLException e) {
                System.err.println(e.getMessage());
            }  
        }
    }
}
