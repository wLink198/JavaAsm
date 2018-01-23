/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment.controller;

import Assignment.entity.Student;
import Assignment.model.StudentModel;
import java.util.ArrayList;

/**
 *
 * @author wLink
 */
public class StudentController {
    private final StudentModel model = new StudentModel();
    
    public void printStudentList(){
        ArrayList<Student> list = model.getListStudent();
        System.out.println("=======================Student list========================");
        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            System.out.println(student.getId()+"\t"+student.getRollNumber()+"\t"+student.getName()+"\t"+student.getPhone()+"\t"+student.getEmail());
        }
        System.out.println("===========================================================");
    }
    
    public void addStudent(){
        Student st = new Student();
        st.inputRollNumber();
        st.inputName();
        st.inputPhone();
        st.inputEmail();
        model.insertStudent(st); 
    }
    
    public void editStudent(){
        Student st = new Student();
        st.inputId();
        model.updateStudent(st);
    }
    
    public void getStudentDetail(){
        Student st = new Student();
         st.inputId();
         model.studentDetail(st);
    }
    
    public void deleteStudent(){
         Student st = new Student();
         st.inputId();
         model.deleteStudent(st);
    }   
}
