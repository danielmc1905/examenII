/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam.service;

import exam.dao.StudentDAO;
import exam.orm.Student;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jdk.nashorn.internal.objects.Global;

/**
 *
 * @author Admin01
 */
public class StudentService {

    private StudentDAO studentDAO;

    public StudentService() {
        studentDAO = new StudentDAO();
    }

    public void saveStudent(Student student) {
        if (!isValidStudent(student)) {
            System.out.println("ERROR!");
            return;
        }
        studentDAO.addStudent(student);
        JOptionPane.showMessageDialog(null, "Student successfully added!");
        return;
    }

    public List<Student> getAllStudents() {
        return studentDAO.getStudentList();
    }

    public DefaultTableModel print() {
        return studentDAO.printStudents();
    }

    public boolean isValidStudent(Student student) {
        if (student == null) {
            JOptionPane.showMessageDialog(null, "Student is null");
            return false;
        }
        if (student.getId() == 0) {
            JOptionPane.showMessageDialog(null, "Student's id is required!");
            return false;
        }
        if(studentDAO.find(student.getId()) != null){
            JOptionPane.showMessageDialog(null, "Student already exists!");
            return false;
        }
        if (student.getName().equals("")) {
            JOptionPane.showMessageDialog(null, "Student's name is required!");
            return false;
        }
        if (student.getLastName().equals("")) {
            JOptionPane.showMessageDialog(null, "Student's last name is required!");
            return false;
        }
        if (student.getBirthDate().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Student's birth date is required!");
            return false;
        }
        if (student.getAge() == 0) {
            JOptionPane.showMessageDialog(null, "Student's age couldn't be calculated!");
            return false;
        }
        if (student.getEmail().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Student's email is required!");
            return false;
        }
        if (student.getPhone().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Student's phone is required!");
            return false;
        }
        if (student.getCareer().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Student's career is required!");
            return false;
        }
        if (student.getAddress().getStreet().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Student's street is required!");
            return false;
        }
        if (student.getAddress().getState().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Student's state is required!");
            return false;
        }
        if (student.getAddress().getCountry().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Student's country is required!");
            return false;
        }
        if (student.getGender().equals("")) {
            JOptionPane.showMessageDialog(null, "Student's gender is required!");
            return false;
        }
        return true;
    }

    public int calculateAge(int year) {
        Calendar calendar = Calendar.getInstance();
        int calendarYear = calendar.get(calendar.YEAR);
        return calendarYear -= year;
    }
}
