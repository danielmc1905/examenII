/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam.dao;

import exam.orm.Student;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin01
 */
public class StudentDAO implements Serializable {

    private ArrayList<Student> studentList;

    public StudentDAO() {
        if (studentList == null) {
            studentList = new ArrayList();
        }
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    /**
     * Adds a new student
     *
     * @param Student
     * @author Admin01
     */
    public void addStudent(Student student) {
        if (studentList.contains(student)) {
            return;
        } else {
            studentList.add(student);
        }
    }

    /**
     * Return the position in the list
     *
     * @param id
     * @author Admin01
     */
    public int position(int id) {
        for (Student student : studentList) {
            if (student.getId() == id) {
                return (studentList.indexOf(id));
            }
        }
        return -1;
    }

    /**
     * Removes a student by id
     *
     * @param id
     * @author Admin01
     */
    public boolean delete(int id) {
        int index = position(id);
        if (index != -1) {
            return false;
        }
        studentList.remove(index);
        return true;
    }

    /**
     * Updates a Student
     *
     * @param Student
     * @author Admin01
     */
    public Student update(Student updatedStudent) throws Exception {
        if (delete(updatedStudent.getId())) { // if delete return true, add the new student
            addStudent(updatedStudent);
        } else {
            throw new Exception(String.format("Student %s not found", updatedStudent));
        }
        return updatedStudent;
    }

    /**
     * Looks for a student
     *
     * @param id
     * @author Admin01
     */
    public Student find(int id) {
        for (Student student : studentList) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    /**
     * Prints all the students
     *
     * @author Admin01
     * @return
     */
    public DefaultTableModel printStudents() {
        DefaultTableModel model = new DefaultTableModel();
        String labels[] = {
            "ID", "NAME", "LAST NAME", "BIRTH DATE",
            "AGE", "GENDER", "EMAIL", "PHONE", "CAREER", "STREET",
            "STATE", "COUNTRY"};
        model.setColumnIdentifiers(labels);
        String row[] = new String[12];
        for (Student student : studentList) {
            row[0] = "" + student.getId();
            row[1] = student.getName();
            row[2] = student.getLastName();
            row[3] = student.getBirthDate();
            row[4] = "" + student.getAge();
            row[5] = "" + student.getGender();
            row[6] = student.getEmail();
            row[7] = student.getPhone();
            row[8] = student.getCareer();
            row[9] = student.getAddress().getStreet();
            row[10] = student.getAddress().getState();
            row[11] = student.getAddress().getCountry();
            model.addRow(row);
        }
        return model;
    }
}
