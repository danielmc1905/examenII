/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam.service;

import exam.dao.StudentDAO;
import exam.orm.Student;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Admin01
 */
public class StudentService {

    private StudentDAO studentDAO;

    public StudentService() {
        studentDAO = new StudentDAO();
    }

    public Student saveStudent(Student student) {
        if (isValidStudent(student) != "") {
            JOptionPane.showMessageDialog(null, "ERROR!");
            return null;
        }
        studentDAO.addStudent(student);
        studentDAO.saveStudent();
        JOptionPane.showMessageDialog(null, "Student successfully added!");
        return student;
    }

    public String isValidStudent(Student student) {
        String error = "";
        if (student == null) {
            error = "Student is null";
            return error;
        }
        if (student.getId() == 0) {
            error = "Student's id is required!";
            return error;
        }
        if (student.getName().equals("")) {
            error = "Student's name is required!";
            return error;
        }
        if (student.getLastName().equals("")) {
            error = "Student's last name is required!";
            return error;
        }
        if (student.getBirthDate().trim().equals("")) {
            error = "Student's birth date is required!";
            return error;
        }
        if (student.getAge() == 0) {
            error = "Student's age couldn't be calculated!";
            return error;
        }
        if (student.getEmail().trim().equals("")) {
            error = "Student's email is required!";
            return error;
        }
        if (student.getPhone().trim().equals("")) {
            error = "Student's phone is required!";
            return error;
        }
        if (student.getCareer().trim().equals("")) {
            error = "Student's career is required!";
            return error;
        }
        if (student.getAddress().equals("")) {
            error = "Student's address is required!";
            return error;
        }
        if (student.getGender().equals("")) {
            error = "Student's gender is required!";
            return error;
        }
        return "";
    }

}
